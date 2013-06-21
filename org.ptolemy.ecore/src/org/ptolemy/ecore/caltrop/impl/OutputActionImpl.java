/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.InputPattern;
import org.ptolemy.ecore.caltrop.OutputAction;
import org.ptolemy.ecore.caltrop.OutputPattern;
import org.ptolemy.ecore.kernel.impl.NamedObjImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl#getGuardExpression <em>Guard Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl#getOutputPatterns <em>Output Patterns</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl#getUpdateExpression <em>Update Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl#getDelayExpression <em>Delay Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputActionImpl extends NamedObjImpl implements OutputAction {
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
	 * The cached value of the '{@link #getOutputPatterns() <em>Output Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputPattern> outputPatterns;

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression bodyExpression;

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
	 * The cached value of the '{@link #getDelayExpression() <em>Delay Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelayExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression delayExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.OUTPUT_ACTION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
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
				msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION, null, msgs);
			if (newGuardExpression != null)
				msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION, null, msgs);
			msgs = basicSetGuardExpression(newGuardExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputPattern> getOutputPatterns() {
		if (outputPatterns == null) {
			outputPatterns = new EObjectContainmentEList<OutputPattern>(OutputPattern.class, this, CaltropPackage.OUTPUT_ACTION__OUTPUT_PATTERNS);
		}
		return outputPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(XExpression newBodyExpression, NotificationChain msgs) {
		XExpression oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION, oldBodyExpression, newBodyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExpression(XExpression newBodyExpression) {
		if (newBodyExpression != bodyExpression) {
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject)bodyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION, null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject)newBodyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION, null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION, newBodyExpression, newBodyExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION, oldUpdateExpression, newUpdateExpression);
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
				msgs = ((InternalEObject)updateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION, null, msgs);
			if (newUpdateExpression != null)
				msgs = ((InternalEObject)newUpdateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION, null, msgs);
			msgs = basicSetUpdateExpression(newUpdateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION, newUpdateExpression, newUpdateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getDelayExpression() {
		return delayExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelayExpression(XExpression newDelayExpression, NotificationChain msgs) {
		XExpression oldDelayExpression = delayExpression;
		delayExpression = newDelayExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION, oldDelayExpression, newDelayExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelayExpression(XExpression newDelayExpression) {
		if (newDelayExpression != delayExpression) {
			NotificationChain msgs = null;
			if (delayExpression != null)
				msgs = ((InternalEObject)delayExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION, null, msgs);
			if (newDelayExpression != null)
				msgs = ((InternalEObject)newDelayExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION, null, msgs);
			msgs = basicSetDelayExpression(newDelayExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION, newDelayExpression, newDelayExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InputPattern> getInputPatterns() {
		return new BasicEList<InputPattern>();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION:
				return basicSetGuardExpression(null, msgs);
			case CaltropPackage.OUTPUT_ACTION__OUTPUT_PATTERNS:
				return ((InternalEList<?>)getOutputPatterns()).basicRemove(otherEnd, msgs);
			case CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION:
				return basicSetBodyExpression(null, msgs);
			case CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION:
				return basicSetUpdateExpression(null, msgs);
			case CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION:
				return basicSetDelayExpression(null, msgs);
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
			case CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION:
				return getGuardExpression();
			case CaltropPackage.OUTPUT_ACTION__OUTPUT_PATTERNS:
				return getOutputPatterns();
			case CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION:
				return getBodyExpression();
			case CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION:
				return getUpdateExpression();
			case CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION:
				return getDelayExpression();
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
			case CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION:
				setGuardExpression((XExpression)newValue);
				return;
			case CaltropPackage.OUTPUT_ACTION__OUTPUT_PATTERNS:
				getOutputPatterns().clear();
				getOutputPatterns().addAll((Collection<? extends OutputPattern>)newValue);
				return;
			case CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION:
				setBodyExpression((XExpression)newValue);
				return;
			case CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION:
				setUpdateExpression((XExpression)newValue);
				return;
			case CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION:
				setDelayExpression((XExpression)newValue);
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
			case CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION:
				setGuardExpression((XExpression)null);
				return;
			case CaltropPackage.OUTPUT_ACTION__OUTPUT_PATTERNS:
				getOutputPatterns().clear();
				return;
			case CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION:
				setBodyExpression((XExpression)null);
				return;
			case CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION:
				setUpdateExpression((XExpression)null);
				return;
			case CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION:
				setDelayExpression((XExpression)null);
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
			case CaltropPackage.OUTPUT_ACTION__GUARD_EXPRESSION:
				return guardExpression != null;
			case CaltropPackage.OUTPUT_ACTION__OUTPUT_PATTERNS:
				return outputPatterns != null && !outputPatterns.isEmpty();
			case CaltropPackage.OUTPUT_ACTION__BODY_EXPRESSION:
				return bodyExpression != null;
			case CaltropPackage.OUTPUT_ACTION__UPDATE_EXPRESSION:
				return updateExpression != null;
			case CaltropPackage.OUTPUT_ACTION__DELAY_EXPRESSION:
				return delayExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //OutputActionImpl
