/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityRefImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityRefImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityRefImpl#getResolved <em>Resolved</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityRefImpl<P extends Port> extends EObjectImpl implements EntityRef<P> {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Entity<P> ref;

	/**
	 * The cached value of the '{@link #getResolved() <em>Resolved</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolved()
	 * @generated
	 * @ordered
	 */
	protected Entity<P> resolved;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.ENTITY_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Entity<P> getOwner() {
		if (eContainerFeatureID() != KernelPackage.ENTITY_REF__OWNER) return null;
		return (Entity<P>)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Entity<P> newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, KernelPackage.ENTITY_REF__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Entity<P> newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != KernelPackage.ENTITY_REF__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, KernelPackage.ENTITY__SUPER_ENTITY, Entity.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ENTITY_REF__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Entity<P> getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (Entity<P>)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KernelPackage.ENTITY_REF__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity<P> basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRef(Entity<P> newRef) {
		Entity<P> oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ENTITY_REF__REF, oldRef, ref));
	}

	protected Entity<P> resolve() {
		EcoreUtil.Copier copier = createCopier(this);
		Entity<P> copy = (Entity<P>) copier.copy(getRef());
	    copier.copyReferences();
		return copy;
	}

	protected EntityCopier createCopier(EntityRef<?> entityRef) {
		return new EntityCopier(entityRef);
	}

	protected static class EntityCopier extends EcoreUtil.Copier {
		
		protected final EntityRef<?> entityRef;
		
		public EntityCopier(EntityRef<?> entityRef) {
			super();
			this.entityRef = entityRef;
		}

		@Override
		protected EObject createCopy(EObject eObject) {
			EObject copy = super.createCopy(eObject);
			if (eObject instanceof NamedObj && copy instanceof NamedObj) {
				((NamedObj) copy).setInheritsFrom((NamedObj) eObject);
			}
			return copy;
		}
		
		@Override
		protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
			// if we're copying a port of the top-level entity
			if (eObject instanceof Port && ((Port) eObject).getContainer() == entityRef.getRef()) {
				// don't copy top-level links
				if (eReference == KernelPackage.eINSTANCE.getRelation_SourcePort() ||
					eReference == KernelPackage.eINSTANCE.getRelation_TargetPorts()) {
					return;
				}
			}
			super.copyReference(eReference, eObject, copyEObject);
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean resolve(boolean force) {
		Entity<P> ref = getRef(); // will resolve
		if (ref != null && (resolved == null || force)) {
			setResolved(ref != null ? resolve() : null);
			if (getOwner() != null) {
				getOwner().entityResolved(eContainingFeature());
			}
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity<P> getResolved() {
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResolved(Entity<P> newResolved, NotificationChain msgs) {
		Entity<P> oldResolved = resolved;
		resolved = newResolved;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.ENTITY_REF__RESOLVED, oldResolved, newResolved);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolved(Entity<P> newResolved) {
		if (newResolved != resolved) {
			NotificationChain msgs = null;
			if (resolved != null)
				msgs = ((InternalEObject)resolved).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.ENTITY_REF__RESOLVED, null, msgs);
			if (newResolved != null)
				msgs = ((InternalEObject)newResolved).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KernelPackage.ENTITY_REF__RESOLVED, null, msgs);
			msgs = basicSetResolved(newResolved, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ENTITY_REF__RESOLVED, newResolved, newResolved));
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
			case KernelPackage.ENTITY_REF__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Entity<P>)otherEnd, msgs);
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
			case KernelPackage.ENTITY_REF__OWNER:
				return basicSetOwner(null, msgs);
			case KernelPackage.ENTITY_REF__RESOLVED:
				return basicSetResolved(null, msgs);
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
			case KernelPackage.ENTITY_REF__OWNER:
				return eInternalContainer().eInverseRemove(this, KernelPackage.ENTITY__SUPER_ENTITY, Entity.class, msgs);
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
			case KernelPackage.ENTITY_REF__OWNER:
				return getOwner();
			case KernelPackage.ENTITY_REF__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case KernelPackage.ENTITY_REF__RESOLVED:
				return getResolved();
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
			case KernelPackage.ENTITY_REF__OWNER:
				setOwner((Entity<P>)newValue);
				return;
			case KernelPackage.ENTITY_REF__REF:
				setRef((Entity<P>)newValue);
				return;
			case KernelPackage.ENTITY_REF__RESOLVED:
				setResolved((Entity<P>)newValue);
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
			case KernelPackage.ENTITY_REF__OWNER:
				setOwner((Entity<P>)null);
				return;
			case KernelPackage.ENTITY_REF__REF:
				setRef((Entity<P>)null);
				return;
			case KernelPackage.ENTITY_REF__RESOLVED:
				setResolved((Entity<P>)null);
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
			case KernelPackage.ENTITY_REF__OWNER:
				return getOwner() != null;
			case KernelPackage.ENTITY_REF__REF:
				return ref != null;
			case KernelPackage.ENTITY_REF__RESOLVED:
				return resolved != null;
		}
		return super.eIsSet(featureID);
	}

} //EntityRefImpl
