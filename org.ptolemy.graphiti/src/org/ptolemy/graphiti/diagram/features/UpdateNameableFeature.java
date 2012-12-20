package org.ptolemy.graphiti.diagram.features;

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
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.graphiti.actordiagram.LabelShape;
import org.ptolemy.graphiti.actordiagram.ModelShape;

import com.google.inject.Inject;

public abstract class UpdateNameableFeature extends AbstractUpdateFeature {
 
	@Inject
    public UpdateNameableFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        PictogramElement pe = context.getPictogramElement();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		return canUpdate(pe, bo);
    }
    
    protected boolean canUpdate(PictogramElement pe, EObject bo) {
    	return pe instanceof LabelShape && bo instanceof Nameable;
    }

    String getDisplayName(Nameable named) {
		String displayName = named.getDisplayName();
		if (displayName == null || "".equals(displayName)) {
			displayName = named.getName();
		}
		return displayName;
    }
    
    @Override
    public IReason updateNeeded(IUpdateContext context) {
        PictogramElement pe = context.getPictogramElement();
        if (AbstractRemoveLinkFeature.isUnlinked(pe)) {
        	return Reason.createTrueReason("Model removed");
        }
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        return (update(pe, bo, false) ? Reason.createTrueReason("Out of date") : Reason.createFalseReason());
    }

    @Override
    public boolean update(IUpdateContext context) {
    	PictogramElement pe = context.getPictogramElement();
//        if (AbstractRemoveLinkFeature.isUnlinked(pe)) {
//        	removeNeeded((Shape) pe);
//        	return true;
//        }
    	EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    	boolean changed = update(pe, bo, true);
		LayoutContext layoutContext = new LayoutContext(pe);
		ILayoutFeature layoutFeature = getFeatureProvider().getLayoutFeature(layoutContext);
		if (layoutFeature != null && layoutFeature.canLayout(layoutContext)) {
			layoutFeature.layout(layoutContext);
		}
		return changed;
    }

    protected boolean update(PictogramElement pe, EObject bo, boolean reallyUpdate) {
        if (AbstractRemoveLinkFeature.isUnlinked(pe)) {
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
	    	Nameable named = (Nameable) bo;
			String actorName = getDisplayName(named);
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
    
    protected <T> Collection<Shape> getExtraChildren(ContainerShape containerShape) {
    	Collection<Shape> extraChildren = new ArrayList<Shape>();
    	for (Shape shape : containerShape.getChildren()) {
    		if (shape instanceof ModelShape<?>) {
    			EObject model = ((ModelShape<? extends EObject>) shape).getModel();
    			if (model == null || model.eIsProxy()) {
    				extraChildren.add(shape);
    			}
    		}
    	}
    	return extraChildren;
    }
    
    protected IRemoveContext createRemoveContext(Shape shape) {
    	RemoveContext removeContext = new RemoveContext(shape);
    	return removeContext;
    }

    protected <T> ModelShape<T> findModelShape(ContainerShape containerShape, T model) {
    	for (Shape shape : containerShape.getChildren()) {
    		if (shape instanceof ModelShape<?> && ((ModelShape<?>) shape).getModel() == model) {
    			return (ModelShape<T>) shape;
    		}
    	}
    	return null;
    }

    protected <T> Collection<T> getMissingChildren(ContainerShape containerShape, Iterable<T> children) {
    	Collection<T> missingChildren = new ArrayList<T>();
    	for (T eObject : children) {
    		if (findModelShape(containerShape, eObject) == null) {
    			missingChildren.add(eObject);
    		}
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
		for (Shape shape : getExtraChildren(containerShape)) {
			if (! reallyRemove) {
				return true;
			}
			removeNeeded(shape);
			changed = true;
		}
		return changed;
    }

	protected void removeNeeded(Shape shape) {
		IRemoveContext removeContext = createRemoveContext(shape);
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
