/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.actor.ActorPackage
 * @generated
 */
public interface ActorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActorFactory eINSTANCE = org.ptolemy.ecore.actor.impl.ActorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Jvm Typed Obj</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jvm Typed Obj</em>'.
	 * @generated
	 */
	JvmTypedObj createJvmTypedObj();

	/**
	 * Returns a new object of class '<em>Injectable Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Injectable Attribute</em>'.
	 * @generated
	 */
	InjectableAttribute createInjectableAttribute();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ref</em>'.
	 * @generated
	 */
	<P extends AbstractTypedIOPort> ActorRef<P> createActorRef();

	/**
	 * Returns a new object of class '<em>Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Binding</em>'.
	 * @generated
	 */
	ParameterBinding createParameterBinding();

	/**
	 * Returns a new object of class '<em>IO Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IO Port</em>'.
	 * @generated
	 */
	IOPort createIOPort();

	/**
	 * Returns a new object of class '<em>Typed IO Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed IO Port</em>'.
	 * @generated
	 */
	TypedIOPort createTypedIOPort();

	/**
	 * Returns a new object of class '<em>Atomic Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Actor</em>'.
	 * @generated
	 */
	<P extends AbstractIOPort> AtomicActor<P> createAtomicActor();

	/**
	 * Returns a new object of class '<em>Type Parameterized</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Parameterized</em>'.
	 * @generated
	 */
	TypeParameterized createTypeParameterized();

	/**
	 * Returns a new object of class '<em>Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Parameter</em>'.
	 * @generated
	 */
	TypeParameter createTypeParameter();

	/**
	 * Returns a new object of class '<em>Typed Atomic Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Atomic Actor</em>'.
	 * @generated
	 */
	TypedAtomicActor createTypedAtomicActor();

	/**
	 * Returns a new object of class '<em>Composite Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Actor</em>'.
	 * @generated
	 */
	<P extends AbstractIOPort> CompositeActor<P> createCompositeActor();

	/**
	 * Returns a new object of class '<em>Typed Composite Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Composite Actor</em>'.
	 * @generated
	 */
	TypedCompositeActor createTypedCompositeActor();

	/**
	 * Returns a new object of class '<em>Entity Actor Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Actor Impl</em>'.
	 * @generated
	 */
	<P extends AbstractIOPort> EntityActorImpl<P> createEntityActorImpl();

	/**
	 * Returns a new object of class '<em>Entity Ref Actor Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Ref Actor Impl</em>'.
	 * @generated
	 */
	<P extends AbstractIOPort> EntityRefActorImpl<P> createEntityRefActorImpl();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActorPackage getActorPackage();

} //ActorFactory
