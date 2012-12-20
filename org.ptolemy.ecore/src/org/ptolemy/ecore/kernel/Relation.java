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
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Relation#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Relation#getTargetPorts <em>Target Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getRelation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceTargetContainer inputOutputLogic'"
 * @generated
 */
public interface Relation extends NamedObj {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EntityContainer<?> getContainer();

	/**
	 * Returns the value of the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port</em>' reference.
	 * @see #setSourcePort(Port)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getRelation_SourcePort()
	 * @model required="true"
	 * @generated
	 */
	Port getSourcePort();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.Relation#getSourcePort <em>Source Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port</em>' reference.
	 * @see #getSourcePort()
	 * @generated
	 */
	void setSourcePort(Port value);

	/**
	 * Returns the value of the '<em><b>Target Ports</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Ports</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getRelation_TargetPorts()
	 * @model required="true"
	 * @generated
	 */
	EList<Port> getTargetPorts();

} // Relation
