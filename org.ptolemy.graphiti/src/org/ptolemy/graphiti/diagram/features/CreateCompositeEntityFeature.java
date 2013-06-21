package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.kernel.Entity;

import com.google.inject.Inject;

public class CreateCompositeEntityFeature extends CreateEntityFeature {
 
	@Inject
    public CreateCompositeEntityFeature(IFeatureProvider fp) {
        super(fp, "Composite", "Create composite actor");
    }

    @Override
	protected Entity<?> createActor() {
		return ActorFactory.eINSTANCE.createTypedCompositeActor();
	} 
}
