/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IO Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.IOPort#getIoKind <em>Io Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getIOPort()
 * @model
 * @generated
 */
public interface IOPort extends AbstractIOPort {

	/**
	 * Returns the value of the '<em><b>Io Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.ptolemy.ecore.actor.IOPortKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Io Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Io Kind</em>' attribute.
	 * @see org.ptolemy.ecore.actor.IOPortKind
	 * @see #setIoKind(IOPortKind)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getIOPort_IoKind()
	 * @model
	 * @generated
	 */
	IOPortKind getIoKind();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.IOPort#getIoKind <em>Io Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Io Kind</em>' attribute.
	 * @see org.ptolemy.ecore.actor.IOPortKind
	 * @see #getIoKind()
	 * @generated
	 */
	void setIoKind(IOPortKind value);
} // IOPort
