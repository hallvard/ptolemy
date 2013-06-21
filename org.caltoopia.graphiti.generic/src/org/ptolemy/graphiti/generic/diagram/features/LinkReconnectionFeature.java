package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;

public class LinkReconnectionFeature extends DefaultReconnectionFeature {

	public LinkReconnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		return true;
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		super.preReconnect(context);
	}

	@Override
	public void postReconnect(IReconnectionContext context) {
		super.postReconnect(context);
	}
}
