/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.ptolemy.ecore.actor.impl.AbstractTypedIOPortImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.TypedOutputPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Output Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TypedOutputPortImpl extends AbstractTypedIOPortImpl implements TypedOutputPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedOutputPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.TYPED_OUTPUT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JvmTypeReference getInferredType() {
		if (inferredType != null && inferredType.eIsProxy()) {
			InternalEObject oldInferredType = (InternalEObject)inferredType;
			inferredType = (JvmTypeReference)eResolveProxy(oldInferredType);
			if (inferredType != oldInferredType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaltropPackage.TYPED_OUTPUT_PORT__INFERRED_TYPE, oldInferredType, inferredType));
			}
		}
		return (inferredType != null ? inferredType : inferType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JvmTypeReference inferType() {
		return type;
	}

	//
	
	@Override
	public boolean isInput() {
		return false;
	}

	@Override
	public boolean isOutput() {
		return true;
	}

} //TypedOutputPortImpl
