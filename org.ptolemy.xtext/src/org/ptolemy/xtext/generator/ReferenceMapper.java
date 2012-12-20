package org.ptolemy.xtext.generator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmTypeParameter;

public class ReferenceMapper extends EcoreUtil.Copier {

	private Class<? extends EObject> c;
	
	public ReferenceMapper(Class<? extends EObject> c) {
		super();
		this.c = c;
	}

	@Override
	public EObject get(Object key) {
		if (c.isInstance(key)) {
			EObject wrapped = WrappingAdapter.getWrapped((EObject) key, JvmTypeParameter.class);
			if (wrapped!= null) {
				return wrapped;
			}
			return (EObject) key;
		}
		return super.get(key);
	}
}
