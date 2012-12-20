package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;
import org.ptolemy.ecore.kernel.util.KernelValidator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CreateRelationFeature extends AbstractCreateConnectionFeature {

	protected CreateRelationFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Inject
	public CreateRelationFeature (IFeatureProvider fp) {
		this(fp, "Relation", "Create Relation");
	}

	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		if (sourceAnchor == null) {
			return false;
		}
		return canStartConnection(sourceAnchor);
	}

	protected boolean canCreateConnection(Anchor anchor, CreatePortFeature createPortFeature) {
		AnchorContainer anchorParent = anchor.getParent();
		Shape parentShape = Util.getParentShape(anchorParent, Port.class);
		if (parentShape != null) {
			return true;
		}
		parentShape = Util.getParentShape(anchorParent, Entity.class);
		if (parentShape != null && createPortFeature.canCreate(getCreateContext(parentShape))) {
			return true;
		}
		return false;
	}

	protected boolean canStartConnection(Anchor sourceAnchor) {
		return canCreateConnection(sourceAnchor, createOutputPortFeature);
	}
	
	protected Shape getPortOrEntityShape(Anchor anchor) {
		AnchorContainer parent = anchor.getParent();
		Shape parentShape = Util.getParentShape(parent, Port.class);
		if (parentShape == null) {
			parentShape = Util.getParentShape(parent, Entity.class);
		}
		return parentShape;
	}

	public boolean canCreate(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();
		if (sourceAnchor == null || (! canCreateConnection(sourceAnchor, createOutputPortFeature))) {
			return false;
		}
		if (targetAnchor == null || (! canCreateConnection(targetAnchor, createInputPortFeature))) {
			return false;
		}		
		Shape sourceShape = getPortOrEntityShape(sourceAnchor);
		Shape targetShape = getPortOrEntityShape(targetAnchor);
		if (sourceShape != null && targetShape != null && sourceShape != targetShape) {
			NamedObj source = (NamedObj) getBusinessObjectForPictogramElement(sourceShape);
			NamedObj target = (NamedObj) getBusinessObjectForPictogramElement(targetShape);
			return KernelValidator.isValidLink(source, target);
		}
		return false;
	}

	@Inject @Named("single-output") CreatePortFeature createOutputPortFeature;
	@Inject @Named("single-input") CreatePortFeature createInputPortFeature;
	
	public Connection create(ICreateConnectionContext context) {
		if (! canCreate(context)) {
			return null;
		}
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();
		Shape sourceShape = getPortOrEntityShape(sourceAnchor);
		Shape targetShape = getPortOrEntityShape(targetAnchor);
		NamedObj source = (NamedObj) getBusinessObjectForPictogramElement(sourceShape);
		NamedObj target = (NamedObj) getBusinessObjectForPictogramElement(targetShape);
		
		Port sourcePort = null, targetPort = null;
		if (source instanceof Port) {
			sourcePort = (Port) source;
		} else if (source instanceof Entity<?>) {
			sourcePort = (Port) createOutputPortFeature.create(getCreateContext(sourceShape))[0];
			sourceShape = Util.getChildShape((ContainerShape) sourceShape, sourcePort);
		}
		if (target instanceof Port) {
			targetPort = (Port) target;
		} else if (target instanceof Entity<?>) {
			targetPort = (Port) createInputPortFeature.create(getCreateContext(targetShape))[0];
			targetShape = Util.getChildShape((ContainerShape) targetShape, targetPort);
		}
		Anchor altSourceAnchor = LayoutPortFeature.PORT_ANCHOR.get(sourceShape);
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

	@Inject
	private KernelFactory kernelFactory;
	
	protected EObject createRelation(Port source, Port target) {
		EntityContainer<?> relationContainer = KernelValidator.getRelationContainer(source, target);
		if (relationContainer != null) {
			Relation relation = kernelFactory.createRelation();
			relation.setSourcePort(source);
			relation.getTargetPorts().add(target);
			configureRelation(relation, relationContainer);
			relationContainer.getRelations().add(relation);
			return relation;
		}
		return null;
	}

	protected void configureRelation(Relation relation, EObject context) {
	}
}
