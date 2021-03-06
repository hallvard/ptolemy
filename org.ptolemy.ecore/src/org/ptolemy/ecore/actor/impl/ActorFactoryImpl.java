/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.ActorRef;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.CompositeActor;
import org.ptolemy.ecore.actor.IOPort;
import org.ptolemy.ecore.actor.IOPortKind;
import org.ptolemy.ecore.actor.JavaActorImpl;
import org.ptolemy.ecore.actor.JvmTypedAttribute;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.actor.Parameter;
import org.ptolemy.ecore.actor.ParameterBinding;
import org.ptolemy.ecore.actor.TypeParameter;
import org.ptolemy.ecore.actor.TypeParameterized;
import org.ptolemy.ecore.actor.TypedAtomicActor;
import org.ptolemy.ecore.actor.TypedCompositeActor;
import org.ptolemy.ecore.actor.TypedIOPort;
import org.ptolemy.ecore.actor.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActorFactoryImpl extends EFactoryImpl implements ActorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActorFactory init() {
		try {
			ActorFactory theActorFactory = (ActorFactory)EPackage.Registry.INSTANCE.getEFactory(ActorPackage.eNS_URI);
			if (theActorFactory != null) {
				return theActorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorFactoryImpl() {
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
			case ActorPackage.JVM_TYPED_OBJ: return createJvmTypedObj();
			case ActorPackage.JVM_TYPED_ATTRIBUTE: return createJvmTypedAttribute();
			case ActorPackage.VARIABLE: return createVariable();
			case ActorPackage.PARAMETER: return createParameter();
			case ActorPackage.ACTOR_REF: return createActorRef();
			case ActorPackage.PARAMETER_BINDING: return createParameterBinding();
			case ActorPackage.IO_PORT: return createIOPort();
			case ActorPackage.TYPED_IO_PORT: return createTypedIOPort();
			case ActorPackage.ATOMIC_ACTOR: return createAtomicActor();
			case ActorPackage.JAVA_ACTOR_IMPL: return createJavaActorImpl();
			case ActorPackage.TYPE_PARAMETERIZED: return createTypeParameterized();
			case ActorPackage.TYPE_PARAMETER: return createTypeParameter();
			case ActorPackage.TYPED_ATOMIC_ACTOR: return createTypedAtomicActor();
			case ActorPackage.COMPOSITE_ACTOR: return createCompositeActor();
			case ActorPackage.TYPED_COMPOSITE_ACTOR: return createTypedCompositeActor();
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
			case ActorPackage.IO_PORT_KIND:
				return createIOPortKindFromString(eDataType, initialValue);
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
			case ActorPackage.IO_PORT_KIND:
				return convertIOPortKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypedObj createJvmTypedObj() {
		JvmTypedObjImpl jvmTypedObj = new JvmTypedObjImpl();
		return jvmTypedObj;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypedAttribute createJvmTypedAttribute() {
		JvmTypedAttributeImpl jvmTypedAttribute = new JvmTypedAttributeImpl();
		return jvmTypedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <P extends AbstractTypedIOPort> ActorRef<P> createActorRef() {
		ActorRefImpl<P> actorRef = new ActorRefImpl<P>();
		return actorRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterBinding createParameterBinding() {
		ParameterBindingImpl parameterBinding = new ParameterBindingImpl();
		return parameterBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOPort createIOPort() {
		IOPortImpl ioPort = new IOPortImpl();
		return ioPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedIOPort createTypedIOPort() {
		TypedIOPortImpl typedIOPort = new TypedIOPortImpl();
		return typedIOPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <P extends AbstractIOPort> AtomicActor<P> createAtomicActor() {
		AtomicActorImpl<P> atomicActor = new AtomicActorImpl<P>();
		return atomicActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaActorImpl createJavaActorImpl() {
		JavaActorImplImpl javaActorImpl = new JavaActorImplImpl();
		return javaActorImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeParameterized createTypeParameterized() {
		TypeParameterizedImpl typeParameterized = new TypeParameterizedImpl();
		return typeParameterized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeParameter createTypeParameter() {
		TypeParameterImpl typeParameter = new TypeParameterImpl();
		return typeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedAtomicActor createTypedAtomicActor() {
		TypedAtomicActorImpl typedAtomicActor = new TypedAtomicActorImpl();
		return typedAtomicActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <P extends AbstractIOPort> CompositeActor<P> createCompositeActor() {
		CompositeActorImpl<P> compositeActor = new CompositeActorImpl<P>();
		return compositeActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedCompositeActor createTypedCompositeActor() {
		TypedCompositeActorImpl typedCompositeActor = new TypedCompositeActorImpl();
		return typedCompositeActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOPortKind createIOPortKindFromString(EDataType eDataType, String initialValue) {
		IOPortKind result = IOPortKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIOPortKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorPackage getActorPackage() {
		return (ActorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActorPackage getPackage() {
		return ActorPackage.eINSTANCE;
	}

} //ActorFactoryImpl
