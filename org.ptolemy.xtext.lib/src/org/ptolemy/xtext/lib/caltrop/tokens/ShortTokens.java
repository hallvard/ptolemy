package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.ShortToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class ShortTokens extends Tokens<Short> {

	protected ShortTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}

	@Override
	protected Short getValue(Token token) throws IllegalActionException {
		return get(token);
	}
	
	public short[] copyInto(short[] values) throws IllegalActionException {
		return copyInto(tokens, groupSize, offset, values);
	}

	//

	public static ShortToken create(short s) {
		return new ShortToken(s);
	}

	public static short get(Token token) throws IllegalActionException {
		return ShortToken.convert(token).shortValue();
	}
	
	public static short[] copyInto(Token[] tokens, int repeat, int offset, short[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}
