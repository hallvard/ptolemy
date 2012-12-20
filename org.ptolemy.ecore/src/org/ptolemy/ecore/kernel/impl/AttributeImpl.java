/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import org.eclipse.emf.ecore.EClass;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.NamedObj;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AttributeImpl extends NamedObjImpl implements Attribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.ATTRIBUTE;
	}

	@Override
	public NamedObj getContainer() {
		return (eContainer() instanceof NamedObj) ? (NamedObj) eContainer() : null;
	}

	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(getAttributeKindString() + " " + getAttributeTypeString() + " ");
		toString(result);
		return result.toString();
	}
	
	protected String getAttributeKindString() {
		return "-";
	}
	
	protected abstract String getAttributeTypeString();

} //AttributeImpl
