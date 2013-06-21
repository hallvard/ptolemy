/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xtype.XImportSection;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.impl.EntityContainerImpl;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.ImportDirective;
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
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<XImportSection> imports;

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
	public EList<XImportSection> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<XImportSection>(XImportSection.class, this, XactorPackage.ENTITY_FOLDER__IMPORTS);
		}
		return imports;
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
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
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
				getImports().clear();
				getImports().addAll((Collection<? extends XImportSection>)newValue);
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
				getImports().clear();
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
				return imports != null && !imports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public NamedObj getContainer() {
		return (eContainer() instanceof EntityContainer ? (NamedObj) eContainer() : null);
	}

} //EntityFolderImpl
