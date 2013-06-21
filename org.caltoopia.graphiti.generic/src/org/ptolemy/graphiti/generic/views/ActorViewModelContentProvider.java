package org.ptolemy.graphiti.generic.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ConnectionContainerViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class ActorViewModelContentProvider extends AbstractContentProvider {

	@Inject
	private ActorViewModel actorViewModel;
	
	@Inject
	private ActorContainerViewModel actorContainerViewModel;
	
	@Inject
	private ConnectionContainerViewModel relationContainerViewModel;
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getNotifier() instanceof EObject) {
			EObject eObject = (EObject) notification.getNotifier();
			if (actorContainerViewModel.isEntity(eObject, EntityViewModel.EntityKind.ENTITY_NAMESPACE)) {
				viewer.refresh(eObject);
			} else if (actorViewModel.isEntity(eObject, EntityViewModel.EntityKind.ACTOR)) {
				viewer.update(eObject, null);
			}
		}
	}

	@Override
	protected void addChildren(EObject parent, Collection<Object> elements) {
		if (actorViewModel.isEntity(parent, EntityViewModel.EntityKind.ACTOR)) {
			Iterables.addAll(elements, actorViewModel.getPorts(parent));
		}
		if (actorContainerViewModel.isEntity(parent, EntityViewModel.EntityKind.ENTITY_NAMESPACE)) {
			Iterables.addAll(elements, actorContainerViewModel.getEntities(parent, (EntityViewModel.EntityKind) null));
		}
		if (actorContainerViewModel.isEntity(parent, EntityViewModel.EntityKind.COMPOSITE_ACTOR)) {
			Iterables.addAll(elements, relationContainerViewModel.getConnections(parent));
		}
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			if (actorContainerViewModel.isEntity(eObject, (EntityViewModel.EntityKind) null)) {
				return actorContainerViewModel.getNamespace(eObject);
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			return
				actorViewModel.isEntity(eObject, EntityViewModel.EntityKind.ACTOR) ||
				actorContainerViewModel.isEntity(eObject, EntityViewModel.EntityKind.ENTITY_NAMESPACE) ||
				actorContainerViewModel.isEntity(eObject, EntityViewModel.EntityKind.COMPOSITE_ACTOR);
		}
		return false;
	}
}
