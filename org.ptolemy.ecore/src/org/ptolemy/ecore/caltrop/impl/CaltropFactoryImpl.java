/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.caltrop.*;
import org.ptolemy.ecore.caltrop.ActionPattern;
import org.ptolemy.ecore.caltrop.ActorParameter;
import org.ptolemy.ecore.caltrop.CaltropActorImpl;
import org.ptolemy.ecore.caltrop.CaltropFactory;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ChannelSelectorKeyword;
import org.ptolemy.ecore.caltrop.EventAction;
import org.ptolemy.ecore.caltrop.EventPattern;
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector;
import org.ptolemy.ecore.caltrop.FireAction;
import org.ptolemy.ecore.caltrop.FunctionDeclaration;
import org.ptolemy.ecore.caltrop.InputPattern;
import org.ptolemy.ecore.caltrop.KeywordChannelSelector;
import org.ptolemy.ecore.caltrop.OutputAction;
import org.ptolemy.ecore.caltrop.OutputPattern;
import org.ptolemy.ecore.caltrop.ReAction;
import org.ptolemy.ecore.caltrop.Schedule;
import org.ptolemy.ecore.caltrop.State;
import org.ptolemy.ecore.caltrop.StateVariable;
import org.ptolemy.ecore.caltrop.Transition;
import org.ptolemy.ecore.caltrop.TypedInputPort;
import org.ptolemy.ecore.caltrop.TypedOutputPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CaltropFactoryImpl extends EFactoryImpl implements CaltropFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CaltropFactory init() {
		try {
			CaltropFactory theCaltropFactory = (CaltropFactory)EPackage.Registry.INSTANCE.getEFactory(CaltropPackage.eNS_URI);
			if (theCaltropFactory != null) {
				return theCaltropFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CaltropFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaltropFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CaltropPackage.CALTROP_ACTOR_IMPL: return createCaltropActorImpl();
			case CaltropPackage.ACTOR_PARAMETER: return createActorParameter();
			case CaltropPackage.TYPED_INPUT_PORT: return createTypedInputPort();
			case CaltropPackage.TYPED_OUTPUT_PORT: return createTypedOutputPort();
			case CaltropPackage.STATE_VARIABLE: return createStateVariable();
			case CaltropPackage.FIRE_ACTION: return createFireAction();
			case CaltropPackage.RE_ACTION: return createReAction();
			case CaltropPackage.OUTPUT_ACTION: return createOutputAction();
			case CaltropPackage.ACTION_PATTERN: return createActionPattern();
			case CaltropPackage.INPUT_PATTERN: return createInputPattern();
			case CaltropPackage.OUTPUT_PATTERN: return createOutputPattern();
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR: return createExpressionChannelSelector();
			case CaltropPackage.KEYWORD_CHANNEL_SELECTOR: return createKeywordChannelSelector();
			case CaltropPackage.FUNCTION_DECLARATION: return createFunctionDeclaration();
			case CaltropPackage.SCHEDULE: return createSchedule();
			case CaltropPackage.STATE: return createState();
			case CaltropPackage.TRANSITION: return createTransition();
			case CaltropPackage.EVENT_ACTION: return createEventAction();
			case CaltropPackage.EVENT_PATTERN: return createEventPattern();
			case CaltropPackage.CONVERSION_RELATION: return createConversionRelation();
			case CaltropPackage.REALM: return createRealm();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CaltropPackage.CHANNEL_SELECTOR_KEYWORD:
				return createChannelSelectorKeywordFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CaltropPackage.CHANNEL_SELECTOR_KEYWORD:
				return convertChannelSelectorKeywordToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <P extends AbstractIOPort> CaltropActorImpl<P> createCaltropActorImpl() {
		CaltropActorImplImpl<P> caltropActorImpl = new CaltropActorImplImpl<P>();
		return caltropActorImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorParameter createActorParameter() {
		ActorParameterImpl actorParameter = new ActorParameterImpl();
		return actorParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedInputPort createTypedInputPort() {
		TypedInputPortImpl typedInputPort = new TypedInputPortImpl();
		return typedInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedOutputPort createTypedOutputPort() {
		TypedOutputPortImpl typedOutputPort = new TypedOutputPortImpl();
		return typedOutputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable createStateVariable() {
		StateVariableImpl stateVariable = new StateVariableImpl();
		return stateVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FireAction createFireAction() {
		FireActionImpl fireAction = new FireActionImpl();
		return fireAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReAction createReAction() {
		ReActionImpl reAction = new ReActionImpl();
		return reAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputAction createOutputAction() {
		OutputActionImpl outputAction = new OutputActionImpl();
		return outputAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionPattern createActionPattern() {
		ActionPatternImpl actionPattern = new ActionPatternImpl();
		return actionPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPattern createInputPattern() {
		InputPatternImpl inputPattern = new InputPatternImpl();
		return inputPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPattern createOutputPattern() {
		OutputPatternImpl outputPattern = new OutputPatternImpl();
		return outputPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionChannelSelector createExpressionChannelSelector() {
		ExpressionChannelSelectorImpl expressionChannelSelector = new ExpressionChannelSelectorImpl();
		return expressionChannelSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeywordChannelSelector createKeywordChannelSelector() {
		KeywordChannelSelectorImpl keywordChannelSelector = new KeywordChannelSelectorImpl();
		return keywordChannelSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration createFunctionDeclaration() {
		FunctionDeclarationImpl functionDeclaration = new FunctionDeclarationImpl();
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedule createSchedule() {
		ScheduleImpl schedule = new ScheduleImpl();
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventAction createEventAction() {
		EventActionImpl eventAction = new EventActionImpl();
		return eventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern createEventPattern() {
		EventPatternImpl eventPattern = new EventPatternImpl();
		return eventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversionRelation createConversionRelation() {
		ConversionRelationImpl conversionRelation = new ConversionRelationImpl();
		return conversionRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realm createRealm() {
		RealmImpl realm = new RealmImpl();
		return realm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelSelectorKeyword createChannelSelectorKeywordFromString(EDataType eDataType, String initialValue) {
		ChannelSelectorKeyword result = ChannelSelectorKeyword.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertChannelSelectorKeywordToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaltropPackage getCaltropPackage() {
		return (CaltropPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CaltropPackage getPackage() {
		return CaltropPackage.eINSTANCE;
	}

} //CaltropFactoryImpl
