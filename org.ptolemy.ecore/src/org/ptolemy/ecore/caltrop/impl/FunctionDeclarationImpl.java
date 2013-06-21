/**
 */
package org.ptolemy.ecore.caltrop.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.actor.impl.JvmTypedObjImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.FunctionDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.FunctionDeclarationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.FunctionDeclarationImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.FunctionDeclarationImpl#getThrowables <em>Throwables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDeclarationImpl extends JvmTypedObjImpl implements FunctionDeclaration {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypedObj> parameters;

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
	 * The cached value of the '{@link #getThrowables() <em>Throwables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowables()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> throwables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.FUNCTION_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypedObj> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<JvmTypedObj>(JvmTypedObj.class, this, CaltropPackage.FUNCTION_DECLARATION__PARAMETERS);
		}
		return parameters;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION, oldBodyExpression, newBodyExpression);
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
				msgs = ((InternalEObject)bodyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION, null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject)newBodyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION, null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION, newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getThrowables() {
		if (throwables == null) {
			throwables = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, CaltropPackage.FUNCTION_DECLARATION__THROWABLES);
		}
		return throwables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.FUNCTION_DECLARATION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION:
				return basicSetBodyExpression(null, msgs);
			case CaltropPackage.FUNCTION_DECLARATION__THROWABLES:
				return ((InternalEList<?>)getThrowables()).basicRemove(otherEnd, msgs);
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
			case CaltropPackage.FUNCTION_DECLARATION__PARAMETERS:
				return getParameters();
			case CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION:
				return getBodyExpression();
			case CaltropPackage.FUNCTION_DECLARATION__THROWABLES:
				return getThrowables();
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
			case CaltropPackage.FUNCTION_DECLARATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends JvmTypedObj>)newValue);
				return;
			case CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION:
				setBodyExpression((XExpression)newValue);
				return;
			case CaltropPackage.FUNCTION_DECLARATION__THROWABLES:
				getThrowables().clear();
				getThrowables().addAll((Collection<? extends JvmTypeReference>)newValue);
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
			case CaltropPackage.FUNCTION_DECLARATION__PARAMETERS:
				getParameters().clear();
				return;
			case CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION:
				setBodyExpression((XExpression)null);
				return;
			case CaltropPackage.FUNCTION_DECLARATION__THROWABLES:
				getThrowables().clear();
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
			case CaltropPackage.FUNCTION_DECLARATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CaltropPackage.FUNCTION_DECLARATION__BODY_EXPRESSION:
				return bodyExpression != null;
			case CaltropPackage.FUNCTION_DECLARATION__THROWABLES:
				return throwables != null && !throwables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionDeclarationImpl
