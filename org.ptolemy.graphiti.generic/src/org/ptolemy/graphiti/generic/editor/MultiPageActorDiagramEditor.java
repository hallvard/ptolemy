package org.ptolemy.graphiti.generic.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.ptolemy.graphiti.generic.views.ActorDiagramEditorOutlinePage;
import org.ptolemy.graphiti.generic.views.GraphicsEditorOutlinePage;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MultiPageActorDiagramEditor extends MultiPageEditorPart implements IContributedContentsView {

	public MultiPageActorDiagramEditor() {
		super();
	}

	private Map<ActorDiagramEditor, Diagram> actorDiagramEditors = new HashMap<ActorDiagramEditor, Diagram>();
	
	private ActorDiagramEditor getActorDiagramEditor(int pos) {
		return (ActorDiagramEditor) getEditor(pos);
	}

	public ActorDiagramEditor getActorDiagramEditor(Diagram diagram) {
		for (ActorDiagramEditor diagramEditor : actorDiagramEditors.keySet()) {
			if (diagramEditor.getDiagramTypeProvider().getDiagram() == diagram) {
				return diagramEditor;
			}
		}
		return null;
	}

	// used before editor is initialized
	public Diagram getActorEditorDiagram(ActorDiagramEditor editor) {
		return actorDiagramEditors.get(editor);
	}

	private int getPageIndex(ActorDiagramEditor editor) {
		int count = 0;
		for (int i = 0; i < getPageCount(); i++) {
			if (editor == getEditor(i)) {
				return count;
			}
			count++;
		}
		return -1;
	}

	@Override
	public IWorkbenchPart getContributingPart() {
		return getActiveEditor();
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapterType) {
		IEditorPart activeEditor = getActiveEditor();
		if (DiagramEditor.class.equals(adapterType) && activeEditor instanceof DiagramEditor) {
			return activeEditor;
		} else if (IContentOutlinePage.class.equals(adapterType)) {
			return getOutlinePage();
		}
		Object result = super.getAdapter(adapterType);
		if (result == null && getMainEditor() != null) {
			result = getMainEditor().getAdapter(adapterType);
		}
		return result;
	}
	
	public ActorDiagramEditor getMainEditor() {
		return (getPageCount() > 0 ? getActorDiagramEditor(0) : null);
	}

	@Override
	public IEditorPart getActiveEditor() {
		return super.getActiveEditor();
	}
	
	@Override
	protected void createPages() {
		try {
			addActorDiagramEditor(null);
			setPartName(getEditorInput().getName());
			diagramEditorUpdater = new DiagramEditorUpdater();
			diagramEditorUpdater.run(true);
			getDiagramResource().eAdapters().add(diagramEditorUpdater);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DiagramEditorUpdater diagramEditorUpdater;
	
	private class DiagramEditorUpdater extends AdapterImpl implements Runnable {
		public void run(boolean async) {
			if (async && (! getContainer().isDisposed())) {
				getContainer().getDisplay().asyncExec(this);
			} else {
				run();
			}
		}
		@Override
		public void run() {
			try {
				updateEditorPages();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getFeatureID(Resource.class) == Resource.RESOURCE__CONTENTS) {
				run(true);
			}
		}
	}

	public Resource getDiagramResource() {
		ActorDiagramEditor mainEditor = getMainEditor();
		return (mainEditor != null ? mainEditor.getEditingDomain().getResourceSet().getResources().get(0) : null);
	}

	protected void updateEditorPages() {
		Resource diagramResource = getDiagramResource();
		if (diagramResource == null) {
			return;
		}
		EList<EObject> diagrams = diagramResource.getContents();
		// remove extra editors
		Collection<ActorDiagramEditor> diagramEditors = new ArrayList<ActorDiagramEditor>(actorDiagramEditors.keySet());
		for (ActorDiagramEditor diagramEditor : diagramEditors) {
			if (! diagrams.contains(diagramEditor.getDiagramTypeProvider().getDiagram())) {
				int pos = getPageIndex(diagramEditor);
				if (pos >= 0) {
					removePage(pos);
				}
				actorDiagramEditors.remove(diagramEditor);
			}
		}
		// add new editors
		for (EObject eObject : diagrams) {
			if (eObject instanceof Diagram) {
				Diagram diagram = (Diagram) eObject;
				ActorDiagramEditor actorDiagramEditor = getActorDiagramEditor(diagram);
				if (actorDiagramEditor == null) {
					try {
						addActorDiagramEditor(diagram);
					} catch (PartInitException e) {
					}
				}
			}
		}
	}
	
	@Inject
	private Provider<ActorDiagramEditor> actorDiagramEditorProvider;
	
	protected ActorDiagramEditor addActorDiagramEditor(Diagram diagram) throws PartInitException {
		ActorDiagramEditor editor = actorDiagramEditorProvider.get();
		actorDiagramEditors.put(editor, diagram);
		editor.setMultiPageActorDiagramEditor(this);
		addPage(editor, getEditorInput());
		setPageText(getPageIndex(editor), editor.getPartName());
		return editor;
	}

	public void addPage(int pageIndex, IEditorPart editor, IEditorInput input) throws PartInitException {
		super.addPage(pageIndex,editor,input);
	}
	
	@Override
	public void removePage(int pageIndex) {
		super.removePage(pageIndex);
	}

	@Override
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		getMainEditor().doSave(monitor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		getMainEditor().doSaveAs();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return getMainEditor() != null && getMainEditor().isSaveAsAllowed();
	}

	@Override
	public void dispose() {
		if (outlinePage != null) {
			outlinePage.dispose();
			outlinePage = null;
		}
		actorDiagramEditors.clear();
		super.dispose();
	}

	//

	@Inject
	private ActorDiagramEditorOutlinePage outlinePage;
	
	private GraphicsEditorOutlinePage getOutlinePage() {
		return outlinePage;
	}
}
