package org.ptolemy.xtext.lib.caltrop;

import java.util.ArrayList;
import java.util.List;

import ptolemy.actor.NoTokenException;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.Token;
import ptolemy.kernel.ComponentEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class CaltropIOPort extends TypedIOPort {

	public CaltropIOPort(ComponentEntity<?> container, String name, boolean isInput, boolean isOutput) throws IllegalActionException, NameDuplicationException {
		super(container, name, isInput, isOutput);
	}

	private static class TokenBuffer {
		Token[] buffer;
		int getPos, peekPos = 0, size = 0;

		void grow(int n) {
			if (buffer == null) {
				buffer = new Token[n]; 
			} else if (buffer.length < size + n) {
				Token[] newBuffer = new Token[size + n];
				System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
				buffer = newBuffer;
			}
		}
		void append(Token token) {
			grow(1);
			buffer[size++] = token;
		}
		void append(Token[] tokens) {
			grow(tokens.length);
			System.arraycopy(tokens, 0, buffer, size, tokens.length);
			size += tokens.length;
		}
		void rollbackGet() {
			size = peekPos;
			getPos = 0;
		}
		void commitGet() {
			System.arraycopy(buffer, getPos, buffer, 0, size - getPos);
			peekPos = size -= getPos;
			getPos = 0;
		}
	}

	private List<TokenBuffer> tokenBuffers; 
	
	@Override
	public boolean hasToken(int channelIndex) throws IllegalActionException {
		if (tokenBuffers == null || channelIndex >= tokenBuffers.size()) {
			return super.hasToken(channelIndex);
		} else {
			TokenBuffer tokenBuffer = tokenBuffers.get(channelIndex);
			int tokenBufferSize = tokenBuffer.size - tokenBuffer.getPos;
			return tokenBufferSize >= 1 || super.hasToken(channelIndex);
		}
	}

	@Override
	public boolean hasToken(int channelIndex, int tokens) throws IllegalActionException {
		if (tokenBuffers == null || channelIndex >= tokenBuffers.size()) {
			return super.hasToken(channelIndex, tokens);
		} else {
			TokenBuffer tokenBuffer = tokenBuffers.get(channelIndex);
			int tokenBufferSize = tokenBuffer.size - tokenBuffer.getPos;
			return tokenBufferSize >= tokens || super.hasToken(channelIndex, tokens - tokenBufferSize);
		}
	}
	
	protected TokenBuffer ensureTokenBuffer(int channelIndex) {
		if (tokenBuffers == null) {
			tokenBuffers = new ArrayList<TokenBuffer>(channelIndex + 1);
		}
		while (channelIndex >= tokenBuffers.size()) {
			tokenBuffers.add(new TokenBuffer());
		}
		return tokenBuffers.get(channelIndex);
	}
	
	@Override
	public Token get(int channelIndex) throws NoTokenException, IllegalActionException {
		TokenBuffer tokenBuffer = ensureTokenBuffer(channelIndex);
		if (tokenBuffer.size >= 1) {
			return tokenBuffer.buffer[tokenBuffer.getPos++];
		}
		Token token = super.get(channelIndex);
		tokenBuffer.append(token);
		tokenBuffer.getPos++;
		return token;
	}

	@Override
	public Token[] get(int channelIndex, int vectorLength) throws NoTokenException, IllegalActionException {
		TokenBuffer tokenBuffer = ensureTokenBuffer(channelIndex);
		if (tokenBuffer.size < vectorLength) {
			tokenBuffer.append(super.get(channelIndex, vectorLength - tokenBuffer.size));
		}
		Token[] tokens = new Token[vectorLength];
		System.arraycopy(tokenBuffer.buffer, tokenBuffer.getPos, tokens, 0, vectorLength);
		tokenBuffer.getPos += vectorLength;
		return tokens;
	}

	// fire() must rollback previous gets
	public void rollbackGet() {
		if (tokenBuffers != null) {
			for (TokenBuffer tokenBuffer : tokenBuffers) {
				tokenBuffer.rollbackGet();
			}
		}
	}
	
	// postfire() must commit gets
	public void commitGet() {
		if (tokenBuffers != null) {
			for (TokenBuffer tokenBuffer : tokenBuffers) {
				tokenBuffer.commitGet();
			}
		}
	}
}
