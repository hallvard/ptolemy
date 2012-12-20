/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.kernel.KernelPackage
 * @generated
 */
public interface KernelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelFactory eINSTANCE = org.ptolemy.ecore.kernel.impl.KernelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity</em>'.
	 * @generated
	 */
	<P extends Port> Entity<P> createEntity();

	/**
	 * Returns a new object of class '<em>Entity Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Ref</em>'.
	 * @generated
	 */
	<P extends Port> EntityRef<P> createEntityRef();

	/**
	 * Returns a new object of class '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
	Port createPort();

	/**
	 * Returns a new object of class '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation</em>'.
	 * @generated
	 */
	Relation createRelation();

	/**
	 * Returns a new object of class '<em>Component Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Entity</em>'.
	 * @generated
	 */
	<P extends ComponentPort> ComponentEntity<P> createComponentEntity();

	/**
	 * Returns a new object of class '<em>Component Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Port</em>'.
	 * @generated
	 */
	ComponentPort createComponentPort();

	/**
	 * Returns a new object of class '<em>Composite Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Entity</em>'.
	 * @generated
	 */
	<P extends ComponentPort> CompositeEntity<P> createCompositeEntity();

	/**
	 * Returns a new object of class '<em>Entity Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Container</em>'.
	 * @generated
	 */
	<P extends Port> EntityContainer<P> createEntityContainer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KernelPackage getKernelPackage();

} //KernelFactory
