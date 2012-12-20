/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.xactor.XactorPackage
 * @generated
 */
public interface XactorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XactorFactory eINSTANCE = org.ptolemy.ecore.xactor.impl.XactorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Entity Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Folder</em>'.
	 * @generated
	 */
	EntityFolder createEntityFolder();

	/**
	 * Returns a new object of class '<em>Actor Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Model</em>'.
	 * @generated
	 */
	ActorModel createActorModel();

	/**
	 * Returns a new object of class '<em>Import Directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Directive</em>'.
	 * @generated
	 */
	ImportDirective createImportDirective();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XactorPackage getXactorPackage();

} //XactorFactory
