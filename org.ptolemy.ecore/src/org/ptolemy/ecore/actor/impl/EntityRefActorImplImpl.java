/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ptolemy.ecore.actor.AbstractEntityActorImpl;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.AtomicActorImpl;
import org.ptolemy.ecore.actor.EntityRefActorImpl;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.impl.EntityRefImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Ref Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.EntityRefActorImplImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityRefActorImplImpl<P extends AbstractIOPort> extends EntityRefImpl<P> implements EntityRefActorImpl<P> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityRefActorImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.ENTITY_REF_ACTOR_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public AtomicActor<P> getContainer() {
		if (eContainerFeatureID() != ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER) return null;
		return (AtomicActor<P>)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(AtomicActor<P> newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(AtomicActor<P> newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, ActorPackage.ATOMIC_ACTOR__IMPL, AtomicActor.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Entity<P> getEntity() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((AtomicActor<P>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				return basicSetContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				return eInternalContainer().eInverseRemove(this, ActorPackage.ATOMIC_ACTOR__IMPL, AtomicActor.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				return getContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				setContainer((AtomicActor<P>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				setContainer((AtomicActor<P>)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER:
				return getContainer() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AtomicActorImpl.class) {
			switch (derivedFeatureID) {
				case ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER: return ActorPackage.ATOMIC_ACTOR_IMPL__CONTAINER;
				default: return -1;
			}
		}
		if (baseClass == AbstractEntityActorImpl.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AtomicActorImpl.class) {
			switch (baseFeatureID) {
				case ActorPackage.ATOMIC_ACTOR_IMPL__CONTAINER: return ActorPackage.ENTITY_REF_ACTOR_IMPL__CONTAINER;
				default: return -1;
			}
		}
		if (baseClass == AbstractEntityActorImpl.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EntityRefActorImplImpl
