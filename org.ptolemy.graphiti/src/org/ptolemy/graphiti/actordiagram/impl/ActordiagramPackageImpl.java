/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.graphiti.mm.MmPackage;
import org.eclipse.graphiti.mm.algorithms.AlgorithmsPackage;
import org.eclipse.graphiti.mm.algorithms.styles.StylesPackage;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.graphiti.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.actordiagram.EntityShape;
import org.ptolemy.graphiti.actordiagram.LabelShape;
import org.ptolemy.graphiti.actordiagram.ModelShape;
import org.ptolemy.graphiti.actordiagram.PortAnchor;
import org.ptolemy.graphiti.actordiagram.PortShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActordiagramPackageImpl extends EPackageImpl implements ActordiagramPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityContainerShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portAnchorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityContainerDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelShapeEClass = null;

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
	 * @see org.ptolemy.graphiti.actordiagram.ActordiagramPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActordiagramPackageImpl() {
		super(eNS_URI, ActordiagramFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActordiagramPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActordiagramPackage init() {
		if (isInited) return (ActordiagramPackage)EPackage.Registry.INSTANCE.getEPackage(ActordiagramPackage.eNS_URI);

		// Obtain or create and register package
		ActordiagramPackageImpl theActordiagramPackage = (ActordiagramPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActordiagramPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActordiagramPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MmPackage.eINSTANCE.eClass();
		KernelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theActordiagramPackage.createPackageContents();

		// Initialize created meta-data
		theActordiagramPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActordiagramPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActordiagramPackage.eNS_URI, theActordiagramPackage);
		return theActordiagramPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityShape() {
		return entityShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityContainerShape() {
		return entityContainerShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortShape() {
		return portShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortShape_Alignment() {
		return (EAttribute)portShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortShape_Orientation() {
		return (EAttribute)portShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortShape_OutsideAnchor() {
		return (EReference)portShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortShape_InsideAnchor() {
		return (EReference)portShapeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortShape_Size() {
		return (EAttribute)portShapeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortShape_Filled() {
		return (EAttribute)portShapeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortShape_Locked() {
		return (EAttribute)portShapeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortAnchor() {
		return portAnchorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortAnchor_Alignment() {
		return (EAttribute)portAnchorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityContainerDiagram() {
		return entityContainerDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelShape() {
		return modelShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelShape_Model() {
		return (EReference)modelShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabelShape() {
		return labelShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabelShape_Label() {
		return (EReference)labelShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActordiagramFactory getActordiagramFactory() {
		return (ActordiagramFactory)getEFactoryInstance();
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
		modelShapeEClass = createEClass(MODEL_SHAPE);
		createEReference(modelShapeEClass, MODEL_SHAPE__MODEL);

		labelShapeEClass = createEClass(LABEL_SHAPE);
		createEReference(labelShapeEClass, LABEL_SHAPE__LABEL);

		entityShapeEClass = createEClass(ENTITY_SHAPE);

		entityContainerShapeEClass = createEClass(ENTITY_CONTAINER_SHAPE);

		portShapeEClass = createEClass(PORT_SHAPE);
		createEAttribute(portShapeEClass, PORT_SHAPE__ALIGNMENT);
		createEAttribute(portShapeEClass, PORT_SHAPE__ORIENTATION);
		createEReference(portShapeEClass, PORT_SHAPE__OUTSIDE_ANCHOR);
		createEReference(portShapeEClass, PORT_SHAPE__INSIDE_ANCHOR);
		createEAttribute(portShapeEClass, PORT_SHAPE__SIZE);
		createEAttribute(portShapeEClass, PORT_SHAPE__FILLED);
		createEAttribute(portShapeEClass, PORT_SHAPE__LOCKED);

		portAnchorEClass = createEClass(PORT_ANCHOR);
		createEAttribute(portAnchorEClass, PORT_ANCHOR__ALIGNMENT);

		entityContainerDiagramEClass = createEClass(ENTITY_CONTAINER_DIAGRAM);
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

		// Obtain other dependent packages
		AlgorithmsPackage theAlgorithmsPackage = (AlgorithmsPackage)EPackage.Registry.INSTANCE.getEPackage(AlgorithmsPackage.eNS_URI);
		PictogramsPackage thePictogramsPackage = (PictogramsPackage)EPackage.Registry.INSTANCE.getEPackage(PictogramsPackage.eNS_URI);
		KernelPackage theKernelPackage = (KernelPackage)EPackage.Registry.INSTANCE.getEPackage(KernelPackage.eNS_URI);
		StylesPackage theStylesPackage = (StylesPackage)EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI);

		// Create type parameters
		ETypeParameter modelShapeEClass_M = addETypeParameter(modelShapeEClass, "M");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(thePictogramsPackage.getContainerShape());
		entityShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelShape());
		EGenericType g2 = createEGenericType(theKernelPackage.getEntity());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		entityShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLabelShape());
		entityShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(thePictogramsPackage.getContainerShape());
		entityContainerShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelShape());
		g2 = createEGenericType(theKernelPackage.getEntityContainer());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		entityContainerShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLabelShape());
		entityContainerShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(thePictogramsPackage.getShape());
		portShapeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelShape());
		g2 = createEGenericType(theKernelPackage.getPort());
		g1.getETypeArguments().add(g2);
		portShapeEClass.getEGenericSuperTypes().add(g1);
		portAnchorEClass.getESuperTypes().add(thePictogramsPackage.getBoxRelativeAnchor());
		g1 = createEGenericType(thePictogramsPackage.getDiagram());
		entityContainerDiagramEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelShape());
		g2 = createEGenericType(theKernelPackage.getEntityContainer());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		entityContainerDiagramEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(modelShapeEClass, ModelShape.class, "ModelShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(modelShapeEClass_M);
		initEReference(getModelShape_Model(), g1, null, "model", null, 0, 1, ModelShape.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(labelShapeEClass, LabelShape.class, "LabelShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLabelShape_Label(), theAlgorithmsPackage.getAbstractText(), null, "label", null, 0, 1, LabelShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityShapeEClass, EntityShape.class, "EntityShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityContainerShapeEClass, EntityContainerShape.class, "EntityContainerShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portShapeEClass, PortShape.class, "PortShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPortShape_Alignment(), theStylesPackage.getOrientation(), "alignment", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortShape_Orientation(), theStylesPackage.getOrientation(), "orientation", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortShape_OutsideAnchor(), this.getPortAnchor(), null, "outsideAnchor", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortShape_InsideAnchor(), this.getPortAnchor(), null, "insideAnchor", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortShape_Size(), ecorePackage.getEInt(), "size", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortShape_Filled(), ecorePackage.getEBoolean(), "filled", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortShape_Locked(), ecorePackage.getEBoolean(), "locked", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portAnchorEClass, PortAnchor.class, "PortAnchor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPortAnchor_Alignment(), theStylesPackage.getOrientation(), "alignment", null, 0, 1, PortAnchor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityContainerDiagramEClass, EntityContainerDiagram.class, "EntityContainerDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ActordiagramPackageImpl
