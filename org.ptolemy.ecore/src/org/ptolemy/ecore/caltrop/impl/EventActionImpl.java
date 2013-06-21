/**
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
import org.ptolemy.ecore.caltrop.EventAction;
import org.ptolemy.ecore.caltrop.EventPattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventActionImpl#getEventPatterns <em>Event Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventActionImpl extends ReActionImpl implements EventAction {
	/**
	 * The cached value of the '{@link #getEventPatterns() <em>Event Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPattern> eventPatterns;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.EVENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventPattern> getEventPatterns() {
		if (eventPatterns == null) {
			eventPatterns = new EObjectContainmentEList<EventPattern>(EventPattern.class, this, CaltropPackage.EVENT_ACTION__EVENT_PATTERNS);
		}
		return eventPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.EVENT_ACTION__EVENT_PATTERNS:
				return ((InternalEList<?>)getEventPatterns()).basicRemove(otherEnd, msgs);
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
			case CaltropPackage.EVENT_ACTION__EVENT_PATTERNS:
				return getEventPatterns();
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
			case CaltropPackage.EVENT_ACTION__EVENT_PATTERNS:
				getEventPatterns().clear();
				getEventPatterns().addAll((Collection<? extends EventPattern>)newValue);
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
			case CaltropPackage.EVENT_ACTION__EVENT_PATTERNS:
				getEventPatterns().clear();
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
			case CaltropPackage.EVENT_ACTION__EVENT_PATTERNS:
				return eventPatterns != null && !eventPatterns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EventActionImpl
