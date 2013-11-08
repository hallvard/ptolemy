package org.ptolemy.xtext.generator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

public class MappingCopier extends Copier {
	
	private Map<JvmTypeParameter, JvmTypeReference> mapping;
	private boolean removeWildcards = true;

	public MappingCopier(Map<JvmTypeParameter, JvmTypeReference> mapping) {
		super(true, true);
		this.mapping = mapping;
	}
	
	@Override
	public EObject copy(EObject eObject) {
		if (removeWildcards && eObject instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildCard = (JvmWildcardTypeReference) eObject;
			JvmLowerBound lower = null;
			JvmUpperBound upper = null;
			for (JvmTypeConstraint constraint : wildCard.getConstraints()) {
				if (constraint instanceof JvmLowerBound) {
					lower = (JvmLowerBound) constraint;
				} else if (constraint instanceof JvmUpperBound) {
					upper = (JvmUpperBound) constraint;
				}
			}
			if (lower != null && lower.getTypeReference() != null) {
				eObject = lower.getTypeReference();
			} else if (upper != null && upper.getTypeReference() != null) {
				eObject = upper.getTypeReference();
			}
		}
		if (eObject instanceof JvmTypeReference) {
			JvmTypeReference typeRef = (JvmTypeReference) eObject;
			while (typeRef.getType() instanceof JvmTypeParameter) {
				JvmTypeReference resolvedTypeRef = resolveTypeParameter((JvmTypeParameter) typeRef.getType());
				if (resolvedTypeRef == null) {
					break;
				}
				typeRef = resolvedTypeRef;
			}
			eObject = typeRef;
		}
		return super.copy(eObject);
	}

	protected JvmTypeReference resolveTypeParameter(JvmTypeParameter typeParameter) {
		return (mapping != null ? mapping.get(typeParameter) : null);
	}

	public static <E extends EObject> E map(E eObject, JvmTypeReference... typeRefs) {
		return map(eObject, false, typeRefs);
	}

	public static <E extends EObject> E map(E eObject, boolean removeWildcards, JvmTypeReference... typeRefs) {
		MappingCopier copier = new MappingCopier(computeTypeArgumentMapping(typeRefs));
		copier.removeWildcards = removeWildcards;
		E copy = (E) copier.copy(eObject);
		copier.copyReferences();
		return copy;
	}
	
	public static Map<JvmTypeParameter, JvmTypeReference> computeTypeArgumentMapping(JvmTypeReference... typeRefs) {
		Map<JvmTypeParameter, JvmTypeReference> typeMapping = new HashMap<JvmTypeParameter, JvmTypeReference>();
		Queue<JvmTypeReference> types = new LinkedList<JvmTypeReference>(Arrays.asList(typeRefs));
		while (types.size() > 0) {
			JvmTypeReference nextTypeRef = types.remove();
			JvmType nextType = nextTypeRef.getType();
			if (nextTypeRef instanceof JvmParameterizedTypeReference && nextType instanceof JvmTypeParameterDeclarator) {
				Iterator<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) nextType).getTypeParameters().iterator();
				Iterator<JvmTypeReference> typeArguments = ((JvmParameterizedTypeReference) nextTypeRef).getArguments().iterator();
				while (typeParameters.hasNext() && typeArguments.hasNext()) {
					typeMapping.put(typeParameters.next(), typeArguments.next());
				}
			}
			if (nextType instanceof JvmDeclaredType) {
				types.addAll(((JvmDeclaredType) nextType).getSuperTypes());
			}
		}
		return typeMapping;
	}
}
