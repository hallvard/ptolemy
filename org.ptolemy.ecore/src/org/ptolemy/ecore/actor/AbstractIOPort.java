/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.ptolemy.ecore.kernel.ComponentPort;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract IO Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.AbstractIOPort#isMultiport <em>Multiport</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.AbstractIOPort#getWidth <em>Width</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.AbstractIOPort#getRate <em>Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getAbstractIOPort()
 * @model abstract="true"
 * @generated
 */
public interface AbstractIOPort extends ComponentPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isInput();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isOutput();

	/**
	 * Returns the value of the '<em><b>Multiport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiport</em>' attribute.
	 * @see #setMultiport(boolean)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getAbstractIOPort_Multiport()
	 * @model
	 * @generated
	 */
	boolean isMultiport();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.AbstractIOPort#isMultiport <em>Multiport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiport</em>' attribute.
	 * @see #isMultiport()
	 * @generated
	 */
	void setMultiport(boolean value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see org.ptolemy.ecore.actor.ActorPackage#getAbstractIOPort_Width()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getWidth();

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate</em>' attribute.
	 * @see #setRate(int)
	 * @see org.ptolemy.ecore.actor.ActorPackage#getAbstractIOPort_Rate()
	 * @model default="-1"
	 * @generated
	 */
	int getRate();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.actor.AbstractIOPort#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate</em>' attribute.
	 * @see #getRate()
	 * @generated
	 */
	void setRate(int value);

} // AbstractIOPort
