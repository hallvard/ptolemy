package org.caltoopia.graphiti;

import org.caltoopia.frontend.cal.AstActorVariable;
import org.caltoopia.frontend.cal.AstEntity;
import org.caltoopia.frontend.cal.AstNamespace;
import org.caltoopia.frontend.cal.AstNetwork;
//import org.caltoopia.graphiti.caldiagram.CaldiagramFactory;
import org.eclipse.emf.ecore.EObject;
import org.ptolemy.graphiti.generic.AbstractShapeFactory;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

import com.google.inject.Inject;

public class CalShapeFactory extends AbstractShapeFactory {

//	@Inject
//	private CaldiagramFactory caldiagramFactory;
//
//	@Override
//	public EntityContainerDiagram<?> createEntityContainerDiagram(EObject entity) {
//		EntityContainerDiagram<?> diagram = null;
//		if (entity instanceof AstNetwork) {
//			diagram = caldiagramFactory.createCalNetworkDiagram();
//		} else if (entity instanceof AstNamespace) {
//			diagram = caldiagramFactory.createCalNamespaceDiagram();
//		}
//		if (diagram != null) {
//			link(diagram, entity);
//		}
//		return diagram;
//	}
//
//	@Override
//	public EntityShape<?> createEntityShape(EObject entity) {
//		EntityShape<?> entityShape = null;
//		if (entity instanceof AstEntity) {
//			entityShape = caldiagramFactory.createCalEntityShape();
//		} else if (entity instanceof AstActorVariable) {
//			entityShape = caldiagramFactory.createCalActorVariableShape();
//		}
//		if (entityShape != null) {
//			link(entityShape, entity);
//		}
//		return null;
//	}
//
//	@Override
//	public PortShape<?> createPortShape(EObject port) {
//		PortShape<?> portShape = caldiagramFactory.createCalPortShape();
//		link(portShape, port);
//		return portShape;
//	}
//
//	@Override
//	public RelationShape<?> createConnectionShape(EObject relation) {
//		RelationShape<?> relationShape = caldiagramFactory.createCalConnectionShape();
//		link(relationShape, relation);
//		return relationShape;
//	}

}
