package org.ptolemy.graphiti.generic.editor.dnd;

import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;

public class EObjectUriDragSourceListener extends DragSourceAdapter implements TransferDragSourceListener {

	@Override
	public void dragSetData(DragSourceEvent event) {
	}

	@Override
	public Transfer getTransfer() {
		return TextTransfer.getInstance();
	}
}
