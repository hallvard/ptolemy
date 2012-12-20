package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.ecore.kernel.Nameable;

import com.google.inject.Inject;

public class DirectEditNameableNameFeature extends AbstractDirectEditingFeature {
 
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
        Object bo = getBusinessObjectForPictogramElement(pe);
		return (ga instanceof Text && bo instanceof Nameable);
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        // return the current name of the EClass
        PictogramElement pe = context.getPictogramElement();
        Nameable named = (Nameable) getBusinessObjectForPictogramElement(pe);
        return ((Nameable) named).getName();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        // null means, that the value is valid
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        // set the new name for the EClass
        PictogramElement pe = context.getPictogramElement();
        ((Nameable) getBusinessObjectForPictogramElement(pe)).setName(value);
//        updatePictogramElement(((Shape) pe).getContainer());
    }
}
