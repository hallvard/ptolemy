package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class ObjectTokens<T> extends Tokens<T> {
	
	private Class<T> c;
	
	public ObjectTokens(Token[] tokens, int groupSize, int offset, Class<T> c) {
		super(tokens, groupSize, offset);
		this.c = c;
	}

	@Override
	protected T getValue(Token token) throws IllegalActionException {
		return get(token, c);
	}
	
	//

	public static <T> T get(Token token, Class<T> c) throws IllegalActionException {
		Object value = ObjectToken.convert(token).getValue();
		return c.isInstance(value) ? (T) value : null;
	}

	public static <T> T[] copyInto(Token[] tokens, int repeat, int offset, T[] values, Class<T> c) throws IllegalActionException {
		for (int i = 0; i < values.length; i++) {
			values[i] = get(tokens[i * repeat + offset], c);
		}
		return values;
	}
}
