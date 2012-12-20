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
 * A representation of the model object '<em><b>Entity Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.EntityActorImpl#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getEntityActorImpl()
 * @model
 * @generated
 */
public interface EntityActorImpl<P extends AbstractIOPort> extends AbstractEntityActorImpl<P> {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' containment reference.
	 * @see #setEntity(Entity)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getEntityActorImpl_Entity()
	 * @model containment="true"
	 * @generated
	 */
	Entity<P> getEntity();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.EntityActorImpl#getEntity <em>Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' containment reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity<P> value);

} // EntityActorImpl
