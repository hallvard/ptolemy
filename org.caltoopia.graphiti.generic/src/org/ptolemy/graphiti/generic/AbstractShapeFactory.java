package org.ptolemy.graphiti.generic;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

import com.google.inject.Inject;

public class AbstractShapeFactory implements ShapeFactory {
	
	@Inject
	private ActordiagramFactory diagramFactory;

	@Override
	public EntityContainerDiagram createEntityContainerDiagram(EObject entity) {
		EntityContainerDiagram diagram = diagramFactory.createEntityContainerDiagram();
		link(diagram, entity);
		return diagram;
	}

	@Override
	public EntityShape createEntityShape(EObject entity) {
		EntityShape entityShape = diagramFactory.createEntityShape();
		link(entityShape, entity);
		return null;
	}

	@Override
	public PortShape createPortShape(EObject port) {
		PortShape portShape = diagramFactory.createPortShape();
		link(portShape, port);
		return portShape;
	}

	@Override
	public RelationShape createConnectionShape(EObject relation) {
		RelationShape relationShape = diagramFactory.createRelationShape();
		link(relationShape, relation);
		return relationShape;
	}

	//

	protected void link(Shape shape, List<EObject> bos) {
		EList<EObject> boList = Graphiti.getLinkService().getLinkForPictogramElement(shape).getBusinessObjects();
		ECollections.setEList(boList, bos);
	}
	
	protected void link(Shape shape, EObject... bo) {
		link(shape, Arrays.asList(bo));
	}
}
