package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class IntTokens extends Tokens<Integer> {

	public IntTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}

	@Override
	protected Integer getValue(Token token) throws IllegalActionException {
		return get(token);
	}

	public int[] copyInto(int[] values) throws IllegalActionException {
		return copyInto(tokens, groupSize, offset, values);
	}

	//

	public static int get(Token token) throws IllegalActionException {
		return IntToken.convert(token).intValue();
	}
	
	public static int[] copyInto(Token[] tokens, int groupSize, int offset, int[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * groupSize + offset]);
		}
		return values;
	}
}
