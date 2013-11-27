package org.ptolemy.xtext.lib.caltrop.tuple;

public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {
	
	protected final T3 value3;

	public Tuple3(T1 value1, T2 value2, T3 value3) {
		super(value1, value2);
		this.value3 = value3;
	}

	@Override
	public String toStringImpl() {
		return super.toStringImpl() + ", " + value3;
	}
	
	public T3 getValue3() {
		return value3;
	}

	public Object getValue(int i) {
		return (i == 3 ? getValue3() : super.getValue(i));
	}
}
