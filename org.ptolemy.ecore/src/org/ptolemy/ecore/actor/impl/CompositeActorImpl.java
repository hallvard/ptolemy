/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypesPackage;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.Actor;
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
