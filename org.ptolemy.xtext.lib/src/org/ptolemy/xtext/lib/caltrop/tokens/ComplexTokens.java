package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.ComplexToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class ComplexTokens extends Tokens<ptolemy.math.Complex> {
	
	protected ComplexTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}
	
	@Override
	protected ptolemy.math.Complex getValue(Token token) throws IllegalActionException {
		return get(token);
	}
	
	//

	public static ComplexToken create(ptolemy.math.Complex c) {
		return new ComplexToken(c);
	}

	public static ptolemy.math.Complex get(Token token) throws IllegalActionException {
		return ComplexToken.convert(token).complexValue();
	}
	
	public static ptolemy.math.Complex[] copyInto(Token[] tokens, int repeat, int offset, ptolemy.math.Complex[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}
