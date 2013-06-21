/**
 */
package org.ptolemy.graphiti.generic.actordiagram;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.graphiti.mm.algorithms.AbstractText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.LabelShape#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getLabelShape()
 * @model abstract="true"
 * @generated
 */
public interface LabelShape extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(AbstractText)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getLabelShape_Label()
	 * @model
	 * @generated
	 */
	AbstractText getLabel();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.LabelShape#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(AbstractText value);

} // LabelShape
