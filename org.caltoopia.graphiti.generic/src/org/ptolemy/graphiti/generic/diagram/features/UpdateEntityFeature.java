package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel.EntityKind;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;

import com.google.inject.Inject;

public class UpdateEntityFeature extends UpdateNameableFeature {
 
	@Inject
	private ActorViewModel actorViewModel;
	
	@Inject
    public UpdateEntityFeature(IFeatureProvider fp) {
        super(fp);
    }
 
	@Override
    public boolean canUpdate(PictogramElement pe) {
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
        return pe instanceof EntityShape && actorViewModel.isEntity(bo, null);
    }

	@Override
	protected boolean update(PictogramElement pe, boolean reallyUpdate) {
		boolean changed = super.update(pe, reallyUpdate);
		if (changed && (! reallyUpdate)) {
			return true;
		}
    	ContainerShape containerShape = (ContainerShape) pe;
		changed = removeNeeded(containerShape, reallyUpdate) | changed;
		if (changed && (! reallyUpdate)) {
			return true;
		}
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		if (actorViewModel.isEntity(bo, EntityKind.ACTOR)) {
			changed	= addNeeded(containerShape, actorViewModel.getPorts(bo), reallyUpdate) | changed;
		}
        return changed;
    }
}
