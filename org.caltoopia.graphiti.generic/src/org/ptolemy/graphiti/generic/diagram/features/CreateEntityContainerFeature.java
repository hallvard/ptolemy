package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class CreateEntityContainerFeature extends CreateActorFeature {

	@Inject
	public CreateEntityContainerFeature(IFeatureProvider fp) {
		super(fp, EntityViewModel.EntityKind.COMPOSITE_ACTOR);
	}

	@Override
	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return super.canCreate(targetContainer, bo) && (! actorContainerEditModel.isEntity(bo, EntityViewModel.EntityKind.ACTOR));
	}
}
