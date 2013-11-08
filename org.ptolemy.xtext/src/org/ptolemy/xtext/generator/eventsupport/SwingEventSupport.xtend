package org.ptolemy.xtext.generator.eventsupport

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.ArrayList
import java.util.Collection
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference

public class SwingEventSupport extends AbstractEventSupport implements EventSupport {
	
	@Inject Injector injector
	
	override isProperty() { false }
	
	override addEvents(JvmTypeReference typeRef, String name, Collection<EventData> events) {
		val adders = new ArrayList<JvmOperation>
		val removers = new ArrayList<JvmOperation>
		for (JvmOperation op : typeRef.allOperations) {
			if (if (name == null) op.listenerAdderName != null else name.equals(op.listenerAdderName)) {
				adders += op
			} else if (if (name == null) op.listenerRemoverName != null else name.equals(op.listenerRemoverName)) {
				removers += op
			}
		}
		for (JvmOperation remover : removers) {
			val adder = adders.findFirst[remover.isListenerRemoverFor(it)]
			if (adder != null) {
				val eventData = new SwingEventData(typeRef, name, copyType(adder.parameters.head.parameterType, typeRef))
				injector.injectMembers(eventData)
				events += eventData
			}
		}
	}
}
