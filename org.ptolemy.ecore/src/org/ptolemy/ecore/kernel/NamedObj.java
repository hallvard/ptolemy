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
 * A representation of the model object '<em><b>Named Obj</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.NamedObj#getName <em>Name</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.NamedObj#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.NamedObj#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.NamedObj#getInheritsFrom <em>Inherits From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getNamedObj()
 * @model abstract="true"
 * @generated
 */
public interface NamedObj extends Nameable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getNamedObj_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.NamedObj#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getNamedObj_DisplayName()
	 * @model
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.NamedObj#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getNamedObj_Attributes()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Inherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits From</em>' reference.
	 * @see #setInheritsFrom(NamedObj)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getNamedObj_InheritsFrom()
	 * @model transient="true"
	 * @generated
	 */
	NamedObj getInheritsFrom();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.NamedObj#getInheritsFrom <em>Inherits From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherits From</em>' reference.
	 * @see #getInheritsFrom()
	 * @generated
	 */
	void setInheritsFrom(NamedObj value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Attribute getAttribute(String name);

} // NamedObj
