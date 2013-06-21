package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel.PortKind;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;
import org.ptolemy.graphiti.generic.diagram.features.util.OrientationSupport;

import com.google.inject.Inject;

public class UpdatePortFeature extends UpdateNameableFeature {
 
	@Inject
	private ActorViewModel actorViewModel;
	
	@Inject
    public UpdatePortFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        return context.getPictogramElement() instanceof PortShape;
    }

	@Override
	protected boolean update(PictogramElement pe, boolean reallyUpdate) {
		boolean changed = super.update(pe, reallyUpdate);
    	PortShape portShape = (PortShape) pe;
    	EObject port = linkService.getBusinessObjectForLinkedPictogramElement(portShape);
    	boolean isDiagramPort = portShape.getContainer() instanceof Diagram;
		Boolean isInput = null;
		if (actorViewModel.isPort(port, PortKind.IO)) {
		} else if (actorViewModel.isPort(port, PortKind.INPUT)) {
			isInput = Boolean.TRUE;
		} else if (actorViewModel.isPort(port, PortKind.OUTPUT)) {
			isInput = Boolean.FALSE;
		}
		if (isInput != null) {
			Orientation orientation = Orientation.ALIGNMENT_RIGHT; 
			int rotation = 0;
			rotation = OrientationSupport.distance((isInput ? Orientation.ALIGNMENT_LEFT : Orientation.ALIGNMENT_RIGHT), portShape.getAlignment());
			Orientation anchorAlignment = (isInput == isDiagramPort ? Orientation.ALIGNMENT_RIGHT : Orientation.ALIGNMENT_LEFT);
			// orientation of port
			orientation = OrientationSupport.rotate(orientation, rotation);
			changed |= (portShape.getOrientation() != orientation);
			if (reallyUpdate) {
				portShape.setOrientation(orientation);
			}
			
			// alignment of outside anchor
			if (portShape.getOutsideAnchor() != null) {
				anchorAlignment = OrientationSupport.rotate(anchorAlignment, rotation);
				changed |= (portShape.getOutsideAnchor().getAlignment() != anchorAlignment);
				if (reallyUpdate) {
					portShape.getOutsideAnchor().setAlignment(anchorAlignment);
				}
			}
			// alignment of inside anchor
			if (portShape.getInsideAnchor() != null) {
				anchorAlignment = OrientationSupport.rotate(anchorAlignment, 2);
				changed |= (portShape.getInsideAnchor().getAlignment() != anchorAlignment);
				if (reallyUpdate) {
					portShape.getInsideAnchor().setAlignment(anchorAlignment);
				}
			}
		}
		
    	boolean filled = actorViewModel.isMulti(port);
    	changed |= (portShape.isFilled() != filled);
    	if (reallyUpdate) {
    		portShape.setFilled(filled);
    	}
    	boolean locked = isDiagramPort || true; // (port != null && port.getInheritsFrom() != null);
    	changed |= (portShape.isLocked() != locked);
    	if (reallyUpdate) {
    		portShape.setLocked(locked);
    	}
    	return changed;
    }
}
