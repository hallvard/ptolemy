/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor;

import org.eclipse.emf.ecore.EAttribute;
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
	String eNS_URI = "org.ptolemy.ecore.xactor";

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
	 * The number of structural features of the '<em>Entity Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FOLDER_FEATURE_COUNT = KernelPackage.ENTITY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.xactor.impl.ActorModelImpl <em>Actor Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.xactor.impl.ActorModelImpl
	 * @see org.ptolemy.ecore.xactor.impl.XactorPackageImpl#getActorModel()
	 * @generated
	 */
	int ACTOR_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__NAME = ENTITY_FOLDER__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__DISPLAY_NAME = ENTITY_FOLDER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__ATTRIBUTES = ENTITY_FOLDER__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__INHERITS_FROM = ENTITY_FOLDER__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__ENTITIES = ENTITY_FOLDER__ENTITIES;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__RELATIONS = ENTITY_FOLDER__RELATIONS;

	/**
	 * The feature id for the '<em><b>Entity Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__ENTITY_CONTAINERS = ENTITY_FOLDER__ENTITY_CONTAINERS;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL__IMPORTS = ENTITY_FOLDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_MODEL_FEATURE_COUNT = ENTITY_FOLDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.xactor.impl.ImportDirectiveImpl <em>Import Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.xactor.impl.ImportDirectiveImpl
	 * @see org.ptolemy.ecore.xactor.impl.XactorPackageImpl#getImportDirective()
	 * @generated
	 */
	int IMPORT_DIRECTIVE = 2;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DIRECTIVE__IMPORTED_NAMESPACE = 0;

	/**
	 * The number of structural features of the '<em>Import Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_DIRECTIVE_FEATURE_COUNT = 1;


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
	 * Returns the meta object for class '{@link org.ptolemy.ecore.xactor.ActorModel <em>Actor Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Model</em>'.
	 * @see org.ptolemy.ecore.xactor.ActorModel
	 * @generated
	 */
	EClass getActorModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.xactor.ActorModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.ptolemy.ecore.xactor.ActorModel#getImports()
	 * @see #getActorModel()
	 * @generated
	 */
	EReference getActorModel_Imports();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.xactor.ImportDirective <em>Import Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Directive</em>'.
	 * @see org.ptolemy.ecore.xactor.ImportDirective
	 * @generated
	 */
	EClass getImportDirective();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.xactor.ImportDirective#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.ptolemy.ecore.xactor.ImportDirective#getImportedNamespace()
	 * @see #getImportDirective()
	 * @generated
	 */
	EAttribute getImportDirective_ImportedNamespace();

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
		 * The meta object literal for the '{@link org.ptolemy.ecore.xactor.impl.ActorModelImpl <em>Actor Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.xactor.impl.ActorModelImpl
		 * @see org.ptolemy.ecore.xactor.impl.XactorPackageImpl#getActorModel()
		 * @generated
		 */
		EClass ACTOR_MODEL = eINSTANCE.getActorModel();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_MODEL__IMPORTS = eINSTANCE.getActorModel_Imports();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.xactor.impl.ImportDirectiveImpl <em>Import Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.xactor.impl.ImportDirectiveImpl
		 * @see org.ptolemy.ecore.xactor.impl.XactorPackageImpl#getImportDirective()
		 * @generated
		 */
		EClass IMPORT_DIRECTIVE = eINSTANCE.getImportDirective();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_DIRECTIVE__IMPORTED_NAMESPACE = eINSTANCE.getImportDirective_ImportedNamespace();

	}

} //XactorPackage
