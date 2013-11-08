/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.impl.VariableImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.Realm;
import org.ptolemy.ecore.caltrop.StateVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.StateVariableImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.StateVariableImpl#isBinding <em>Binding</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.StateVariableImpl#getUpdateExpression <em>Update Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.StateVariableImpl#getRealm <em>Realm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateVariableImpl extends VariableImpl implements StateVariable {
	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected boolean constant = CONSTANT_EDEFAULT;

	/**
	 * The default value of the '{@link #isBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBinding()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BINDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBinding()
	 * @generated
	 * @ordered
	 */
	protected boolean binding = BINDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUpdateExpression() <em>Update Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdateExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression updateExpression;

	/**
	 * The cached value of the '{@link #getRealm() <em>Realm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealm()
	 * @generated
	 * @ordered
	 */
	protected Realm realm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.STATE_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstant() {
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstant(boolean newConstant) {
		boolean oldConstant = constant;
		constant = newConstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.STATE_VARIABLE__CONSTANT, oldConstant, constant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(boolean newBinding) {
		boolean oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.STATE_VARIABLE__BINDING, oldBinding, binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getUpdateExpression() {
		return updateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpdateExpression(XExpression newUpdateExpression, NotificationChain msgs) {
		XExpression oldUpdateExpression = updateExpression;
		updateExpression = newUpdateExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION, oldUpdateExpression, newUpdateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateExpression(XExpression newUpdateExpression) {
		if (newUpdateExpression != updateExpression) {
			NotificationChain msgs = null;
			if (updateExpression != null)
				msgs = ((InternalEObject)updateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION, null, msgs);
			if (newUpdateExpression != null)
				msgs = ((InternalEObject)newUpdateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION, null, msgs);
			msgs = basicSetUpdateExpression(newUpdateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION, newUpdateExpression, newUpdateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realm getRealm() {
		return realm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRealm(Realm newRealm, NotificationChain msgs) {
		Realm oldRealm = realm;
		realm = newRealm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.STATE_VARIABLE__REALM, oldRealm, newRealm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealm(Realm newRealm) {
		if (newRealm != realm) {
			NotificationChain msgs = null;
			if (realm != null)
				msgs = ((InternalEObject)realm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.STATE_VARIABLE__REALM, null, msgs);
			if (newRealm != null)
				msgs = ((InternalEObject)newRealm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.STATE_VARIABLE__REALM, null, msgs);
			msgs = basicSetRealm(newRealm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.STATE_VARIABLE__REALM, newRealm, newRealm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION:
				return basicSetUpdateExpression(null, msgs);
			case CaltropPackage.STATE_VARIABLE__REALM:
				return basicSetRealm(null, msgs);
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
			case CaltropPackage.STATE_VARIABLE__CONSTANT:
				return isConstant();
			case CaltropPackage.STATE_VARIABLE__BINDING:
				return isBinding();
			case CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION:
				return getUpdateExpression();
			case CaltropPackage.STATE_VARIABLE__REALM:
				return getRealm();
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
			case CaltropPackage.STATE_VARIABLE__CONSTANT:
				setConstant((Boolean)newValue);
				return;
			case CaltropPackage.STATE_VARIABLE__BINDING:
				setBinding((Boolean)newValue);
				return;
			case CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION:
				setUpdateExpression((XExpression)newValue);
				return;
			case CaltropPackage.STATE_VARIABLE__REALM:
				setRealm((Realm)newValue);
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
			case CaltropPackage.STATE_VARIABLE__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
				return;
			case CaltropPackage.STATE_VARIABLE__BINDING:
				setBinding(BINDING_EDEFAULT);
				return;
			case CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION:
				setUpdateExpression((XExpression)null);
				return;
			case CaltropPackage.STATE_VARIABLE__REALM:
				setRealm((Realm)null);
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
			case CaltropPackage.STATE_VARIABLE__CONSTANT:
				return constant != CONSTANT_EDEFAULT;
			case CaltropPackage.STATE_VARIABLE__BINDING:
				return binding != BINDING_EDEFAULT;
			case CaltropPackage.STATE_VARIABLE__UPDATE_EXPRESSION:
				return updateExpression != null;
			case CaltropPackage.STATE_VARIABLE__REALM:
				return realm != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (constant: ");
		result.append(constant);
		result.append(", binding: ");
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} //ActionVariableImpl
