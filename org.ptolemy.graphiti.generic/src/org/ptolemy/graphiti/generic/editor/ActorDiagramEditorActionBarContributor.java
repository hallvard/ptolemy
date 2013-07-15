package org.ptolemy.graphiti.generic.editor;

import org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.ui.IEditorPart;

public class ActorDiagramEditorActionBarContributor extends DiagramEditorActionBarContributor implements IPageChangedListener {

	private MultiPageActorDiagramEditor multiPageEditorPart = null;
	
    public void setActiveEditor(IEditorPart part) {
    	if (multiPageEditorPart != null) {
    		multiPageEditorPart.removePageChangedListener(this);
    		multiPageEditorPart = null;
    	}
        if (part instanceof MultiPageActorDiagramEditor) {
        	multiPageEditorPart = (MultiPageActorDiagramEditor) part;
            if (multiPageEditorPart != null) {
            	multiPageEditorPart.addPageChangedListener(this);
            }
            setActivePage(multiPageEditorPart.getActiveEditor());
        } else {
        	super.setActiveEditor(part);
        }
    }

    public void setActivePage(IEditorPart activeEditor) {
    	if (activeEditor != null) {
    		super.setActiveEditor(activeEditor);
    	}
    }

	@Override
	public void pageChanged(PageChangedEvent event) {
		if (event.getPageChangeProvider() == multiPageEditorPart) {
			setActivePage(multiPageEditorPart.getActiveEditor());
		}
	}
}
