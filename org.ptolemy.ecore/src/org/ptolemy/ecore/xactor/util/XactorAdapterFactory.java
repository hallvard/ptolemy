/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Named;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.xactor.*;
import org.ptolemy.ecore.xactor.ActorModel;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.ImportDirective;
import org.ptolemy.ecore.xactor.XactorPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.xactor.XactorPackage
 * @generated
 */
public class XactorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XactorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XactorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XactorPackage.eINSTANCE;
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
	protected XactorSwitch<Adapter> modelSwitch =
		new XactorSwitch<Adapter>() {
			@Override
			public Adapter caseEntityFolder(EntityFolder object) {
				return createEntityFolderAdapter();
			}
			@Override
			public Adapter caseActorModel(ActorModel object) {
				return createActorModelAdapter();
			}
			@Override
			public Adapter caseImportDirective(ImportDirective object) {
				return createImportDirectiveAdapter();
			}
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
			public <P extends Port> Adapter caseIEntity(IEntity<P> object) {
				return createIEntityAdapter();
			}
			@Override
			public <P extends Port> Adapter caseEntityContainer(EntityContainer<P> object) {
				return createEntityContainerAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.xactor.EntityFolder <em>Entity Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.xactor.EntityFolder
	 * @generated
	 */
	public Adapter createEntityFolderAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.xactor.ActorModel <em>Actor Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.xactor.ActorModel
	 * @generated
	 */
	public Adapter createActorModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.ecore.xactor.ImportDirective <em>Import Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.ecore.xactor.ImportDirective
	 * @generated
	 */
	public Adapter createImportDirectiveAdapter() {
		return null;
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

} //XactorAdapterFactory
