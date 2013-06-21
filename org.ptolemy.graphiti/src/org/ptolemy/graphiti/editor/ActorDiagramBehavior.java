package org.ptolemy.graphiti.editor;

import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.ptolemy.graphiti.Activator;
import org.ptolemy.graphiti.editor.dnd.DragCreateImageSupport;
import org.ptolemy.graphiti.editor.dnd.DragCreateNoteImageSupport;
import org.ptolemy.graphiti.editor.dnd.DragImportActorsSupport;

import com.google.inject.Inject;

public class ActorDiagramBehavior extends DiagramBehavior {

	@Inject
	public ActorDiagramBehavior(ActorDiagramEditor diagramContainer) {
		super(diagramContainer);
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
	}

	private GraphicalViewer getGraphicalViewer() {
		return getDiagramContainer().getGraphicalViewer();
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		ActorDiagramPersistencyBehavior persistencyBehavior = new ActorDiagramPersistencyBehavior(this) {
			@Override
			public Diagram loadDiagram(URI uri) {
				Diagram diagram = null;
				if (getDiagramContainer() instanceof ActorDiagramEditor) {
					ActorDiagramEditor diagramEditor = (ActorDiagramEditor) getDiagramContainer();
					if (diagramEditor.isMainEditor()) {
						diagram = super.loadDiagram(uri);
					} else {
						diagram = diagramEditor.getMultiPageActorDiagramEditor().getActorEditorDiagram(diagramEditor);
					}
				} else {
					diagram = super.loadDiagram(uri);
				}
				return diagram;
			}
		};
		Activator.getDefault().getInjector().injectMembers(persistencyBehavior);
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
			@Override
			public void historyNotification(OperationHistoryEvent event) {
				// filter out notifications from other threads, e.g. XtextEditorCommands
				if (getGraphicalViewer().getControl().getDisplay().getThread() == Thread.currentThread()) {
					super.historyNotification(event);
				}
			}
		};
	}
}
