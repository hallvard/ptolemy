package org.ptolemy.graphiti.diagram.features.editastext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.ptolemy.ecore.actor.AtomicActor;

import com.google.inject.Inject;

public class EditAtomicActorAsTextFeature extends AbstractEditAsTextFeature {

	@Inject
	public EditAtomicActorAsTextFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(EObject bo) {
		return bo instanceof AtomicActor<?>;
	}

//	@Override
//	public EStructuralFeature[] getStructuralFeatures() {
//		return new EStructuralFeature[]{
//			ActorPackage.eINSTANCE.getAtomicActor_Impl(),
//		};
//	}
}
