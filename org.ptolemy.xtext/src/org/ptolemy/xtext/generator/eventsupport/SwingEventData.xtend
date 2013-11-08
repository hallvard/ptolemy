package org.ptolemy.xtext.generator.eventsupport

import javax.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.ptolemy.xtext.generator.TreeAppendableUtil

class SwingEventData extends EventData {

	public new(JvmTypeReference typeRef, String name, JvmTypeReference listenerType) {
		super(typeRef, name, listenerType)
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
