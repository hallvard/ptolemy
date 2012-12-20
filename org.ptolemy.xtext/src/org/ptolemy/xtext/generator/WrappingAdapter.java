package org.ptolemy.xtext.generator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class WrappingAdapter<T> extends AdapterImpl {
	
	private T wrapped;

	public WrappingAdapter(T wrapped) {
		super();
		this.wrapped = wrapped;
	}

	public void attach(Notifier notifier) {
		notifier.eAdapters().add(this);
	}
	
	public T getWrapped() {
		return wrapped;
	}

	public static <T> T getWrapped(Notifier notifier, Class<T> c) {
		for (Adapter adapter : notifier.eAdapters()) {
			if (adapter instanceof WrappingAdapter && c.isInstance(((WrappingAdapter) adapter).wrapped)) {
				return (T) ((WrappingAdapter) adapter).getWrapped();
			}
		}
		return null;
	}
}
