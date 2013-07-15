package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface NameViewModel {

	/**
	 * Returns the (simple) name of the eObject
	 * @param eObject
	 * @return
	 */
	public String getName(EObject eObject);

	/**
	 * Returns the owning eObject within which the name must be unique
	 * @return
	 */
	public EObject getNamespace(EObject eObject);

	/**
	 * Returns the qualified name of the eObject
	 * @param eObject
	 * @return
	 */
	public String getQualifiedEntityName(EObject eObject);
}
