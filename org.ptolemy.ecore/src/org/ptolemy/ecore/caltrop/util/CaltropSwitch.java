/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.AtomicActorImpl;
import org.ptolemy.ecore.actor.JvmTypedAttribute;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.actor.Parameter;
import org.ptolemy.ecore.actor.Typeable;
import org.ptolemy.ecore.actor.Variable;
import org.ptolemy.ecore.caltrop.*;
import org.ptolemy.ecore.caltrop.ActorParameter;
import org.ptolemy.ecore.caltrop.CaltropActorImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ChannelSelector;
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
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Named;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.caltrop.CaltropPackage
 * @generated
 */
public class CaltropSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CaltropPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaltropSwitch() {
		if (modelPackage == null) {
			modelPackage = CaltropPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CaltropPackage.CALTROP_ACTOR_IMPL: {
				CaltropActorImpl<?> caltropActorImpl = (CaltropActorImpl<?>)theEObject;
				T result = caseCaltropActorImpl(caltropActorImpl);
				if (result == null) result = caseAtomicActorImpl(caltropActorImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.ACTOR_PARAMETER: {
				ActorParameter actorParameter = (ActorParameter)theEObject;
				T result = caseActorParameter(actorParameter);
				if (result == null) result = caseParameter(actorParameter);
				if (result == null) result = caseVariable(actorParameter);
				if (result == null) result = caseJvmTypedAttribute(actorParameter);
				if (result == null) result = caseAttribute(actorParameter);
				if (result == null) result = caseJvmTypedObj(actorParameter);
				if (result == null) result = caseNamedObj(actorParameter);
				if (result == null) result = caseTypeable(actorParameter);
				if (result == null) result = caseNameable(actorParameter);
				if (result == null) result = caseNamed(actorParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.TYPED_INPUT_PORT: {
				TypedInputPort typedInputPort = (TypedInputPort)theEObject;
				T result = caseTypedInputPort(typedInputPort);
				if (result == null) result = caseAbstractTypedIOPort(typedInputPort);
				if (result == null) result = caseAbstractIOPort(typedInputPort);
				if (result == null) result = caseJvmTypedObj(typedInputPort);
				if (result == null) result = caseComponentPort(typedInputPort);
				if (result == null) result = caseTypeable(typedInputPort);
				if (result == null) result = casePort(typedInputPort);
				if (result == null) result = caseNamedObj(typedInputPort);
				if (result == null) result = caseNameable(typedInputPort);
				if (result == null) result = caseNamed(typedInputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.TYPED_OUTPUT_PORT: {
				TypedOutputPort typedOutputPort = (TypedOutputPort)theEObject;
				T result = caseTypedOutputPort(typedOutputPort);
				if (result == null) result = caseAbstractTypedIOPort(typedOutputPort);
				if (result == null) result = caseAbstractIOPort(typedOutputPort);
				if (result == null) result = caseJvmTypedObj(typedOutputPort);
				if (result == null) result = caseComponentPort(typedOutputPort);
				if (result == null) result = caseTypeable(typedOutputPort);
				if (result == null) result = casePort(typedOutputPort);
				if (result == null) result = caseNamedObj(typedOutputPort);
				if (result == null) result = caseNameable(typedOutputPort);
				if (result == null) result = caseNamed(typedOutputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.STATE_VARIABLE: {
				StateVariable stateVariable = (StateVariable)theEObject;
				T result = caseStateVariable(stateVariable);
				if (result == null) result = caseVariable(stateVariable);
				if (result == null) result = caseJvmTypedAttribute(stateVariable);
				if (result == null) result = caseAttribute(stateVariable);
				if (result == null) result = caseJvmTypedObj(stateVariable);
				if (result == null) result = caseNamedObj(stateVariable);
				if (result == null) result = caseTypeable(stateVariable);
				if (result == null) result = caseNameable(stateVariable);
				if (result == null) result = caseNamed(stateVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.FIRE_ACTION: {
				FireAction fireAction = (FireAction)theEObject;
				T result = caseFireAction(fireAction);
				if (result == null) result = caseOutputAction(fireAction);
				if (result == null) result = caseNamedObj(fireAction);
				if (result == null) result = caseNameable(fireAction);
				if (result == null) result = caseNamed(fireAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.OUTPUT_ACTION: {
				OutputAction outputAction = (OutputAction)theEObject;
				T result = caseOutputAction(outputAction);
				if (result == null) result = caseNamedObj(outputAction);
				if (result == null) result = caseNameable(outputAction);
				if (result == null) result = caseNamed(outputAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.PORT_PATTERN: {
				PortPattern portPattern = (PortPattern)theEObject;
				T result = casePortPattern(portPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.INPUT_PATTERN: {
				InputPattern inputPattern = (InputPattern)theEObject;
				T result = caseInputPattern(inputPattern);
				if (result == null) result = casePortPattern(inputPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.OUTPUT_PATTERN: {
				OutputPattern outputPattern = (OutputPattern)theEObject;
				T result = caseOutputPattern(outputPattern);
				if (result == null) result = casePortPattern(outputPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.CHANNEL_SELECTOR: {
				ChannelSelector channelSelector = (ChannelSelector)theEObject;
				T result = caseChannelSelector(channelSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.EXPRESSION_CHANNEL_SELECTOR: {
				ExpressionChannelSelector expressionChannelSelector = (ExpressionChannelSelector)theEObject;
				T result = caseExpressionChannelSelector(expressionChannelSelector);
				if (result == null) result = caseChannelSelector(expressionChannelSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.KEYWORD_CHANNEL_SELECTOR: {
				KeywordChannelSelector keywordChannelSelector = (KeywordChannelSelector)theEObject;
				T result = caseKeywordChannelSelector(keywordChannelSelector);
				if (result == null) result = caseChannelSelector(keywordChannelSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CaltropPackage.OLD_ACTION_VARIABLE_VALUE_REF: {
				OldActionVariableValueRef oldActionVariableValueRef = (OldActionVariableValueRef)theEObject;
				T result = caseOldActionVariableValueRef(oldActionVariableValueRef);
				if (result == null) result = caseXAbstractFeatureCall(oldActionVariableValueRef);
				if (result == null) result = caseXExpression(oldActionVariableValueRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends AbstractIOPort> T caseCaltropActorImpl(CaltropActorImpl<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorParameter(ActorParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedInputPort(TypedInputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedOutputPort(TypedOutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateVariable(StateVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fire Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fire Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFireAction(FireAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputAction(OutputAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortPattern(PortPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPattern(InputPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPattern(OutputPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelSelector(ChannelSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Channel Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Channel Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionChannelSelector(ExpressionChannelSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Keyword Channel Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Keyword Channel Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeywordChannelSelector(KeywordChannelSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Old Action Variable Value Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Old Action Variable Value Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOldActionVariableValueRef(OldActionVariableValueRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Actor Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Actor Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends AbstractIOPort> T caseAtomicActorImpl(AtomicActorImpl<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamed(Named object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Obj</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Obj</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedObj(NamedObj object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPort(ComponentPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract IO Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract IO Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractIOPort(AbstractIOPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typeable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typeable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeable(Typeable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Typed Obj</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Typed Obj</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypedObj(JvmTypedObj object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Typed Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Typed Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypedAttribute(JvmTypedAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Typed IO Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Typed IO Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTypedIOPort(AbstractTypedIOPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExpression(XExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAbstract Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAbstract Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAbstractFeatureCall(XAbstractFeatureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CaltropSwitch
