package org.ptolemy.xtext.generator.eventsupport

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.Collection
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference

public class ObservablePropertySupport extends AbstractEventSupport implements EventSupport {
	
	@Inject Injector injector

	override isProperty() { true }

	override void addEvents(JvmTypeReference typeRef, String name, Collection<EventData> properties) {
		// look for property methods, i.e. methods ending with Property (and returning ObservableValues)
		for (JvmOperation op : typeRef.allOperations) {
			if (if (name == null) op.observableGetterName != null else name.equals(op.observableGetterName)) {
				val observableType = op.returnType
				if (observableType.type instanceof JvmDeclaredType) {
					val addRemoveListenerMethods = addRemoveListenerMethods(observableType.type as JvmDeclaredType, "", "javafx.beans.value.ChangeListener")
					if (addRemoveListenerMethods != null) {
						val listenerType = addRemoveListenerMethods.key.parameters.head.parameterType
						val propertyData = new ObservablePropertyData(typeRef, op.observableGetterName, copyType(listenerType, typeRef, observableType))
						injector.injectMembers(propertyData)
						properties += propertyData 
					}
				}
			}
		}
	}

	def observableGetterName(JvmOperation op) {
		if (op.parameters.size == 0) accessorName(op.simpleName, null, "Property") else null
	}
}
