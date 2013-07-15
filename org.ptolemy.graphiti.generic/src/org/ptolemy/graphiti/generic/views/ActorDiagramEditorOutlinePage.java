package org.ptolemy.graphiti.generic.views;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.ui.internal.fixed.FixedScrollableThumbnail;
import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.ptolemy.graphiti.generic.editor.ActorDiagramEditor;
import org.ptolemy.graphiti.generic.editor.MultiPageActorDiagramEditor;

import com.google.inject.Inject;

/**
 * An outline page for the graphical modeling editor. It displays the contents
 * of the editor either as a hierarchical Outline or as a graphical Thumbnail.
 * There are buttons to switch between those displays. Subclasses should
 * overwrite this outline page (and dependent classes), to change the
 * default-behaviour.
 */

/*
 * Shamelessly ripped from, based on forum pointer
 * http://git.eclipse.org/c/gmp/org.eclipse.gmp.graphiti.git/plain/examples/org.eclipse.graphiti.examples.common/src/org/eclipse/graphiti/examples/common/outline/GraphicsEditorOutlinePage.java
 */

@SuppressWarnings("restriction")
public class ActorDiagramEditorOutlinePage extends GraphicsEditorOutlinePage {

//	private TreeViewer modelTreeViewer;
	private TreeViewer diagramTreeViewer;

	@Inject
	public ActorDiagramEditorOutlinePage(MultiPageActorDiagramEditor diagramEditor) {
		super((IAdaptable) diagramEditor);
	}

	@Override
	public void dispose() {
//		if (modelTreeViewer != null) {
//			if (modelTreeViewer.getContentProvider() != null) {
//				modelTreeViewer.getContentProvider().dispose();
//			}
//			modelTreeViewer = null;
//		}
		if (diagramTreeViewer != null) {
			if (diagramTreeViewer.getContentProvider() != null) {
				diagramTreeViewer.getContentProvider().dispose();
			}
			diagramTreeViewer = null;
		}
		super.dispose();
	}

//	@Inject
//	private ActorViewModelContentProvider actorViewModelContentProvider;

	@Inject
	private ActorDiagramLabelProvider actorDiagramLabelProvider;
	
	@Inject
	private ActorDiagramContentProvider actorDiagramContentProvider;

	private TabFolder tabFolder;
	
	@Override
	public void createControl(Composite parent) {
		tabFolder = new TabFolder(parent, SWT.NONE);
		super.createControl(tabFolder);
		
		TabItem diagram = new TabItem(tabFolder, SWT.NONE);
		diagram.setText("Diagram");
		diagram.setControl(super.getControl());

//		TabItem modelTree = new TabItem(tabFolder, SWT.NONE);
//		modelTree.setText("Model");
//		modelTreeViewer = new TreeViewer(tabFolder);
//		modelTreeViewer.setContentProvider(actorViewModelContentProvider);
//		modelTree.setControl(modelTreeViewer.getControl());

		TabItem diagramTree = new TabItem(tabFolder, SWT.NONE);
		diagramTree.setText("Tree");
		diagramTreeViewer = new TreeViewer(tabFolder);
		diagramTreeViewer.setContentProvider(actorDiagramContentProvider);
		diagramTreeViewer.setLabelProvider(actorDiagramLabelProvider);
		diagramTree.setControl(diagramTreeViewer.getControl());
	}

	@Override
	public Control getControl() {
		return tabFolder;
	}

	@Inject
	private ILinkService linkService;
	
	protected void update() {
		super.update();
		ActorDiagramEditor actorDiagramEditor = (ActorDiagramEditor) diagramEditor.getAdapter(ActorDiagramEditor.class);
		Diagram diagram = (actorDiagramEditor != null ? actorDiagramEditor.getDiagramTypeProvider().getDiagram() : null);
//		if (modelTreeViewer != null) {
//			modelTreeViewer.setInput(diagram != null ? linkService.getBusinessObjectForLinkedPictogramElement(diagram) : null);
//		}
		if (diagramTreeViewer != null) {
			diagramTreeViewer.setInput(diagram);
		}
	}
}
