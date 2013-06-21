package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class CreateCompositeEntityFeature extends CreateActorFeature {
 
	@Inject
    public CreateCompositeEntityFeature(IFeatureProvider fp) {
        super(fp, EntityViewModel.EntityKind.COMPOSITE_ACTOR);
    }
}
