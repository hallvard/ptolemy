/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typeable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.ptolemy.ecore.actor.ActorPackage#getTypeable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Typeable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmTypeReference getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmTypeReference getInferredType();

} // Typeable
