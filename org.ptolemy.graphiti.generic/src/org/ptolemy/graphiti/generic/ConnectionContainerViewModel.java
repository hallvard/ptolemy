package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface ConnectionContainerViewModel extends ActorViewModel {

	/**
	 * Returns the connections contained by the composite actor
	 * @param actorContainer
	 * @return
	 */
	public Iterable<? extends EObject> getConnections(EObject compositeActor);

	/**
	 * Returns the source actor of the connection
	 * @param connection
	 * @return
	 */
	public EObject getSourceActor(EObject connection);

	/**
	 * Returns the target actor of the connection
	 * @param connection
	 * @return
	 */
	public EObject getTargetActor(EObject connection);
	
	/**
	 * Returns the source port of the connection. Note that the source port need not be owned by the source entity, e.g if it is inherited. 
	 * @param connection
	 * @return
	 */
	public EObject getSourcePort(EObject connection);
	
	/**
	 * Returns the target port of the connection. Note that the target port need not be owned by the target entity, e.g if it is inherited.
	 * @param connection
	 * @return
	 */
	public EObject getTargetPort(EObject connection);
}
