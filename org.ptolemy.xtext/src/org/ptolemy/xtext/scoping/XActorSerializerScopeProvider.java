package org.ptolemy.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.annotations.scoping.XbaseWithAnnotationsScopeProvider;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.eclipse.xtext.xbase.serializer.SerializerScopeProvider;

import com.google.inject.Inject;

public class XActorSerializerScopeProvider extends SerializerScopeProvider {
	
	@Inject
	private XActorDelegatedScopeProvider delegatedScopeProvider;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope superScope = super.getScope(context, reference);
		return delegatedScopeProvider.getScope(context, reference, superScope);
	}
}
