package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.actordiagram.PortAnchor;
import org.ptolemy.graphiti.actordiagram.PortShape;

import com.google.inject.Inject;

public class AddPortFeature extends AbstractAddShapeFeature {

	@Inject
	public AddPortFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof Port;
	}

	@Inject
	private ActordiagramFactory actordiagramFactory;
	
	public PictogramElement add(IAddContext context) {
		Port port = (Port) context.getNewObject();
		ContainerShape parentShape = (ContainerShape) Util.getParentShape(context.getTargetContainer(), Entity.class);
		return addPort(port, parentShape);
	}

	protected PictogramElement addPort(Port port, ContainerShape parentShape) {
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		PortShape portShape = actordiagramFactory.createPortShape();
		portShape.setVisible(true);
		portShape.setActive(true);
		int portSize = LayoutPortFeature.DEFAULT_PORT_SIZE;
		portShape.setSize(portSize);

		Boolean input = null;
		if (port instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) port;
			if (ioPort.isInput() && ioPort.isOutput()) {
			} else if (ioPort.isInput()) {
				input = Boolean.TRUE;
			} else if (ioPort.isOutput()) {
				input = Boolean.FALSE;
			}
		}
		Orientation alignment = Orientation.ALIGNMENT_BOTTOM;
		if (input != null) {
			alignment = (input ? Orientation.ALIGNMENT_LEFT : Orientation.ALIGNMENT_RIGHT);
		}
		portShape.setAlignment(alignment);
		parentShape.getChildren().add(portShape);

		IGaService gaService = Graphiti.getGaService();
		Rectangle rectangle = gaService.createInvisibleRectangle(portShape);
		rectangle.setFilled(false);
		gaService.setLocationAndSize(rectangle, 0, 0, portSize, portSize);

		Polygon polygon = gaService.createPlainPolygon(rectangle, new int[]{0, 0, 2, 1, 0, 2});
		polygon.setForeground(manageColor(LayoutPortFeature.PORT_FOREGROUND));
		polygon.setBackground(manageColor(LayoutPortFeature.PORT_BACKGROUND));
		gaService.setLocationAndSize(polygon, 0, 0, portSize, portSize);

		// this anchor is used after the link is created
		PortAnchor portAnchor = actordiagramFactory.createPortAnchor();
		portAnchor.setAlignment(Orientation.ALIGNMENT_RIGHT);
		portShape.setOutsideAnchor(portAnchor);
		portAnchor.setVisible(true);
		portAnchor.setActive(true);
		portAnchor.setParent(portShape);

		portShape.getAnchors().add(portAnchor);
		portAnchor.setReferencedGraphicsAlgorithm(rectangle);

		Rectangle anchorGa = gaService.createInvisibleRectangle(portAnchor);
		gaService.setLocationAndSize(anchorGa, 0, 0, 1, 1);

		// this anchor is used to make the target bigger
		ChopboxAnchor chopBoxAnchor = peCreateService.createChopboxAnchor(portShape);
		chopBoxAnchor.setReferencedGraphicsAlgorithm(rectangle);

		// create link and wire it
		link(portShape, port);

		updatePictogramElement(portShape);
		layoutPictogramElement(portShape);
		
		return portShape;
	}
}
