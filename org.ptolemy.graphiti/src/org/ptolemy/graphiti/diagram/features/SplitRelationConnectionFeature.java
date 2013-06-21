package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;
import org.ptolemy.ecore.kernel.util.KernelValidator;
import org.ptolemy.graphiti.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.actordiagram.RelationConnection;
import org.ptolemy.graphiti.actordiagram.RelationShape;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SplitRelationConnectionFeature extends DoubleClickFeature {

	private static final int RELATION_SIZE = 14;

	@Inject
	public SplitRelationConnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	protected boolean canExecute(PictogramElement pe, EObject bo, ICustomContext context) {
		if (pe instanceof RelationConnection) {
			return true;
		}
		return false;
	}
	
	@Inject private AddRelationFeature addRelationFeature;
	
	protected void execute(PictogramElement pe, EObject bo, ICustomContext context) {
		RelationShape relationShape = ActordiagramFactory.eINSTANCE.createRelationShape();
		relationShape.setVisible(true);
		relationShape.setActive(true);
		Rectangle relationGa = Graphiti.getGaCreateService().createInvisibleRectangle(relationShape);
		int x = context.getX(); if (x < 0) x = 200;
		int y = context.getY(); if (y < 0) y = 200;
		Graphiti.getGaService().setLocationAndSize(relationGa, x, y, RELATION_SIZE, RELATION_SIZE);
		Graphiti.getGaCreateService().createPolygon(relationGa, new int[] {
				RELATION_SIZE / 2, 0,
				RELATION_SIZE, RELATION_SIZE / 2,
				RELATION_SIZE / 2, RELATION_SIZE,
				0, RELATION_SIZE / 2,
		});
		BoxRelativeAnchor anchor = Graphiti.getPeCreateService().createBoxRelativeAnchor(relationShape);
		anchor.setReferencedGraphicsAlgorithm(relationGa);
		anchor.setRelativeHeight(0.5);
		anchor.setRelativeWidth(0.5);
		Rectangle anchorGa = Graphiti.getGaCreateService().createInvisibleRectangle(anchor);
		Graphiti.getGaService().setLocationAndSize(anchorGa, -1, -1, 3, 3);

		RelationConnection startConnection = (RelationConnection) pe;
		relationShape.setContainer(startConnection.getParent());
		RelationConnection endConnection = addRelationFeature.createRelationConnection(anchor, startConnection.getEnd());
		startConnection.setEnd(anchor);
		
		link(relationShape, bo);
		link(endConnection, bo);
	}

	void execute(EObject bo, ICustomContext context) {
		RelationShape relationShape = ActordiagramFactory.eINSTANCE.createRelationShape();
		relationShape.setVisible(true);
		relationShape.setActive(true);
		Rectangle relationGa = Graphiti.getGaCreateService().createInvisibleRectangle(relationShape);
		int x = context.getX(); if (x < 0) x = 200;
		int y = context.getY(); if (y < 0) y = 200;
		Graphiti.getGaService().setLocationAndSize(relationGa, x, y, RELATION_SIZE, RELATION_SIZE);
		Graphiti.getGaCreateService().createPolygon(relationGa, new int[] {
				RELATION_SIZE / 2, 0,
				RELATION_SIZE, RELATION_SIZE / 2,
				RELATION_SIZE / 2, RELATION_SIZE,
				0, RELATION_SIZE / 2,
		});
		BoxRelativeAnchor anchor = Graphiti.getPeCreateService().createBoxRelativeAnchor(relationShape);
		anchor.setReferencedGraphicsAlgorithm(relationGa);
		anchor.setRelativeHeight(0.5);
		anchor.setRelativeWidth(0.5);
		Rectangle anchorGa = Graphiti.getGaCreateService().createInvisibleRectangle(anchor);
		Graphiti.getGaService().setLocationAndSize(anchorGa, -1, -1, 3, 3);
		
		RelationConnection startConnection = (RelationConnection) pe;
		relationShape.setContainer(startConnection.getParent());
		RelationConnection endConnection = addRelationFeature.createRelationConnection(anchor, startConnection.getEnd());
		startConnection.setEnd(anchor);
		
		link(relationShape, bo);
		link(endConnection, bo);
	}
}
