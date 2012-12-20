package org.ptolemy.xtext.generator;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

public class IterableUtil {

	public <T> Iterable<T> operator_doubleGreaterThan(Iterable<T> unfiltered, Function1<? super T, Boolean> predicate) {
		return IterableExtensions.filter(unfiltered,predicate);
	}

	public <T> Iterable<T> operator_doubleGreaterThan(Iterable<?> unfiltered, Class<T> type) {
		return IterableExtensions.filter(unfiltered, type);
	}

	public <T, R> Iterable<R> operator_doubleArrow(Iterable<T> original, Function1<? super T, ? extends R> transformation) {
		return IterableExtensions.map(original, transformation);
	}
	
	public <T> T operator_doubleGreaterThan(Iterable<? extends T> iterable, Function2<? super T, ? super T, ? extends T> function) {
		return IterableExtensions.reduce(iterable, function);
	}
}
