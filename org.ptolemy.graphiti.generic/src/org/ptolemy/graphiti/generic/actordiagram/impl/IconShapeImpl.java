/**
 */
package org.ptolemy.graphiti.generic.actordiagram.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;

import org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.generic.actordiagram.IconShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Icon Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.impl.IconShapeImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IconShapeImpl extends EObjectImpl implements IconShape {
	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected PlatformGraphicsAlgorithm icon;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IconShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.ICON_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformGraphicsAlgorithm getIcon() {
		if (icon != null && icon.eIsProxy()) {
			InternalEObject oldIcon = (InternalEObject)icon;
			icon = (PlatformGraphicsAlgorithm)eResolveProxy(oldIcon);
			if (icon != oldIcon) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActordiagramPackage.ICON_SHAPE__ICON, oldIcon, icon));
			}
		}
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformGraphicsAlgorithm basicGetIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(PlatformGraphicsAlgorithm newIcon) {
		PlatformGraphicsAlgorithm oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.ICON_SHAPE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActordiagramPackage.ICON_SHAPE__ICON:
				if (resolve) return getIcon();
				return basicGetIcon();
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
			case ActordiagramPackage.ICON_SHAPE__ICON:
				setIcon((PlatformGraphicsAlgorithm)newValue);
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
			case ActordiagramPackage.ICON_SHAPE__ICON:
				setIcon((PlatformGraphicsAlgorithm)null);
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
			case ActordiagramPackage.ICON_SHAPE__ICON:
				return icon != null;
		}
		return super.eIsSet(featureID);
	}

} //IconShapeImpl
