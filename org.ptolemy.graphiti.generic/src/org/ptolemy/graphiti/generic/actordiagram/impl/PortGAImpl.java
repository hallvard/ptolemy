/**
 */
package org.ptolemy.graphiti.generic.actordiagram.impl;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.algorithms.impl.PlatformGraphicsAlgorithmImpl;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.generic.actordiagram.PortGA;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port GA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PortGAImpl extends PlatformGraphicsAlgorithmImpl implements PortGA {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortGAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.PORT_GA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Point getTipAnchorPoint() {
		int w2 = getWidth() / 2, h2 = getHeight() / 2;
		switch (getPortShape().getOrientation()) {
		case ALIGNMENT_RIGHT: 	return new Point(getWidth() - 1, h2);
		case ALIGNMENT_LEFT: 	return new Point(0, h2);
		case ALIGNMENT_TOP: 	return new Point(w2, 0);
		case ALIGNMENT_BOTTOM: 	return new Point(w2, getHeight() - 1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Point getBaseAnchorPoint() {
		int w2 = getWidth() / 2, h2 = getHeight() / 2;
		switch (getPortShape().getOrientation()) {
		case ALIGNMENT_RIGHT: 	return new Point(0, h2);
		case ALIGNMENT_LEFT: 	return new Point(getWidth() - 1, h2);
		case ALIGNMENT_TOP: 	return new Point(w2, getHeight() - 1);
		case ALIGNMENT_BOTTOM: 	return new Point(w2, 0);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle getTipBounds() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle getBaseBounds() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PortShape getPortShape() {
		EObject container = this;
		while (container != null) {
			if (container instanceof PortShape) {
				return (PortShape) container;
			}
			container = container.eContainer();
		}
		return null;
	}

} //PortGAImpl
