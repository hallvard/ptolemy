/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.kernel.KernelPackage
 * @generated
 */
public class KernelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KernelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelSwitch() {
		if (modelPackage == null) {
			modelPackage = KernelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case KernelPackage.NAMED: {
				Named named = (Named)theEObject;
				T result = caseNamed(named);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.NAMEABLE: {
				Nameable nameable = (Nameable)theEObject;
				T result = caseNameable(nameable);
				if (result == null) result = caseNamed(nameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.NAMED_OBJ: {
				NamedObj namedObj = (NamedObj)theEObject;
				T result = caseNamedObj(namedObj);
				if (result == null) result = caseNameable(namedObj);
				if (result == null) result = caseNamed(namedObj);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseNamedObj(attribute);
				if (result == null) result = caseNameable(attribute);
				if (result == null) result = caseNamed(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.IENTITY: {
				IEntity<?> iEntity = (IEntity<?>)theEObject;
				T result = caseIEntity(iEntity);
				if (result == null) result = caseNameable(iEntity);
				if (result == null) result = caseNamed(iEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.ENTITY: {
				Entity<?> entity = (Entity<?>)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = caseNamedObj(entity);
				if (result == null) result = caseEntityRefOwner(entity);
				if (result == null) result = caseIEntity(entity);
				if (result == null) result = caseNameable(entity);
				if (result == null) result = caseNamed(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.ENTITY_REF_OWNER: {
				EntityRefOwner entityRefOwner = (EntityRefOwner)theEObject;
				T result = caseEntityRefOwner(entityRefOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.ENTITY_REF: {
				EntityRef<?> entityRef = (EntityRef<?>)theEObject;
				T result = caseEntityRef(entityRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseNamedObj(port);
				if (result == null) result = caseNameable(port);
				if (result == null) result = caseNamed(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = caseNamedObj(relation);
				if (result == null) result = caseNameable(relation);
				if (result == null) result = caseNamed(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.COMPONENT_ENTITY: {
				ComponentEntity<?> componentEntity = (ComponentEntity<?>)theEObject;
				T result = caseComponentEntity(componentEntity);
				if (result == null) result = caseEntity(componentEntity);
				if (result == null) result = caseNamedObj(componentEntity);
				if (result == null) result = caseEntityRefOwner(componentEntity);
				if (result == null) result = caseIEntity(componentEntity);
				if (result == null) result = caseNameable(componentEntity);
				if (result == null) result = caseNamed(componentEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.COMPONENT_PORT: {
				ComponentPort componentPort = (ComponentPort)theEObject;
				T result = caseComponentPort(componentPort);
				if (result == null) result = casePort(componentPort);
				if (result == null) result = caseNamedObj(componentPort);
				if (result == null) result = caseNameable(componentPort);
				if (result == null) result = caseNamed(componentPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.ENTITY_CONTAINER: {
				EntityContainer<?> entityContainer = (EntityContainer<?>)theEObject;
				T result = caseEntityContainer(entityContainer);
				if (result == null) result = caseNamedObj(entityContainer);
				if (result == null) result = caseIEntity(entityContainer);
				if (result == null) result = caseNameable(entityContainer);
				if (result == null) result = caseNamed(entityContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KernelPackage.COMPOSITE_ENTITY: {
				CompositeEntity<?> compositeEntity = (CompositeEntity<?>)theEObject;
				T result = caseCompositeEntity(compositeEntity);
				if (result == null) result = caseComponentEntity(compositeEntity);
				if (result == null) result = caseEntityContainer(compositeEntity);
				if (result == null) result = caseEntity(compositeEntity);
				if (result == null) result = caseNamedObj(compositeEntity);
				if (result == null) result = caseEntityRefOwner(compositeEntity);
				if (result == null) result = caseIEntity(compositeEntity);
				if (result == null) result = caseNameable(compositeEntity);
				if (result == null) result = caseNamed(compositeEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamed(Named object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEntity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEntity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseIEntity(IEntity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Obj</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Obj</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedObj(NamedObj object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseEntity(Entity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Ref Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Ref Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityRefOwner(EntityRefOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseEntityRef(EntityRef<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelation(Relation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends ComponentPort> T caseComponentEntity(ComponentEntity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPort(ComponentPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends ComponentPort> T caseCompositeEntity(CompositeEntity<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P extends Port> T caseEntityContainer(EntityContainer<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //KernelSwitch
