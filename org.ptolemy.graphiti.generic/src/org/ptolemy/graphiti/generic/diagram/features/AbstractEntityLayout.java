package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.services.Graphiti;

public class AbstractEntityLayout implements IEntityLayout {

	protected int portSize = LayoutPortFeature.DEFAULT_PORT_SIZE;
	protected int textMinimumHeight = LayoutEntityFeature.ENTITY_NAME_HEIGHT;
	protected float textXAlignment = 0.0f, textYAlignment = 0.0f;
	protected float textRelativeWidth = 1.0f, textRelativeHeight = 0.0f;
	
	@Override
	public GraphicsAlgorithm createGraphicsAlgorithm(GraphicsAlgorithmContainer container) {
		return Graphiti.getGaService().createRectangle(container);
	}

	@Override
	public void layoutGraphicsAlgorithm(GraphicsAlgorithm ga, int x, int y, int width, int height) {
		applyGraphicsAlgorithmLayout(ga, x, y, width, height);
	}

	protected void applyGraphicsAlgorithmLayout(GraphicsAlgorithm ga, int x, int y, int width, int height) {
		Graphiti.getGaService().setLocationAndSize(ga, x, y, width, height);
	}

	public AbstractText createText(GraphicsAlgorithmContainer container) {
		Text text = Graphiti.getGaService().createText(container);
		configureText(text);
		return text;
	}

	protected void configureText(Text text) {
	}

	@Override
	public void layoutText(AbstractText text, int x, int y, int width, int height) {
		int tx = (int) (x + width * textXAlignment);
		int ty = (int) (y + height * textYAlignment);
		int tw = (int) (width * textRelativeWidth);
		int th = (int) Math.max(height * textRelativeHeight, textMinimumHeight);
		applyTextLayout(text, tx, ty, tw, th);
	}
	
	protected void applyTextLayout(AbstractText text, int x, int y, int width, int height) {
		Graphiti.getGaService().setLocationAndSize(text, x, y, width, height);
	}

	@Override
	public Insets getInsets() {
		return new Insets(0, 0, 0, 0);
	}
}
