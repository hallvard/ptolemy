package org.ptolemy.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;

public class ActorDiagramNameableSection extends GFPropertySection implements ITabbedPropertyConstants {
 
	protected Composite composite;
    protected Text nameText, displayNameText;
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        composite = factory.createFlatFormComposite(parent);
        FormData data;
 
        nameText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        nameText.setLayoutData(data);
 
        Label nameLabel = factory.createLabel(composite, "Name:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        nameLabel.setLayoutData(data);
        
        displayNameText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(nameText, VSPACE, SWT.BOTTOM);
        displayNameText.setLayoutData(data);
        
        Label displayNameLabel = factory.createLabel(composite, "Display name:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameLabel, VSPACE, SWT.BOTTOM);
        displayNameLabel.setLayoutData(data);
        
        nameText.addModifyListener(modifyListener);
        displayNameText.addModifyListener(modifyListener);
    }
    
    protected ModifyListener modifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent e) {
    		PictogramElement pe = getSelectedPictogramElement();
    		if (pe != null) {
    			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    			ActorDiagramNameableSection.this.modifyText(e, pe, bo);
    		}
		}
	};
   
    protected void modifyText(ModifyEvent e, PictogramElement pe, EObject bo) {
    	if (e.widget == nameText && bo instanceof Nameable) {
			String value = nameText.getText();
			setFeature(bo, KernelPackage.eINSTANCE.getNamedObj_Name(), "".equals(value) ? null : value);
    	} else if (e.widget == displayNameText && bo instanceof Nameable) {
	    	String value = displayNameText.getText();
	    	setFeature(bo, KernelPackage.eINSTANCE.getNamedObj_DisplayName(), "".equals(value) ? null : value);
    	}
    }

    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        	refresh(pe, bo);
        }
    }

    @Override
    public PictogramElement getSelectedPictogramElement() {
    	return super.getSelectedPictogramElement();
    }

	protected void refresh(PictogramElement pe, EObject bo) {
		if (bo instanceof Nameable) {
			Nameable named = (Nameable) bo;
			String name = named.getName();
			nameText.setText(name == null ? "" : name);
			String displayName = named.getDisplayName();
			displayNameText.setText(displayName == null ? "" : displayName);
		}
	}
    
	public void setFeature(final EObject eObject, final EStructuralFeature feature, final Object newValue) {
		execute(new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
			@Override
			public void execute(IContext context) {
				eObject.eSet(feature, newValue);
			}
			@Override
			public boolean canExecute(IContext context) {
				Object oldValue = eObject.eGet(feature);
				return oldValue != null ? (! oldValue.equals(newValue)) : newValue != null;
			}
		}, new CustomContext());
	}
}
