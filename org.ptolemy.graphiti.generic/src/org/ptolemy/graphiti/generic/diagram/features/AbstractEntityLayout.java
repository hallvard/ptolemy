package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.generic.diagram.features.util.GenericShapeRendererFactory;
import org.ptolemy.graphiti.generic.diagram.features.util.IconImageProvider;

import com.google.inject.Inject;

public class AbstractEntityLayout implements IEntityLayout {

	protected int portSize = LayoutPortFeature.DEFAULT_PORT_SIZE;
	
	protected float textXAlignment = 0.0f, textYAlignment = 0.0f;
	protected float textRelativeWidth = 1.0f, textRelativeHeight = 0.0f;
	protected int textMinimumHeight = LayoutEntityFeature.ENTITY_NAME_HEIGHT;

	protected float iconXAlignment = 0.5f, iconYAlignment = 0.5f;
	protected float iconRelativeWidth = 1.0f, iconRelativeHeight = 1.0f;
	
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
		applyLayout(text, x, y, width, height);
	}

	protected void applyLayout(GraphicsAlgorithm ga, int x, int y, int width, int height) {
		Graphiti.getGaService().setLocationAndSize(ga, x, y, width, height);
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(0, 0, 0, 0);
	}

	@Inject
	private IconImageProvider iconImageProvider; 
	
	public String getIconUrl(EObject model) {
		return iconImageProvider.getIconImageURL(model);
	}

	public PlatformGraphicsAlgorithm createIcon(GraphicsAlgorithmContainer container, EObject model) {
		String iconUrl = getIconUrl(model);
		String iconId = (iconUrl != null ? GenericShapeRendererFactory.createImageIdForURL(iconUrl) : null);
		PlatformGraphicsAlgorithm pga = Graphiti.getGaService().createPlatformGraphicsAlgorithm(container, iconId);
		return pga;
	}

	@Override
	public void layoutIcon(PlatformGraphicsAlgorithm pga, int x, int y, int width, int height) {
		int tw = (int) (width * iconRelativeWidth);
		int th = (int) (height * iconRelativeHeight);
		int tx = (int) (x + (width - tw) * iconXAlignment);
		int ty = (int) (y + (height - th) * iconYAlignment);
		applyIconLayout(pga, tx, ty, tw, th);
	}
	
	protected void applyIconLayout(PlatformGraphicsAlgorithm pga, int x, int y, int width, int height) {
		applyLayout(pga, x, y, width, height);
	}
}
