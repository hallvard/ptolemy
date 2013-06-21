/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.InternalEList;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getSourceEntities <em>Source Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getTargetEntities <em>Target Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getSuperEntity <em>Super Entity</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getInheritedAttributes <em>Inherited Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getInheritedPorts <em>Inherited Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getAllAttributes <em>All Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.impl.EntityImpl#getAllPorts <em>All Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl<P extends Port> extends NamedObjImpl implements Entity<P> {
	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<P> ports;

	/**
	 * The cached value of the '{@link #getSuperEntity() <em>Super Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperEntity()
	 * @generated
	 * @ordered
	 */
	protected EntityRef<P> superEntity;
	/**
	 * The cached value of the '{@link #getInheritedAttributes() <em>Inherited Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> inheritedAttributes;

	/**
	 * The cached value of the '{@link #getInheritedPorts() <em>Inherited Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<P> inheritedPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<P> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentEList<P>(Port.class, this, KernelPackage.ENTITY__PORTS);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Entity<?>> getSourceEntities() {
		EList<Entity<?>> result = new BasicEList<Entity<?>>();
		EntityContainer<?> container = getContainer();
		if (container != null) {
			for (Relation relation : container.getRelations()) {
				for (Port targetPort : relation.getTargetPorts()) {
					if (targetPort.getContainer() == this) {
						Entity<?> sourceEntity = relation.getSourcePort().getContainer();
						if (sourceEntity != null && sourceEntity.getContainer() == container && (! result.contains(sourceEntity))) {
							result.add(sourceEntity);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Entity<?>> getTargetEntities() {
		EList<Entity<?>> result = new BasicEList<Entity<?>>();
		EntityContainer<?> container = getContainer();
		if (container != null) {
			for (Relation relation : container.getRelations()) {
				Port sourcePort = relation.getSourcePort();
				if (sourcePort != null && sourcePort.getContainer() == this) {
					for (Port targetPort : relation.getTargetPorts()) {
						Entity<?> targetEntity = targetPort.getContainer();
						if (targetEntity != null && targetEntity.getContainer() == container && (! result.contains(targetEntity))) {
							result.add(targetEntity);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRef<P> getSuperEntity() {
		return superEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperEntity(EntityRef<P> newSuperEntity, NotificationChain msgs) {
		EntityRef<P> oldSuperEntity = superEntity;
		superEntity = newSuperEntity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.ENTITY__SUPER_ENTITY, oldSuperEntity, newSuperEntity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperEntity(EntityRef<P> newSuperEntity) {
		if (newSuperEntity != superEntity) {
			NotificationChain msgs = null;
			if (superEntity != null)
				msgs = ((InternalEObject)superEntity).eInverseRemove(this, KernelPackage.ENTITY_REF__OWNER, EntityRef.class, msgs);
			if (newSuperEntity != null)
				msgs = ((InternalEObject)newSuperEntity).eInverseAdd(this, KernelPackage.ENTITY_REF__OWNER, EntityRef.class, msgs);
			msgs = basicSetSuperEntity(newSuperEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ENTITY__SUPER_ENTITY, newSuperEntity, newSuperEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Attribute> getInheritedAttributes() {
		if (inheritedAttributes == null) {
			inheritedAttributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, KernelPackage.ENTITY__INHERITED_ATTRIBUTES);
			// will populate the list
			resolveSuperEntity(false);
		}
		return inheritedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<P> getInheritedPorts() {
		if (inheritedPorts == null) {
			inheritedPorts = new EObjectContainmentEList<P>(Port.class, this, KernelPackage.ENTITY__INHERITED_PORTS);
			// will populate the list
			resolveSuperEntity(false);
		}
		return inheritedPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Attribute> getAllAttributes() {
		EList<Attribute> inheritedAttributes = getInheritedAttributes();
		if (inheritedAttributes.isEmpty()) {
			return getAttributes();
		}
		BasicEList<Attribute> allAttributes = new BasicEList<Attribute>(getAttributes());
		allAttributes.addAll(inheritedAttributes);
		return allAttributes;
	}

	@Override
	public Attribute getAttribute(String name) {
		Attribute attribute = getNamed(name, this, KernelPackage.eINSTANCE.getNamedObj_Attributes());
		if (attribute == null) {
			attribute = getNamed(name, this, KernelPackage.eINSTANCE.getEntity_InheritedAttributes());
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<P> getAllPorts() {
		EList<P> inheritedPorts = getInheritedPorts();
		EList<P> ownPorts = getPorts();
		if (inheritedPorts.isEmpty()) {
			return ownPorts;
		}
		BasicEList<P> allPorts = new BasicEList<P>(ownPorts);
		allPorts.addAll(inheritedPorts);
		return allPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntityContainer getContainer() {
		return (eContainer() instanceof EntityContainer ? (EntityContainer) eContainer() : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public P getPort(String name) {
		Port port = getNamed(name, this, KernelPackage.eINSTANCE.getEntity_Ports());
		if (port == null) {
			port = getNamed(name, this, KernelPackage.eINSTANCE.getEntity_InheritedPorts());
		}
		return (P) port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean resolveSuperEntity(boolean force) {
		boolean resolved = false;
		EntityRef<? super P> superEntityRef = getSuperEntity();
		if (superEntityRef != null) {
			resolved = superEntityRef.resolve(force);
		}
//		if (resolved || force) {
//			updateInheritedFeatures();
//		}
		return resolved;
	}

	protected void updateInheritedFeatures() {
		clearInheritedFeatures();
		Entity<? super P> superEntity = null;
		EntityRef<? super P> superEntityRef = getSuperEntity();
		if (superEntityRef != null) {
			superEntity = superEntityRef.getResolved();
//			Entity<P> resolvedSuperEntity = superEntityRef.getResolved();
//			superEntity = (resolvedSuperEntity != null ? EcoreUtil.copy(resolvedSuperEntity) : null);
			if (superEntity != null) {
				superEntity.resolveSuperEntity(true);
			}
		}
		if (superEntity != null) {
			Copier copier = createCopier(superEntityRef);
			inheritFeatures(superEntity, copier);
			copier.copyReferences();
		}
	}

	protected EcoreUtil.Copier createCopier(EntityRef<? super P> entityRef) {
		return new EcoreUtil.Copier();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void entityResolved(EStructuralFeature feature) {
		if (feature == KernelPackage.eINSTANCE.getEntity_SuperEntity()) {
			updateInheritedFeatures();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.ENTITY__SUPER_ENTITY:
				if (superEntity != null)
					msgs = ((InternalEObject)superEntity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.ENTITY__SUPER_ENTITY, null, msgs);
				return basicSetSuperEntity((EntityRef<P>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.ENTITY__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
			case KernelPackage.ENTITY__SUPER_ENTITY:
				return basicSetSuperEntity(null, msgs);
			case KernelPackage.ENTITY__INHERITED_ATTRIBUTES:
				return ((InternalEList<?>)getInheritedAttributes()).basicRemove(otherEnd, msgs);
			case KernelPackage.ENTITY__INHERITED_PORTS:
				return ((InternalEList<?>)getInheritedPorts()).basicRemove(otherEnd, msgs);
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
			case KernelPackage.ENTITY__PORTS:
				return getPorts();
			case KernelPackage.ENTITY__SOURCE_ENTITIES:
				return getSourceEntities();
			case KernelPackage.ENTITY__TARGET_ENTITIES:
				return getTargetEntities();
			case KernelPackage.ENTITY__SUPER_ENTITY:
				return getSuperEntity();
			case KernelPackage.ENTITY__INHERITED_ATTRIBUTES:
				return getInheritedAttributes();
			case KernelPackage.ENTITY__INHERITED_PORTS:
				return getInheritedPorts();
			case KernelPackage.ENTITY__ALL_ATTRIBUTES:
				return getAllAttributes();
			case KernelPackage.ENTITY__ALL_PORTS:
				return getAllPorts();
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
			case KernelPackage.ENTITY__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends P>)newValue);
				return;
			case KernelPackage.ENTITY__SUPER_ENTITY:
				setSuperEntity((EntityRef<P>)newValue);
				return;
			case KernelPackage.ENTITY__INHERITED_ATTRIBUTES:
				getInheritedAttributes().clear();
				getInheritedAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case KernelPackage.ENTITY__INHERITED_PORTS:
				getInheritedPorts().clear();
				getInheritedPorts().addAll((Collection<? extends P>)newValue);
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
			case KernelPackage.ENTITY__PORTS:
				getPorts().clear();
				return;
			case KernelPackage.ENTITY__SUPER_ENTITY:
				setSuperEntity((EntityRef<P>)null);
				return;
			case KernelPackage.ENTITY__INHERITED_ATTRIBUTES:
				getInheritedAttributes().clear();
				return;
			case KernelPackage.ENTITY__INHERITED_PORTS:
				getInheritedPorts().clear();
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
			case KernelPackage.ENTITY__PORTS:
				return ports != null && !ports.isEmpty();
			case KernelPackage.ENTITY__SOURCE_ENTITIES:
				return !getSourceEntities().isEmpty();
			case KernelPackage.ENTITY__TARGET_ENTITIES:
				return !getTargetEntities().isEmpty();
			case KernelPackage.ENTITY__SUPER_ENTITY:
				return superEntity != null;
			case KernelPackage.ENTITY__INHERITED_ATTRIBUTES:
				return inheritedAttributes != null && !inheritedAttributes.isEmpty();
			case KernelPackage.ENTITY__INHERITED_PORTS:
				return inheritedPorts != null && !inheritedPorts.isEmpty();
			case KernelPackage.ENTITY__ALL_ATTRIBUTES:
				return !getAllAttributes().isEmpty();
			case KernelPackage.ENTITY__ALL_PORTS:
				return !getAllPorts().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	//
	
//	@Override
//	public String getName() {
//		String name = super.getName();
//		return (name != null ? name : getDefaultName());
//	}
//
//	protected String getDefaultBaseName() {
//		return "entity";
//	}
//
//	@Override
//	protected boolean isSameKind(Nameable named) {
//		return named instanceof Entity;
//	}
//
//	@Override
//	protected EList<? extends Nameable> getSameObjects() {
//		return getContainer().getEntities();
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		toString(result, 0);
		return result.toString();
	}
	
	protected void toString(StringBuffer result, int depth) {
		indent(result, depth);
		result.append(getEntityKindString() + " ");
		super.toString(result);
		if (getSuperEntity() != null && getSuperEntity().getRef() != null) {
			result.append(" is " + getSuperEntity().getRef().getName());
		}
		EList<P> ports = getAllPorts();
		if (ports.isEmpty()) {
			ports = this.getPorts();
		}
		for (Port port : ports) {
			result.append(" ");
			result.append(port.toString());
		}
		EList<Attribute> attributes = getAllAttributes();
		if (attributes.isEmpty()) {
			attributes = this.getAttributes();
		}
		for (Attribute attribute : attributes) {
			result.append(" ");
			result.append(attribute.toString());
		}
	}

	protected String getEntityKindString() {
		return "entity";
	}

	protected void indent(StringBuffer result, int depth) {
		for (int i = 0; i < depth; i++) {
			result.append("  ");
		}
	}

	//
	
	protected void clearInheritedFeatures() {
		if (inheritedAttributes != null) {
			inheritedAttributes.clear();
		}
		if (inheritedPorts != null) {
			inheritedPorts.clear();
		}
	}

	protected void inheritFeatures(Entity<?> superEntity, EcoreUtil.Copier copier) {
		inheritAttributes(superEntity, copier);
		inheritPorts(superEntity, copier);
	}

	protected void inheritAttributes(Entity<?> superEntity, EcoreUtil.Copier copier) {
		EList<Attribute> superAttributes = superEntity.getAllAttributes();
		if (! superAttributes.isEmpty()) {
			getInheritedAttributes().addAll(copier.copyAll(superAttributes));
		}
	}

//	protected <T extends Nameable> T namedSame(T thisElement, EList<T> superElements, EcoreUtil.Copier copier) {
//		T superElement = getNamed(thisElement.getName(), superElements);
//		if (superElement != null) {
//			return superElement;
//		}
//		return null;
//	}
//
//	protected void mergeAttributes(Attribute attribute, EList<Attribute> otherAttributes, EList<Attribute> merged, EcoreUtil.Copier copier) {
//		if (! copier.containsKey(attribute)) {
//			Attribute otherAttribute = namedSame(attribute, otherAttributes, copier);
//			Attribute mergedAttribute = createMerged(attribute, otherAttribute, copier);
//			merged.add(mergedAttribute);
//		}
//	}
//
//	protected <T> void addUnmerged(EList<T> elements, EList<T> mergedElements, EcoreUtil.Copier copier) {
//		for (T element : elements) {
//			if (! copier.containsKey(element)) {
//				mergedElements.add(element);
//			}
//		}
//	}
//	
//	protected <T extends Nameable> T createMerged(T thisElement, T superElement, EcoreUtil.Copier copier) {
//		EClass thisClass = thisElement.eClass();
//		if (superElement != null) {
//			EClass superClass = superElement.eClass();
//			if (! superClass.isSuperTypeOf(thisClass)) {
//				throw new IllegalArgumentException(thisClass.getName() + " + is not a subclass of " + superClass.getName() + ", so can't merge " + thisElement + " and " + superElement);
//			}
//		}
//		T merged = (T) EcoreUtil.create(thisClass);
//		if (thisElement != merged) {
//			copier.put(thisElement, merged);
//		}
//		if (superElement != null && superElement != merged) {
//			copier.put(superElement, merged);
//		}
//		merged.setName(thisElement.getName());
//		return merged;
//	}
	
	protected void inheritPorts(Entity<? extends Port> superEntity, EcoreUtil.Copier copier) {
		EList<? extends Port> superPorts = superEntity.getAllPorts();
		if (! superPorts.isEmpty()) {
			getInheritedPorts().addAll((Collection<? extends P>) copier.copyAll(superPorts));
		}
	}

//	private <T extends Nameable> T merge(T element, EList<T> others, EList<T> merged, EcoreUtil.Copier copier) {
//		if (! copier.containsKey(element)) {
//			T otherElement = namedSame(element, others, copier);
//			T mergedElement = createMerged(element, otherElement, copier);
//			merged.add(mergedElement);
//			return mergedElement;
//		}
//		return null;
//	}
//
//	protected void mergePorts(Port port, Port mergedPort, EcoreUtil.Copier copier) {
//	}

} //EntityImpl
