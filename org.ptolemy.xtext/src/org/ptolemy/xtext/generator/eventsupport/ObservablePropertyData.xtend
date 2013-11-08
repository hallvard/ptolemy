package org.ptolemy.xtext.generator.eventsupport

import javax.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.ptolemy.xtext.generator.TreeAppendableUtil

class ObservablePropertyData extends EventData {

	public new(JvmTypeReference typeRef, String name, JvmTypeReference listenerType) {
		super(typeRef, name, listenerType)
	}

	@Inject extension TreeAppendableUtil
	@Inject extension AbstractEventSupport
	
	override appendAddListener(String listenerVar, ITreeAppendable it) {
		it << '''«name»Property().«listenerAdderName("")»(«listenerVar»)'''
	}

	override appendRemoveListener(String listenerVar, ITreeAppendable it) {
		it << '''«name»Property().«listenerRemoverName("")»(«listenerVar»)'''
	}	
}
