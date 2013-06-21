package org.ptolemy.graphiti.diagram.properties.xtext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.caltoopia.graphiti.generic.diagram.properties.xtext.AbstractEmbeddedEditorSupport;
import org.caltoopia.graphiti.generic.diagram.properties.xtext.EmbeddedEditorContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;

public class ObeosEmbeddedEditorSupport extends AbstractEmbeddedEditorSupport {

	public ObeosEmbeddedEditorSupport(EmbeddedEditorContext embeddedEditorContext) {
		super(embeddedEditorContext);
	}

	@Override
	public Control createControl(Composite parent) {
		this.xtextEditorComposite = parent;
		Resource originalResource = getOriginalResource();
		// Clone root EObject
		EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
		try{
			this.xtextResource = createVirtualXtextResource(semanticElement, originalResource.getResourceSet());
			createXtextEditor(xtextEditorComposite, new ResourceWorkingCopyFileEditorInput(xtextResource), false);
		} catch (Exception e) {
			System.err.println(e);
		}
		return xtextEditorComposite.getChildren()[0];
	}
	
	@Override
	public void refresh(EObject bo) {
		configureXtextEditor(bo);
	}

	public void applyChanges() {
		if (xtextEditor != null) {
			try {
				if (! hasDocumentErrors()) {
					final IXtextDocument xtextDocument = xtextEditor.getDocument();
					// subtract 2 for the artificial newlines
					int documentGrowth = xtextDocument.getLength() - initialDocumentSize - 2;
					String newText = xtextDocument.get(editorOffset + 1, initialEditorSize + documentGrowth);
					updateXtextResource(editorOffset, initialEditorSize, newText);
				}
			} catch (Exception exc) {
			}
			EList<Resource> resources = xtextResource.getResourceSet().getResources();
			if (resources.indexOf(xtextResource) == 0) {
				resources.clear();
			}
			xtextEditor.dispose();
			if (xtextEditorComposite instanceof Decorations) {
				xtextEditorComposite.setVisible(false);
				xtextEditorComposite.dispose();
			}
			xtextEditor = null;
		}
	}

	private XtextResource createVirtualXtextResource(EObject semanticElement, ResourceSet resourceSet) throws IOException {
		IResourceFactory resourceFactory = embeddedEditorContext.getInjector().getInstance(IResourceFactory.class);
		if (resourceSet == null) {
			XtextResourceSet xtextResourceSet = embeddedEditorContext.getInjector().getInstance(XtextResourceSet.class);
			xtextResourceSet.setClasspathURIContext(getClass());
			resourceSet = xtextResourceSet;
		}
		URI uri = createXtextResourceUri();
		// Create virtual resource
		XtextResource xtextVirtualResource = (XtextResource) resourceFactory.createResource(uri);
		resourceSet.getResources().add(xtextVirtualResource);

		// Populate virtual resource with the given semantic element to edit
		xtextVirtualResource.getContents().add(semanticElement);
		//save to create file
		xtextVirtualResource.save(Collections.emptyMap());

		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		xtextVirtualResource.save(out, Collections.emptyMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));

		return xtextVirtualResource;
	}

	protected void updateXtextResource(final int offset, final int replacedTextLength, final String newText) throws IOException, BadLocationException {
		ICompositeNode oldRootNode = xtextResource.getParseResult().getRootNode();
		// final IParseResult parseResult =
		// xtextResource.getParser().reparse(oldRootNode, offset,
		// Reparse the entire document
		String originalRegion = NodeModelUtils.getTokenText(oldRootNode);
		int changeOffset = offset - oldRootNode.getTotalOffset();
		StringBuffer reparseRegion = new StringBuffer();
		reparseRegion.append(originalRegion.substring(0, changeOffset));
		reparseRegion.append(newText);
		if (changeOffset + replacedTextLength < originalRegion.length())
			reparseRegion.append(originalRegion.substring(changeOffset + replacedTextLength));
		String allText = reparseRegion.toString();
		xtextResource.reparse(allText);
		final IParseResult parseResult = xtextResource.getParseResult();
		if (! parseResult.hasSyntaxErrors()) {
			embeddedEditorContext.updateModel(parseResult.getRootASTElement());
		}
	}

	/**
	 * Create the XText editor
	 * @param editorInput the editor input
	 * @throws Exception
	 */
	protected void createXtextEditor(Composite composite, IEditorInput editorInput, boolean isPopup) throws Exception {
		if (isPopup) {
			xtextEditorComposite = new Decorations(xtextEditorComposite, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		}
		xtextEditorComposite.setLayout(new FillLayout());
		IEditorSite editorSite = embeddedEditorContext.getDiagramEditor().getEditorSite();
		this.xtextEditor = embeddedEditorContext.getInjector().getInstance(XtextEditor.class);
		// remove dirty state editor callback
		xtextEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(Guice.createInjector(new Module() {
			public void configure(Binder binder) {
			}
		})));
		xtextEditor.init(editorSite, editorInput);
		xtextEditor.createPartControl(xtextEditorComposite);
		configureXtextEditor();
	}
}
