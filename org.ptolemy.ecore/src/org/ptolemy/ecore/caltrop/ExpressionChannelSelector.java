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
 * A representation of the model object '<em><b>Expression Channel Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector#isMany <em>Many</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector#getKeyExpressions <em>Key Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getExpressionChannelSelector()
 * @model
 * @generated
 */
public interface ExpressionChannelSelector extends ChannelSelector {
	/**
	 * Returns the value of the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many</em>' attribute.
	 * @see #setMany(boolean)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getExpressionChannelSelector_Many()
	 * @model
	 * @generated
	 */
	boolean isMany();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.ExpressionChannelSelector#isMany <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Many</em>' attribute.
	 * @see #isMany()
	 * @generated
	 */
	void setMany(boolean value);

	/**
	 * Returns the value of the '<em><b>Key Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Expressions</em>' containment reference list.
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getExpressionChannelSelector_KeyExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getKeyExpressions();

} // ExpressionChannelSelector
