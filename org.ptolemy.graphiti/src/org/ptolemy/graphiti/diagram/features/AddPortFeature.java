package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.actordiagram.EntityShape;
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
		boolean isDiagramPort = parentShape instanceof Diagram;
		int portSize = LayoutPortFeature.DEFAULT_PORT_SIZE * (isDiagramPort ? 3 : 1);
		portShape.setSize(portSize);

		Boolean isInput = null;
		if (port instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) port;
			if (ioPort.isInput() && ioPort.isOutput()) {
			} else if (ioPort.isInput()) {
				isInput = Boolean.TRUE;
			} else if (ioPort.isOutput()) {
				isInput = Boolean.FALSE;
			}
		}
		Orientation alignment = Orientation.ALIGNMENT_BOTTOM;
		if (isInput != null) {
			alignment = (isInput ? Orientation.ALIGNMENT_LEFT : Orientation.ALIGNMENT_RIGHT);
		}
		portShape.setAlignment(alignment);
		portShape.setContainer(parentShape);

		IGaService gaService = Graphiti.getGaService();
		Rectangle rectangle = gaService.createInvisibleRectangle(portShape);
		rectangle.setFilled(false);
		gaService.setLocationAndSize(rectangle, 0, 0, portSize, portSize);

		GraphicsAlgorithm portGa = ActordiagramFactory.eINSTANCE.createPortGA(); // gaService.createPlainPolygon(rectangle, new int[]{0, 0, 2, 1, 0, 2});
		gaService.resetAll(portGa);
		portGa.setParentGraphicsAlgorithm(rectangle);
		portGa.setForeground(manageColor(LayoutPortFeature.PORT_FOREGROUND));
		portGa.setBackground(manageColor(LayoutPortFeature.PORT_BACKGROUND));
		gaService.setLocationAndSize(portGa, 0, 0, portSize, portSize);

		// this anchor is used after the link is created
		PortAnchor portAnchor = actordiagramFactory.createPortAnchor();
		portAnchor.setAlignment(isInput == isDiagramPort ? Orientation.ALIGNMENT_RIGHT : Orientation.ALIGNMENT_LEFT);
		portShape.setOutsideAnchor(portAnchor);
		portAnchor.setVisible(true);
		portAnchor.setActive(true);
		portAnchor.setParent(portShape);
//		portShape.getAnchors().add(portAnchor);
		portAnchor.setReferencedGraphicsAlgorithm(rectangle);

		Rectangle anchorGa = gaService.createInvisibleRectangle(portAnchor);
		anchorGa.setBackground(manageColor(LayoutPortFeature.PORT_ANCHOR_BACKGROUND));
		gaService.setLocationAndSize(anchorGa, 0, 0, portSize / 6, portSize / 6);

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
