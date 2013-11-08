/**
 */
package org.ptolemy.graphiti.generic.actordiagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.impl.ContainerShapeImpl;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.IconShape;
import org.ptolemy.graphiti.generic.actordiagram.LabelShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.impl.EntityShapeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.impl.EntityShapeImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityShapeImpl extends ContainerShapeImpl implements EntityShape {
	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected AbstractText label;

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
	protected EntityShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.ENTITY_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractText getLabel() {
		if (label != null && label.eIsProxy()) {
			InternalEObject oldLabel = (InternalEObject)label;
			label = (AbstractText)eResolveProxy(oldLabel);
			if (label != oldLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActordiagramPackage.ENTITY_SHAPE__LABEL, oldLabel, label));
			}
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractText basicGetLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(AbstractText newLabel) {
		AbstractText oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.ENTITY_SHAPE__LABEL, oldLabel, label));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActordiagramPackage.ENTITY_SHAPE__ICON, oldIcon, icon));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.ENTITY_SHAPE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActordiagramPackage.ENTITY_SHAPE__LABEL:
				if (resolve) return getLabel();
				return basicGetLabel();
			case ActordiagramPackage.ENTITY_SHAPE__ICON:
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
			case ActordiagramPackage.ENTITY_SHAPE__LABEL:
				setLabel((AbstractText)newValue);
				return;
			case ActordiagramPackage.ENTITY_SHAPE__ICON:
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
			case ActordiagramPackage.ENTITY_SHAPE__LABEL:
				setLabel((AbstractText)null);
				return;
			case ActordiagramPackage.ENTITY_SHAPE__ICON:
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
			case ActordiagramPackage.ENTITY_SHAPE__LABEL:
				return label != null;
			case ActordiagramPackage.ENTITY_SHAPE__ICON:
				return icon != null;
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
		if (baseClass == LabelShape.class) {
			switch (derivedFeatureID) {
				case ActordiagramPackage.ENTITY_SHAPE__LABEL: return ActordiagramPackage.LABEL_SHAPE__LABEL;
				default: return -1;
			}
		}
		if (baseClass == IconShape.class) {
			switch (derivedFeatureID) {
				case ActordiagramPackage.ENTITY_SHAPE__ICON: return ActordiagramPackage.ICON_SHAPE__ICON;
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
		if (baseClass == LabelShape.class) {
			switch (baseFeatureID) {
				case ActordiagramPackage.LABEL_SHAPE__LABEL: return ActordiagramPackage.ENTITY_SHAPE__LABEL;
				default: return -1;
			}
		}
		if (baseClass == IconShape.class) {
			switch (baseFeatureID) {
				case ActordiagramPackage.ICON_SHAPE__ICON: return ActordiagramPackage.ENTITY_SHAPE__ICON;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EntityShapeImpl
