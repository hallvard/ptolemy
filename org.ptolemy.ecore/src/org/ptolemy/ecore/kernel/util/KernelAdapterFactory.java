/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.ptolemy.ecore.kernel.*;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.ComponentEntity;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.EntityRefOwner;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Named;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.kernel.KernelPackage
 * @generated
 */
public class KernelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KernelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = KernelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KernelSwitch<Adapter> modelSwitch =
		new KernelSwitch<Adapter>() {
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNamedObj(NamedObj object) {
				return createNamedObjAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public <P extends Port> Adapter caseIEntity(IEntity<P> object) {
				return createIEntityAdapter();
			}
			@Override
			public <P extends Port> Adapter caseEntity(Entity<P> object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter caseEntityRefOwner(EntityRefOwner object) {
				return createEntityRefOwnerAdapter();
			}
			@Override
			public <P extends Port> Adapter caseEntityRef(EntityRef<P> object) {
				return createEntityRefAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public <P extends ComponentPort> Adapter caseComponentEntity(ComponentEntity<P> object) {
				return createComponentEntityAdapter();
			}
			@Override
			public Adapter caseComponentPort(ComponentPort object) {
				return createComponentPortAdapter();
			}
			@Override
			public <P extends Port> Adapter caseEntityContainer(EntityContainer<P> object) {
				return createEntityContainerAdapter();
			}
			@Override
			public <P extends ComponentPort> Adapter caseCompositeEntity(CompositeEntity<P> object) {
				return createCompositeEntityAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Named
	 * @generated
	 */
	public Adapter createNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.IEntity <em>IEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.IEntity
	 * @generated
	 */
	public Adapter createIEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.NamedObj <em>Named Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.NamedObj
	 * @generated
	 */
	public Adapter createNamedObjAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.EntityRefOwner <em>Entity Ref Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.EntityRefOwner
	 * @generated
	 */
	public Adapter createEntityRefOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.EntityRef <em>Entity Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.EntityRef
	 * @generated
	 */
	public Adapter createEntityRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.ComponentEntity <em>Component Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.ComponentEntity
	 * @generated
	 */
	public Adapter createComponentEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.ComponentPort <em>Component Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.ComponentPort
	 * @generated
	 */
	public Adapter createComponentPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.CompositeEntity <em>Composite Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.CompositeEntity
	 * @generated
	 */
	public Adapter createCompositeEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.kernel.EntityContainer <em>Entity Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.kernel.EntityContainer
	 * @generated
	 */
	public Adapter createEntityContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //KernelAdapterFactory
