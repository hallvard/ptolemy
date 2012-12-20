package org.ptolemy.graphiti.diagram.properties.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.ptolemy.ecore.actor.JvmTypedObj;

public class JvmTypedObjSectionSupport extends AbstractEmbeddedEditorSupport implements EmbeddedEditorSupport {
 
	protected Composite editorComposite;

	private EmbeddedEditorFactory embeddedEditorFactory;
	
    private EmbeddedEditor editor;
    private EmbeddedEditorModelAccess partialEditor = null; 

	public JvmTypedObjSectionSupport(EmbeddedEditorContext embeddedEditorContext) {
		super(embeddedEditorContext);
	}

	public Control createControl(Composite composite) {
        editorComposite = new Composite(composite, SWT.NONE); // factory.createFlatFormComposite(composite);
        editorComposite.setLayout(new GridLayout(1, false));
 
        embeddedEditorFactory = embeddedEditorContext.getInjector().getInstance(EmbeddedEditorFactory.class);
		editor = embeddedEditorFactory.newEditor(embeddedEditorContext).showErrorAndWarningAnnotations().withParent(editorComposite);
		return editorComposite;
    }

	public void applyChanges() {
		editor.getDocument().readOnly(new IUnitOfWork<Void, XtextResource>() {
			@Override
			public java.lang.Void exec(XtextResource state) throws Exception {
				EList<EObject> contents = state.getContents();
				if (contents.size() > 0 && contents.get(0) instanceof JvmTypeReference) {
					embeddedEditorContext.updateModel(contents.get(0));
				}
				return null;
			}
		});
	}

	public void refresh(EObject bo) {
    	if (bo instanceof JvmTypedObj) {
        	JvmTypedObj typed = (JvmTypedObj) bo;
        	JvmTypeReference type = typed.getInferredType();
        	if (partialEditor == null) {
    			partialEditor = editor.createPartialEditor();
    		}
        	partialEditor.updateModel("actor " + typed.getContainer().getName() + ">|>", (type != null ? type.getIdentifier() : ""), typed.getName());
        }
    }
}
