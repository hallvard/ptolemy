package org.ptolemy.graphiti.generic.diagram.features;

import java.net.URL;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.generic.diagram.features.util.GenericShapeRendererFactory;

import com.google.inject.Inject;

public class AddImageFeature extends AbstractAddFeature {
 
	@Inject
    public AddImageFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canAdd(IAddContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		return targetContainer instanceof ContainerShape && context.getNewObject() instanceof URL && isSupportedUrl((URL) context.getNewObject());
	}
	
	private static String[] supportedExtensions = {"gif", "jpeg", "jpg", "png"};

	public static boolean isSupportedUrl(URL url) {
		for (int i = 0; i < supportedExtensions.length; i++) {
			if (url.getPath().endsWith(supportedExtensions[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {

    	Shape shape = Graphiti.getPeCreateService().createShape(context.getTargetContainer(), true);
        URL url = (URL) context.getNewObject();
        PlatformGraphicsAlgorithm platformGa = Graphiti.getGaCreateService().createPlatformGraphicsAlgorithm(shape, GenericShapeRendererFactory.createImageIdForURL(url));
		Graphiti.getGaService().setLocation(platformGa, context.getX(), context.getY());

		// link to itself, to indicate it's not a model object
		link(shape, platformGa);

        layoutPictogramElement(shape);
        
        return shape;
    }
}
