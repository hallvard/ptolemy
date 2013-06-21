package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.google.inject.Inject;

public class DirectEditNoteFeature extends AbstractDirectEditingFeature {
 
	@Inject
    public DirectEditNoteFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public int getEditingType() {
        return TYPE_TEXT;
    }
 
    @Override
    public boolean canDirectEdit(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
        Object bo = getBusinessObjectForPictogramElement(pe);
		return (ga instanceof AbstractText && bo == ga);
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        // return the current name of the EClass
        PictogramElement pe = context.getPictogramElement();
        return ((AbstractText) getBusinessObjectForPictogramElement(pe)).getValue();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        // null means, that the value is valid
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        // set the new name for the EClass
        PictogramElement pe = context.getPictogramElement();
        ((AbstractText) getBusinessObjectForPictogramElement(pe)).setValue(value);
    }
}
