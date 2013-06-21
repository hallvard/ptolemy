/**
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.xtext.xbase.XExpression;

import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Converter Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.ConversionRelation#getValueVar <em>Value Var</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.ConversionRelation#getConversionExpression <em>Conversion Expression</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.ConversionRelation#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getConversionRelation()
 * @model
 * @generated
 */
public interface ConversionRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Conversion Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Expression</em>' containment reference.
	 * @see #setConversionExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getConversionRelation_ConversionExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getConversionExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.ConversionRelation#getConversionExpression <em>Conversion Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Expression</em>' containment reference.
	 * @see #getConversionExpression()
	 * @generated
	 */
	void setConversionExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Expression</em>' containment reference.
	 * @see #setGuardExpression(XExpression)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getConversionRelation_GuardExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getGuardExpression();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.ConversionRelation#getGuardExpression <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Expression</em>' containment reference.
	 * @see #getGuardExpression()
	 * @generated
	 */
	void setGuardExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Value Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Var</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Var</em>' attribute.
	 * @see #setValueVar(String)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getConversionRelation_ValueVar()
	 * @model
	 * @generated
	 */
	String getValueVar();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.ConversionRelation#getValueVar <em>Value Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Var</em>' attribute.
	 * @see #getValueVar()
	 * @generated
	 */
	void setValueVar(String value);

} // ConverterRelation
