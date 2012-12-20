package org.ptolemy.xtext.scoping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.scoping.LocalVariableScopeContext;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.Actor;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.Parameter;
import org.ptolemy.ecore.actor.ParameterBinding;
import org.ptolemy.ecore.actor.Typeable;
import org.ptolemy.ecore.actor.Variable;
import org.ptolemy.ecore.caltrop.FireAction;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Relation;

import com.google.inject.Inject;

public class XActorScopeProvider extends XbaseScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context instanceof ParameterBinding && reference == ActorPackage.eINSTANCE.getParameterBinding_ParameterRef()) {
			Collection<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();
			if (context.eContainer() instanceof EntityRef<?>) {
				EntityRef<?> entityRef = (EntityRef<?>) context.eContainer();
				Entity<?> entity = entityRef.getOwner(); // entityRef.getRef();
				if (entity != null) {
					for (Attribute attribute : entity.getAllAttributes()) {
						if (attribute instanceof Parameter && attribute.getInheritsFrom() != null) {
							descriptions.add(EObjectDescription.create(attribute.getName(), attribute));
						}
					}
				}
			}
			IScope scope = super.getScope(context, reference);
			if (! descriptions.isEmpty()) {
				scope = new SimpleScope(scope, descriptions);
			}
			return scope;
		}
		return super.getScope(context, reference);
	}

	@Override
	protected IScope createLocalVarScope(IScope parentScope, LocalVariableScopeContext scopeContext) {
		EObject context = scopeContext.getContext();
		return super.createLocalVarScope(parentScope, scopeContext);
	}
}
