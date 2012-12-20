package org.ptolemy.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;
import org.ptolemy.ecore.actor.Typeable;
import org.ptolemy.ecore.caltrop.OldActionVariableValueRef;

import com.google.inject.Singleton;

@Singleton
public class XActorTypeProvider extends XbaseTypeProvider {

	@Override
	protected JvmTypeReference expectedType(EObject container, EReference reference, int index, boolean rawType) {
		if (container instanceof Typeable) {
			return ((Typeable) container).getInferredType();
		}
		return super.expectedType(container, reference, index, rawType);
	}
}
