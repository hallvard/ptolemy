package org.ptolemy.graphiti.diagram.features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.ptolemy.graphiti.actordiagram.EntityShape;
import org.ptolemy.graphiti.actordiagram.PortShape;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class LayoutEntityFeature extends AbstractLayoutEntityFeature {

	@Inject
	public LayoutEntityFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canLayout(ILayoutContext context) {
		return (context.getPictogramElement() instanceof EntityShape);
	}

	@Inject
	protected void setEntityLayout(@Named("Entity") IEntityLayout entityLayout) {
		super.setEntityLayout(entityLayout);
	}
	
	@Override
	protected boolean layoutPorts(ContainerShape containerShape, Dimension containerSize) {
		boolean changed = false;

		Collection<PortShape> bottomPortShapes = new ArrayList<PortShape>();
		addPortShapes(containerShape, bottomPortShapes);
		Collection<PortShape> leftPortShapes = new ArrayList<PortShape>(), rightPortShapes = new ArrayList<PortShape>(), topPortShapes = new ArrayList<PortShape>();

		Iterator<PortShape> it = bottomPortShapes.iterator();
		while (it.hasNext()) {
			PortShape portShape = it.next();
			Orientation alignment = portShape.getAlignment();
			if (alignment == null || alignment == Orientation.ALIGNMENT_BOTTOM) {
				continue;
			}
			if (alignment == Orientation.ALIGNMENT_LEFT) {
				leftPortShapes.add(portShape);
			} else if (alignment == Orientation.ALIGNMENT_RIGHT) {
				rightPortShapes.add(portShape);
			} else if (alignment == Orientation.ALIGNMENT_TOP) {
				topPortShapes.add(portShape);
			}
			it.remove();
		}
		
		int portSize = LayoutPortFeature.DEFAULT_PORT_SIZE;
		Insets insets = entityLayout.getInsets();

		// resize container so all ports fit
		int minNorthWidth = topPortShapes.size() * portSize + portSize * 2;
		int minSouthWidth = bottomPortShapes.size() * portSize + portSize * 2;
		int minWidth = Math.max(minNorthWidth, minSouthWidth);
		if (containerSize.width < minWidth) {
			containerSize.width = minWidth;
			changed = true;
		}
		int minWestHeight = leftPortShapes.size() * portSize + insets.top;
		int minEastHeight = rightPortShapes.size() * portSize + insets.top;
		int minHeight = Math.max(minWestHeight, minEastHeight);
		if (containerSize.height < minHeight) {
			containerSize.height = minHeight;
			changed = true;
		}

		int width = containerSize.width - insets.left - insets.right;
		int height = containerSize.height - insets.top - insets.right;

		layoutPorts(leftPortShapes, 0, insets.top, 0, height, 0.0f, 1.0f);
		layoutPorts(rightPortShapes, containerSize.width - portSize, insets.top, 0, height, 0.0f, 1.0f);
		layoutPorts(topPortShapes, portSize, insets.top - portSize, width, 0, 1.0f, 0.0f);
		layoutPorts(bottomPortShapes, portSize, insets.top + height, width, 0, 1.0f, 0.0f);
		return changed;
	}

	private boolean layoutPorts(Collection<PortShape> portShapes, int x, int y, int width, int height, float sx, float sy) {
		boolean changed = false;
		if (portShapes.size() > 0) {
			int dx = width / portShapes.size();
			int dy = height / portShapes.size();
			for (PortShape portShape : portShapes) {
				GraphicsAlgorithm ga = portShape.getGraphicsAlgorithm();
				int portSize = portShape.getSize();
				changed |= Util.setLocation(ga, (int) (x + (dx - portSize * sx) / 2), (int) (y + (dy - portSize * sy) / 2));
				x += dx;
				y += dy;
			}
		}
		return changed;
	}

	private void addPortShapes(ContainerShape containerShape, Collection<PortShape> result) {
		for (Shape shape : containerShape.getChildren()) {
			if (shape instanceof PortShape) {
				result.add((PortShape) shape);
			} else if (shape instanceof EntityShape) {
				addPortShapes((EntityShape) shape, result);
			}
		}
	}
}