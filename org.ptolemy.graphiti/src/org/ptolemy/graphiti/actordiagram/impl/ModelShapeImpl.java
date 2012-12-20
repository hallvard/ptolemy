/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.ptolemy.graphiti.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.actordiagram.ModelShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.actordiagram.impl.ModelShapeImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelShapeImpl<M> extends EObjectImpl implements ModelShape<M> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActordiagramPackage.Literals.MODEL_SHAPE;
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

	public static <M extends EObject> M getModel(PictogramLink link, Class<M> clazz) {
		if (link != null) {
			for (EObject bo : link.getBusinessObjects()) {
				if (clazz.isInstance(bo)) {
					return (M) bo;
				}
			}
		}
		return null;
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
			case ActordiagramPackage.MODEL_SHAPE__MODEL:
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
			case ActordiagramPackage.MODEL_SHAPE__MODEL:
				return basicGetModel() != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelShapeImpl
