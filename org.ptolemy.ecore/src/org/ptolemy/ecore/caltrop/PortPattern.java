/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XExpression;
import org.ptolemy.ecore.kernel.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.PortPattern#getRepeatExpression <em>Repeat Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.PortPattern#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.PortPattern#getPortRef <em>Port Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getPortPattern()
 * @model abstract="true"
 * @generated
 */
public interface PortPattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Repeat Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat Expression</em>' containment reference.
	 * @see #setRepeatExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getPortPattern_RepeatExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getRepeatExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.PortPattern#getRepeatExpression <em>Repeat Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat Expression</em>' containment reference.
	 * @see #getRepeatExpression()
	 * @generated
	 */
	void setRepeatExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channels</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' containment reference.
	 * @see #setChannels(ChannelSelector)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getPortPattern_Channels()
	 * @model containment="true"
	 * @generated
	 */
	ChannelSelector getChannels();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.PortPattern#getChannels <em>Channels</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channels</em>' containment reference.
	 * @see #getChannels()
	 * @generated
	 */
	void setChannels(ChannelSelector value);

	/**
	 * Returns the value of the '<em><b>Port Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Ref</em>' reference.
	 * @see #setPortRef(Port)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getPortPattern_PortRef()
	 * @model
	 * @generated
	 */
	Port getPortRef();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.PortPattern#getPortRef <em>Port Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Ref</em>' reference.
	 * @see #getPortRef()
	 * @generated
	 */
	void setPortRef(Port value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int size();

} // PortPattern
