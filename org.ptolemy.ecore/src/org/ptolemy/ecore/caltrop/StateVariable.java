/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.ptolemy.ecore.actor.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.StateVariable#isConstant <em>Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getStateVariable()
 * @model
 * @generated
 */
public interface StateVariable extends Variable {
	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see #setConstant(boolean)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getStateVariable_Constant()
	 * @model
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.StateVariable#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

} // ActionVariable
