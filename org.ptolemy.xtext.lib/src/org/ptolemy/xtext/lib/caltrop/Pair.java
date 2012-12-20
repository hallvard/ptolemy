package org.ptolemy.xtext.lib.caltrop;

public interface Pair<T1, T2> {
	
	public T1 getKey();
	public T2 getValue();
	
	public static class Impl<T1, T2> implements Pair<T1, T2> {
		
		private final T1 key; 
		private final T2 value;

		public Impl(T1 key, T2 value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public T1 getKey() {
			return key;
		}

		@Override
		public T2 getValue() {
			return value;
		}
	}
}
