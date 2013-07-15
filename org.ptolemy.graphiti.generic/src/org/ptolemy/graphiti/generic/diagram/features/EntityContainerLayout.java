package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.services.Graphiti;

public class EntityContainerLayout extends AbstractEntityLayout {

	@Override
	public GraphicsAlgorithm createGraphicsAlgorithm(GraphicsAlgorithmContainer container) {
		return Graphiti.getGaService().createPolygon(container);
	}

	private int flipHeight = 8, flipWidth = 25;

	@Override
	protected void applyGraphicsAlgorithmLayout(GraphicsAlgorithm ga, int x, int y, int width, int height) {
		Polygon polygon = (Polygon) ga;
		int[] xy = new int[] {
			0, flipHeight,
			flipHeight, 0,
			flipHeight + flipWidth, 0,
			flipHeight + flipWidth + flipHeight, flipHeight, 
			width, flipHeight,
			width, height,
			0, height
		};
		Util.setPoints(polygon, xy);
	}
	
	@Override
	protected void applyTextLayout(AbstractText text, int x, int y, int width, int height) {
		super.applyTextLayout(text, x + flipHeight / 2, flipHeight, width, height);
	}
}
