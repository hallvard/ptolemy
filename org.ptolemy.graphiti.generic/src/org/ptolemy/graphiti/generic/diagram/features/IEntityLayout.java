package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;

public interface IEntityLayout {
	public GraphicsAlgorithm createGraphicsAlgorithm(GraphicsAlgorithmContainer container);
	public void layoutGraphicsAlgorithm(GraphicsAlgorithm ga, int x, int y, int width, int height);
	public AbstractText createText(GraphicsAlgorithmContainer container);
	public void layoutText(AbstractText text, int x, int y, int width, int height);
	public Insets getInsets();
	public String getIconUrl(EObject model);
	public PlatformGraphicsAlgorithm createIcon(GraphicsAlgorithmContainer container, EObject model);
	public void layoutIcon(PlatformGraphicsAlgorithm pga, int x, int y, int width, int height);
}
