/**
 */
package org.caltoopia.graphiti.generic.actordiagram.impl;

import org.caltoopia.graphiti.generic.actordiagram.*;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
			case ActordiagramPackage.PORT_GA: return createPortGA();
			case ActordiagramPackage.RELATION_CONNECTION: return createRelationConnection();
			case ActordiagramPackage.RELATION_SHAPE: return createRelationShape();
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
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ActordiagramPackage.EPOINT:
				return createEPointFromString(eDataType, initialValue);
			case ActordiagramPackage.EDIMENSION:
				return createEDimensionFromString(eDataType, initialValue);
			case ActordiagramPackage.ERECTANGLE:
				return createERectangleFromString(eDataType, initialValue);
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
			case ActordiagramPackage.EPOINT:
				return convertEPointToString(eDataType, instanceValue);
			case ActordiagramPackage.EDIMENSION:
				return convertEDimensionToString(eDataType, instanceValue);
			case ActordiagramPackage.ERECTANGLE:
				return convertERectangleToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public <M> EntityShape<M> createEntityShape() {
		EntityShapeImpl<M> entityShape = new EntityShapeImpl<M>();
		return entityShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <M> EntityContainerShape<M> createEntityContainerShape() {
		EntityContainerShapeImpl<M> entityContainerShape = new EntityContainerShapeImpl<M>();
		return entityContainerShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <M> PortShape<M> createPortShape() {
		PortShapeImpl<M> portShape = new PortShapeImpl<M>();
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
	public <M> PortGA<M> createPortGA() {
		PortGAImpl<M> portGA = new PortGAImpl<M>();
		return portGA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <M> RelationConnection<M> createRelationConnection() {
		RelationConnectionImpl<M> relationConnection = new RelationConnectionImpl<M>();
		return relationConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <M> RelationShape<M> createRelationShape() {
		RelationShapeImpl<M> relationShape = new RelationShapeImpl<M>();
		return relationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <M> EntityContainerDiagram<M> createEntityContainerDiagram() {
		EntityContainerDiagramImpl<M> entityContainerDiagram = new EntityContainerDiagramImpl<M>();
		return entityContainerDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createEPointFromString(EDataType eDataType, String initialValue) {
		return (Point)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPointToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension createEDimensionFromString(EDataType eDataType, String initialValue) {
		return (Dimension)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDimensionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle createERectangleFromString(EDataType eDataType, String initialValue) {
		return (Rectangle)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertERectangleToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
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
