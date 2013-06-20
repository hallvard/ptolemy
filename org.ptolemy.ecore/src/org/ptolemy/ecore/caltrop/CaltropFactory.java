/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop;

import org.eclipse.emf.ecore.EFactory;
import org.ptolemy.ecore.actor.AbstractIOPort;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.caltrop.CaltropPackage
 * @generated
 */
public interface CaltropFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CaltropFactory eINSTANCE = org.ptolemy.ecore.caltrop.impl.CaltropFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Actor Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Impl</em>'.
	 * @generated
	 */
	<P extends AbstractIOPort> CaltropActorImpl<P> createCaltropActorImpl();

	/**
	 * Returns a new object of class '<em>Actor Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Parameter</em>'.
	 * @generated
	 */
	ActorParameter createActorParameter();

	/**
	 * Returns a new object of class '<em>Typed Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Input Port</em>'.
	 * @generated
	 */
	TypedInputPort createTypedInputPort();

	/**
	 * Returns a new object of class '<em>Typed Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Output Port</em>'.
	 * @generated
	 */
	TypedOutputPort createTypedOutputPort();

	/**
	 * Returns a new object of class '<em>State Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Variable</em>'.
	 * @generated
	 */
	StateVariable createStateVariable();

	/**
	 * Returns a new object of class '<em>Fire Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fire Action</em>'.
	 * @generated
	 */
	FireAction createFireAction();

	/**
	 * Returns a new object of class '<em>Output Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Action</em>'.
	 * @generated
	 */
	OutputAction createOutputAction();

	/**
	 * Returns a new object of class '<em>Input Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Pattern</em>'.
	 * @generated
	 */
	InputPattern createInputPattern();

	/**
	 * Returns a new object of class '<em>Output Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Pattern</em>'.
	 * @generated
	 */
	OutputPattern createOutputPattern();

	/**
	 * Returns a new object of class '<em>Expression Channel Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Channel Selector</em>'.
	 * @generated
	 */
	ExpressionChannelSelector createExpressionChannelSelector();

	/**
	 * Returns a new object of class '<em>Keyword Channel Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Keyword Channel Selector</em>'.
	 * @generated
	 */
	KeywordChannelSelector createKeywordChannelSelector();

	/**
	 * Returns a new object of class '<em>Old Action Variable Value Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Old Action Variable Value Ref</em>'.
	 * @generated
	 */
	OldActionVariableValueRef createOldActionVariableValueRef();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CaltropPackage getCaltropPackage();

} //CaltropFactory