/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.ModelShape#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.graphiti.actordiagram.ActordiagramPackage#getModelShape()
 * @model
 * @generated
 */
public interface ModelShape<M> extends EObject {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see org.ptolemy.graphiti.actordiagram.ActordiagramPackage#getModelShape_Model()
	 * @model kind="reference" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	M getModel();

} // ModelShape
