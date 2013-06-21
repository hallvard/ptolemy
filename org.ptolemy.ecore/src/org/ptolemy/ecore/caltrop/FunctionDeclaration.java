/**
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.JvmTypedObj;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.FunctionDeclaration#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.FunctionDeclaration#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.FunctionDeclaration#getThrowables <em>Throwables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getFunctionDeclaration()
 * @model
 * @generated
 */
public interface FunctionDeclaration extends JvmTypedObj {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.actor.JvmTypedObj}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getFunctionDeclaration_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypedObj> getParameters();

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
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getFunctionDeclaration_BodyExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.FunctionDeclaration#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Throwables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throwables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throwables</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getFunctionDeclaration_Throwables()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getThrowables();

} // FunctionDeclaration
