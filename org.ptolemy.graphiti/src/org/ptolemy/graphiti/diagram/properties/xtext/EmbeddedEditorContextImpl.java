package org.ptolemy.graphiti.diagram.properties.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.ptolemy.graphiti.diagram.features.editastext.EditedResourceProvider;

import com.google.inject.Injector;

public abstract class EmbeddedEditorContextImpl extends EditedResourceProvider implements EmbeddedEditorContext {

	private Injector injector;
	private DiagramEditor diagramEditor;
	
	public EmbeddedEditorContextImpl(DiagramEditor diagramEditor, Injector injector) {
		super(getModelResource(diagramEditor), injector.getInstance(IResourceFactory.class), getModelResource(diagramEditor).getResourceSet());
		this.injector = injector;
	}

	@Override
	public Injector getInjector() {
		return injector;
	}

	@Override
	public DiagramEditor getDiagramEditor() {
		return diagramEditor;
	}
	
	public static Resource getModelResource(DiagramEditor diagramEditor) {
		for (Resource resource : diagramEditor.getResourceSet().getResources()) {
			if (resource instanceof XtextResource) {
				return resource;
			}
		}
		return null;
	}
}