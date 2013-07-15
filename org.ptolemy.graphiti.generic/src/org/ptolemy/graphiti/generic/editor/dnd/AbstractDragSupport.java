package org.ptolemy.graphiti.generic.editor.dnd;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.swt.dnd.Transfer;

public abstract class AbstractDragSupport extends AbstractTransferDropTargetListener {

	private final IFeatureProvider featureProvider;
	
	protected AbstractDragSupport(EditPartViewer viewer, Transfer transfer, IFeatureProvider featureProvider) {
		super(viewer, transfer);
		this.featureProvider = featureProvider;
	}

	protected IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}
	
	static URL getEventObjectURL(Object eventObject) {
		if (eventObject instanceof String) {
			try {
				return new URL(eventObject.toString());
			} catch (MalformedURLException e) {
			}
		}
		return null;
	}
}
