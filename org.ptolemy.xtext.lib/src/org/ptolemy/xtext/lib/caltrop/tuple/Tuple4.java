package org.ptolemy.xtext.lib.caltrop.tuple;

public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3>{
	
	protected final T4 value4;

	public Tuple4(T1 value1, T2 value2, T3 value3, T4 value4) {
		super(value1, value2, value3);
		this.value4 = value4;
	}

	@Override
	public String toStringImpl() {
		return super.toStringImpl() + ", " + value4;
	}
	
	public T4 getValue4() {
		return value4;
	}

	public Object getValue(int i) {
		return (i == 4 ? getValue4() : super.getValue(i));
	}
}
