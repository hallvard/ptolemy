package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.BooleanToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class BooleanTokens extends Tokens<Boolean> {
	
	public BooleanTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}
	
	@Override
	protected Boolean getValue(Token token) throws IllegalActionException {
		return get(token);
	}

	public boolean[] copyInto(boolean[] values) throws IllegalActionException {
		return copyInto(tokens, groupSize, offset, values);
	}

	//

	public static BooleanToken create(boolean b) {
		return new BooleanToken(b);
	}
	
	public static boolean get(Token token) throws IllegalActionException {
		return BooleanToken.convert(token).booleanValue();
	}
	
	public static boolean[] copyInto(Token[] tokens, int repeat, int offset, boolean[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}
