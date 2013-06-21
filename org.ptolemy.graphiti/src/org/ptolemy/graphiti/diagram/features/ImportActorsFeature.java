package org.ptolemy.graphiti.diagram.features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.xactor.ActorModel;
import org.ptolemy.ecore.xactor.ImportDirective;
import org.ptolemy.ecore.xactor.XactorFactory;
import org.ptolemy.graphiti.editor.ActorDiagramEditor;

public class ImportActorsFeature extends AbstractCustomFeature {

	public ImportActorsFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		if (context instanceof ImportActorsFeatureContext && ((ImportActorsFeatureContext) context).getUris().length == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		if (! (context instanceof ImportActorsFeatureContext)) {
			return;
		}
		ImportActorsFeatureContext importActorsFeatureContext = (ImportActorsFeatureContext) context;
		Object model = getBusinessObjectForPictogramElement(importActorsFeatureContext.getDiagram());
		if (! (model instanceof ActorModel)) {
			return;
		}
		ActorModel actorModel = (ActorModel) model;

		ResourceSet resourceSet = new ResourceSetImpl();
		List<EntityContainer<?>> entityContainers = new ArrayList<EntityContainer<?>>();
		URI[] uris = importActorsFeatureContext.getUris();
		for (int i = 0; i < uris.length; i++) {
			URI uri = uris[i];
			if (uri.isPlatformResource()) {
				Resource resource = resourceSet.getResource(uri, true);
				entityContainers.addAll(getEntityContainers(resource));
			}
		}
		for (EntityContainer<?> entityContainer : entityContainers) {
			addImportDirective(actorModel.getImports(), entityContainer.getFullName() + ".*");
		}
		((DiagramBehavior) getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior()).refreshPalette();
	}

	protected void addImportDirective(Collection<ImportDirective> importDirectives, String importPath) {
		// avoid adding a duplicate
		for (ImportDirective importDirective : importDirectives) {
			if (importPath.equals(importDirective.getImportedNamespace())) {
				return;
			}
		}
		ImportDirective importDirective = XactorFactory.eINSTANCE.createImportDirective();
		importDirective.setImportedNamespace(importPath);
		importDirectives.add(importDirective);
	}

	private List<EntityContainer<?>> getEntityContainers(Resource resource) {
		List<EntityContainer<?>> entityContainers = new ArrayList<EntityContainer<?>>();
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof CompositeEntity<?>) {
				allContents.prune();
			} else if (next instanceof EntityContainer) {
				EntityContainer<?> entityContainer = (EntityContainer<?>) next;
				if (entityContainer.getEntities().size() > 0) {
					entityContainers.add(entityContainer);
				}
			} else if (next instanceof IEntity<?>) {
				allContents.prune();
			}
		}
		return entityContainers;
	}
}
