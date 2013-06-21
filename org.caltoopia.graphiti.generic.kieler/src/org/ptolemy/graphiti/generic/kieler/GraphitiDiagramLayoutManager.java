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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.parts.IPictogramElementEditPart;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.config.VolatileLayoutConfig;
import de.cau.cs.kieler.kiml.graphiti.GefDiagramLayoutManager;
import de.cau.cs.kieler.kiml.graphiti.GraphitiLayoutCommand;
import de.cau.cs.kieler.kiml.graphiti.GraphitiLayoutConfig;
import de.cau.cs.kieler.kiml.graphiti.KimlGraphitiUtil;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.impl.KShapeLayoutImpl;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutMapping;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * Generic layout manager implementation for Graphiti diagrams.
 * 
 * @author atr
 * @author soh
 * @author msp
 */
@SuppressWarnings("restriction")
public class GraphitiDiagramLayoutManager extends GefDiagramLayoutManager<PictogramElement> {

    /**
     * {@inheritDoc}
     */
    public boolean supports(final Object object) {
        return object instanceof DiagramEditor || object instanceof IPictogramElementEditPart || object instanceof PictogramElement;
    }
    
    /** the cached layout configuration for Graphiti. */
    private GraphitiLayoutConfig layoutConfig = new GraphitiLayoutConfig();

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object getAdapter(final Object object, final Class adapterType) {
        if (adapterType.isAssignableFrom(GraphitiLayoutConfig.class)) {
            return layoutConfig;
        } else if (adapterType.isAssignableFrom(IPictogramElementEditPart.class)) {
            if (object instanceof IPictogramElementEditPart) {
                return object;
            } else if (object instanceof DiagramEditor) {
                return ((DiagramEditor) object).getGraphicalViewer().getContents();
            }
        } else if (adapterType.isAssignableFrom(EObject.class)) {
            if (object instanceof IPictogramElementEditPart) {
                PictogramElement pe = ((IPictogramElementEditPart) object).getPictogramElement();
                if (pe.getLink() != null) {
                    List<EObject> businessObjects = pe.getLink().getBusinessObjects();
                    if (!businessObjects.isEmpty()) {
                        return businessObjects.get(0);
                    }
                }
            } else if (object instanceof PictogramElement) {
                PictogramElement pe = (PictogramElement) object;
                if (pe.getLink() != null) {
                    List<EObject> businessObjects = pe.getLink().getBusinessObjects();
                    if (!businessObjects.isEmpty()) {
                        return businessObjects.get(0);
                    }
                }
            }
        } else if (adapterType.isAssignableFrom(PictogramElement.class)) {
            if (object instanceof PictogramElement) {
                return object;
            } else if (object instanceof IPictogramElementEditPart) {
                return ((IPictogramElementEditPart) object).getPictogramElement();
            } else if (object instanceof DiagramEditor) {
                EditPart contents = ((DiagramEditor) object).getGraphicalViewer().getContents();
                if (contents instanceof IPictogramElementEditPart) {
                    return ((IPictogramElementEditPart) contents).getPictogramElement();
                }
            }
        } else if (adapterType.isAssignableFrom(TransactionalEditingDomain.class)) {
            if (object instanceof DiagramEditor) {
                return ((DiagramEditor) object).getEditingDomain();
            } else if (object instanceof IPictogramElementEditPart) {
                return ((IPictogramElementEditPart) object).getConfigurationProvider()
                        .getDiagramBehavior().getEditingDomain();
            }
        }
        if (object instanceof IAdaptable) {
            return ((IAdaptable) object).getAdapter(adapterType);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Class<?>[] getAdapterList() {
        return new Class<?>[] { PictogramElement.class };
    }

    /**
     * {@inheritDoc}
     */
    public LayoutMapping<PictogramElement> buildLayoutGraph(final IWorkbenchPart workbenchPart,
            final Object diagramPart) {
        LayoutMapping<PictogramElement> mapping = new LayoutMapping<PictogramElement>(this);
        mapping.setProperty(KimlGraphitiUtil.CONNECTIONS, new LinkedList<Connection>());
        mapping.setProperty(KimlGraphitiUtil.STATIC_CONFIG, new VolatileLayoutConfig());

        if (workbenchPart instanceof DiagramEditor) {
            mapping.setProperty(KimlGraphitiUtil.DIAGRAM_EDITOR, (DiagramEditor) workbenchPart);
        } else {
        	DiagramEditor diagramEditor =  (DiagramEditor) getAdapter(workbenchPart, DiagramEditor.class);
        	if (diagramEditor != null) {
                mapping.setProperty(KimlGraphitiUtil.DIAGRAM_EDITOR, diagramEditor);
        	}
        }
        EditPart layoutRootPart = null;
        if (diagramPart instanceof IPictogramElementEditPart) {
            layoutRootPart = (EditPart) diagramPart;
        } else if (mapping.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR) != null) {
            layoutRootPart = mapping.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR)
                    .getGraphicalViewer().getContents();
        }
        if (!(layoutRootPart instanceof IPictogramElementEditPart)) {
            throw new UnsupportedOperationException(
                    "Not supported by this layout manager: Workbench part "
                    + workbenchPart + ", Edit part " + diagramPart);
        }
        PictogramElement element = ((IPictogramElementEditPart) layoutRootPart)
                .getPictogramElement();
        mapping.setParentElement(element);

        if (element instanceof Diagram) {
            KNode topNode = KimlUtil.createInitializedNode();
            KShapeLayout shapeLayout = topNode.getData(KShapeLayout.class);
            GraphicsAlgorithm ga = element.getGraphicsAlgorithm();
            shapeLayout.setPos(ga.getX(), ga.getY());
            shapeLayout.setSize(ga.getWidth(), ga.getHeight());
            mapping.getGraphMap().put(topNode, element);

            buildLayoutGraphRecursively(mapping, (Diagram) element, topNode);
            
            mapping.setLayoutGraph(topNode);
        } else if (element instanceof Shape) {
            mapping.setLayoutGraph(createNode(mapping, null, (Shape) element));
        }

        for (Connection entry : mapping.getProperty(KimlGraphitiUtil.CONNECTIONS)) {
            KimlGraphitiUtil.createEdge(mapping, entry);
        }
        
        // create layout configurators for Graphiti
        mapping.getLayoutConfigs().add(mapping.getProperty(KimlGraphitiUtil.STATIC_CONFIG));
        mapping.getLayoutConfigs().add(layoutConfig);

        return mapping;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void transferLayout(final LayoutMapping<PictogramElement> mapping) {
        DiagramEditor diagramEditor = mapping.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR);
        GraphitiLayoutCommand command = new GraphitiLayoutCommand(diagramEditor.getEditingDomain(),
                diagramEditor.getDiagramTypeProvider().getFeatureProvider());
        for (Entry<KGraphElement, PictogramElement> entry : mapping.getGraphMap().entrySet()) {
            command.add(entry.getKey(), entry.getValue());
        }
        mapping.setProperty(KimlGraphitiUtil.LAYOUT_COMMAND, command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void applyLayout(final LayoutMapping<PictogramElement> mapping) {
        TransactionalEditingDomain editingDomain = mapping.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR)
                .getEditingDomain();
        editingDomain.getCommandStack().execute(mapping.getProperty(KimlGraphitiUtil.LAYOUT_COMMAND));
    }

    /** the fixed minimal size of shapes. */
    protected static final float MIN_SIZE = 15.0f;
    
    /**
     * Recursively builds a layout graph by analyzing the children of the given current pictogram
     * Element.
     *
     * @param mapping the mapping of pictogram elements to graph elements
     * @param parentElement the currently analyzed element
     * @param parentNode the corresponding KNode
     */
    protected void buildLayoutGraphRecursively(final LayoutMapping<PictogramElement> mapping,
            final ContainerShape parentElement, final KNode parentNode) {
        Iterator<? extends PictogramElement> childNodeShapes = getChildNodeShapes(parentElement);
		while (childNodeShapes.hasNext()) {
			PictogramElement childElement = childNodeShapes.next();
            if (isChildNodeElement(parentElement, childElement)) {
            	createNode(mapping, parentNode, childElement);
            }
        }
    }

    /**
     * Create a node for the layout graph.
     * 
     * @param mapping the mapping of pictogram elements to graph elements
     * @param parentNode the parent node
     * @param element the shape for a new node
     * @return a new layout node
     */
    protected KNode createNode(final LayoutMapping<PictogramElement> mapping,
            final KNode parentNode, final PictogramElement element) {
        KNode childNode = KimlUtil.createInitializedNode();
        childNode.setParent(parentNode);
        VolatileLayoutConfig staticConfig = mapping.getProperty(KimlGraphitiUtil.STATIC_CONFIG);

        // set the node's layout
        KShapeLayout nodeLayout = childNode.getData(KShapeLayout.class);
        GraphicsAlgorithm nodeGa = element.getGraphicsAlgorithm();
        KInsets nodeInsets = KimlGraphitiUtil.calcInsets(nodeGa);
        nodeLayout.setProperty(GraphitiLayoutCommand.INVIS_INSETS, nodeInsets);
        staticConfig.setValue(GraphitiLayoutCommand.INVIS_INSETS, childNode, LayoutContext.GRAPH_ELEM,
                nodeInsets);
        KInsets parentInsets = parentNode == null ? null : parentNode.getData(KShapeLayout.class)
                .getProperty(GraphitiLayoutCommand.INVIS_INSETS);
        if (parentInsets == null) {
            nodeLayout.setPos(nodeGa.getX() + nodeInsets.getLeft(),
                    nodeGa.getY() + nodeInsets.getTop());
        } else {
            nodeLayout.setPos(nodeGa.getX() + nodeInsets.getLeft() - parentInsets.getLeft(),
                    nodeGa.getY() + nodeInsets.getTop() - parentInsets.getTop());
        }
        nodeLayout.setSize(nodeGa.getWidth() - nodeInsets.getLeft() - nodeInsets.getRight(),
                nodeGa.getHeight() - nodeInsets.getTop() - nodeInsets.getBottom());
        // the modification flag must initially be false
        ((KShapeLayoutImpl) nodeLayout).resetModificationFlag();
        configureLayout(element, nodeLayout);

        // FIXME find a way to specify the minimal size dynamically
        staticConfig.setValue(LayoutOptions.MIN_WIDTH, childNode, LayoutContext.GRAPH_ELEM, MIN_SIZE);
        staticConfig.setValue(LayoutOptions.MIN_HEIGHT, childNode, LayoutContext.GRAPH_ELEM, MIN_SIZE);

        mapping.getGraphMap().put(childNode, element);

	    if (element instanceof ContainerShape) {
	        createLabels(element, childNode, nodeInsets);
	        // process the children of the container shape
	        buildLayoutGraphRecursively(mapping, (ContainerShape) element, childNode);
	    }

        Iterator<? extends PictogramElement> portElements = getPortElements(element);
        while (portElements.hasNext()) {
        	PictogramElement portElement = portElements.next();
            if (isPortElement(element, portElement)) {
                createPort(mapping, childNode, portElement);
                // gather all connections in the diagram
                mapping.getProperty(KimlGraphitiUtil.CONNECTIONS).addAll(getConnections(portElement));
            }
        }
        mapping.getProperty(KimlGraphitiUtil.CONNECTIONS).addAll(getConnections(element));
        return childNode;
    }

	protected void configureLayout( PictogramElement element, KShapeLayout nodeLayout) {
	}

	protected void createLabels(final PictogramElement element, KNode childNode, KInsets nodeInsets) {
		Iterator<? extends PictogramElement> labelElements = getLabelElements(element);
		while (labelElements.hasNext()) {
			PictogramElement labelElement = labelElements.next();
		    if (isLabelElement(element, labelElement)) {
				GraphicsAlgorithm childGa = labelElement.getGraphicsAlgorithm();
		        if (childGa instanceof AbstractText) {
		            KimlGraphitiUtil.createLabel(childNode, (AbstractText) childGa, -nodeInsets.getLeft(), -nodeInsets.getTop());
		        }
		    }
		}
	}

    //
    
    protected void createPort(LayoutMapping<PictogramElement> mapping, KNode childNode, PictogramElement portElement) {
    	if (portElement instanceof BoxRelativeAnchor) {
    		createPort(mapping, childNode, (BoxRelativeAnchor) portElement);
    	} else if (portElement instanceof FixPointAnchor) {
    		createPort(mapping, childNode, (FixPointAnchor) portElement);
    	} else if (portElement instanceof Anchor) {
    		createPort(mapping, childNode, (Anchor) portElement);
    	}
	}

    /**
     * Create a port for the layout graph using a box-relative anchor. The referenced graphics
     * algorithm of the anchor is assumed to be the same as the one returned by
     * {@link #findVisibleGa(GraphicsAlgorithm)}.
     * 
     * @param mapping the mapping of pictogram elements to graph elements
     * @param parentNode the parent node
     * @param bra the anchor
     * @return a new layout port
     */
    protected KPort createPort(final LayoutMapping<PictogramElement> mapping,
            final KNode parentNode, final BoxRelativeAnchor bra) {
    	GraphicsAlgorithm referencedGa = bra.getReferencedGraphicsAlgorithm();
    	if (referencedGa == null) {
    		return null;
    	}
        double xPos = bra.getRelativeWidth() * referencedGa.getWidth();
		double yPos = bra.getRelativeHeight() * referencedGa.getHeight();
		return createPort(mapping, parentNode, bra, xPos, yPos);
    }

    /**
     * Create a port for the layout graph using a fixed-position anchor.
     * 
     * @param mapping the mapping of pictogram elements to graph elements
     * @param parentNode the parent node
     * @param fpa the anchor
     * @return a new layout port
     */
    protected KPort createPort(final LayoutMapping<PictogramElement> mapping,
            final KNode parentNode, final FixPointAnchor fpa) {
        int xPos = fpa.getLocation().getX(), yPos = fpa.getLocation().getY();
		return createPort(mapping, parentNode, fpa, xPos, yPos);
    }

    /**
     * Create a port for the layout graph using a general anchor.
     * 
     * @param mapping the mapping of pictogram elements to graph elements
     * @param parentNode the parent node
     * @param anchor the anchor
     * @return a new layout port
     */
    protected KPort createPort(final LayoutMapping<PictogramElement> mapping,
    		final KNode parentNode, final Anchor anchor) {
    	return createPort(mapping, parentNode, anchor, 0.0, 0.0);
    }
    
    /**
     * Create a port for the layout graph using a pre-computed position.
     * 
     * @param mapping the mapping of pictogram elements to graph elements
     * @param parentNode the parent node
     * @param portElement the anchor
     * @param xPos the x-coordinate connection position of the anchor
     * @param yPos the y-coordinate connection position of the anchor
     * @return a new layout port
     */
    protected KPort createPort(LayoutMapping<PictogramElement> mapping, KNode parentNode, PictogramElement portElement, double xPos, double yPos) {

        KPort port = KimlUtil.createInitializedPort();
        port.setNode(parentNode);
        mapping.getGraphMap().put(port, portElement);

    	final KShapeLayout portLayout = port.getData(KShapeLayout.class);
        GraphicsAlgorithm portGa = portElement.getGraphicsAlgorithm(); 
    	if (portGa != null) {
    		xPos += portGa.getX();
    		yPos += portGa.getY();
    		portLayout.setSize(portGa.getWidth(), portGa.getHeight());
    	}
    	portLayout.setPos((float) xPos, (float) yPos);
    	// the modification flag must initially be false
    	((KShapeLayoutImpl) portLayout).resetModificationFlag();
    	
    	return port;
    }

    // the overridable methods for navigating from nodes to ports to connections
    

    /**
     * Returns the set of child shapes to be considered as nodes
     * @param parentShape the parent shape
     * @return the set of child shapes to be considered as nodes
     */
    protected Iterator<? extends PictogramElement> getChildNodeShapes(ContainerShape parentShape) {
    	return parentShape.getChildren().iterator();
    }

    /**
     * Tells whether a particular child element corresponds to a child node of a parent element
     * @param parent the parent element
     * @param child the child element
     * @return true if child corresponds to a child node, false otherwise
     */
    protected boolean isChildNodeElement(PictogramElement parent, PictogramElement child) {
    	// relevant shapes are those that can be connected
		return (child instanceof Shape && ! ((Shape) child).getAnchors().isEmpty());
	}

    /**
     * Returns the set of child pictograms to be considered as labels
     * @param element the parent element
     * @return the set of child elements to be considered as labels
     */
	protected Iterator<? extends PictogramElement> getLabelElements(PictogramElement element) {
    	return (element instanceof ContainerShape ? ((ContainerShape) element).getChildren() : Collections.<PictogramElement>emptyList()).iterator();
    }

    /**
     * Tells whether a particular child element corresponds to a label of a parent element
     * @param parent the parent element
     * @param child the child element
     * @return true if child corresponds to a label of parent, false otherwise
     */
    protected boolean isLabelElement(PictogramElement parent, PictogramElement child) {
    	GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
        return (childGa instanceof AbstractText);
	}

    /**
     * Returns the set of child pictograms to be considered as ports
     * @param element the parent element
     * @return the set of child elements to be considered as ports
     */
    protected Iterator<? extends PictogramElement> getPortElements(PictogramElement element) {
    	return (element instanceof Shape ? ((Shape) element).getAnchors() : Collections.<PictogramElement>emptyList()).iterator();
    }

    /**
     * Tells whether a particular child element corresponds to a port of a parent element
     * @param parent the parent element
     * @param child the child element
     * @return true if child corresponds to a port, false otherwise
     */
    protected boolean isPortElement(PictogramElement parent, PictogramElement child) {
    	if (! (child instanceof Anchor)) {
    		return false;
    	}
    	Anchor anchor = (Anchor) child;
        return anchor.getGraphicsAlgorithm() != null && (anchor instanceof BoxRelativeAnchor || anchor instanceof FixPointAnchor);
    }
    
    /**
     * Returns the set of connections of a pictogram
     * @param element the parent element
     * @return the set of connections of the parent element
     */
    protected Collection<? extends Connection> getConnections(PictogramElement element) {
    	return (element instanceof Anchor ? ((Anchor) element).getOutgoingConnections() : Collections.<Connection>emptyList());
    }
}
