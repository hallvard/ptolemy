package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.DoubleToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class DoubleTokens extends Tokens<Double> {
	
	protected DoubleTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}
	
	@Override
	protected Double getValue(Token token) throws IllegalActionException {
		return get(token);
	}
	
	public double[] copyInto(double[] values) throws IllegalActionException {
		return copyInto(tokens, groupSize, offset, values);
	}
	
	//

	public static double get(Token token) throws IllegalActionException {
		return DoubleToken.convert(token).doubleValue();
	}
	
	public static double[] copyInto(Token[] tokens, int repeat, int offset, double[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}