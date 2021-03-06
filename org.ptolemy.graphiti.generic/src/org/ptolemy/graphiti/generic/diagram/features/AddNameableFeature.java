package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.NameViewModel;
import org.ptolemy.graphiti.generic.actordiagram.IconShape;
import org.ptolemy.graphiti.generic.actordiagram.LabelShape;
import org.ptolemy.graphiti.generic.diagram.features.util.GenericShapeRendererFactory;
import org.ptolemy.graphiti.generic.diagram.features.util.IconImageProvider;

import com.google.inject.Inject;

public abstract class AddNameableFeature extends AbstractAddShapeFeature {

	@Inject
	protected EntityViewModel entityViewModel;

	@Inject
	public AddNameableFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canAdd(IAddContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(targetContainer);
		Object newObject = context.getNewObject();
		return canAdd(targetContainer, bo, newObject);
	}

	protected boolean canAdd(ContainerShape targetContainer, EObject bo, Object newObject) {
		return false;
	}

	protected void setLabel(LabelShape labelShape, EObject named, AbstractText text) {
		if (named != null) {
			text.setValue(entityViewModel.getName(named));
		}
		labelShape.setLabel(text);

		// provide information to support direct-editing directly
        // after object creation (must be activated additionally)
        IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
        // set container shape for direct editing after object creation
        directEditingInfo.setMainPictogramElement((PictogramElement) labelShape);
        // set shape and graphics algorithm where the editor shall be opened
        directEditingInfo.setPictogramElement((PictogramElement) labelShape);
        directEditingInfo.setGraphicsAlgorithm(text);
	}
}
