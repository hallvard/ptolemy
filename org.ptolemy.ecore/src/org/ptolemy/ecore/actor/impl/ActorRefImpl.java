/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.ActorRef;
import org.ptolemy.ecore.actor.ParameterBinding;
import org.ptolemy.ecore.actor.TypeParameter;
import org.ptolemy.ecore.actor.TypeParameterized;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.impl.EntityRefImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.actor.impl.ActorRefImpl#getParameterBindings <em>Parameter Bindings</em>}</li>
 *   <li>{@link org.ptolemy.ecore.actor.impl.ActorRefImpl#getTypeArguments <em>Type Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorRefImpl<P extends AbstractTypedIOPort> extends EntityRefImpl<P> implements ActorRef<P> {
	/**
	 * The cached value of the '{@link #getParameterBindings() <em>Parameter Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterBinding> parameterBindings;

	/**
	 * The cached value of the '{@link #getTypeArguments() <em>Type Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> typeArguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActorPackage.Literals.ACTOR_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterBinding> getParameterBindings() {
		if (parameterBindings == null) {
			parameterBindings = new EObjectContainmentEList<ParameterBinding>(ParameterBinding.class, this, ActorPackage.ACTOR_REF__PARAMETER_BINDINGS);
		}
		return parameterBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getTypeArguments() {
		if (typeArguments == null) {
			typeArguments = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, ActorPackage.ACTOR_REF__TYPE_ARGUMENTS);
		}
		return typeArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActorPackage.ACTOR_REF__PARAMETER_BINDINGS:
				return ((InternalEList<?>)getParameterBindings()).basicRemove(otherEnd, msgs);
			case ActorPackage.ACTOR_REF__TYPE_ARGUMENTS:
				return ((InternalEList<?>)getTypeArguments()).basicRemove(otherEnd, msgs);
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
			case ActorPackage.ACTOR_REF__PARAMETER_BINDINGS:
				return getParameterBindings();
			case ActorPackage.ACTOR_REF__TYPE_ARGUMENTS:
				return getTypeArguments();
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
			case ActorPackage.ACTOR_REF__PARAMETER_BINDINGS:
				getParameterBindings().clear();
				getParameterBindings().addAll((Collection<? extends ParameterBinding>)newValue);
				return;
			case ActorPackage.ACTOR_REF__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends JvmTypeReference>)newValue);
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
			case ActorPackage.ACTOR_REF__PARAMETER_BINDINGS:
				getParameterBindings().clear();
				return;
			case ActorPackage.ACTOR_REF__TYPE_ARGUMENTS:
				getTypeArguments().clear();
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
			case ActorPackage.ACTOR_REF__PARAMETER_BINDINGS:
				return parameterBindings != null && !parameterBindings.isEmpty();
			case ActorPackage.ACTOR_REF__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	//

//	@Override
//	protected EntityCopier createCopier(EntityRef<?> entityRef) {
//		return new TypedActorCopier(entityRef);
//	}
//	
//	static class TypedActorCopier extends EntityCopier {
//
//		public TypedActorCopier(EntityRef<?> entityRef) {
//			super(entityRef);
//		}
//
//		@Override
//		public EObject get(Object key) {
//			if (entityRef instanceof ActorRef && entityRef.getRef() instanceof TypeParameterized) {
//				EList<TypeParameter> typeParameters = ((TypeParameterized) entityRef.getRef()).getTypeParameters();
//				EList<JvmTypeReference> typeArguments = ((ActorRef<?>) entityRef).getTypeArguments();
//				int pos = typeParameters.indexOf(key);
//				if (pos >= 0) {
//					return typeArguments.get(pos).getType();
//				}
//			}
//			return super.get(key);
//		}
//	}

} //ActorRefImpl
