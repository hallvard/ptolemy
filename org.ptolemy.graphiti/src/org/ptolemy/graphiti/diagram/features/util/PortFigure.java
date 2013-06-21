package org.ptolemy.graphiti.diagram.features.util;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.graphiti.platform.ga.IVisualState;
import org.eclipse.graphiti.platform.ga.IVisualStateChangeListener;
import org.eclipse.graphiti.platform.ga.IVisualStateHolder;
import org.eclipse.graphiti.platform.ga.VisualState;
import org.eclipse.graphiti.platform.ga.VisualStateChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.ptolemy.graphiti.actordiagram.PortGA;

public class PortFigure extends Shape implements IGraphicsAlgorithmRenderer, IVisualStateHolder, IVisualStateChangeListener {

	private Polygon base;
	private Polygon tip;
	private final PortGA portGa;

	public PortFigure(PortGA portGa) {
		base = new Polygon();
		tip = new Polygon();
		add(base);
		add(tip);
		this.portGa = portGa;
		setFill(portGa.getFilled());
	}

	@Override
	public void setBackgroundColor(Color color) {
		base.setBackgroundColor(color);
		tip.setBackgroundColor(color);
	}

	@Override
	public void setForegroundColor(org.eclipse.swt.graphics.Color color) {
		base.setForegroundColor(color);
		tip.setForegroundColor(color);
	}

	@Override
	public void setFill(boolean fill) {
		super.setFill(fill);
		base.setFill(fill);
		tip.setFill(fill);
	}

	@Override
	public void setOutline(boolean outline) {
		super.setOutline(outline);
		base.setOutline(outline);
		tip.setOutline(outline);
	}
	
	public IFigure getBase() {
		return base;
	}

	public IFigure getTip() {
		return tip;
	}

	public int getDirection() {
		return OrientationSupport.direction(portGa.getPortShape().getOrientation());
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

	private Dimension size = null;
	private int direction = -1;
	
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		if (needsRefresh(rect)) {
			setPoints(tip, rect.x, rect.y, portGa.getTipAnchorPoint(), portGa.getBaseAnchorPoint(), 0.5f);
			setPoints(base, rect.x, rect.y, portGa.getTipAnchorPoint(), portGa.getBaseAnchorPoint(), 1.0f);
		}
	}

	protected boolean needsRefresh(Rectangle rect) {
		return this.size == null || this.size.width != rect.width || this.size.height != rect.height || getDirection() != direction;
	}

	private void setPoints(Polygon polygon, int x, int y, Point tip, Point base, float sizeFactor) {
		polygon.removeAllPoints();
		int dx = (int) ((base.x - tip.x) * sizeFactor), dy = (int) ((base.y - tip.y) * sizeFactor);
		polygon.addPoint(new Point(tip.x, tip.y));
		polygon.addPoint(new Point(tip.x + dx - dy / 2, tip.y + dy - dx / 2));
		polygon.addPoint(new Point(tip.x + dx + dy / 2, tip.y + dy + dx / 2));
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		// does not have own visible state
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		// does not have own visible state
	}

	//
	
	@Override
	public void visualStateChanged(VisualStateChangedEvent e) {
	}

	private VisualState visualState;

	@Override
	public IVisualState getVisualState() {
		if (visualState == null) {
			visualState = new VisualState();
			visualState.addChangeListener(this);
		}
		return visualState;
	}
}
