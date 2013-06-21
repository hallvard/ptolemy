package org.ptolemy.graphiti.generic.diagram.features;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ILocationContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.generic.actordiagram.RelationConnection;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

import com.google.inject.Inject;

public class SplitRelationConnectionFeature extends DoubleClickFeature {

	private static final int RELATION_SIZE = 6;

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
	
	@Inject
	private AddRelationFeature addRelationFeature;
	
	protected void execute(PictogramElement pe, EObject bo, ICustomContext context) {
		execute((RelationConnection) pe, bo, context);
	}
	
	Anchor execute(RelationConnection startConnection, EObject bo, ICustomContext context) {
		RelationShape relationShape = ActordiagramFactory.eINSTANCE.createRelationShape();
		relationShape.setVisible(true);
		relationShape.setActive(true);
		
		int x = context.getX(); if (x < 0) x = 200;
		int y = context.getY(); if (y < 0) y = 200;
		
		GraphicsAlgorithm relationGa = Graphiti.getGaCreateService().createEllipse(relationShape);
		Graphiti.getGaService().setLocationAndSize(relationGa, x - RELATION_SIZE / 2, y - RELATION_SIZE / 2, RELATION_SIZE, RELATION_SIZE);
		ChopboxAnchor anchor = Graphiti.getPeCreateService().createChopboxAnchor(relationShape);
		anchor.setReferencedGraphicsAlgorithm(relationGa);
		
//		Rectangle relationGa = Graphiti.getGaCreateService().createInvisibleRectangle(relationShape);
//		int x = context.getX(); if (x < 0) x = 200;
//		int y = context.getY(); if (y < 0) y = 200;
//		Graphiti.getGaService().setLocationAndSize(relationGa, x, y, RELATION_SIZE, RELATION_SIZE);
//		GraphicsAlgorithm relationShapeGa = Graphiti.getGaCreateService().createEllipse(relationGa);
//		Graphiti.getGaService().setLocationAndSize(relationShapeGa, x, y, RELATION_SIZE, RELATION_SIZE);
//		BoxRelativeAnchor anchor = Graphiti.getPeCreateService().createBoxRelativeAnchor(relationShape);
//		anchor.setReferencedGraphicsAlgorithm(relationGa);
//		anchor.setRelativeHeight(0.5);
//		anchor.setRelativeWidth(0.5);
//		Rectangle anchorGa = Graphiti.getGaCreateService().createInvisibleRectangle(anchor);
//		Graphiti.getGaService().setLocationAndSize(anchorGa, -1, -1, 3, 3);
		
		relationShape.setContainer(startConnection.getParent());
		RelationConnection endConnection = addRelationFeature.createRelationConnection(anchor, startConnection.getEnd());
		
		startConnection.setEnd(anchor);
		
		// check class, in case RelationConnection does not subclass it
		if (startConnection instanceof FreeFormConnection) {
			splitBendPoints((FreeFormConnection) startConnection, endConnection, x, y);
		}
		
		link(relationShape, bo);
		link(endConnection, bo);
		
		return anchor;
	}
	
	private void splitBendPoints(FreeFormConnection startConnection, Connection endConnection, int x, int y) {
		List<Point> points = new ArrayList<Point>();
		GraphicsAlgorithm startGa = startConnection.getStart().getGraphicsAlgorithm();
		if (startGa != null) {
			Point p = StylesFactory.eINSTANCE.createPoint();
			p.setX(startGa.getX());
			p.setY(startGa.getY());
			points.add(p);
		}
		points.addAll(startConnection.getBendpoints());
		GraphicsAlgorithm endGa = startConnection.getEnd().getGraphicsAlgorithm();
		if (endGa != null) {
			Point p = StylesFactory.eINSTANCE.createPoint();
			p.setX(endGa.getX());
			p.setY(endGa.getY());
			points.add(p);
		}
		Point p0 = null;
		int min = -1, minDistance2 = -1;
		for (int i = 0; i < points.size(); i++) {
			Point p1 = points.get(i);
			if (p0 == null) {
				p0 = p1;
			} else {
				int distance2 = distance2(x, p0.getX(), y, p0.getX()) + distance2(x, p1.getX(), y, p1.getY());
				if (min < 0 || distance2 < minDistance2) {
					min = i;
					minDistance2 = distance2;
				}
				p0 = p1;
			}
		}
		for (int i = min; i > 0 && i < points.size(); i++) {
			Point p = points.get(i);
			if (p.eContainer() != null) {
				((List<?>) p.eContainer().eGet(p.eContainingFeature())).remove(p);
			}
			if (endConnection instanceof FreeFormConnection) {
				((FreeFormConnection) endConnection).getBendpoints().add(p);
			}
		}
	}
	
	private static int distance2(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}
	
	
}
