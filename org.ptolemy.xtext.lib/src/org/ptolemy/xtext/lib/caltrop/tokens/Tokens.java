package org.ptolemy.xtext.lib.caltrop.tokens;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

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
}
