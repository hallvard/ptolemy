package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface EntityViewModel extends NameViewModel {

	public enum EntityKind {
		ACTOR, // has ports
		ACTOR_CONTAINER, // can contain actors

		ATOMIC_ACTOR, // actor & ! actorContainer
		COMPOSITE_ACTOR, // actor & actorContainer
		ENTITY_NAMESPACE // ! actor & actor container, and can contain other entity folder, i.e. a namespace
	}
	
	/**
	 * Determines if the eObject is an entity of the specified kind.
	 * If entityKind is null, just determines if eObject is an entity at all.
	 * @param eObject
	 * @param entityKind
	 * @return
	 */
	public boolean isEntity(EObject eObject, EntityKind entityKind);

}
