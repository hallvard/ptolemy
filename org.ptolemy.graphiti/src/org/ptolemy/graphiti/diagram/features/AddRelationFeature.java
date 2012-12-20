package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaCreateService;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.ptolemy.ecore.kernel.Relation;

import com.google.inject.Inject;
 
public class AddRelationFeature extends AbstractAddFeature {

    private static final IColorConstant RELATION_FOREGROUND = new ColorConstant(98, 131, 167);
 
	@Inject
    public AddRelationFeature (IFeatureProvider fp) {
        super(fp);
    }
 
    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConContext = (IAddConnectionContext) context;
        Relation newRelation = (Relation) context.getNewObject();
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
       
        Connection connection = peCreateService.createFreeFormConnection(getDiagram());
        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        IGaService gaService = Graphiti.getGaService();
        Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(RELATION_FOREGROUND));
 
        BoxRelativeAnchor anchor = peCreateService.createBoxRelativeAnchor(connection);
        anchor.setRelativeWidth(0.5);
        anchor.setRelativeHeight(0.5);
        
        IGaCreateService gaCreateService = Graphiti.getGaCreateService();
        Rectangle anchorGa = gaCreateService.createPlainRectangle(anchor);
        gaService.setLocationAndSize(anchorGa, -2, -2, 5, 5);
        anchor.setReferencedGraphicsAlgorithm(polyline);

        // create link and wire it
        link(connection, newRelation);
 
        return connection;
    }
 
    public boolean canAdd(IAddContext context) {
        if (context instanceof IAddConnectionContext && context.getNewObject() instanceof Relation) {
            return true;
        }
        return false;
    }
}