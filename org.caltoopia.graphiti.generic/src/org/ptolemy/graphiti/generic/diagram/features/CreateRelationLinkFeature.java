package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ILocationContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.graphiti.generic.ConnectionContainerEditModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.actordiagram.RelationConnection;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CreateRelationLinkFeature extends AbstractCreateConnectionFeature {

	@Inject
	private ILinkService linkService;
	
	@Inject(optional=true)
	private ConnectionContainerEditModel connectionContainerEditModel;
	
	protected CreateRelationLinkFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Inject
	public CreateRelationLinkFeature (IFeatureProvider fp) {
		this(fp, "Relation/Link", "Create Relation/Link");
	}

	protected Anchor getSourceAnchor(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		if (sourceAnchor == null && context.getSourcePictogramElement() instanceof RelationConnection) {
			sourceAnchor = ((RelationConnection) context.getSourcePictogramElement()).getStart();
		}
		return sourceAnchor;
	}
	
	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor sourceAnchor = getSourceAnchor(context);
		if (sourceAnchor == null) {
			return false;
		}
		return canStartConnection(sourceAnchor);
	}

	protected boolean canCreateConnection(Anchor anchor, CreatePortFeature createPortFeature) {
		AnchorContainer anchorParent = anchor.getParent();
//		System.out.println("Anchor parent: " + anchorParent);
		Shape parentShape = Util.getParentShape(anchorParent);
		if (parentShape != null) {
			return true;
		}
		parentShape = Util.getParentShape(anchorParent, connectionContainerEditModel, null);
		if (parentShape != null && createPortFeature.canCreate(getCreateContext(parentShape))) {
			return true;
		}
		if (anchorParent instanceof RelationConnection) {
			return true;
		}
		return false;
	}

	protected boolean canStartConnection(Anchor sourceAnchor) {
		return canCreateConnection(sourceAnchor, createOutputPortFeature);
	}
	
	protected Shape getPortOrEntityShape(Anchor anchor, boolean isSource) {
		AnchorContainer anchorParent = anchor.getParent();
		if (isSource && anchorParent instanceof RelationShape) {
			return ((RelationShape) anchorParent).getSourcePortShape();
		} else if (anchorParent instanceof PortShape) {
			return (PortShape) anchorParent;
		} else if (anchorParent instanceof EntityShape) {
			return (EntityShape) anchorParent;
		}
		return null;
	}

	public boolean canCreate(ICreateConnectionContext context) {
		if (connectionContainerEditModel == null) {
			return false;
		}
		Anchor sourceAnchor = getSourceAnchor(context);
		Anchor targetAnchor = context.getTargetAnchor();
		if (sourceAnchor == null || (! canCreateConnection(sourceAnchor, createOutputPortFeature))) {
			return false;
		}
		if (targetAnchor == null || (! canCreateConnection(targetAnchor, createInputPortFeature))) {
			return false;
		}
		Shape sourceShape = getPortOrEntityShape(sourceAnchor, true);
		Shape targetShape = getPortOrEntityShape(targetAnchor, false);
		if (sourceShape != null && targetShape != null && sourceShape != targetShape) {
			EObject source = (EObject) getBusinessObjectForPictogramElement(sourceShape);
			EObject target = (EObject) getBusinessObjectForPictogramElement(targetShape);
			return connectionContainerEditModel.getConnectionContainer(source, target) != null;
		}
		return false;
	}

	@Inject @Named("single-output") CreatePortFeature createOutputPortFeature;
	@Inject @Named("single-input") CreatePortFeature createInputPortFeature;
	
	@Inject
	private SplitRelationConnectionFeature splitRelationConnectionFeature;
	
	public Connection create(ICreateConnectionContext context) {
		if (! canCreate(context)) {
			return null;
		}
		Anchor sourceAnchor = context.getSourceAnchor();
		if (sourceAnchor == null && context.getSourcePictogramElement() instanceof RelationConnection) {
			RelationConnection sourceConnection = (RelationConnection) context.getSourcePictogramElement();
			EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(sourceConnection);
			CustomContext customContext = new CustomContext();
			customContext.setInnerPictogramElement(sourceConnection);
			ILocation location = context.getSourceLocation();
			customContext.setLocation(location.getX(), location.getY());
			sourceAnchor = splitRelationConnectionFeature.execute(sourceConnection, bo, customContext);
		}
		Anchor targetAnchor = context.getTargetAnchor();
		Shape sourceShape = getPortOrEntityShape(sourceAnchor, true);
		Shape targetShape = getPortOrEntityShape(targetAnchor, false);
		EObject source = linkService.getBusinessObjectForLinkedPictogramElement(sourceShape);
		EObject target = linkService.getBusinessObjectForLinkedPictogramElement(targetShape);
		
		EObject sourcePort = null, targetPort = null;
		if (connectionContainerEditModel.isPort(source, null)) {
			sourcePort = source;
		} else if (connectionContainerEditModel.isEntity(source, EntityViewModel.EntityKind.ACTOR)) {
			sourcePort = createOutputPortFeature.create(getCreateContext(sourceShape))[0];
			sourceShape = Util.getChildShape((ContainerShape) sourceShape, sourcePort);
		}
		if (connectionContainerEditModel.isPort(target, null)) {
			targetPort = target;
		} else if (connectionContainerEditModel.isEntity(target, EntityViewModel.EntityKind.ACTOR)) {
			targetPort = createInputPortFeature.create(getCreateContext(targetShape))[0];
			targetShape = Util.getChildShape((ContainerShape) targetShape, targetPort);
		}
		Anchor altSourceAnchor = (sourceAnchor.getParent() instanceof RelationShape ? sourceAnchor : LayoutPortFeature.PORT_ANCHOR.get(sourceShape));
		Anchor altTargetAnchor = LayoutPortFeature.PORT_ANCHOR.get(targetShape);
		if (altSourceAnchor == null || altTargetAnchor == null) {
			return null;
		}
		// create new business object
		EObject bo = createRelation(sourcePort, targetPort);
		// add connection for business object
		AddConnectionContext addContext = new AddConnectionContext(altSourceAnchor, altTargetAnchor);
		
		addContext.setNewObject(bo);
		Connection newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		return newConnection;
	}

	protected CreateContext getCreateContext(Shape shape) {
		CreateContext createContext = new CreateContext();
		createContext.setTargetContainer((ContainerShape) shape);
		return createContext;
	}

	protected EObject createRelation(EObject source, EObject target) {
		EObject relationContainer = connectionContainerEditModel.getConnectionContainer(source, target);
		if (relationContainer != null) {
			EObject connection = connectionContainerEditModel.createConnection(source, target);
			configureConnection(connection, relationContainer);
			return connection;
		}
		return null;
	}

	protected void configureConnection(EObject connection, EObject context) {
	}
}
