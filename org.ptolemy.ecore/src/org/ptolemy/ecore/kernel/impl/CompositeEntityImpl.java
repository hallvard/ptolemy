/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl#getMergedEntities <em>Merged Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl#getInheritedRelations <em>Inherited Relations</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl#getAllEntities <em>All Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.CompositeEntityImpl#getAllRelations <em>All Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeEntityImpl<P extends ComponentPort> extends ComponentEntityImpl<P> implements CompositeEntity<P> {
	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity<? extends Port>> entities;

	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relations;

	/**
	 * The cached value of the '{@link #getMergedEntities() <em>Merged Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergedEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity<? extends Port>> mergedEntities;

	/**
	 * The cached value of the '{@link #getInheritedRelations() <em>Inherited Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> inheritedRelations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.COMPOSITE_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity<? extends Port>> getEntities() {
		if (entities == null) {
			entities = new EObjectContainmentEList<Entity<? extends Port>>(Entity.class, this, KernelPackage.COMPOSITE_ENTITY__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelations() {
		if (relations == null) {
			relations = new EObjectContainmentEList<Relation>(Relation.class, this, KernelPackage.COMPOSITE_ENTITY__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity<? extends Port>> getMergedEntities() {
		if (mergedEntities == null) {
			mergedEntities = new EObjectContainmentEList<Entity<? extends Port>>(Entity.class, this, KernelPackage.COMPOSITE_ENTITY__MERGED_ENTITIES);
		}
		return mergedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getInheritedRelations() {
		if (inheritedRelations == null) {
			inheritedRelations = new EObjectContainmentEList<Relation>(Relation.class, this, KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS);
		}
		return inheritedRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Entity<? extends Port>> getAllEntities() {
		EList<Entity<? extends Port>> mergedEntities = getMergedEntities();
		return (mergedEntities.isEmpty() ? getEntities() : mergedEntities);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Relation> getAllRelations() {
		EList<Relation> inheritedRelations = getInheritedRelations();
		if (inheritedRelations.isEmpty()) {
			return getRelations();
		}
		BasicEList<Relation> allRelations = new BasicEList<Relation>(getRelations());
		allRelations.addAll(inheritedRelations);
		return allRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Entity<? extends Port> getEntity(String name) {
		return getNamed(name, this, KernelPackage.eINSTANCE.getCompositeEntity_AllEntities());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.COMPOSITE_ENTITY__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
			case KernelPackage.COMPOSITE_ENTITY__RELATIONS:
				return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
			case KernelPackage.COMPOSITE_ENTITY__MERGED_ENTITIES:
				return ((InternalEList<?>)getMergedEntities()).basicRemove(otherEnd, msgs);
			case KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS:
				return ((InternalEList<?>)getInheritedRelations()).basicRemove(otherEnd, msgs);
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
			case KernelPackage.COMPOSITE_ENTITY__ENTITIES:
				return getEntities();
			case KernelPackage.COMPOSITE_ENTITY__RELATIONS:
				return getRelations();
			case KernelPackage.COMPOSITE_ENTITY__MERGED_ENTITIES:
				return getMergedEntities();
			case KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS:
				return getInheritedRelations();
			case KernelPackage.COMPOSITE_ENTITY__ALL_ENTITIES:
				return getAllEntities();
			case KernelPackage.COMPOSITE_ENTITY__ALL_RELATIONS:
				return getAllRelations();
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
			case KernelPackage.COMPOSITE_ENTITY__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity<? extends Port>>)newValue);
				return;
			case KernelPackage.COMPOSITE_ENTITY__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS:
				getInheritedRelations().clear();
				getInheritedRelations().addAll((Collection<? extends Relation>)newValue);
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
			case KernelPackage.COMPOSITE_ENTITY__ENTITIES:
				getEntities().clear();
				return;
			case KernelPackage.COMPOSITE_ENTITY__RELATIONS:
				getRelations().clear();
				return;
			case KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS:
				getInheritedRelations().clear();
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
			case KernelPackage.COMPOSITE_ENTITY__ENTITIES:
				return entities != null && !entities.isEmpty();
			case KernelPackage.COMPOSITE_ENTITY__RELATIONS:
				return relations != null && !relations.isEmpty();
			case KernelPackage.COMPOSITE_ENTITY__MERGED_ENTITIES:
				return mergedEntities != null && !mergedEntities.isEmpty();
			case KernelPackage.COMPOSITE_ENTITY__INHERITED_RELATIONS:
				return inheritedRelations != null && !inheritedRelations.isEmpty();
			case KernelPackage.COMPOSITE_ENTITY__ALL_ENTITIES:
				return !getAllEntities().isEmpty();
			case KernelPackage.COMPOSITE_ENTITY__ALL_RELATIONS:
				return !getAllRelations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EntityContainer.class) {
			switch (derivedFeatureID) {
				case KernelPackage.COMPOSITE_ENTITY__ENTITIES: return KernelPackage.ENTITY_CONTAINER__ENTITIES;
				case KernelPackage.COMPOSITE_ENTITY__RELATIONS: return KernelPackage.ENTITY_CONTAINER__RELATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EntityContainer.class) {
			switch (baseFeatureID) {
				case KernelPackage.ENTITY_CONTAINER__ENTITIES: return KernelPackage.COMPOSITE_ENTITY__ENTITIES;
				case KernelPackage.ENTITY_CONTAINER__RELATIONS: return KernelPackage.COMPOSITE_ENTITY__RELATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public boolean isAtomic() {
		return false;
	}

	//
	
	@Override
	protected void clearInheritedFeatures() {
		super.clearInheritedFeatures();
		getInheritedRelations().clear();
		getMergedEntities().clear();
	}
	
	@Override
	protected void inheritFeatures(Entity<?> superEntity, EcoreUtil.Copier copier) {
		super.inheritFeatures(superEntity, copier);
		if (superEntity instanceof CompositeEntity<?>) {
//			mergeEntities((CompositeEntity<P>) thisEntity, (CompositeEntity<P>) superEntity, copier);
			inheritRelations((CompositeEntity<P>) superEntity, copier);
		}
	}
	
	protected void inheritRelations(Entity<?> superEntity, EcoreUtil.Copier copier) {
		if (superEntity instanceof CompositeEntity) {
			EList<Relation> superRelations = ((CompositeEntity) superEntity).getAllRelations();
			getInheritedRelations().addAll(copier.copyAll(superRelations));
		}
	}

//	protected void mergeEntities(CompositeEntity<?> thisEntity, CompositeEntity<?> superEntity, EcoreUtil.Copier copier) {
//		EList<Entity<?>> thisEntities = thisEntity.getAllEntities(), superEntities = superEntity.getAllEntities();
//		for (Entity<?> thisChildEntity : thisEntities) {
//			Entity<?> superChildEntity = namedSame(thisChildEntity, superEntities, copier);
//			getMergedEntities().add(mergeEntities(thisChildEntity, superChildEntity, copier));
//		}
//		addUnmerged(superEntities, thisEntity.getMergedEntities(), copier);
//	}
	
//	protected void mergeRelations(CompositeEntity<?> thisEntity, CompositeEntity<?> superEntity, EcoreUtil.Copier copier) {
//		EList<Relation> thisRelations = thisEntity.getAllRelations();
//		copyRelations(thisEntity.getAllRelations(), thisEntity.getMergedRelations(), copier);
//		copyRelations(superEntity.getAllRelations(), thisEntity.getMergedRelations(), copier);
//		for (Relation relation : thisEntity.getMergedRelations()) {
//		}
//	}
//
//	protected void copyRelations(EList<Relation> relations, EList<Relation> resultList, EcoreUtil.Copier copier) {
//		for (Relation thisRelation : relations) {
//			resultList.add((Relation) copier.copy(thisRelation));
//		}
//	}
//
//	protected void copyRelation(Relation relation, EcoreUtil.Copier copier) {
//	}

//	protected Entity<?> mergeEntities(Entity<?> thisEntity, Entity<?> superEntity, Copier copier) {
//		Entity<?> merged = createMerged(thisEntity, superEntity, copier);
//		inheritFeatures(thisEntity, superEntity, copier);
//		return merged;
//	}

	//
	
	@Override
	protected void toString(StringBuffer result, int depth) {
		super.toString(result);
		EList<Entity<?>> entities = getAllEntities();
		if (entities.isEmpty()) {
			entities = this.getEntities();
		}
		result.append(" {\n");
		for (Entity<?> entity : entities) {
			((EntityImpl) entity).toString(result, depth + 1);
			result.append("\n");
		}
		EList<Relation> relations = getAllRelations();
		if (relations.isEmpty()) {
			relations = this.getRelations();
		}
		indent(result, depth);
		for (Relation relation : relations) {
			toName(result, relation.getSourcePort(), relation.getContainer());
			result.append(" ->");
			toNames(result, relation.getTargetPorts(), relation.getContainer());
		}
		indent(result, depth);
		result.append("}");
	}

	@Override
	protected String getEntityKindString() {
		return "composite";
	}

	protected void toName(StringBuffer result, EObject eObject, EntityContainer container) {
		if (eObject instanceof Nameable && (! eObject.eIsProxy())) {
			Nameable named = (Nameable) eObject;
			result.append(" ");
			if (named.eContainer() != container) {
				result.append(named.getContainer().getName());
			}
			result.append("." + named.getName());
		}
	}
	
	protected void toNames(StringBuffer result, EList<? extends EObject> nameds, EntityContainer container) {
		for (EObject eObject : nameds) {
			toName(result, eObject, container);
		}
	}

} //CompositeEntityImpl
