/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.actor.AbstractEntityActorImpl;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.kernel.Entity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Entity Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractEntityActorImplImpl<P extends AbstractIOPort> extends AtomicActorImplImpl<P> implements AbstractEntityActorImpl<P> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractEntityActorImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.ABSTRACT_ENTITY_ACTOR_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity<P> getEntity() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //AbstractEntityActorImplImpl
