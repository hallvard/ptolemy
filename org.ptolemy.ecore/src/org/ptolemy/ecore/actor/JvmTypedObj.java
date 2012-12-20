/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.ptolemy.ecore.kernel.NamedObj;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Typed Obj</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.JvmTypedObj#getType <em>Type</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.JvmTypedObj#getInferredType <em>Inferred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getJvmTypedObj()
 * @model
 * @generated
 */
public interface JvmTypedObj extends NamedObj, Typeable {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmTypeReference)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getJvmTypedObj_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getType();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.JvmTypedObj#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inferred Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inferred Type</em>' reference.
	 * @see #setInferredType(JvmTypeReference)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getJvmTypedObj_InferredType()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	JvmTypeReference getInferredType();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.JvmTypedObj#getInferredType <em>Inferred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inferred Type</em>' reference.
	 * @see #getInferredType()
	 * @generated
	 */
	void setInferredType(JvmTypeReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	JvmTypeReference inferType();

} // JvmTypedObj
