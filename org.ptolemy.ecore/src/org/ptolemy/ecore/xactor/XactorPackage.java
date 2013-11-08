/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.ptolemy.ecore.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.xactor.XactorFactory
 * @model kind="package"
 * @generated
 */
public interface XactorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xactor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ptolemy.org/xactor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xactor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XactorPackage eINSTANCE = org.ptolemy.ecore.xactor.impl.XactorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.xactor.impl.EntityFolderImpl <em>Entity Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.xactor.impl.EntityFolderImpl
	 * @see org.ptolemy.ecore.xactor.impl.XactorPackageImpl#getEntityFolder()
	 * @generated
	 */
	int ENTITY_FOLDER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__NAME = KernelPackage.ENTITY_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__DISPLAY_NAME = KernelPackage.ENTITY_CONTAINER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__ATTRIBUTES = KernelPackage.ENTITY_CONTAINER__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__INHERITS_FROM = KernelPackage.ENTITY_CONTAINER__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__ENTITIES = KernelPackage.ENTITY_CONTAINER__ENTITIES;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__RELATIONS = KernelPackage.ENTITY_CONTAINER__RELATIONS;

	/**
	 * The feature id for the '<em><b>Entity Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__ENTITY_CONTAINERS = KernelPackage.ENTITY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER__IMPORTS = KernelPackage.ENTITY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER_FEATURE_COUNT = KernelPackage.ENTITY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.xactor.EntityFolder <em>Entity Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Folder</em>'.
	 * @see org.ptolemy.ecore.xactor.EntityFolder
	 * @generated
	 */
	EClass getEntityFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.xactor.EntityFolder#getEntityContainers <em>Entity Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entity Containers</em>'.
	 * @see org.ptolemy.ecore.xactor.EntityFolder#getEntityContainers()
	 * @see #getEntityFolder()
	 * @generated
	 */
	EReference getEntityFolder_EntityContainers();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.xactor.EntityFolder#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Imports</em>'.
	 * @see org.ptolemy.ecore.xactor.EntityFolder#getImports()
	 * @see #getEntityFolder()
	 * @generated
	 */
	EReference getEntityFolder_Imports();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XactorFactory getXactorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.xactor.impl.EntityFolderImpl <em>Entity Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.xactor.impl.EntityFolderImpl
		 * @see org.ptolemy.ecore.xactor.impl.XactorPackageImpl#getEntityFolder()
		 * @generated
		 */
		EClass ENTITY_FOLDER = eINSTANCE.getEntityFolder();

		/**
		 * The meta object literal for the '<em><b>Entity Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_FOLDER__ENTITY_CONTAINERS = eINSTANCE.getEntityFolder_EntityContainers();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_FOLDER__IMPORTS = eINSTANCE.getEntityFolder_Imports();

	}

} //XactorPackage
