/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.CompositeActor;
import org.ptolemy.ecore.kernel.impl.CompositeEntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CompositeActorImpl<P extends AbstractIOPort> extends CompositeEntityImpl<P> implements CompositeActor<P> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.COMPOSITE_ACTOR;
	}

} //CompositeActorImpl
