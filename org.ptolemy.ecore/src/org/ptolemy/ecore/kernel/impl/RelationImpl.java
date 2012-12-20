/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.RelationImpl#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.RelationImpl#getTargetPorts <em>Target Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImpl extends NamedObjImpl implements Relation {
	/**
	 * The cached value of the '{@link #getSourcePort() <em>Source Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePort()
	 * @generated
	 * @ordered
	 */
	protected Port sourcePort;

	/**
	 * The cached value of the '{@link #getTargetPorts() <em>Target Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> targetPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntityContainer getContainer() {
		return (EntityContainer) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getSourcePort() {
		if (sourcePort != null && sourcePort.eIsProxy()) {
			InternalEObject oldSourcePort = (InternalEObject)sourcePort;
			sourcePort = (Port)eResolveProxy(oldSourcePort);
			if (sourcePort != oldSourcePort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KernelPackage.RELATION__SOURCE_PORT, oldSourcePort, sourcePort));
			}
		}
		return sourcePort;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetSourcePort() {
		return sourcePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePort(Port newSourcePort) {
		Port oldSourcePort = sourcePort;
		sourcePort = newSourcePort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.RELATION__SOURCE_PORT, oldSourcePort, sourcePort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getTargetPorts() {
		if (targetPorts == null) {
			targetPorts = new EObjectResolvingEList<Port>(Port.class, this, KernelPackage.RELATION__TARGET_PORTS);
		}
		return targetPorts;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.RELATION__SOURCE_PORT:
				if (resolve) return getSourcePort();
				return basicGetSourcePort();
			case KernelPackage.RELATION__TARGET_PORTS:
				return getTargetPorts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KernelPackage.RELATION__SOURCE_PORT:
				setSourcePort((Port)newValue);
				return;
			case KernelPackage.RELATION__TARGET_PORTS:
				getTargetPorts().clear();
				getTargetPorts().addAll((Collection<? extends Port>)newValue);
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
			case KernelPackage.RELATION__SOURCE_PORT:
				setSourcePort((Port)null);
				return;
			case KernelPackage.RELATION__TARGET_PORTS:
				getTargetPorts().clear();
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
			case KernelPackage.RELATION__SOURCE_PORT:
				return sourcePort != null;
			case KernelPackage.RELATION__TARGET_PORTS:
				return targetPorts != null && !targetPorts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	//
	
	@Override
	public String getName() {
		String name = super.getName();
		if (name == null && getContainer() != null) {
			return "r" + (getContainer().getRelations().indexOf(this) + 1);
		}
		return name;
	}

} //RelationImpl
