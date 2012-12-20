package org.ptolemy.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
import org.ptolemy.ecore.kernel.IEntity;
 
public class ActorDiagramEntityFilter extends AbstractPropertySectionFilter {
 
    @Override
    protected boolean accept(PictogramElement pe) {
        EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        if (eObject instanceof IEntity<?>) {
            return true;
        }
        return false;
    }
}
