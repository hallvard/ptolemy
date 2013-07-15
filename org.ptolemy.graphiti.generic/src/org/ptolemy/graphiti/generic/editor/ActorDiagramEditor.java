package org.ptolemy.graphiti.generic.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

import com.google.inject.Inject;

public class ActorDiagramEditor extends DiagramEditor {

	private MultiPageActorDiagramEditor multiPageEditor;	

	@Inject
	private ActorDiagramBehavior actorDiagramBehavior;
	
	@Override
	protected DiagramBehavior createDiagramBehavior() {
		actorDiagramBehavior.initDefaultBehaviors();
		return actorDiagramBehavior;
	}
	
	public MultiPageActorDiagramEditor getMultiPageActorDiagramEditor() {
		return multiPageEditor;
	}
	
	void setMultiPageActorDiagramEditor(MultiPageActorDiagramEditor multiPageEditor) {
		this.multiPageEditor = multiPageEditor;
	}

	public ActorDiagramEditor getMainEditor() {
		return (multiPageEditor != null ? multiPageEditor.getMainEditor() : null);
	}
	
	public boolean isMainEditor() {
		ActorDiagramEditor mainEditor = getMainEditor();
		return (mainEditor == null || mainEditor == ActorDiagramEditor.this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// If not the active editor, ignore selection changed.
		IEditorPart activeEditor = getSite().getPage().getActiveEditor();
		if (multiPageEditor != null && multiPageEditor == activeEditor && multiPageEditor.getActiveEditor() == this) {
			updateActions(getSelectionActions());
		} else {
			super.selectionChanged(part, selection);
		}
	}

	private void openEditor(final Diagram diagram, Boolean asyncCreate) {
		if (multiPageEditor != null) {
			ActorDiagramEditor otherDiagramEditor = multiPageEditor.getActorDiagramEditor(diagram);
			if (otherDiagramEditor == null && Boolean.TRUE.equals(asyncCreate)) {
				EList<EObject> diagrams = multiPageEditor.getDiagramResource().getContents();
				if (! diagrams.contains(diagram)) {
					diagrams.add(diagram);
				}
			}
			if (asyncCreate != null) {
				getGraphicalViewer().getControl().getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						openEditor(diagram, null);
					}
				});
			} else if (otherDiagramEditor != null) {
				multiPageEditor.setActiveEditor(otherDiagramEditor);
			}
		}
	}
	
	public void openEditor(Diagram diagram) {
		openEditor(diagram, true);
	}

	public void selectBusinessObjects(Collection<? extends EObject> bos) {
		TreeIterator<Notifier> allContents = getEditingDomain().getResourceSet().getAllContents();
		Collection<PictogramElement> selection = new ArrayList<PictogramElement>();
		ILinkService linkService = Graphiti.getLinkService();
		while (allContents.hasNext()) {
			Notifier notifier = allContents.next();
			EObject bo = linkService.getBusinessObjectForLinkedPictogramElement((PictogramElement) notifier);
			if (notifier instanceof Shape) {
				if (bos.contains(bo)) {
					selection.add((PictogramElement) notifier);
					allContents.prune();
				}
			} else {
				allContents.prune();
			}
		}
		selectPictogramElements(selection.toArray(new PictogramElement[selection.size()]));
	}
}
