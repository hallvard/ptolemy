package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.ptolemy.graphiti.actordiagram.EntityShape;
import org.ptolemy.graphiti.actordiagram.PortShape;

public class MovePortFeature extends DefaultMoveShapeFeature {
 
    public MovePortFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canMoveShape(IMoveShapeContext context) {
        boolean canMove = super.canMoveShape(context) && context.getShape() instanceof PortShape;
        if (canMove) {
        	if (context.getSourceContainer() != context.getTargetContainer()) {
        		return false;
        	}
            GraphicsAlgorithm parentGa = context.getTargetContainer().getGraphicsAlgorithm();
            if (context.getX() < 0 || context.getX() > parentGa.getWidth()) {
            	return false;
            }
            if (context.getY() < 0 || context.getY() > parentGa.getHeight()) {
            	return false;
            }
        }
        return canMove;
    }

	@Override
	public void moveShape(IMoveShapeContext context) {
		super.moveShape(context);
		PortShape portShape = (PortShape) context.getShape();
        ContainerShape container = context.getTargetContainer();
        if (container instanceof EntityShape) {
        	GraphicsAlgorithm parentGa = container.getGraphicsAlgorithm();
        	int x = context.getX(), y = context.getY();
        	int width = parentGa.getWidth(), height = parentGa.getHeight();
        	Orientation alignment = null;
        	if (x < width / 3) {
        		alignment = Orientation.ALIGNMENT_LEFT;
        	} else if (x > width * 2 / 3) {
        		alignment = Orientation.ALIGNMENT_RIGHT;
        	} else if (y < height / 3) {
        		alignment = Orientation.ALIGNMENT_TOP;
        	} else if (y > height * 2 / 3) {
        		alignment = Orientation.ALIGNMENT_BOTTOM;
        	}
        	if (alignment != null) {
        		portShape.setAlignment(alignment);
        	}
            updatePictogramElement(portShape);
        	layoutPictogramElement(portShape);
        }
	}
}
