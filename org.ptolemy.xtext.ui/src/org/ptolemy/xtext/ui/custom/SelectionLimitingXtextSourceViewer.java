package org.ptolemy.xtext.ui.custom;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.LineBackgroundEvent;
import org.eclipse.swt.custom.LineBackgroundListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

public class SelectionLimitingXtextSourceViewer extends XtextSourceViewer
	implements CaretListener, LineBackgroundListener {
	
	private int minimumOffset = 0, maximumOffset = 0;

	public SelectionLimitingXtextSourceViewer(Composite parent,
			IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
		getTextWidget().addCaretListener(this);
		getTextWidget().addLineBackgroundListener(this);
	}

	@Override
    public void lineGetBackground(LineBackgroundEvent event) {
        int offset = event.lineOffset;
        if (! isValidOffset(offset)) {
            event.lineBackground = getControl().getDisplay().getSystemColor(SWT.COLOR_GRAY);
        }
    }

    private boolean movingCaret = false;
    
    @Override
	public void caretMoved(CaretEvent event) {
//		System.out.println("Caret: " + event.caretOffset);
		if (movingCaret) {
			return;
		}
		int offset = getValidOffset(event.caretOffset);
		if (offset != event.caretOffset) {
			System.out.println("Caret: " + event.caretOffset + " != " + offset);
			movingCaret = true;
			getTextWidget().setCaretOffset(offset);
			movingCaret = false;
		}
	}

	public void setReadOnlyRegion(int minimumSelectionOffset, int maximumSelectionOffset) {
		this.minimumOffset = minimumSelectionOffset;
		this.maximumOffset = maximumSelectionOffset;
	}

	@Override
	protected void validateSelectionRange(int[] selectionRange) {
//		System.out.println("Selection: " + selectionRange[0] + ", " + selectionRange[1]);
		int start = selectionRange[0], end = start + selectionRange[1];
		int validStart = getValidOffset(start), validEnd = getValidOffset(end);
		selectionRange[0] = validStart;
		selectionRange[1] = validEnd - validStart;
//		System.out.println("Selection = " + selectionRange[0] + ", " + selectionRange[1]);
		super.validateSelectionRange(selectionRange);
	}

	protected boolean isValidOffset(int offset) {
		return offset == getValidOffset(offset);
	}

	protected int getValidOffset(int offset) {
		IRegion visibleRegion = getVisibleRegion();
		int minOffset = minimumOffset;
		int maxOffset = maximumOffset;
		if (maxOffset <= 0) {
			maxOffset += visibleRegion.getLength();
		}
		int validOffset = getValidOffset(offset, minOffset, maxOffset);
		return validOffset;
	}

	protected int getValidOffset(int offset, int minOffset, int maxOffset) {
//		System.out.println("Validating: " + minOffset + " < " + offset + " < " + maxOffset);
		if (offset < minOffset) {
			return minOffset;
		} else if (offset > maxOffset) {
			return maxOffset;
		}
		return offset;
	}
	
	public static class Factory implements XtextSourceViewer.Factory {
		
		@Override
		public XtextSourceViewer createSourceViewer(Composite parent,
				IVerticalRuler ruler, IOverviewRuler overviewRuler,
				boolean showsAnnotationOverview, int styles) {
			return new SelectionLimitingXtextSourceViewer(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
		}
	}
}
