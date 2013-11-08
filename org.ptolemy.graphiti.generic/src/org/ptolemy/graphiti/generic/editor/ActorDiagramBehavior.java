package org.ptolemy.graphiti.generic.editor;

import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.ptolemy.graphiti.generic.editor.dnd.DragCreateImageSupport;
import org.ptolemy.graphiti.generic.editor.dnd.DragCreateNoteImageSupport;
import org.ptolemy.graphiti.generic.editor.dnd.DragImportActorsSupport;
import org.ptolemy.graphiti.generic.editor.dnd.EObjectUriDragSourceListener;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ActorDiagramBehavior extends DiagramBehavior {

	@Inject
	public ActorDiagramBehavior(ActorDiagramEditor diagramContainer) {
		super(diagramContainer);
		setParentPart(diagramContainer);
	}

	@Override
	public void initDefaultBehaviors() {
		super.initDefaultBehaviors();
	}
	
	protected ActorDiagramEditor getDiagramEditor() {
		return ((ActorDiagramEditor) getDiagramContainer());
	}

	@Override
	public void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().addDropTargetListener(new DragCreateNoteImageSupport(getGraphicalViewer(), getDiagramTypeProvider().getFeatureProvider()));
		getGraphicalViewer().addDropTargetListener(new DragCreateImageSupport(getGraphicalViewer(), getDiagramTypeProvider().getFeatureProvider()));
		
		getGraphicalViewer().addDropTargetListener(new DragImportActorsSupport(getDiagramTypeProvider().getFeatureProvider()));
		getEditDomain().getPaletteViewer().addDropTargetListener(new DragImportActorsSupport(getDiagramTypeProvider().getFeatureProvider()));

//		new DragSource(getGraphicalViewer().getControl(), DND.DROP_COPY);
//		getGraphicalViewer().addDragSourceListener(new EObjectUriDragSourceListener());
	}

	private GraphicalViewer getGraphicalViewer() {
		return getDiagramContainer().getGraphicalViewer();
	}
	
	@Inject
	private ActorDiagramPersistencyBehavior persistencyBehavior;
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return persistencyBehavior;
	}

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new DefaultUpdateBehavior(this) {
			@Override
			protected void createEditingDomain() {
				if (getDiagramContainer() instanceof ActorDiagramEditor) {
					ActorDiagramEditor diagramEditor = (ActorDiagramEditor) getDiagramContainer();
					ActorDiagramEditor editor = diagramEditor.getMainEditor();
					if (editor != null && editor != getDiagramContainer()) {
						initializeEditingDomain(editor.getEditingDomain());
						return;
					}
				}
				super.createEditingDomain();
			}
//			@Override
//			public void dispose() {
//				try {
//					super.dispose();
//				} catch (Exception e) {
//				}
//			}
			@Override
			public void historyNotification(OperationHistoryEvent event) {
				// filter out notifications from other threads, e.g. XtextEditorCommands
				if (getGraphicalViewer().getControl().getDisplay().getThread() == Thread.currentThread()) {
					super.historyNotification(event);
				}
			}
		};
	}
	
	@Override
	public Point calculateRealMouseLocation(Point nativeLocation) {
		Point realMouseLocation = nativeLocation;
		try {
			realMouseLocation = super.calculateRealMouseLocation(nativeLocation);
		} catch (Exception e) {
		}
		return realMouseLocation;
	}
}
