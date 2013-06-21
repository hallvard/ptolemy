package org.ptolemy.graphiti.generic.diagram.features;

import java.util.ArrayList;
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
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class ImportActorsFeature extends AbstractCustomFeature {

	@Inject
	private ILinkService linkService;
	
	@Inject
	private ActorContainerViewModel actorContainerViewModel;

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
		EObject model = linkService.getBusinessObjectForLinkedPictogramElement(importActorsFeatureContext.getDiagram());
		if (actorContainerViewModel.getNamespace(model) == null) {
			return;
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		List<EObject> entityContainers = new ArrayList<EObject>();
		URI[] uris = importActorsFeatureContext.getUris();
		for (int i = 0; i < uris.length; i++) {
			URI uri = uris[i];
			if (uri.isPlatformResource()) {
				Resource resource = resourceSet.getResource(uri, true);
				entityContainers.addAll(getEntityContainers(resource));
			}
		}
		for (EObject entityContainer : entityContainers) {
//			addImportDirective(actorModel.getImports(), actorContainerViewModel.getQualifiedEntityName(entityContainer) + ".*");
		}
		((DiagramBehavior) getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior()).refreshPalette();
	}

//	protected void addImportDirective(Collection<ImportDirective> importDirectives, String importPath) {
//		// avoid adding a duplicate
//		for (ImportDirective importDirective : importDirectives) {
//			if (importPath.equals(importDirective.getImportedNamespace())) {
//				return;
//			}
//		}
//		ImportDirective importDirective = XactorFactory.eINSTANCE.createImportDirective();
//		importDirective.setImportedNamespace(importPath);
//		importDirectives.add(importDirective);
//	}

	private List<EObject> getEntityContainers(Resource resource) {
		List<EObject> entityContainers = new ArrayList<EObject>();
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (actorContainerViewModel.isEntity(next, EntityViewModel.EntityKind.COMPOSITE_ACTOR)) {
				allContents.prune();
			} else if (actorContainerViewModel.isEntity(next, EntityViewModel.EntityKind.ACTOR_CONTAINER)) {
				if (actorContainerViewModel.getEntities(next).iterator().hasNext()) {
					entityContainers.add(next);
				}
			} else if (actorContainerViewModel.isEntity(next, EntityViewModel.EntityKind.ACTOR)) {
				allContents.prune();
			}
		}
		return entityContainers;
	}
}
