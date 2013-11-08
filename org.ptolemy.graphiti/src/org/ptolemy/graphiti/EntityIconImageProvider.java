package org.ptolemy.graphiti;

import org.eclipse.emf.ecore.EObject;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.graphiti.generic.diagram.features.util.SimpleIconImageProvider;

public class EntityIconImageProvider extends SimpleIconImageProvider {

	@Override
	public String getIconImageURL(EObject model) {
		if (model instanceof Entity<?>) {
			Entity<?> entity = (Entity<?>) model;
			while (entity != null) {
				String url = getIconImageURLForName(entity, entity.getFullName());
				if (url == null) {
					url = getIconImageURLForName(entity, entity.getName());
				}
				if (url != null) {
					return url;
				}
				EntityRef<?> superEntity = entity.getSuperEntity();
				entity = (superEntity != null ? superEntity.getRef() : null);
			}
		}
		return super.getIconImageURL(model);
	}
}
