package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.services.Graphiti;

import com.google.inject.Inject;

public class DeleteIEntityFeature extends AbstractDeleteLinkFeature {

	@Inject
	public DeleteIEntityFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canDelete(IDeleteContext context) {
		if (! super.canDelete(context)) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		return connectionContainerEditModel.isEntity(bo, null);
	}

	@Override
	public void delete(IDeleteContext context) {
		super.delete(context);
		PictogramElement pe = context.getPictogramElement();
		PictogramLink link = Graphiti.getLinkService().getLinkForPictogramElement(pe);
		deleteFromContainer(link);
	}

	@Override
	protected void deleteBusinessObject(Object bo) {
//		deleteEntity((Entity<? extends Port>) bo);
	}

//	protected void deleteEntity(IEntity<? extends Port> entity) {
//		for (Port port : entity.getPorts()) {
//			deleteLinks(port, true, false);
//		}
//		deleteFromContainer(entity);
//	}
}
