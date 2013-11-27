package org.ptolemy.xtext.generator.eventsupport

import javax.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.ptolemy.xtext.generator.TreeAppendableUtil
import org.eclipse.xtext.common.types.JvmOperation

class ListenerMethodEventData extends EventData {

	public new(JvmTypeReference typeRef, String name, JvmTypeReference listenerType, JvmOperation listenerMethod) {
		super(typeRef, name, listenerType, listenerMethod)
	}

	@Inject extension TreeAppendableUtil
	@Inject extension AbstractEventSupport
	
	override appendAddListener(String listenerVar, ITreeAppendable it) {
		it << '''«listenerAdderName(name)»(«listenerVar»)'''
	}

	override appendRemoveListener(String listenerVar, ITreeAppendable it) {
		it << '''«listenerRemoverName(name)»(«listenerVar»)'''
	}	
}
