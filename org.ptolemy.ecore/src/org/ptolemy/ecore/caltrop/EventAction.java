/**
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.EventAction#getEventPatterns <em>Event Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventAction()
 * @model
 * @generated
 */
public interface EventAction extends ReAction {
	/**
	 * Returns the value of the '<em><b>Event Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.EventPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Patterns</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getEventAction_EventPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventPattern> getEventPatterns();

} // EventAction
