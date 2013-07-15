package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;

import com.google.inject.Inject;

public class RemoveEntityShapeFeature extends AbstractRemoveLinkFeature {

	@Inject
	public RemoveEntityShapeFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canRemove(IRemoveContext context) {
		if (! super.canRemove(context)) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof EntityShape) {
//			if (isUnlinked((ModelShape<?>) pe)) {
//				return true;
//			}
//			EntityShape entityShape = (EntityShape) pe;
			return true;
		}
		return false;
	}
	
	@Override
	public void remove(IRemoveContext context) {
		PictogramElement pe = context.getPictogramElement();
		for (Shape shape : ((ContainerShape) pe).getChildren()) {
			if (shape instanceof PortShape) {
				removeConnections(shape);
			}
		}
		removeFromContainer(pe);
	}
}
