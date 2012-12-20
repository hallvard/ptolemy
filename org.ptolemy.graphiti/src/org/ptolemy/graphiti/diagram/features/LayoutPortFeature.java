package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.actordiagram.PortAnchor;
import org.ptolemy.graphiti.actordiagram.PortShape;
import org.ptolemy.graphiti.diagram.features.util.PERef;

import com.google.inject.Inject;

public class LayoutPortFeature extends AbstractLayoutFeature {

	public final static PERef<Port, GraphicsAlgorithm> PORT_GA1 = new PERef<Port, GraphicsAlgorithm>(Port.class, Rectangle.class);
	public final static PERef<Port, GraphicsAlgorithm> PORT_GA2 = new PERef<Port, GraphicsAlgorithm>(Port.class, Polygon.class);
	public final static PERef<Port, PortAnchor> PORT_ANCHOR = new PERef<Port, PortAnchor>(Port.class, PortAnchor.class);
	public final static PERef<Entity, Shape> PARENT_ENTITY_SHAPE = new PERef<Entity, Shape>(Entity.class, Shape.class);
	
	public final static String ANCHOR_BASE = "base";
	public final static String ANCHOR_TIP = "tip";
	
	public final static int DEFAULT_PORT_SIZE = 12;
	
	@Inject
	public LayoutPortFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canLayout(ILayoutContext context) {
		return context.getPictogramElement() instanceof PortShape;
	}

	public boolean layout(ILayoutContext context) {
		PortShape portShape = (PortShape) context.getPictogramElement();
		GraphicsAlgorithm portGa = PORT_GA2.get(portShape);
		boolean changed = false;
		IColorConstant portForeground = getPortPolygonForeground(portShape.getModel(), portShape);
		if (! Util.isSame(portGa.getForeground(), portForeground)) {
			portGa.setForeground(manageColor(portForeground));
			changed = true;
		}
		IColorConstant portBackground = getPortPolygonBackground(portShape.getModel(), portShape);
		if (! Util.isSame(portGa.getBackground(), portBackground)) {
			portGa.setBackground(manageColor(portBackground));
			changed = true;
		}
		layoutPortGa(portShape, portGa);
		PortAnchor boxAnchor = PORT_ANCHOR.get(portShape);
		changed |= layoutPortAnchor(portShape, boxAnchor);
		LayoutContext layoutContext = new LayoutContext(PARENT_ENTITY_SHAPE.get(portShape));
		changed |= getFeatureProvider().getLayoutFeature(layoutContext).layout(layoutContext);

		return changed;
	}
	
	private boolean layoutPortGa(PortShape portShape, GraphicsAlgorithm portGa) {
		boolean changed = false;
		if (portGa instanceof Polygon) {
			changed |= layoutPortPolygon(portShape, (Polygon) portGa);
		} else {
			int size = portShape.getSize();
			changed |= Util.setLocationAndSize(portGa, 0, 0, size, size);
		}
		return changed;
	}

	private static int PORT_FOREGROUND_RED = 98, PORT_FOREGROUND_GREEN = 131, PORT_FOREGROUND_BLUE = 167;
	public static final IColorConstant PORT_FOREGROUND = new ColorConstant(PORT_FOREGROUND_RED, PORT_FOREGROUND_GREEN, PORT_FOREGROUND_BLUE);

	private static int PORT_FOREGROUND_GRAYNESS = (PORT_FOREGROUND_RED + PORT_FOREGROUND_GREEN + PORT_FOREGROUND_BLUE) / 3;
	public static final IColorConstant LOCKED_PORT_FOREGROUND = new ColorConstant(PORT_FOREGROUND_GRAYNESS, PORT_FOREGROUND_GRAYNESS, PORT_FOREGROUND_GRAYNESS);
	
	private static IColorConstant getPortPolygonForeground(Port newPort, PortShape shape) {
		return shape.isLocked() ? LOCKED_PORT_FOREGROUND : PORT_FOREGROUND;
	}
	
	private static int PORT_BACKGROUND_RED = 187, PORT_BACKGROUND_GREEN = 218, PORT_BACKGROUND_BLUE = 247;
	public static final IColorConstant PORT_BACKGROUND = new ColorConstant(PORT_BACKGROUND_RED, PORT_BACKGROUND_GREEN, PORT_BACKGROUND_BLUE);
	public static final IColorConstant MULTIPORT_BACKGROUND = new ColorConstant(PORT_BACKGROUND_RED / 2, PORT_BACKGROUND_GREEN / 2, PORT_BACKGROUND_BLUE / 2);

	private static int PORT_BACKGROUND_GRAYNESS = (PORT_BACKGROUND_RED + PORT_BACKGROUND_GREEN + PORT_BACKGROUND_BLUE) / 3;
	public static final IColorConstant LOCKED_PORT_BACKGROUND = new ColorConstant(PORT_BACKGROUND_GRAYNESS, PORT_BACKGROUND_GRAYNESS, PORT_BACKGROUND_GRAYNESS);
	public static final IColorConstant LOCKED_MULTIPORT_BACKGROUND = new ColorConstant(PORT_BACKGROUND_GRAYNESS / 2, PORT_BACKGROUND_GRAYNESS / 2, PORT_BACKGROUND_GRAYNESS / 2);

	private static IColorConstant getPortPolygonBackground(Port newPort, PortShape shape) {
		boolean isMultiport = newPort instanceof AbstractIOPort && ((AbstractIOPort) newPort).isMultiport();
		return shape.isLocked() ? (isMultiport ? LOCKED_MULTIPORT_BACKGROUND : LOCKED_PORT_BACKGROUND) : (isMultiport ? MULTIPORT_BACKGROUND : PORT_BACKGROUND);
	}

	private boolean layoutPortPolygon(PortShape portShape, Polygon polygon) {
		int size = portShape.getSize();
		int xy[] = {0, 0, size, 0, size, size, 0, size};
		switch (portShape.getOrientation()) {
		case ALIGNMENT_TOP: 	xy = new int[]{size / 2, 0, size, size, 0, size}; 	break;
		case ALIGNMENT_BOTTOM:	xy = new int[]{0, 0, size, 0, size / 2, size}; 		break;
		case ALIGNMENT_RIGHT:	xy = new int[]{0, 0, size, size / 2, 0, size};		break;
		case ALIGNMENT_LEFT:	xy = new int[]{0, size / 2, size, 0, size, size};	break;
		}
		return Util.setPoints(polygon, xy);
	}
	
	private boolean layoutPortAnchor(PortShape portShape, PortAnchor portAnchor) {
		double relativeWidth = 0.5, relativeHeight = 0.5;
		switch (portAnchor.getAlignment()) {
		case ALIGNMENT_TOP: 	relativeWidth = 0.5; relativeHeight = 0.0;	break;
		case ALIGNMENT_BOTTOM:	relativeWidth = 0.5; relativeHeight = 1.0;	break;
		case ALIGNMENT_RIGHT:	relativeWidth = 1.0; relativeHeight = 0.5;	break;
		case ALIGNMENT_LEFT:	relativeWidth = 0.0; relativeHeight = 0.5;	break;
		}
		boolean changed = false;
		if (portAnchor.getRelativeWidth() != relativeWidth) {
			portAnchor.setRelativeWidth(relativeWidth);
			changed = true;
		}
		if (portAnchor.getRelativeHeight() != relativeHeight) {
			portAnchor.setRelativeHeight(relativeHeight);
			changed = true;
		}
		return changed;
	}
}
