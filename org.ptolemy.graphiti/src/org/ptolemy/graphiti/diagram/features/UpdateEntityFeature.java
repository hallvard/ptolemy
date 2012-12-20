package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.graphiti.actordiagram.EntityShape;

import com.google.inject.Inject;

public class UpdateEntityFeature extends UpdateNameableFeature {
 
	@Inject
    public UpdateEntityFeature(IFeatureProvider fp) {
        super(fp);
    }
 
	@Override
    public boolean canUpdate(PictogramElement pe, EObject bo) {
        return pe instanceof EntityShape && bo instanceof Entity;
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
		Entity<?> entity = (Entity<?>) bo;
		changed	= addNeeded(containerShape, entity.getAllPorts(), reallyUpdate) | changed;
        return changed;
    }
}
