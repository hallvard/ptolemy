/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.PortImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.PortImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.PortImpl#getTargetPorts <em>Target Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.PortImpl#getSourcePorts <em>Source Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends NamedObjImpl implements Port {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.PORT;
	}

	// link handling

	protected static void addIncomingLinks(Iterable<Relation> relations, Port port, Collection<Relation> links) {
		for (Relation relation : relations) {
			if (relation.getTargetPorts().contains(port)) {
				links.add(relation);
			}
		}
	}
	
	protected static void addOutgoingLinks(Iterable<Relation> relations, Port port, Collection<Relation> links) {
		for (Relation relation : relations) {
			if (relation.getSourcePort() == port) {
				links.add(relation);
			}
		}
	}
	
	protected static boolean sameContainerContainer(Port port, Port otherPort) {
		Entity<?> portContainer = port.getContainer();
		Entity<?> otherContainer = otherPort.getContainer();
		return (portContainer != null && otherContainer != null && otherContainer.getContainer() == portContainer.getContainer());
	}
	
	protected static void addTargetPorts(Iterable<Relation> relations, Port port, Collection<Port> ports) {
		for (Relation relation : relations) {
			if (relation.getSourcePort() == port) {
				for (Port targetPort : relation.getTargetPorts()) {
					if (sameContainerContainer(port, targetPort) && (! ports.contains(targetPort))) {
						ports.add(targetPort);
					}
				}
			}
		}
	}

	protected static void addSourcePorts(Iterable<Relation> relations, Port port, Collection<Port> ports) {
		for (Relation relation : relations) {
			if (relation.getTargetPorts().contains(port)) {
				if (sameContainerContainer(port, relation.getSourcePort()) && (! ports.contains(relation.getSourcePort()))) {
					ports.add(relation.getSourcePort());
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Relation> getOutgoingLinks() {
		EList<Relation> relations = new BasicEList<Relation>();
		if (getContainer() != null && getContainer().getContainer() != null) {
			addOutgoingLinks(getContainer().getContainer().getRelations(), this, relations);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Relation> getIncomingLinks() {
		EList<Relation> relations = new BasicEList<Relation>();
		if (getContainer() != null && getContainer().getContainer() != null) {
			addIncomingLinks(getContainer().getContainer().getRelations(), this, relations);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Entity<?> getContainer() {
		return (Entity<?>) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Port> getTargetPorts() {
		EList<Port> ports = new BasicEList<Port>();
		if (getContainer() != null && getContainer().getContainer() != null) {
			addTargetPorts(getContainer().getContainer().getRelations(), this, ports);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Port> getSourcePorts() {
		EList<Port> ports = new BasicEList<Port>();
		if (getContainer() != null && getContainer().getContainer() != null) {
			addSourcePorts(getContainer().getContainer().getRelations(), this, ports);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.PORT__OUTGOING_LINKS:
				return getOutgoingLinks();
			case KernelPackage.PORT__INCOMING_LINKS:
				return getIncomingLinks();
			case KernelPackage.PORT__TARGET_PORTS:
				return getTargetPorts();
			case KernelPackage.PORT__SOURCE_PORTS:
				return getSourcePorts();
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
			case KernelPackage.PORT__OUTGOING_LINKS:
				return !getOutgoingLinks().isEmpty();
			case KernelPackage.PORT__INCOMING_LINKS:
				return !getIncomingLinks().isEmpty();
			case KernelPackage.PORT__TARGET_PORTS:
				return !getTargetPorts().isEmpty();
			case KernelPackage.PORT__SOURCE_PORTS:
				return !getSourcePorts().isEmpty();
		}
		return super.eIsSet(featureID);
	}

//	@Override
//	public String getName() {
//		String name = super.getName();
//		return (name != null ? name : getDefaultName());
//	}
//
//	@Override
//	protected String getDefaultBaseName() {
//		return "port";
//	}
//	
//	@Override
//	protected boolean isSameKind(Nameable named) {
//		return named instanceof Port;
//	}
//
//	@Override
//	protected EList<? extends Nameable> getSameObjects() {
//		return getContainer().getPorts();
//	}

	//
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(getPortKindString());
		String typeString = getPortTypeString();
		if (typeString != null) {
			result.append(" " + typeString);
		}
		result.append(" ");
		super.toString(result);
		return result.toString();
	}

	protected String getPortKindString() {
		return "->";
	}

	protected String getPortTypeString() {
		return null;
	}
	
} //PortImpl
