package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.FloatToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class FloatTokens extends Tokens<Float> {
	
	protected FloatTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}
	
	@Override
	protected Float getValue(Token token) throws IllegalActionException {
		return FloatToken.convert(token).floatValue();
	}
	
	public float[] copyInto(float[] values) throws IllegalActionException {
		return copyInto(tokens, groupSize, offset, values);
	}

	//

	public static FloatToken create(float f) {
		return new FloatToken(f);
	}

	public static float get(Token token) throws IllegalActionException {
		return FloatToken.convert(token).intValue();
	}
	
	public static float[] copyInto(Token[] tokens, int repeat, int offset, float[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}
