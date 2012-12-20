/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.xbase.XbasePackage;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.caltrop.ActorParameter;
import org.ptolemy.ecore.caltrop.CaltropActorImpl;
import org.ptolemy.ecore.caltrop.CaltropFactory;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ChannelSelector;
import org.ptolemy.ecore.caltrop.ChannelSelectorKeyword;
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector;
import org.ptolemy.ecore.caltrop.FireAction;
import org.ptolemy.ecore.caltrop.InputPattern;
import org.ptolemy.ecore.caltrop.KeywordChannelSelector;
import org.ptolemy.ecore.caltrop.OldActionVariableValueRef;
import org.ptolemy.ecore.caltrop.OutputAction;
import org.ptolemy.ecore.caltrop.OutputPattern;
import org.ptolemy.ecore.caltrop.PortPattern;
import org.ptolemy.ecore.caltrop.StateVariable;
import org.ptolemy.ecore.caltrop.TypedInputPort;
import org.ptolemy.ecore.caltrop.TypedOutputPort;
import org.ptolemy.ecore.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CaltropPackageImpl extends EPackageImpl implements CaltropPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caltropActorImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedInputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedOutputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fireActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionChannelSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keywordChannelSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oldActionVariableValueRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum channelSelectorKeywordEEnum = null;

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
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CaltropPackageImpl() {
		super(eNS_URI, CaltropFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CaltropPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CaltropPackage init() {
		if (isInited) return (CaltropPackage)EPackage.Registry.INSTANCE.getEPackage(CaltropPackage.eNS_URI);

		// Obtain or create and register package
		CaltropPackageImpl theCaltropPackage = (CaltropPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CaltropPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CaltropPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ActorPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCaltropPackage.createPackageContents();

		// Initialize created meta-data
		theCaltropPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCaltropPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CaltropPackage.eNS_URI, theCaltropPackage);
		return theCaltropPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaltropActorImpl() {
		return caltropActorImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaltropActorImpl_Actions() {
		return (EReference)caltropActorImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaltropActorImpl_InitActions() {
		return (EReference)caltropActorImplEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorParameter() {
		return actorParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedInputPort() {
		return typedInputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedOutputPort() {
		return typedOutputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateVariable() {
		return stateVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateVariable_Constant() {
		return (EAttribute)stateVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaltropActorImpl_Declarations() {
		return (EReference)caltropActorImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFireAction() {
		return fireActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFireAction_InputPatterns() {
		return (EReference)fireActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputAction() {
		return outputActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputAction_GuardExpression() {
		return (EReference)outputActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputAction_OutputPatterns() {
		return (EReference)outputActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputAction_BodyExpression() {
		return (EReference)outputActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortPattern() {
		return portPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortPattern_RepeatExpression() {
		return (EReference)portPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortPattern_Channels() {
		return (EReference)portPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortPattern_PortRef() {
		return (EReference)portPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPattern() {
		return inputPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputPattern_Variables() {
		return (EAttribute)inputPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPattern() {
		return outputPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPattern_ValueExpressions() {
		return (EReference)outputPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelSelector() {
		return channelSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionChannelSelector() {
		return expressionChannelSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionChannelSelector_Many() {
		return (EAttribute)expressionChannelSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionChannelSelector_KeyExpressions() {
		return (EReference)expressionChannelSelectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeywordChannelSelector() {
		return keywordChannelSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeywordChannelSelector_Keyword() {
		return (EAttribute)keywordChannelSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOldActionVariableValueRef() {
		return oldActionVariableValueRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getChannelSelectorKeyword() {
		return channelSelectorKeywordEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaltropFactory getCaltropFactory() {
		return (CaltropFactory)getEFactoryInstance();
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
		caltropActorImplEClass = createEClass(CALTROP_ACTOR_IMPL);
		createEReference(caltropActorImplEClass, CALTROP_ACTOR_IMPL__DECLARATIONS);
		createEReference(caltropActorImplEClass, CALTROP_ACTOR_IMPL__ACTIONS);
		createEReference(caltropActorImplEClass, CALTROP_ACTOR_IMPL__INIT_ACTIONS);

		actorParameterEClass = createEClass(ACTOR_PARAMETER);

		typedInputPortEClass = createEClass(TYPED_INPUT_PORT);

		typedOutputPortEClass = createEClass(TYPED_OUTPUT_PORT);

		stateVariableEClass = createEClass(STATE_VARIABLE);
		createEAttribute(stateVariableEClass, STATE_VARIABLE__CONSTANT);

		fireActionEClass = createEClass(FIRE_ACTION);
		createEReference(fireActionEClass, FIRE_ACTION__INPUT_PATTERNS);

		outputActionEClass = createEClass(OUTPUT_ACTION);
		createEReference(outputActionEClass, OUTPUT_ACTION__GUARD_EXPRESSION);
		createEReference(outputActionEClass, OUTPUT_ACTION__OUTPUT_PATTERNS);
		createEReference(outputActionEClass, OUTPUT_ACTION__BODY_EXPRESSION);

		portPatternEClass = createEClass(PORT_PATTERN);
		createEReference(portPatternEClass, PORT_PATTERN__REPEAT_EXPRESSION);
		createEReference(portPatternEClass, PORT_PATTERN__CHANNELS);
		createEReference(portPatternEClass, PORT_PATTERN__PORT_REF);

		inputPatternEClass = createEClass(INPUT_PATTERN);
		createEAttribute(inputPatternEClass, INPUT_PATTERN__VARIABLES);

		outputPatternEClass = createEClass(OUTPUT_PATTERN);
		createEReference(outputPatternEClass, OUTPUT_PATTERN__VALUE_EXPRESSIONS);

		channelSelectorEClass = createEClass(CHANNEL_SELECTOR);

		expressionChannelSelectorEClass = createEClass(EXPRESSION_CHANNEL_SELECTOR);
		createEAttribute(expressionChannelSelectorEClass, EXPRESSION_CHANNEL_SELECTOR__MANY);
		createEReference(expressionChannelSelectorEClass, EXPRESSION_CHANNEL_SELECTOR__KEY_EXPRESSIONS);

		keywordChannelSelectorEClass = createEClass(KEYWORD_CHANNEL_SELECTOR);
		createEAttribute(keywordChannelSelectorEClass, KEYWORD_CHANNEL_SELECTOR__KEYWORD);

		oldActionVariableValueRefEClass = createEClass(OLD_ACTION_VARIABLE_VALUE_REF);

		// Create enums
		channelSelectorKeywordEEnum = createEEnum(CHANNEL_SELECTOR_KEYWORD);
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
		ActorPackage theActorPackage = (ActorPackage)EPackage.Registry.INSTANCE.getEPackage(ActorPackage.eNS_URI);
		KernelPackage theKernelPackage = (KernelPackage)EPackage.Registry.INSTANCE.getEPackage(KernelPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters
		ETypeParameter caltropActorImplEClass_P = addETypeParameter(caltropActorImplEClass, "P");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theActorPackage.getAbstractIOPort());
		caltropActorImplEClass_P.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(theActorPackage.getAtomicActorImpl());
		EGenericType g2 = createEGenericType(caltropActorImplEClass_P);
		g1.getETypeArguments().add(g2);
		caltropActorImplEClass.getEGenericSuperTypes().add(g1);
		actorParameterEClass.getESuperTypes().add(theActorPackage.getParameter());
		typedInputPortEClass.getESuperTypes().add(theActorPackage.getAbstractTypedIOPort());
		typedOutputPortEClass.getESuperTypes().add(theActorPackage.getAbstractTypedIOPort());
		stateVariableEClass.getESuperTypes().add(theActorPackage.getVariable());
		fireActionEClass.getESuperTypes().add(this.getOutputAction());
		outputActionEClass.getESuperTypes().add(theKernelPackage.getNamedObj());
		inputPatternEClass.getESuperTypes().add(this.getPortPattern());
		outputPatternEClass.getESuperTypes().add(this.getPortPattern());
		expressionChannelSelectorEClass.getESuperTypes().add(this.getChannelSelector());
		keywordChannelSelectorEClass.getESuperTypes().add(this.getChannelSelector());
		oldActionVariableValueRefEClass.getESuperTypes().add(theXbasePackage.getXAbstractFeatureCall());

		// Initialize classes and features; add operations and parameters
		initEClass(caltropActorImplEClass, CaltropActorImpl.class, "CaltropActorImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaltropActorImpl_Declarations(), this.getStateVariable(), null, "declarations", null, 0, -1, CaltropActorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCaltropActorImpl_Actions(), this.getFireAction(), null, "actions", null, 0, -1, CaltropActorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCaltropActorImpl_InitActions(), this.getOutputAction(), null, "initActions", null, 0, -1, CaltropActorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorParameterEClass, ActorParameter.class, "ActorParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedInputPortEClass, TypedInputPort.class, "TypedInputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedOutputPortEClass, TypedOutputPort.class, "TypedOutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateVariableEClass, StateVariable.class, "StateVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateVariable_Constant(), ecorePackage.getEBoolean(), "constant", null, 0, 1, StateVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fireActionEClass, FireAction.class, "FireAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFireAction_InputPatterns(), this.getInputPattern(), null, "inputPatterns", null, 0, -1, FireAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputActionEClass, OutputAction.class, "OutputAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputAction_GuardExpression(), theXbasePackage.getXExpression(), null, "guardExpression", null, 0, 1, OutputAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputAction_OutputPatterns(), this.getOutputPattern(), null, "outputPatterns", null, 0, -1, OutputAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputAction_BodyExpression(), theXbasePackage.getXExpression(), null, "bodyExpression", null, 0, 1, OutputAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(outputActionEClass, this.getInputPattern(), "getInputPatterns", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(portPatternEClass, PortPattern.class, "PortPattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortPattern_RepeatExpression(), theXbasePackage.getXExpression(), null, "repeatExpression", null, 0, 1, PortPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortPattern_Channels(), this.getChannelSelector(), null, "channels", null, 0, 1, PortPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortPattern_PortRef(), theKernelPackage.getPort(), null, "portRef", null, 0, 1, PortPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(portPatternEClass, ecorePackage.getEInt(), "size", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inputPatternEClass, InputPattern.class, "InputPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputPattern_Variables(), ecorePackage.getEString(), "variables", null, 0, -1, InputPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputPatternEClass, OutputPattern.class, "OutputPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPattern_ValueExpressions(), theXbasePackage.getXExpression(), null, "valueExpressions", null, 0, -1, OutputPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(channelSelectorEClass, ChannelSelector.class, "ChannelSelector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionChannelSelectorEClass, ExpressionChannelSelector.class, "ExpressionChannelSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpressionChannelSelector_Many(), ecorePackage.getEBoolean(), "many", null, 0, 1, ExpressionChannelSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpressionChannelSelector_KeyExpressions(), theXbasePackage.getXExpression(), null, "keyExpressions", null, 0, -1, ExpressionChannelSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keywordChannelSelectorEClass, KeywordChannelSelector.class, "KeywordChannelSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeywordChannelSelector_Keyword(), this.getChannelSelectorKeyword(), "keyword", null, 0, 1, KeywordChannelSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oldActionVariableValueRefEClass, OldActionVariableValueRef.class, "OldActionVariableValueRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(channelSelectorKeywordEEnum, ChannelSelectorKeyword.class, "ChannelSelectorKeyword");
		addEEnumLiteral(channelSelectorKeywordEEnum, ChannelSelectorKeyword.ALL);
		addEEnumLiteral(channelSelectorKeywordEEnum, ChannelSelectorKeyword.ANY);

		// Create resource
		createResource(eNS_URI);
	}

} //CaltropPackageImpl
