/**
 */
package org.ptolemy.graphiti.generic.actordiagram;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port GA</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortGA()
 * @model
 * @generated
 */
public interface PortGA extends PlatformGraphicsAlgorithm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.ptolemy.graphiti.generic.actordiagram.EPoint"
	 * @generated
	 */
	Point getTipAnchorPoint();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.ptolemy.graphiti.generic.actordiagram.EPoint"
	 * @generated
	 */
	Point getBaseAnchorPoint();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.ptolemy.graphiti.generic.actordiagram.ERectangle"
	 * @generated
	 */
	Rectangle getTipBounds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.ptolemy.graphiti.generic.actordiagram.ERectangle"
	 * @generated
	 */
	Rectangle getBaseBounds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	PortShape getPortShape();

} // PortGA
