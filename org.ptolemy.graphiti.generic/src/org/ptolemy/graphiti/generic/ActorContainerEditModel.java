package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface ActorContainerEditModel extends ActorContainerViewModel, NameEditModel {

	/**
	 * Creates a new entity (actor and/or container) of the specified kind, with the suggested name, and
	 * adds it to the provided container
	 * @param name
	 * @param
	 * @return the new actor
	 */
	public EObject createEntity(EntityKind entityKind, String name, EObject actorContainer);

	/**
	 * Creates a new actor that is an instance of an existing actor with the suggested name, and
	 * adds it to the provided actor container
	 * @param name
	 * @param actor
	 * @return
	 */
	public EObject createActorInstance(EObject actor, String name, EObject actorContainer);
	
	/**
	 * Deletes the entity
	 * @param entity
	 */
	public void deleteEntity(EObject entity);

	/**
	 * Creates the root container with the provided name
	 * @param name
	 * @return
	 */
	public EObject createModelRoot(String name);
}
