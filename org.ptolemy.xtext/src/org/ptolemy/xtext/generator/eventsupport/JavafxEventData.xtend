package org.ptolemy.xtext.generator.eventsupport

import javax.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.ptolemy.xtext.generator.TreeAppendableUtil

class JavafxEventData extends EventData {

	public new(JvmTypeReference typeRef, String name, JvmTypeReference listenerType) {
		super(typeRef, name, listenerType, "handle", 1)
	}

	@Inject extension TreeAppendableUtil
	@Inject extension JavafxEventSupport
	
	override appendAddListener(String listenerVar, ITreeAppendable it) {
		it << '''«handlerSetterName(name)»(«listenerVar»)'''
	}

	override appendRemoveListener(String listenerVar, ITreeAppendable it) {
		it << '''«handlerSetterName(name)»(null)'''
	}
}
