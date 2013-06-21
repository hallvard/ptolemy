package org.ptolemy.graphiti.generic.diagram.features.util;

import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.graphiti.platform.ga.IRendererContext;
import org.ptolemy.graphiti.generic.actordiagram.PortGA;

public class ActorDiagramShapeRendererFactory extends GenericShapeRendererFactory {
	
//	@Inject
//	public ActorDiagramShapeRendererFactory(AbstractDiagramTypeProvider diagramTypeProvider) {
//		super(diagramTypeProvider);
//	}

	@Override
	public IGraphicsAlgorithmRenderer createGraphicsAlgorithmRenderer(IRendererContext rendererContext) {
		PlatformGraphicsAlgorithm ga = rendererContext.getPlatformGraphicsAlgorithm();
		if (ga instanceof PortGA) {
			PortGA portGa = (PortGA) ga;
			if (portGa.getPortShape() == null) {
				throw new IllegalStateException("A PortGA must be contained in a PortShape");
			}
			return new PortFigure(portGa);
		}
		return super.createGraphicsAlgorithmRenderer(rendererContext);
	}
}
