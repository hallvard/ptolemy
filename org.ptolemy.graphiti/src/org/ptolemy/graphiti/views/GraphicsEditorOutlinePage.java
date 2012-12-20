package org.ptolemy.graphiti.views;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.graphiti.ui.internal.fixed.FixedScrollableThumbnail;
import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

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
public class GraphicsEditorOutlinePage extends org.eclipse.ui.part.Page implements IContentOutlinePage, IPageChangedListener {

	private IAdaptable diagramEditor;

	private Canvas thumbnailControl;
	private LightweightSystem lightweightSystem;
	private FixedScrollableThumbnail thumbnailViewer;

	public GraphicsEditorOutlinePage(IAdaptable diagramEditor) {
		super();
		this.diagramEditor = diagramEditor;
		if (diagramEditor instanceof IPageChangeProvider) {
			((IPageChangeProvider) diagramEditor).addPageChangedListener(this);
		}
	}

	@Override
	public void createControl(Composite parent) {
		thumbnailControl = new Canvas(parent, SWT.NONE);
		lightweightSystem = new LightweightSystem(thumbnailControl);
		update();
	}

	protected void update() {
		GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor.getAdapter(GraphicalViewer.class);
		if (graphicalViewer != null) {
			ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) graphicalViewer.getRootEditPart();
			thumbnailViewer = new FixedScrollableThumbnail((Viewport) rootEditPart.getFigure());
			thumbnailViewer.setBorder(new MarginBorder(3));
			thumbnailViewer.setSource(rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS));
			lightweightSystem.setContents(thumbnailViewer);
		} else {
			lightweightSystem.setContents(new Figure());
		}
	}

	@Override
	public Control getControl() {
		return thumbnailControl;
	}

	@Override
	public void setFocus() {
		thumbnailControl.setFocus();
	}

	@Override
	public void dispose() {
		if (thumbnailViewer != null) {
			thumbnailViewer.deactivate();
		}
		super.dispose();
	}
	
	@Override
	public void pageChanged(PageChangedEvent event) {
		if (event.getPageChangeProvider() == diagramEditor) {
			update();
		}
	}

	//

	@Override
	public ISelection getSelection() {
		return null;
	}
	@Override
	public void setSelection(ISelection selection) {
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}
	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
	}
}
