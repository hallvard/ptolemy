package org.ptolemy.graphiti.generic.editor.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

public class DragCreateNoteImageSupport extends DragCreateNoteSupport {

	public DragCreateNoteImageSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		super(viewer, featureProvider);
	}

	@Override
	protected ICreateFeature getCreateFeature(Object eventObject, IFeatureProvider featureProvider) {
		ICreateFeature createImageFeature = DragCreateImageSupport.getCreateImageFeature(eventObject, featureProvider);
		return (createImageFeature != null ? createImageFeature : super.getCreateFeature(eventObject, featureProvider));
	}
}
