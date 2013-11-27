package org.ptolemy.xtext.lib.caltrop.tuple;

public class Tuple1<T1> extends Tuple0 {
	
	protected final T1 value1; 

	public Tuple1(T1 value1) {
		this.value1 = value1;
	}

	protected String toStringImpl() {
		return super.toStringImpl() + value1;
	}

	public T1 getValue1() {
		return value1;
	}
	
	public Object getValue(int i) {
		return (i == 1 ? getValue1() : super.getValue(i));
	}
}
