/**
 */
package org.caltoopia.graphiti.generic.actordiagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.caltoopia.graphiti.generic.actordiagram.ActordiagramPackage
 * @generated
 */
public interface ActordiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActordiagramFactory eINSTANCE = org.caltoopia.graphiti.generic.actordiagram.impl.ActordiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Shape</em>'.
	 * @generated
	 */
	<M> ModelShape<M> createModelShape();

	/**
	 * Returns a new object of class '<em>Entity Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Shape</em>'.
	 * @generated
	 */
	<M> EntityShape<M> createEntityShape();

	/**
	 * Returns a new object of class '<em>Entity Container Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Container Shape</em>'.
	 * @generated
	 */
	<M> EntityContainerShape<M> createEntityContainerShape();

	/**
	 * Returns a new object of class '<em>Port Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Shape</em>'.
	 * @generated
	 */
	<M> PortShape<M> createPortShape();

	/**
	 * Returns a new object of class '<em>Port Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Anchor</em>'.
	 * @generated
	 */
	PortAnchor createPortAnchor();

	/**
	 * Returns a new object of class '<em>Port GA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port GA</em>'.
	 * @generated
	 */
	<M> PortGA<M> createPortGA();

	/**
	 * Returns a new object of class '<em>Relation Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Connection</em>'.
	 * @generated
	 */
	<M> RelationConnection<M> createRelationConnection();

	/**
	 * Returns a new object of class '<em>Relation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Shape</em>'.
	 * @generated
	 */
	<M> RelationShape<M> createRelationShape();

	/**
	 * Returns a new object of class '<em>Entity Container Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Container Diagram</em>'.
	 * @generated
	 */
	<M> EntityContainerDiagram<M> createEntityContainerDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActordiagramPackage getActordiagramPackage();

} //ActordiagramFactory
