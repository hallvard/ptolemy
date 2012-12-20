/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.ComponentEntity;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.EntityRefOwner;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Named;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;
import org.ptolemy.ecore.kernel.util.KernelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KernelPackageImpl extends EPackageImpl implements KernelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedObjEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityRefOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaClassRefEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.ptolemy.ecore.kernel.KernelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private KernelPackageImpl() {
		super(eNS_URI, KernelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link KernelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static KernelPackage init() {
		if (isInited) return (KernelPackage)EPackage.Registry.INSTANCE.getEPackage(KernelPackage.eNS_URI);

		// Obtain or create and register package
		KernelPackageImpl theKernelPackage = (KernelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof KernelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new KernelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theKernelPackage.createPackageContents();

		// Initialize created meta-data
		theKernelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theKernelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return KernelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theKernelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(KernelPackage.eNS_URI, theKernelPackage);
		return theKernelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamed() {
		return namedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEntity() {
		return iEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameable() {
		return nameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedObj() {
		return namedObjEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedObj_Name() {
		return (EAttribute)namedObjEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedObj_DisplayName() {
		return (EAttribute)namedObjEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedObj_Attributes() {
		return (EReference)namedObjEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedObj_InheritsFrom() {
		return (EReference)namedObjEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_Ports() {
		return (EReference)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_SourceEntities() {
		return (EReference)entityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_TargetEntities() {
		return (EReference)entityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_SuperEntity() {
		return (EReference)entityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_InheritedAttributes() {
		return (EReference)entityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_InheritedPorts() {
		return (EReference)entityEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_AllAttributes() {
		return (EReference)entityEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_AllPorts() {
		return (EReference)entityEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityRefOwner() {
		return entityRefOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityRef() {
		return entityRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRef_Owner() {
		return (EReference)entityRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRef_Ref() {
		return (EReference)entityRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRef_Resolved() {
		return (EReference)entityRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_OutgoingLinks() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_IncomingLinks() {
		return (EReference)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_TargetPorts() {
		return (EReference)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_SourcePorts() {
		return (EReference)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_SourcePort() {
		return (EReference)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_TargetPorts() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentEntity() {
		return componentEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPort() {
		return componentPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPort_InnerOutgoingLinks() {
		return (EReference)componentPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPort_InnerIncomingLinks() {
		return (EReference)componentPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeEntity() {
		return compositeEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeEntity_MergedEntities() {
		return (EReference)compositeEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeEntity_InheritedRelations() {
		return (EReference)compositeEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeEntity_AllEntities() {
		return (EReference)compositeEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeEntity_AllRelations() {
		return (EReference)compositeEntityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityContainer() {
		return entityContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityContainer_Entities() {
		return (EReference)entityContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityContainer_Relations() {
		return (EReference)entityContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaClassRef() {
		return javaClassRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelFactory getKernelFactory() {
		return (KernelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		namedEClass = createEClass(NAMED);

		nameableEClass = createEClass(NAMEABLE);

		namedObjEClass = createEClass(NAMED_OBJ);
		createEAttribute(namedObjEClass, NAMED_OBJ__NAME);
		createEAttribute(namedObjEClass, NAMED_OBJ__DISPLAY_NAME);
		createEReference(namedObjEClass, NAMED_OBJ__ATTRIBUTES);
		createEReference(namedObjEClass, NAMED_OBJ__INHERITS_FROM);

		attributeEClass = createEClass(ATTRIBUTE);

		iEntityEClass = createEClass(IENTITY);

		entityEClass = createEClass(ENTITY);
		createEReference(entityEClass, ENTITY__PORTS);
		createEReference(entityEClass, ENTITY__SOURCE_ENTITIES);
		createEReference(entityEClass, ENTITY__TARGET_ENTITIES);
		createEReference(entityEClass, ENTITY__SUPER_ENTITY);
		createEReference(entityEClass, ENTITY__INHERITED_ATTRIBUTES);
		createEReference(entityEClass, ENTITY__INHERITED_PORTS);
		createEReference(entityEClass, ENTITY__ALL_ATTRIBUTES);
		createEReference(entityEClass, ENTITY__ALL_PORTS);

		entityRefOwnerEClass = createEClass(ENTITY_REF_OWNER);

		entityRefEClass = createEClass(ENTITY_REF);
		createEReference(entityRefEClass, ENTITY_REF__OWNER);
		createEReference(entityRefEClass, ENTITY_REF__REF);
		createEReference(entityRefEClass, ENTITY_REF__RESOLVED);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__OUTGOING_LINKS);
		createEReference(portEClass, PORT__INCOMING_LINKS);
		createEReference(portEClass, PORT__TARGET_PORTS);
		createEReference(portEClass, PORT__SOURCE_PORTS);

		relationEClass = createEClass(RELATION);
		createEReference(relationEClass, RELATION__SOURCE_PORT);
		createEReference(relationEClass, RELATION__TARGET_PORTS);

		componentEntityEClass = createEClass(COMPONENT_ENTITY);

		componentPortEClass = createEClass(COMPONENT_PORT);
		createEReference(componentPortEClass, COMPONENT_PORT__INNER_OUTGOING_LINKS);
		createEReference(componentPortEClass, COMPONENT_PORT__INNER_INCOMING_LINKS);

		entityContainerEClass = createEClass(ENTITY_CONTAINER);
		createEReference(entityContainerEClass, ENTITY_CONTAINER__ENTITIES);
		createEReference(entityContainerEClass, ENTITY_CONTAINER__RELATIONS);

		compositeEntityEClass = createEClass(COMPOSITE_ENTITY);
		createEReference(compositeEntityEClass, COMPOSITE_ENTITY__MERGED_ENTITIES);
		createEReference(compositeEntityEClass, COMPOSITE_ENTITY__INHERITED_RELATIONS);
		createEReference(compositeEntityEClass, COMPOSITE_ENTITY__ALL_ENTITIES);
		createEReference(compositeEntityEClass, COMPOSITE_ENTITY__ALL_RELATIONS);

		// Create data types
		javaClassRefEDataType = createEDataType(JAVA_CLASS_REF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter iEntityEClass_P = addETypeParameter(iEntityEClass, "P");
		ETypeParameter entityEClass_P = addETypeParameter(entityEClass, "P");
		ETypeParameter entityRefEClass_P = addETypeParameter(entityRefEClass, "P");
		ETypeParameter componentEntityEClass_P = addETypeParameter(componentEntityEClass, "P");
		ETypeParameter entityContainerEClass_P = addETypeParameter(entityContainerEClass, "P");
		ETypeParameter compositeEntityEClass_P = addETypeParameter(compositeEntityEClass, "P");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getPort());
		iEntityEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getPort());
		entityEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getPort());
		entityRefEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getComponentPort());
		componentEntityEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getPort());
		entityContainerEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getComponentPort());
		compositeEntityEClass_P.getEBounds().add(g1);

		// Add supertypes to classes
		nameableEClass.getESuperTypes().add(this.getNamed());
		namedObjEClass.getESuperTypes().add(this.getNameable());
		attributeEClass.getESuperTypes().add(this.getNamedObj());
		iEntityEClass.getESuperTypes().add(this.getNameable());
		g1 = createEGenericType(this.getNamedObj());
		entityEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getEntityRefOwner());
		entityEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIEntity());
		EGenericType g2 = createEGenericType(entityEClass_P);
		g1.getETypeArguments().add(g2);
		entityEClass.getEGenericSuperTypes().add(g1);
		portEClass.getESuperTypes().add(this.getNamedObj());
		relationEClass.getESuperTypes().add(this.getNamedObj());
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType(componentEntityEClass_P);
		g1.getETypeArguments().add(g2);
		componentEntityEClass.getEGenericSuperTypes().add(g1);
		componentPortEClass.getESuperTypes().add(this.getPort());
		g1 = createEGenericType(this.getNamedObj());
		entityContainerEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIEntity());
		g2 = createEGenericType(entityContainerEClass_P);
		g1.getETypeArguments().add(g2);
		entityContainerEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getComponentEntity());
		g2 = createEGenericType(compositeEntityEClass_P);
		g1.getETypeArguments().add(g2);
		compositeEntityEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getEntityContainer());
		g2 = createEGenericType(compositeEntityEClass_P);
		g1.getETypeArguments().add(g2);
		compositeEntityEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(namedEClass, Named.class, "Named", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(namedEClass, this.getNamedObj(), "getContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(namedEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(namedEClass, ecorePackage.getEString(), "getDisplayName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(namedEClass, ecorePackage.getEString(), "getFullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(namedEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNamedObj(), "container", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(nameableEClass, null, "setName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedObjEClass, NamedObj.class, "NamedObj", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedObj_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedObj_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, NamedObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedObj_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, NamedObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getNamedObj_Attributes().getEKeys().add(this.getNamedObj_Name());
		initEReference(getNamedObj_InheritsFrom(), this.getNamedObj(), null, "inheritsFrom", null, 0, 1, NamedObj.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(namedObjEClass, this.getAttribute(), "getAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iEntityEClass, IEntity.class, "IEntity", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(iEntityEClass, this.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(iEntityEClass, this.getAttribute(), "getAllAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iEntityEClass, null, "getPorts", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(iEntityEClass_P);
		initEOperation(op, g1);

		op = addEOperation(iEntityEClass, null, "getAllPorts", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(iEntityEClass_P);
		initEOperation(op, g1);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(entityEClass_P);
		initEReference(getEntity_Ports(), g1, null, "ports", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getEntity_Ports().getEKeys().add(this.getNamedObj_Name());
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(this.getPort());
		g2.setEUpperBound(g3);
		initEReference(getEntity_SourceEntities(), g1, null, "sourceEntities", null, 0, -1, Entity.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(this.getPort());
		g2.setEUpperBound(g3);
		initEReference(getEntity_TargetEntities(), g1, null, "targetEntities", null, 0, -1, Entity.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getEntityRef());
		g2 = createEGenericType(entityEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getEntity_SuperEntity(), g1, this.getEntityRef_Owner(), "superEntity", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_InheritedAttributes(), this.getAttribute(), null, "inheritedAttributes", null, 0, -1, Entity.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(entityEClass_P);
		initEReference(getEntity_InheritedPorts(), g1, null, "inheritedPorts", null, 0, -1, Entity.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getEntity_InheritedPorts().getEKeys().add(this.getNamedObj_Name());
		initEReference(getEntity_AllAttributes(), this.getAttribute(), null, "allAttributes", null, 0, -1, Entity.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(entityEClass_P);
		initEReference(getEntity_AllPorts(), g1, null, "allPorts", null, 0, -1, Entity.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(entityEClass, null, "getContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getEntityContainer());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(entityEClass, null, "getPort", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(entityEClass_P);
		initEOperation(op, g1);

		op = addEOperation(entityEClass, ecorePackage.getEBoolean(), "resolveSuperEntity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "force", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(entityRefOwnerEClass, EntityRefOwner.class, "EntityRefOwner", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(entityRefOwnerEClass, null, "entityResolved", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEStructuralFeature(), "feature", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(entityRefEClass, EntityRef.class, "EntityRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType(entityRefEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getEntityRef_Owner(), g1, this.getEntity_SuperEntity(), "owner", null, 0, 1, EntityRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType(entityRefEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getEntityRef_Ref(), g1, null, "ref", null, 0, 1, EntityRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType(entityRefEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getEntityRef_Resolved(), g1, null, "resolved", null, 0, 1, EntityRef.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(entityRefEClass, ecorePackage.getEBoolean(), "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "force", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_OutgoingLinks(), this.getRelation(), null, "outgoingLinks", null, 0, -1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPort_IncomingLinks(), this.getRelation(), null, "incomingLinks", null, 0, -1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPort_TargetPorts(), this.getPort(), null, "targetPorts", null, 0, -1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPort_SourcePorts(), this.getPort(), null, "sourcePorts", null, 0, -1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(portEClass, null, "getContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelation_SourcePort(), this.getPort(), null, "sourcePort", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_TargetPorts(), this.getPort(), null, "targetPorts", null, 1, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationEClass, null, "getContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getEntityContainer());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(componentEntityEClass, ComponentEntity.class, "ComponentEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(componentEntityEClass, ecorePackage.getEBoolean(), "isAtomic", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEntityEClass, ecorePackage.getEBoolean(), "isOpaque", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(componentPortEClass, ComponentPort.class, "ComponentPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentPort_InnerOutgoingLinks(), this.getRelation(), null, "innerOutgoingLinks", null, 0, -1, ComponentPort.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentPort_InnerIncomingLinks(), this.getRelation(), null, "innerIncomingLinks", null, 0, -1, ComponentPort.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(entityContainerEClass, EntityContainer.class, "EntityContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(this.getPort());
		g2.setEUpperBound(g3);
		initEReference(getEntityContainer_Entities(), g1, null, "entities", null, 0, -1, EntityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getEntityContainer_Entities().getEKeys().add(this.getNamedObj_Name());
		initEReference(getEntityContainer_Relations(), this.getRelation(), null, "relations", null, 0, -1, EntityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeEntityEClass, CompositeEntity.class, "CompositeEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(this.getPort());
		g2.setEUpperBound(g3);
		initEReference(getCompositeEntity_MergedEntities(), g1, null, "mergedEntities", null, 0, -1, CompositeEntity.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getCompositeEntity_MergedEntities().getEKeys().add(this.getNamedObj_Name());
		initEReference(getCompositeEntity_InheritedRelations(), this.getRelation(), null, "inheritedRelations", null, 0, -1, CompositeEntity.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(this.getPort());
		g2.setEUpperBound(g3);
		initEReference(getCompositeEntity_AllEntities(), g1, null, "allEntities", null, 0, -1, CompositeEntity.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeEntity_AllRelations(), this.getRelation(), null, "allRelations", null, 0, -1, CompositeEntity.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(compositeEntityEClass, null, "getEntity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getEntity());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(this.getPort());
		g2.setEUpperBound(g3);
		initEOperation(op, g1);

		// Initialize data types
		initEDataType(javaClassRefEDataType, Object.class, "JavaClassRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (portEClass, 
		   source, 
		   new String[] {
			 "constraints", ""
		   });		
		addAnnotation
		  (relationEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceTargetContainer inputOutputLogic"
		   });
	}

} //KernelPackageImpl
