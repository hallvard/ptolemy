/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.ptolemy.ecore.kernel.KernelFactory
 * @model kind="package"
 * @generated
 */
public interface KernelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kernel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ptolemy.org/kernel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kernel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelPackage eINSTANCE = org.ptolemy.ecore.kernel.impl.KernelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.Named <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Named
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getNamed()
	 * @generated
	 */
	int NAMED = 0;

	/**
	 * The number of structural features of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.AttributeImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Nameable
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 1;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.NamedObjImpl <em>Named Obj</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.NamedObjImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getNamedObj()
	 * @generated
	 */
	int NAMED_OBJ = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJ__NAME = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJ__DISPLAY_NAME = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJ__ATTRIBUTES = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJ__INHERITS_FROM = NAMEABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Named Obj</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJ_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DISPLAY_NAME = NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ATTRIBUTES = NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INHERITS_FROM = NAMED_OBJ__INHERITS_FROM;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.IEntity <em>IEntity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.IEntity
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getIEntity()
	 * @generated
	 */
	int IENTITY = 4;

	/**
	 * The number of structural features of the '<em>IEntity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENTITY_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.EntityImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__DISPLAY_NAME = NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ATTRIBUTES = NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INHERITS_FROM = NAMED_OBJ__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__PORTS = NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SOURCE_ENTITIES = NAMED_OBJ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__TARGET_ENTITIES = NAMED_OBJ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SUPER_ENTITY = NAMED_OBJ_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INHERITED_ATTRIBUTES = NAMED_OBJ_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INHERITED_PORTS = NAMED_OBJ_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ALL_ATTRIBUTES = NAMED_OBJ_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ALL_PORTS = NAMED_OBJ_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = NAMED_OBJ_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.EntityRefOwner <em>Entity Ref Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.EntityRefOwner
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntityRefOwner()
	 * @generated
	 */
	int ENTITY_REF_OWNER = 6;

	/**
	 * The number of structural features of the '<em>Entity Ref Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_OWNER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.EntityRefImpl <em>Entity Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.EntityRefImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntityRef()
	 * @generated
	 */
	int ENTITY_REF = 7;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF__OWNER = IENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF__REF = IENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF__RESOLVED = IENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entity Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_FEATURE_COUNT = IENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.PortImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DISPLAY_NAME = NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ATTRIBUTES = NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__INHERITS_FROM = NAMED_OBJ__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OUTGOING_LINKS = NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__INCOMING_LINKS = NAMED_OBJ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TARGET_PORTS = NAMED_OBJ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SOURCE_PORTS = NAMED_OBJ_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = NAMED_OBJ_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.RelationImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__DISPLAY_NAME = NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ATTRIBUTES = NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__INHERITS_FROM = NAMED_OBJ__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE_PORT = NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_PORTS = NAMED_OBJ_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = NAMED_OBJ_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.ComponentEntityImpl <em>Component Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.ComponentEntityImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getComponentEntity()
	 * @generated
	 */
	int COMPONENT_ENTITY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__DISPLAY_NAME = ENTITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__INHERITS_FROM = ENTITY__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__PORTS = ENTITY__PORTS;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__SOURCE_ENTITIES = ENTITY__SOURCE_ENTITIES;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__TARGET_ENTITIES = ENTITY__TARGET_ENTITIES;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__SUPER_ENTITY = ENTITY__SUPER_ENTITY;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__INHERITED_ATTRIBUTES = ENTITY__INHERITED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__INHERITED_PORTS = ENTITY__INHERITED_PORTS;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__ALL_ATTRIBUTES = ENTITY__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY__ALL_PORTS = ENTITY__ALL_PORTS;

	/**
	 * The number of structural features of the '<em>Component Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.ComponentPortImpl <em>Component Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.ComponentPortImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getComponentPort()
	 * @generated
	 */
	int COMPONENT_PORT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__DISPLAY_NAME = PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__ATTRIBUTES = PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__INHERITS_FROM = PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__OUTGOING_LINKS = PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__INCOMING_LINKS = PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__TARGET_PORTS = PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__SOURCE_PORTS = PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__INNER_OUTGOING_LINKS = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT__INNER_INCOMING_LINKS = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl <em>Composite Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.CompositeEntityImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getCompositeEntity()
	 * @generated
	 */
	int COMPOSITE_ENTITY = 13;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.kernel.impl.EntityContainerImpl <em>Entity Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.impl.EntityContainerImpl
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntityContainer()
	 * @generated
	 */
	int ENTITY_CONTAINER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER__NAME = NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER__DISPLAY_NAME = NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER__ATTRIBUTES = NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER__INHERITS_FROM = NAMED_OBJ__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER__ENTITIES = NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER__RELATIONS = NAMED_OBJ_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTAINER_FEATURE_COUNT = NAMED_OBJ_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__NAME = COMPONENT_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__DISPLAY_NAME = COMPONENT_ENTITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__ATTRIBUTES = COMPONENT_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__INHERITS_FROM = COMPONENT_ENTITY__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__PORTS = COMPONENT_ENTITY__PORTS;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__SOURCE_ENTITIES = COMPONENT_ENTITY__SOURCE_ENTITIES;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__TARGET_ENTITIES = COMPONENT_ENTITY__TARGET_ENTITIES;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__SUPER_ENTITY = COMPONENT_ENTITY__SUPER_ENTITY;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__INHERITED_ATTRIBUTES = COMPONENT_ENTITY__INHERITED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__INHERITED_PORTS = COMPONENT_ENTITY__INHERITED_PORTS;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__ALL_ATTRIBUTES = COMPONENT_ENTITY__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__ALL_PORTS = COMPONENT_ENTITY__ALL_PORTS;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__ENTITIES = COMPONENT_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__RELATIONS = COMPONENT_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Merged Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__MERGED_ENTITIES = COMPONENT_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inherited Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__INHERITED_RELATIONS = COMPONENT_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>All Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__ALL_ENTITIES = COMPONENT_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>All Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY__ALL_RELATIONS = COMPONENT_ENTITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Composite Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ENTITY_FEATURE_COUNT = COMPONENT_ENTITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '<em>Java Class Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getJavaClassRef()
	 * @generated
	 */
	int JAVA_CLASS_REF = 14;


	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named</em>'.
	 * @see org.ptolemy.ecore.kernel.Named
	 * @generated
	 */
	EClass getNamed();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.ptolemy.ecore.kernel.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.IEntity <em>IEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEntity</em>'.
	 * @see org.ptolemy.ecore.kernel.IEntity
	 * @generated
	 */
	EClass getIEntity();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.ptolemy.ecore.kernel.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.NamedObj <em>Named Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Obj</em>'.
	 * @see org.ptolemy.ecore.kernel.NamedObj
	 * @generated
	 */
	EClass getNamedObj();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.kernel.NamedObj#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.ptolemy.ecore.kernel.NamedObj#getName()
	 * @see #getNamedObj()
	 * @generated
	 */
	EAttribute getNamedObj_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.kernel.NamedObj#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.ptolemy.ecore.kernel.NamedObj#getDisplayName()
	 * @see #getNamedObj()
	 * @generated
	 */
	EAttribute getNamedObj_DisplayName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.NamedObj#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.ptolemy.ecore.kernel.NamedObj#getAttributes()
	 * @see #getNamedObj()
	 * @generated
	 */
	EReference getNamedObj_Attributes();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.ecore.kernel.NamedObj#getInheritsFrom <em>Inherits From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inherits From</em>'.
	 * @see org.ptolemy.ecore.kernel.NamedObj#getInheritsFrom()
	 * @see #getNamedObj()
	 * @generated
	 */
	EReference getNamedObj_InheritsFrom();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.Entity#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getPorts()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Ports();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Entity#getSourceEntities <em>Source Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Entities</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getSourceEntities()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_SourceEntities();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Entity#getTargetEntities <em>Target Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Entities</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getTargetEntities()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_TargetEntities();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.kernel.Entity#getSuperEntity <em>Super Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super Entity</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getSuperEntity()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_SuperEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.Entity#getInheritedAttributes <em>Inherited Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inherited Attributes</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getInheritedAttributes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_InheritedAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.Entity#getInheritedPorts <em>Inherited Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inherited Ports</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getInheritedPorts()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_InheritedPorts();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Entity#getAllAttributes <em>All Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Attributes</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getAllAttributes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_AllAttributes();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Entity#getAllPorts <em>All Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Ports</em>'.
	 * @see org.ptolemy.ecore.kernel.Entity#getAllPorts()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_AllPorts();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.EntityRefOwner <em>Entity Ref Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Ref Owner</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityRefOwner
	 * @generated
	 */
	EClass getEntityRefOwner();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.EntityRef <em>Entity Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Ref</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityRef
	 * @generated
	 */
	EClass getEntityRef();

	/**
	 * Returns the meta object for the container reference '{@link org.ptolemy.ecore.kernel.EntityRef#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityRef#getOwner()
	 * @see #getEntityRef()
	 * @generated
	 */
	EReference getEntityRef_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.ecore.kernel.EntityRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityRef#getRef()
	 * @see #getEntityRef()
	 * @generated
	 */
	EReference getEntityRef_Ref();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.kernel.EntityRef#getResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resolved</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityRef#getResolved()
	 * @see #getEntityRef()
	 * @generated
	 */
	EReference getEntityRef_Resolved();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.ptolemy.ecore.kernel.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Port#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Links</em>'.
	 * @see org.ptolemy.ecore.kernel.Port#getOutgoingLinks()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_OutgoingLinks();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Port#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Links</em>'.
	 * @see org.ptolemy.ecore.kernel.Port#getIncomingLinks()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_IncomingLinks();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Port#getTargetPorts <em>Target Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Ports</em>'.
	 * @see org.ptolemy.ecore.kernel.Port#getTargetPorts()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_TargetPorts();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Port#getSourcePorts <em>Source Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Ports</em>'.
	 * @see org.ptolemy.ecore.kernel.Port#getSourcePorts()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_SourcePorts();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see org.ptolemy.ecore.kernel.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.ecore.kernel.Relation#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Port</em>'.
	 * @see org.ptolemy.ecore.kernel.Relation#getSourcePort()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_SourcePort();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.Relation#getTargetPorts <em>Target Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Ports</em>'.
	 * @see org.ptolemy.ecore.kernel.Relation#getTargetPorts()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_TargetPorts();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.ComponentEntity <em>Component Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Entity</em>'.
	 * @see org.ptolemy.ecore.kernel.ComponentEntity
	 * @generated
	 */
	EClass getComponentEntity();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.ComponentPort <em>Component Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Port</em>'.
	 * @see org.ptolemy.ecore.kernel.ComponentPort
	 * @generated
	 */
	EClass getComponentPort();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.ComponentPort#getInnerOutgoingLinks <em>Inner Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inner Outgoing Links</em>'.
	 * @see org.ptolemy.ecore.kernel.ComponentPort#getInnerOutgoingLinks()
	 * @see #getComponentPort()
	 * @generated
	 */
	EReference getComponentPort_InnerOutgoingLinks();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.ComponentPort#getInnerIncomingLinks <em>Inner Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inner Incoming Links</em>'.
	 * @see org.ptolemy.ecore.kernel.ComponentPort#getInnerIncomingLinks()
	 * @see #getComponentPort()
	 * @generated
	 */
	EReference getComponentPort_InnerIncomingLinks();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.CompositeEntity <em>Composite Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Entity</em>'.
	 * @see org.ptolemy.ecore.kernel.CompositeEntity
	 * @generated
	 */
	EClass getCompositeEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.CompositeEntity#getMergedEntities <em>Merged Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Merged Entities</em>'.
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getMergedEntities()
	 * @see #getCompositeEntity()
	 * @generated
	 */
	EReference getCompositeEntity_MergedEntities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.CompositeEntity#getInheritedRelations <em>Inherited Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inherited Relations</em>'.
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getInheritedRelations()
	 * @see #getCompositeEntity()
	 * @generated
	 */
	EReference getCompositeEntity_InheritedRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllEntities <em>All Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Entities</em>'.
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getAllEntities()
	 * @see #getCompositeEntity()
	 * @generated
	 */
	EReference getCompositeEntity_AllEntities();

	/**
	 * Returns the meta object for the reference list '{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllRelations <em>All Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Relations</em>'.
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getAllRelations()
	 * @see #getCompositeEntity()
	 * @generated
	 */
	EReference getCompositeEntity_AllRelations();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.kernel.EntityContainer <em>Entity Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Container</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityContainer
	 * @generated
	 */
	EClass getEntityContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.EntityContainer#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityContainer#getEntities()
	 * @see #getEntityContainer()
	 * @generated
	 */
	EReference getEntityContainer_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.kernel.EntityContainer#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relations</em>'.
	 * @see org.ptolemy.ecore.kernel.EntityContainer#getRelations()
	 * @see #getEntityContainer()
	 * @generated
	 */
	EReference getEntityContainer_Relations();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Java Class Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Class Ref</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJavaClassRef();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KernelFactory getKernelFactory();

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
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.Named <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.Named
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getNamed()
		 * @generated
		 */
		EClass NAMED = eINSTANCE.getNamed();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.AttributeImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.IEntity <em>IEntity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.IEntity
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getIEntity()
		 * @generated
		 */
		EClass IENTITY = eINSTANCE.getIEntity();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.Nameable
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.NamedObjImpl <em>Named Obj</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.NamedObjImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getNamedObj()
		 * @generated
		 */
		EClass NAMED_OBJ = eINSTANCE.getNamedObj();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_OBJ__NAME = eINSTANCE.getNamedObj_Name();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_OBJ__DISPLAY_NAME = eINSTANCE.getNamedObj_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_OBJ__ATTRIBUTES = eINSTANCE.getNamedObj_Attributes();

		/**
		 * The meta object literal for the '<em><b>Inherits From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_OBJ__INHERITS_FROM = eINSTANCE.getNamedObj_InheritsFrom();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.EntityImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__PORTS = eINSTANCE.getEntity_Ports();

		/**
		 * The meta object literal for the '<em><b>Source Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__SOURCE_ENTITIES = eINSTANCE.getEntity_SourceEntities();

		/**
		 * The meta object literal for the '<em><b>Target Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__TARGET_ENTITIES = eINSTANCE.getEntity_TargetEntities();

		/**
		 * The meta object literal for the '<em><b>Super Entity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__SUPER_ENTITY = eINSTANCE.getEntity_SuperEntity();

		/**
		 * The meta object literal for the '<em><b>Inherited Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__INHERITED_ATTRIBUTES = eINSTANCE.getEntity_InheritedAttributes();

		/**
		 * The meta object literal for the '<em><b>Inherited Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__INHERITED_PORTS = eINSTANCE.getEntity_InheritedPorts();

		/**
		 * The meta object literal for the '<em><b>All Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__ALL_ATTRIBUTES = eINSTANCE.getEntity_AllAttributes();

		/**
		 * The meta object literal for the '<em><b>All Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__ALL_PORTS = eINSTANCE.getEntity_AllPorts();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.EntityRefOwner <em>Entity Ref Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.EntityRefOwner
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntityRefOwner()
		 * @generated
		 */
		EClass ENTITY_REF_OWNER = eINSTANCE.getEntityRefOwner();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.EntityRefImpl <em>Entity Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.EntityRefImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntityRef()
		 * @generated
		 */
		EClass ENTITY_REF = eINSTANCE.getEntityRef();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_REF__OWNER = eINSTANCE.getEntityRef_Owner();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_REF__REF = eINSTANCE.getEntityRef_Ref();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_REF__RESOLVED = eINSTANCE.getEntityRef_Resolved();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.PortImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OUTGOING_LINKS = eINSTANCE.getPort_OutgoingLinks();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__INCOMING_LINKS = eINSTANCE.getPort_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Target Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__TARGET_PORTS = eINSTANCE.getPort_TargetPorts();

		/**
		 * The meta object literal for the '<em><b>Source Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__SOURCE_PORTS = eINSTANCE.getPort_SourcePorts();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.RelationImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Source Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SOURCE_PORT = eINSTANCE.getRelation_SourcePort();

		/**
		 * The meta object literal for the '<em><b>Target Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__TARGET_PORTS = eINSTANCE.getRelation_TargetPorts();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.ComponentEntityImpl <em>Component Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.ComponentEntityImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getComponentEntity()
		 * @generated
		 */
		EClass COMPONENT_ENTITY = eINSTANCE.getComponentEntity();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.ComponentPortImpl <em>Component Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.ComponentPortImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getComponentPort()
		 * @generated
		 */
		EClass COMPONENT_PORT = eINSTANCE.getComponentPort();

		/**
		 * The meta object literal for the '<em><b>Inner Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_PORT__INNER_OUTGOING_LINKS = eINSTANCE.getComponentPort_InnerOutgoingLinks();

		/**
		 * The meta object literal for the '<em><b>Inner Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_PORT__INNER_INCOMING_LINKS = eINSTANCE.getComponentPort_InnerIncomingLinks();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl <em>Composite Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.CompositeEntityImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getCompositeEntity()
		 * @generated
		 */
		EClass COMPOSITE_ENTITY = eINSTANCE.getCompositeEntity();

		/**
		 * The meta object literal for the '<em><b>Merged Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ENTITY__MERGED_ENTITIES = eINSTANCE.getCompositeEntity_MergedEntities();

		/**
		 * The meta object literal for the '<em><b>Inherited Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ENTITY__INHERITED_RELATIONS = eINSTANCE.getCompositeEntity_InheritedRelations();

		/**
		 * The meta object literal for the '<em><b>All Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ENTITY__ALL_ENTITIES = eINSTANCE.getCompositeEntity_AllEntities();

		/**
		 * The meta object literal for the '<em><b>All Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ENTITY__ALL_RELATIONS = eINSTANCE.getCompositeEntity_AllRelations();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.kernel.impl.EntityContainerImpl <em>Entity Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.kernel.impl.EntityContainerImpl
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getEntityContainer()
		 * @generated
		 */
		EClass ENTITY_CONTAINER = eINSTANCE.getEntityContainer();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_CONTAINER__ENTITIES = eINSTANCE.getEntityContainer_Entities();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_CONTAINER__RELATIONS = eINSTANCE.getEntityContainer_Relations();

		/**
		 * The meta object literal for the '<em>Java Class Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.ptolemy.ecore.kernel.impl.KernelPackageImpl#getJavaClassRef()
		 * @generated
		 */
		EDataType JAVA_CLASS_REF = eINSTANCE.getJavaClassRef();

	}

} //KernelPackage
