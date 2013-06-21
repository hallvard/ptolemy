package org.ptolemy.xtext.jvmmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.xactor.EntityFolder;

public class EntitySorter {
	
	private Collection<IEntity<?>> entities;
	
	private IEntity<?> root;
	
	public EntitySorter(IEntity<?> root) {
		this.root = root;
	}

	public Collection<IEntity<?>> sort() {
		entities = new ArrayList<IEntity<?>>();
		doSwitch(root);
		return entities;
	}
	
	private boolean accept(IEntity<?> entity) {
		if (root.eResource() == entity.eResource() && (! entities.contains(entity))) {
			return entities.add(entity);
		}
		return false;
	}

	private boolean doSwitch(IEntity<?> entity) {
		boolean result = false;
		if (entity instanceof Entity<?> && ((Entity<?>) entity).getSuperEntity() != null) {
			EntityRef<?> superEntity = ((Entity<?>) entity).getSuperEntity();
			superEntity.resolve(false);
			accept(superEntity.getRef());
		}
		if (entity instanceof EntityContainer<?>) {
			for (Entity<?> child : ((EntityContainer<?>) entity).getEntities()) {
				result = doSwitch(child) || result;
			}
		}
		if (entity instanceof EntityFolder) {
			for (EntityFolder child : ((EntityFolder) entity).getEntityContainers()) {
				result = doSwitch(child) || result;
			}
		}
		return accept(entity) || result;
	}
}	
