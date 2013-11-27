package org.ptolemy.xtext.generator.eventsupport

import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.lib.Pair
import org.ptolemy.xtext.generator.MappingCopier

public class AbstractEventSupport {
	
	def allOperations(JvmTypeReference typeRef) {
		(typeRef.type as JvmDeclaredType).allFeatures.filter(JvmOperation)
	}
	
	def copyType(JvmTypeReference type, JvmTypeReference... contextTypes) {
		MappingCopier.map(type, true, contextTypes)
	}

	def accessorName(String name, String prefix, String suffix) {
		if (prefix == null && suffix != null && name.endsWith(suffix)) {
			name.substring(0, name.length - suffix.length)
		} else if (prefix != null && name.startsWith(prefix) && name.length > prefix.length && Character::isUpperCase(name.charAt(prefix.length)) && (suffix == null || name.endsWith(suffix))) {
			name.substring(prefix.length, name.length - if (suffix != null) suffix.length else 0).toFirstLower
		} else
			null
	}

	def isAccessorName(String name, String prefix, String suffix) {
		accessorName(name, prefix, suffix) != null
	}

	def listenerAdderName(String eventName) { "add" + eventName.toFirstUpper + "Listener" }
	def listenerAdderName(JvmOperation op) {
		if (op.parameters.size == 1) accessorName(op.simpleName, "add", "Listener") else null  
	}

	def listenerRemoverName(String eventName) 	{ "remove" + eventName.toFirstUpper + "Listener" }
	def listenerRemoverName(JvmOperation op) {
		if (op.parameters.size == 1) accessorName(op.simpleName, "remove", "Listener") else null 
	}
	
	def isListenerRemoverFor(JvmOperation op, JvmOperation adder) {
		op.listenerRemoverName.equals(adder.listenerAdderName) && {
			if (op.parameters.size == adder.parameters.size) {
				val removerParameters = op.parameters.iterator
				val adderParameters = adder.parameters.iterator
				while (removerParameters.hasNext && adderParameters.hasNext) {
					val removerParameterType = removerParameters.next.parameterType
					val adderParameterType = adderParameters.next.parameterType
					if (removerParameterType == null || adderParameterType == null) {
						return false
					}
					val removerQName = removerParameterType.qualifiedName
					val adderQName = adderParameterType.qualifiedName
					if (removerQName == null || adderQName == null) {
						return false
					}
					if (! removerQName.equals(adderQName)) {
						return false
					}
				}
				return true
			}
			false
		}
	}

	def Pair<JvmOperation, JvmOperation> addRemoveListenerMethods(JvmDeclaredType type, String name, String listenerTypeName) {
		val listenerAdderName = listenerAdderName(name)
		val listenerRemoverName = listenerRemoverName(name)
		var JvmOperation addListenerMethod = null
		var JvmOperation removeListenerMethod = null
		// look add/removeListener methods
		for (JvmOperation op : type.allFeatures.filter(JvmOperation)) {
			if (op.parameters.size == 1) {
				val parameterType = op.parameters.head.parameterType
				if (parameterType != null) {
					var qName = parameterType.qualifiedName
					val pos = qName.indexOf('<')
					if (pos > 0) {
						qName = qName.substring(0, pos)
					}
					if (listenerTypeName == null || qName.equals(listenerTypeName)) {
						if (op.simpleName.equals(listenerAdderName)) {
							addListenerMethod = op
						} else if (op.simpleName.equals(listenerRemoverName)) {
							removeListenerMethod = op
						}
					}
				}
			}
		}
		if (addListenerMethod != null && removeListenerMethod != null && removeListenerMethod.isListenerRemoverFor(addListenerMethod))
			addListenerMethod -> removeListenerMethod
		else
			null			
	}
}
