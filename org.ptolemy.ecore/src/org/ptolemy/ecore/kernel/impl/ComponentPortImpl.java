/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.ComponentPortImpl#getInnerOutgoingLinks <em>Inner Outgoing Links</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.ComponentPortImpl#getInnerIncomingLinks <em>Inner Incoming Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentPortImpl extends PortImpl implements ComponentPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.COMPONENT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Relation> getInnerOutgoingLinks() {
		EList<Relation> relations = new BasicEList<Relation>();
		if (getContainer() instanceof CompositeEntity<?>) {
			addOutgoingLinks(((CompositeEntity<?>) getContainer()).getAllRelations(), this, relations);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Relation> getInnerIncomingLinks() {
		EList<Relation> relations = new BasicEList<Relation>();
		if (getContainer() instanceof CompositeEntity<?>) {
			addIncomingLinks(((CompositeEntity<?>) getContainer()).getAllRelations(), this, relations);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.COMPONENT_PORT__INNER_OUTGOING_LINKS:
				return getInnerOutgoingLinks();
			case KernelPackage.COMPONENT_PORT__INNER_INCOMING_LINKS:
				return getInnerIncomingLinks();
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
			case KernelPackage.COMPONENT_PORT__INNER_OUTGOING_LINKS:
				return !getInnerOutgoingLinks().isEmpty();
			case KernelPackage.COMPONENT_PORT__INNER_INCOMING_LINKS:
				return !getInnerIncomingLinks().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentPortImpl
