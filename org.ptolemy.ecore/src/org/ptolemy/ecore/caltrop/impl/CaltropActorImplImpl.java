/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.caltrop.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.impl.AtomicActorImplImpl;
import org.ptolemy.ecore.caltrop.CaltropActorImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.FireAction;
import org.ptolemy.ecore.caltrop.OutputAction;
import org.ptolemy.ecore.caltrop.StateVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.ptolemy.ecore.caltrop.impl.CaltropActorImplImpl#getInitActions <em>Init Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaltropActorImplImpl<P extends AbstractIOPort> extends AtomicActorImplImpl<P> implements CaltropActorImpl<P> {
	/**
	 * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<StateVariable> declarations;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<FireAction> actions;

	/**
	 * The cached value of the '{@link #getInitActions() <em>Init Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitActions()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputAction> initActions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaltropActorImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaltropPackage.Literals.CALTROP_ACTOR_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FireAction> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<FireAction>(FireAction.class, this, CaltropPackage.CALTROP_ACTOR_IMPL__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputAction> getInitActions() {
		if (initActions == null) {
			initActions = new EObjectContainmentEList<OutputAction>(OutputAction.class, this, CaltropPackage.CALTROP_ACTOR_IMPL__INIT_ACTIONS);
		}
		return initActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateVariable> getDeclarations() {
		if (declarations == null) {
			declarations = new EObjectContainmentEList<StateVariable>(StateVariable.class, this, CaltropPackage.CALTROP_ACTOR_IMPL__DECLARATIONS);
		}
		return declarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaltropPackage.CALTROP_ACTOR_IMPL__DECLARATIONS:
				return ((InternalEList<?>)getDeclarations()).basicRemove(otherEnd, msgs);
			case CaltropPackage.CALTROP_ACTOR_IMPL__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case CaltropPackage.CALTROP_ACTOR_IMPL__INIT_ACTIONS:
				return ((InternalEList<?>)getInitActions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CaltropPackage.CALTROP_ACTOR_IMPL__DECLARATIONS:
				return getDeclarations();
			case CaltropPackage.CALTROP_ACTOR_IMPL__ACTIONS:
				return getActions();
			case CaltropPackage.CALTROP_ACTOR_IMPL__INIT_ACTIONS:
				return getInitActions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CaltropPackage.CALTROP_ACTOR_IMPL__DECLARATIONS:
				getDeclarations().clear();
				getDeclarations().addAll((Collection<? extends StateVariable>)newValue);
				return;
			case CaltropPackage.CALTROP_ACTOR_IMPL__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends FireAction>)newValue);
				return;
			case CaltropPackage.CALTROP_ACTOR_IMPL__INIT_ACTIONS:
				getInitActions().clear();
				getInitActions().addAll((Collection<? extends OutputAction>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CaltropPackage.CALTROP_ACTOR_IMPL__DECLARATIONS:
				getDeclarations().clear();
				return;
			case CaltropPackage.CALTROP_ACTOR_IMPL__ACTIONS:
				getActions().clear();
				return;
			case CaltropPackage.CALTROP_ACTOR_IMPL__INIT_ACTIONS:
				getInitActions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CaltropPackage.CALTROP_ACTOR_IMPL__DECLARATIONS:
				return declarations != null && !declarations.isEmpty();
			case CaltropPackage.CALTROP_ACTOR_IMPL__ACTIONS:
				return actions != null && !actions.isEmpty();
			case CaltropPackage.CALTROP_ACTOR_IMPL__INIT_ACTIONS:
				return initActions != null && !initActions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CaltropActorImplImpl
