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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.EventPattern;
import org.ptolemy.ecore.caltrop.StateVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#getVarRef <em>Var Ref</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#isProperty <em>Property</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#getTimeExpression <em>Time Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.EventPatternImpl#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventPatternImpl extends ActionPatternImpl implements EventPattern {
	/**
	 * The cached value of the '{@link #getVarRef() <em>Var Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarRef()
	 * @generated
	 * @ordered
	 */
	protected StateVariable varRef;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected String qualifier = QUALIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> variables;

	/**
	 * The default value of the '{@link #isProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProperty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROPERTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProperty()
	 * @generated
	 * @ordered
	 */
	protected boolean property = PROPERTY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimeExpression() <em>Time Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression timeExpression;

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
	protected EventPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.EVENT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable getVarRef() {
		if (varRef != null && varRef.eIsProxy()) {
			InternalEObject oldVarRef = (InternalEObject)varRef;
			varRef = (StateVariable)eResolveProxy(oldVarRef);
			if (varRef != oldVarRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaltropPackage.EVENT_PATTERN__VAR_REF, oldVarRef, varRef));
			}
		}
		return varRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable basicGetVarRef() {
		return varRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarRef(StateVariable newVarRef) {
		StateVariable oldVarRef = varRef;
		varRef = newVarRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__VAR_REF, oldVarRef, varRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifier() {
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifier(String newQualifier) {
		String oldQualifier = qualifier;
		qualifier = newQualifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__QUALIFIER, oldQualifier, qualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVariables() {
		if (variables == null) {
			variables = new EDataTypeUniqueEList<String>(String.class, this, CaltropPackage.EVENT_PATTERN__VARIABLES);
		}
		return variables;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getPatternVariables() {
		return getVariables();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(boolean newProperty) {
		boolean oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getTimeExpression() {
		return timeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeExpression(XExpression newTimeExpression, NotificationChain msgs) {
		XExpression oldTimeExpression = timeExpression;
		timeExpression = newTimeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION, oldTimeExpression, newTimeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeExpression(XExpression newTimeExpression) {
		if (newTimeExpression != timeExpression) {
			NotificationChain msgs = null;
			if (timeExpression != null)
				msgs = ((InternalEObject)timeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION, null, msgs);
			if (newTimeExpression != null)
				msgs = ((InternalEObject)newTimeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION, null, msgs);
			msgs = basicSetTimeExpression(newTimeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION, newTimeExpression, newTimeExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
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
				msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION, null, msgs);
			if (newGuardExpression != null)
				msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION, null, msgs);
			msgs = basicSetGuardExpression(newGuardExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION:
				return basicSetTimeExpression(null, msgs);
			case CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION:
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
			case CaltropPackage.EVENT_PATTERN__VAR_REF:
				if (resolve) return getVarRef();
				return basicGetVarRef();
			case CaltropPackage.EVENT_PATTERN__NAME:
				return getName();
			case CaltropPackage.EVENT_PATTERN__QUALIFIER:
				return getQualifier();
			case CaltropPackage.EVENT_PATTERN__VARIABLES:
				return getVariables();
			case CaltropPackage.EVENT_PATTERN__PROPERTY:
				return isProperty();
			case CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION:
				return getTimeExpression();
			case CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION:
				return getGuardExpression();
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
			case CaltropPackage.EVENT_PATTERN__VAR_REF:
				setVarRef((StateVariable)newValue);
				return;
			case CaltropPackage.EVENT_PATTERN__NAME:
				setName((String)newValue);
				return;
			case CaltropPackage.EVENT_PATTERN__QUALIFIER:
				setQualifier((String)newValue);
				return;
			case CaltropPackage.EVENT_PATTERN__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends String>)newValue);
				return;
			case CaltropPackage.EVENT_PATTERN__PROPERTY:
				setProperty((Boolean)newValue);
				return;
			case CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION:
				setTimeExpression((XExpression)newValue);
				return;
			case CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION:
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
			case CaltropPackage.EVENT_PATTERN__VAR_REF:
				setVarRef((StateVariable)null);
				return;
			case CaltropPackage.EVENT_PATTERN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CaltropPackage.EVENT_PATTERN__QUALIFIER:
				setQualifier(QUALIFIER_EDEFAULT);
				return;
			case CaltropPackage.EVENT_PATTERN__VARIABLES:
				getVariables().clear();
				return;
			case CaltropPackage.EVENT_PATTERN__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION:
				setTimeExpression((XExpression)null);
				return;
			case CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION:
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
			case CaltropPackage.EVENT_PATTERN__VAR_REF:
				return varRef != null;
			case CaltropPackage.EVENT_PATTERN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CaltropPackage.EVENT_PATTERN__QUALIFIER:
				return QUALIFIER_EDEFAULT == null ? qualifier != null : !QUALIFIER_EDEFAULT.equals(qualifier);
			case CaltropPackage.EVENT_PATTERN__VARIABLES:
				return variables != null && !variables.isEmpty();
			case CaltropPackage.EVENT_PATTERN__PROPERTY:
				return property != PROPERTY_EDEFAULT;
			case CaltropPackage.EVENT_PATTERN__TIME_EXPRESSION:
				return timeExpression != null;
			case CaltropPackage.EVENT_PATTERN__GUARD_EXPRESSION:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", qualifier: ");
		result.append(qualifier);
		result.append(", variables: ");
		result.append(variables);
		result.append(", property: ");
		result.append(property);
		result.append(')');
		return result.toString();
	}

} //EventPatternImpl
