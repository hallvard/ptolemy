package org.ptolemy.graphiti.diagram.properties.xtext;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public abstract class AbstractEmbeddedEditorSupport implements EmbeddedEditorSupport {

	protected EmbeddedEditorContext embeddedEditorContext;

	public AbstractEmbeddedEditorSupport(EmbeddedEditorContext embeddedEditorContext) {
		this.embeddedEditorContext = embeddedEditorContext;
	}

	protected EObject originalBo;
	
	protected Composite xtextEditorComposite;
	protected XtextEditor xtextEditor;
	protected XtextResource xtextResource;

	protected int editorOffset, initialEditorSize, initialDocumentSize;

	@Override
	public Control createControl(Composite parent) {
		this.xtextResource = embeddedEditorContext.createResource();
		this.xtextEditorComposite = parent;
		return null;
	}
	
	protected void dispose() {
		if (xtextResource != null) {
			EList<Resource> resources = xtextResource.getResourceSet().getResources();
			if (resources.indexOf(xtextResource) == 0) {
				resources.clear();
			}
		}
		if (xtextEditor != null) {
			xtextEditor.dispose();
			xtextEditor = null;
		}
		if (xtextEditorComposite instanceof Decorations) {
			xtextEditorComposite.setVisible(false);
			xtextEditorComposite.dispose();
			xtextEditorComposite = null;
		}
	}

	protected Resource getOriginalResource() {
		DiagramEditor diagramEditor = embeddedEditorContext.getDiagramEditor();
		for (Resource resource : diagramEditor.getResourceSet().getResources()) {
			if (resource instanceof XtextResource) {
				return resource;
			}
		}
		return null;
	}
 
	protected URI createXtextResourceUri() {
		URI originalUri = getOriginalResource().getURI();
		URI tempUri =  originalUri.trimFileExtension().appendFileExtension("temp." + originalUri.fileExtension());
		return tempUri;
	}

	protected void configureXtextEditor() {
		addKeyVerifyListener();
	}
	
	protected void configureXtextEditor(EObject originalBo) {
		try {
			setEditorRegion();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		if (xtextEditorComposite instanceof Decorations) {
			setEditorBounds();
		}
	}

	private void addKeyVerifyListener() {
		ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewer.getTextWidget();
		xtextTextWidget.addVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent e) {
				if ((e.stateMask & SWT.CTRL) != 0 && ((e.keyCode == SWT.KEYPAD_CR) || (e.keyCode == SWT.CR))) {
					e.doit = false;
				}
			}
		});
		xtextTextWidget.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					applyChanges();
				}
				if (keyCode == SWT.ESC) {
					applyChanges();
				}
			}
		});
	}

	private void setEditorRegion() throws BadLocationException {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		boolean success = xtextEditor.getDocument().modify(new IUnitOfWork<Boolean, XtextResource>() {

			public Boolean exec(XtextResource state) throws Exception {
				EObject semanticElementInDocument = state.getEObject(originalBo.eResource().getURIFragment(originalBo));
				if (semanticElementInDocument == null) {
					return false;
				}
				ICompositeNode xtextNode = NodeModelUtils.getNode(semanticElementInDocument);
				if (xtextNode == null) {
					return false;
				}
				// getOffset() and getLength() are trimming whitespaces
				editorOffset = xtextNode.getOffset();
				initialEditorSize = xtextNode.getLength();
				initialDocumentSize = xtextDocument.getLength();

				// insert a newline directly before and after the node
				xtextDocument.replace(editorOffset, 0, "\n");
				xtextDocument.replace(editorOffset + 1 + initialEditorSize, 0, "\n");
				return true;
			}

		});
		if (success) {
			xtextEditor.showHighlightRangeOnly(true);
			xtextEditor.setHighlightRange(editorOffset + 1, initialEditorSize, true);
			xtextEditor.setFocus();
		}
	}

	private static int MIN_EDITOR_WIDTH = 100, MIN_EDITOR_HEIGHT = 20;

	private void setEditorBounds() {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		// mind the added newlines
		String editString = "";
		try {
			editString = xtextDocument.get(editorOffset + 1, initialEditorSize);
		} catch (BadLocationException exc) {
		}
		int numLines = getNumLines(editString);
		int numColumns = getMaxColumns(editString);

		Control control = xtextEditorComposite;
		Rectangle bounds = new Rectangle(200, 300, 0, 0);
		while (control != null && (! (control instanceof Shell))) {
			bounds.translate(control.getBounds().x, control.getBounds().y);
			control = control.getParent();
		}
		Font font = control.getFont();
		FontData fontData = font.getFontData()[0];
		int fontHeightInPixel = fontData.getHeight();

		int width = Math.max(fontHeightInPixel * (numColumns + 3), MIN_EDITOR_WIDTH);
		int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
		xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width, height);
		xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width + 250, height + 50);
	}

	protected boolean hasDocumentErrors() {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return ! state.getErrors().isEmpty() || parseResult == null || parseResult.hasSyntaxErrors();
			}
		}));
	}

	public static int getNumLines(String s) {
		int numLines = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\n') {
				numLines++;
			}
		}
		return numLines;
	}

	public static int getMaxColumns(String s) {
		int maxColumns = 0;
		int currentColumns = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\n') {
				maxColumns = Math.max(maxColumns, currentColumns);
				currentColumns = 0;
			} else {
				currentColumns++;
			}
		}
		return Math.max(currentColumns, maxColumns);
	}
}
