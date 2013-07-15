package org.ptolemy.graphiti.generic.diagram.properties.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.ptolemy.graphiti.generic.diagram.features.editastext.EditedResourceProvider;

import com.google.inject.Injector;

public abstract class EmbeddedEditorContextImpl extends EditedResourceProvider implements EmbeddedEditorContext {

	private Injector injector;
	private DiagramBehavior diagramBehavior;
	
	public EmbeddedEditorContextImpl(DiagramBehavior diagramBehavior, Injector injector) {
		super(getModelResource(diagramBehavior), injector.getInstance(IResourceFactory.class), getModelResource(diagramBehavior).getResourceSet());
		this.injector = injector;
	}

	@Override
	public Injector getInjector() {
		return injector;
	}

	@Override
	public DiagramBehavior getDiagramBehavior() {
		return diagramBehavior;
	}
	
	public static Resource getModelResource(DiagramBehavior diagramBehavior) {
		for (Resource resource : diagramBehavior.getResourceSet().getResources()) {
			if (resource instanceof XtextResource) {
				return resource;
			}
		}
		return null;
	}
}