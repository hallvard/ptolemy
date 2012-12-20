package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.XactorFactory;

import com.google.inject.Inject;

public class CreateEntityContainerFeature extends CreateNameableFeature {

	@Inject
    public CreateEntityContainerFeature(IFeatureProvider fp) {
    	super(fp, "Folder", "Create Folder");
    }

	@Override
	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return bo instanceof EntityFolder;
	}

	@Override
	protected Nameable create(ContainerShape targetContainer, EObject bo) {
		EntityFolder parent = (EntityFolder) bo;
		EntityFolder folder = XactorFactory.eINSTANCE.createEntityFolder();
		folder.setName("Folder");
		parent.getEntityContainers().add(folder);
        return folder;
	}
}
