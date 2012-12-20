/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Port#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Port#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Port#getTargetPorts <em>Target Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Port#getSourcePorts <em>Source Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getPort()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints=''"
 * @generated
 */
public interface Port extends NamedObj {
	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getPort_OutgoingLinks()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Relation> getOutgoingLinks();

	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getPort_IncomingLinks()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Relation> getIncomingLinks();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Entity<?> getContainer();

	/**
	 * Returns the value of the '<em><b>Source Ports</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Port}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Ports</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getPort_SourcePorts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Port> getSourcePorts();

	/**
	 * Returns the value of the '<em><b>Target Ports</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Port}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Ports</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getPort_TargetPorts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Port> getTargetPorts();

} // Port
