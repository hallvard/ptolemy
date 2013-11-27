package org.ptolemy.xtext.generator.eventsupport

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.ArrayList
import java.util.Collection
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmDeclaredType

public class ListenerMethodEventSupport extends AbstractEventSupport implements EventSupport {
	
	@Inject Injector injector
	
	override isProperty() { false }
	
	override addEvents(JvmTypeReference typeRef, String name, Collection<EventData> events) {
		val adders = new ArrayList<JvmOperation>
		val removers = new ArrayList<JvmOperation>
		for (JvmOperation op : typeRef.allOperations) {
			if (op.listenerAdderName != null) {
				adders += op
			} else if (op.listenerRemoverName != null) {
				removers += op
			}
		}
		for (JvmOperation remover : removers) {
			val adder = adders.findFirst[remover.isListenerRemoverFor(it)]
			if (adder != null && name != null) {
				val eventName = adder.listenerAdderName
				val listenerType = adder.parameters.head.parameterType
				if (name != null) {
					val listenerMethod = EventData.findMethod(listenerType, name, -1)
					addEvent(typeRef, eventName, listenerType, listenerMethod, events)
				} else {
					(listenerType as JvmDeclaredType).allFeatures.filter(JvmOperation).forEach[
						addEvent(typeRef, eventName, listenerType, it, events)
					]
				} 
			}
		}
	}
	
	def private addEvent(JvmTypeReference typeRef, String name, JvmTypeReference listenerType, JvmOperation listenerMethod, Collection<EventData> events) {
		val eventData = new ListenerMethodEventData(typeRef, name, copyType(listenerType, typeRef), listenerMethod)
		injector.injectMembers(eventData)
		events += eventData
	}
}
