package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.graphiti.mm.algorithms.AbstractText;

public class EntityLayout extends AbstractEntityLayout {

	@Override
	public Insets getInsets() {
		int portMarginSize = portSize, nameMarginSize = textMinimumHeight;
		return new Insets(nameMarginSize, portMarginSize, portMarginSize, portMarginSize);
	}

	@Override
	protected void applyTextLayout(AbstractText text, int x, int y, int width, int height) {
		super.applyTextLayout(text, x, 0, width, height);
	}
}
