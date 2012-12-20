/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.OldActionVariableValueRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Old Action Variable Value Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OldActionVariableValueRefImpl extends XAbstractFeatureCallImpl implements OldActionVariableValueRef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OldActionVariableValueRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.OLD_ACTION_VARIABLE_VALUE_REF;
	}
	
	//

	@Override
	public EList<XExpression> getExplicitArguments() {
		return new BasicEList<XExpression>();
	}

} //OldActionVariableValueExpressionImpl
