package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;
import org.ptolemy.graphiti.actordiagram.ModelShape;
import org.ptolemy.graphiti.actordiagram.PortAnchor;

import com.google.inject.Inject;

public class UpdateEntityContainerDiagramFeature extends UpdateNameableFeature {
 
	@Inject
    public UpdateEntityContainerDiagramFeature(IFeatureProvider fp) {
        super(fp);
    }
 
	@Override
    public boolean canUpdate(PictogramElement pe, EObject bo) {
        return pe instanceof Diagram && bo instanceof EntityContainer<?>;
    }

	@Override
	protected boolean update(PictogramElement pe, EObject bo, boolean reallyUpdate) {
		boolean changed = super.update(pe, bo, reallyUpdate);
		if (changed && (! reallyUpdate)) {
			return true;
		}
    	ContainerShape containerShape = (ContainerShape) pe;
    	changed = removeNeeded(containerShape, reallyUpdate) | changed;
    	if (changed && (! reallyUpdate)) {
    		return true;
    	}
    	EntityContainer<?> entityContainer = (EntityContainer<?>) bo;
    	changed = addNeeded(containerShape, entityContainer.getEntities(), reallyUpdate) | changed;
    	if (changed && (! reallyUpdate)) {
    		return true;
    	}
    	for (Relation relation : getMissingChildren(containerShape, entityContainer.getRelations())) {
    		changed = true;
    		if (! reallyUpdate) {
    			break;
    		}
    		Port sourcePort = relation.getSourcePort();
    		ModelShape<?> sourceEntityShape = findModelShape(containerShape, sourcePort.getContainer());
    		ModelShape<?> sourcePortShape = findModelShape((ContainerShape) sourceEntityShape, (Port) sourcePort);
    		PortAnchor sourcePortAnchor = LayoutPortFeature.PORT_ANCHOR.get(sourcePortShape);
    		Port targetPort = relation.getTargetPorts().get(0); 
    		ModelShape<?> targetEntityShape = findModelShape(containerShape, targetPort.getContainer());
    		ModelShape<?> targetPortShape = findModelShape((ContainerShape) targetEntityShape, (Port) targetPort);
    		PortAnchor targetPortAnchor = LayoutPortFeature.PORT_ANCHOR.get(targetPortShape);
    		AddConnectionContext addConContext = new AddConnectionContext(sourcePortAnchor, targetPortAnchor);
    		addConContext.setNewObject(relation);
    		getFeatureProvider().addIfPossible(addConContext);
    	}
		return changed;
    }
}
