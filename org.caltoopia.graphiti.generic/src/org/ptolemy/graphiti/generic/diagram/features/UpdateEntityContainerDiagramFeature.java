package org.ptolemy.graphiti.generic.diagram.features;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ConnectionContainerViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.actordiagram.PortAnchor;

import com.google.inject.Inject;

public class UpdateEntityContainerDiagramFeature extends UpdateNameableFeature {

	@Inject
	private ActorContainerViewModel actorContainerViewModel;

	@Inject
	private ConnectionContainerViewModel connectionContainerViewModel;

	@Inject
	private ActorViewModel actorViewModel;

	@Inject
    public UpdateEntityContainerDiagramFeature(IFeatureProvider fp) {
        super(fp);
    }
 
	@Override
    public boolean canUpdate(PictogramElement pe) {
		if (! (pe instanceof Diagram)) {
			return false;
		}
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
        return actorContainerViewModel.isEntity(bo, EntityViewModel.EntityKind.COMPOSITE_ACTOR) ||
        	   actorContainerViewModel.isEntity(bo, EntityViewModel.EntityKind.ENTITY_NAMESPACE
        	);
    }

	private EObject findConnectionPortShape(ContainerShape containerShape, EObject port, EObject actor) {
		ContainerShape actorShape = null;
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(containerShape);
		if (actor == null || actor == bo) {
			actorShape = containerShape;
		} else {
			actorShape = (ContainerShape) findModelShape(containerShape, actor);
		}
		return findModelShape(actorShape, port);
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
    	if (actorContainerViewModel.isEntity(bo, EntityViewModel.EntityKind.COMPOSITE_ACTOR)) {
    		changed	= addNeeded(containerShape, actorViewModel.getPorts(bo), reallyUpdate) | changed;
    	}
		if (changed && (! reallyUpdate)) {
			return true;
		}
		changed = addNeeded(containerShape, actorContainerViewModel.getEntities(bo), reallyUpdate) | changed;
    	if (changed && (! reallyUpdate)) {
    		return true;
    	}
    	Collection<? extends EObject> missingConnections = getMissingChildren(containerShape, connectionContainerViewModel.getConnections(bo));
		for (EObject connection : missingConnections) {
    		changed = true;
    		if (! reallyUpdate) {
    			break;
    		}
    		EObject sourcePortShape = findConnectionPortShape(containerShape, connectionContainerViewModel.getSourcePort(connection), connectionContainerViewModel.getSourceActor(connection));
    		EObject targetPortShape = findConnectionPortShape(containerShape, connectionContainerViewModel.getTargetPort(connection), connectionContainerViewModel.getTargetActor(connection));
    		if (sourcePortShape != null && targetPortShape != null) {
    			PortAnchor sourcePortAnchor = LayoutPortFeature.PORT_ANCHOR.get(sourcePortShape);
    			PortAnchor targetPortAnchor = LayoutPortFeature.PORT_ANCHOR.get(targetPortShape);
    			
    			AddConnectionContext addConContext = new AddConnectionContext(sourcePortAnchor, targetPortAnchor);
    			addConContext.setNewObject(connection);
    			getFeatureProvider().addIfPossible(addConContext);
    		}
    	}
		return changed;
    }
}
