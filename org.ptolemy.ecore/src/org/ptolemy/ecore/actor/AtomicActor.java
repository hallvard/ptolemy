/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.ptolemy.ecore.kernel.Entity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.AtomicActor#getImpl <em>Impl</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.AtomicActor#getInheritedImpl <em>Inherited Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getAtomicActor()
 * @model
 * @generated
 */
public interface AtomicActor<P extends AbstractIOPort> extends Entity<P>, Actor<P> {

	/**
	 * Returns the value of the '<em><b>Impl</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.ptolemy.ecore.actor.AtomicActorImpl#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impl</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impl</em>' containment reference.
	 * @see #setImpl(AtomicActorImpl)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getAtomicActor_Impl()
	 * @see org.ptolemy.ecore.actor.AtomicActorImpl#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	AtomicActorImpl<P> getImpl();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.AtomicActor#getImpl <em>Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impl</em>' containment reference.
	 * @see #getImpl()
	 * @generated
	 */
	void setImpl(AtomicActorImpl<P> value);

	/**
	 * Returns the value of the '<em><b>Inherited Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Impl</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Impl</em>' containment reference.
	 * @see #setInheritedImpl(AtomicActorImpl)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getAtomicActor_InheritedImpl()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	AtomicActorImpl<P> getInheritedImpl();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.AtomicActor#getInheritedImpl <em>Inherited Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Impl</em>' containment reference.
	 * @see #getInheritedImpl()
	 * @generated
	 */
	void setInheritedImpl(AtomicActorImpl<P> value);
} // AtomicActor
