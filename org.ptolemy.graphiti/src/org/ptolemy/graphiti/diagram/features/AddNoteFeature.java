package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import com.google.inject.Inject;

public class AddNoteFeature extends AbstractAddFeature {
 
	@Inject
    public AddNoteFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canAdd(IAddContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		return targetContainer instanceof ContainerShape && context.getNewObject() instanceof String;
	}

	@Override
	public PictogramElement add(IAddContext context) {

    	Shape shape = Graphiti.getPeCreateService().createShape(context.getTargetContainer(), true);
        String string = (String) context.getNewObject();
		MultiText text = Graphiti.getGaCreateService().createMultiText(shape, string);
		Graphiti.getGaService().setLocationAndSize(text, context.getX(), context.getY(), 50, 20);

		// link to itself, to indicate it's not a model object
		link(shape, text);
		
        getFeatureProvider().getDirectEditingInfo().setActive(true);
		// provide information to support direct-editing directly
        // after object creation (must be activated additionally)
        IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
        // set container shape for direct editing after object creation
        directEditingInfo.setMainPictogramElement(shape);
        // set shape and graphics algorithm where the editor shall be opened
        directEditingInfo.setPictogramElement(shape);
        directEditingInfo.setGraphicsAlgorithm(text);

        layoutPictogramElement(shape);
        
        return shape;
    }
}
