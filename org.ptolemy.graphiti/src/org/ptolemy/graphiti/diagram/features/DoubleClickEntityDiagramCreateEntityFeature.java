package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.actordiagram.EntityContainerDiagram;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DoubleClickEntityDiagramCreateEntityFeature extends DoubleClickCreateFeature {

	@Inject
	public DoubleClickEntityDiagramCreateEntityFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Inject
	public void setCreateFeature(@Named("Entity") ICreateFeature createFeature) {
		super.setCreateFeature(createFeature);
	}
	
	@Override
	protected boolean canExecute(PictogramElement pe, EObject bo, ICustomContext context) {
		return pe instanceof EntityContainerDiagram && super.canExecute(pe, bo, context);
	}
}
