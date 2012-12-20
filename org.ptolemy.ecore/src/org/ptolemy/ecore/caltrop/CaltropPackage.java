/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.XbasePackage;
import org.ptolemy.ecore.actor.ActorPackage;
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
 * @see org.ptolemy.ecore.caltrop.CaltropFactory
 * @model kind="package"
 * @generated
 */
public interface CaltropPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "caltrop";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.ptolemy.ecore.caltrop";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "caltrop";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CaltropPackage eINSTANCE = org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl <em>Actor Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getCaltropActorImpl()
	 * @generated
	 */
	int CALTROP_ACTOR_IMPL = 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALTROP_ACTOR_IMPL__CONTAINER = ActorPackage.ATOMIC_ACTOR_IMPL__CONTAINER;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALTROP_ACTOR_IMPL__DECLARATIONS = ActorPackage.ATOMIC_ACTOR_IMPL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALTROP_ACTOR_IMPL__ACTIONS = ActorPackage.ATOMIC_ACTOR_IMPL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Init Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALTROP_ACTOR_IMPL__INIT_ACTIONS = ActorPackage.ATOMIC_ACTOR_IMPL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALTROP_ACTOR_IMPL_FEATURE_COUNT = ActorPackage.ATOMIC_ACTOR_IMPL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.ActorParameterImpl <em>Actor Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.ActorParameterImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getActorParameter()
	 * @generated
	 */
	int ACTOR_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__NAME = ActorPackage.PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__DISPLAY_NAME = ActorPackage.PARAMETER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__ATTRIBUTES = ActorPackage.PARAMETER__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__INHERITS_FROM = ActorPackage.PARAMETER__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__TYPE = ActorPackage.PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__INFERRED_TYPE = ActorPackage.PARAMETER__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER__VALUE_EXPRESSION = ActorPackage.PARAMETER__VALUE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Actor Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_PARAMETER_FEATURE_COUNT = ActorPackage.PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.TypedInputPortImpl <em>Typed Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.TypedInputPortImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getTypedInputPort()
	 * @generated
	 */
	int TYPED_INPUT_PORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__NAME = ActorPackage.ABSTRACT_TYPED_IO_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__DISPLAY_NAME = ActorPackage.ABSTRACT_TYPED_IO_PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__ATTRIBUTES = ActorPackage.ABSTRACT_TYPED_IO_PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__INHERITS_FROM = ActorPackage.ABSTRACT_TYPED_IO_PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__OUTGOING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__INCOMING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__TARGET_PORTS = ActorPackage.ABSTRACT_TYPED_IO_PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__SOURCE_PORTS = ActorPackage.ABSTRACT_TYPED_IO_PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__INNER_OUTGOING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__INNER_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__INNER_INCOMING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__INNER_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__MULTIPORT = ActorPackage.ABSTRACT_TYPED_IO_PORT__MULTIPORT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__WIDTH = ActorPackage.ABSTRACT_TYPED_IO_PORT__WIDTH;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__RATE = ActorPackage.ABSTRACT_TYPED_IO_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__TYPE = ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT__INFERRED_TYPE = ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE;

	/**
	 * The number of structural features of the '<em>Typed Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_INPUT_PORT_FEATURE_COUNT = ActorPackage.ABSTRACT_TYPED_IO_PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.TypedOutputPortImpl <em>Typed Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.TypedOutputPortImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getTypedOutputPort()
	 * @generated
	 */
	int TYPED_OUTPUT_PORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__NAME = ActorPackage.ABSTRACT_TYPED_IO_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__DISPLAY_NAME = ActorPackage.ABSTRACT_TYPED_IO_PORT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__ATTRIBUTES = ActorPackage.ABSTRACT_TYPED_IO_PORT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__INHERITS_FROM = ActorPackage.ABSTRACT_TYPED_IO_PORT__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__OUTGOING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__INCOMING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Target Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__TARGET_PORTS = ActorPackage.ABSTRACT_TYPED_IO_PORT__TARGET_PORTS;

	/**
	 * The feature id for the '<em><b>Source Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__SOURCE_PORTS = ActorPackage.ABSTRACT_TYPED_IO_PORT__SOURCE_PORTS;

	/**
	 * The feature id for the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__INNER_OUTGOING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__INNER_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__INNER_INCOMING_LINKS = ActorPackage.ABSTRACT_TYPED_IO_PORT__INNER_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__MULTIPORT = ActorPackage.ABSTRACT_TYPED_IO_PORT__MULTIPORT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__WIDTH = ActorPackage.ABSTRACT_TYPED_IO_PORT__WIDTH;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__RATE = ActorPackage.ABSTRACT_TYPED_IO_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__TYPE = ActorPackage.ABSTRACT_TYPED_IO_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT__INFERRED_TYPE = ActorPackage.ABSTRACT_TYPED_IO_PORT__INFERRED_TYPE;

	/**
	 * The number of structural features of the '<em>Typed Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_OUTPUT_PORT_FEATURE_COUNT = ActorPackage.ABSTRACT_TYPED_IO_PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.StateVariableImpl <em>State Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.StateVariableImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getStateVariable()
	 * @generated
	 */
	int STATE_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__NAME = ActorPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__DISPLAY_NAME = ActorPackage.VARIABLE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__ATTRIBUTES = ActorPackage.VARIABLE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__INHERITS_FROM = ActorPackage.VARIABLE__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__TYPE = ActorPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__INFERRED_TYPE = ActorPackage.VARIABLE__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__VALUE_EXPRESSION = ActorPackage.VARIABLE__VALUE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE__CONSTANT = ActorPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_FEATURE_COUNT = ActorPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl <em>Output Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.OutputActionImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getOutputAction()
	 * @generated
	 */
	int OUTPUT_ACTION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__NAME = KernelPackage.NAMED_OBJ__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__DISPLAY_NAME = KernelPackage.NAMED_OBJ__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__ATTRIBUTES = KernelPackage.NAMED_OBJ__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__INHERITS_FROM = KernelPackage.NAMED_OBJ__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__GUARD_EXPRESSION = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__OUTPUT_PATTERNS = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__BODY_EXPRESSION = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Output Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION_FEATURE_COUNT = KernelPackage.NAMED_OBJ_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.FireActionImpl <em>Fire Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.FireActionImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getFireAction()
	 * @generated
	 */
	int FIRE_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__NAME = OUTPUT_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__DISPLAY_NAME = OUTPUT_ACTION__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__ATTRIBUTES = OUTPUT_ACTION__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__INHERITS_FROM = OUTPUT_ACTION__INHERITS_FROM;

	/**
	 * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__GUARD_EXPRESSION = OUTPUT_ACTION__GUARD_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Output Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__OUTPUT_PATTERNS = OUTPUT_ACTION__OUTPUT_PATTERNS;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__BODY_EXPRESSION = OUTPUT_ACTION__BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Input Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION__INPUT_PATTERNS = OUTPUT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fire Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRE_ACTION_FEATURE_COUNT = OUTPUT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.PortPatternImpl <em>Port Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.PortPatternImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getPortPattern()
	 * @generated
	 */
	int PORT_PATTERN = 7;

	/**
	 * The feature id for the '<em><b>Repeat Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_PATTERN__REPEAT_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_PATTERN__CHANNELS = 1;

	/**
	 * The feature id for the '<em><b>Port Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_PATTERN__PORT_REF = 2;

	/**
	 * The number of structural features of the '<em>Port Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_PATTERN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.InputPatternImpl <em>Input Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.InputPatternImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getInputPattern()
	 * @generated
	 */
	int INPUT_PATTERN = 8;

	/**
	 * The feature id for the '<em><b>Repeat Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PATTERN__REPEAT_EXPRESSION = PORT_PATTERN__REPEAT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PATTERN__CHANNELS = PORT_PATTERN__CHANNELS;

	/**
	 * The feature id for the '<em><b>Port Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PATTERN__PORT_REF = PORT_PATTERN__PORT_REF;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PATTERN__VARIABLES = PORT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PATTERN_FEATURE_COUNT = PORT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.OutputPatternImpl <em>Output Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.OutputPatternImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getOutputPattern()
	 * @generated
	 */
	int OUTPUT_PATTERN = 9;

	/**
	 * The feature id for the '<em><b>Repeat Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PATTERN__REPEAT_EXPRESSION = PORT_PATTERN__REPEAT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PATTERN__CHANNELS = PORT_PATTERN__CHANNELS;

	/**
	 * The feature id for the '<em><b>Port Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PATTERN__PORT_REF = PORT_PATTERN__PORT_REF;

	/**
	 * The feature id for the '<em><b>Value Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PATTERN__VALUE_EXPRESSIONS = PORT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PATTERN_FEATURE_COUNT = PORT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.ChannelSelectorImpl <em>Channel Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.ChannelSelectorImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getChannelSelector()
	 * @generated
	 */
	int CHANNEL_SELECTOR = 10;

	/**
	 * The number of structural features of the '<em>Channel Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SELECTOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.ExpressionChannelSelectorImpl <em>Expression Channel Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.ExpressionChannelSelectorImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getExpressionChannelSelector()
	 * @generated
	 */
	int EXPRESSION_CHANNEL_SELECTOR = 11;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_CHANNEL_SELECTOR__MANY = CHANNEL_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS = CHANNEL_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression Channel Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_CHANNEL_SELECTOR_FEATURE_COUNT = CHANNEL_SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.KeywordChannelSelectorImpl <em>Keyword Channel Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.KeywordChannelSelectorImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getKeywordChannelSelector()
	 * @generated
	 */
	int KEYWORD_CHANNEL_SELECTOR = 12;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD_CHANNEL_SELECTOR__KEYWORD = CHANNEL_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Keyword Channel Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD_CHANNEL_SELECTOR_FEATURE_COUNT = CHANNEL_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.impl.OldActionVariableValueRefImpl <em>Old Action Variable Value Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.impl.OldActionVariableValueRefImpl
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getOldActionVariableValueRef()
	 * @generated
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF = 13;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__FEATURE = XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__TYPE_ARGUMENTS = XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__IMPLICIT_RECEIVER = XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__INVALID_FEATURE_ISSUE_CODE = XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__VALID_FEATURE = XbasePackage.XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__IMPLICIT_FIRST_ARGUMENT = XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Actual Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF__ACTUAL_TYPE_ARGUMENTS = XbasePackage.XABSTRACT_FEATURE_CALL__ACTUAL_TYPE_ARGUMENTS;

	/**
	 * The number of structural features of the '<em>Old Action Variable Value Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_ACTION_VARIABLE_VALUE_REF_FEATURE_COUNT = XbasePackage.XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.ptolemy.ecore.caltrop.ChannelSelectorKeyword <em>Channel Selector Keyword</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
	 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getChannelSelectorKeyword()
	 * @generated
	 */
	int CHANNEL_SELECTOR_KEYWORD = 14;

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.CaltropActorImpl <em>Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Impl</em>'.
	 * @see org.ptolemy.ecore.caltrop.CaltropActorImpl
	 * @generated
	 */
	EClass getCaltropActorImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.ptolemy.ecore.caltrop.CaltropActorImpl#getActions()
	 * @see #getCaltropActorImpl()
	 * @generated
	 */
	EReference getCaltropActorImpl_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getInitActions <em>Init Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Init Actions</em>'.
	 * @see org.ptolemy.ecore.caltrop.CaltropActorImpl#getInitActions()
	 * @see #getCaltropActorImpl()
	 * @generated
	 */
	EReference getCaltropActorImpl_InitActions();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.ActorParameter <em>Actor Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Parameter</em>'.
	 * @see org.ptolemy.ecore.caltrop.ActorParameter
	 * @generated
	 */
	EClass getActorParameter();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.TypedInputPort <em>Typed Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Input Port</em>'.
	 * @see org.ptolemy.ecore.caltrop.TypedInputPort
	 * @generated
	 */
	EClass getTypedInputPort();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.TypedOutputPort <em>Typed Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Output Port</em>'.
	 * @see org.ptolemy.ecore.caltrop.TypedOutputPort
	 * @generated
	 */
	EClass getTypedOutputPort();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.StateVariable <em>State Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Variable</em>'.
	 * @see org.ptolemy.ecore.caltrop.StateVariable
	 * @generated
	 */
	EClass getStateVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.caltrop.StateVariable#isConstant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant</em>'.
	 * @see org.ptolemy.ecore.caltrop.StateVariable#isConstant()
	 * @see #getStateVariable()
	 * @generated
	 */
	EAttribute getStateVariable_Constant();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.ptolemy.ecore.caltrop.CaltropActorImpl#getDeclarations()
	 * @see #getCaltropActorImpl()
	 * @generated
	 */
	EReference getCaltropActorImpl_Declarations();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.FireAction <em>Fire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fire Action</em>'.
	 * @see org.ptolemy.ecore.caltrop.FireAction
	 * @generated
	 */
	EClass getFireAction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.FireAction#getInputPatterns <em>Input Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Patterns</em>'.
	 * @see org.ptolemy.ecore.caltrop.FireAction#getInputPatterns()
	 * @see #getFireAction()
	 * @generated
	 */
	EReference getFireAction_InputPatterns();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.OutputAction <em>Output Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Action</em>'.
	 * @see org.ptolemy.ecore.caltrop.OutputAction
	 * @generated
	 */
	EClass getOutputAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.caltrop.OutputAction#getGuardExpression <em>Guard Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Expression</em>'.
	 * @see org.ptolemy.ecore.caltrop.OutputAction#getGuardExpression()
	 * @see #getOutputAction()
	 * @generated
	 */
	EReference getOutputAction_GuardExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.OutputAction#getOutputPatterns <em>Output Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Patterns</em>'.
	 * @see org.ptolemy.ecore.caltrop.OutputAction#getOutputPatterns()
	 * @see #getOutputAction()
	 * @generated
	 */
	EReference getOutputAction_OutputPatterns();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.caltrop.OutputAction#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.ptolemy.ecore.caltrop.OutputAction#getBodyExpression()
	 * @see #getOutputAction()
	 * @generated
	 */
	EReference getOutputAction_BodyExpression();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.PortPattern <em>Port Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Pattern</em>'.
	 * @see org.ptolemy.ecore.caltrop.PortPattern
	 * @generated
	 */
	EClass getPortPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.caltrop.PortPattern#getRepeatExpression <em>Repeat Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Repeat Expression</em>'.
	 * @see org.ptolemy.ecore.caltrop.PortPattern#getRepeatExpression()
	 * @see #getPortPattern()
	 * @generated
	 */
	EReference getPortPattern_RepeatExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.ptolemy.ecore.caltrop.PortPattern#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channels</em>'.
	 * @see org.ptolemy.ecore.caltrop.PortPattern#getChannels()
	 * @see #getPortPattern()
	 * @generated
	 */
	EReference getPortPattern_Channels();

	/**
	 * Returns the meta object for the reference '{@link org.ptolemy.ecore.caltrop.PortPattern#getPortRef <em>Port Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Ref</em>'.
	 * @see org.ptolemy.ecore.caltrop.PortPattern#getPortRef()
	 * @see #getPortPattern()
	 * @generated
	 */
	EReference getPortPattern_PortRef();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.InputPattern <em>Input Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Pattern</em>'.
	 * @see org.ptolemy.ecore.caltrop.InputPattern
	 * @generated
	 */
	EClass getInputPattern();

	/**
	 * Returns the meta object for the attribute list '{@link org.ptolemy.ecore.caltrop.InputPattern#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Variables</em>'.
	 * @see org.ptolemy.ecore.caltrop.InputPattern#getVariables()
	 * @see #getInputPattern()
	 * @generated
	 */
	EAttribute getInputPattern_Variables();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.OutputPattern <em>Output Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Pattern</em>'.
	 * @see org.ptolemy.ecore.caltrop.OutputPattern
	 * @generated
	 */
	EClass getOutputPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.OutputPattern#getValueExpressions <em>Value Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Expressions</em>'.
	 * @see org.ptolemy.ecore.caltrop.OutputPattern#getValueExpressions()
	 * @see #getOutputPattern()
	 * @generated
	 */
	EReference getOutputPattern_ValueExpressions();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.ChannelSelector <em>Channel Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Selector</em>'.
	 * @see org.ptolemy.ecore.caltrop.ChannelSelector
	 * @generated
	 */
	EClass getChannelSelector();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector <em>Expression Channel Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Channel Selector</em>'.
	 * @see org.ptolemy.ecore.caltrop.ExpressionChannelSelector
	 * @generated
	 */
	EClass getExpressionChannelSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector#isMany <em>Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many</em>'.
	 * @see org.ptolemy.ecore.caltrop.ExpressionChannelSelector#isMany()
	 * @see #getExpressionChannelSelector()
	 * @generated
	 */
	EAttribute getExpressionChannelSelector_Many();

	/**
	 * Returns the meta object for the containment reference list '{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector#getKeyExpressions <em>Key Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Expressions</em>'.
	 * @see org.ptolemy.ecore.caltrop.ExpressionChannelSelector#getKeyExpressions()
	 * @see #getExpressionChannelSelector()
	 * @generated
	 */
	EReference getExpressionChannelSelector_KeyExpressions();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.KeywordChannelSelector <em>Keyword Channel Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyword Channel Selector</em>'.
	 * @see org.ptolemy.ecore.caltrop.KeywordChannelSelector
	 * @generated
	 */
	EClass getKeywordChannelSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.ptolemy.ecore.caltrop.KeywordChannelSelector#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see org.ptolemy.ecore.caltrop.KeywordChannelSelector#getKeyword()
	 * @see #getKeywordChannelSelector()
	 * @generated
	 */
	EAttribute getKeywordChannelSelector_Keyword();

	/**
	 * Returns the meta object for class '{@link org.ptolemy.ecore.caltrop.OldActionVariableValueRef <em>Old Action Variable Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Old Action Variable Value Ref</em>'.
	 * @see org.ptolemy.ecore.caltrop.OldActionVariableValueRef
	 * @generated
	 */
	EClass getOldActionVariableValueRef();

	/**
	 * Returns the meta object for enum '{@link org.ptolemy.ecore.caltrop.ChannelSelectorKeyword <em>Channel Selector Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Channel Selector Keyword</em>'.
	 * @see org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
	 * @generated
	 */
	EEnum getChannelSelectorKeyword();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CaltropFactory getCaltropFactory();

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
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl <em>Actor Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getCaltropActorImpl()
		 * @generated
		 */
		EClass CALTROP_ACTOR_IMPL = eINSTANCE.getCaltropActorImpl();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALTROP_ACTOR_IMPL__ACTIONS = eINSTANCE.getCaltropActorImpl_Actions();

		/**
		 * The meta object literal for the '<em><b>Init Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALTROP_ACTOR_IMPL__INIT_ACTIONS = eINSTANCE.getCaltropActorImpl_InitActions();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.ActorParameterImpl <em>Actor Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.ActorParameterImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getActorParameter()
		 * @generated
		 */
		EClass ACTOR_PARAMETER = eINSTANCE.getActorParameter();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.TypedInputPortImpl <em>Typed Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.TypedInputPortImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getTypedInputPort()
		 * @generated
		 */
		EClass TYPED_INPUT_PORT = eINSTANCE.getTypedInputPort();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.TypedOutputPortImpl <em>Typed Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.TypedOutputPortImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getTypedOutputPort()
		 * @generated
		 */
		EClass TYPED_OUTPUT_PORT = eINSTANCE.getTypedOutputPort();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.StateVariableImpl <em>State Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.StateVariableImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getStateVariable()
		 * @generated
		 */
		EClass STATE_VARIABLE = eINSTANCE.getStateVariable();

		/**
		 * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_VARIABLE__CONSTANT = eINSTANCE.getStateVariable_Constant();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALTROP_ACTOR_IMPL__DECLARATIONS = eINSTANCE.getCaltropActorImpl_Declarations();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.FireActionImpl <em>Fire Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.FireActionImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getFireAction()
		 * @generated
		 */
		EClass FIRE_ACTION = eINSTANCE.getFireAction();

		/**
		 * The meta object literal for the '<em><b>Input Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIRE_ACTION__INPUT_PATTERNS = eINSTANCE.getFireAction_InputPatterns();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.OutputActionImpl <em>Output Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.OutputActionImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getOutputAction()
		 * @generated
		 */
		EClass OUTPUT_ACTION = eINSTANCE.getOutputAction();

		/**
		 * The meta object literal for the '<em><b>Guard Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_ACTION__GUARD_EXPRESSION = eINSTANCE.getOutputAction_GuardExpression();

		/**
		 * The meta object literal for the '<em><b>Output Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_ACTION__OUTPUT_PATTERNS = eINSTANCE.getOutputAction_OutputPatterns();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_ACTION__BODY_EXPRESSION = eINSTANCE.getOutputAction_BodyExpression();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.PortPatternImpl <em>Port Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.PortPatternImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getPortPattern()
		 * @generated
		 */
		EClass PORT_PATTERN = eINSTANCE.getPortPattern();

		/**
		 * The meta object literal for the '<em><b>Repeat Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_PATTERN__REPEAT_EXPRESSION = eINSTANCE.getPortPattern_RepeatExpression();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_PATTERN__CHANNELS = eINSTANCE.getPortPattern_Channels();

		/**
		 * The meta object literal for the '<em><b>Port Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_PATTERN__PORT_REF = eINSTANCE.getPortPattern_PortRef();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.InputPatternImpl <em>Input Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.InputPatternImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getInputPattern()
		 * @generated
		 */
		EClass INPUT_PATTERN = eINSTANCE.getInputPattern();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_PATTERN__VARIABLES = eINSTANCE.getInputPattern_Variables();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.OutputPatternImpl <em>Output Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.OutputPatternImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getOutputPattern()
		 * @generated
		 */
		EClass OUTPUT_PATTERN = eINSTANCE.getOutputPattern();

		/**
		 * The meta object literal for the '<em><b>Value Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PATTERN__VALUE_EXPRESSIONS = eINSTANCE.getOutputPattern_ValueExpressions();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.ChannelSelectorImpl <em>Channel Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.ChannelSelectorImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getChannelSelector()
		 * @generated
		 */
		EClass CHANNEL_SELECTOR = eINSTANCE.getChannelSelector();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.ExpressionChannelSelectorImpl <em>Expression Channel Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.ExpressionChannelSelectorImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getExpressionChannelSelector()
		 * @generated
		 */
		EClass EXPRESSION_CHANNEL_SELECTOR = eINSTANCE.getExpressionChannelSelector();

		/**
		 * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_CHANNEL_SELECTOR__MANY = eINSTANCE.getExpressionChannelSelector_Many();

		/**
		 * The meta object literal for the '<em><b>Key Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS = eINSTANCE.getExpressionChannelSelector_KeyExpressions();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.KeywordChannelSelectorImpl <em>Keyword Channel Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.KeywordChannelSelectorImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getKeywordChannelSelector()
		 * @generated
		 */
		EClass KEYWORD_CHANNEL_SELECTOR = eINSTANCE.getKeywordChannelSelector();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEYWORD_CHANNEL_SELECTOR__KEYWORD = eINSTANCE.getKeywordChannelSelector_Keyword();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.impl.OldActionVariableValueRefImpl <em>Old Action Variable Value Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.impl.OldActionVariableValueRefImpl
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getOldActionVariableValueRef()
		 * @generated
		 */
		EClass OLD_ACTION_VARIABLE_VALUE_REF = eINSTANCE.getOldActionVariableValueRef();

		/**
		 * The meta object literal for the '{@link org.ptolemy.ecore.caltrop.ChannelSelectorKeyword <em>Channel Selector Keyword</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
		 * @see org.ptolemy.ecore.caltrop.impl.CaltropPackageImpl#getChannelSelectorKeyword()
		 * @generated
		 */
		EEnum CHANNEL_SELECTOR_KEYWORD = eINSTANCE.getChannelSelectorKeyword();

	}

} //CaltropPackage
