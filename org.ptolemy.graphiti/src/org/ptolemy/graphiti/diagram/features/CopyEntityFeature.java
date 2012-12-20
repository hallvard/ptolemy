package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;
import org.ptolemy.ecore.kernel.IEntity;

import com.google.inject.Inject;

public class CopyEntityFeature extends AbstractCopyFeature {

	@Inject
	public CopyEntityFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canCopy(ICopyContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		for (int i = 0; i < pictogramElements.length; i++) {
			PictogramElement pe = pictogramElements[i];
			if (! canCopy(getBusinessObjectForPictogramElement(pe))) {
				return false;
			}
		}
		return pictogramElements.length > 0;
	}

	public boolean canCopy(Object eObject) {
		return eObject instanceof IEntity<?>;
	}

	@Override
	public void copy(ICopyContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		EObject[] bos = new EObject[pictogramElements.length];
		for (int i = 0; i < pictogramElements.length; i++) {
			PictogramElement pe = pictogramElements[i];
			EObject bo = (EObject) getBusinessObjectForPictogramElement(pe);
			bos[i] = EcoreUtil.copy(bo);
		}
		putToClipboard(bos);
	}
}
