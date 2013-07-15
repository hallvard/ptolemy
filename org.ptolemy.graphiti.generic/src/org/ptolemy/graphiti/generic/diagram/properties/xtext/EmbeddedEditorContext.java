package org.ptolemy.graphiti.generic.diagram.properties.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

public interface EmbeddedEditorContext extends IEditedResourceProvider {
	public Injector getInjector();
	public DiagramBehavior getDiagramBehavior();
	public void updateModel(EObject eObject);
}
