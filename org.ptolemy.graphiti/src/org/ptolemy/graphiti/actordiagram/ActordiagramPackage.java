/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;

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
 * @see org.ptolemy.graphiti.actordiagram.ActordiagramFactory
 * @model kind="package"
 * @generated
 */
public interface ActordiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actordiagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.ptolemy.graphiti.actordiagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actordiagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActordiagramPackage eINSTANCE = org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.EntityShapeImpl <em>Entity Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.EntityShapeImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getEntityShape()
	 * @generated
	 */
	int ENTITY_SHAPE = 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl <em>Port Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getPortShape()
	 * @generated
	 */
	int PORT_SHAPE = 4;

	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.ModelShapeImpl <em>Model Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.ModelShapeImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getModelShape()
	 * @generated
	 */
	int MODEL_SHAPE = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SHAPE__MODEL = 0;

	/**
	 * The number of structural features of the '<em>Model Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SHAPE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.LabelShapeImpl <em>Label Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.LabelShapeImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getLabelShape()
	 * @generated
	 */
	int LABEL_SHAPE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_SHAPE__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Label Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_SHAPE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__PROPERTIES = PictogramsPackage.CONTAINER_SHAPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__VISIBLE = PictogramsPackage.CONTAINER_SHAPE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Graphics Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__GRAPHICS_ALGORITHM = PictogramsPackage.CONTAINER_SHAPE__GRAPHICS_ALGORITHM;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__ACTIVE = PictogramsPackage.CONTAINER_SHAPE__ACTIVE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__LINK = PictogramsPackage.CONTAINER_SHAPE__LINK;

	/**
	 * The feature id for the '<em><b>Anchors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__ANCHORS = PictogramsPackage.CONTAINER_SHAPE__ANCHORS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__CONTAINER = PictogramsPackage.CONTAINER_SHAPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__CHILDREN = PictogramsPackage.CONTAINER_SHAPE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__MODEL = PictogramsPackage.CONTAINER_SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE__LABEL = PictogramsPackage.CONTAINER_SHAPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SHAPE_FEATURE_COUNT = PictogramsPackage.CONTAINER_SHAPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.EntityContainerShapeImpl <em>Entity Container Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.EntityContainerShapeImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getEntityContainerShape()
	 * @generated
	 */
	int ENTITY_CONTAINER_SHAPE = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__PROPERTIES = PictogramsPackage.CONTAINER_SHAPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__VISIBLE = PictogramsPackage.CONTAINER_SHAPE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Graphics Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__GRAPHICS_ALGORITHM = PictogramsPackage.CONTAINER_SHAPE__GRAPHICS_ALGORITHM;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__ACTIVE = PictogramsPackage.CONTAINER_SHAPE__ACTIVE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__LINK = PictogramsPackage.CONTAINER_SHAPE__LINK;

	/**
	 * The feature id for the '<em><b>Anchors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__ANCHORS = PictogramsPackage.CONTAINER_SHAPE__ANCHORS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__CONTAINER = PictogramsPackage.CONTAINER_SHAPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__CHILDREN = PictogramsPackage.CONTAINER_SHAPE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__MODEL = PictogramsPackage.CONTAINER_SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE__LABEL = PictogramsPackage.CONTAINER_SHAPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Container Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_SHAPE_FEATURE_COUNT = PictogramsPackage.CONTAINER_SHAPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__PROPERTIES = PictogramsPackage.SHAPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__VISIBLE = PictogramsPackage.SHAPE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Graphics Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__GRAPHICS_ALGORITHM = PictogramsPackage.SHAPE__GRAPHICS_ALGORITHM;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__ACTIVE = PictogramsPackage.SHAPE__ACTIVE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__LINK = PictogramsPackage.SHAPE__LINK;

	/**
	 * The feature id for the '<em><b>Anchors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__ANCHORS = PictogramsPackage.SHAPE__ANCHORS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__CONTAINER = PictogramsPackage.SHAPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__MODEL = PictogramsPackage.SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__ALIGNMENT = PictogramsPackage.SHAPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__ORIENTATION = PictogramsPackage.SHAPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outside Anchor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__OUTSIDE_ANCHOR = PictogramsPackage.SHAPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inside Anchor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__INSIDE_ANCHOR = PictogramsPackage.SHAPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__SIZE = PictogramsPackage.SHAPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Filled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__FILLED = PictogramsPackage.SHAPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Locked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE__LOCKED = PictogramsPackage.SHAPE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Port Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SHAPE_FEATURE_COUNT = PictogramsPackage.SHAPE_FEATURE_COUNT + 8;


	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.PortAnchorImpl <em>Port Anchor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.PortAnchorImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getPortAnchor()
	 * @generated
	 */
	int PORT_ANCHOR = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__PROPERTIES = PictogramsPackage.BOX_RELATIVE_ANCHOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__VISIBLE = PictogramsPackage.BOX_RELATIVE_ANCHOR__VISIBLE;

	/**
	 * The feature id for the '<em><b>Graphics Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__GRAPHICS_ALGORITHM = PictogramsPackage.BOX_RELATIVE_ANCHOR__GRAPHICS_ALGORITHM;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__ACTIVE = PictogramsPackage.BOX_RELATIVE_ANCHOR__ACTIVE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__LINK = PictogramsPackage.BOX_RELATIVE_ANCHOR__LINK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__PARENT = PictogramsPackage.BOX_RELATIVE_ANCHOR__PARENT;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__OUTGOING_CONNECTIONS = PictogramsPackage.BOX_RELATIVE_ANCHOR__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__INCOMING_CONNECTIONS = PictogramsPackage.BOX_RELATIVE_ANCHOR__INCOMING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Referenced Graphics Algorithm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__REFERENCED_GRAPHICS_ALGORITHM = PictogramsPackage.BOX_RELATIVE_ANCHOR__REFERENCED_GRAPHICS_ALGORITHM;

	/**
	 * The feature id for the '<em><b>Use Anchor Location As Connection Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__USE_ANCHOR_LOCATION_AS_CONNECTION_ENDPOINT = PictogramsPackage.BOX_RELATIVE_ANCHOR__USE_ANCHOR_LOCATION_AS_CONNECTION_ENDPOINT;

	/**
	 * The feature id for the '<em><b>Relative Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__RELATIVE_WIDTH = PictogramsPackage.BOX_RELATIVE_ANCHOR__RELATIVE_WIDTH;

	/**
	 * The feature id for the '<em><b>Relative Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__RELATIVE_HEIGHT = PictogramsPackage.BOX_RELATIVE_ANCHOR__RELATIVE_HEIGHT;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR__ALIGNMENT = PictogramsPackage.BOX_RELATIVE_ANCHOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port Anchor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ANCHOR_FEATURE_COUNT = PictogramsPackage.BOX_RELATIVE_ANCHOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.graphiti.actordiagram.impl.EntityContainerDiagramImpl <em>Entity Container Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.graphiti.actordiagram.impl.EntityContainerDiagramImpl
	 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getEntityContainerDiagram()
	 * @generated
	 */
	int ENTITY_CONTAINER_DIAGRAM = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__PROPERTIES = PictogramsPackage.DIAGRAM__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__VISIBLE = PictogramsPackage.DIAGRAM__VISIBLE;

	/**
	 * The feature id for the '<em><b>Graphics Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__GRAPHICS_ALGORITHM = PictogramsPackage.DIAGRAM__GRAPHICS_ALGORITHM;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__ACTIVE = PictogramsPackage.DIAGRAM__ACTIVE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__LINK = PictogramsPackage.DIAGRAM__LINK;

	/**
	 * The feature id for the '<em><b>Anchors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__ANCHORS = PictogramsPackage.DIAGRAM__ANCHORS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__CONTAINER = PictogramsPackage.DIAGRAM__CONTAINER;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__CHILDREN = PictogramsPackage.DIAGRAM__CHILDREN;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__STYLES = PictogramsPackage.DIAGRAM__STYLES;

	/**
	 * The feature id for the '<em><b>Grid Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__GRID_UNIT = PictogramsPackage.DIAGRAM__GRID_UNIT;

	/**
	 * The feature id for the '<em><b>Diagram Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__DIAGRAM_TYPE_ID = PictogramsPackage.DIAGRAM__DIAGRAM_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__CONNECTIONS = PictogramsPackage.DIAGRAM__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__NAME = PictogramsPackage.DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Snap To Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__SNAP_TO_GRID = PictogramsPackage.DIAGRAM__SNAP_TO_GRID;

	/**
	 * The feature id for the '<em><b>Show Guides</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__SHOW_GUIDES = PictogramsPackage.DIAGRAM__SHOW_GUIDES;

	/**
	 * The feature id for the '<em><b>Colors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__COLORS = PictogramsPackage.DIAGRAM__COLORS;

	/**
	 * The feature id for the '<em><b>Fonts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__FONTS = PictogramsPackage.DIAGRAM__FONTS;

	/**
	 * The feature id for the '<em><b>Pictogram Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__PICTOGRAM_LINKS = PictogramsPackage.DIAGRAM__PICTOGRAM_LINKS;

	/**
	 * The feature id for the '<em><b>Vertical Grid Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__VERTICAL_GRID_UNIT = PictogramsPackage.DIAGRAM__VERTICAL_GRID_UNIT;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__VERSION = PictogramsPackage.DIAGRAM__VERSION;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM__MODEL = PictogramsPackage.DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Container Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_DIAGRAM_FEATURE_COUNT = PictogramsPackage.DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.EntityShape <em>Entity Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Shape</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.EntityShape
	 * @generated
	 */
	EClass getEntityShape();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.EntityContainerShape <em>Entity Container Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Container Shape</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.EntityContainerShape
	 * @generated
	 */
	EClass getEntityContainerShape();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.PortShape <em>Port Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Shape</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape
	 * @generated
	 */
	EClass getPortShape();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.graphiti.actordiagram.PortShape#getAlignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#getAlignment()
	 * @see #getPortShape()
	 * @generated
	 */
	EAttribute getPortShape_Alignment();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.graphiti.actordiagram.PortShape#getOrientation <em>Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Orientation</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#getOrientation()
	 * @see #getPortShape()
	 * @generated
	 */
	EAttribute getPortShape_Orientation();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.graphiti.actordiagram.PortShape#getOutsideAnchor <em>Outside Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Anchor</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#getOutsideAnchor()
	 * @see #getPortShape()
	 * @generated
	 */
	EReference getPortShape_OutsideAnchor();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.graphiti.actordiagram.PortShape#getInsideAnchor <em>Inside Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Anchor</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#getInsideAnchor()
	 * @see #getPortShape()
	 * @generated
	 */
	EReference getPortShape_InsideAnchor();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.graphiti.actordiagram.PortShape#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#getSize()
	 * @see #getPortShape()
	 * @generated
	 */
	EAttribute getPortShape_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.graphiti.actordiagram.PortShape#isFilled <em>Filled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filled</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#isFilled()
	 * @see #getPortShape()
	 * @generated
	 */
	EAttribute getPortShape_Filled();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.graphiti.actordiagram.PortShape#isLocked <em>Locked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locked</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape#isLocked()
	 * @see #getPortShape()
	 * @generated
	 */
	EAttribute getPortShape_Locked();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.PortAnchor <em>Port Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Anchor</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortAnchor
	 * @generated
	 */
	EClass getPortAnchor();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.graphiti.actordiagram.PortAnchor#getAlignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.PortAnchor#getAlignment()
	 * @see #getPortAnchor()
	 * @generated
	 */
	EAttribute getPortAnchor_Alignment();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.EntityContainerDiagram <em>Entity Container Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Container Diagram</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.EntityContainerDiagram
	 * @generated
	 */
	EClass getEntityContainerDiagram();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.ModelShape <em>Model Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Shape</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.ModelShape
	 * @generated
	 */
	EClass getModelShape();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.graphiti.actordiagram.ModelShape#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.ModelShape#getModel()
	 * @see #getModelShape()
	 * @generated
	 */
	EReference getModelShape_Model();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.graphiti.actordiagram.LabelShape <em>Label Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Shape</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.LabelShape
	 * @generated
	 */
	EClass getLabelShape();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.graphiti.actordiagram.LabelShape#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label</em>'.
	 * @see org.ptolemy.graphiti.actordiagram.LabelShape#getLabel()
	 * @see #getLabelShape()
	 * @generated
	 */
	EReference getLabelShape_Label();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActordiagramFactory getActordiagramFactory();

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
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.EntityShapeImpl <em>Entity Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.EntityShapeImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getEntityShape()
		 * @generated
		 */
		EClass ENTITY_SHAPE = eINSTANCE.getEntityShape();

		/**
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.EntityContainerShapeImpl <em>Entity Container Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.EntityContainerShapeImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getEntityContainerShape()
		 * @generated
		 */
		EClass ENTITY_CONTAINER_SHAPE = eINSTANCE.getEntityContainerShape();

		/**
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl <em>Port Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getPortShape()
		 * @generated
		 */
		EClass PORT_SHAPE = eINSTANCE.getPortShape();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SHAPE__ALIGNMENT = eINSTANCE.getPortShape_Alignment();

		/**
		 * The meta object literal for the '<em><b>Orientation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SHAPE__ORIENTATION = eINSTANCE.getPortShape_Orientation();

		/**
		 * The meta object literal for the '<em><b>Outside Anchor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_SHAPE__OUTSIDE_ANCHOR = eINSTANCE.getPortShape_OutsideAnchor();

		/**
		 * The meta object literal for the '<em><b>Inside Anchor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_SHAPE__INSIDE_ANCHOR = eINSTANCE.getPortShape_InsideAnchor();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SHAPE__SIZE = eINSTANCE.getPortShape_Size();

		/**
		 * The meta object literal for the '<em><b>Filled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SHAPE__FILLED = eINSTANCE.getPortShape_Filled();

		/**
		 * The meta object literal for the '<em><b>Locked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SHAPE__LOCKED = eINSTANCE.getPortShape_Locked();

		/**
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.PortAnchorImpl <em>Port Anchor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.PortAnchorImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getPortAnchor()
		 * @generated
		 */
		EClass PORT_ANCHOR = eINSTANCE.getPortAnchor();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_ANCHOR__ALIGNMENT = eINSTANCE.getPortAnchor_Alignment();

		/**
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.EntityContainerDiagramImpl <em>Entity Container Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.EntityContainerDiagramImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getEntityContainerDiagram()
		 * @generated
		 */
		EClass ENTITY_CONTAINER_DIAGRAM = eINSTANCE.getEntityContainerDiagram();

		/**
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.ModelShapeImpl <em>Model Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.ModelShapeImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getModelShape()
		 * @generated
		 */
		EClass MODEL_SHAPE = eINSTANCE.getModelShape();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SHAPE__MODEL = eINSTANCE.getModelShape_Model();

		/**
		 * The meta object literal for the '{@link org.ptolemy.graphiti.actordiagram.impl.LabelShapeImpl <em>Label Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.graphiti.actordiagram.impl.LabelShapeImpl
		 * @see org.ptolemy.graphiti.actordiagram.impl.ActordiagramPackageImpl#getLabelShape()
		 * @generated
		 */
		EClass LABEL_SHAPE = eINSTANCE.getLabelShape();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_SHAPE__LABEL = eINSTANCE.getLabelShape_Label();

	}

} //ActordiagramPackage
