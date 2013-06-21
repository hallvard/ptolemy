package org.ptolemy.graphiti.editor.dnd;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

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
