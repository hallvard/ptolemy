package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class UpdateEntityFolderDiagramFeature extends UpdateEntityContainerDiagramFeature {
 
	@Inject
	private ActorContainerViewModel actorContainerViewModel;

	@Inject
    public UpdateEntityFolderDiagramFeature(IFeatureProvider fp) {
        super(fp);
    }
 
	@Override
    public boolean canUpdate(PictogramElement pe) {
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
        return pe instanceof Diagram && actorContainerViewModel.isEntity(bo, EntityViewModel.EntityKind.ENTITY_NAMESPACE);
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
		changed	= addNeeded(containerShape, actorContainerViewModel.getEntities(bo), reallyUpdate) | changed;
        return changed;
    }
}
