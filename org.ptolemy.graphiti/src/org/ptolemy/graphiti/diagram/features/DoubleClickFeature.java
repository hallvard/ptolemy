package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public abstract class DoubleClickFeature extends AbstractCustomFeature {

	@Inject
	public DoubleClickFeature(IFeatureProvider fp) {
		super(fp);
	}

	protected boolean canExecute(PictogramElement pe, EObject bo, ICustomContext context) {
		return false;
	}

	protected void execute(PictogramElement pe, EObject bo, ICustomContext context) {
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement pe = context.getInnerPictogramElement();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		return canExecute(pe, bo, context);
	}
	
	@Override
	public void execute(ICustomContext context) {
		PictogramElement pe = context.getInnerPictogramElement();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		execute(pe, bo, context);
	}
}
