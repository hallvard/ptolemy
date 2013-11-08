/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.xtext.xbase.XExpression;
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
 *   <li>{@link org.ptolemy.ecore.caltrop.StateVariable#isBinding <em>Binding</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.StateVariable#getUpdateExpression <em>Update Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.StateVariable#getRealm <em>Realm</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' attribute.
	 * @see #setBinding(boolean)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getStateVariable_Binding()
	 * @model
	 * @generated
	 */
	boolean isBinding();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.StateVariable#isBinding <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' attribute.
	 * @see #isBinding()
	 * @generated
	 */
	void setBinding(boolean value);

	/**
	 * Returns the value of the '<em><b>Update Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Expression</em>' containment reference.
	 * @see #setUpdateExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getStateVariable_UpdateExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getUpdateExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.StateVariable#getUpdateExpression <em>Update Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Expression</em>' containment reference.
	 * @see #getUpdateExpression()
	 * @generated
	 */
	void setUpdateExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Realm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realm</em>' containment reference.
	 * @see #setRealm(Realm)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getStateVariable_Realm()
	 * @model containment="true"
	 * @generated
	 */
	Realm getRealm();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.StateVariable#getRealm <em>Realm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realm</em>' containment reference.
	 * @see #getRealm()
	 * @generated
	 */
	void setRealm(Realm value);

} // ActionVariable
