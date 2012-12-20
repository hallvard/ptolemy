package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.ecore.xactor.EntityFolder;

import com.google.inject.Inject;

public class UpdateEntityFolderDiagramFeature extends UpdateEntityContainerDiagramFeature {
 
	@Inject
    public UpdateEntityFolderDiagramFeature(IFeatureProvider fp) {
        super(fp);
    }
 
	@Override
    public boolean canUpdate(PictogramElement pe, EObject bo) {
        return pe instanceof Diagram && bo instanceof EntityFolder;
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
		EntityFolder entityFolder = (EntityFolder) bo;
		changed	= addNeeded(containerShape, entityFolder.getEntityContainers(), reallyUpdate) | changed;
        return changed;
    }
}
