package org.ptolemy.xtext.generator.eventsupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;

public abstract class EventData {

	public final JvmTypeReference typeRef;
	public final String name;

	protected JvmTypeReference listenerType;
	
	public EventData(JvmTypeReference typeRef, String name) {
		this.typeRef = typeRef;
		this.name = name;
	}

	public EventData(JvmTypeReference typeRef, String name, JvmTypeReference listenerType) {
		this(typeRef, name);
		this.listenerType = listenerType;
	}
	
	public JvmTypeReference getListenerType(EObject context) {
		return listenerType;
	}

	public abstract void appendAddListener(String listenerVar, ITreeAppendable it);
	public abstract void appendRemoveListener(String listenerVar, ITreeAppendable it);
}
