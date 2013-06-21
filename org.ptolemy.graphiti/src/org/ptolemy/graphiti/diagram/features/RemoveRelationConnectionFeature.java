package org.ptolemy.graphiti.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.google.inject.Inject;

public class RemoveRelationConnectionFeature extends AbstractRemoveLinkFeature {

	@Inject
	public RemoveRelationConnectionFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canRemove(IRemoveContext context) {
		if (! super.canRemove(context)) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		return pe instanceof Connection;
	}
	
	@Override
	public void remove(IRemoveContext context) {
		super.remove(context);
//		PictogramElement pe = context.getPictogramElement();
//		removeConnection((Connection) pe);
	}
}
