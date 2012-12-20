package org.ptolemy.graphiti.editor.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.ptolemy.graphiti.diagram.features.CreateNoteFeature;

public class DragCreateNoteSupport extends AbstractDragCreateSupport {

	public DragCreateNoteSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		super(viewer, featureProvider);
	}

	@Override
	protected ICreateFeature getCreateFeature(Object object, IFeatureProvider featureProvider) {
		return new CreateNoteFeature(featureProvider, object instanceof String ? (String) object : "A note");
	}
}
