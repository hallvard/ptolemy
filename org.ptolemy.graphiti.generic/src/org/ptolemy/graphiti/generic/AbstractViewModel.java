package org.ptolemy.graphiti.generic;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ptolemy.graphiti.generic.ActorViewModel.PortKind;
import org.ptolemy.graphiti.generic.EntityViewModel.EntityKind;

public abstract class AbstractViewModel implements NameViewModel {

	// from NameViewModel

	/**
	 * Returns the (simple) name of the eObject
	 * @param eObject
	 * @return
	 */
	@Override
	public String getName(EObject eObject) {
		EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
		return (nameFeature != null && (! eObject.eIsProxy()) ? (String) eObject.eGet(nameFeature) : null);
	}

	/**
	 * Returns the qualified name of the eObject
	 * @param eObject
	 * @return
	 */
	@Override
	public String getQualifiedEntityName(EObject eObject) {
		StringBuilder buffer = new StringBuilder(getName(eObject));
		while (eObject.eContainer() != null) {
			eObject = eObject.eContainer();
			String name = getName(eObject);
			if (name != null) {
				buffer.insert(0, ".");
				buffer.insert(0, name);
			}
		}
		return buffer.toString();
	}
	
	/**
	 * Returns the owning eObject within which the name must be unique
	 * @return
	 */
	@Override
	public EObject getNamespace(EObject eObject) {
		return eObject.eContainer();
	}

	// from NameEditModel

	/**
	 * Sets the (simple) name of the eObject to the provided name
	 * @param eObject
	 * @param name
	 * @return
	 */
//	will @Override if NameEditModel is implemented
	public String setName(EObject eObject, String name) {
		eObject.eSet(eObject.eClass().getEStructuralFeature("name"), name);
		return getName(eObject);
	}
	
	protected boolean isUsed(EObject container, String name) {
		for (EObject child : container.eContents()) {
			String childName = getName(child);
			if (name.equals(childName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a unique name in this container, with the provided prefix
	 * @return
	 */
//	will @Override if NameEditModel is implemented
	public String getUniqueName(EObject eObject, String prefix) {
		int count = 1;
		while (isUsed(eObject, prefix + count)) {
			count++;
		}
		return prefix + count;
	}
	
	// support for ActorViewModel

	protected abstract boolean isPort(EObject port, PortKind portKind);
	
	protected void addPorts(Collection<? extends EObject> ports, PortKind portsKind, PortKind[] portKinds, Collection<EObject> allPorts) {
		if (portKinds == null || portKinds.length == 0) {
			allPorts.addAll(ports);
		} else {
			for (PortKind portKind : portKinds) {
				if (portsKind == null) {
					for (EObject port : ports) {
						if (isPort(port, portKind)) {
							allPorts.add(port);
						}
					}
				} else if (portKind == portsKind) {
					allPorts.addAll(ports);
					break;
				}
			}
		}
	}
	
	protected abstract boolean isEntity(EObject entity, EntityKind entityKind);
	
	protected void addEntities(Collection<? extends EObject> entities, EntityKind entitiesKind, EntityKind[] entityKinds, Collection<EObject> allEntities) {
		if (entityKinds == null || entityKinds.length == 0) {
			allEntities.addAll(entities);
		} else {
			for (EntityKind entityKind : entityKinds) {
				if (entityKind == null) {
					for (EObject entity : entities) {
						if (isEntity(entity, entityKind)) {
							allEntities.add(entity);
						}
					}
				} else if (entityKind == entitiesKind) {
					allEntities.addAll(entities);
					break;
				}
			}
		}
	}
}
