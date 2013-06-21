package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.actordiagram.PortAnchor;
import org.ptolemy.graphiti.generic.actordiagram.PortGA;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.diagram.features.util.PERef;

import com.google.inject.Inject;

public class LayoutPortFeature extends AbstractLayoutFeature {

	public final static PERef<EObject, GraphicsAlgorithm> PORT_GA1 = new PERef<EObject, GraphicsAlgorithm>(EObject.class, Rectangle.class);
	public final static PERef<EObject, GraphicsAlgorithm> PORT_GA2 = new PERef<EObject, GraphicsAlgorithm>(EObject.class, PortGA.class);
	public final static PERef<EObject, PortAnchor> PORT_ANCHOR = new PERef<EObject, PortAnchor>(EObject.class, PortAnchor.class);
	public final static PERef<EObject, Shape> PARENT_ENTITY_SHAPE = new PERef<EObject, Shape>(EObject.class, Shape.class);
	
	public final static String ANCHOR_BASE = "base";
	public final static String ANCHOR_TIP = "tip";
	
	public final static int DEFAULT_PORT_SIZE = 12;

	@Inject
	private ILinkService linkService;

	@Inject
	private ActorViewModel actorViewModel;

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
		IColorConstant portForeground = getPortPolygonForeground(portShape);
		if (! Util.isSame(portGa.getForeground(), portForeground)) {
			portGa.setForeground(manageColor(portForeground));
			changed = true;
		}
		IColorConstant portBackground = getPortPolygonBackground(portShape);
		if (! Util.isSame(portGa.getBackground(), portBackground)) {
			portGa.setBackground(manageColor(portBackground));
			changed = true;
		}
		layoutPortGa(portShape, portGa);
		PortAnchor boxAnchor = PORT_ANCHOR.get(portShape);
		changed |= layoutPortAnchor(portShape, boxAnchor);
		LayoutContext layoutContext = new LayoutContext(PARENT_ENTITY_SHAPE.get(portShape.eContainer()));
		changed |= getFeatureProvider().layoutIfPossible(layoutContext).toBoolean();

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

	private static IColorConstant color(int red, int green, int blue, float factor) {
		if (factor < 0) {
			red = (int)(255 + ((255 - red) * factor));
			green = (int)(255 + ((255 - green) * factor));
			blue = (int)(255 + ((255 - blue) * factor));
		} else {
			red = (int)(red * factor);
			green = (int)(green * factor);
			blue = (int)(blue * factor);
		}
		return new ColorConstant(red, green, blue);
	}
	
	private static float FOREGROUND_FACTOR = 1.0f;
	private static float LOCKED_FOREGROUND_FACTOR = 0.8f;
	
	private static int PORT_FOREGROUND_RED = 98, PORT_FOREGROUND_GREEN = 131, PORT_FOREGROUND_BLUE = 167;
	public static final IColorConstant PORT_FOREGROUND = color(PORT_FOREGROUND_RED, PORT_FOREGROUND_GREEN, PORT_FOREGROUND_BLUE, FOREGROUND_FACTOR);
	
	private static int PORT_FOREGROUND_GRAYNESS = (PORT_FOREGROUND_RED + PORT_FOREGROUND_GREEN + PORT_FOREGROUND_BLUE) / 3;
	public static final IColorConstant LOCKED_PORT_FOREGROUND = color(PORT_FOREGROUND_GRAYNESS, PORT_FOREGROUND_GRAYNESS, PORT_FOREGROUND_GRAYNESS, -LOCKED_FOREGROUND_FACTOR);

	private static IColorConstant getPortPolygonForeground(PortShape shape) {
		return shape.isLocked() ? LOCKED_PORT_FOREGROUND : PORT_FOREGROUND;
	}
	
	private static float BACKGROUND_FACTOR = 1.0f;
	private static float MULTIPORT_BACKGROUND_FACTOR = 0.1f;
	private static float LOCKED_BACKGROUND_FACTOR = 1.0f;
	
	private static int PORT_BACKGROUND_RED = 187, PORT_BACKGROUND_GREEN = 218, PORT_BACKGROUND_BLUE = 247;
	public static final IColorConstant PORT_BACKGROUND = color(PORT_BACKGROUND_RED, PORT_BACKGROUND_GREEN, PORT_BACKGROUND_BLUE, BACKGROUND_FACTOR);
	public static final IColorConstant MULTIPORT_BACKGROUND = color(PORT_BACKGROUND_RED, PORT_BACKGROUND_GREEN, PORT_BACKGROUND_BLUE, -MULTIPORT_BACKGROUND_FACTOR * BACKGROUND_FACTOR);

	private static int PORT_BACKGROUND_GRAYNESS = (PORT_BACKGROUND_RED + PORT_BACKGROUND_GREEN + PORT_BACKGROUND_BLUE) / 3;
	public static final IColorConstant LOCKED_PORT_BACKGROUND = color(PORT_BACKGROUND_GRAYNESS, PORT_BACKGROUND_GRAYNESS, PORT_BACKGROUND_GRAYNESS, -LOCKED_BACKGROUND_FACTOR * BACKGROUND_FACTOR);
	public static final IColorConstant LOCKED_MULTIPORT_BACKGROUND = color(PORT_BACKGROUND_GRAYNESS, PORT_BACKGROUND_GRAYNESS, PORT_BACKGROUND_GRAYNESS, -LOCKED_BACKGROUND_FACTOR * MULTIPORT_BACKGROUND_FACTOR);

	public static final IColorConstant PORT_ANCHOR_BACKGROUND = color(0, 0, 0, 1.0f);

	private IColorConstant getPortPolygonBackground(PortShape shape) {
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(shape);
		boolean isMultiport = actorViewModel.isMulti(bo);
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
    	boolean isDiagramPort = portShape.getContainer() instanceof Diagram;
    	GraphicsAlgorithm ga = portAnchor.getGraphicsAlgorithm();
    	if (ga.getFilled() != isDiagramPort || ga.getLineVisible() != isDiagramPort) {
    		ga.setFilled(isDiagramPort);
    		changed = true;
    	}
    	if (ga.getLineVisible() != isDiagramPort) {
    		ga.setLineVisible(isDiagramPort);
    		changed = true;
    	}
		return changed;
	}
}
