package org.ptolemy.graphiti.generic.diagram.features.editastext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

import com.google.inject.Inject;

public class EditPortAsTextFeature extends AbstractEditAsTextFeature {

	@Inject
	public EditPortAsTextFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(EObject bo) {
		return actorViewModel.isPort(bo, null);
	}

//	public EStructuralFeature[] getStructuralFeatures() {
//		return new EStructuralFeature[]{
//			ActorPackage.eINSTANCE.getJvmTypedObj_Type(),
//			ActorPackage.eINSTANCE.getAbstractIOPort_Multiport(),
//		};
//	}
}
