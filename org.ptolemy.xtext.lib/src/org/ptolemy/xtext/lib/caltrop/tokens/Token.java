package org.ptolemy.xtext.lib.caltrop.tokens;

public interface Token<T> {
	boolean has(int i);
	T[] get(int i);
}
