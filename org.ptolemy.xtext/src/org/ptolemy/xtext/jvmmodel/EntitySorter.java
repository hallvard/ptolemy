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
	
	private final IEntity<?> root;
	
	private final boolean includeSuperEntities;
	
	public EntitySorter(IEntity<?> root, boolean includeSuperEntities) {
		this.root = root;
		this.includeSuperEntities = includeSuperEntities;
	}

	public Collection<IEntity<?>> sort() {
		entities = new ArrayList<IEntity<?>>();
		doSwitch(root);
		return entities;
	}
	
	private boolean accept(IEntity<?> entity) {
		if ((! entities.contains(entity)) && root.eResource() == entity.eResource()) {
			return entities.add(entity);
		}
		return false;
	}

	private boolean doSwitch(IEntity<?> entity) {
		boolean result = false;
		if (includeSuperEntities && entity instanceof Entity<?> && ((Entity<?>) entity).getSuperEntity() != null) {
			EntityRef<?> superEntity = ((Entity<?>) entity).getSuperEntity();
			accept(superEntity);
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
