package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;

import com.google.inject.Inject;

public class RemovePortShapeFeature extends AbstractRemoveLinkFeature {

	@Inject
	private ILinkService linkService;
	
	@Inject
	public RemovePortShapeFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canRemove(IRemoveContext context) {
		if (! super.canRemove(context)) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof PortShape) {
			if (isUnlinked(pe, linkService)) {
				return true;
			}
			PortShape portShape = (PortShape) pe;
			if ((! portShape.isLocked()) && pe instanceof AnchorContainer) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void remove(IRemoveContext context) {
//		PictogramElement pe = context.getPictogramElement();
		super.remove(context);
//		removeConnections((AnchorContainer) pe);
//		removeFromContainer(pe);
	}
}
