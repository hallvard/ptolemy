/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.OutputPattern#getValueExpressions <em>Value Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputPattern()
 * @model
 * @generated
 */
public interface OutputPattern extends PortPattern {
	/**
	 * Returns the value of the '<em><b>Value Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expressions</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getOutputPattern_ValueExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getValueExpressions();

} // OutputPattern
