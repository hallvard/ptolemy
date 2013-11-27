package org.ptolemy.xtext.lib.caltrop.tokens;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ptolemy.data.BooleanToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.math.Complex;

public abstract class Tokens<T> implements Iterable<T> {

	protected final Token[] tokens;
	protected int groupSize, offset;
	
	protected Tokens(Token[] tokens, int groupSize, int offset) {
		this.tokens = tokens;
		this.groupSize = groupSize;
		this.offset = offset;
	}

	protected abstract T getValue(Token token) throws IllegalActionException;

	public int size() {
		return tokens.length / groupSize;
	}

	private int pos(int i) {
		return i * groupSize + offset; 
	}

	public T get(int i) throws IllegalActionException {
		return getValue(tokens[pos(i)]);
	}
	
	public T[] copyInto(T[] values) throws IllegalActionException {
		for (int i = 0; i < size(); i++) {
			values[i] = get(i * groupSize + offset);
		}
		return values;
	}

	public Iterator<T> iterator() {
		return new TokensIterator();
	}
	
	private class TokensIterator implements Iterator<T> {

		private int i = 0;
		
		@Override
		public boolean hasNext() {
			try {
				get(i);
				return pos(i) < tokens.length;
			} catch (IllegalActionException e) {
				return false;
			}
		}
	
		@Override
		public T next() {
			try {
				return getValue(tokens[pos(i++)]);
			} catch (IllegalActionException e) {
				throw new NoSuchElementException(e.getMessage());
			}
		}
	
		@Override
		public void remove() {
			throw new UnsupportedOperationException(this.getClass() + " does not support remove");
		}
	}
	
	public static Token create(boolean b) 	{ return BooleanTokens.create(b); }
	public static Token create(int i) 		{ return IntTokens.create(i); }
	public static Token create(short s) 	{ return ShortTokens.create(s); }
	public static Token create(long l)		{ return LongTokens.create(l); }
	public static Token create(double d) 	{ return DoubleTokens.create(d); }
	public static Token create(float f) 	{ return FloatTokens.create(f); }
	public static Token create(Complex c) 	{ return ComplexTokens.create(c); }
	public static Token create(String s) 	{ return BooleanTokens.create(s); }
}
