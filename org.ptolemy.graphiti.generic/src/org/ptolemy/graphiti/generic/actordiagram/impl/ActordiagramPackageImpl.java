/**
 */
package org.ptolemy.graphiti.generic.actordiagram.impl;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.graphiti.mm.MmPackage;
import org.eclipse.graphiti.mm.algorithms.AlgorithmsPackage;
import org.eclipse.graphiti.mm.algorithms.styles.StylesPackage;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.IconShape;
import org.ptolemy.graphiti.generic.actordiagram.LabelShape;
import org.ptolemy.graphiti.generic.actordiagram.PortAnchor;
import org.ptolemy.graphiti.generic.actordiagram.PortGA;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.actordiagram.RelationConnection;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

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
	private EClass labelShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iconShapeEClass = null;

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
	private EClass portGAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationShapeEClass = null;

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
	private EDataType ePointEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eDimensionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eRectangleEDataType = null;

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
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#eNS_URI
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
	public EClass getIconShape() {
		return iconShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIconShape_Icon() {
		return (EReference)iconShapeEClass.getEStructuralFeatures().get(0);
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
	public EClass getPortGA() {
		return portGAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationConnection() {
		return relationConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationShape() {
		return relationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationShape_SourcePortShape() {
		return (EReference)relationShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationShape_TargetPortShapes() {
		return (EReference)relationShapeEClass.getEStructuralFeatures().get(1);
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
	public EDataType getEPoint() {
		return ePointEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEDimension() {
		return eDimensionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getERectangle() {
		return eRectangleEDataType;
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
		labelShapeEClass = createEClass(LABEL_SHAPE);
		createEReference(labelShapeEClass, LABEL_SHAPE__LABEL);

		iconShapeEClass = createEClass(ICON_SHAPE);
		createEReference(iconShapeEClass, ICON_SHAPE__ICON);

		entityShapeEClass = createEClass(ENTITY_SHAPE);

		entityContainerShapeEClass = createEClass(ENTITY_CONTAINER_SHAPE);

		entityContainerDiagramEClass = createEClass(ENTITY_CONTAINER_DIAGRAM);

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

		portGAEClass = createEClass(PORT_GA);

		relationConnectionEClass = createEClass(RELATION_CONNECTION);

		relationShapeEClass = createEClass(RELATION_SHAPE);
		createEReference(relationShapeEClass, RELATION_SHAPE__SOURCE_PORT_SHAPE);
		createEReference(relationShapeEClass, RELATION_SHAPE__TARGET_PORT_SHAPES);

		// Create data types
		ePointEDataType = createEDataType(EPOINT);
		eDimensionEDataType = createEDataType(EDIMENSION);
		eRectangleEDataType = createEDataType(ERECTANGLE);
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
		StylesPackage theStylesPackage = (StylesPackage)EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		entityShapeEClass.getESuperTypes().add(thePictogramsPackage.getContainerShape());
		entityShapeEClass.getESuperTypes().add(this.getLabelShape());
		entityShapeEClass.getESuperTypes().add(this.getIconShape());
		entityContainerShapeEClass.getESuperTypes().add(thePictogramsPackage.getContainerShape());
		entityContainerShapeEClass.getESuperTypes().add(this.getLabelShape());
		entityContainerDiagramEClass.getESuperTypes().add(thePictogramsPackage.getDiagram());
		portShapeEClass.getESuperTypes().add(thePictogramsPackage.getShape());
		portAnchorEClass.getESuperTypes().add(thePictogramsPackage.getBoxRelativeAnchor());
		portGAEClass.getESuperTypes().add(theAlgorithmsPackage.getPlatformGraphicsAlgorithm());
		relationConnectionEClass.getESuperTypes().add(thePictogramsPackage.getFreeFormConnection());
		relationShapeEClass.getESuperTypes().add(thePictogramsPackage.getShape());

		// Initialize classes and features; add operations and parameters
		initEClass(labelShapeEClass, LabelShape.class, "LabelShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLabelShape_Label(), theAlgorithmsPackage.getAbstractText(), null, "label", null, 0, 1, LabelShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconShapeEClass, IconShape.class, "IconShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIconShape_Icon(), theAlgorithmsPackage.getPlatformGraphicsAlgorithm(), null, "icon", null, 0, 1, IconShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityShapeEClass, EntityShape.class, "EntityShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityContainerShapeEClass, EntityContainerShape.class, "EntityContainerShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityContainerDiagramEClass, EntityContainerDiagram.class, "EntityContainerDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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

		initEClass(portGAEClass, PortGA.class, "PortGA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(portGAEClass, this.getEPoint(), "getTipAnchorPoint", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(portGAEClass, this.getEPoint(), "getBaseAnchorPoint", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(portGAEClass, this.getERectangle(), "getTipBounds", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(portGAEClass, this.getERectangle(), "getBaseBounds", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(portGAEClass, this.getPortShape(), "getPortShape", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationConnectionEClass, RelationConnection.class, "RelationConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationShapeEClass, RelationShape.class, "RelationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationShape_SourcePortShape(), this.getPortShape(), null, "sourcePortShape", null, 0, 1, RelationShape.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRelationShape_TargetPortShapes(), this.getPortShape(), null, "targetPortShapes", null, 0, -1, RelationShape.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(ePointEDataType, Point.class, "EPoint", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eDimensionEDataType, Dimension.class, "EDimension", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eRectangleEDataType, Rectangle.class, "ERectangle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ActordiagramPackageImpl
