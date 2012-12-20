package org.ptolemy.graphiti.diagram.properties.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

public interface EmbeddedEditorContext extends IEditedResourceProvider {
	public Injector getInjector();
	public DiagramEditor getDiagramEditor();
	public void updateModel(EObject eObject);
}
