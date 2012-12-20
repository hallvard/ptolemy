/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.EntityRef#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.EntityRef#getRef <em>Ref</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.EntityRef#getResolved <em>Resolved</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityRef()
 * @model
 * @generated
 */
public interface EntityRef<P extends Port> extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.ptolemy.ecore.kernel.Entity#getSuperEntity <em>Super Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Entity)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityRef_Owner()
	 * @see org.ptolemy.ecore.kernel.Entity#getSuperEntity
	 * @model opposite="superEntity" transient="false"
	 * @generated
	 */
	Entity<P> getOwner();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.EntityRef#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Entity<P> value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Entity)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityRef_Ref()
	 * @model
	 * @generated
	 */
	Entity<P> getRef();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.EntityRef#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Entity<P> value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' containment reference.
	 * @see #setResolved(Entity)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityRef_Resolved()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	Entity<P> getResolved();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.EntityRef#getResolved <em>Resolved</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved</em>' containment reference.
	 * @see #getResolved()
	 * @generated
	 */
	void setResolved(Entity<P> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean resolve(boolean force);

} // EntityRef
