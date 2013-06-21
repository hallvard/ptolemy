/**
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;

import org.ptolemy.ecore.kernel.NamedObj;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.State#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.State#getSchedule <em>Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedObj {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.Transition}.
	 * It is bidirectional and its opposite is '{@link org.ptolemy.ecore.caltrop.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getState_Transitions()
	 * @see org.ptolemy.ecore.caltrop.Transition#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.ptolemy.ecore.caltrop.Schedule#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' container reference.
	 * @see #setSchedule(Schedule)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getState_Schedule()
	 * @see org.ptolemy.ecore.caltrop.Schedule#getStates
	 * @model opposite="states" transient="false"
	 * @generated
	 */
	Schedule getSchedule();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.State#getSchedule <em>Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' container reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(Schedule value);

} // State
