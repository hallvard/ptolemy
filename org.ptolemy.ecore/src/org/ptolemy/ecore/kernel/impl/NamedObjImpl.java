/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.NamedObj;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Obj</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.NamedObjImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.NamedObjImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.NamedObjImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.NamedObjImpl#getInheritsFrom <em>Inherits From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedObjImpl extends EObjectImpl implements NamedObj {
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
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getInheritsFrom() <em>Inherits From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFrom()
	 * @generated
	 * @ordered
	 */
	protected NamedObj inheritsFrom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedObjImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.NAMED_OBJ;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.NAMED_OBJ__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.NAMED_OBJ__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, KernelPackage.NAMED_OBJ__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedObj getInheritsFrom() {
		if (inheritsFrom != null && inheritsFrom.eIsProxy()) {
			InternalEObject oldInheritsFrom = (InternalEObject)inheritsFrom;
			inheritsFrom = (NamedObj)eResolveProxy(oldInheritsFrom);
			if (inheritsFrom != oldInheritsFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KernelPackage.NAMED_OBJ__INHERITS_FROM, oldInheritsFrom, inheritsFrom));
			}
		}
		return inheritsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedObj basicGetInheritsFrom() {
		return inheritsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritsFrom(NamedObj newInheritsFrom) {
		NamedObj oldInheritsFrom = inheritsFrom;
		inheritsFrom = newInheritsFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.NAMED_OBJ__INHERITS_FROM, oldInheritsFrom, inheritsFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Attribute getAttribute(String name) {
		return getNamed(name, this, KernelPackage.eINSTANCE.getNamedObj_Attributes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedObj getContainer() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getFullName() {
		return getName(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName(NamedObj namedObj) {
		if (getName() == null) {
			return null;
		}
		StringBuilder fullName = new StringBuilder(getName());
		Nameable container = getContainer(), cddr = (container != null ? container.getContainer() : null);
		while (container != namedObj && container != null) {
			if (container.getName() != null) {
				fullName.insert(0, '.');
				fullName.insert(0, container.getName());
			}
			container = container.getContainer();
			if (cddr != null) {
				cddr = cddr.getContainer();
				if (cddr != null) {
					cddr = cddr.getContainer();
				}
				if (cddr == container) {
					throw new IllegalStateException("Circular containment structure");
				}
			}
		}
		return fullName.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.NAMED_OBJ__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case KernelPackage.NAMED_OBJ__NAME:
				return getName();
			case KernelPackage.NAMED_OBJ__DISPLAY_NAME:
				return getDisplayName();
			case KernelPackage.NAMED_OBJ__ATTRIBUTES:
				return getAttributes();
			case KernelPackage.NAMED_OBJ__INHERITS_FROM:
				if (resolve) return getInheritsFrom();
				return basicGetInheritsFrom();
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
			case KernelPackage.NAMED_OBJ__NAME:
				setName((String)newValue);
				return;
			case KernelPackage.NAMED_OBJ__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case KernelPackage.NAMED_OBJ__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case KernelPackage.NAMED_OBJ__INHERITS_FROM:
				setInheritsFrom((NamedObj)newValue);
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
			case KernelPackage.NAMED_OBJ__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KernelPackage.NAMED_OBJ__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case KernelPackage.NAMED_OBJ__ATTRIBUTES:
				getAttributes().clear();
				return;
			case KernelPackage.NAMED_OBJ__INHERITS_FROM:
				setInheritsFrom((NamedObj)null);
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
			case KernelPackage.NAMED_OBJ__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KernelPackage.NAMED_OBJ__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case KernelPackage.NAMED_OBJ__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case KernelPackage.NAMED_OBJ__INHERITS_FROM:
				return inheritsFrom != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		toString(result);
		return result.toString();
	}

	protected void toString(StringBuffer result) {
		result.append(getName());
		if (displayName != null) {
			result.append(" \"" + displayName + "\"");
		}
	}
	
	//

	protected static <T extends Nameable> T getNamed(String name, EList<T> nameds) {
		for (T t : nameds) {
			if (name.equals(t.getName())) {
				return t;
			}
		}
		return null;
	}
	
	protected static <T extends Nameable> T getNamed(String name, NamedObj named, EStructuralFeature feature) {
		return getNamed(name, (EList<T>) named.eGet(feature));
	}
	
	//
	
//	protected String getDefaultBaseName() {
//		return "named";
//	}
//
//	protected boolean isSameKind(Nameable named) {
//		return true;
//	}
//	
//	protected EList<? extends Nameable> getSameObjects() {
//		return (EList<? extends Nameable>) eContainer.eGet(eContainingFeature());
//	}
//
//	protected String getDefaultName() {
//		if (getInheritsFrom() != null) {
//			return getInheritsFrom().getName();
//		}
//		if (getContainer() == null) {
//			return null;
//		}
//		EList<? extends Nameable> nameds = getSameObjects();
//		int pos = 0, count = 0;
//		for (Nameable named: nameds) {
//			if (isSameKind(named)) {
//				count++;
//				if (named == this) {
//					pos = count;
//				}
//			}
//		}
//		String baseName = getDefaultBaseName();
//		return baseName + (count == 1 ? "" : pos);
//	}

} //NamedObjImpl
