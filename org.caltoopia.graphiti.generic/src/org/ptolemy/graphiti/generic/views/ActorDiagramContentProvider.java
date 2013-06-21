package org.ptolemy.graphiti.generic.views;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import com.google.common.collect.Iterables;

public class ActorDiagramContentProvider extends AbstractContentProvider {

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getNotifier() instanceof PictogramElement) {
			EObject pe = (EObject) notification.getNotifier();
			while (pe != null) {
				if (pe instanceof Shape) {
					refresh(pe);
					break;
				}
				pe = pe.eContainer();
			}
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	protected void addChildren(EObject parent, Collection<Object> elements) {
		if (parent instanceof ContainerShape) {
			Iterables.addAll(elements, ((ContainerShape) parent).getChildren());
		}
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof Shape) {
			return ((Shape) element).getContainer();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof ContainerShape;
	}
}
