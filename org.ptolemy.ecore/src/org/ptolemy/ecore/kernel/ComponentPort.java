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
 * A representation of the model object '<em><b>Component Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.ComponentPort#getInnerOutgoingLinks <em>Inner Outgoing Links</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.ComponentPort#getInnerIncomingLinks <em>Inner Incoming Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getComponentPort()
 * @model
 * @generated
 */
public interface ComponentPort extends Port {

	/**
	 * Returns the value of the '<em><b>Inner Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Outgoing Links</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getComponentPort_InnerOutgoingLinks()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Relation> getInnerOutgoingLinks();

	/**
	 * Returns the value of the '<em><b>Inner Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Incoming Links</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getComponentPort_InnerIncomingLinks()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Relation> getInnerIncomingLinks();
} // ComponentPort
