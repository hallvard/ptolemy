package org.ptolemy.graphiti.diagram.features;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ILocationContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;
import org.eclipse.graphiti.ui.internal.util.clipboard.ModelClipboard;

import com.google.inject.Inject;

public class PasteFeature extends AbstractPasteFeature {

	@Inject
	public PasteFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canPaste(IPasteContext context) {
		return paste(context, false);
    }

	protected ContainerShape getTargetContainer(PictogramElement[] pictogramElements) {
		if (pictogramElements.length == 1 && (pictogramElements[0] instanceof ContainerShape)) {
        	return (ContainerShape) pictogramElements[0];
        }
		return null;
	}

	protected AddContext getAddContext(ContainerShape targetContainer, EObject eObject, IContext context) {
		AddContext addContext = new AddContext();
		addContext.setTargetContainer(targetContainer);
		if (context instanceof ILocationContext) {
			addContext.setLocation(((ILocationContext) context).getX(), ((ILocationContext) context).getY());
		}
		addContext.setNewObject(eObject);
		return addContext;
	}
	
	@Override
	public void paste(IPasteContext context) {
		paste(context, true);
	}

	public boolean paste(IPasteContext context, boolean reallyPaste) {
        ContainerShape targetContainer = getTargetContainer(context.getPictogramElements());
        Object[] fromClipboard = getFromClipboard();
        if (targetContainer == null || fromClipboard == null) {
            return false;
        }
        Collection<Object> copiesOfAdded = new ArrayList<Object>();
        IFeatureProvider featureProvider = getFeatureProvider();
        for (Object object : getFromClipboard()) {
        	if (object instanceof EObject) {
        		AddContext addContext = getAddContext(targetContainer, (EObject) object, context);
        		if (! featureProvider.canAdd(addContext).toBoolean()) {
        			continue;
            	}
        		if (reallyPaste) {
        			copiesOfAdded.add(EcoreUtil.copy((EObject) object));
        			featureProvider.addIfPossible(addContext);
        		}
            }
        }
        if (copiesOfAdded.size() == 0) {
        	return false;
        }
        if (reallyPaste) {
        	ModelClipboard.getDefault().setContent(copiesOfAdded.toArray(new EObject[copiesOfAdded.size()]));
        }
        return true;
    }
}
