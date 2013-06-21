/**
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ConversionRelation;

import org.ptolemy.ecore.kernel.impl.RelationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Converter Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.ConversionRelationImpl#getValueVar <em>Value Var</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.ConversionRelationImpl#getConversionExpression <em>Conversion Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.ConversionRelationImpl#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConversionRelationImpl extends RelationImpl implements ConversionRelation {
	/**
	 * The default value of the '{@link #getValueVar() <em>Value Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueVar()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_VAR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getValueVar() <em>Value Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueVar()
	 * @generated
	 * @ordered
	 */
	protected String valueVar = VALUE_VAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConversionExpression() <em>Conversion Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversionExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression conversionExpression;

	/**
	 * The cached value of the '{@link #getGuardExpression() <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression guardExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConversionRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.CONVERSION_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getConversionExpression() {
		return conversionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConversionExpression(XExpression newConversionExpression, NotificationChain msgs) {
		XExpression oldConversionExpression = conversionExpression;
		conversionExpression = newConversionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION, oldConversionExpression, newConversionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConversionExpression(XExpression newConversionExpression) {
		if (newConversionExpression != conversionExpression) {
			NotificationChain msgs = null;
			if (conversionExpression != null)
				msgs = ((InternalEObject)conversionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION, null, msgs);
			if (newConversionExpression != null)
				msgs = ((InternalEObject)newConversionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION, null, msgs);
			msgs = basicSetConversionExpression(newConversionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION, newConversionExpression, newConversionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getGuardExpression() {
		return guardExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardExpression(XExpression newGuardExpression, NotificationChain msgs) {
		XExpression oldGuardExpression = guardExpression;
		guardExpression = newGuardExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardExpression(XExpression newGuardExpression) {
		if (newGuardExpression != guardExpression) {
			NotificationChain msgs = null;
			if (guardExpression != null)
				msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION, null, msgs);
			if (newGuardExpression != null)
				msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION, null, msgs);
			msgs = basicSetGuardExpression(newGuardExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueVar() {
		return valueVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueVar(String newValueVar) {
		String oldValueVar = valueVar;
		valueVar = newValueVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.CONVERSION_RELATION__VALUE_VAR, oldValueVar, valueVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION:
				return basicSetConversionExpression(null, msgs);
			case CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION:
				return basicSetGuardExpression(null, msgs);
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
			case CaltropPackage.CONVERSION_RELATION__VALUE_VAR:
				return getValueVar();
			case CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION:
				return getConversionExpression();
			case CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION:
				return getGuardExpression();
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
			case CaltropPackage.CONVERSION_RELATION__VALUE_VAR:
				setValueVar((String)newValue);
				return;
			case CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION:
				setConversionExpression((XExpression)newValue);
				return;
			case CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION:
				setGuardExpression((XExpression)newValue);
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
			case CaltropPackage.CONVERSION_RELATION__VALUE_VAR:
				setValueVar(VALUE_VAR_EDEFAULT);
				return;
			case CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION:
				setConversionExpression((XExpression)null);
				return;
			case CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION:
				setGuardExpression((XExpression)null);
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
			case CaltropPackage.CONVERSION_RELATION__VALUE_VAR:
				return VALUE_VAR_EDEFAULT == null ? valueVar != null : !VALUE_VAR_EDEFAULT.equals(valueVar);
			case CaltropPackage.CONVERSION_RELATION__CONVERSION_EXPRESSION:
				return conversionExpression != null;
			case CaltropPackage.CONVERSION_RELATION__GUARD_EXPRESSION:
				return guardExpression != null;
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
		result.append(" (valueVar: ");
		result.append(valueVar);
		result.append(')');
		return result.toString();
	}

} //ConverterRelationImpl
