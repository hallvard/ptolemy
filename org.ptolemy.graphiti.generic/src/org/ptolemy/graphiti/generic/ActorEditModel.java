package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface ActorEditModel extends ActorViewModel, NameEditModel {

	/**
	 * Creates (and adds) a new port with the provided name and of the provided kind (input, output, io), and
	 * adds it to the actor
	 * @param name
	 * @param portKind
	 * @return the newly created port
	 */
	public EObject createPort(PortKind portKind, String name, EObject actor);
	
	/**
	 * Sets the multi flag of the port 
	 * @param port
	 * @param multi
	 */
	public void setMultiPort(EObject port, boolean multi);
	
	/**
	 * Deletes the port
	 * @param port
	 */
	public void deletePort(EObject port);
}
