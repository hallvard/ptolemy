/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fire Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.FireAction#getInputPatterns <em>Input Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getFireAction()
 * @model
 * @generated
 */
public interface FireAction extends ReAction {
	/**
	 * Returns the value of the '<em><b>Input Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.caltrop.InputPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Patterns</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getFireAction_InputPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputPattern> getInputPatterns();

} // FireAction
