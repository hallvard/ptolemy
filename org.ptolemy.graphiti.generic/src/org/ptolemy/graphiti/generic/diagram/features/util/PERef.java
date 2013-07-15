package org.ptolemy.graphiti.generic.diagram.features.util;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

public class PERef<BO,PE> {

	private final Class<? extends BO> boc;
	private final Class<? extends PE> pec;
	private final int num;

	public PERef(Class<? extends BO> boc, Class<? extends PE> pec, int num) {
		this.boc = boc;
		this.pec = pec;
		this.num = num;
	}
	public PERef(Class<? extends BO> boc, Class<? extends PE> pec) {
		this(boc, pec, 1);
	}

	public PE get(EObject eObject) {
		PictogramElement pe = getParentElement(eObject, boc);
		return (pe != null ? getChildElement(pe, pec, num) : null);
	}
	
	public static <PE> PE getChildElement(PictogramElement pe, Class<PE> pec, int num) {
		int count = 0;
		if (pec.isInstance(pe) && ++count == num) {
			return (PE) pe;
		}
		ILinkService linkService = Graphiti.getLinkService();
		EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
		TreeIterator<EObject> contents = pe.eAllContents();
		while (contents.hasNext()) {
			EObject child = contents.next();
			if (child instanceof PictogramElement) {
				EObject thisBo = linkService.getBusinessObjectForLinkedPictogramElement((PictogramElement) child);
				if (thisBo != null && thisBo != bo) {
					contents.prune();
				}
			}
			if (pec.isInstance(child) && ++count == num) {
				return (PE) child;
			}
		}
		return null;
	}

	public static PictogramElement getParentElement(EObject eObject, Class<?> boc) {
		ILinkService linkService = Graphiti.getLinkService();
		EObject bo = null;
		PictogramElement result = null;
		while (eObject != null) {
			if (eObject instanceof PictogramElement) {
				PictogramElement pe = (PictogramElement) eObject;
				EObject thisBo = linkService.getBusinessObjectForLinkedPictogramElement(pe);
				if (bo == null) {
					if (boc.isInstance(thisBo)) {
						bo = thisBo;
					}
				} else if (thisBo != bo) {
					break;
				}
				result = pe;
			}
			eObject = eObject.eContainer();
		}
		return result;
	}
}
