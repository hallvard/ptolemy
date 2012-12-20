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
 * A representation of the model object '<em><b>Composite Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getMergedEntities <em>Merged Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getInheritedRelations <em>Inherited Relations</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllEntities <em>All Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllRelations <em>All Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getCompositeEntity()
 * @model
 * @generated
 */
public interface CompositeEntity<P extends ComponentPort> extends ComponentEntity<P>, EntityContainer<P> {
	/**
	 * Returns the value of the '<em><b>Merged Entities</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Entity}&lt;? extends org.ptolemy.ecore.kernel.Port>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merged Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merged Entities</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getCompositeEntity_MergedEntities()
	 * @model containment="true" keys="name" changeable="false"
	 * @generated
	 */
	EList<Entity<? extends Port>> getMergedEntities();

	/**
	 * Returns the value of the '<em><b>Inherited Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Relations</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getCompositeEntity_InheritedRelations()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<Relation> getInheritedRelations();

	/**
	 * Returns the value of the '<em><b>All Entities</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Entity}&lt;? extends org.ptolemy.ecore.kernel.Port>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Entities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Entities</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getCompositeEntity_AllEntities()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Entity<? extends Port>> getAllEntities();

	/**
	 * Returns the value of the '<em><b>All Relations</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Relations</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getCompositeEntity_AllRelations()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Relation> getAllRelations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Entity<? extends Port> getEntity(String name);

} // CompositeEntity
