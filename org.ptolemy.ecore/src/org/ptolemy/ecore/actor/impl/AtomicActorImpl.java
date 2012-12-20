/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.EntityActorImpl;
import org.ptolemy.ecore.actor.EntityRefActorImpl;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AtomicActorImpl#getImpl <em>Impl</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AtomicActorImpl#getInheritedImpl <em>Inherited Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicActorImpl<P extends AbstractIOPort> extends EntityImpl<P> implements AtomicActor<P> {
	/**
	 * The cached value of the '{@link #getImpl() <em>Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpl()
	 * @generated
	 * @ordered
	 */
	protected org.ptolemy.ecore.actor.AtomicActorImpl<P> impl;

	/**
	 * The cached value of the '{@link #getInheritedImpl() <em>Inherited Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedImpl()
	 * @generated
	 * @ordered
	 */
	protected org.ptolemy.ecore.actor.AtomicActorImpl<P> inheritedImpl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.ATOMIC_ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.ptolemy.ecore.actor.AtomicActorImpl<P> getImpl() {
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImpl(org.ptolemy.ecore.actor.AtomicActorImpl<P> newImpl, NotificationChain msgs) {
		org.ptolemy.ecore.actor.AtomicActorImpl<P> oldImpl = impl;
		impl = newImpl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActorPackage.ATOMIC_ACTOR__IMPL, oldImpl, newImpl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpl(org.ptolemy.ecore.actor.AtomicActorImpl<P> newImpl) {
		if (newImpl != impl) {
			NotificationChain msgs = null;
			if (impl != null)
				msgs = ((InternalEObject)impl).eInverseRemove(this, ActorPackage.ATOMIC_ACTOR_IMPL__CONTAINER, org.ptolemy.ecore.actor.AtomicActorImpl.class, msgs);
			if (newImpl != null)
				msgs = ((InternalEObject)newImpl).eInverseAdd(this, ActorPackage.ATOMIC_ACTOR_IMPL__CONTAINER, org.ptolemy.ecore.actor.AtomicActorImpl.class, msgs);
			msgs = basicSetImpl(newImpl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ATOMIC_ACTOR__IMPL, newImpl, newImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.ptolemy.ecore.actor.AtomicActorImpl<P> getInheritedImpl() {
		return inheritedImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInheritedImpl(org.ptolemy.ecore.actor.AtomicActorImpl<P> newInheritedImpl, NotificationChain msgs) {
		org.ptolemy.ecore.actor.AtomicActorImpl<P> oldInheritedImpl = inheritedImpl;
		inheritedImpl = newInheritedImpl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL, oldInheritedImpl, newInheritedImpl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedImpl(org.ptolemy.ecore.actor.AtomicActorImpl<P> newInheritedImpl) {
		if (newInheritedImpl != inheritedImpl) {
			NotificationChain msgs = null;
			if (inheritedImpl != null)
				msgs = ((InternalEObject)inheritedImpl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL, null, msgs);
			if (newInheritedImpl != null)
				msgs = ((InternalEObject)newInheritedImpl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL, null, msgs);
			msgs = basicSetInheritedImpl(newInheritedImpl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL, newInheritedImpl, newInheritedImpl));
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
			case ActorPackage.ATOMIC_ACTOR__IMPL:
				if (impl != null)
					msgs = ((InternalEObject)impl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActorPackage.ATOMIC_ACTOR__IMPL, null, msgs);
				return basicSetImpl((org.ptolemy.ecore.actor.AtomicActorImpl<P>)otherEnd, msgs);
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
			case ActorPackage.ATOMIC_ACTOR__IMPL:
				return basicSetImpl(null, msgs);
			case ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL:
				return basicSetInheritedImpl(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActorPackage.ATOMIC_ACTOR__IMPL:
				return getImpl();
			case ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL:
				return getInheritedImpl();
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
			case ActorPackage.ATOMIC_ACTOR__IMPL:
				setImpl((org.ptolemy.ecore.actor.AtomicActorImpl<P>)newValue);
				return;
			case ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL:
				setInheritedImpl((org.ptolemy.ecore.actor.AtomicActorImpl<P>)newValue);
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
			case ActorPackage.ATOMIC_ACTOR__IMPL:
				setImpl((org.ptolemy.ecore.actor.AtomicActorImpl<P>)null);
				return;
			case ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL:
				setInheritedImpl((org.ptolemy.ecore.actor.AtomicActorImpl<P>)null);
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
			case ActorPackage.ATOMIC_ACTOR__IMPL:
				return impl != null;
			case ActorPackage.ATOMIC_ACTOR__INHERITED_IMPL:
				return inheritedImpl != null;
		}
		return super.eIsSet(featureID);
	}

	//
	
	@Override
	protected void inheritFeatures(Entity<?> superEntity, Copier copier) {
		super.inheritFeatures(superEntity, copier);
		if (superEntity instanceof AtomicActor) {
			setInheritedImpl((org.ptolemy.ecore.actor.AtomicActorImpl<P>) copier.copy(((AtomicActor) superEntity).getImpl()));
		}
	}
} //AtomicActorImpl
