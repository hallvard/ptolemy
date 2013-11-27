/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.Actor;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.ActorRef;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.AtomicActorImpl;
import org.ptolemy.ecore.actor.CompositeActor;
import org.ptolemy.ecore.actor.IOPort;
import org.ptolemy.ecore.actor.JavaActorImpl;
import org.ptolemy.ecore.actor.JvmTypedAttribute;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.actor.Parameter;
import org.ptolemy.ecore.actor.ParameterBinding;
import org.ptolemy.ecore.actor.TypeParameter;
import org.ptolemy.ecore.actor.TypeParameterized;
import org.ptolemy.ecore.actor.Typeable;
import org.ptolemy.ecore.actor.TypedAtomicActor;
import org.ptolemy.ecore.actor.TypedCompositeActor;
import org.ptolemy.ecore.actor.TypedIOPort;
import org.ptolemy.ecore.actor.Variable;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.ComponentEntity;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.EntityRefOwner;
import org.ptolemy.ecore.kernel.IEntity;
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
 * @see org.ptolemy.ecore.actor.ActorPackage
 * @generated
 */
public class ActorSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorSwitch() {
		if (modelPackage == null) {
			modelPackage = ActorPackage.eINSTANCE;
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
			case ActorPackage.TYPEABLE: {
				Typeable typeable = (Typeable)theEObject;
				T result = caseTypeable(typeable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.JVM_TYPED_OBJ: {
				JvmTypedObj jvmTypedObj = (JvmTypedObj)theEObject;
				T result = caseJvmTypedObj(jvmTypedObj);
				if (result == null) result = caseNamedObj(jvmTypedObj);
				if (result == null) result = caseTypeable(jvmTypedObj);
				if (result == null) result = caseNameable(jvmTypedObj);
				if (result == null) result = caseNamed(jvmTypedObj);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.JVM_TYPED_ATTRIBUTE: {
				JvmTypedAttribute jvmTypedAttribute = (JvmTypedAttribute)theEObject;
				T result = caseJvmTypedAttribute(jvmTypedAttribute);
				if (result == null) result = caseAttribute(jvmTypedAttribute);
				if (result == null) result = caseJvmTypedObj(jvmTypedAttribute);
				if (result == null) result = caseNamedObj(jvmTypedAttribute);
				if (result == null) result = caseTypeable(jvmTypedAttribute);
				if (result == null) result = caseNameable(jvmTypedAttribute);
				if (result == null) result = caseNamed(jvmTypedAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseJvmTypedAttribute(variable);
				if (result == null) result = caseAttribute(variable);
				if (result == null) result = caseJvmTypedObj(variable);
				if (result == null) result = caseNamedObj(variable);
				if (result == null) result = caseTypeable(variable);
				if (result == null) result = caseNameable(variable);
				if (result == null) result = caseNamed(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseVariable(parameter);
				if (result == null) result = caseJvmTypedAttribute(parameter);
				if (result == null) result = caseAttribute(parameter);
				if (result == null) result = caseJvmTypedObj(parameter);
				if (result == null) result = caseNamedObj(parameter);
				if (result == null) result = caseTypeable(parameter);
				if (result == null) result = caseNameable(parameter);
				if (result == null) result = caseNamed(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.ACTOR_REF: {
				ActorRef<?> actorRef = (ActorRef<?>)theEObject;
				T result = caseActorRef(actorRef);
				if (result == null) result = caseEntityRef(actorRef);
				if (result == null) result = caseIEntity(actorRef);
				if (result == null) result = caseNameable(actorRef);
				if (result == null) result = caseNamed(actorRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.PARAMETER_BINDING: {
				ParameterBinding parameterBinding = (ParameterBinding)theEObject;
				T result = caseParameterBinding(parameterBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.ABSTRACT_IO_PORT: {
				AbstractIOPort abstractIOPort = (AbstractIOPort)theEObject;
				T result = caseAbstractIOPort(abstractIOPort);
				if (result == null) result = caseComponentPort(abstractIOPort);
				if (result == null) result = casePort(abstractIOPort);
				if (result == null) result = caseNamedObj(abstractIOPort);
				if (result == null) result = caseNameable(abstractIOPort);
				if (result == null) result = caseNamed(abstractIOPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.IO_PORT: {
				IOPort ioPort = (IOPort)theEObject;
				T result = caseIOPort(ioPort);
				if (result == null) result = caseAbstractIOPort(ioPort);
				if (result == null) result = caseComponentPort(ioPort);
				if (result == null) result = casePort(ioPort);
				if (result == null) result = caseNamedObj(ioPort);
				if (result == null) result = caseNameable(ioPort);
				if (result == null) result = caseNamed(ioPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.ABSTRACT_TYPED_IO_PORT: {
				AbstractTypedIOPort abstractTypedIOPort = (AbstractTypedIOPort)theEObject;
				T result = caseAbstractTypedIOPort(abstractTypedIOPort);
				if (result == null) result = caseAbstractIOPort(abstractTypedIOPort);
				if (result == null) result = caseJvmTypedObj(abstractTypedIOPort);
				if (result == null) result = caseComponentPort(abstractTypedIOPort);
				if (result == null) result = caseTypeable(abstractTypedIOPort);
				if (result == null) result = casePort(abstractTypedIOPort);
				if (result == null) result = caseNamedObj(abstractTypedIOPort);
				if (result == null) result = caseNameable(abstractTypedIOPort);
				if (result == null) result = caseNamed(abstractTypedIOPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.TYPED_IO_PORT: {
				TypedIOPort typedIOPort = (TypedIOPort)theEObject;
				T result = caseTypedIOPort(typedIOPort);
				if (result == null) result = caseAbstractTypedIOPort(typedIOPort);
				if (result == null) result = caseIOPort(typedIOPort);
				if (result == null) result = caseAbstractIOPort(typedIOPort);
				if (result == null) result = caseJvmTypedObj(typedIOPort);
				if (result == null) result = caseComponentPort(typedIOPort);
				if (result == null) result = caseTypeable(typedIOPort);
				if (result == null) result = casePort(typedIOPort);
				if (result == null) result = caseNamedObj(typedIOPort);
				if (result == null) result = caseNameable(typedIOPort);
				if (result == null) result = caseNamed(typedIOPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.ACTOR: {
				Actor<?> actor = (Actor<?>)theEObject;
				T result = caseActor(actor);
				if (result == null) result = caseIEntity(actor);
				if (result == null) result = caseNameable(actor);
				if (result == null) result = caseNamed(actor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.ATOMIC_ACTOR: {
				AtomicActor<?> atomicActor = (AtomicActor<?>)theEObject;
				T result = caseAtomicActor(atomicActor);
				if (result == null) result = caseEntity(atomicActor);
				if (result == null) result = caseActor(atomicActor);
				if (result == null) result = caseNamedObj(atomicActor);
				if (result == null) result = caseEntityRefOwner(atomicActor);
				if (result == null) result = caseIEntity(atomicActor);
				if (result == null) result = caseNameable(atomicActor);
				if (result == null) result = caseNamed(atomicActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.ATOMIC_ACTOR_IMPL: {
				AtomicActorImpl<?> atomicActorImpl = (AtomicActorImpl<?>)theEObject;
				T result = caseAtomicActorImpl(atomicActorImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.JAVA_ACTOR_IMPL: {
				JavaActorImpl javaActorImpl = (JavaActorImpl)theEObject;
				T result = caseJavaActorImpl(javaActorImpl);
				if (result == null) result = caseAtomicActorImpl(javaActorImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.TYPE_PARAMETERIZED: {
				TypeParameterized typeParameterized = (TypeParameterized)theEObject;
				T result = caseTypeParameterized(typeParameterized);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.TYPE_PARAMETER: {
				TypeParameter typeParameter = (TypeParameter)theEObject;
				T result = caseTypeParameter(typeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.TYPED_ATOMIC_ACTOR: {
				TypedAtomicActor typedAtomicActor = (TypedAtomicActor)theEObject;
				T result = caseTypedAtomicActor(typedAtomicActor);
				if (result == null) result = caseAtomicActor(typedAtomicActor);
				if (result == null) result = caseTypeParameterized(typedAtomicActor);
				if (result == null) result = caseEntity(typedAtomicActor);
				if (result == null) result = caseActor(typedAtomicActor);
				if (result == null) result = caseNamedObj(typedAtomicActor);
				if (result == null) result = caseEntityRefOwner(typedAtomicActor);
				if (result == null) result = caseIEntity(typedAtomicActor);
				if (result == null) result = caseNameable(typedAtomicActor);
				if (result == null) result = caseNamed(typedAtomicActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.COMPOSITE_ACTOR: {
				CompositeActor<?> compositeActor = (CompositeActor<?>)theEObject;
				T result = caseCompositeActor(compositeActor);
				if (result == null) result = caseCompositeEntity(compositeActor);
				if (result == null) result = caseActor(compositeActor);
				if (result == null) result = caseComponentEntity(compositeActor);
				if (result == null) result = caseEntityContainer(compositeActor);
				if (result == null) result = caseEntity(compositeActor);
				if (result == null) result = caseNamedObj(compositeActor);
				if (result == null) result = caseEntityRefOwner(compositeActor);
				if (result == null) result = caseIEntity(compositeActor);
				if (result == null) result = caseNameable(compositeActor);
				if (result == null) result = caseNamed(compositeActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActorPackage.TYPED_COMPOSITE_ACTOR: {
				TypedCompositeActor typedCompositeActor = (TypedCompositeActor)theEObject;
				T result = caseTypedCompositeActor(typedCompositeActor);
				if (result == null) result = caseCompositeActor(typedCompositeActor);
				if (result == null) result = caseTypeParameterized(typedCompositeActor);
				if (result == null) result = caseCompositeEntity(typedCompositeActor);
				if (result == null) result = caseActor(typedCompositeActor);
				if (result == null) result = caseComponentEntity(typedCompositeActor);
				if (result == null) result = caseEntityContainer(typedCompositeActor);
				if (result == null) result = caseEntity(typedCompositeActor);
				if (result == null) result = caseNamedObj(typedCompositeActor);
				if (result == null) result = caseEntityRefOwner(typedCompositeActor);
				if (result == null) result = caseIEntity(typedCompositeActor);
				if (result == null) result = caseNameable(typedCompositeActor);
				if (result == null) result = caseNamed(typedCompositeActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends AbstractTypedIOPort> T caseActorRef(ActorRef<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterBinding(ParameterBinding object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>IO Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IO Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOPort(IOPort object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Typed IO Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed IO Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedIOPort(TypedIOPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends AbstractIOPort> T caseActor(Actor<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends AbstractIOPort> T caseAtomicActor(AtomicActor<P> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Java Actor Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Actor Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaActorImpl(JavaActorImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Parameterized</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Parameterized</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeParameterized(TypeParameterized object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeParameter(TypeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Atomic Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Atomic Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedAtomicActor(TypedAtomicActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends AbstractIOPort> T caseCompositeActor(CompositeActor<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Composite Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Composite Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedCompositeActor(TypedCompositeActor object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Entity Ref Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Ref Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityRefOwner(EntityRefOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEntity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEntity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseIEntity(IEntity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseEntity(Entity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends ComponentPort> T caseComponentEntity(ComponentEntity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseEntityContainer(EntityContainer<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends ComponentPort> T caseCompositeEntity(CompositeEntity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseEntityRef(EntityRef<P> object) {
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

} //ActorSwitch
