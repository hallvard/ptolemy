package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.actordiagram.RelationConnection;

import com.google.inject.Inject;

public class DeleteRelationFeature extends AbstractDeleteLinkFeature {

	@Inject
	public DeleteRelationFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canDelete(IDeleteContext context) {
		if (! super.canDelete(context)) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		return (pe instanceof RelationConnection);
	}
	
	@Override
	protected void deleteBusinessObject(Object bo) {
		// TODO
//		if (bo instanceof Relation) {
//			deleteRelation((Relation) bo);
//		}
	}
}
