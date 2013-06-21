package org.ptolemy.graphiti.diagram.features.util;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.graphiti.platform.ga.IRendererContext;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.ptolemy.graphiti.actordiagram.PortGA;

import com.google.inject.Inject;

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
