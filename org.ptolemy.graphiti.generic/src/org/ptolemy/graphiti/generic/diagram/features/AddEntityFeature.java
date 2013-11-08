package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.generic.actordiagram.IconShape;
import org.ptolemy.graphiti.generic.actordiagram.LabelShape;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AddEntityFeature extends AddNameableFeature {

	private int INITIAL_WIDTH = 70;
	private int INITIAL_HEIGHT = 50;

	@Inject
	private ILinkService linkService;
	
	@Inject
	private ActorViewModel actorViewModel;
	
	@Inject
	public AddEntityFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	protected boolean canAdd(ContainerShape targetContainer, EObject bo, Object newObject) {
		if (! (newObject instanceof EObject)) {
			return false;
		}
		EObject newEntity = (EObject) newObject;
		EObject actorContainer = linkService.getBusinessObjectForLinkedPictogramElement(targetContainer);
		return entityViewModel.isEntity(actorContainer, EntityViewModel.EntityKind.ACTOR_CONTAINER) &&
				entityViewModel.isEntity(newEntity, EntityViewModel.EntityKind.ACTOR);
	}

	@Inject
	protected ActordiagramFactory actordiagramFactory;
	
	private IEntityLayout entityLayout;

	@Inject
	protected void setEntityLayout(@Named("Entity") IEntityLayout entityLayout) {
		this.entityLayout = entityLayout;
	}

	protected ContainerShape createEntityShape() {
		return actordiagramFactory.createEntityShape();
	}

	public PictogramElement add(IAddContext context) {
		EObject newEntity = (EObject) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();

		ContainerShape entityShape = createEntityShape();
		entityShape.setVisible(true);
		entityShape.setActive(true);
		targetDiagram.getChildren().add(entityShape);

		IGaService gaService = Graphiti.getGaService();
		Rectangle bounds = gaService.createInvisibleRectangle(entityShape);
		Insets insets = entityLayout.getInsets();

		int width = INITIAL_WIDTH;
		int height = INITIAL_HEIGHT;
		gaService.setLocationAndSize(bounds, context.getX() - insets.left, context.getY() - insets.top, width + insets.left + insets.right, height + insets.top + insets.bottom);

		GraphicsAlgorithm entityGa = entityLayout.createGraphicsAlgorithm(bounds);
		entityGa.setForeground(manageColor(LayoutEntityFeature.ENTITY_FOREGROUND));
		entityGa.setBackground(manageColor(LayoutEntityFeature.ENTITY_BACKGROUND));
		entityGa.setLineWidth(2);
		entityLayout.layoutGraphicsAlgorithm(entityGa, insets.left, insets.top, width, height);

		// this anchor is used for connections that add a port and relation
		ChopboxAnchor chopBoxAnchor = Graphiti.getPeCreateService().createChopboxAnchor(entityShape);
		chopBoxAnchor.setReferencedGraphicsAlgorithm(entityGa);

		// create link and wire it
		link(entityShape, newEntity);
		
		// create and set text graphics algorithm
		AbstractText text = entityLayout.createText(bounds);

		text.setForeground(manageColor(LayoutEntityFeature.ENTITY_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));

		if (entityShape instanceof LabelShape) {
			setLabel((LabelShape) entityShape, newEntity, text);
			entityLayout.layoutText(text, insets.left, insets.right, width, height);
		}

		PlatformGraphicsAlgorithm pga = entityLayout.createIcon(bounds, newEntity);
		
		if (entityShape instanceof IconShape) {
			// create and set icon graphics algorithm
			entityLayout.layoutIcon(pga, insets.left, insets.right, width, height);
		}

        for (EObject port : actorViewModel.getPorts(newEntity)) {
        	AddContext addContext = new AddContext(context, port);
        	addContext.setTargetContainer(entityShape);
    		getFeatureProvider().addIfPossible(addContext);
        }

        layoutPictogramElement(entityShape);

		return entityShape;
	}
}
