/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.impl.ShapeImpl;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.actordiagram.ModelShape;
import org.ptolemy.graphiti.actordiagram.PortAnchor;
import org.ptolemy.graphiti.actordiagram.PortShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#getOutsideAnchor <em>Outside Anchor</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#getInsideAnchor <em>Inside Anchor</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#isFilled <em>Filled</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.PortShapeImpl#isLocked <em>Locked</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortShapeImpl extends ShapeImpl implements PortShape {
	/**
	 * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final Orientation ALIGNMENT_EDEFAULT = Orientation.ALIGNMENT_CENTER;

	/**
	 * The cached value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected Orientation alignment = ALIGNMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrientation() <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation()
	 * @generated
	 * @ordered
	 */
	protected static final Orientation ORIENTATION_EDEFAULT = Orientation.ALIGNMENT_CENTER;

	/**
	 * The cached value of the '{@link #getOrientation() <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation()
	 * @generated
	 * @ordered
	 */
	protected Orientation orientation = ORIENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutsideAnchor() <em>Outside Anchor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutsideAnchor()
	 * @generated
	 * @ordered
	 */
	protected PortAnchor outsideAnchor;

	/**
	 * The cached value of the '{@link #getInsideAnchor() <em>Inside Anchor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsideAnchor()
	 * @generated
	 * @ordered
	 */
	protected PortAnchor insideAnchor;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isFilled() <em>Filled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFilled() <em>Filled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilled()
	 * @generated
	 * @ordered
	 */
	protected boolean filled = FILLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isLocked() <em>Locked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocked() <em>Locked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocked()
	 * @generated
	 * @ordered
	 */
	protected boolean locked = LOCKED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.PORT_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getModel() {
		Port model = basicGetModel();
		return model != null && ((EObject)model).eIsProxy() ? (Port)eResolveProxy((InternalEObject)model) : model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Port basicGetModel() {
		return ModelShapeImpl.getModel(link, Port.class);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Orientation getAlignment() {
		return alignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlignment(Orientation newAlignment) {
		Orientation oldAlignment = alignment;
		alignment = newAlignment == null ? ALIGNMENT_EDEFAULT : newAlignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__ALIGNMENT, oldAlignment, alignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(Orientation newOrientation) {
		Orientation oldOrientation = orientation;
		orientation = newOrientation == null ? ORIENTATION_EDEFAULT : newOrientation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__ORIENTATION, oldOrientation, orientation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortAnchor getOutsideAnchor() {
		if (outsideAnchor != null && outsideAnchor.eIsProxy()) {
			InternalEObject oldOutsideAnchor = (InternalEObject)outsideAnchor;
			outsideAnchor = (PortAnchor)eResolveProxy(oldOutsideAnchor);
			if (outsideAnchor != oldOutsideAnchor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActordiagramPackage.PORT_SHAPE__OUTSIDE_ANCHOR, oldOutsideAnchor, outsideAnchor));
			}
		}
		return outsideAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortAnchor basicGetOutsideAnchor() {
		return outsideAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutsideAnchor(PortAnchor newOutsideAnchor) {
		PortAnchor oldOutsideAnchor = outsideAnchor;
		outsideAnchor = newOutsideAnchor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__OUTSIDE_ANCHOR, oldOutsideAnchor, outsideAnchor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortAnchor getInsideAnchor() {
		if (insideAnchor != null && insideAnchor.eIsProxy()) {
			InternalEObject oldInsideAnchor = (InternalEObject)insideAnchor;
			insideAnchor = (PortAnchor)eResolveProxy(oldInsideAnchor);
			if (insideAnchor != oldInsideAnchor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActordiagramPackage.PORT_SHAPE__INSIDE_ANCHOR, oldInsideAnchor, insideAnchor));
			}
		}
		return insideAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortAnchor basicGetInsideAnchor() {
		return insideAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsideAnchor(PortAnchor newInsideAnchor) {
		PortAnchor oldInsideAnchor = insideAnchor;
		insideAnchor = newInsideAnchor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__INSIDE_ANCHOR, oldInsideAnchor, insideAnchor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilled(boolean newFilled) {
		boolean oldFilled = filled;
		filled = newFilled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__FILLED, oldFilled, filled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocked(boolean newLocked) {
		boolean oldLocked = locked;
		locked = newLocked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.PORT_SHAPE__LOCKED, oldLocked, locked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActordiagramPackage.PORT_SHAPE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case ActordiagramPackage.PORT_SHAPE__ALIGNMENT:
				return getAlignment();
			case ActordiagramPackage.PORT_SHAPE__ORIENTATION:
				return getOrientation();
			case ActordiagramPackage.PORT_SHAPE__OUTSIDE_ANCHOR:
				if (resolve) return getOutsideAnchor();
				return basicGetOutsideAnchor();
			case ActordiagramPackage.PORT_SHAPE__INSIDE_ANCHOR:
				if (resolve) return getInsideAnchor();
				return basicGetInsideAnchor();
			case ActordiagramPackage.PORT_SHAPE__SIZE:
				return getSize();
			case ActordiagramPackage.PORT_SHAPE__FILLED:
				return isFilled();
			case ActordiagramPackage.PORT_SHAPE__LOCKED:
				return isLocked();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActordiagramPackage.PORT_SHAPE__ALIGNMENT:
				setAlignment((Orientation)newValue);
				return;
			case ActordiagramPackage.PORT_SHAPE__ORIENTATION:
				setOrientation((Orientation)newValue);
				return;
			case ActordiagramPackage.PORT_SHAPE__OUTSIDE_ANCHOR:
				setOutsideAnchor((PortAnchor)newValue);
				return;
			case ActordiagramPackage.PORT_SHAPE__INSIDE_ANCHOR:
				setInsideAnchor((PortAnchor)newValue);
				return;
			case ActordiagramPackage.PORT_SHAPE__SIZE:
				setSize((Integer)newValue);
				return;
			case ActordiagramPackage.PORT_SHAPE__FILLED:
				setFilled((Boolean)newValue);
				return;
			case ActordiagramPackage.PORT_SHAPE__LOCKED:
				setLocked((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActordiagramPackage.PORT_SHAPE__ALIGNMENT:
				setAlignment(ALIGNMENT_EDEFAULT);
				return;
			case ActordiagramPackage.PORT_SHAPE__ORIENTATION:
				setOrientation(ORIENTATION_EDEFAULT);
				return;
			case ActordiagramPackage.PORT_SHAPE__OUTSIDE_ANCHOR:
				setOutsideAnchor((PortAnchor)null);
				return;
			case ActordiagramPackage.PORT_SHAPE__INSIDE_ANCHOR:
				setInsideAnchor((PortAnchor)null);
				return;
			case ActordiagramPackage.PORT_SHAPE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ActordiagramPackage.PORT_SHAPE__FILLED:
				setFilled(FILLED_EDEFAULT);
				return;
			case ActordiagramPackage.PORT_SHAPE__LOCKED:
				setLocked(LOCKED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActordiagramPackage.PORT_SHAPE__MODEL:
				return basicGetModel() != null;
			case ActordiagramPackage.PORT_SHAPE__ALIGNMENT:
				return alignment != ALIGNMENT_EDEFAULT;
			case ActordiagramPackage.PORT_SHAPE__ORIENTATION:
				return orientation != ORIENTATION_EDEFAULT;
			case ActordiagramPackage.PORT_SHAPE__OUTSIDE_ANCHOR:
				return outsideAnchor != null;
			case ActordiagramPackage.PORT_SHAPE__INSIDE_ANCHOR:
				return insideAnchor != null;
			case ActordiagramPackage.PORT_SHAPE__SIZE:
				return size != SIZE_EDEFAULT;
			case ActordiagramPackage.PORT_SHAPE__FILLED:
				return filled != FILLED_EDEFAULT;
			case ActordiagramPackage.PORT_SHAPE__LOCKED:
				return locked != LOCKED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ModelShape.class) {
			switch (derivedFeatureID) {
				case ActordiagramPackage.PORT_SHAPE__MODEL: return ActordiagramPackage.MODEL_SHAPE__MODEL;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ModelShape.class) {
			switch (baseFeatureID) {
				case ActordiagramPackage.MODEL_SHAPE__MODEL: return ActordiagramPackage.PORT_SHAPE__MODEL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (alignment: ");
		result.append(alignment);
		result.append(", orientation: ");
		result.append(orientation);
		result.append(", size: ");
		result.append(size);
		result.append(", filled: ");
		result.append(filled);
		result.append(", locked: ");
		result.append(locked);
		result.append(')');
		return result.toString();
	}

} //PortShapeImpl
