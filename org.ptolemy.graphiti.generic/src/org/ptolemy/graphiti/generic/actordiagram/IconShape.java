/**
 */
package org.ptolemy.graphiti.generic.actordiagram;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.IconShape#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getIconShape()
 * @model
 * @generated
 */
public interface IconShape extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' reference.
	 * @see #setIcon(PlatformGraphicsAlgorithm)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getIconShape_Icon()
	 * @model
	 * @generated
	 */
	PlatformGraphicsAlgorithm getIcon();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.IconShape#getIcon <em>Icon</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' reference.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(PlatformGraphicsAlgorithm value);

} // IconShape
