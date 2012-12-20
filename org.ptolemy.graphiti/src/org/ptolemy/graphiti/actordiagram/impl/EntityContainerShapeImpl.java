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
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.pictograms.impl.ContainerShapeImpl;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.graphiti.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.actordiagram.LabelShape;
import org.ptolemy.graphiti.actordiagram.ModelShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Container Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.EntityContainerShapeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.EntityContainerShapeImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityContainerShapeImpl extends ContainerShapeImpl implements EntityContainerShape {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityContainerShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.ENTITY_CONTAINER_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityContainer<?> getModel() {
		EntityContainer<?> model = basicGetModel();
		return model != null && ((EObject)model).eIsProxy() ? (EntityContainer<?>)eResolveProxy((InternalEObject)model) : model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntityContainer<?> basicGetModel() {
		return ModelShapeImpl.getModel(link, EntityContainer.class);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL, oldLabel, label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL:
				if (resolve) return getLabel();
				return basicGetLabel();
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
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL:
				setLabel((AbstractText)newValue);
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
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL:
				setLabel((AbstractText)null);
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
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__MODEL:
				return basicGetModel() != null;
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL:
				return label != null;
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
				case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__MODEL: return ActordiagramPackage.MODEL_SHAPE__MODEL;
				default: return -1;
			}
		}
		if (baseClass == LabelShape.class) {
			switch (derivedFeatureID) {
				case ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL: return ActordiagramPackage.LABEL_SHAPE__LABEL;
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
				case ActordiagramPackage.MODEL_SHAPE__MODEL: return ActordiagramPackage.ENTITY_CONTAINER_SHAPE__MODEL;
				default: return -1;
			}
		}
		if (baseClass == LabelShape.class) {
			switch (baseFeatureID) {
				case ActordiagramPackage.LABEL_SHAPE__LABEL: return ActordiagramPackage.ENTITY_CONTAINER_SHAPE__LABEL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EntityContainerShapeImpl
