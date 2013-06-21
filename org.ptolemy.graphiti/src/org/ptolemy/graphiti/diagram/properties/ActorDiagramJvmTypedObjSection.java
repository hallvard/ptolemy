package org.ptolemy.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.resource.XtextResource;
import org.ptolemy.graphiti.diagram.properties.xtext.EmbeddedEditorSupport;
import org.ptolemy.xtext.ui.internal.XActorActivator;

import com.google.inject.Injector;

public class ActorDiagramJvmTypedObjSection extends ActorDiagramNameableSection {
 
	protected Control editorComposite;

	private Injector injector = XActorActivator.getInstance().getInjector(XActorActivator.ORG_PTOLEMY_XTEXT_XACTOR);
	private EmbeddedEditorSupport embeddedEditorSupport;
	private DiagramBehavior diagramBehavior;

    @Override
    public void createControls(Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
//        IEditorPart activeEditor = tabbedPropertySheetPage.getSite().getPage().getActiveEditor();
//        if (activeEditor instanceof DiagramEditor) {
//        	diagramEditor = (DiagramEditor) activeEditor;
//        }
//		embeddedEditorSupport = new
////        		JvmTypedObjSectionSupport
//        		ObeosEmbeddedEditorSupport
//        		(new EmbeddedEditorContextImpl(diagramEditor, injector) {
//    				@Override
//    				public void updateModel(EObject eObject) {
//    					if (eObject instanceof JvmTypeReference) {
//    						EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
//    						setFeature(bo, ActorPackage.eINSTANCE.getJvmTypedObj_Type(), EcoreUtil.copy(eObject));
//    					}
//    				}
//        		});
//
//        FormData data = new FormData();
//        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
//        data.right = new FormAttachment(100, 0);
//        data.height = 100;
//        data.top = new FormAttachment(displayNameText, VSPACE * 2, SWT.BOTTOM);
//        editorComposite = embeddedEditorSupport.createControl(composite);
//        editorComposite.setLayoutData(data);
//        
//		Button button = new Button(composite, SWT.PUSH);
//		button.setText("Set type");
//		data = new FormData();
//        data.left = new FormAttachment(0, 0);
//        data.right = new FormAttachment(editorComposite, -HSPACE);
//        data.top = new FormAttachment(editorComposite, 0, SWT.CENTER);
//        button.setLayoutData(data);
//        
//		button.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				embeddedEditorSupport.applyChanges();
//			}
//		});
    }

	protected Resource getOriginalResource() {
		for (Resource resource : diagramBehavior.getResourceSet().getResources()) {
			if (resource instanceof XtextResource) {
				return resource;
			}
		}
		return null;
	}

    @Override
	protected void refresh(PictogramElement pe, EObject bo) {
    	super.refresh(pe, bo);
//    	embeddedEditorSupport.refresh(bo);
    }
}
