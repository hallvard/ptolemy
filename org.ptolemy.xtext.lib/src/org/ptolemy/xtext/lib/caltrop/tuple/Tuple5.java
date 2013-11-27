package org.ptolemy.xtext.lib.caltrop.tuple;

public class Tuple5<T1, T2, T3, T4, T5> extends Tuple4<T1, T2, T3, T4>{
		
	protected final T5 value5;

	public Tuple5(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
		super(value1, value2, value3, value4);
		this.value5 = value5;
	}

	@Override
	public String toStringImpl() {
		return super.toStringImpl() + ", " + value5;
	}
	
	public T5 getValue5() {
		return value5;
	}

	public Object getValue(int i) {
		return (i == 5 ? getValue5() : super.getValue(i));
	}
}
