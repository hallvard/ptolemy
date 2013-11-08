package org.ptolemy.graphiti.generic.diagram.features.util;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.graphiti.platform.ga.IVisualState;
import org.eclipse.graphiti.platform.ga.IVisualStateChangeListener;
import org.eclipse.graphiti.platform.ga.IVisualStateHolder;
import org.eclipse.graphiti.platform.ga.VisualState;
import org.eclipse.graphiti.platform.ga.VisualStateChangedEvent;

public class GenericShapeRenderer extends Shape implements IGraphicsAlgorithmRenderer, IVisualStateHolder, IVisualStateChangeListener {

	private VisualState visualState;

	public GenericShapeRenderer(IFigure... childFigures) {
		Dimension size = new Dimension();
		for (IFigure childFigure : childFigures) {
			add(childFigure);
			Dimension preferredSize = childFigure.getPreferredSize();
			size.width = Math.max(size.width, preferredSize.width);
			size.height = Math.max(size.height, preferredSize.height);
		}
		setPreferredSize(size);
	}
	
	private float alignmentX = 0.5f, alignmentY = 0.5f;
	
	public void setAlignmentX(float alignmentX) {
		this.alignmentX = alignmentX;
	}

	public void setAlignmentY(float alignmentY) {
		this.alignmentY = alignmentY;
	}
	
	@Override
	public void setBounds(Rectangle rect) {
		Dimension preferredSize = getPreferredSize();
		Rectangle bounds = new Rectangle(rect.x, rect.y, rect.width, rect.height);
		if (bounds.width < preferredSize.width) {
			bounds.width = preferredSize.width;
			bounds.x -= (preferredSize.width - rect.width) / 2;
		}
		if (bounds.height < preferredSize.height) {
			bounds.height = preferredSize.height;
			bounds.y -= (preferredSize.height - rect.height) / 2;
		}
		super.setBounds(bounds);
		for (Object child : getChildren()) {
			IFigure childFigure = (IFigure) child;
			Dimension preferredChildSize = childFigure.getPreferredSize();
			int dx = bounds.width - preferredChildSize.width, dy = bounds.height - preferredChildSize.height; 
			Rectangle childBounds = new Rectangle(((IFigure) child).getBounds());
			childBounds.x = (useLocalCoordinates() ? 0 : bounds.x) + (int) (dx * alignmentX);
			childBounds.y = (useLocalCoordinates() ? 0 : bounds.y) + (int) (dy * alignmentY);
			childFigure.setBounds(childBounds);
		}
	}

	@Override
	protected void fillShape(Graphics graphics) {
	}

	@Override
	protected void outlineShape(Graphics graphics) {
	}

	//
	
	@Override
	public void visualStateChanged(VisualStateChangedEvent e) {
	}

	@Override
	public IVisualState getVisualState() {
		if (visualState == null) {
			visualState = new VisualState();
			visualState.addChangeListener(this);
		}
		return visualState;
	}
}
