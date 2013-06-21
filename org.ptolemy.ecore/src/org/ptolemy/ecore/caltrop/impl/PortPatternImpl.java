/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.AtomicActorImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.ChannelSelector;
import org.ptolemy.ecore.caltrop.OutputAction;
import org.ptolemy.ecore.caltrop.PortPattern;
import org.ptolemy.ecore.kernel.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.PortPatternImpl#getRepeatExpression <em>Repeat Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.PortPatternImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.PortPatternImpl#getPortRef <em>Port Ref</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.PortPatternImpl#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PortPatternImpl extends EObjectImpl implements PortPattern {
	/**
	 * The cached value of the '{@link #getRepeatExpression() <em>Repeat Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeatExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression repeatExpression;

	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected ChannelSelector channels;

	/**
	 * The cached value of the '{@link #getPortRef() <em>Port Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortRef()
	 * @generated
	 * @ordered
	 */
	protected Port portRef;

	/**
	 * The cached value of the '{@link #getGuardExpression() <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression guardExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.PORT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getRepeatExpression() {
		return repeatExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepeatExpression(XExpression newRepeatExpression, NotificationChain msgs) {
		XExpression oldRepeatExpression = repeatExpression;
		repeatExpression = newRepeatExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION, oldRepeatExpression, newRepeatExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatExpression(XExpression newRepeatExpression) {
		if (newRepeatExpression != repeatExpression) {
			NotificationChain msgs = null;
			if (repeatExpression != null)
				msgs = ((InternalEObject)repeatExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION, null, msgs);
			if (newRepeatExpression != null)
				msgs = ((InternalEObject)newRepeatExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION, null, msgs);
			msgs = basicSetRepeatExpression(newRepeatExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION, newRepeatExpression, newRepeatExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelSelector getChannels() {
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChannels(ChannelSelector newChannels, NotificationChain msgs) {
		ChannelSelector oldChannels = channels;
		channels = newChannels;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__CHANNELS, oldChannels, newChannels);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannels(ChannelSelector newChannels) {
		if (newChannels != channels) {
			NotificationChain msgs = null;
			if (channels != null)
				msgs = ((InternalEObject)channels).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.PORT_PATTERN__CHANNELS, null, msgs);
			if (newChannels != null)
				msgs = ((InternalEObject)newChannels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.PORT_PATTERN__CHANNELS, null, msgs);
			msgs = basicSetChannels(newChannels, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__CHANNELS, newChannels, newChannels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Port getPortRef() {
		if (portRef != null && portRef.eIsProxy()) {
			InternalEObject oldPortRef = (InternalEObject)portRef;
			portRef = (Port)eResolveProxy(oldPortRef);
			if (portRef != oldPortRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaltropPackage.PORT_PATTERN__PORT_REF, oldPortRef, portRef));
			}
		}
		if (portRef != null) {
			return portRef;
		}
		return findPortRef();
	}

	private Port findPortRef() {
		if (eContainer() instanceof OutputAction) {
			OutputAction action = (OutputAction) eContainer();
			int pos = -1;
			Boolean input = null, output = null;
			if (this.eContainmentFeature() == CaltropPackage.eINSTANCE.getFireAction_InputPatterns()) {
				pos = action.getInputPatterns().indexOf(this);
				input = Boolean.TRUE;
				output = Boolean.FALSE;
			} else if (this.eContainmentFeature() == CaltropPackage.eINSTANCE.getOutputAction_OutputPatterns()) {
				pos = action.getOutputPatterns().indexOf(this);
				input = Boolean.FALSE;
				output = Boolean.TRUE;
			}
			if (pos >= 0 && input != null && output != null && action.eContainer() != null) {
				AtomicActor<AbstractIOPort> actor = ((AtomicActorImpl<AbstractIOPort>) action.eContainer()).getContainer();
				if (actor != null) {
					for (AbstractIOPort port : actor.getAllPorts()) {
						if (port.isInput() == input.booleanValue() && port.isOutput() == output.booleanValue()) {
							if (pos == 0) {
								return port;
							}
							pos--;
						}
					}
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
	public Port basicGetPortRef() {
		return portRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortRef(Port newPortRef) {
		Port oldPortRef = portRef;
		portRef = newPortRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__PORT_REF, oldPortRef, portRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getGuardExpression() {
		return guardExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardExpression(XExpression newGuardExpression, NotificationChain msgs) {
		XExpression oldGuardExpression = guardExpression;
		guardExpression = newGuardExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardExpression(XExpression newGuardExpression) {
		if (newGuardExpression != guardExpression) {
			NotificationChain msgs = null;
			if (guardExpression != null)
				msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION, null, msgs);
			if (newGuardExpression != null)
				msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION, null, msgs);
			msgs = basicSetGuardExpression(newGuardExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int size() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION:
				return basicSetRepeatExpression(null, msgs);
			case CaltropPackage.PORT_PATTERN__CHANNELS:
				return basicSetChannels(null, msgs);
			case CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION:
				return basicSetGuardExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION:
				return getRepeatExpression();
			case CaltropPackage.PORT_PATTERN__CHANNELS:
				return getChannels();
			case CaltropPackage.PORT_PATTERN__PORT_REF:
				if (resolve) return getPortRef();
				return basicGetPortRef();
			case CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION:
				return getGuardExpression();
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
			case CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION:
				setRepeatExpression((XExpression)newValue);
				return;
			case CaltropPackage.PORT_PATTERN__CHANNELS:
				setChannels((ChannelSelector)newValue);
				return;
			case CaltropPackage.PORT_PATTERN__PORT_REF:
				setPortRef((Port)newValue);
				return;
			case CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION:
				setGuardExpression((XExpression)newValue);
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
			case CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION:
				setRepeatExpression((XExpression)null);
				return;
			case CaltropPackage.PORT_PATTERN__CHANNELS:
				setChannels((ChannelSelector)null);
				return;
			case CaltropPackage.PORT_PATTERN__PORT_REF:
				setPortRef((Port)null);
				return;
			case CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION:
				setGuardExpression((XExpression)null);
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
			case CaltropPackage.PORT_PATTERN__REPEAT_EXPRESSION:
				return repeatExpression != null;
			case CaltropPackage.PORT_PATTERN__CHANNELS:
				return channels != null;
			case CaltropPackage.PORT_PATTERN__PORT_REF:
				return portRef != null;
			case CaltropPackage.PORT_PATTERN__GUARD_EXPRESSION:
				return guardExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //PortPatternImpl
