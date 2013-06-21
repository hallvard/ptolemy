package org.ptolemy.graphiti.generic.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;
 
public class ActorDiagramEntityFilter extends AbstractPropertySectionFilter {
 
	@Inject
	private EntityViewModel entityViewModel;

    @Override
    protected boolean accept(PictogramElement pe) {
        EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        if (entityViewModel.isEntity(eObject, null)) {
            return true;
        }
        return false;
    }
}
