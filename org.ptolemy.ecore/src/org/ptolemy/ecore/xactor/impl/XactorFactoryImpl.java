/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.xactor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ptolemy.ecore.xactor.*;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.XactorFactory;
import org.ptolemy.ecore.xactor.XactorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XactorFactoryImpl extends EFactoryImpl implements XactorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XactorFactory init() {
		try {
			XactorFactory theXactorFactory = (XactorFactory)EPackage.Registry.INSTANCE.getEFactory(XactorPackage.eNS_URI);
			if (theXactorFactory != null) {
				return theXactorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XactorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XactorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XactorPackage.ENTITY_FOLDER: return createEntityFolder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityFolder createEntityFolder() {
		EntityFolderImpl entityFolder = new EntityFolderImpl();
		return entityFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XactorPackage getXactorPackage() {
		return (XactorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XactorPackage getPackage() {
		return XactorPackage.eINSTANCE;
	}

} //XactorFactoryImpl
