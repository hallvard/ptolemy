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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.actor.Typeable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Typed IO Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl#getInferredType <em>Inferred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractTypedIOPortImpl extends AbstractIOPortImpl implements AbstractTypedIOPort {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference type;

	/**
	 * The cached value of the '{@link #getInferredType() <em>Inferred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInferredType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference inferredType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTypedIOPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.ABSTRACT_TYPED_IO_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(JvmTypeReference newType, NotificationChain msgs) {
		JvmTypeReference oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(JvmTypeReference newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JvmTypeReference getInferredType() {
		if (inferredType != null && inferredType.eIsProxy()) {
			InternalEObject oldInferredType = (InternalEObject)inferredType;
			inferredType = (JvmTypeReference)eResolveProxy(oldInferredType);
			if (inferredType != oldInferredType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActorPackage.TYPED_IO_PORT__INFERRED_TYPE, oldInferredType, inferredType));
			}
		}
		return (inferredType != null ? inferredType : inferType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JvmTypeReference inferType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference basicGetInferredType() {
		return inferredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInferredType(JvmTypeReference newInferredType) {
		JvmTypeReference oldInferredType = inferredType;
		inferredType = newInferredType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE, oldInferredType, inferredType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE:
				return basicSetType(null, msgs);
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
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE:
				return getType();
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE:
				if (resolve) return getInferredType();
				return basicGetInferredType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE:
				setType((JvmTypeReference)newValue);
				return;
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE:
				setInferredType((JvmTypeReference)newValue);
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
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE:
				setType((JvmTypeReference)null);
				return;
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE:
				setInferredType((JvmTypeReference)null);
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
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE:
				return type != null;
			case ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE:
				return inferredType != null;
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
		if (baseClass == Typeable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == JvmTypedObj.class) {
			switch (derivedFeatureID) {
				case ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE: return ActorPackage.JVM_TYPED_OBJ__TYPE;
				case ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE: return ActorPackage.JVM_TYPED_OBJ__INFERRED_TYPE;
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
		if (baseClass == Typeable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == JvmTypedObj.class) {
			switch (baseFeatureID) {
				case ActorPackage.JVM_TYPED_OBJ__TYPE: return ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE;
				case ActorPackage.JVM_TYPED_OBJ__INFERRED_TYPE: return ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //AbstractTypedIOPortImpl
