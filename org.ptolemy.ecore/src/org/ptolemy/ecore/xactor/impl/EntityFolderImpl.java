/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xtype.XImportSection;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.impl.EntityContainerImpl;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.XactorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.xactor.impl.EntityFolderImpl#getEntityContainers <em>Entity Containers</em>}</li>
 *   <li>{@link org.ptolemy.ecore.xactor.impl.EntityFolderImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityFolderImpl extends EntityContainerImpl<Port> implements EntityFolder {
	/**
	 * The cached value of the '{@link #getEntityContainers() <em>Entity Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<EntityFolder> entityContainers;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected XImportSection imports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XactorPackage.Literals.ENTITY_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EntityFolder> getEntityContainers() {
		if (entityContainers == null) {
			entityContainers = new EObjectContainmentEList<EntityFolder>(EntityFolder.class, this, XactorPackage.ENTITY_FOLDER__ENTITY_CONTAINERS);
		}
		return entityContainers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XImportSection getImports() {
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImports(XImportSection newImports, NotificationChain msgs) {
		XImportSection oldImports = imports;
		imports = newImports;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XactorPackage.ENTITY_FOLDER__IMPORTS, oldImports, newImports);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImports(XImportSection newImports) {
		if (newImports != imports) {
			NotificationChain msgs = null;
			if (imports != null)
				msgs = ((InternalEObject)imports).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XactorPackage.ENTITY_FOLDER__IMPORTS, null, msgs);
			if (newImports != null)
				msgs = ((InternalEObject)newImports).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XactorPackage.ENTITY_FOLDER__IMPORTS, null, msgs);
			msgs = basicSetImports(newImports, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XactorPackage.ENTITY_FOLDER__IMPORTS, newImports, newImports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XactorPackage.ENTITY_FOLDER__ENTITY_CONTAINERS:
				return ((InternalEList<?>)getEntityContainers()).basicRemove(otherEnd, msgs);
			case XactorPackage.ENTITY_FOLDER__IMPORTS:
				return basicSetImports(null, msgs);
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
			case XactorPackage.ENTITY_FOLDER__ENTITY_CONTAINERS:
				return getEntityContainers();
			case XactorPackage.ENTITY_FOLDER__IMPORTS:
				return getImports();
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
			case XactorPackage.ENTITY_FOLDER__ENTITY_CONTAINERS:
				getEntityContainers().clear();
				getEntityContainers().addAll((Collection<? extends EntityFolder>)newValue);
				return;
			case XactorPackage.ENTITY_FOLDER__IMPORTS:
				setImports((XImportSection)newValue);
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
			case XactorPackage.ENTITY_FOLDER__ENTITY_CONTAINERS:
				getEntityContainers().clear();
				return;
			case XactorPackage.ENTITY_FOLDER__IMPORTS:
				setImports((XImportSection)null);
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
			case XactorPackage.ENTITY_FOLDER__ENTITY_CONTAINERS:
				return entityContainers != null && !entityContainers.isEmpty();
			case XactorPackage.ENTITY_FOLDER__IMPORTS:
				return imports != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public NamedObj getContainer() {
		return (eContainer() instanceof EntityContainer ? (NamedObj) eContainer() : null);
	}

} //EntityFolderImpl
