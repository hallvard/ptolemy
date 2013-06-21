package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface ConnectionContainerEditModel extends ConnectionContainerViewModel {

	/**
	 * Returns the actor container that will be the parent of a connection between the provided ports, or
	 * null if they cannot be connected
	 * @param sourcePort
	 * @param targetPort
	 * @return
	 */
	public EObject getConnectionContainer(EObject sourcePort, EObject targetPort);
	
	/**
	 * Creates (and adds) the a connection between the provided ports
	 * @param sourcePort
	 * @param targetPort
	 * @return
	 */
	public EObject createConnection(EObject sourcePort, EObject targetPort);
	
	/**
	 * Deletes the connection
	 * @param connection
	 */
	public void deleteConnection(EObject connection);
}
