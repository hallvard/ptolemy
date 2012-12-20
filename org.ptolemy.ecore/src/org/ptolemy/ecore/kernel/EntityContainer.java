/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.EntityContainer#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.EntityContainer#getRelations <em>Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityContainer()
 * @model
 * @generated
 */
public interface EntityContainer<P extends Port> extends NamedObj, IEntity<P> {
	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Entity}&lt;? extends org.ptolemy.ecore.kernel.Port>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityContainer_Entities()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Entity<? extends Port>> getEntities();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntityContainer_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relation> getRelations();

} // EntityContainer
