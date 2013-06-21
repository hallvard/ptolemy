/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.FireAction;
import org.ptolemy.ecore.caltrop.InputPattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fire Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.FireActionImpl#getInputPatterns <em>Input Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FireActionImpl extends ReActionImpl implements FireAction {
	/**
	 * The cached value of the '{@link #getInputPatterns() <em>Input Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<InputPattern> inputPatterns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FireActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.FIRE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputPattern> getInputPatterns() {
		if (inputPatterns == null) {
			inputPatterns = new EObjectContainmentEList<InputPattern>(InputPattern.class, this, CaltropPackage.FIRE_ACTION__INPUT_PATTERNS);
		}
		return inputPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.FIRE_ACTION__INPUT_PATTERNS:
				return ((InternalEList<?>)getInputPatterns()).basicRemove(otherEnd, msgs);
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
			case CaltropPackage.FIRE_ACTION__INPUT_PATTERNS:
				return getInputPatterns();
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
			case CaltropPackage.FIRE_ACTION__INPUT_PATTERNS:
				getInputPatterns().clear();
				getInputPatterns().addAll((Collection<? extends InputPattern>)newValue);
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
			case CaltropPackage.FIRE_ACTION__INPUT_PATTERNS:
				getInputPatterns().clear();
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
			case CaltropPackage.FIRE_ACTION__INPUT_PATTERNS:
				return inputPatterns != null && !inputPatterns.isEmpty();
		}
		return super.eIsSet(featureID);
	}
} //FireActionImpl
