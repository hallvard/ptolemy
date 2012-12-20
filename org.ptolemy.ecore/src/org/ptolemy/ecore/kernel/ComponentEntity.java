/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getComponentEntity()
 * @model
 * @generated
 */
public interface ComponentEntity<P extends ComponentPort> extends Entity<P> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isAtomic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isOpaque();
} // ComponentEntity
