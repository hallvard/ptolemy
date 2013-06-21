/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram.impl;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ptolemy.graphiti.actordiagram.*;
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
	public PortGA createPortGA() {
		PortGAImpl portGA = new PortGAImpl();
		return portGA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationConnection createRelationConnection() {
		RelationConnectionImpl relationConnection = new RelationConnectionImpl();
		return relationConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationShape createRelationShape() {
		RelationShapeImpl relationShape = new RelationShapeImpl();
		return relationShape;
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
	 * @generated NOT
	 */
	public Point createEPointFromString(EDataType eDataType, String initialValue) {
		String[] values = initialValue.split(" ");
		int x = (values.length >= 1 ? Integer.valueOf(values[0]) : 0);
		int y = (values.length >= 2 ? Integer.valueOf(values[1]) : 0);
		return new Point(x, y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEPointToString(EDataType eDataType, Object instanceValue) {
		Point p = (Point) instanceValue;
		return p.x + " " + p.y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Dimension createEDimensionFromString(EDataType eDataType, String initialValue) {
		String[] values = initialValue.split(" ");
		int w = (values.length >= 1 ? Integer.valueOf(values[0]) : 0);
		int h = (values.length >= 2 ? Integer.valueOf(values[1]) : 0);
		return new Dimension(w, h);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEDimensionToString(EDataType eDataType, Object instanceValue) {
		Dimension d = (Dimension) instanceValue;
		return d.width + " " + d.height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Rectangle createERectangleFromString(EDataType eDataType, String initialValue) {
		String[] values = initialValue.split(" ");
		int x = (values.length >= 1 ? Integer.valueOf(values[0]) : 0);
		int y = (values.length >= 2 ? Integer.valueOf(values[1]) : 0);
		int w = (values.length >= 3 ? Integer.valueOf(values[2]) : 0);
		int h = (values.length >= 4 ? Integer.valueOf(values[3]) : 0);
		return new Rectangle(x, y, w, h);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertERectangleToString(EDataType eDataType, Object instanceValue) {
		Rectangle r = (Rectangle) instanceValue;
		return r.x + " " + r.y + " " + r.width + " " + r.height;
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
