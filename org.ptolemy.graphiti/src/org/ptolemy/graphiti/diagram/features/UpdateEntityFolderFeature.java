package org.ptolemy.graphiti.diagram.features;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.ILinkService;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.graphiti.editor.CreateActorDiagramWizard;

import com.google.inject.Inject;

public class UpdateEntityFolderFeature extends UpdateNameableFeature {

	@Inject
	public UpdateEntityFolderFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Inject
	private ILinkService linkService;

    protected Diagram findDiagram(Resource diagramResource, EObject bo) {
    	for (EObject diagram : diagramResource.getContents()) {
    		if (diagram instanceof Diagram && linkService.getBusinessObjectForLinkedPictogramElement((Diagram) diagram) == bo) {
    			return (Diagram) diagram;
    		}
    	}
    	return null;
    }

	@Override
	protected boolean canUpdate(PictogramElement pe, EObject bo) {
		return (pe instanceof Diagram && bo instanceof EntityFolder);
	}

	@Override
	protected boolean update(PictogramElement pe, EObject bo, boolean reallyUpdate) {
		boolean changed = super.update(pe, bo, reallyUpdate);
		if (changed && (! reallyUpdate)) {
			return true;
		}
		Resource diagramResource = pe.eResource();
		EntityFolder entityFolder = (EntityFolder) bo;
		Collection<EntityContainer<?>> entityContainers = getEntityContainers(bo);
		for (EntityContainer<?> entityContainer : entityContainers) {
			if (findDiagram(diagramResource, entityContainer) == null) {
				if (! reallyUpdate) {
					return true;
				}
				Diagram diagram = CreateActorDiagramWizard.createDiagram(entityContainer.getName(entityFolder));
				link(diagram, entityContainer);
				diagramResource.getContents().add(diagram);
			}
		}
    	ContainerShape containerShape = (ContainerShape) pe;
    	changed = removeNeeded(containerShape, reallyUpdate) | changed;
    	if (changed && (! reallyUpdate)) {
    		return true;
    	}
    	changed = addNeeded(containerShape, entityFolder.getEntities(), reallyUpdate) | changed;
    	if (changed && (! reallyUpdate)) {
    		return true;
    	}
    	changed = addNeeded(containerShape, entityFolder.getEntityContainers(), reallyUpdate) | changed;
		return changed;
	}

	//

	public static Collection<EntityContainer<?>> getEntityContainers(Resource resource) {
		return getEntityContainers(resource.getAllContents());
	}
	public static Collection<EntityContainer<?>> getEntityContainers(EObject eObject) {
		return getEntityContainers(eObject.eAllContents());
	}

	public static Collection<EntityContainer<?>> getEntityContainers(TreeIterator<EObject> allContents) {
		Collection<EntityContainer<?>> entityContainers = new ArrayList<EntityContainer<?>>();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (AddEntityContainerFeature.isJustEntityContainer(eObject)) {
				entityContainers.add((EntityContainer<?>) eObject);
			} else {
				allContents.prune();
			}
		}
		return entityContainers;
	}
}
