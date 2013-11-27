package org.ptolemy.xtext.lib.caltrop.tuple;

public class Tuple0 {
		
	public Tuple0() {
	}

	protected String toStringImpl() {
		return "";
	}

	public final String toString() {
		return "<" + toStringImpl() + ">";
	}

	public Object getValue(int i) {
		throw new IndexOutOfBoundsException();
	}
}
