package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.ptolemy.graphiti.generic.EntityViewModel;

public class CreateActorInstanceFeature extends AbstractCreateActorFeature {
 
    private EObject actorPrototype;
    
    public CreateActorInstanceFeature(IFeatureProvider fp, String name, EObject prototype) {
    	super(fp, name, "Create " + (name != null ? name : "") + "Actor");
    	this.actorPrototype = prototype;
    }

	@Override
	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return super.canCreate(targetContainer, bo) && canCreate(actorPrototype);
	}

	boolean canCreate(EObject bo) {
		return actorContainerEditModel.isEntity(bo, EntityViewModel.EntityKind.ACTOR);
	}

	protected EObject createActor(String name, EObject actorContainer) {
		return (actorContainerEditModel.createActorInstance(actorPrototype, name, actorContainer));
	}
}
