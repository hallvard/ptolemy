/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.AtomicActorImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getAtomicActorImpl()
 * @model abstract="true"
 * @generated
 */
public interface AtomicActorImpl<P extends AbstractIOPort> extends EObject {

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.ptolemy.ecore.actor.AtomicActor#getImpl <em>Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(AtomicActor)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getAtomicActorImpl_Container()
	 * @see org.ptolemy.ecore.actor.AtomicActor#getImpl
	 * @model opposite="impl" transient="false"
	 * @generated
	 */
	AtomicActor<P> getContainer();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.AtomicActorImpl#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(AtomicActor<P> value);
} // AtomicActorImpl
