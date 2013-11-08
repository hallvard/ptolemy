package org.ptolemy.xtext.generator.eventsupport

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.ArrayList
import java.util.Collection
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.ptolemy.xtext.generator.MappingCopier

public class JavafxEventSupport extends AbstractEventSupport implements EventSupport {
	
	@Inject Injector injector
	
	override isProperty() { false }
	
	override addEvents(JvmTypeReference typeRef, String name, Collection<EventData> events) {
		val handlerSetters = new ArrayList<JvmOperation>
		for (JvmOperation op : typeRef.allOperations) {
			if (if (name == null) op.handlerSetterName != null else name.equals(op.handlerSetterName)) {
				handlerSetters += op
			}
		}
		for (JvmOperation handlerSetter : handlerSetters) {
			val eventData = new JavafxEventData(typeRef, name, copyType(handlerSetter.parameters.head.parameterType, typeRef))
			injector.injectMembers(eventData)
			events += eventData
		}
	}
	
	def handlerSetterName(String eventName) { "setOn" + eventName.toFirstUpper }
	def handlerSetterName(JvmOperation op) {
		if (op.parameters.size == 1) accessorName(op.simpleName, "setOn", null) else null  
	}
}
