package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.ptolemy.graphiti.generic.ActorContainerEditModel;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class AbstractCreateActorFeature extends CreateNameableFeature {

	@Inject(optional=true)
	protected ActorContainerEditModel actorContainerEditModel;

    protected AbstractCreateActorFeature(IFeatureProvider fp, String name, String description) {
        super(fp, name, description);
    }

    public AbstractCreateActorFeature(IFeatureProvider fp, String name) {
    	this(fp, name, "Create " + (name != null ? name : "") + "Actor");
    }

	@Override
	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return (actorContainerEditModel != null) && actorContainerEditModel.isEntity(bo, EntityViewModel.EntityKind.ENTITY_NAMESPACE);
	}

	private <T> T getCreateFeature(Class<T> c) {
		ICreateFeature[] createFeatures = getFeatureProvider().getCreateFeatures();
		for (int i = 0; i < createFeatures.length; i++) {
			if (c.isInstance(createFeatures[i])) {
				return (T) createFeatures[i];
			}
		}
		return null;
	}
	
	@Override
	protected EObject create(ContainerShape targetContainer, EObject actorContainer) {
		String prefix = getNamePrefix();
		String name = actorContainerEditModel.getUniqueName(actorContainer, prefix);
		EObject entity = createActor(name, actorContainer);
        return entity;
	}

	protected String getNamePrefix() {
		return "actor";
	}

	protected EObject createActor(String name, EObject actorContainer) {
		return actorContainerEditModel.createEntity(EntityViewModel.EntityKind.ATOMIC_ACTOR, name, actorContainer);
	}
}
