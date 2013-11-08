package org.ptolemy.xtext.examples.swing.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

public class DelegatingListModel<T> extends AbstractListModel implements ListModel {

	private List<T> delegate;
	
	public DelegatingListModel(List<T> delegate) {
		setDelegate(delegate);
	}

	public DelegatingListModel(Collection<T> elements) {
		setDelegate(new ArrayList<T>(elements));
	}
	
	public void setDelegate(List<T> delegate) {
		int oldSize = getSize(); 
		this.delegate = delegate;
		int newSize = getSize();
		if (newSize > oldSize) {
			fireIntervalAdded(this, oldSize, newSize - 1);
			fireContentsChanged(this, 0, oldSize - 1);
		} else if (newSize < oldSize) {
			fireIntervalRemoved(this, newSize, oldSize - 1);
			fireContentsChanged(this, 0, newSize - 1);
		} else {
			fireContentsChanged(this, 0, newSize - 1);
		}
	}

	public Object getElementAt(int index) {
		return (delegate != null && delegate.size() > index ? delegate.get(index) : null);
	}

	public int getSize() {
		return (delegate != null ? delegate.size() : 0);
	}
}
