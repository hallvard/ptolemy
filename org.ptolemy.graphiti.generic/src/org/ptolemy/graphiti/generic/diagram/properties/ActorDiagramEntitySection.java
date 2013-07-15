package org.ptolemy.graphiti.generic.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class ActorDiagramEntitySection extends ActorDiagramNameableSection {
 
    @Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
    }
 
    @Override
    public void refresh() {
    	super.refresh();
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            if (eObject  != null) {
            }
        }
    }
}
