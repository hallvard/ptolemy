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
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.kernel.impl.ComponentPortImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract IO Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AbstractIOPortImpl#isMultiport <em>Multiport</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AbstractIOPortImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.impl.AbstractIOPortImpl#getRate <em>Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractIOPortImpl extends ComponentPortImpl implements AbstractIOPort {
	/**
	 * The default value of the '{@link #isMultiport() <em>Multiport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiport()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIPORT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isMultiport() <em>Multiport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiport()
	 * @generated
	 * @ordered
	 */
	protected boolean multiport = MULTIPORT_EDEFAULT;
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getRate() <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRate()
	 * @generated
	 * @ordered
	 */
	protected static final int RATE_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getRate() <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRate()
	 * @generated
	 * @ordered
	 */
	protected int rate = RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractIOPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.ABSTRACT_IO_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInput() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOutput() {
		// TODO: implement this method
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
			case ActorPackage.ABSTRACT_IO_PORT__MULTIPORT:
				return isMultiport();
			case ActorPackage.ABSTRACT_IO_PORT__WIDTH:
				return getWidth();
			case ActorPackage.ABSTRACT_IO_PORT__RATE:
				return getRate();
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
			case ActorPackage.ABSTRACT_IO_PORT__MULTIPORT:
				setMultiport((Boolean)newValue);
				return;
			case ActorPackage.ABSTRACT_IO_PORT__RATE:
				setRate((Integer)newValue);
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
			case ActorPackage.ABSTRACT_IO_PORT__MULTIPORT:
				setMultiport(MULTIPORT_EDEFAULT);
				return;
			case ActorPackage.ABSTRACT_IO_PORT__RATE:
				setRate(RATE_EDEFAULT);
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
			case ActorPackage.ABSTRACT_IO_PORT__MULTIPORT:
				return multiport != MULTIPORT_EDEFAULT;
			case ActorPackage.ABSTRACT_IO_PORT__WIDTH:
				return getWidth() != WIDTH_EDEFAULT;
			case ActorPackage.ABSTRACT_IO_PORT__RATE:
				return rate != RATE_EDEFAULT;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiport() {
		return multiport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiport(boolean newMultiport) {
		boolean oldMultiport = multiport;
		multiport = newMultiport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ABSTRACT_IO_PORT__MULTIPORT, oldMultiport, multiport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getWidth() {
		if (isMultiport()) {
			return getIncomingLinks().size();
		}
		return 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRate(int newRate) {
		int oldRate = rate;
		rate = newRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActorPackage.ABSTRACT_IO_PORT__RATE, oldRate, rate));
	}

//	// support default name computation
//
//	@Override
//	protected String getDefaultBaseName() {
//		if (isInput() && isOutput()) {
//			return "io";
//		} else if (isInput()) {
//			return "input";
//		} else if (isOutput()) {
//			return "output";
//		}
//		return super.getDefaultBaseName();
//	}
//
//	@Override
//	protected boolean isSameKind(Nameable named) {
//		if (! super.isSameKind(named)) {
//			return false;
//		}
//		if (named instanceof AbstractIOPort) {
//			AbstractIOPort ioPort = (AbstractIOPort) named;
//			return ioPort.isInput() == this.isInput() && ioPort.isOutput() == this.isOutput();
//		}
//		return false;
//	}
	
	//

	@Override
	protected String getPortKindString() {
		String kindString = super.getPortKindString();
		if (isInput() && isOutput()) {
			kindString = ">|>";
		} else if (isInput()) {
			kindString = ">|";
		} else if (isOutput()) {
			kindString = "|>";
		}
		return (isMultiport() ? kindString + "*" : kindString);
	}
	
} //AbstractIOPortImpl
