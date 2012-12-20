/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.ptolemy.ecore.actor.ActorFactory
 * @model kind="package"
 * @generated
 */
public interface ActorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.ptolemy.ecore.actor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActorPackage eINSTANCE = org.ptolemy.ecore.actor.impl.ActorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.Typeable <em>Typeable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.Typeable
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypeable()
	 * @generated
	 */
	int TYPEABLE = 0;

	/**
	 * The number of structural features of the '<em>Typeable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.JvmTypedObjImpl <em>Jvm Typed Obj</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.JvmTypedObjImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getJvmTypedObj()
	 * @generated
	 */
	int JVM_TYPED_OBJ = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ__NAME = KernelPackage.NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ__DISPLAY_NAME = KernelPackage.NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ__ATTRIBUTES = KernelPackage.NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ__INHERITS_FROM = KernelPackage.NAMED_OBJ__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ__TYPE = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ__INFERRED_TYPE = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Typed Obj</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_OBJ_FEATURE_COUNT = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.JvmTypedAttributeImpl <em>Jvm Typed Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.JvmTypedAttributeImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getJvmTypedAttribute()
	 * @generated
	 */
	int JVM_TYPED_ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE__NAME = KernelPackage.ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE__DISPLAY_NAME = KernelPackage.ATTRIBUTE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE__ATTRIBUTES = KernelPackage.ATTRIBUTE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE__INHERITS_FROM = KernelPackage.ATTRIBUTE__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE__TYPE = KernelPackage.ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE__INFERRED_TYPE = KernelPackage.ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Typed Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPED_ATTRIBUTE_FEATURE_COUNT = KernelPackage.ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.InjectableAttributeImpl <em>Injectable Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.InjectableAttributeImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getInjectableAttribute()
	 * @generated
	 */
	int INJECTABLE_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE__NAME = JVM_TYPED_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE__DISPLAY_NAME = JVM_TYPED_ATTRIBUTE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE__ATTRIBUTES = JVM_TYPED_ATTRIBUTE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE__INHERITS_FROM = JVM_TYPED_ATTRIBUTE__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE__TYPE = JVM_TYPED_ATTRIBUTE__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE__INFERRED_TYPE = JVM_TYPED_ATTRIBUTE__INFERRED_TYPE;

	/**
	 * The number of structural features of the '<em>Injectable Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTABLE_ATTRIBUTE_FEATURE_COUNT = JVM_TYPED_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.VariableImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = JVM_TYPED_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DISPLAY_NAME = JVM_TYPED_ATTRIBUTE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ATTRIBUTES = JVM_TYPED_ATTRIBUTE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INHERITS_FROM = JVM_TYPED_ATTRIBUTE__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = JVM_TYPED_ATTRIBUTE__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INFERRED_TYPE = JVM_TYPED_ATTRIBUTE__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE_EXPRESSION = JVM_TYPED_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = JVM_TYPED_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.ParameterImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DISPLAY_NAME = VARIABLE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ATTRIBUTES = VARIABLE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INHERITS_FROM = VARIABLE__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INFERRED_TYPE = VARIABLE__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE_EXPRESSION = VARIABLE__VALUE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.ActorRefImpl <em>Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.ActorRefImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getActorRef()
	 * @generated
	 */
	int ACTOR_REF = 6;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_REF__OWNER = KernelPackage.ENTITY_REF__OWNER;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_REF__REF = KernelPackage.ENTITY_REF__REF;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_REF__RESOLVED = KernelPackage.ENTITY_REF__RESOLVED;

	/**
	 * The feature id for the '<em><b>Parameter Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_REF__PARAMETER_BINDINGS = KernelPackage.ENTITY_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_REF__TYPE_ARGUMENTS = KernelPackage.ENTITY_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_REF_FEATURE_COUNT = KernelPackage.ENTITY_REF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.ParameterBindingImpl <em>Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.ParameterBindingImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getParameterBinding()
	 * @generated
	 */
	int PARAMETER_BINDING = 7;

	/**
	 * The feature id for the '<em><b>Parameter Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING__PARAMETER_REF = 0;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING__VALUE_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.AbstractIOPortImpl <em>Abstract IO Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.AbstractIOPortImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAbstractIOPort()
	 * @generated
	 */
	int ABSTRACT_IO_PORT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__NAME = KernelPackage.COMPONENT_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__DISPLAY_NAME = KernelPackage.COMPONENT_PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__ATTRIBUTES = KernelPackage.COMPONENT_PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__INHERITS_FROM = KernelPackage.COMPONENT_PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__OUTGOING_LINKS = KernelPackage.COMPONENT_PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__INCOMING_LINKS = KernelPackage.COMPONENT_PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__TARGET_PORTS = KernelPackage.COMPONENT_PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__SOURCE_PORTS = KernelPackage.COMPONENT_PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__INNER_OUTGOING_LINKS = KernelPackage.COMPONENT_PORT__INNER_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__INNER_INCOMING_LINKS = KernelPackage.COMPONENT_PORT__INNER_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__MULTIPORT = KernelPackage.COMPONENT_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__WIDTH = KernelPackage.COMPONENT_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT__RATE = KernelPackage.COMPONENT_PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract IO Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IO_PORT_FEATURE_COUNT = KernelPackage.COMPONENT_PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.IOPortImpl <em>IO Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.IOPortImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getIOPort()
	 * @generated
	 */
	int IO_PORT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__NAME = ABSTRACT_IO_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__DISPLAY_NAME = ABSTRACT_IO_PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__ATTRIBUTES = ABSTRACT_IO_PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__INHERITS_FROM = ABSTRACT_IO_PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__OUTGOING_LINKS = ABSTRACT_IO_PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__INCOMING_LINKS = ABSTRACT_IO_PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__TARGET_PORTS = ABSTRACT_IO_PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__SOURCE_PORTS = ABSTRACT_IO_PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__INNER_OUTGOING_LINKS = ABSTRACT_IO_PORT__INNER_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__INNER_INCOMING_LINKS = ABSTRACT_IO_PORT__INNER_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__MULTIPORT = ABSTRACT_IO_PORT__MULTIPORT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__WIDTH = ABSTRACT_IO_PORT__WIDTH;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__RATE = ABSTRACT_IO_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Io Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT__IO_KIND = ABSTRACT_IO_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IO Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_PORT_FEATURE_COUNT = ABSTRACT_IO_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl <em>Abstract Typed IO Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAbstractTypedIOPort()
	 * @generated
	 */
	int ABSTRACT_TYPED_IO_PORT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__NAME = ABSTRACT_IO_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__DISPLAY_NAME = ABSTRACT_IO_PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__ATTRIBUTES = ABSTRACT_IO_PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__INHERITS_FROM = ABSTRACT_IO_PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__OUTGOING_LINKS = ABSTRACT_IO_PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__INCOMING_LINKS = ABSTRACT_IO_PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__TARGET_PORTS = ABSTRACT_IO_PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__SOURCE_PORTS = ABSTRACT_IO_PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__INNER_OUTGOING_LINKS = ABSTRACT_IO_PORT__INNER_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__INNER_INCOMING_LINKS = ABSTRACT_IO_PORT__INNER_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__MULTIPORT = ABSTRACT_IO_PORT__MULTIPORT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__WIDTH = ABSTRACT_IO_PORT__WIDTH;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__RATE = ABSTRACT_IO_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__TYPE = ABSTRACT_IO_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE = ABSTRACT_IO_PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Typed IO Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPED_IO_PORT_FEATURE_COUNT = ABSTRACT_IO_PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.TypedIOPortImpl <em>Typed IO Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.TypedIOPortImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypedIOPort()
	 * @generated
	 */
	int TYPED_IO_PORT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__NAME = ABSTRACT_TYPED_IO_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__DISPLAY_NAME = ABSTRACT_TYPED_IO_PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__ATTRIBUTES = ABSTRACT_TYPED_IO_PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__INHERITS_FROM = ABSTRACT_TYPED_IO_PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__OUTGOING_LINKS = ABSTRACT_TYPED_IO_PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__INCOMING_LINKS = ABSTRACT_TYPED_IO_PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__TARGET_PORTS = ABSTRACT_TYPED_IO_PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__SOURCE_PORTS = ABSTRACT_TYPED_IO_PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__INNER_OUTGOING_LINKS = ABSTRACT_TYPED_IO_PORT__INNER_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__INNER_INCOMING_LINKS = ABSTRACT_TYPED_IO_PORT__INNER_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__MULTIPORT = ABSTRACT_TYPED_IO_PORT__MULTIPORT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__WIDTH = ABSTRACT_TYPED_IO_PORT__WIDTH;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__RATE = ABSTRACT_TYPED_IO_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__TYPE = ABSTRACT_TYPED_IO_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__INFERRED_TYPE = ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Io Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT__IO_KIND = ABSTRACT_TYPED_IO_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed IO Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_IO_PORT_FEATURE_COUNT = ABSTRACT_TYPED_IO_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.Actor <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.Actor
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 12;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = KernelPackage.IENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.AtomicActorImpl <em>Atomic Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.AtomicActorImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAtomicActor()
	 * @generated
	 */
	int ATOMIC_ACTOR = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__NAME = KernelPackage.ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__DISPLAY_NAME = KernelPackage.ENTITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__ATTRIBUTES = KernelPackage.ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__INHERITS_FROM = KernelPackage.ENTITY__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__PORTS = KernelPackage.ENTITY__PORTS;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__SOURCE_ENTITIES = KernelPackage.ENTITY__SOURCE_ENTITIES;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__TARGET_ENTITIES = KernelPackage.ENTITY__TARGET_ENTITIES;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__SUPER_ENTITY = KernelPackage.ENTITY__SUPER_ENTITY;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__INHERITED_ATTRIBUTES = KernelPackage.ENTITY__INHERITED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__INHERITED_PORTS = KernelPackage.ENTITY__INHERITED_PORTS;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__ALL_ATTRIBUTES = KernelPackage.ENTITY__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__ALL_PORTS = KernelPackage.ENTITY__ALL_PORTS;

	/**
	 * The feature id for the '<em><b>Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__IMPL = KernelPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR__INHERITED_IMPL = KernelPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Atomic Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR_FEATURE_COUNT = KernelPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.AtomicActorImplImpl <em>Atomic Actor Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.AtomicActorImplImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAtomicActorImpl()
	 * @generated
	 */
	int ATOMIC_ACTOR_IMPL = 14;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR_IMPL__CONTAINER = 0;

	/**
	 * The number of structural features of the '<em>Atomic Actor Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTOR_IMPL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.TypeParameterizedImpl <em>Type Parameterized</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.TypeParameterizedImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypeParameterized()
	 * @generated
	 */
	int TYPE_PARAMETERIZED = 15;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETERIZED__TYPE_PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Type Parameterized</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETERIZED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.TypeParameterImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypeParameter()
	 * @generated
	 */
	int TYPE_PARAMETER = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.TypedAtomicActorImpl <em>Typed Atomic Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.TypedAtomicActorImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypedAtomicActor()
	 * @generated
	 */
	int TYPED_ATOMIC_ACTOR = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__NAME = ATOMIC_ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__DISPLAY_NAME = ATOMIC_ACTOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__ATTRIBUTES = ATOMIC_ACTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__INHERITS_FROM = ATOMIC_ACTOR__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__PORTS = ATOMIC_ACTOR__PORTS;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__SOURCE_ENTITIES = ATOMIC_ACTOR__SOURCE_ENTITIES;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__TARGET_ENTITIES = ATOMIC_ACTOR__TARGET_ENTITIES;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__SUPER_ENTITY = ATOMIC_ACTOR__SUPER_ENTITY;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__INHERITED_ATTRIBUTES = ATOMIC_ACTOR__INHERITED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__INHERITED_PORTS = ATOMIC_ACTOR__INHERITED_PORTS;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__ALL_ATTRIBUTES = ATOMIC_ACTOR__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__ALL_PORTS = ATOMIC_ACTOR__ALL_PORTS;

	/**
	 * The feature id for the '<em><b>Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__IMPL = ATOMIC_ACTOR__IMPL;

	/**
	 * The feature id for the '<em><b>Inherited Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__INHERITED_IMPL = ATOMIC_ACTOR__INHERITED_IMPL;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR__TYPE_PARAMETERS = ATOMIC_ACTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Atomic Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ATOMIC_ACTOR_FEATURE_COUNT = ATOMIC_ACTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.CompositeActorImpl <em>Composite Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.CompositeActorImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getCompositeActor()
	 * @generated
	 */
	int COMPOSITE_ACTOR = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__NAME = KernelPackage.COMPOSITE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__DISPLAY_NAME = KernelPackage.COMPOSITE_ENTITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__ATTRIBUTES = KernelPackage.COMPOSITE_ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__INHERITS_FROM = KernelPackage.COMPOSITE_ENTITY__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__PORTS = KernelPackage.COMPOSITE_ENTITY__PORTS;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__SOURCE_ENTITIES = KernelPackage.COMPOSITE_ENTITY__SOURCE_ENTITIES;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__TARGET_ENTITIES = KernelPackage.COMPOSITE_ENTITY__TARGET_ENTITIES;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__SUPER_ENTITY = KernelPackage.COMPOSITE_ENTITY__SUPER_ENTITY;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__INHERITED_ATTRIBUTES = KernelPackage.COMPOSITE_ENTITY__INHERITED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__INHERITED_PORTS = KernelPackage.COMPOSITE_ENTITY__INHERITED_PORTS;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__ALL_ATTRIBUTES = KernelPackage.COMPOSITE_ENTITY__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__ALL_PORTS = KernelPackage.COMPOSITE_ENTITY__ALL_PORTS;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__ENTITIES = KernelPackage.COMPOSITE_ENTITY__ENTITIES;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__RELATIONS = KernelPackage.COMPOSITE_ENTITY__RELATIONS;

	/**
	 * The feature id for the '<em><b>Merged Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__MERGED_ENTITIES = KernelPackage.COMPOSITE_ENTITY__MERGED_ENTITIES;

	/**
	 * The feature id for the '<em><b>Inherited Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__INHERITED_RELATIONS = KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS;

	/**
	 * The feature id for the '<em><b>All Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__ALL_ENTITIES = KernelPackage.COMPOSITE_ENTITY__ALL_ENTITIES;

	/**
	 * The feature id for the '<em><b>All Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR__ALL_RELATIONS = KernelPackage.COMPOSITE_ENTITY__ALL_RELATIONS;

	/**
	 * The number of structural features of the '<em>Composite Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTOR_FEATURE_COUNT = KernelPackage.COMPOSITE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.TypedCompositeActorImpl <em>Typed Composite Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.TypedCompositeActorImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypedCompositeActor()
	 * @generated
	 */
	int TYPED_COMPOSITE_ACTOR = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__NAME = COMPOSITE_ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__DISPLAY_NAME = COMPOSITE_ACTOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__ATTRIBUTES = COMPOSITE_ACTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__INHERITS_FROM = COMPOSITE_ACTOR__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__PORTS = COMPOSITE_ACTOR__PORTS;

	/**
	 * The feature id for the '<em><b>Source Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__SOURCE_ENTITIES = COMPOSITE_ACTOR__SOURCE_ENTITIES;

	/**
	 * The feature id for the '<em><b>Target Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__TARGET_ENTITIES = COMPOSITE_ACTOR__TARGET_ENTITIES;

	/**
	 * The feature id for the '<em><b>Super Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__SUPER_ENTITY = COMPOSITE_ACTOR__SUPER_ENTITY;

	/**
	 * The feature id for the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__INHERITED_ATTRIBUTES = COMPOSITE_ACTOR__INHERITED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__INHERITED_PORTS = COMPOSITE_ACTOR__INHERITED_PORTS;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__ALL_ATTRIBUTES = COMPOSITE_ACTOR__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__ALL_PORTS = COMPOSITE_ACTOR__ALL_PORTS;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__ENTITIES = COMPOSITE_ACTOR__ENTITIES;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__RELATIONS = COMPOSITE_ACTOR__RELATIONS;

	/**
	 * The feature id for the '<em><b>Merged Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__MERGED_ENTITIES = COMPOSITE_ACTOR__MERGED_ENTITIES;

	/**
	 * The feature id for the '<em><b>Inherited Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__INHERITED_RELATIONS = COMPOSITE_ACTOR__INHERITED_RELATIONS;

	/**
	 * The feature id for the '<em><b>All Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__ALL_ENTITIES = COMPOSITE_ACTOR__ALL_ENTITIES;

	/**
	 * The feature id for the '<em><b>All Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__ALL_RELATIONS = COMPOSITE_ACTOR__ALL_RELATIONS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR__TYPE_PARAMETERS = COMPOSITE_ACTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Composite Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_COMPOSITE_ACTOR_FEATURE_COUNT = COMPOSITE_ACTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.AbstractEntityActorImplImpl <em>Abstract Entity Actor Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.AbstractEntityActorImplImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAbstractEntityActorImpl()
	 * @generated
	 */
	int ABSTRACT_ENTITY_ACTOR_IMPL = 20;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ENTITY_ACTOR_IMPL__CONTAINER = ATOMIC_ACTOR_IMPL__CONTAINER;

	/**
	 * The number of structural features of the '<em>Abstract Entity Actor Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ENTITY_ACTOR_IMPL_FEATURE_COUNT = ATOMIC_ACTOR_IMPL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.EntityActorImplImpl <em>Entity Actor Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.EntityActorImplImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getEntityActorImpl()
	 * @generated
	 */
	int ENTITY_ACTOR_IMPL = 21;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_ACTOR_IMPL__CONTAINER = ABSTRACT_ENTITY_ACTOR_IMPL__CONTAINER;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_ACTOR_IMPL__ENTITY = ABSTRACT_ENTITY_ACTOR_IMPL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Actor Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_ACTOR_IMPL_FEATURE_COUNT = ABSTRACT_ENTITY_ACTOR_IMPL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.impl.EntityRefActorImplImpl <em>Entity Ref Actor Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.impl.EntityRefActorImplImpl
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getEntityRefActorImpl()
	 * @generated
	 */
	int ENTITY_REF_ACTOR_IMPL = 22;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_ACTOR_IMPL__OWNER = KernelPackage.ENTITY_REF__OWNER;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_ACTOR_IMPL__REF = KernelPackage.ENTITY_REF__REF;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_ACTOR_IMPL__RESOLVED = KernelPackage.ENTITY_REF__RESOLVED;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_ACTOR_IMPL__CONTAINER = KernelPackage.ENTITY_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Ref Actor Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REF_ACTOR_IMPL_FEATURE_COUNT = KernelPackage.ENTITY_REF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.actor.IOPortKind <em>IO Port Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.actor.IOPortKind
	 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getIOPortKind()
	 * @generated
	 */
	int IO_PORT_KIND = 23;


	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.Typeable <em>Typeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typeable</em>'.
	 * @see org.ptolemy.ecore.actor.Typeable
	 * @generated
	 */
	EClass getTypeable();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.JvmTypedObj <em>Jvm Typed Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Typed Obj</em>'.
	 * @see org.ptolemy.ecore.actor.JvmTypedObj
	 * @generated
	 */
	EClass getJvmTypedObj();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.JvmTypedObj#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.ptolemy.ecore.actor.JvmTypedObj#getType()
	 * @see #getJvmTypedObj()
	 * @generated
	 */
	EReference getJvmTypedObj_Type();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.ecore.actor.JvmTypedObj#getInferredType <em>Inferred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inferred Type</em>'.
	 * @see org.ptolemy.ecore.actor.JvmTypedObj#getInferredType()
	 * @see #getJvmTypedObj()
	 * @generated
	 */
	EReference getJvmTypedObj_InferredType();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.JvmTypedAttribute <em>Jvm Typed Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Typed Attribute</em>'.
	 * @see org.ptolemy.ecore.actor.JvmTypedAttribute
	 * @generated
	 */
	EClass getJvmTypedAttribute();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.InjectableAttribute <em>Injectable Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injectable Attribute</em>'.
	 * @see org.ptolemy.ecore.actor.InjectableAttribute
	 * @generated
	 */
	EClass getInjectableAttribute();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.ptolemy.ecore.actor.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.Variable#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.ptolemy.ecore.actor.Variable#getValueExpression()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_ValueExpression();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.ptolemy.ecore.actor.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.ActorRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref</em>'.
	 * @see org.ptolemy.ecore.actor.ActorRef
	 * @generated
	 */
	EClass getActorRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.actor.ActorRef#getParameterBindings <em>Parameter Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Bindings</em>'.
	 * @see org.ptolemy.ecore.actor.ActorRef#getParameterBindings()
	 * @see #getActorRef()
	 * @generated
	 */
	EReference getActorRef_ParameterBindings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.actor.ActorRef#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.ptolemy.ecore.actor.ActorRef#getTypeArguments()
	 * @see #getActorRef()
	 * @generated
	 */
	EReference getActorRef_TypeArguments();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.ParameterBinding <em>Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Binding</em>'.
	 * @see org.ptolemy.ecore.actor.ParameterBinding
	 * @generated
	 */
	EClass getParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.ecore.actor.ParameterBinding#getParameterRef <em>Parameter Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Ref</em>'.
	 * @see org.ptolemy.ecore.actor.ParameterBinding#getParameterRef()
	 * @see #getParameterBinding()
	 * @generated
	 */
	EReference getParameterBinding_ParameterRef();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.ParameterBinding#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.ptolemy.ecore.actor.ParameterBinding#getValueExpression()
	 * @see #getParameterBinding()
	 * @generated
	 */
	EReference getParameterBinding_ValueExpression();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.AbstractIOPort <em>Abstract IO Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract IO Port</em>'.
	 * @see org.ptolemy.ecore.actor.AbstractIOPort
	 * @generated
	 */
	EClass getAbstractIOPort();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.actor.AbstractIOPort#isMultiport <em>Multiport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiport</em>'.
	 * @see org.ptolemy.ecore.actor.AbstractIOPort#isMultiport()
	 * @see #getAbstractIOPort()
	 * @generated
	 */
	EAttribute getAbstractIOPort_Multiport();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.actor.AbstractIOPort#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.ptolemy.ecore.actor.AbstractIOPort#getWidth()
	 * @see #getAbstractIOPort()
	 * @generated
	 */
	EAttribute getAbstractIOPort_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.actor.AbstractIOPort#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see org.ptolemy.ecore.actor.AbstractIOPort#getRate()
	 * @see #getAbstractIOPort()
	 * @generated
	 */
	EAttribute getAbstractIOPort_Rate();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.IOPort <em>IO Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IO Port</em>'.
	 * @see org.ptolemy.ecore.actor.IOPort
	 * @generated
	 */
	EClass getIOPort();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.actor.IOPort#getIoKind <em>Io Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Io Kind</em>'.
	 * @see org.ptolemy.ecore.actor.IOPort#getIoKind()
	 * @see #getIOPort()
	 * @generated
	 */
	EAttribute getIOPort_IoKind();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.AbstractTypedIOPort <em>Abstract Typed IO Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Typed IO Port</em>'.
	 * @see org.ptolemy.ecore.actor.AbstractTypedIOPort
	 * @generated
	 */
	EClass getAbstractTypedIOPort();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.TypedIOPort <em>Typed IO Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed IO Port</em>'.
	 * @see org.ptolemy.ecore.actor.TypedIOPort
	 * @generated
	 */
	EClass getTypedIOPort();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see org.ptolemy.ecore.actor.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.AtomicActor <em>Atomic Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Actor</em>'.
	 * @see org.ptolemy.ecore.actor.AtomicActor
	 * @generated
	 */
	EClass getAtomicActor();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.AtomicActor#getImpl <em>Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Impl</em>'.
	 * @see org.ptolemy.ecore.actor.AtomicActor#getImpl()
	 * @see #getAtomicActor()
	 * @generated
	 */
	EReference getAtomicActor_Impl();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.AtomicActor#getInheritedImpl <em>Inherited Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inherited Impl</em>'.
	 * @see org.ptolemy.ecore.actor.AtomicActor#getInheritedImpl()
	 * @see #getAtomicActor()
	 * @generated
	 */
	EReference getAtomicActor_InheritedImpl();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.AtomicActorImpl <em>Atomic Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Actor Impl</em>'.
	 * @see org.ptolemy.ecore.actor.AtomicActorImpl
	 * @generated
	 */
	EClass getAtomicActorImpl();

	/**
	 * Returns the meta object for the container reference '{@link org.ptolemy.ecore.actor.AtomicActorImpl#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.ptolemy.ecore.actor.AtomicActorImpl#getContainer()
	 * @see #getAtomicActorImpl()
	 * @generated
	 */
	EReference getAtomicActorImpl_Container();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.TypeParameterized <em>Type Parameterized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameterized</em>'.
	 * @see org.ptolemy.ecore.actor.TypeParameterized
	 * @generated
	 */
	EClass getTypeParameterized();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.actor.TypeParameterized#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.ptolemy.ecore.actor.TypeParameterized#getTypeParameters()
	 * @see #getTypeParameterized()
	 * @generated
	 */
	EReference getTypeParameterized_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.TypeParameter <em>Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter</em>'.
	 * @see org.ptolemy.ecore.actor.TypeParameter
	 * @generated
	 */
	EClass getTypeParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.actor.TypeParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.ptolemy.ecore.actor.TypeParameter#getName()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EAttribute getTypeParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.TypeParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.ptolemy.ecore.actor.TypeParameter#getType()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EReference getTypeParameter_Type();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.TypedAtomicActor <em>Typed Atomic Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Atomic Actor</em>'.
	 * @see org.ptolemy.ecore.actor.TypedAtomicActor
	 * @generated
	 */
	EClass getTypedAtomicActor();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.CompositeActor <em>Composite Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Actor</em>'.
	 * @see org.ptolemy.ecore.actor.CompositeActor
	 * @generated
	 */
	EClass getCompositeActor();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.TypedCompositeActor <em>Typed Composite Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Composite Actor</em>'.
	 * @see org.ptolemy.ecore.actor.TypedCompositeActor
	 * @generated
	 */
	EClass getTypedCompositeActor();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.AbstractEntityActorImpl <em>Abstract Entity Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Entity Actor Impl</em>'.
	 * @see org.ptolemy.ecore.actor.AbstractEntityActorImpl
	 * @generated
	 */
	EClass getAbstractEntityActorImpl();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.EntityActorImpl <em>Entity Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Actor Impl</em>'.
	 * @see org.ptolemy.ecore.actor.EntityActorImpl
	 * @generated
	 */
	EClass getEntityActorImpl();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.actor.EntityActorImpl#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entity</em>'.
	 * @see org.ptolemy.ecore.actor.EntityActorImpl#getEntity()
	 * @see #getEntityActorImpl()
	 * @generated
	 */
	EReference getEntityActorImpl_Entity();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.actor.EntityRefActorImpl <em>Entity Ref Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Ref Actor Impl</em>'.
	 * @see org.ptolemy.ecore.actor.EntityRefActorImpl
	 * @generated
	 */
	EClass getEntityRefActorImpl();

	/**
	 * Returns the meta object for enum '{@link org.ptolemy.ecore.actor.IOPortKind <em>IO Port Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>IO Port Kind</em>'.
	 * @see org.ptolemy.ecore.actor.IOPortKind
	 * @generated
	 */
	EEnum getIOPortKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActorFactory getActorFactory();

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
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.Typeable <em>Typeable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.Typeable
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypeable()
		 * @generated
		 */
		EClass TYPEABLE = eINSTANCE.getTypeable();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.JvmTypedObjImpl <em>Jvm Typed Obj</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.JvmTypedObjImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getJvmTypedObj()
		 * @generated
		 */
		EClass JVM_TYPED_OBJ = eINSTANCE.getJvmTypedObj();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPED_OBJ__TYPE = eINSTANCE.getJvmTypedObj_Type();

		/**
		 * The meta object literal for the '<em><b>Inferred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPED_OBJ__INFERRED_TYPE = eINSTANCE.getJvmTypedObj_InferredType();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.JvmTypedAttributeImpl <em>Jvm Typed Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.JvmTypedAttributeImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getJvmTypedAttribute()
		 * @generated
		 */
		EClass JVM_TYPED_ATTRIBUTE = eINSTANCE.getJvmTypedAttribute();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.InjectableAttributeImpl <em>Injectable Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.InjectableAttributeImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getInjectableAttribute()
		 * @generated
		 */
		EClass INJECTABLE_ATTRIBUTE = eINSTANCE.getInjectableAttribute();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.VariableImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__VALUE_EXPRESSION = eINSTANCE.getVariable_ValueExpression();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.ParameterImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.ActorRefImpl <em>Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.ActorRefImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getActorRef()
		 * @generated
		 */
		EClass ACTOR_REF = eINSTANCE.getActorRef();

		/**
		 * The meta object literal for the '<em><b>Parameter Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_REF__PARAMETER_BINDINGS = eINSTANCE.getActorRef_ParameterBindings();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_REF__TYPE_ARGUMENTS = eINSTANCE.getActorRef_TypeArguments();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.ParameterBindingImpl <em>Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.ParameterBindingImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getParameterBinding()
		 * @generated
		 */
		EClass PARAMETER_BINDING = eINSTANCE.getParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Parameter Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_BINDING__PARAMETER_REF = eINSTANCE.getParameterBinding_ParameterRef();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_BINDING__VALUE_EXPRESSION = eINSTANCE.getParameterBinding_ValueExpression();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.AbstractIOPortImpl <em>Abstract IO Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.AbstractIOPortImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAbstractIOPort()
		 * @generated
		 */
		EClass ABSTRACT_IO_PORT = eINSTANCE.getAbstractIOPort();

		/**
		 * The meta object literal for the '<em><b>Multiport</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_IO_PORT__MULTIPORT = eINSTANCE.getAbstractIOPort_Multiport();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_IO_PORT__WIDTH = eINSTANCE.getAbstractIOPort_Width();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_IO_PORT__RATE = eINSTANCE.getAbstractIOPort_Rate();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.IOPortImpl <em>IO Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.IOPortImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getIOPort()
		 * @generated
		 */
		EClass IO_PORT = eINSTANCE.getIOPort();

		/**
		 * The meta object literal for the '<em><b>Io Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO_PORT__IO_KIND = eINSTANCE.getIOPort_IoKind();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl <em>Abstract Typed IO Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAbstractTypedIOPort()
		 * @generated
		 */
		EClass ABSTRACT_TYPED_IO_PORT = eINSTANCE.getAbstractTypedIOPort();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.TypedIOPortImpl <em>Typed IO Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.TypedIOPortImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypedIOPort()
		 * @generated
		 */
		EClass TYPED_IO_PORT = eINSTANCE.getTypedIOPort();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.Actor <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.Actor
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.AtomicActorImpl <em>Atomic Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.AtomicActorImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAtomicActor()
		 * @generated
		 */
		EClass ATOMIC_ACTOR = eINSTANCE.getAtomicActor();

		/**
		 * The meta object literal for the '<em><b>Impl</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_ACTOR__IMPL = eINSTANCE.getAtomicActor_Impl();

		/**
		 * The meta object literal for the '<em><b>Inherited Impl</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_ACTOR__INHERITED_IMPL = eINSTANCE.getAtomicActor_InheritedImpl();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.AtomicActorImplImpl <em>Atomic Actor Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.AtomicActorImplImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAtomicActorImpl()
		 * @generated
		 */
		EClass ATOMIC_ACTOR_IMPL = eINSTANCE.getAtomicActorImpl();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_ACTOR_IMPL__CONTAINER = eINSTANCE.getAtomicActorImpl_Container();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.TypeParameterizedImpl <em>Type Parameterized</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.TypeParameterizedImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypeParameterized()
		 * @generated
		 */
		EClass TYPE_PARAMETERIZED = eINSTANCE.getTypeParameterized();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETERIZED__TYPE_PARAMETERS = eINSTANCE.getTypeParameterized_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.TypeParameterImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypeParameter()
		 * @generated
		 */
		EClass TYPE_PARAMETER = eINSTANCE.getTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_PARAMETER__NAME = eINSTANCE.getTypeParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER__TYPE = eINSTANCE.getTypeParameter_Type();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.TypedAtomicActorImpl <em>Typed Atomic Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.TypedAtomicActorImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypedAtomicActor()
		 * @generated
		 */
		EClass TYPED_ATOMIC_ACTOR = eINSTANCE.getTypedAtomicActor();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.CompositeActorImpl <em>Composite Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.CompositeActorImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getCompositeActor()
		 * @generated
		 */
		EClass COMPOSITE_ACTOR = eINSTANCE.getCompositeActor();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.TypedCompositeActorImpl <em>Typed Composite Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.TypedCompositeActorImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getTypedCompositeActor()
		 * @generated
		 */
		EClass TYPED_COMPOSITE_ACTOR = eINSTANCE.getTypedCompositeActor();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.AbstractEntityActorImplImpl <em>Abstract Entity Actor Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.AbstractEntityActorImplImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getAbstractEntityActorImpl()
		 * @generated
		 */
		EClass ABSTRACT_ENTITY_ACTOR_IMPL = eINSTANCE.getAbstractEntityActorImpl();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.EntityActorImplImpl <em>Entity Actor Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.EntityActorImplImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getEntityActorImpl()
		 * @generated
		 */
		EClass ENTITY_ACTOR_IMPL = eINSTANCE.getEntityActorImpl();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_ACTOR_IMPL__ENTITY = eINSTANCE.getEntityActorImpl_Entity();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.impl.EntityRefActorImplImpl <em>Entity Ref Actor Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.impl.EntityRefActorImplImpl
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getEntityRefActorImpl()
		 * @generated
		 */
		EClass ENTITY_REF_ACTOR_IMPL = eINSTANCE.getEntityRefActorImpl();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.actor.IOPortKind <em>IO Port Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.actor.IOPortKind
		 * @see org.ptolemy.ecore.actor.impl.ActorPackageImpl#getIOPortKind()
		 * @generated
		 */
		EEnum IO_PORT_KIND = eINSTANCE.getIOPortKind();

	}

} //ActorPackage
