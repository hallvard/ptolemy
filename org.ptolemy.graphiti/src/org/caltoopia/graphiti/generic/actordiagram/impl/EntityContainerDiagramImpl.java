/**
 */
package org.caltoopia.graphiti.generic.actordiagram.impl;

import org.caltoopia.graphiti.generic.actordiagram.ActordiagramPackage;
import org.caltoopia.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.caltoopia.graphiti.generic.actordiagram.ModelShape;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.graphiti.mm.pictograms.impl.DiagramImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Container Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.caltoopia.graphiti.generic.actordiagram.impl.EntityContainerDiagramImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityContainerDiagramImpl<M> extends DiagramImpl implements EntityContainerDiagram<M> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityContainerDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.ENTITY_CONTAINER_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public M getModel() {
		M model = basicGetModel();
		return model != null && ((EObject)model).eIsProxy() ? (M)eResolveProxy((InternalEObject)model) : model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M basicGetModel() {
		// TODO: implement this method to return the 'Model' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActordiagramPackage.ENTITY_CONTAINER_DIAGRAM__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
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
			case ActordiagramPackage.ENTITY_CONTAINER_DIAGRAM__MODEL:
				return basicGetModel() != null;
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
				case ActordiagramPackage.ENTITY_CONTAINER_DIAGRAM__MODEL: return ActordiagramPackage.MODEL_SHAPE__MODEL;
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
				case ActordiagramPackage.MODEL_SHAPE__MODEL: return ActordiagramPackage.ENTITY_CONTAINER_DIAGRAM__MODEL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EntityContainerDiagramImpl
