package org.ptolemy.graphiti.editor.dnd;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.dnd.URLTransfer;
import org.ptolemy.graphiti.diagram.features.AddImageFeature;
import org.ptolemy.graphiti.diagram.features.CreateImageFeature;

public class DragCreateImageSupport extends AbstractDragCreateSupport {

	public DragCreateImageSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		super(viewer, featureProvider);
	}

	@Override
	protected Transfer getDragTransfer() {
		return URLTransfer.getInstance();
	}

	@Override
	protected Object nativeToJava(TransferData transferData) {
		return URLTransfer.getInstance().nativeToJava(transferData);
	}

	static ICreateFeature getCreateImageFeature(Object object, IFeatureProvider featureProvider) {
		if (object instanceof String) {
			try {
				URL url = new URL(object.toString());
				if (AddImageFeature.isSupportedUrl(url)) {
					return new CreateImageFeature(featureProvider, url);
				}
			} catch (MalformedURLException e) {
			}
		}
		return null;
	}

	protected ICreateFeature getCreateFeature(Object object, IFeatureProvider featureProvider) {
		return getCreateImageFeature(object, featureProvider);
	}
}
