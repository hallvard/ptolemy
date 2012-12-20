/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.Variable#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends JvmTypedAttribute {
	/**
	 * Returns the value of the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression</em>' containment reference.
	 * @see #setValueExpression(XExpression)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getVariable_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValueExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.Variable#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(XExpression value);

} // Variable
