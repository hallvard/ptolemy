package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaCreateService;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.generic.actordiagram.RelationConnection;

import com.google.inject.Inject;
 
public class AddRelationFeature extends AbstractAddFeature {

    private static final IColorConstant RELATION_FOREGROUND = new ColorConstant(98, 131, 167);
 
	@Inject
    public AddRelationFeature (IFeatureProvider fp) {
        super(fp);
    }
 
    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConContext = (IAddConnectionContext) context;
        Connection connection = createRelationConnection(addConContext.getSourceAnchor(), addConContext.getTargetAnchor());
        // create link and wire it
        link(connection, context.getNewObject());
 
        return connection;
    }

    RelationConnection createRelationConnection(Anchor start, Anchor end) {
    	RelationConnection connection = createRelationConnection();
	    connection.setStart(start);
	    connection.setEnd(end);
	
	    IGaService gaService = Graphiti.getGaService();
	    Polyline polyline = gaService.createPolyline(connection);
	    polyline.setLineWidth(2);
	    polyline.setForeground(manageColor(RELATION_FOREGROUND));
	
	    BoxRelativeAnchor anchor = Graphiti.getPeCreateService().createBoxRelativeAnchor(connection);
	    anchor.setRelativeWidth(0.5);
	    anchor.setRelativeHeight(0.5);
	    
	    IGaCreateService gaCreateService = Graphiti.getGaCreateService();
	    Rectangle anchorGa = gaCreateService.createPlainRectangle(anchor);
	    anchorGa.setFilled(true);
	    anchorGa.setLineVisible(true);
	    gaService.setLocationAndSize(anchorGa, -2, -2, 15, 15);
	    anchor.setReferencedGraphicsAlgorithm(polyline);
	    return connection;
	}
    
    RelationConnection createRelationConnection() {
    	RelationConnection connection = ActordiagramFactory.eINSTANCE.createRelationConnection(); // peCreateService.createFreeFormConnection(getDiagram());
        connection.setVisible(true);
        connection.setActive(true);
        connection.setParent(getDiagram());
		return connection;
	}
 
    public boolean canAdd(IAddContext context) {
        if (context instanceof IAddConnectionContext && context.getNewObject() instanceof EObject) {
            return true;
        }
        return false;
    }
}