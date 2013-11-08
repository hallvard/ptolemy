package org.ptolemy.graphiti.generic.diagram.features.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRendererFactory;
import org.eclipse.graphiti.platform.ga.IRendererContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.ptolemy.graphiti.generic.Activator;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class GenericShapeRendererFactory implements IGraphicsAlgorithmRendererFactory {

	@Inject
	private Logger logger;
	
	@Inject
	private Injector injector;

	private AbstractDiagramTypeProvider diagramTypeProvider;

//	@Inject
//	public GenericShapeRendererFactory(AbstractDiagramTypeProvider diagramTypeProvider) {
//		this.diagramTypeProvider = diagramTypeProvider;
//	}

	protected AbstractDiagramTypeProvider getDiagramTypeProvider() {
		return diagramTypeProvider;
	}
	
	public static boolean isLabelId(String id) {
		return id.startsWith("=");
	}
	public static String createLabelIdForString(String s) {
		return "=" + s;
	}

	public static boolean isImageId(String id) {
		return id.startsWith("@");
	}
	public static String createImageIdForURL(URL url) {
		return createImageIdForURL(url.toString());
	}
	public static String createImageIdForURL(String urlString) {
		return "@" + urlString;
	}
	
	@Override
	public IGraphicsAlgorithmRenderer createGraphicsAlgorithmRenderer(IRendererContext rendererContext) {
		String id = rendererContext.getPlatformGraphicsAlgorithm().getId();
		String[] ids = (id != null && id.trim().length() > 0 ? id.split(" ") : new String[0]);
		List<IFigure> children = new ArrayList<IFigure>(ids.length);
		for (int i = 0; i < ids.length; i++) {
			IFigure figure = null;
			Exception shapeException = null;
			id = ids[i];
			// is this a label with the id as text
			if (isLabelId(id)) {
				String labelText = id.substring(1);
				figure = new Label(labelText);
			}
			// is this a label with the id as icon url
			else if (isImageId(id)) {
				ImageRegistry imageRegistry = Activator.getDefault().getImageRegistry();
				String imageKey = id.substring(1);
				Image image = imageRegistry.get(imageKey);
				try {
					if (image == null) {
						imageRegistry.put(imageKey, ImageDescriptor.createFromURL(new URL(imageKey)));
						image = imageRegistry.get(imageKey);
					}
				} catch (Exception e) {
					shapeException = e;
				}
				if (image != null) {
					figure = new ImageFigure(image);
				} else {
					shapeException = new IllegalArgumentException("No image for key: " + imageKey);
				}
			}
			if (figure == null) {
				try {
					Class<? extends IFigure> c = (Class<? extends IFigure>) Activator.getDefault().getClass().getClassLoader().loadClass(id);
					figure = (IFigure) injector.getInstance(c);
				} catch (Exception e) {
					shapeException = e;
				}
			}
			if (figure == null) {
				Binding<?> binding = null;
				try {
					binding = injector.getBinding(Key.get(IFigure.class, Names.named(id)));
				} catch (Exception e) {
				}
				if (binding != null) {
					figure = (IFigure) binding.getProvider().get();
				}
			}
			if (figure == null) {
				figure = new Label(id);
			}
			if (figure != null) {
				Dimension shapeSize = figure.getPreferredSize();
				figure.setSize(shapeSize);
				children.add(figure);
			}
			if (shapeException != null) {
				logger.warning("Couldn't create custom draw2d Shape for " + id + ": " + shapeException);
			}
		}
//		if (children.size() > 0) {
			return new GenericShapeRenderer(children.toArray(new IFigure[children.size()]));
//		}
//		return null;
	}
}
