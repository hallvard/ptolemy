package org.ptolemy.xtext.lib.caltrop.tuple;

import java.util.Collection;
import java.util.Iterator;

public class Tuples {
	
	public static Tuple0 create() {
		return new Tuple0();
	}
	public static <T1> Tuple1<T1> create(T1 value1) {
		return new Tuple1<T1>(value1);
	}
	public static <T1,T2> Tuple2<T1,T2> create(T1 value1, T2 value2) {
		return new Tuple2<T1,T2>(value1, value2);
	}
	public static <T1,T2,T3> Tuple3<T1,T2,T3> create(T1 value1, T2 value2, T3 value3) {
		return new Tuple3<T1,T2,T3>(value1, value2, value3);
	}
	public static <T1,T2,T3,T4> Tuple4<T1,T2,T3,T4> create(T1 value1, T2 value2, T3 value3, T4 value4) {
		return new Tuple4<T1,T2,T3,T4>(value1, value2, value3, value4);
	}
	public static <T1,T2,T3,T4,T5> Tuple5<T1,T2,T3,T4,T5> create(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
		return new Tuple5<T1,T2,T3,T4,T5>(value1, value2, value3, value4, value5);
	}

	public static <T> Tuple0 create(T... values) {
		switch (values.length) {
		case 0: return create();
		case 1: return create(values[0]);
		case 2: return create(values[0], values[1]);
		case 3: return create(values[0], values[1], values[2]);
		case 4: return create(values[0], values[1], values[2], values[3]);
		case 5: return create(values[0], values[1], values[2], values[3], values[4]);
		default: throw new IllegalArgumentException("Only tuple sizes up to and including 5 is supported, but " + values.length + " values were provided");
		}
	}
	
	public static <T> Tuple0 create(Collection<T> values) {
		Iterator<T> it = values.iterator();
		switch (values.size()) {
		case 0: return create();
		case 1: return create(it.next());
		case 2: return create(it.next(), it.next());
		case 3: return create(it.next(), it.next(), it.next());
		case 4: return create(it.next(), it.next(), it.next(), it.next());
		case 5: return create(it.next(), it.next(), it.next(), it.next(), it.next());
		default: throw new IllegalArgumentException("Only tuple sizes up to and including 5 is supported, but " + values.size() + " values were provided");
		}
	}
}
