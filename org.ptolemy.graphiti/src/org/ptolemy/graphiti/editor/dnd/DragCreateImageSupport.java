package org.ptolemy.graphiti.editor.dnd;

import java.net.URL;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.dnd.URLTransfer;
import org.ptolemy.graphiti.diagram.features.AddImageFeature;
import org.ptolemy.graphiti.diagram.features.CreateImageFeature;

public class DragCreateImageSupport extends AbstractDragCreateSupport {

	public DragCreateImageSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		super(viewer, URLTransfer.getInstance(), featureProvider);
	}

	@Override
	protected Object nativeToJava(TransferData transferData) {
		return URLTransfer.getInstance().nativeToJava(transferData);
	}

	static ICreateFeature getCreateImageFeature(Object eventObject, IFeatureProvider featureProvider) {
		URL url = getEventObjectURL(eventObject);
		if (url != null && AddImageFeature.isSupportedUrl(url)) {
			return new CreateImageFeature(featureProvider, url);
		}
		return null;
	}

	@Override
	public boolean isEnabled(DropTargetEvent event) {
		URL url = getEventObjectURL(getDropTargetEventObject(event));
		return (url != null && AddImageFeature.isSupportedUrl(url));
	}

	protected ICreateFeature getCreateFeature(Object eventObject, IFeatureProvider featureProvider) {
		return getCreateImageFeature(eventObject, featureProvider);
	}
}
