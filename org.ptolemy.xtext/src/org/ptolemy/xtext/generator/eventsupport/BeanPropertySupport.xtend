package org.ptolemy.xtext.generator.eventsupport

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.ArrayList
import java.util.Collection
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.lib.Pair

public class BeanPropertySupport extends AbstractEventSupport implements EventSupport {
	
	@Inject Injector injector
	
	override isProperty() { true }
	
	override void addEvents(JvmTypeReference typeRef, String name, Collection<EventData> properties) {
		val addRemoveListenerMethods = addRemoveListenerMethods(typeRef.type as JvmDeclaredType, "propertyChange", "java.beans.PropertyChangeListener")
		if (addRemoveListenerMethods == null) {
			return
		}
		val setters = <JvmOperation>newArrayList
		val getters = <JvmOperation>newArrayList
		// look for getters and setters, i.e. methods beginning with get/is and set
		for (JvmOperation op : typeRef.allOperations) {
			if (if (name == null) op.setterPropertyName != null else name.equals(op.setterPropertyName)) {
				setters += op
			} else if (if (name == null) op.getterPropertyName != null else name.equals(op.getterPropertyName)) {
				getters += op
			}
		}
		// add as property when setter has corresponding getter
		for (JvmOperation setter : setters) {
			val getter = getters.findFirst[ isGetterFor(setter) ]
			if (getter != null) {
				val propertyData = new BeanPropertyData(typeRef, getter.getterPropertyName, copyType(addRemoveListenerMethods.key.parameters.head.parameterType))
				injector.injectMembers(propertyData)
				properties += propertyData 
			}
		}
	}

	def setterPropertyName(JvmOperation op) {
		if (op.parameters.size == 1) accessorName(op.simpleName, "set", null) else null
	}
	
	def String getterPropertyName(JvmOperation op) {
		var getterName = null as String
		if (op.parameters.size == 0) {
			getterName = accessorName(op.simpleName, "get" , null)
			if (getterName == null && "boolean".equals(op.returnType.qualifiedName)) {
				getterName = accessorName(op.simpleName, "is", null)
			}
		}
		getterName
	}

	def isGetterFor(JvmOperation op, JvmOperation setter) {
		op.getterPropertyName.equals(setter.setterPropertyName) && op.returnType.qualifiedName.equals(setter.parameters.head.parameterType.qualifiedName)
	}

	//
	
	def Iterable<Pair<String, JvmTypeReference>> getEvents(JvmDeclaredType type, String name) {
		val adders = new ArrayList<JvmOperation>
		val removers = new ArrayList<JvmOperation>
		val events = new ArrayList<Pair<String, JvmTypeReference>>
		for (JvmOperation op : type.allFeatures.filter(JvmOperation)) {
			if (if (name == null) op.listenerAdderName != null else name.equals(op.listenerAdderName)) {
				adders += op
			} else if (if (name == null) op.listenerRemoverName != null else name.equals(op.listenerRemoverName)) {
				removers += op
			}
		}
		for (JvmOperation remover : removers) {
			val adder = adders.findFirst[remover.isListenerRemoverFor(it)]
			if (adder != null) {
				events += adder.listenerAdderName -> adder.parameters.head.parameterType
			}
		}
		events
	}

	def Pair<String, JvmTypeReference> getEvent(JvmDeclaredType type, String eventName) {
		getEvents(type, eventName).head
	}
	def Pair<String, JvmTypeReference> getEvent(JvmTypeReference typeRef, String eventName) {
		if (typeRef.type instanceof JvmDeclaredType)
			getEvent(typeRef.type as JvmDeclaredType, eventName)
		else null
	}
}
