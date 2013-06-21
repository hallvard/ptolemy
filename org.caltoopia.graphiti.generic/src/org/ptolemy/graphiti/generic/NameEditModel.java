package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface NameEditModel extends NameViewModel {

	/**
	 * Sets the (simple) name of named to the provided name
	 * @param named
	 * @param name
	 * @return
	 */
	public String setName(EObject named, String name);
	
	/**
	 * Returns a unique name in this container, with the provided prefix
	 * @return
	 */
	public String getUniqueName(EObject namespace, String prefix);
}
