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

public abstract class AbstractDragCreateSupport extends AbstractDragSupport {

	protected AbstractDragCreateSupport(EditPartViewer viewer, Transfer transfer, IFeatureProvider featureProvider) {
		super(viewer, transfer, featureProvider);
	}

	public AbstractDragCreateSupport(EditPartViewer viewer, IFeatureProvider featureProvider) {
		this(viewer, TextTransfer.getInstance(), featureProvider);
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
	
	protected abstract ICreateFeature getCreateFeature(Object eventObject, IFeatureProvider featureProvider);

	protected Object getDropTargetEventObject(DropTargetEvent event) {
		Object string = null;
		if (event.data != null) {
			string = event.data;
		} else if (event.currentDataType != null) {
			string = nativeToJava(event.currentDataType);
		}
		return string;
	}

	private class NoteCreationFactory implements CreationFactory {

		public ICreateFeature getCreateFeature() {
			return AbstractDragCreateSupport.this.getCreateFeature(getDropTargetEventObject(getCurrentEvent()), getFeatureProvider());
		}

		public Object getNewObject() {
			return getCreateFeature();
		}

		public Object getObjectType() {
			return (getCreateFeature() instanceof ICreateFeature ? ICreateFeature.class : null);
		}
	}
}
