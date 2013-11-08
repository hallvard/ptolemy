package org.ptolemy.graphiti.generic.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.ptolemy.graphiti.generic.ActorEditModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel.PortKind;

import com.google.inject.Inject;

public class ActorDiagramPortSection extends ActorDiagramNameableSection {
 
    private Button inputButton, outputButton, multiportButton;
    
    @Inject
    private ActorViewModel actorViewModel;
    
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        FormData data;
  
        inputButton = factory.createButton(composite, "Input?", SWT.CHECK);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.top = new FormAttachment(composite, VSPACE*2, SWT.BOTTOM);
        inputButton.setLayoutData(data);

        outputButton = factory.createButton(composite, "Output?", SWT.CHECK);
        data = new FormData();
        data.left = new FormAttachment(inputButton, HSPACE, SWT.RIGHT);
        data.top = new FormAttachment(inputButton, 0, SWT.TOP);
        outputButton.setLayoutData(data);
        
        multiportButton = factory.createButton(composite, "Multiport?", SWT.CHECK);
        data = new FormData();
        data.left = new FormAttachment(outputButton, HSPACE, SWT.RIGHT);
        data.top = new FormAttachment(outputButton, 0, SWT.TOP);
        multiportButton.setLayoutData(data);
        
        inputButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        PictogramElement pe = getSelectedPictogramElement();
		        if (pe != null) {
		            EObject port = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		            if (actorViewModel.isPort(port, null)) {
        				setIoKind(port, inputButton.getSelection(), actorViewModel.isPort(port, PortKind.OUTPUT));
		            }
		        }
			}
		});

        outputButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		PictogramElement pe = getSelectedPictogramElement();
        		if (pe != null) {
		            EObject port = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		            if (actorViewModel.isPort(port, null)) {
        				setIoKind(port, actorViewModel.isPort(port, PortKind.INPUT), outputButton.getSelection());
        			}
        		}
        	}
        });
        
        multiportButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		PictogramElement pe = getSelectedPictogramElement();
        		if (pe != null) {
		            EObject port = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		            if (actorViewModel.isPort(port, null)) {
        				setMultiport(port, multiportButton.getSelection());
        			}
        		}
        	}
        });
    }
 
    void setIoKind(EObject ioPort, boolean input, boolean output) {
    	PortKind newPortKind = PortKind.IO;
    	if (input && output) {
    		newPortKind = PortKind.IO;
    	} else if (input) {
    		newPortKind = PortKind.INPUT;
    	} else if (output) {
    		newPortKind = PortKind.OUTPUT;
    	}
    	setIoKind(ioPort, newPortKind);
    }

	void setIoKind(final EObject ioPort, final PortKind newPortKind) {
		// TODO
//    	setProperty(ioPort, ActorPackage.eINSTANCE.getIOPort_IoKind(), newPortKind);
	}

	void setMultiport(final EObject ioPort, final boolean newMultiport) {
		// TODO
//		setProperty(ioPort, ActorPackage.eINSTANCE.getAbstractIOPort_Multiport(), newMultiport);
	}

    @Override
    public void refresh() {
    	super.refresh();
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            EObject port = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            boolean canEdit = actorViewModel.isPort(port, null) && actorViewModel instanceof ActorEditModel;
            inputButton.setEnabled(canEdit);
            outputButton.setEnabled(canEdit);
            multiportButton.setEnabled(canEdit);

            inputButton.setSelection(canEdit && actorViewModel.isPort(port, PortKind.INPUT));
            outputButton.setSelection(canEdit && actorViewModel.isPort(port, PortKind.OUTPUT));
            multiportButton.setSelection(canEdit);
        }
    }
}
