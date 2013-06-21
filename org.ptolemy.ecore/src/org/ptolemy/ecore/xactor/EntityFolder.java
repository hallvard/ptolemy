/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xtype.XImportSection;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.xactor.EntityFolder#getEntityContainers <em>Entity Containers</em>}</li>
 *   <li>{@link org.ptolemy.ecore.xactor.EntityFolder#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.xactor.XactorPackage#getEntityFolder()
 * @model
 * @generated
 */
public interface EntityFolder extends EntityContainer<Port> {
	/**
	 * Returns the value of the '<em><b>Entity Containers</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.xactor.EntityFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Containers</em>' containment reference list.
	 * @see org.ptolemy.ecore.xactor.XactorPackage#getEntityFolder_EntityContainers()
	 * @model containment="true"
	 * @generated
	 */
	EList<EntityFolder> getEntityContainers();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtype.XImportSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.ptolemy.ecore.xactor.XactorPackage#getEntityFolder_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<XImportSection> getImports();

} // EntityFolder
