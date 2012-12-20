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
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getSourceEntities <em>Source Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getTargetEntities <em>Target Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getSuperEntity <em>Super Entity</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getInheritedAttributes <em>Inherited Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getInheritedPorts <em>Inherited Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getAllAttributes <em>All Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getAllPorts <em>All Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity<P extends Port> extends NamedObj, EntityRefOwner, IEntity<P> {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EntityContainer<?> getContainer();

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link P}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_Ports()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<P> getPorts();

	/**
	 * Returns the value of the '<em><b>Source Entities</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Entity}&lt;? extends org.ptolemy.ecore.kernel.Port>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Entities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Entities</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_SourceEntities()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Entity<? extends Port>> getSourceEntities();

	/**
	 * Returns the value of the '<em><b>Target Entities</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Entity}&lt;? extends org.ptolemy.ecore.kernel.Port>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Entities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Entities</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_TargetEntities()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Entity<? extends Port>> getTargetEntities();

	/**
	 * Returns the value of the '<em><b>Super Entity</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.ptolemy.ecore.kernel.EntityRef#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Entity</em>' containment reference.
	 * @see #setSuperEntity(EntityRef)
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_SuperEntity()
	 * @see org.ptolemy.ecore.kernel.EntityRef#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EntityRef<P> getSuperEntity();

	/**
	 * Sets the value of the '{@link org.ptolemy.ecore.kernel.Entity#getSuperEntity <em>Super Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Entity</em>' containment reference.
	 * @see #getSuperEntity()
	 * @generated
	 */
	void setSuperEntity(EntityRef<P> value);

	/**
	 * Returns the value of the '<em><b>Inherited Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Attributes</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_InheritedAttributes()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<Attribute> getInheritedAttributes();

	/**
	 * Returns the value of the '<em><b>Inherited Ports</b></em>' containment reference list.
	 * The list contents are of type {@link P}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Ports</em>' containment reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_InheritedPorts()
	 * @model containment="true" keys="name" transient="true"
	 * @generated
	 */
	EList<P> getInheritedPorts();

	/**
	 * Returns the value of the '<em><b>All Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.ecore.kernel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Attributes</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_AllAttributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Attribute> getAllAttributes();

	/**
	 * Returns the value of the '<em><b>All Ports</b></em>' reference list.
	 * The list contents are of type {@link P}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Ports</em>' reference list.
	 * @see org.ptolemy.ecore.kernel.KernelPackage#getEntity_AllPorts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<P> getAllPorts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	P getPort(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean resolveSuperEntity(boolean force);

} // Entity
