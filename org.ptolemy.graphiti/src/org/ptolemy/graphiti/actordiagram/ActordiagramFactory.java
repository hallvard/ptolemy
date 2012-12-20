/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.graphiti.actordiagram.ActordiagramPackage
 * @generated
 */
public interface ActordiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActordiagramFactory eINSTANCE = org.ptolemy.graphiti.actordiagram.impl.ActordiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Entity Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Shape</em>'.
	 * @generated
	 */
	EntityShape createEntityShape();

	/**
	 * Returns a new object of class '<em>Entity Container Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Container Shape</em>'.
	 * @generated
	 */
	EntityContainerShape createEntityContainerShape();

	/**
	 * Returns a new object of class '<em>Port Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Shape</em>'.
	 * @generated
	 */
	PortShape createPortShape();

	/**
	 * Returns a new object of class '<em>Port Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Anchor</em>'.
	 * @generated
	 */
	PortAnchor createPortAnchor();

	/**
	 * Returns a new object of class '<em>Entity Container Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Container Diagram</em>'.
	 * @generated
	 */
	EntityContainerDiagram createEntityContainerDiagram();

	/**
	 * Returns a new object of class '<em>Model Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Shape</em>'.
	 * @generated
	 */
	<M> ModelShape<M> createModelShape();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActordiagramPackage getActordiagramPackage();

} //ActordiagramFactory
