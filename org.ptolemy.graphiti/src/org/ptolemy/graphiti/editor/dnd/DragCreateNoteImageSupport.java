package org.ptolemy.graphiti.editor.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

public class DragCreateNoteImageSupport extends DragCreateNoteSupport {

	public DragCreateNoteImageSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		super(viewer, featureProvider);
	}

	@Override
	protected ICreateFeature getCreateFeature(Object object, IFeatureProvider featureProvider) {
		ICreateFeature createImageFeature = DragCreateImageSupport.getCreateImageFeature(object, featureProvider);
		return (createImageFeature != null ? createImageFeature : super.getCreateFeature(object, featureProvider));
	}
}
