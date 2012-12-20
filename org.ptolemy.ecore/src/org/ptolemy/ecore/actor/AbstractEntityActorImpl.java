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
 * A representation of the model object '<em><b>Abstract Entity Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getAbstractEntityActorImpl()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEntityActorImpl<P extends AbstractIOPort> extends AtomicActorImpl<P> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Entity<P> getEntity();

} // AbstractEntityActorImpl
