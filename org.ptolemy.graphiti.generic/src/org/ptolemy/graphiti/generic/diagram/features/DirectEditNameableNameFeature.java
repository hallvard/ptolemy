package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.NameEditModel;

import com.google.inject.Inject;

public class DirectEditNameableNameFeature extends AbstractDirectEditingFeature {
 
	@Inject
	private ILinkService linkService;
	
	@Inject
	private ActorViewModel actorViewModel;

	@Inject(optional=true)
	private NameEditModel nameEditModel;
	
	@Inject
    public DirectEditNameableNameFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public int getEditingType() {
        return TYPE_TEXT;
    }
 
    @Override
    public boolean canDirectEdit(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		return (ga instanceof Text && (
					actorViewModel.isEntity(bo, null) ||
					actorViewModel.isPort(bo, null)
				));
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        // return the current name of the EClass
        PictogramElement pe = context.getPictogramElement();
        EObject named = (EObject) getBusinessObjectForPictogramElement(pe);
        return actorViewModel.getName(named);
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
    	if (nameEditModel != null) {
    		PictogramElement pe = context.getPictogramElement();
    		nameEditModel.setName((EObject) getBusinessObjectForPictogramElement(pe), value);
//        updatePictogramElement(((Shape) pe).getContainer());
    	}
    }
}
