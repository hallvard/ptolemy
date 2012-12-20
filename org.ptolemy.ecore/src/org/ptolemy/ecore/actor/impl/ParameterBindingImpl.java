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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.Parameter;
import org.ptolemy.ecore.actor.ParameterBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.ParameterBindingImpl#getParameterRef <em>Parameter Ref</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.impl.ParameterBindingImpl#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterBindingImpl extends EObjectImpl implements ParameterBinding {
	/**
	 * The cached value of the '{@link #getParameterRef() <em>Parameter Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterRef()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameterRef;

	/**
	 * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression valueExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.PARAMETER_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameterRef() {
		if (parameterRef != null && parameterRef.eIsProxy()) {
			InternalEObject oldParameterRef = (InternalEObject)parameterRef;
			parameterRef = (Parameter)eResolveProxy(oldParameterRef);
			if (parameterRef != oldParameterRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActorPackage.PARAMETER_BINDING__PARAMETER_REF, oldParameterRef, parameterRef));
			}
		}
		return parameterRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameterRef() {
		return parameterRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterRef(Parameter newParameterRef) {
		Parameter oldParameterRef = parameterRef;
		parameterRef = newParameterRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.PARAMETER_BINDING__PARAMETER_REF, oldParameterRef, parameterRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getValueExpression() {
		return valueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExpression(XExpression newValueExpression, NotificationChain msgs) {
		XExpression oldValueExpression = valueExpression;
		valueExpression = newValueExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueExpression(XExpression newValueExpression) {
		if (newValueExpression != valueExpression) {
			NotificationChain msgs = null;
			if (valueExpression != null)
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
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
			case ActorPackage.PARAMETER_BINDING__PARAMETER_REF:
				if (resolve) return getParameterRef();
				return basicGetParameterRef();
			case ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION:
				return getValueExpression();
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
			case ActorPackage.PARAMETER_BINDING__PARAMETER_REF:
				setParameterRef((Parameter)newValue);
				return;
			case ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION:
				setValueExpression((XExpression)newValue);
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
			case ActorPackage.PARAMETER_BINDING__PARAMETER_REF:
				setParameterRef((Parameter)null);
				return;
			case ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION:
				setValueExpression((XExpression)null);
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
			case ActorPackage.PARAMETER_BINDING__PARAMETER_REF:
				return parameterRef != null;
			case ActorPackage.PARAMETER_BINDING__VALUE_EXPRESSION:
				return valueExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterBindingImpl
