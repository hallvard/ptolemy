package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.ptolemy.graphiti.generic.diagram.features.util.PERef;

import com.google.inject.Inject;

public abstract class AbstractLayoutEntityFeature extends AbstractLayoutFeature {

	public final static IColorConstant ENTITY_TEXT_FOREGROUND = IColorConstant.BLACK;
	public final static IColorConstant ENTITY_FOREGROUND = new ColorConstant(98, 131, 167);
	public final static IColorConstant ENTITY_BACKGROUND = new ColorConstant(187, 218, 247);

	public final static int ENTITY_NAME_HEIGHT = 14;

	public final static PERef<EObject, ContainerShape> ENTITY_SHAPE = new PERef<EObject, ContainerShape>(EObject.class, ContainerShape.class);
	public final static PERef<EObject, GraphicsAlgorithm> ENTITY_GA = new PERef<EObject, GraphicsAlgorithm>(EObject.class, GraphicsAlgorithm.class, 2);

	protected IEntityLayout entityLayout;

	protected void setEntityLayout(IEntityLayout entityLayout) {
		this.entityLayout = entityLayout;
	}

	@Inject
	public AbstractLayoutEntityFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean layout(ILayoutContext context) {
		ContainerShape entityShape = (ContainerShape) context.getPictogramElement();
		boolean changed = false;

		GraphicsAlgorithm containerRectangle = entityShape.getGraphicsAlgorithm();
		Dimension containerSize = new Dimension(containerRectangle.getWidth(), containerRectangle.getHeight());

		Insets insets = entityLayout.getInsets();

		changed = layoutPorts(entityShape, containerSize) | changed;
		
		GraphicsAlgorithm entityGa = ENTITY_GA.get(entityShape);
		int width = containerSize.width - insets.left - insets.right;
		int height = containerSize.height - insets.top - insets.right;
		if (entityGa != null) {
			entityLayout.layoutGraphicsAlgorithm(entityGa, insets.left, insets.top, width, height);
		}
		return changed;
	}

	protected boolean layoutPorts(ContainerShape entityShape, Dimension containerSize) {
		return false;
	}
}
