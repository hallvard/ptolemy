package org.ptolemy.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.annotations.scoping.XbaseWithAnnotationsScopeProvider;

import com.google.inject.Inject;

public class XActorScopeProvider extends XbaseWithAnnotationsScopeProvider {
	
	@Inject
	private XActorDelegatedScopeProvider delegatedScopeProvider;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope superScope = super.getScope(context, reference);
		return delegatedScopeProvider.getScope(context, reference, superScope);
	}
}
