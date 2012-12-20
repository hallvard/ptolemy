/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.kernel.ComponentEntity;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ComponentEntityImpl<P extends ComponentPort> extends EntityImpl<P> implements ComponentEntity<P> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.COMPONENT_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isAtomic() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isOpaque() {
		return true;
	}

} //ComponentEntityImpl
