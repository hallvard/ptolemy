package org.ptolemy.graphiti.editor.dnd;

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

public abstract class AbstractDragCreateSupport extends AbstractTransferDropTargetListener {

	private final IFeatureProvider featureProvider;
	
	public AbstractDragCreateSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		super(viewer);
		this.featureProvider = featureProvider;
		setTransfer(getDragTransfer());
	}

	private IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}
	
	protected Transfer getDragTransfer() {
		return TextTransfer.getInstance();
	}
	
	@Override
	protected void updateTargetRequest() {
		((CreateRequest) getTargetRequest()).setLocation(getDropLocation());
	}

	@Override
	protected Request createTargetRequest() {
		CreateRequest request = new CreateRequest();

		request.setFactory(new NoteCreationFactory());
		request.setLocation(getDropLocation());
		return request;
	}
	
	protected Object nativeToJava(TransferData transferData) {
		return TextTransfer.getInstance().nativeToJava(transferData);
	}
	
	protected abstract ICreateFeature getCreateFeature(Object object, IFeatureProvider featureProvider);
	
	private class NoteCreationFactory implements CreationFactory {

		public Object getNewObject() {
			DropTargetEvent currentEvent = getCurrentEvent();
			Object string = null;
			if (currentEvent.data != null) {
				string = currentEvent.data;
			} else if (currentEvent.currentDataType != null) {
				string = nativeToJava(currentEvent.currentDataType);
			}
			ICreateFeature createFeature = getCreateFeature(string, getFeatureProvider());
			return createFeature;
		}

		public Object getObjectType() {
			return ICreateFeature.class;
		}
	}
}
