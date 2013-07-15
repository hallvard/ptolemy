package org.ptolemy.graphiti.generic.diagram.properties;

import javax.sound.sampled.Port;

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

public class ActorDiagramPortSection extends ActorDiagramNameableSection {
 
    private Button inputButton, outputButton, multiportButton;
    
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
		            Port port = (Port) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		            if (port instanceof IOPort) {
		            	IOPort ioPort = (IOPort) port;
        				setIoKind(ioPort, inputButton.getSelection(), ioPort.isOutput());
		            }
		        }
			}
		});

        outputButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		PictogramElement pe = getSelectedPictogramElement();
        		if (pe != null) {
        			Port port = (Port) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        			if (port instanceof IOPort) {
        				IOPort ioPort = (IOPort) port;
        				setIoKind(ioPort, ioPort.isInput(), outputButton.getSelection());
        			}
        		}
        	}
        });
        
        multiportButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		PictogramElement pe = getSelectedPictogramElement();
        		if (pe != null) {
        			Port port = (Port) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        			if (port instanceof IOPort) {
        				IOPort ioPort = (IOPort) port;
        				setMultiport(ioPort, multiportButton.getSelection());
        			}
        		}
        	}
        });
    }
 
    void setIoKind(IOPort ioPort, boolean input, boolean output) {
    	PortKind newPortKind = PortKind.UNSPECIFIED;
    	if (input && output) {
    		newPortKind = PortKind.INPUT_OUTPUT;
    	} else if (input) {
    		newPortKind = PortKind.INPUT;
    	} else if (output) {
    		newPortKind = PortKind.OUTPUT;
    	}
    	setIoKind(ioPort, newPortKind);
    }

	void setIoKind(final IOPort ioPort, final PortKind newPortKind) {
    	setProperty(ioPort, ActorPackage.eINSTANCE.getIOPort_IoKind(), newPortKind);
	}

	void setMultiport(final IOPort ioPort, final boolean newMultiport) {
		setProperty(ioPort, ActorPackage.eINSTANCE.getAbstractIOPort_Multiport(), newMultiport);
	}

    @Override
    public void refresh() {
    	super.refresh();
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Port port = (Port) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            inputButton.setEnabled(port instanceof IOPort);
            outputButton.setEnabled(port instanceof IOPort);
            multiportButton.setEnabled(port instanceof IOPort);

            inputButton.setSelection(port instanceof IOPort && ((IOPort) port).isInput());
            outputButton.setSelection(port instanceof IOPort && ((IOPort) port).isOutput());
            multiportButton.setSelection(port instanceof IOPort && ((IOPort) port).isMultiport());
        }
    }
}
