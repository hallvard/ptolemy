package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.actordiagram.RelationShape;

public interface ShapeFactory {
	
	public EntityContainerDiagram createEntityContainerDiagram(EObject entity);
	public EntityShape createEntityShape(EObject entity);
	public PortShape createPortShape(EObject port);
	public RelationShape createConnectionShape(EObject relation);

}
