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

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.generic.actordiagram.EntityShape;
import org.ptolemy.graphiti.generic.actordiagram.PortAnchor;
import org.ptolemy.graphiti.generic.actordiagram.PortShape;

import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.PortConstraints;
import de.cau.cs.kieler.kiml.options.SizeConstraint;

/**
 * Generic layout manager implementation for Graphiti diagrams.
 * 
 * @author atr
 * @author soh
 * @author msp
 * @author hal
 */
public class ActorDiagramLayoutManager extends GraphitiDiagramLayoutManager {

    /**
     * {@inheritDoc}
     */
    public boolean supports(Object object) {
    	PictogramElement pe = (PictogramElement) getAdapter(object, PictogramElement.class);
    	if (pe == null) {
    		Object editor = getAdapter(object, DiagramEditor.class);
    		if (editor != null) {
    			pe = (PictogramElement) getAdapter(editor, PictogramElement.class);
    		}
    	}
    	if (pe != null) {
    		object = pe;
    	}
//    	EObject bo = (EObject) getAdapter(object, EObject.class);
    	return object instanceof EntityContainerDiagram;
    }

    @Override
    protected boolean isChildNodeElement(PictogramElement parent, PictogramElement child) {
		return (child instanceof EntityShape || child instanceof EntityContainerShape ||
				(parent instanceof EntityContainerDiagram && child instanceof PortShape));
	}

	protected void configureLayout( PictogramElement element, KShapeLayout nodeLayout) {
		nodeLayout.setProperty(LayoutOptions.SIZE_CONSTRAINT, SizeConstraint.MINIMUM_SIZE);
		nodeLayout.setProperty(LayoutOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_POS);
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
