package org.ptolemy.xtext.generator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

class TypeParameterResolvingCopier extends Copier {

	private final TypeUtil typeUtil;
	
	public TypeParameterResolvingCopier(TypeUtil typeUtil) {
		this.typeUtil = typeUtil;
	}

	private boolean resolved = false, generic = false;
	
	public boolean isGeneric() {
		return generic;
	}

	static Result getResult(JvmTypeReference typeRef, TypeUtil typeUtil) {
		Result result = WrappingAdapter.getWrapped(typeRef, Result.class);
		if (result == null) {
			TypeParameterResolvingCopier copier = new TypeParameterResolvingCopier(typeUtil);
			JvmTypeReference copy = (JvmTypeReference) copier.copy(typeRef);
			copier.copyReferences();
			if (! copier.resolved) {
				copy = typeRef;
			}
			result = new Result(copy, copier.generic);
			new WrappingAdapter<Result>(result).attach(typeRef);
			if (copier.resolved && (! copier.generic)) {
				new WrappingAdapter<Result>(result).attach(copy);
			}
		}
		return result;
	}
	
	private Map<JvmTypeParameter, JvmType> resolvedMap = new HashMap<JvmTypeParameter, JvmType>();
	
	@Override
	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
		if (eObject instanceof JvmTypeReference && eReference.getEType() == TypesPackage.eINSTANCE.getJvmType()) {
			JvmTypeReference typeRef = (JvmTypeReference) eObject;
			if (eReference.isMany()) {
				for (JvmType typeParameter : (EList<? extends JvmType>) eObject.eGet(eReference)) {
					resolveTypeParameter(typeRef, typeParameter);
				}
			} else {
				resolveTypeParameter(typeRef, (JvmType) eObject.eGet(eReference));
			}
		}
		super.copyReference(eReference, eObject, copyEObject);
	}

	@Override
	public EObject get(Object key) {
		if (resolvedMap.containsKey(key)) {
			resolved = true;
			return resolvedMap.get(key);
		}
		return super.get(key);
	}
	
	protected void resolveTypeParameter(JvmTypeReference typeRef, JvmType type) {
		if (type instanceof JvmTypeParameter && (! containsKey(type))) {
			JvmType resolved = typeUtil.resolveTypeParameter(typeRef).getType();
			if (resolved instanceof JvmTypeParameter) {
				generic = true;
			}
			if (resolved != null) {
				resolvedMap.put((JvmTypeParameter) type, resolved);
			}
		}
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
}
