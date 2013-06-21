package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AddEntityContainerFeature extends AddEntityFeature {

	@Inject
	public AddEntityContainerFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	protected boolean canAdd(ContainerShape targetContainer, EObject bo, Object newObject) {
		return newObject instanceof EObject && entityViewModel.isEntity((EObject) newObject, EntityViewModel.EntityKind.ENTITY_NAMESPACE);
	}

	@Override
	@Inject
	protected void setEntityLayout(@Named("EntityContainer") IEntityLayout entityLayout) {
		super.setEntityLayout(entityLayout);
	}

	@Override
	protected ContainerShape createEntityShape() {
		return actordiagramFactory.createEntityContainerShape();
	}
}
