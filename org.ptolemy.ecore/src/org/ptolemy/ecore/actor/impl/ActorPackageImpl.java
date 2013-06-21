/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.XbasePackage;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.Actor;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.ActorRef;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.AtomicActorImpl;
import org.ptolemy.ecore.actor.CompositeActor;
import org.ptolemy.ecore.actor.IOPort;
import org.ptolemy.ecore.actor.IOPortKind;
import org.ptolemy.ecore.actor.InjectableAttribute;
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
import org.ptolemy.ecore.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActorPackageImpl extends EPackageImpl implements ActorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypedObjEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypedAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass injectableAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractIOPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ioPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTypedIOPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedIOPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicActorImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaActorImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeParameterizedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedAtomicActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedCompositeActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ioPortKindEEnum = null;

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
	 * @see org.ptolemy.ecore.actor.ActorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActorPackageImpl() {
		super(eNS_URI, ActorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActorPackage init() {
		if (isInited) return (ActorPackage)EPackage.Registry.INSTANCE.getEPackage(ActorPackage.eNS_URI);

		// Obtain or create and register package
		ActorPackageImpl theActorPackage = (ActorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();
		XbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theActorPackage.createPackageContents();

		// Initialize created meta-data
		theActorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActorPackage.eNS_URI, theActorPackage);
		return theActorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeable() {
		return typeableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypedObj() {
		return jvmTypedObjEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypedObj_Type() {
		return (EReference)jvmTypedObjEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypedObj_InferredType() {
		return (EReference)jvmTypedObjEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypedAttribute() {
		return jvmTypedAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInjectableAttribute() {
		return injectableAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_ValueExpression() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorRef() {
		return actorRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorRef_ParameterBindings() {
		return (EReference)actorRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorRef_TypeArguments() {
		return (EReference)actorRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterBinding() {
		return parameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterBinding_ParameterRef() {
		return (EReference)parameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterBinding_ValueExpression() {
		return (EReference)parameterBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractIOPort() {
		return abstractIOPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractIOPort_Multiport() {
		return (EAttribute)abstractIOPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractIOPort_Width() {
		return (EAttribute)abstractIOPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractIOPort_Rate() {
		return (EAttribute)abstractIOPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOPort() {
		return ioPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOPort_IoKind() {
		return (EAttribute)ioPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTypedIOPort() {
		return abstractTypedIOPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedIOPort() {
		return typedIOPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicActor() {
		return atomicActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomicActor_Impl() {
		return (EReference)atomicActorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomicActor_InheritedImpl() {
		return (EReference)atomicActorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicActorImpl() {
		return atomicActorImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomicActorImpl_Container() {
		return (EReference)atomicActorImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaActorImpl() {
		return javaActorImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaActorImpl_Type() {
		return (EReference)javaActorImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeParameterized() {
		return typeParameterizedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameterized_TypeParameters() {
		return (EReference)typeParameterizedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeParameter() {
		return typeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeParameter_Name() {
		return (EAttribute)typeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameter_Type() {
		return (EReference)typeParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedAtomicActor() {
		return typedAtomicActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeActor() {
		return compositeActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedCompositeActor() {
		return typedCompositeActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIOPortKind() {
		return ioPortKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorFactory getActorFactory() {
		return (ActorFactory)getEFactoryInstance();
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
		typeableEClass = createEClass(TYPEABLE);

		jvmTypedObjEClass = createEClass(JVM_TYPED_OBJ);
		createEReference(jvmTypedObjEClass, JVM_TYPED_OBJ__TYPE);
		createEReference(jvmTypedObjEClass, JVM_TYPED_OBJ__INFERRED_TYPE);

		jvmTypedAttributeEClass = createEClass(JVM_TYPED_ATTRIBUTE);

		injectableAttributeEClass = createEClass(INJECTABLE_ATTRIBUTE);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__VALUE_EXPRESSION);

		parameterEClass = createEClass(PARAMETER);

		actorRefEClass = createEClass(ACTOR_REF);
		createEReference(actorRefEClass, ACTOR_REF__PARAMETER_BINDINGS);
		createEReference(actorRefEClass, ACTOR_REF__TYPE_ARGUMENTS);

		parameterBindingEClass = createEClass(PARAMETER_BINDING);
		createEReference(parameterBindingEClass, PARAMETER_BINDING__PARAMETER_REF);
		createEReference(parameterBindingEClass, PARAMETER_BINDING__VALUE_EXPRESSION);

		abstractIOPortEClass = createEClass(ABSTRACT_IO_PORT);
		createEAttribute(abstractIOPortEClass, ABSTRACT_IO_PORT__MULTIPORT);
		createEAttribute(abstractIOPortEClass, ABSTRACT_IO_PORT__WIDTH);
		createEAttribute(abstractIOPortEClass, ABSTRACT_IO_PORT__RATE);

		ioPortEClass = createEClass(IO_PORT);
		createEAttribute(ioPortEClass, IO_PORT__IO_KIND);

		abstractTypedIOPortEClass = createEClass(ABSTRACT_TYPED_IO_PORT);

		typedIOPortEClass = createEClass(TYPED_IO_PORT);

		actorEClass = createEClass(ACTOR);

		atomicActorEClass = createEClass(ATOMIC_ACTOR);
		createEReference(atomicActorEClass, ATOMIC_ACTOR__IMPL);
		createEReference(atomicActorEClass, ATOMIC_ACTOR__INHERITED_IMPL);

		atomicActorImplEClass = createEClass(ATOMIC_ACTOR_IMPL);
		createEReference(atomicActorImplEClass, ATOMIC_ACTOR_IMPL__CONTAINER);

		javaActorImplEClass = createEClass(JAVA_ACTOR_IMPL);
		createEReference(javaActorImplEClass, JAVA_ACTOR_IMPL__TYPE);

		typeParameterizedEClass = createEClass(TYPE_PARAMETERIZED);
		createEReference(typeParameterizedEClass, TYPE_PARAMETERIZED__TYPE_PARAMETERS);

		typeParameterEClass = createEClass(TYPE_PARAMETER);
		createEAttribute(typeParameterEClass, TYPE_PARAMETER__NAME);
		createEReference(typeParameterEClass, TYPE_PARAMETER__TYPE);

		typedAtomicActorEClass = createEClass(TYPED_ATOMIC_ACTOR);

		compositeActorEClass = createEClass(COMPOSITE_ACTOR);

		typedCompositeActorEClass = createEClass(TYPED_COMPOSITE_ACTOR);

		// Create enums
		ioPortKindEEnum = createEEnum(IO_PORT_KIND);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		KernelPackage theKernelPackage = (KernelPackage)EPackage.Registry.INSTANCE.getEPackage(KernelPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters
		ETypeParameter actorRefEClass_P = addETypeParameter(actorRefEClass, "P");
		ETypeParameter actorEClass_P = addETypeParameter(actorEClass, "P");
		ETypeParameter atomicActorEClass_P = addETypeParameter(atomicActorEClass, "P");
		ETypeParameter atomicActorImplEClass_P = addETypeParameter(atomicActorImplEClass, "P");
		ETypeParameter compositeActorEClass_P = addETypeParameter(compositeActorEClass, "P");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getAbstractTypedIOPort());
		actorRefEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getAbstractIOPort());
		actorEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getAbstractIOPort());
		atomicActorEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getAbstractIOPort());
		atomicActorImplEClass_P.getEBounds().add(g1);
		g1 = createEGenericType(this.getAbstractIOPort());
		compositeActorEClass_P.getEBounds().add(g1);

		// Add supertypes to classes
		jvmTypedObjEClass.getESuperTypes().add(theKernelPackage.getNamedObj());
		jvmTypedObjEClass.getESuperTypes().add(this.getTypeable());
		jvmTypedAttributeEClass.getESuperTypes().add(theKernelPackage.getAttribute());
		jvmTypedAttributeEClass.getESuperTypes().add(this.getJvmTypedObj());
		injectableAttributeEClass.getESuperTypes().add(this.getJvmTypedAttribute());
		variableEClass.getESuperTypes().add(this.getJvmTypedAttribute());
		parameterEClass.getESuperTypes().add(this.getVariable());
		g1 = createEGenericType(theKernelPackage.getEntityRef());
		EGenericType g2 = createEGenericType(actorRefEClass_P);
		g1.getETypeArguments().add(g2);
		actorRefEClass.getEGenericSuperTypes().add(g1);
		abstractIOPortEClass.getESuperTypes().add(theKernelPackage.getComponentPort());
		ioPortEClass.getESuperTypes().add(this.getAbstractIOPort());
		abstractTypedIOPortEClass.getESuperTypes().add(this.getAbstractIOPort());
		abstractTypedIOPortEClass.getESuperTypes().add(this.getJvmTypedObj());
		typedIOPortEClass.getESuperTypes().add(this.getAbstractTypedIOPort());
		typedIOPortEClass.getESuperTypes().add(this.getIOPort());
		g1 = createEGenericType(theKernelPackage.getIEntity());
		g2 = createEGenericType(actorEClass_P);
		g1.getETypeArguments().add(g2);
		actorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theKernelPackage.getEntity());
		g2 = createEGenericType(atomicActorEClass_P);
		g1.getETypeArguments().add(g2);
		atomicActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getActor());
		g2 = createEGenericType(atomicActorEClass_P);
		g1.getETypeArguments().add(g2);
		atomicActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAtomicActorImpl());
		g2 = createEGenericType(this.getAbstractIOPort());
		g1.getETypeArguments().add(g2);
		javaActorImplEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAtomicActor());
		g2 = createEGenericType(this.getAbstractTypedIOPort());
		g1.getETypeArguments().add(g2);
		typedAtomicActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTypeParameterized());
		typedAtomicActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theKernelPackage.getCompositeEntity());
		g2 = createEGenericType(compositeActorEClass_P);
		g1.getETypeArguments().add(g2);
		compositeActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getActor());
		g2 = createEGenericType(compositeActorEClass_P);
		g1.getETypeArguments().add(g2);
		compositeActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCompositeActor());
		g2 = createEGenericType(this.getAbstractTypedIOPort());
		g1.getETypeArguments().add(g2);
		typedCompositeActorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTypeParameterized());
		typedCompositeActorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(typeableEClass, Typeable.class, "Typeable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(typeableEClass, theTypesPackage.getJvmTypeReference(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(typeableEClass, theTypesPackage.getJvmTypeReference(), "getInferredType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmTypedObjEClass, JvmTypedObj.class, "JvmTypedObj", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypedObj_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, JvmTypedObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmTypedObj_InferredType(), theTypesPackage.getJvmTypeReference(), null, "inferredType", null, 0, 1, JvmTypedObj.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(jvmTypedObjEClass, theTypesPackage.getJvmTypeReference(), "inferType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmTypedAttributeEClass, JvmTypedAttribute.class, "JvmTypedAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(injectableAttributeEClass, InjectableAttribute.class, "InjectableAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_ValueExpression(), theXbasePackage.getXExpression(), null, "valueExpression", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actorRefEClass, ActorRef.class, "ActorRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorRef_ParameterBindings(), this.getParameterBinding(), null, "parameterBindings", null, 0, -1, ActorRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorRef_TypeArguments(), theTypesPackage.getJvmTypeReference(), null, "typeArguments", null, 0, -1, ActorRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterBindingEClass, ParameterBinding.class, "ParameterBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterBinding_ParameterRef(), this.getParameter(), null, "parameterRef", null, 0, 1, ParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterBinding_ValueExpression(), theXbasePackage.getXExpression(), null, "valueExpression", null, 0, 1, ParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractIOPortEClass, AbstractIOPort.class, "AbstractIOPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractIOPort_Multiport(), ecorePackage.getEBoolean(), "multiport", null, 0, 1, AbstractIOPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractIOPort_Width(), ecorePackage.getEInt(), "width", null, 0, 1, AbstractIOPort.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractIOPort_Rate(), ecorePackage.getEInt(), "rate", "-1", 0, 1, AbstractIOPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(abstractIOPortEClass, ecorePackage.getEBoolean(), "isInput", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractIOPortEClass, ecorePackage.getEBoolean(), "isOutput", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ioPortEClass, IOPort.class, "IOPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIOPort_IoKind(), this.getIOPortKind(), "ioKind", null, 0, 1, IOPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTypedIOPortEClass, AbstractTypedIOPort.class, "AbstractTypedIOPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedIOPortEClass, TypedIOPort.class, "TypedIOPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actorEClass, Actor.class, "Actor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(atomicActorEClass, AtomicActor.class, "AtomicActor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getAtomicActorImpl());
		g2 = createEGenericType(atomicActorEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getAtomicActor_Impl(), g1, this.getAtomicActorImpl_Container(), "impl", null, 0, 1, AtomicActor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getAtomicActorImpl());
		g2 = createEGenericType(atomicActorEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getAtomicActor_InheritedImpl(), g1, null, "inheritedImpl", null, 0, 1, AtomicActor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicActorImplEClass, AtomicActorImpl.class, "AtomicActorImpl", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getAtomicActor());
		g2 = createEGenericType(atomicActorImplEClass_P);
		g1.getETypeArguments().add(g2);
		initEReference(getAtomicActorImpl_Container(), g1, this.getAtomicActor_Impl(), "container", null, 0, 1, AtomicActorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaActorImplEClass, JavaActorImpl.class, "JavaActorImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaActorImpl_Type(), theTypesPackage.getJvmParameterizedTypeReference(), null, "type", null, 0, 1, JavaActorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeParameterizedEClass, TypeParameterized.class, "TypeParameterized", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeParameterized_TypeParameters(), this.getTypeParameter(), null, "typeParameters", null, 0, -1, TypeParameterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeParameterEClass, TypeParameter.class, "TypeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeParameter_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, TypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedAtomicActorEClass, TypedAtomicActor.class, "TypedAtomicActor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeActorEClass, CompositeActor.class, "CompositeActor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedCompositeActorEClass, TypedCompositeActor.class, "TypedCompositeActor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(ioPortKindEEnum, IOPortKind.class, "IOPortKind");
		addEEnumLiteral(ioPortKindEEnum, IOPortKind.UNSPECIFIED);
		addEEnumLiteral(ioPortKindEEnum, IOPortKind.INPUT);
		addEEnumLiteral(ioPortKindEEnum, IOPortKind.OUTPUT);
		addEEnumLiteral(ioPortKindEEnum, IOPortKind.INPUT_OUTPUT);

		// Create resource
		createResource(eNS_URI);
	}

} //ActorPackageImpl
