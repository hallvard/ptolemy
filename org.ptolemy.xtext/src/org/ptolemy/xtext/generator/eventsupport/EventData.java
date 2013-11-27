package org.ptolemy.xtext.generator.eventsupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;

public abstract class EventData {

	public final JvmTypeReference typeRef;
	public final String name;

	protected JvmTypeReference listenerType;
	protected JvmOperation listenerMethod;
	
	public EventData(JvmTypeReference typeRef, String name) {
		this.typeRef = typeRef;
		this.name = name;
	}

	public EventData(JvmTypeReference typeRef, String name, JvmTypeReference listenerType, JvmOperation listenerMethod) {
		this(typeRef, name);
		this.listenerType = listenerType;
		this.listenerMethod = listenerMethod;
	}

	static JvmOperation findMethod(JvmTypeReference typeReference, String name, int argCount) {
		for (JvmFeature feature : ((JvmDeclaredType) typeReference.getType()).getAllFeatures()) {
			if (feature instanceof JvmOperation) {
				JvmOperation op = (JvmOperation) feature;
				if ((name == null || name.equals(feature.getSimpleName())) && (argCount < 0 || op.getParameters().size() == argCount)) {
					return op;
				}
			}
		}
		return null;
	}

	public EventData(JvmTypeReference typeRef, String name, JvmTypeReference listenerType, String listenerMethodName, int argCount) {
		this(typeRef, name, listenerType, null);
		this.listenerMethod = findMethod(listenerType, listenerMethodName, argCount);
	}

	public JvmTypeReference getListenerType() {
		return listenerType;
	}

	public JvmOperation getListenerMethod() {
		return listenerMethod;
	}

	public abstract void appendAddListener(String listenerVar, ITreeAppendable it);
	public abstract void appendRemoveListener(String listenerVar, ITreeAppendable it);
}
