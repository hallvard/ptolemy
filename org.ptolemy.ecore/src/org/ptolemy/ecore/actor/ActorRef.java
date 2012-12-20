/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.ptolemy.ecore.kernel.EntityRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.ActorRef#getParameterBindings <em>Parameter Bindings</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.ActorRef#getTypeArguments <em>Type Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getActorRef()
 * @model
 * @generated
 */
public interface ActorRef<P extends AbstractTypedIOPort> extends EntityRef<P> {
	/**
	 * Returns the value of the '<em><b>Parameter Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.actor.ParameterBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Bindings</em>' containment reference list.
	 * @see org.ptolemy.ecore.actor.ActorPackage#getActorRef_ParameterBindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterBinding> getParameterBindings();

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.ptolemy.ecore.actor.ActorPackage#getActorRef_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

} // ActorRef
