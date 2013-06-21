/**
 */
package org.ptolemy.graphiti.generic.actordiagram.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.impl.ShapeImpl;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.impl.RelationShapeImpl#getSourcePortShape <em>Source Port Shape</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.impl.RelationShapeImpl#getTargetPortShapes <em>Target Port Shapes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationShapeImpl extends ShapeImpl implements RelationShape {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.RELATION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortShape getSourcePortShape() {
		PortShape sourcePortShape = basicGetSourcePortShape();
		return sourcePortShape != null && sourcePortShape.eIsProxy() ? (PortShape)eResolveProxy((InternalEObject)sourcePortShape) : sourcePortShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PortShape basicGetSourcePortShape() {
		for (Anchor anchor: getAnchors()) {
			for (Connection connection : anchor.getIncomingConnections()) {
				Anchor start = connection.getStart();
				if (start == null) {
					continue;
				}
				AnchorContainer anchorParent = start.getParent();
				if (anchorParent instanceof PortShape) {
					return (PortShape) anchorParent;
				} else if (anchorParent instanceof RelationShape) {
					return ((RelationShape) anchorParent).getSourcePortShape();
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<PortShape> getTargetPortShapes() {
		EList<PortShape> portShapes = new BasicEList<PortShape>();
		addTargetPortShapes(this, portShapes);
		return portShapes;
	}

	private void addTargetPortShapes(RelationShape relationShape, EList<PortShape> portShapes) {
		for (Anchor anchor: relationShape.getAnchors()) {
			for (Connection connection : anchor.getOutgoingConnections()) {
				Anchor end = connection.getEnd();
				if (end == null) {
					continue;
				}
				AnchorContainer anchorParent = end.getParent();
				if (anchorParent instanceof PortShape) {
					portShapes.add((PortShape) anchorParent);
				} else if (anchorParent instanceof RelationShape) {
					addTargetPortShapes((RelationShape) anchorParent, portShapes);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActordiagramPackage.RELATION_SHAPE__SOURCE_PORT_SHAPE:
				if (resolve) return getSourcePortShape();
				return basicGetSourcePortShape();
			case ActordiagramPackage.RELATION_SHAPE__TARGET_PORT_SHAPES:
				return getTargetPortShapes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActordiagramPackage.RELATION_SHAPE__SOURCE_PORT_SHAPE:
				return basicGetSourcePortShape() != null;
			case ActordiagramPackage.RELATION_SHAPE__TARGET_PORT_SHAPES:
				return !getTargetPortShapes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationShapeImpl
