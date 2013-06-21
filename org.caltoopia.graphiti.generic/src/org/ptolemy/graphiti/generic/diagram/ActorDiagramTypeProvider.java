package org.ptolemy.graphiti.generic.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRendererFactory;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

import com.google.inject.Inject;

public class ActorDiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;

	@Inject
	public void setFeatureProvider(IFeatureProvider featureProvider) {
		super.setFeatureProvider(featureProvider);
	}

	@Inject
	private ActorDiagramToolBehaviorProvider toolBehaviorProvider;
	
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] {
					toolBehaviorProvider, // new ActorDiagramToolBehaviorProvider(this)
			};
		}
		return toolBehaviorProviders;
	}

	@Inject
	private IGraphicsAlgorithmRendererFactory gaRendererFactory;
	
	@Override
	public IGraphicsAlgorithmRendererFactory getGraphicsAlgorithmRendererFactory() {
		return gaRendererFactory;
	}

	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}
}
