/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.IOPort;
import org.ptolemy.ecore.actor.IOPortKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IO Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.IOPortImpl#getIoKind <em>Io Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IOPortImpl extends AbstractIOPortImpl implements IOPort {
	/**
	 * The default value of the '{@link #getIoKind() <em>Io Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIoKind()
	 * @generated
	 * @ordered
	 */
	protected static final IOPortKind IO_KIND_EDEFAULT = IOPortKind.UNSPECIFIED;
	/**
	 * The cached value of the '{@link #getIoKind() <em>Io Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIoKind()
	 * @generated
	 * @ordered
	 */
	protected IOPortKind ioKind = IO_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IOPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.IO_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOPortKind getIoKind() {
		return ioKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIoKind(IOPortKind newIoKind) {
		IOPortKind oldIoKind = ioKind;
		ioKind = newIoKind == null ? IO_KIND_EDEFAULT : newIoKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.IO_PORT__IO_KIND, oldIoKind, ioKind));
	}

	@Override
	public boolean isInput() {
		return ioKind == IOPortKind.INPUT || ioKind == IOPortKind.INPUT_OUTPUT;
	}

	@Override
	public boolean isOutput() {
		return ioKind == IOPortKind.OUTPUT || ioKind == IOPortKind.INPUT_OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActorPackage.IO_PORT__IO_KIND:
				return getIoKind();
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
			case ActorPackage.IO_PORT__IO_KIND:
				setIoKind((IOPortKind)newValue);
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
			case ActorPackage.IO_PORT__IO_KIND:
				setIoKind(IO_KIND_EDEFAULT);
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
			case ActorPackage.IO_PORT__IO_KIND:
				return ioKind != IO_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} //IOPortImpl
