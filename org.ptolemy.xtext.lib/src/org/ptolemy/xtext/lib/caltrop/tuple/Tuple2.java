package org.ptolemy.xtext.lib.caltrop.tuple;

public class Tuple2<T1, T2> extends Tuple1<T1> {
			
	protected final T2 value2;

	public Tuple2(T1 value1, T2 value2) {
		super(value1);
		this.value2 = value2;
	}

	@Override
	public String toStringImpl() {
		return super.toStringImpl() + ", " + value2;
	}
	
	public T2 getValue2() {
		return value2;
	}

	public Object getValue(int i) {
		return (i == 2 ? getValue2() : super.getValue(i));
	}
}
