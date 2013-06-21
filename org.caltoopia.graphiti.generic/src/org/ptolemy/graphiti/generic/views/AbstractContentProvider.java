package org.ptolemy.graphiti.generic.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ConnectionContainerViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public abstract class AbstractContentProvider extends EContentAdapter implements ITreeContentProvider {

	protected TreeViewer viewer;
	
	private Notifier model = null;
	
	@Override
	public void dispose() {
		viewer = null;
		if (model != null) {
			removeAdapter(model);
		}
	}
	
	protected void refresh(final Object element) {
		viewer.getControl().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				viewer.refresh(element);
			}
		});
	}
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (viewer instanceof TreeViewer) {
			this.viewer = (TreeViewer) viewer;
		}
		if (oldInput instanceof Notifier) {
			removeAdapter((Notifier) oldInput);
		}
		model = null;
		if (newInput instanceof Notifier) {
			setTarget(model = (Notifier) newInput);
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Collection<Object> elements = new ArrayList<Object>();
		if (parentElement instanceof ResourceSet) {
			Iterables.addAll(elements, ((ResourceSet) parentElement).getResources());
		} else if (parentElement instanceof Resource) {
			Iterables.addAll(elements, ((Resource) parentElement).getContents());
		} else if (parentElement instanceof EObject) {
			addChildren((EObject) parentElement, elements);
		}
		return Iterables.toArray(elements, Object.class);
	}

	protected abstract void addChildren(EObject parentElement, Collection<Object> elements);
}
