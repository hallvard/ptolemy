/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Keyword Channel Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.KeywordChannelSelector#getKeyword <em>Keyword</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getKeywordChannelSelector()
 * @model
 * @generated
 */
public interface KeywordChannelSelector extends ChannelSelector {
	/**
	 * Returns the value of the '<em><b>Keyword</b></em>' attribute.
	 * The literals are from the enumeration {@link org.ptolemy.ecore.caltrop.ChannelSelectorKeyword}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyword</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyword</em>' attribute.
	 * @see org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
	 * @see #setKeyword(ChannelSelectorKeyword)
	 * @see org.ptolemy.ecore.caltrop.CaltropPackage#getKeywordChannelSelector_Keyword()
	 * @model
	 * @generated
	 */
	ChannelSelectorKeyword getKeyword();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.caltrop.KeywordChannelSelector#getKeyword <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyword</em>' attribute.
	 * @see org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
	 * @see #getKeyword()
	 * @generated
	 */
	void setKeyword(ChannelSelectorKeyword value);

} // KeywordChannelSelector
