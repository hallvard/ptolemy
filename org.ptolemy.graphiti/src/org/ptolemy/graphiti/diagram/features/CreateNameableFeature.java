package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.ecore.kernel.Nameable;

import com.google.inject.Inject;

public abstract class CreateNameableFeature extends AbstractCreateFeature {

	@Inject
    protected CreateNameableFeature(IFeatureProvider fp, String name, String description) {
    	super(fp, name, description);
    }

	@Override
	public boolean canCreate(ICreateContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(targetContainer);
		return canCreate(targetContainer, bo);
	}

	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return false;
	}

	public Object[] create(ICreateContext context) {

		ContainerShape targetContainer = context.getTargetContainer();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(targetContainer);
		Nameable nameable = create(targetContainer, bo);
		if (nameable == null) {
			return null;
		}
		invokeAddFeature(context, nameable);
        getFeatureProvider().getDirectEditingInfo().setActive(true);

        return new Object[]{nameable};
	}

	protected void invokeAddFeature(ICreateContext context, Nameable nameable) {
		addGraphicalRepresentation(context, nameable);
	}

	protected abstract Nameable create(ContainerShape targetContainer, EObject bo);
}