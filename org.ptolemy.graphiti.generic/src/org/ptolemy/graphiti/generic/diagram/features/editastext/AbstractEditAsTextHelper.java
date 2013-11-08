package org.ptolemy.graphiti.generic.diagram.features.editastext;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public abstract class AbstractEditAsTextHelper implements IEditAsTextHelper, IEditedResourceProvider {

	protected Context context;
	
	@Inject
	public AbstractEditAsTextHelper(Context context) {
		this.context = context;
	}
	
	public void editAsText(EObject editableObject, EStructuralFeature[] editableFeatures, Composite comp, int x, int y) {
		createPopupEditor(editableObject, editableFeatures, comp, x, y);
	}

	protected XtextResource createXtextResource(EObject semanticElement) {
		IResourceFactory resourceFactory = context.getDslInjector().getInstance(IResourceFactory.class);
		// Create virtual resource
		Resource originalResource = semanticElement.eResource();
		URI originalUri = originalResource.getURI();
		URI tempUri =  originalUri.trimFileExtension().appendFileExtension("temp." + originalUri.fileExtension());
		
		XtextResource tempXtextResource = (XtextResource) resourceFactory.createResource(tempUri);
		getXtextResourceSet(originalResource).getResources().add(tempXtextResource);
		return tempXtextResource;
	}

	protected ResourceSet getXtextResourceSet(Resource originalResource) {
		return originalResource.getResourceSet();
	}

	protected EmbeddedEditor editor;
	protected EmbeddedEditorModelAccess partialEditor = null; 
    protected XtextResource xtextResource = null;
    protected EObject editableObject = null;
    protected EStructuralFeature[] editableFeatures;
    
    @Override
    public XtextResource createResource() {
    	return xtextResource;
    }

    protected String createXtextEditor() {
		xtextResource = createXtextResource(editableObject);
		String[] initialText = getInitialText(editableObject, editableFeatures);
		if (xtextResource.isLoaded()) {
			xtextResource.unload();
		}
		EmbeddedEditorFactory embeddedEditorFactory = context.getDslInjector().getInstance(EmbeddedEditorFactory.class);
		editor = embeddedEditorFactory.newEditor(this).showErrorAndWarningAnnotations().withParent(editorComposite);
		String invisiblePrefix = "", invisibleSuffix = "", readonlyPrefix = "", readonlySuffix = "";
		String editableContent = initialText[initialText.length / 2];
		if (initialText.length >= 3) {
			invisiblePrefix = initialText[0];
			invisibleSuffix = initialText[initialText.length - 1];
		}
		if (initialText.length >= 5) {
			readonlyPrefix = initialText[1];
			readonlySuffix = initialText[initialText.length - 2];
		}
		readonlyPrefix = withNewlines(readonlyPrefix, false, true);
		readonlySuffix = withNewlines(readonlySuffix, true, false);
		editableContent = withoutNewlines(editableContent, true, true);
		partialEditor = editor.createPartialEditor(invisiblePrefix, readonlyPrefix + editableContent + readonlySuffix, invisibleSuffix, true);
		configureEditor();
		addKeyListeners(editor.getViewer().getTextWidget());

		if (readonlyPrefix.length() > 0 || readonlySuffix.length() > 0) {
			// TODO
//			((SelectionLimitingXtextSourceViewer) editor.getViewer()).setReadOnlyRegion(readonlyPrefix.length(), -readonlySuffix.length());
		}
		return editableContent;
	}

	protected String withNewlines(String s, boolean prefix, boolean suffix) {
		if (s.length() > 0) {
			if (prefix && (! s.startsWith("\n"))) {
				s = "\n" + s;
			}
			if (suffix && (! s.endsWith("\n"))) {
				s = s + "\n";
			}
		}
		return s;
	}

	protected String withoutNewlines(String s, boolean prefix, boolean suffix) {
		int start = 0, end = s.length();
		if (prefix) {
			while (start < end) {
				if (s.charAt(start) != '\n') {
					break;
				}
				start++;
			}
		}
		if (prefix) {
			while (end - 1 > start) {
				if (s.charAt(end - 1) != '\n') {
					break;
				}
				end--;
			}
		}
		return s.substring(start, end);
	}

	protected abstract String[] getInitialText(EObject editableObject, EStructuralFeature[] editableFeatures);

	protected void configureEditor() {
	}

	protected boolean isCommitKeyEvent(KeyEvent e) {
		return (e.stateMask & SWT.CTRL) != 0 && ((e.keyCode == SWT.KEYPAD_CR) || (e.keyCode == SWT.CR));
	}
	protected boolean isEscapeKeyEvent(KeyEvent e) {
		return (e.keyCode == SWT.ESC);
	}
	
	private void addKeyListeners(Control control) {
		if (control instanceof StyledText) {
			((StyledText) control).addVerifyKeyListener(new VerifyKeyListener() {
				public void verifyKey(VerifyEvent e) {
					if (isCommitKeyEvent(e)) {
						e.doit = false;
					}
				}
			});
		}
		control.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (isCommitKeyEvent(e)) {
					closeEditor(true);
				} else if (isEscapeKeyEvent(e)) {
					closeEditor(false);
				}
			}
		});
	}
	
	private Composite editorComposite = null;
	
	private int MINIMUM_WIDTH = 200, MINIMUN_HEIGHT = 150;

	protected void createPopupEditor(final EObject editableObject, EStructuralFeature[] editableFeatures, final Composite comp, int x, int y) {
		editorComposite = new Decorations(comp, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		editorComposite.setLayout(new FillLayout(SWT.VERTICAL));
		final Label label = new Label(editorComposite, SWT.NONE);
		label.setText("Initializing...");
		label.setData(Boolean.TRUE);
		Rectangle bounds = new Rectangle(x, y, 0, 0);
//		Control control = comp;
//		while (control != null && (! (control instanceof Shell))) {
//			bounds.translate(control.getBounds().x, control.getBounds().y);
//			System.out.println(x + ", " + y + ": " + bounds);
//			control = control.getParent();
//		}
		editorComposite.setBounds(bounds.x, bounds.y, MINIMUM_WIDTH, MINIMUN_HEIGHT);
		editorComposite.setVisible(true);
		
		this.editableObject = editableObject;
		this.editableFeatures = editableFeatures;

		editorComposite.getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					addXtextEditor();
				} catch (RuntimeException e) {
					closeEditor(false);
					MessageBox dialog = new MessageBox(comp.getShell(), SWT.ICON_ERROR | SWT.OK);
					dialog.setText("Exception when opening editor");
					dialog.setMessage(e.getMessage());
					dialog.open();
					throw e;
				}
			}
		});
	}

	protected void addXtextEditor() {
		Control[] children = editorComposite.getChildren();
		for (int i = 0; i < children.length; i++) {
			if (Boolean.TRUE.equals(children[i].getData())) {
				children[i].dispose();
			}
		}
		String initialText = createXtextEditor();
		FontData fontData = editorComposite.getFont().getFontData()[0];
		int fontHeight = fontData.getHeight();
		Dimension size = getSize(initialText, fontHeight, fontHeight);
		int width = Math.max(size.width + 100, MINIMUM_WIDTH);
		int height = Math.max(size.height + 100, MINIMUN_HEIGHT);
		editorComposite.setSize(width + 40, height + 20);
		editor.getViewer().getTextWidget().setFocus();
	}

	public void stopEditing(boolean applyResult) {
		closeEditor(applyResult);
	}
	
	protected void closeEditor(boolean useContent) {
		boolean ok = true;
		if (useContent) {
			System.out.println(editor.getDocument().get());
			Boolean result = editor.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
				@Override
				public Boolean exec(XtextResource state) throws Exception {
					IParseResult parseResult = state.getParseResult();
					if (state.getErrors().isEmpty() && parseResult != null && (! parseResult.hasSyntaxErrors())) {
						try {
							return applyState(state);
						} catch (Exception e) {
							throw e;
						}
					}
					return null;
				}
			});
			ok = Boolean.TRUE.equals(result);
		}
		if (! ok) {
			return;
		}
		if (editorComposite != null) {
			editorComposite.setVisible(false);
			editorComposite.dispose();
			editorComposite = null;
		}
	}

	protected Boolean applyState(final XtextResource xtextResource) {
		EObject eObject = xtextResource.getContents().get(0);
		return context.applyResult(eObject);
	}

	protected EObject getReplacement(EObject editableObject, EObject model) {
		return null;
	}

	private static Dimension getSize(String s, int fontWidth, int fontHeight) {
		int height = fontHeight;
		int maxWidth = 0;
		int currentColumns = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\n') {
				maxWidth = Math.max(maxWidth, currentColumns);
				currentColumns = 0;
				height += fontHeight;
			} else {
				currentColumns += fontWidth;
			}
		}
		return new Dimension(maxWidth, height);
	}
}
