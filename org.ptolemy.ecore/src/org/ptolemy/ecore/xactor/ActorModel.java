/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.xactor.ActorModel#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.xactor.XactorPackage#getActorModel()
 * @model
 * @generated
 */
public interface ActorModel extends EntityFolder {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.xactor.ImportDirective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.ptolemy.ecore.xactor.XactorPackage#getActorModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportDirective> getImports();

} // ActorModel
