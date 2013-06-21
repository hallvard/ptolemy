package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.util.IColorConstant;
import org.ptolemy.graphiti.generic.EntityViewModel;

public class Util {

	public static Shape getParentShape(PictogramElement pe) {
		return getParentShape(pe, EObject.class, null, null);
	}

	public static Shape getParentShape(PictogramElement pe, EntityViewModel entityViewModel, EntityViewModel.EntityKind entityKind) {
		return getParentShape(pe, EObject.class, entityViewModel, entityKind);
	}

	private static Shape getParentShape(PictogramElement pe, Class<?> c, EntityViewModel entityViewModel, EntityViewModel.EntityKind entityKind) {
		ILinkService linkService = Graphiti.getLinkService();
		EObject bo = null;
		Shape result = null;
		while (pe instanceof Shape) {
			Shape shape = (Shape) pe;
			bo = linkService.getBusinessObjectForLinkedPictogramElement(shape);
	        if (c.isInstance(bo) &&
	        	(entityViewModel == null || entityViewModel.isEntity(bo, entityKind)) &&
	        	(result == null || bo == linkService.getBusinessObjectForLinkedPictogramElement(result))) {
	        	result = shape;
	        } else if (result != null) {
	        	break;
	        }
        	pe = shape.getContainer();
		}
		return result;
	}

	public static Shape getParentShape(Shape shape, Class<?> c) {
		do {
			shape = shape.getContainer();
			if (c.isInstance(shape)) {
				return shape;
			}
		} while (shape instanceof Shape);
		return null;
	}
	
	public static Shape getChildShape(ContainerShape parentShape, EObject childBo) {
        ILinkService linkService = Graphiti.getLinkService();
        for (Shape shape : parentShape.getChildren()) {
        	if (childBo == linkService.getBusinessObjectForLinkedPictogramElement(shape)) {
        		return shape;
        	}
        }
        return null;
	}

	public static <T> T getChildElement(PictogramElement pe, Class<T> c) {
        ILinkService linkService = Graphiti.getLinkService();
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
        if (pe instanceof ContainerShape) {
            for (Shape shape : ((ContainerShape) pe).getChildren()) {
            	EObject childBo = linkService.getBusinessObjectForLinkedPictogramElement(shape);
				if (childBo != null && (childBo != bo)) {
            		continue;
            	}
            	T element = getElement(shape, c);
            	if (element != null) {
            		return element;
            	}
            }
        }
        return null;
	}

	public static <T> T getElement(PictogramElement pe, Class<T> c) {
        if (c.isInstance(pe)) {
        	return (T) pe;
        }
        ILinkService linkService = Graphiti.getLinkService();
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
        if (c.isInstance(bo)) {
        	return (T) pe;
        }
        if (c.isInstance(pe.getGraphicsAlgorithm())) {
        	return (T) pe.getGraphicsAlgorithm();
        }
        T element = getChildElement(pe, c);
        if (element != null) {
        	return element;
        }
        if (pe instanceof AnchorContainer) {
        	for (Anchor anchor : ((AnchorContainer) pe).getAnchors()) {
        		if (c.isInstance(anchor)) {
        			return (T) anchor;
        		}
        	}
        }
        return null;
    }
	
	public static void setPropertyValue(PictogramElement pe, String key, Object value) {
		if (value != null) {
			Graphiti.getPeService().setPropertyValue(pe, key, String.valueOf(value));
		}
	}

	public static Object getPropertyValue(PictogramElement pe, String key, Object def) {
		String value = Graphiti.getPeService().getPropertyValue(pe, key);
		return value != null ? value : def;
	}

	public static boolean isSame(Object o1, Object o2) {
		return o1 != null ? o1.equals(o2) : o2 == null;
	}
	
	public static boolean isSame(Color actualColor, IColorConstant expectedColor) {
		return actualColor != null &&
				actualColor.getRed() == expectedColor.getRed() &&
				actualColor.getGreen() == expectedColor.getGreen() &&
				actualColor.getBlue() == expectedColor.getBlue();
	}
	
	//
	
	public static boolean setPoints(Polyline polyline, int[] xy) {
		boolean changed = false;
		EList<Point> points = polyline.getPoints();
		int i = 0;
		for (Point p : points) {
			if (i >= xy.length || p.getX() != xy[i] || p.getY() != xy[i + 1]) {
				changed = true;
				break;
			}
			i += 2;
		}
		if (i != xy.length) {
			changed = true;
		}
		if (changed) {
			points.clear();
			for (int j = 0; j < xy.length; j += 2) {
				points.add(Graphiti.getGaService().createPoint(xy[j], xy[j + 1]));
			}
		}
		return changed;
	}

	public static boolean setLocation(GraphicsAlgorithm ga, int x, int y) {
		boolean changed = false;
		if (ga.getX() != x) {
			ga.setX(x);
			changed |= true;
		}
		if (ga.getY() != y) {
			ga.setY(y);
			changed |= true;
		}
		return changed;
	}

	public static boolean setLocationAndSize(GraphicsAlgorithm ga, int x, int y, int w, int h) {
		boolean changed = setLocation(ga, x, y);
		if (ga.getWidth() != w) {
			ga.setWidth(w);
			changed |= true;
		}
		if (ga.getHeight() != h) {
			ga.setHeight(h);
			changed |= true;
		}
		return changed;
	}
}
