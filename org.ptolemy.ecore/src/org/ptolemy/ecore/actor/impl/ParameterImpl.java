/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends VariableImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.PARAMETER;
	}

	@Override
	protected String getAttributeKindString() {
		return "*";
	}

} //ParameterImpl
