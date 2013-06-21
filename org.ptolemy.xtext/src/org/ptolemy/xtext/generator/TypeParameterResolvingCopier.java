package org.ptolemy.xtext.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.ptolemy.ecore.actor.ActorRef;
import org.ptolemy.ecore.actor.TypeParameter;
import org.ptolemy.ecore.actor.TypeParameterized;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityRef;

import com.google.inject.Inject;

class TypeParameterResolvingCopier extends Copier {

	private boolean generic = false;
	
	public boolean isGeneric() {
		return generic;
	}
	
	public static class Result {

		public final JvmTypeReference typeRef;
		public boolean generic;

		public Result(JvmTypeReference typeRef, boolean generic) {
			super();
			this.typeRef = typeRef;
			this.generic = generic;
		}
	}

	static Result getCachedResult(JvmTypeReference typeRef) {
		return WrappingAdapter.getWrapped(typeRef, Result.class);
	}

	Result copyTypeReference(JvmTypeReference typeRef) {
		JvmTypeReference copy = (JvmTypeReference) copy(typeRef);
		copyReferences();
		Result result = new Result(copy, generic);
		new WrappingAdapter<Result>(result).attach(typeRef);
		if (! generic) {
			new WrappingAdapter<Result>(result).attach(copy);
		}
		return result;
	}
	
	@Override
	public EObject copy(EObject eObject) {
		if (eObject instanceof JvmTypeReference) {
			JvmTypeReference typeRef = (JvmTypeReference) eObject;
			if (typeRef.getType() instanceof JvmTypeParameter) {
				JvmTypeReference resolveTypeRef = resolveTypeParameter(typeRef, true);
				if (resolveTypeRef.getType() instanceof JvmTypeParameter) {
					generic = true;
				}
				return resolveTypeRef;
			}
		}
		return super.copy(eObject);
	}
	
	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	JvmTypeReference resolveTypeParameter(JvmTypeReference typeRef, boolean clone) {
		while (typeRef != null && typeRef.getType() instanceof JvmTypeParameter) {
			JvmTypeReference resolvedTypeRef = resolveTypeParameter1(typeRef);
			if (resolvedTypeRef == null) {
				break;
//				return typeRef;
			}
			typeRef = resolvedTypeRef;
		}
		return (clone ? jvmTypesBuilder.cloneWithProxies(typeRef) : typeRef);
	}
	
	JvmTypeReference resolveTypeParameter1(JvmTypeReference typeRef) {
		EObject container = typeRef.eContainer();
		while (container != null) {
			if (container instanceof Entity<?>) {
				EntityRef<?> entityRef = ((Entity<?>) container).getSuperEntity();
				if (entityRef != null && entityRef.getRef() != null) {
					Entity<?> superEntity = entityRef.getRef();
					if (entityRef instanceof ActorRef<?> && superEntity instanceof TypeParameterized) {
						EList<JvmTypeReference> typeArguments = ((ActorRef<?>) entityRef).getTypeArguments();
						int pos = 0;
						for (TypeParameter typeParameter : ((TypeParameterized) superEntity).getTypeParameters()) {
							for (EObject jvmElement : jvmModelAssociations.getJvmElements(typeParameter)) {
								if (typeRef.getType() == jvmElement && pos < typeArguments.size()) {
									return typeArguments.get(pos);
								}
							}
							pos = pos + 1;
						}
					}
				}
			}
			container = container.eContainer();
		}
		return null;
	}
}
