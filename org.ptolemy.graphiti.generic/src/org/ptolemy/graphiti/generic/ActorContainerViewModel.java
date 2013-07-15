package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface ActorContainerViewModel extends EntityViewModel {

	/**
	 * Returns the actors contained by the actor container. The entityKinds arguments control which entities to include,
	 * no arguments means return all.
	 * @param actorContainer
	 * @return
	 */
	public Iterable<? extends EObject> getEntities(EObject actorContainer, EntityKind... entityKinds);
}
