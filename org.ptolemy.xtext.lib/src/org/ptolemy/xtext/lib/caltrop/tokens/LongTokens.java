package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.LongToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class LongTokens extends Tokens<Long> {

	protected LongTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}

	@Override
	protected Long getValue(Token token) throws IllegalActionException {
		return get(token);
	}
	
	public long[] copyInto(long[] values) throws IllegalActionException {
		return copyInto(tokens, groupSize, offset, values);
	}

	//

	public static long get(Token token) throws IllegalActionException {
		return LongToken.convert(token).longValue();
	}
	
	public static long[] copyInto(Token[] tokens, int repeat, int offset, long[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}
