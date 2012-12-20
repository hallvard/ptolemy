package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DoubleClickCreateFeature extends AbstractCustomFeature {

	@Inject
	public DoubleClickCreateFeature(IFeatureProvider fp) {
		super(fp);
	}

	private ICreateFeature createFeature;

	@Inject
	public void setCreateFeature(@Named("Entity") ICreateFeature createFeature) {
		this.createFeature = createFeature;
	}
	
	protected ICreateFeature getCreateFeature(ICreateContext createContext) {
		if (createFeature != null && createFeature.canCreate(createContext)) {
			return createFeature;
		}
		ICreateFeature[] createFeatures = getFeatureProvider().getCreateFeatures();
		for (int i = 0; i < createFeatures.length; i++) {
			if (createFeatures[i].canCreate(createContext)) {
				return createFeatures[i];
			}
		}
		return null;
	}
	
	@Override
	public String getName() {
		return (createFeature != null ? createFeature.getName() : "Double-click create");
	}

	@Override
	public String getDescription() {
		return (createFeature != null ? createFeature.getDescription() : "Double-click to create");
	}
	
	@Override
	public boolean canExecute(ICustomContext context) {
		CreateContext createContext = getCreateContext(context);
		return createContext != null && getCreateFeature(createContext) != null;
	}
	
	@Override
	public void execute(ICustomContext context) {
		CreateContext createContext = getCreateContext(context);
		if (createContext != null) {
			getCreateFeature(createContext).execute(createContext);
		}
	}
	
	protected CreateContext getCreateContext(ICustomContext context) {
		PictogramElement pe = context.getInnerPictogramElement();
		if (pe instanceof ContainerShape) {
			CreateContext createContext = new CreateContext();
			createContext.setTargetContainer((ContainerShape) pe);
			if (context instanceof IDoubleClickContext) {
				createContext.setX(((IDoubleClickContext) context).getX());
				createContext.setY(((IDoubleClickContext) context).getY());
			}
			return createContext;
		}
		return null;
	}
}
