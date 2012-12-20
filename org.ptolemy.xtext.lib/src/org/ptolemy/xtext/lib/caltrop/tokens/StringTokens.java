package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class StringTokens extends Tokens<String> {
	
	protected StringTokens(Token[] tokens, int groupSize, int offset) {
		super(tokens, groupSize, offset);
	}
	
	@Override
	protected String getValue(Token token) throws IllegalActionException {
		return get(token);
	}

	//

	public static String get(Token token) throws IllegalActionException {
		return StringToken.convert(token).stringValue();
	}
	
	public static String[] copyInto(Token[] tokens, int repeat, int offset, String[] values) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset]);
		}
		return values;
	}
}