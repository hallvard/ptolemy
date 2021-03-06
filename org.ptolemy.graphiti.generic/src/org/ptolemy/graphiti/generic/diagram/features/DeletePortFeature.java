package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;

import com.google.inject.Inject;

public class DeletePortFeature extends AbstractDeleteLinkFeature {

	@Inject
	public DeletePortFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canDelete(IDeleteContext context) {
		if (! super.canDelete(context)) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof PortShape) {
			PortShape portShape = (PortShape) pe;
			return ! portShape.isLocked();
		}
		return false;
	}

	@Override
	protected void deleteBusinessObject(Object bo) {
		// TODO
	}

//	protected void deletePort(Port port) {
//		deleteLinks(port, true, true);
//		deleteFromContainer(port);
//	}
}
