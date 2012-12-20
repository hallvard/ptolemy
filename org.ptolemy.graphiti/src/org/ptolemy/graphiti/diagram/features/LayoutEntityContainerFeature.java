package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.ptolemy.graphiti.actordiagram.EntityContainerShape;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class LayoutEntityContainerFeature extends AbstractLayoutEntityFeature {

	@Inject
	public LayoutEntityContainerFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canLayout(ILayoutContext context) {
		return (context.getPictogramElement() instanceof EntityContainerShape);
	}

	@Inject
	protected void setEntityLayout(@Named("EntityContainer") IEntityLayout entityLayout) {
		super.setEntityLayout(entityLayout);
	}
}
