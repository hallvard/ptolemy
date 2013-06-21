/**
 */
package org.ptolemy.ecore.actor;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.JavaActorImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getJavaActorImpl()
 * @model
 * @generated
 */
public interface JavaActorImpl extends AtomicActorImpl<AbstractIOPort> {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmParameterizedTypeReference)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getJavaActorImpl_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmParameterizedTypeReference getType();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.JavaActorImpl#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmParameterizedTypeReference value);

} // JavaActorImpl
