package org.ptolemy.graphiti.generic.diagram.features;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.editor.CreateActorDiagramWizard;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class UpdateEntityFolderFeature extends UpdateNameableFeature {

	@Inject
	private ActorContainerViewModel actorContainerViewModel;
	
	@Inject
	public UpdateEntityFolderFeature(IFeatureProvider fp) {
		super(fp);
	}

    protected Diagram findDiagram(Resource diagramResource, EObject bo) {
    	for (EObject diagram : diagramResource.getContents()) {
    		if (diagram instanceof Diagram && linkService.getBusinessObjectForLinkedPictogramElement((Diagram) diagram) == bo) {
    			return (Diagram) diagram;
    		}
    	}
    	return null;
    }

	@Override
	protected boolean canUpdate(PictogramElement pe) {
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		return actorContainerViewModel.isEntity(bo, ActorViewModel.EntityKind.ENTITY_NAMESPACE);
	}

	@Inject @Named("diagramType") private String DIAGRAM_TYPE;
	
	@Override
	protected boolean update(PictogramElement pe, boolean reallyUpdate) {
		boolean changed = super.update(pe, reallyUpdate);
		if (changed && (! reallyUpdate)) {
			return true;
		}
		Resource diagramResource = pe.eResource();
		EObject entityFolder = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		Collection<EObject> entityContainers = getEntityContainers(entityFolder, actorContainerViewModel);
		for (EObject entityContainer : entityContainers) {
			if (findDiagram(diagramResource, entityContainer) == null) {
				if (! reallyUpdate) {
					return true;
				}
				Diagram diagram = CreateActorDiagramWizard.createDiagram(nameViewModel.getName(entityContainer), DIAGRAM_TYPE);
				link(diagram, entityContainer);
				diagramResource.getContents().add(diagram);
			}
		}
    	ContainerShape containerShape = (ContainerShape) pe;
    	changed = removeNeeded(containerShape, reallyUpdate) | changed;
    	if (changed && (! reallyUpdate)) {
    		return true;
    	}
    	changed = addNeeded(containerShape, actorContainerViewModel.getEntities(entityFolder), reallyUpdate) | changed;
		return changed;
	}

	//

	public static Collection<EObject> getEntityContainers(Resource resource, EntityViewModel entityViewModel) {
		return getEntityContainers(resource.getAllContents(), entityViewModel);
	}
	public static Collection<EObject> getEntityContainers(EObject eObject, EntityViewModel entityViewModel) {
		return getEntityContainers(eObject.eAllContents(), entityViewModel);
	}

	public static Collection<EObject> getEntityContainers(TreeIterator<EObject> allContents, EntityViewModel entityViewModel) {
		Collection<EObject> entityContainers = new ArrayList<EObject>();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (entityViewModel.isEntity(eObject, EntityViewModel.EntityKind.ENTITY_NAMESPACE)) {
				entityContainers.add((EObject) eObject);
			} else {
				allContents.prune();
			}
		}
		return entityContainers;
	}
}
