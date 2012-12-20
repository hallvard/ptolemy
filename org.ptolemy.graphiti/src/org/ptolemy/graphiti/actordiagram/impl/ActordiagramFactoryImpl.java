/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ptolemy.graphiti.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.actordiagram.EntityShape;
import org.ptolemy.graphiti.actordiagram.ModelShape;
import org.ptolemy.graphiti.actordiagram.PortAnchor;
import org.ptolemy.graphiti.actordiagram.PortShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActordiagramFactoryImpl extends EFactoryImpl implements ActordiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActordiagramFactory init() {
		try {
			ActordiagramFactory theActordiagramFactory = (ActordiagramFactory)EPackage.Registry.INSTANCE.getEFactory("org.ptolemy.graphiti.actordiagram"); 
			if (theActordiagramFactory != null) {
				return theActordiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActordiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActordiagramFactoryImpl() {
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
			case ActordiagramPackage.MODEL_SHAPE: return createModelShape();
			case ActordiagramPackage.ENTITY_SHAPE: return createEntityShape();
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE: return createEntityContainerShape();
			case ActordiagramPackage.PORT_SHAPE: return createPortShape();
			case ActordiagramPackage.PORT_ANCHOR: return createPortAnchor();
			case ActordiagramPackage.ENTITY_CONTAINER_DIAGRAM: return createEntityContainerDiagram();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityShape createEntityShape() {
		EntityShapeImpl entityShape = new EntityShapeImpl();
		return entityShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityContainerShape createEntityContainerShape() {
		EntityContainerShapeImpl entityContainerShape = new EntityContainerShapeImpl();
		return entityContainerShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortShape createPortShape() {
		PortShapeImpl portShape = new PortShapeImpl();
		return portShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortAnchor createPortAnchor() {
		PortAnchorImpl portAnchor = new PortAnchorImpl();
		return portAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityContainerDiagram createEntityContainerDiagram() {
		EntityContainerDiagramImpl entityContainerDiagram = new EntityContainerDiagramImpl();
		return entityContainerDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <M> ModelShape<M> createModelShape() {
		ModelShapeImpl<M> modelShape = new ModelShapeImpl<M>();
		return modelShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActordiagramPackage getActordiagramPackage() {
		return (ActordiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActordiagramPackage getPackage() {
		return ActordiagramPackage.eINSTANCE;
	}

} //ActordiagramFactoryImpl
