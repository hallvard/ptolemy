/**
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#getVarRef <em>Var Ref</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#getName <em>Name</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#isProperty <em>Property</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#getTimeExpression <em>Time Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventPattern#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern()
 * @model
 * @generated
 */
public interface EventPattern extends ActionPattern {
	/**
	 * Returns the value of the '<em><b>Var Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Ref</em>' reference.
	 * @see #setVarRef(StateVariable)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_VarRef()
	 * @model
	 * @generated
	 */
	StateVariable getVarRef();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.EventPattern#getVarRef <em>Var Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Ref</em>' reference.
	 * @see #getVarRef()
	 * @generated
	 */
	void setVarRef(StateVariable value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.EventPattern#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see #setQualifier(String)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_Qualifier()
	 * @model
	 * @generated
	 */
	String getQualifier();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.EventPattern#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' attribute.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(String value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' attribute list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_Variables()
	 * @model
	 * @generated
	 */
	EList<String> getVariables();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(boolean)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_Property()
	 * @model
	 * @generated
	 */
	boolean isProperty();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.EventPattern#isProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #isProperty()
	 * @generated
	 */
	void setProperty(boolean value);

	/**
	 * Returns the value of the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Expression</em>' containment reference.
	 * @see #setTimeExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_TimeExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getTimeExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.EventPattern#getTimeExpression <em>Time Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Expression</em>' containment reference.
	 * @see #getTimeExpression()
	 * @generated
	 */
	void setTimeExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Expression</em>' containment reference.
	 * @see #setGuardExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventPattern_GuardExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getGuardExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.EventPattern#getGuardExpression <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Expression</em>' containment reference.
	 * @see #getGuardExpression()
	 * @generated
	 */
	void setGuardExpression(XExpression value);

} // EventPattern
