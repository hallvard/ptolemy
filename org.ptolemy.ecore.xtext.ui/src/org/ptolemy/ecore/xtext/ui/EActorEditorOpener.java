package org.ptolemy.ecore.xtext.ui;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.ptolemy.graphiti.editor.ActorDiagramEditor;

public class EActorEditorOpener extends LanguageSpecificURIEditorOpener {

	@Override
	protected void selectAndReveal(IEditorPart openEditor, URI uri, EReference crossReference, int indexInList, boolean select) {
		ActorDiagramEditor actorEditor = (ActorDiagramEditor) openEditor.getAdapter(ActorDiagramEditor.class);
		if (actorEditor != null) {
			ResourceSet resourceSet = actorEditor.getEditingDomain().getResourceSet();
			EObject eObject = resourceSet.getEObject(uri, true);
			if (eObject != null) {
				actorEditor.selectBusinessObjects(Collections.singletonList(eObject));
			}
		}
	}
}
