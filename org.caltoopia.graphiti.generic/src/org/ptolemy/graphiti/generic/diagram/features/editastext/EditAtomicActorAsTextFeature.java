package org.ptolemy.graphiti.generic.diagram.features.editastext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class EditAtomicActorAsTextFeature extends AbstractEditAsTextFeature {

	@Inject
	public EditAtomicActorAsTextFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(EObject bo) {
		return actorViewModel.isEntity(bo, EntityViewModel.EntityKind.ATOMIC_ACTOR);
	}
}
