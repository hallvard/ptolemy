package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class CreateActorFeature extends AbstractCreateActorFeature {
 
    private EntityViewModel.EntityKind entityKind;
 
    public CreateActorFeature(IFeatureProvider fp, EntityViewModel.EntityKind entityKind) {
    	super(fp, entityKind.name(), "Create " + entityKind.name());
    }

    @Inject
    public CreateActorFeature(IFeatureProvider fp) {
    	this(fp, EntityViewModel.EntityKind.ATOMIC_ACTOR);
    }

    @Override
	protected EObject createActor(String name, EObject actorContainer) {
		return actorContainerEditModel.createEntity(entityKind, name, actorContainer);
	}
}
