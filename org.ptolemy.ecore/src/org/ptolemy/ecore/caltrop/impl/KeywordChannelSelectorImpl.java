/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ChannelSelectorKeyword;
import org.ptolemy.ecore.caltrop.KeywordChannelSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Keyword Channel Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.KeywordChannelSelectorImpl#getKeyword <em>Keyword</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeywordChannelSelectorImpl extends ChannelSelectorImpl implements KeywordChannelSelector {
	/**
	 * The default value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final ChannelSelectorKeyword KEYWORD_EDEFAULT = ChannelSelectorKeyword.ALL;

	/**
	 * The cached value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
	protected ChannelSelectorKeyword keyword = KEYWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeywordChannelSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.KEYWORD_CHANNEL_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelSelectorKeyword getKeyword() {
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyword(ChannelSelectorKeyword newKeyword) {
		ChannelSelectorKeyword oldKeyword = keyword;
		keyword = newKeyword == null ? KEYWORD_EDEFAULT : newKeyword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.KEYWORD_CHANNEL_SELECTOR__KEYWORD, oldKeyword, keyword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CaltropPackage.KEYWORD_CHANNEL_SELECTOR__KEYWORD:
				return getKeyword();
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
			case CaltropPackage.KEYWORD_CHANNEL_SELECTOR__KEYWORD:
				setKeyword((ChannelSelectorKeyword)newValue);
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
			case CaltropPackage.KEYWORD_CHANNEL_SELECTOR__KEYWORD:
				setKeyword(KEYWORD_EDEFAULT);
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
			case CaltropPackage.KEYWORD_CHANNEL_SELECTOR__KEYWORD:
				return keyword != KEYWORD_EDEFAULT;
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
		result.append(" (keyword: ");
		result.append(keyword);
		result.append(')');
		return result.toString();
	}

} //KeywordChannelSelectorImpl
