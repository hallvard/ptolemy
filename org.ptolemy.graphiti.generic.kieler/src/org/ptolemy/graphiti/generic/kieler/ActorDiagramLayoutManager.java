/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package org.ptolemy.graphiti.generic.kieler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.IWorkbenchPart;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortAnchor;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.config.VolatileLayoutConfig;
import de.cau.cs.kieler.kiml.graphiti.KimlGraphitiUtil;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.PortConstraints;
import de.cau.cs.kieler.kiml.options.SizeConstraint;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutMapping;

/**
 * Generic layout manager implementation for Graphiti diagrams.
 * 
 * @author atr
 * @author soh
 * @author msp
 * @author hal
 */
public class ActorDiagramLayoutManager extends GraphitiDiagramLayoutManager {

	@Override
	public Object getAdapter(Object object, Class adapterType) {
		Object adapter = super.getAdapter(object, adapterType);
		if (adapter == null) {
			Object editor = super.getAdapter(object, DiagramEditor.class);
			if (editor != null) {
				adapter = super.getAdapter(editor, adapterType);
			}
		}
		return adapter;
	}

    public LayoutMapping<PictogramElement> buildLayoutGraph(final IWorkbenchPart workbenchPart, final Object diagramPart) {
    	Object editor = getAdapter(workbenchPart, DiagramEditor.class);
    	return super.buildLayoutGraph(editor instanceof IWorkbenchPart && editor != workbenchPart ? (IWorkbenchPart) editor : workbenchPart, diagramPart);
    }

    public boolean supports(Object object) {
    	PictogramElement pe = (PictogramElement) getAdapter(object, PictogramElement.class);
		return pe instanceof EntityContainerDiagram;
    }

    @Override
    protected boolean isChildNodeElement(PictogramElement parent, PictogramElement child) {
		return (child instanceof EntityShape || child instanceof EntityContainerShape ||
				(parent instanceof EntityContainerDiagram && child instanceof PortShape));
	}

	protected void configureLayout(PictogramElement element, KNode childNode, KShapeLayout nodeLayout, VolatileLayoutConfig staticConfig) {
		super.configureLayout(element, childNode, nodeLayout, staticConfig);
		GraphicsAlgorithm ga = null;
		if (element instanceof Shape) {
			ga = ((Shape) element).getGraphicsAlgorithm();
		} else if (element instanceof GraphicsAlgorithm) {
			ga = (GraphicsAlgorithm) element;
		}
		if (ga != null) {
			ga = findVisible(ga);
			staticConfig.setValue(LayoutOptions.MIN_WIDTH, childNode, LayoutContext.GRAPH_ELEM, (float) ga.getWidth());
			staticConfig.setValue(LayoutOptions.MIN_HEIGHT, childNode, LayoutContext.GRAPH_ELEM, (float) ga.getHeight());
		}
		nodeLayout.setProperty(LayoutOptions.SIZE_CONSTRAINT, SizeConstraint.MINIMUM_SIZE);
		nodeLayout.setProperty(LayoutOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_SIDE);
	}

	private GraphicsAlgorithm findVisible(GraphicsAlgorithm ga) {
		if (ga.getLineVisible()) {
			return ga;
		}
		for (GraphicsAlgorithm child : ga.getGraphicsAlgorithmChildren()) {
			GraphicsAlgorithm visibleChild = findVisible(child);
			if (visibleChild != null) {
				return visibleChild;
			}
		}
		return null;
	}
	
    @Override
    protected Iterator<? extends PictogramElement> getPortElements(PictogramElement element) {
    	Collection<PictogramElement> portElements = new ArrayList<PictogramElement>();
    	if (element instanceof PortShape) {
    		portElements.add(((PortShape) element).getInsideAnchor());
    	} else if (element instanceof ContainerShape) {
    		for (Shape childShape : ((ContainerShape) element).getChildren()) {
    			if (childShape instanceof PortShape) {
					portElements.add(((PortShape) childShape).getOutsideAnchor());
				}
			}
    	}
    	return portElements.iterator();
    }
    
    @Override
    protected boolean isPortElement(PictogramElement parent, PictogramElement child) {
    	return child instanceof PortAnchor;
	}
}
