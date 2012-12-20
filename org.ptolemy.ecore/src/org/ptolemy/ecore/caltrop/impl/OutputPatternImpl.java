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
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.OutputPattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.OutputPatternImpl#getValueExpressions <em>Value Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputPatternImpl extends PortPatternImpl implements OutputPattern {
	/**
	 * The cached value of the '{@link #getValueExpressions() <em>Value Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> valueExpressions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.OUTPUT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getValueExpressions() {
		if (valueExpressions == null) {
			valueExpressions = new EObjectContainmentEList<XExpression>(XExpression.class, this, CaltropPackage.OUTPUT_PATTERN__VALUE_EXPRESSIONS);
		}
		return valueExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.OUTPUT_PATTERN__VALUE_EXPRESSIONS:
				return ((InternalEList<?>)getValueExpressions()).basicRemove(otherEnd, msgs);
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
			case CaltropPackage.OUTPUT_PATTERN__VALUE_EXPRESSIONS:
				return getValueExpressions();
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
			case CaltropPackage.OUTPUT_PATTERN__VALUE_EXPRESSIONS:
				getValueExpressions().clear();
				getValueExpressions().addAll((Collection<? extends XExpression>)newValue);
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
			case CaltropPackage.OUTPUT_PATTERN__VALUE_EXPRESSIONS:
				getValueExpressions().clear();
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
			case CaltropPackage.OUTPUT_PATTERN__VALUE_EXPRESSIONS:
				return valueExpressions != null && !valueExpressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	//
	
	@Override
	public int size() {
		return getValueExpressions().size();
	}
} //OutputPatternImpl
