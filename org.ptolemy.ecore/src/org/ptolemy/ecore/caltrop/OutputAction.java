/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.kernel.NamedObj;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.OutputAction#getGuardExpression <em>Guard Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.OutputAction#getOutputPatterns <em>Output Patterns</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.OutputAction#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.OutputAction#getUpdateExpression <em>Update Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.OutputAction#getDelayExpression <em>Delay Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputAction()
 * @model
 * @generated
 */
public interface OutputAction extends NamedObj {
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
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputAction_GuardExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getGuardExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.OutputAction#getGuardExpression <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Expression</em>' containment reference.
	 * @see #getGuardExpression()
	 * @generated
	 */
	void setGuardExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Output Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.OutputPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Patterns</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputAction_OutputPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputPattern> getOutputPatterns();

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputAction_BodyExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.OutputAction#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(XExpression value);

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
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputAction_UpdateExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getUpdateExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.OutputAction#getUpdateExpression <em>Update Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Expression</em>' containment reference.
	 * @see #getUpdateExpression()
	 * @generated
	 */
	void setUpdateExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Delay Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay Expression</em>' containment reference.
	 * @see #setDelayExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputAction_DelayExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDelayExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.OutputAction#getDelayExpression <em>Delay Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay Expression</em>' containment reference.
	 * @see #getDelayExpression()
	 * @generated
	 */
	void setDelayExpression(XExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<InputPattern> getInputPatterns();

} // OutputAction
