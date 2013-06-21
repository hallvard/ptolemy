package org.ptolemy.graphiti.generic.diagram.features;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.NameViewModel;
import org.ptolemy.graphiti.generic.actordiagram.LabelShape;

import com.google.inject.Inject;

public abstract class UpdateNameableFeature extends AbstractUpdateFeature {
 
	@Inject
	protected ILinkService linkService;
	
	@Inject
	protected NameViewModel nameViewModel;

	@Inject
    public UpdateNameableFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        PictogramElement pe = context.getPictogramElement();
		return canUpdate(pe);
    }
    
    protected boolean canUpdate(PictogramElement pe) {
    	EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		return pe instanceof LabelShape && nameViewModel.getName(bo) != null;
    }

    @Override
    public IReason updateNeeded(IUpdateContext context) {
        PictogramElement pe = context.getPictogramElement();
        if (AbstractRemoveLinkFeature.isUnlinked(pe, linkService)) {
        	return Reason.createTrueReason("Model removed");
        }
        return (update(pe, false) ? Reason.createTrueReason("Out of date") : Reason.createFalseReason());
    }

    @Override
    public boolean update(IUpdateContext context) {
    	PictogramElement pe = context.getPictogramElement();
//        if (AbstractRemoveLinkFeature.isUnlinked(pe)) {
//        	removeNeeded((Shape) pe);
//        	return true;
//        }
    	boolean changed = update(pe, true);
		LayoutContext layoutContext = new LayoutContext(pe);
		ILayoutFeature layoutFeature = getFeatureProvider().getLayoutFeature(layoutContext);
		if (layoutFeature != null && layoutFeature.canLayout(layoutContext)) {
			layoutFeature.layout(layoutContext);
		}
		return changed;
    }

    protected boolean update(PictogramElement pe, boolean reallyUpdate) {
        if (AbstractRemoveLinkFeature.isUnlinked(pe, linkService)) {
        	if (reallyUpdate) {
        		removeNeeded((Shape) pe);
        	}
        	return true;
        }
    	if (pe instanceof LabelShape) {
	    	LabelShape labelShape = (LabelShape) pe;
	        AbstractText textShape = labelShape.getLabel();
	    	String pictogramName = textShape.getValue();
	        // retrieve name from business model
	    	EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
			String actorName = nameViewModel.getName(bo);
	        // update needed, if names are different
	        if (actorName != null ? (! actorName.equals(pictogramName)) : pictogramName != null) {
	        	if (reallyUpdate) {
	        		textShape.setValue(actorName);
	        	}
	        	return true;
	        }
    	}
        return false;
    }
    
    protected Collection<PictogramElement> getExtraChildren(ContainerShape containerShape) {
    	Collection<PictogramElement> extraChildren = new ArrayList<PictogramElement>();
    	addUnlinked(containerShape.getChildren(), extraChildren);
		if (containerShape instanceof Diagram) {
	    	addUnlinked(((Diagram) containerShape).getConnections(), extraChildren);
		}
    	return extraChildren;
    }

	private void addUnlinked(Iterable<? extends PictogramElement> pes, Collection<PictogramElement> extraChildren) {
		for (PictogramElement connection : pes) {
			addUnlinked(connection, extraChildren);
		}
	}

	private void addUnlinked(PictogramElement pe, Collection<PictogramElement> extraChildren) {
		EObject model = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		if (model == null || model.eIsProxy()) {
			extraChildren.add(pe);
		}
	}
    
    protected IRemoveContext createRemoveContext(PictogramElement pe) {
    	RemoveContext removeContext = new RemoveContext(pe);
    	return removeContext;
    }

    protected Shape findModelShape(ContainerShape containerShape, EObject model) {
    	for (Shape shape : containerShape.getChildren()) {
    		if (linkService.getBusinessObjectForLinkedPictogramElement(shape) == model) {
    			return shape;
    		}
    	}
    	return null;
    }

    protected Connection findConnection(Diagram diagram, EObject model) {
    	for (Connection connection : diagram.getConnections()) {
    		Object bo = getBusinessObjectForPictogramElement(connection);
			if (bo == model) {
    			return connection;
    		}
    	}
    	return null;
    }

    protected <T extends EObject> Collection<T> getMissingChildren(ContainerShape containerShape, Iterable<T> children) {
    	Collection<T> missingChildren = new ArrayList<T>();
    	for (T eObject : children) {
    		if (findModelShape(containerShape, eObject) != null) {
    			continue;
    		}
    		if (containerShape instanceof Diagram && findConnection((Diagram) containerShape, eObject) != null) {
				continue;
			}
    		missingChildren.add(eObject);
    	}
    	return missingChildren;
    }
    
    protected IAddContext createAddContext(ContainerShape containerShape, Object entity) {
    	AddContext addContext = new AddContext();
    	addContext.setTargetContainer(containerShape);
    	addContext.setNewObject(entity);
    	return addContext;
    }
    
    //

    protected boolean removeNeeded(ContainerShape containerShape, boolean reallyRemove) {
    	boolean changed = false;
		for (PictogramElement pe : getExtraChildren(containerShape)) {
			if (! reallyRemove) {
				return true;
			}
			removeNeeded(pe);
			changed = true;
		}
		return changed;
    }

	protected void removeNeeded(PictogramElement pe) {
		IRemoveContext removeContext = createRemoveContext(pe);
		IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(removeContext);
		if (removeFeature != null && removeFeature.canRemove(removeContext)) {
			removeFeature.remove(removeContext);
		}
	}
    
    protected boolean addNeeded(ContainerShape containerShape, Iterable<? extends EObject> children, boolean reallyAdd) {
    	boolean changed = false;
		for (EObject child : getMissingChildren(containerShape, children)) {
			if (! reallyAdd) {
				return true;
			}
    		IAddContext addContext = createAddContext(containerShape, child);
			IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
			if (addFeature != null && addFeature.canAdd(addContext)) {
				addFeature.add(addContext);
			}
			changed = true;
		}
		return changed;
    }
}
