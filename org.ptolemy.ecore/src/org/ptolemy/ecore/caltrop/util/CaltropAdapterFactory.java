/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
import org.ptolemy.ecore.caltrop.FunctionDeclaration;
import org.ptolemy.ecore.caltrop.InputPattern;
import org.ptolemy.ecore.caltrop.KeywordChannelSelector;
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
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.caltrop.CaltropPackage
 * @generated
 */
public class CaltropAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CaltropPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaltropAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CaltropPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaltropSwitch<Adapter> modelSwitch =
		new CaltropSwitch<Adapter>() {
			@Override
			public <P extends AbstractIOPort> Adapter caseCaltropActorImpl(CaltropActorImpl<P> object) {
				return createCaltropActorImplAdapter();
			}
			@Override
			public Adapter caseActorParameter(ActorParameter object) {
				return createActorParameterAdapter();
			}
			@Override
			public Adapter caseTypedInputPort(TypedInputPort object) {
				return createTypedInputPortAdapter();
			}
			@Override
			public Adapter caseTypedOutputPort(TypedOutputPort object) {
				return createTypedOutputPortAdapter();
			}
			@Override
			public Adapter caseStateVariable(StateVariable object) {
				return createStateVariableAdapter();
			}
			@Override
			public Adapter caseFireAction(FireAction object) {
				return createFireActionAdapter();
			}
			@Override
			public Adapter caseReAction(ReAction object) {
				return createReActionAdapter();
			}
			@Override
			public Adapter caseOutputAction(OutputAction object) {
				return createOutputActionAdapter();
			}
			@Override
			public Adapter casePortPattern(PortPattern object) {
				return createPortPatternAdapter();
			}
			@Override
			public Adapter caseActionPattern(ActionPattern object) {
				return createActionPatternAdapter();
			}
			@Override
			public Adapter caseInputPattern(InputPattern object) {
				return createInputPatternAdapter();
			}
			@Override
			public Adapter caseOutputPattern(OutputPattern object) {
				return createOutputPatternAdapter();
			}
			@Override
			public Adapter caseChannelSelector(ChannelSelector object) {
				return createChannelSelectorAdapter();
			}
			@Override
			public Adapter caseExpressionChannelSelector(ExpressionChannelSelector object) {
				return createExpressionChannelSelectorAdapter();
			}
			@Override
			public Adapter caseKeywordChannelSelector(KeywordChannelSelector object) {
				return createKeywordChannelSelectorAdapter();
			}
			@Override
			public Adapter caseFunctionDeclaration(FunctionDeclaration object) {
				return createFunctionDeclarationAdapter();
			}
			@Override
			public Adapter caseSchedule(Schedule object) {
				return createScheduleAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseEventAction(EventAction object) {
				return createEventActionAdapter();
			}
			@Override
			public Adapter caseEventPattern(EventPattern object) {
				return createEventPatternAdapter();
			}
			@Override
			public Adapter caseConversionRelation(ConversionRelation object) {
				return createConversionRelationAdapter();
			}
			@Override
			public Adapter caseRealm(Realm object) {
				return createRealmAdapter();
			}
			@Override
			public <P extends AbstractIOPort> Adapter caseAtomicActorImpl(AtomicActorImpl<P> object) {
				return createAtomicActorImplAdapter();
			}
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNamedObj(NamedObj object) {
				return createNamedObjAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseTypeable(Typeable object) {
				return createTypeableAdapter();
			}
			@Override
			public Adapter caseJvmTypedObj(JvmTypedObj object) {
				return createJvmTypedObjAdapter();
			}
			@Override
			public Adapter caseJvmTypedAttribute(JvmTypedAttribute object) {
				return createJvmTypedAttributeAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseComponentPort(ComponentPort object) {
				return createComponentPortAdapter();
			}
			@Override
			public Adapter caseAbstractIOPort(AbstractIOPort object) {
				return createAbstractIOPortAdapter();
			}
			@Override
			public Adapter caseAbstractTypedIOPort(AbstractTypedIOPort object) {
				return createAbstractTypedIOPortAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.CaltropActorImpl <em>Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.CaltropActorImpl
	 * @generated
	 */
	public Adapter createCaltropActorImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.ActorParameter <em>Actor Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.ActorParameter
	 * @generated
	 */
	public Adapter createActorParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.TypedInputPort <em>Typed Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.TypedInputPort
	 * @generated
	 */
	public Adapter createTypedInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.TypedOutputPort <em>Typed Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.TypedOutputPort
	 * @generated
	 */
	public Adapter createTypedOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.StateVariable <em>State Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.StateVariable
	 * @generated
	 */
	public Adapter createStateVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.FireAction <em>Fire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.FireAction
	 * @generated
	 */
	public Adapter createFireActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.ReAction <em>Re Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.ReAction
	 * @generated
	 */
	public Adapter createReActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.OutputAction <em>Output Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.OutputAction
	 * @generated
	 */
	public Adapter createOutputActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.PortPattern <em>Port Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.PortPattern
	 * @generated
	 */
	public Adapter createPortPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.ActionPattern <em>Action Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.ActionPattern
	 * @generated
	 */
	public Adapter createActionPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.InputPattern <em>Input Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.InputPattern
	 * @generated
	 */
	public Adapter createInputPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.OutputPattern <em>Output Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.OutputPattern
	 * @generated
	 */
	public Adapter createOutputPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.ChannelSelector <em>Channel Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.ChannelSelector
	 * @generated
	 */
	public Adapter createChannelSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector <em>Expression Channel Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.ExpressionChannelSelector
	 * @generated
	 */
	public Adapter createExpressionChannelSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.KeywordChannelSelector <em>Keyword Channel Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.KeywordChannelSelector
	 * @generated
	 */
	public Adapter createKeywordChannelSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.FunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.FunctionDeclaration
	 * @generated
	 */
	public Adapter createFunctionDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.Schedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.Schedule
	 * @generated
	 */
	public Adapter createScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.EventAction <em>Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.EventAction
	 * @generated
	 */
	public Adapter createEventActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.EventPattern <em>Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.EventPattern
	 * @generated
	 */
	public Adapter createEventPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.ConversionRelation <em>Conversion Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.ConversionRelation
	 * @generated
	 */
	public Adapter createConversionRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.caltrop.Realm <em>Realm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.caltrop.Realm
	 * @generated
	 */
	public Adapter createRealmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.AtomicActorImpl <em>Atomic Actor Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.AtomicActorImpl
	 * @generated
	 */
	public Adapter createAtomicActorImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Named
	 * @generated
	 */
	public Adapter createNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.NamedObj <em>Named Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.NamedObj
	 * @generated
	 */
	public Adapter createNamedObjAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.ComponentPort <em>Component Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.ComponentPort
	 * @generated
	 */
	public Adapter createComponentPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.AbstractIOPort <em>Abstract IO Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.AbstractIOPort
	 * @generated
	 */
	public Adapter createAbstractIOPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.Typeable <em>Typeable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.Typeable
	 * @generated
	 */
	public Adapter createTypeableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.JvmTypedObj <em>Jvm Typed Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.JvmTypedObj
	 * @generated
	 */
	public Adapter createJvmTypedObjAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.JvmTypedAttribute <em>Jvm Typed Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.JvmTypedAttribute
	 * @generated
	 */
	public Adapter createJvmTypedAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.actor.AbstractTypedIOPort <em>Abstract Typed IO Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.actor.AbstractTypedIOPort
	 * @generated
	 */
	public Adapter createAbstractTypedIOPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CaltropAdapterFactory
