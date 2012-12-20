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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Channel Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.ExpressionChannelSelectorImpl#isMany <em>Many</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.ExpressionChannelSelectorImpl#getKeyExpressions <em>Key Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionChannelSelectorImpl extends ChannelSelectorImpl implements ExpressionChannelSelector {
	/**
	 * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANY_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected boolean many = MANY_EDEFAULT;
	/**
	 * The cached value of the '{@link #getKeyExpressions() <em>Key Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> keyExpressions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionChannelSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.EXPRESSION_CHANNEL_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMany() {
		return many;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMany(boolean newMany) {
		boolean oldMany = many;
		many = newMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__MANY, oldMany, many));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getKeyExpressions() {
		if (keyExpressions == null) {
			keyExpressions = new EObjectContainmentEList<XExpression>(XExpression.class, this, CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS);
		}
		return keyExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS:
				return ((InternalEList<?>)getKeyExpressions()).basicRemove(otherEnd, msgs);
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
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__MANY:
				return isMany();
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS:
				return getKeyExpressions();
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
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__MANY:
				setMany((Boolean)newValue);
				return;
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS:
				getKeyExpressions().clear();
				getKeyExpressions().addAll((Collection<? extends XExpression>)newValue);
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
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__MANY:
				setMany(MANY_EDEFAULT);
				return;
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS:
				getKeyExpressions().clear();
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
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__MANY:
				return many != MANY_EDEFAULT;
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS:
				return keyExpressions != null && !keyExpressions.isEmpty();
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
		result.append(" (many: ");
		result.append(many);
		result.append(')');
		return result.toString();
	}

} //ExpressionChannelSelectorImpl
