package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.actordiagram.PortShape;
import org.ptolemy.graphiti.diagram.features.util.OrientationSupport;

import com.google.inject.Inject;

public class UpdatePortFeature extends UpdateNameableFeature {
 
	@Inject
    public UpdatePortFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        return context.getPictogramElement() instanceof PortShape;
    }

	@Override
	protected boolean update(PictogramElement pe, EObject bo, boolean reallyUpdate) {
		boolean changed = super.update(pe, bo, reallyUpdate);
    	PortShape portShape = (PortShape) pe;
    	Port port = portShape.getModel();
    	boolean isDiagramPort = portShape.getContainer() instanceof Diagram;
		Boolean isInput = null;
		if (port instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) port;
			if (ioPort.isInput() && ioPort.isOutput()) {
			} else if (ioPort.isInput()) {
				isInput = Boolean.TRUE;
			} else if (ioPort.isOutput()) {
				isInput = Boolean.FALSE;
			}
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
		
    	boolean filled = port instanceof AbstractIOPort && (! ((AbstractIOPort) port).isMultiport());
    	changed |= (portShape.isFilled() != filled);
    	if (reallyUpdate) {
    		portShape.setFilled(filled);
    	}
    	boolean locked = isDiagramPort || (port != null && port.getInheritsFrom() != null);
    	changed |= (portShape.isLocked() != locked);
    	if (reallyUpdate) {
    		portShape.setLocked(locked);
    	}
    	return changed;
    }
}
