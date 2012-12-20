package org.ptolemy.graphiti.editor;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.ptolemy.ecore.kernel.EntityContainer;

public class ActorDiagramLibraryProvider extends AdapterImpl {
	
	public EntityContainer<?> getLibraryContainer() {
		Notifier target = getTarget();
		if (target instanceof Resource) {
			for (EObject content : ((Resource) target).getContents()) {
				if (content instanceof EntityContainer<?>) {
					target = (EntityContainer<?>) content;
					break;
				}
			}
		}
		if (target instanceof EntityContainer<?>) {
			return (EntityContainer<?>) target;
		}
		return null;
	}
}
