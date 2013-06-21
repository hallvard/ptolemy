/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AtomicActorImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getInitActions <em>Init Actions</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getSchedule <em>Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getCaltropActorImpl()
 * @model
 * @generated
 */
public interface CaltropActorImpl<P extends AbstractIOPort> extends AtomicActorImpl<P> {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.ReAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getCaltropActorImpl_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReAction> getActions();

	/**
	 * Returns the value of the '<em><b>Init Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.OutputAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Actions</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getCaltropActorImpl_InitActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputAction> getInitActions();

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.FunctionDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getCaltropActorImpl_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionDeclaration> getFunctions();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' containment reference.
	 * @see #setSchedule(Schedule)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getCaltropActorImpl_Schedule()
	 * @model containment="true"
	 * @generated
	 */
	Schedule getSchedule();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.CaltropActorImpl#getSchedule <em>Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' containment reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(Schedule value);

	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.StateVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getCaltropActorImpl_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateVariable> getDeclarations();

} // CaltropActorImpl
