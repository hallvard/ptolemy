package org.ptolemy.xtext.generator

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Iterator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Pair
import org.ptolemy.ecore.actor.AbstractIOPort
import org.ptolemy.ecore.actor.InjectableAttribute
import org.ptolemy.ecore.actor.Typeable
import org.ptolemy.ecore.actor.Variable
import org.ptolemy.ecore.caltrop.ActionPattern
import org.ptolemy.ecore.caltrop.ChannelSelector
import org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
import org.ptolemy.ecore.caltrop.EventPattern
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector
import org.ptolemy.ecore.caltrop.InputPattern
import org.ptolemy.ecore.caltrop.KeywordChannelSelector
import org.ptolemy.ecore.caltrop.OutputPattern
import org.ptolemy.ecore.caltrop.PortPattern
import org.ptolemy.ecore.kernel.Entity
import org.ptolemy.ecore.kernel.Nameable
import org.ptolemy.ecore.kernel.Port

class ActionPatternHelper {
	
    @Inject extension JvmTypesBuilder
	@Inject extension TypeReferences
	@Inject extension TypeUtil

	def isTokenVariable(EObject eObject) {
		eObject instanceof Variable && eObject.eContainer() instanceof Entity<?>
	}

	def isInjectedValue(EObject eObject) {
		eObject instanceof InjectableAttribute && eObject.eContainer() instanceof Entity<?>
	}

    def isMultiport(PortPattern pattern, Port port) {
    	port instanceof AbstractIOPort && (port as AbstractIOPort).multiport && pattern.channels != null
    }

    def isRepeat(PortPattern pattern) {
		pattern.repeatExpression != null
    }

	def toImplType(JvmTypeReference typeRef) {
		val typeParameterMapper = new ReferenceMapper(JvmTypeParameter)
		val copy = typeParameterMapper.copy(typeRef) as JvmTypeReference
		typeParameterMapper.copyReferences
		copy
	}
	
	def methodName(String name, String format) {
		String::format(format, name.toFirstUpper).toFirstLower
	}

	def methodName(Nameable named, String format) {
		methodName(named.name, format)
	}
	
	def type(PortPattern pattern, boolean multi, Boolean impl) {
		val elementType = type(pattern.portRef as Typeable)
		val type = elementType ?: Object.getTypeForName(pattern)
    	var implType = toImplType(type)
    	if (pattern.isRepeat()) {
    		if (implType.isPrimitive) {
	    		implType = createArrayType(type)
    		} else {
    			implType = pattern.newTypeRef(Iterable, type)
    		}
    	}
    	if (multi) {
//    		var innerType = Iterable as Class<? extends Iterable>
//    		if (impl != null) {
//	    		innerType = if (impl) ArrayList else List
//    		}
    		implType = pattern.newTypeRef("org.ptolemy.xtext.lib.caltrop.ChannelMap", implType.objectType(pattern)) // type.cloneWithProxies?
    	}
    	implType
	}
	
	def channelsInternalType(EObject context) {
		createArrayType(context.newTypeRef("java.lang.Integer"))
	}

	def channelsType(EObject context, boolean many) {
		if (many)
			context.newTypeRef(Iterable, context.newTypeRef(Integer))
		else
			context.newTypeRef(int)
	}

	def type(ActionPattern pattern, Boolean impl) {
		if (pattern instanceof PortPattern) {
			val portPattern = pattern as PortPattern
			val port = portPattern.portRef
			portPattern.type(portPattern.isMultiport(port), impl)
		} else if (pattern instanceof EventPattern) {
			val eventPattern = pattern as EventPattern
			val beanType = eventPattern.varRef?.inferredType
			if (beanType != null) {
				val eventName = eventPattern.name
				val eventDef = if (eventPattern.property) beanType.getProperty(eventName) else beanType.getEvent(eventName)
				if (eventDef != null) {
					var listenerType = (if (eventPattern.property) pattern.newTypeRef("java.beans.PropertyChangeListener") else eventDef.value)
					// assume the event type is the type of the first parameter in the first method
					if (impl != null) listenerType else
					(listenerType.type as JvmDeclaredType).allFeatures.filter(JvmOperation).findFirst[! it.parameters.empty].parameters.head.parameterType
				}
			}
		}
	}
	
	@Inject extension TreeAppendableUtil
	
	def boolean isChannelSelectorKeyword(ChannelSelector channelSelector, ChannelSelectorKeyword keyword) {
		channelSelector instanceof KeywordChannelSelector && (channelSelector as KeywordChannelSelector).keyword == keyword
	}

	def requiredChannelCount(ChannelSelector channelSelector) {
		if (channelSelector instanceof ExpressionChannelSelector)
			(channelSelector as ExpressionChannelSelector).keyExpressions.size()
		else
			1
	}

	def generateChannelsList(PortPattern pattern, String channelsVar, String repeatVar, String widthVar, ITreeAppendable it) {
		val countArg = pattern.size() + " * " + (repeatVar ?: "1")
		val channels = pattern.channels
		val anyArg = channels.isChannelSelectorKeyword(ChannelSelectorKeyword::ANY)
		val port = pattern.portRef
		switch (channels) {
			KeywordChannelSelector: {
				it -> pattern << port.channelsInternalType << ''' «channelsVar» = channels(«pattern.portAccess», «countArg», «anyArg», «widthVar»);'''
			}
			ExpressionChannelSelector: {
				val channelVars = new ArrayList<String>()
				for (expression : channels.keyExpressions) {
//					expression.toJavaStatement(it, true) newLine
					val channelVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Channel")
					it -> port << port.channelsType(channels.many) << ''' «channelVar» = ''' // << expression << ";"
//					methodCall(patternMethodName(pattern, actionMethod, "Channel", expression), actionMethod, it)
					methodCall(expression, it)
					it << ";"
					channelVars += channelVar
				}
				it -> pattern << port.channelsInternalType << ''' «channelsVar» = channels(«pattern.portAccess», «countArg», «anyArg», '''
				if (channels.many) {
					// needed because the channels type is parameterized and we cannot create an array of such a type 
					it << channelVars.join(", ") << ");"
				} else {
					it -> port << "new " << port.channelsType(false) << "[]{" << channelVars.join(", ") << "});"
				}
			}
		}
	}

	def <T> T ancestor(EObject eObject, Class<T> clazz) {
		var container = eObject.eContainer()
		while (container != null) {
			if (clazz.isInstance(container)) {
				return container as T
			}
			container = container.eContainer()
		}
		null as T
	}

	def String portAccess(PortPattern pattern) {
		return '''«ancestor(pattern, Entity).name».this.«pattern.portRef.name»'''
	}

	def String tokenValueAccess(PortPattern pattern) {
		'''«pattern.portRef.methodName("_get%sTokenValue")»'''
	}

	def String createTokenAccess(PortPattern pattern) {
		'''«pattern.portRef.methodName("_create%sToken")»'''
	}

	def void generatePatternMatchPart(InputPattern pattern, Port port, JvmExecutable method, ITreeAppendable it) {
		val repeatVar = (if (pattern.isRepeat()) it.declareSyntheticVariable(pattern, "_" + port.name + "Repeat") else "1")
		if (pattern.isRepeat()) {
//			pattern.repeatExpression.toJavaStatement(it, true) newLine
			it << '''int «repeatVar»''' << " = "
			methodCall(pattern.repeatExpression, it)
			it << ";"
		}
		val isMultiport = pattern.isMultiport(port)
		val widthVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Width")
		val channelsVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Channels")
		if (isMultiport) {
			it << '''int «widthVar» = «pattern.portAccess».getWidth();'''
			generateChannelsList(pattern, channelsVar, repeatVar, widthVar, it)
			it << '''if («channelsVar» == null || «channelsVar».length == 0) return false;'''
			for (variable : pattern.variables) {
				it << ''' «variable» = channelMap(«channelsVar»);'''
			}
		}
		val channelVar = if (isMultiport) it.declareSyntheticVariable(pattern, "_" + port.name + "Channel") else "0"
		if (isMultiport) {
			it << '''for (int «channelVar» : «channelsVar») {'''
		}
		val arrayVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Array")
		if (pattern.isRepeat() || pattern.size() > 1) {
			it << '''if (! hasToken(«pattern.portAccess», «channelVar», «repeatVar» * «pattern.size()»)) return false;'''
			it -> pattern << "ptolemy.data.Token" << '''[] «arrayVar» = «pattern.portAccess».get(«channelVar», «repeatVar» * «pattern.size()»);'''
		}
		for (variable : pattern.variables) {
			val varVar = if (isMultiport) it.declareSyntheticVariable(pattern, "_" + variable) else variable
			inputPatternVariable(variable, varVar, arrayVar, channelVar, repeatVar, pattern, port, it);
			if (isMultiport) {
				it << '''«variable».put(«channelVar», «varVar»);'''
			}
		}
		if (isMultiport) {
			it << "}"
		}
		if (pattern.guardExpression != null) {
			it << "if (! " methodCall(pattern.guardExpression, it) it << ") return false;"
		}
	}

	def void generatePatternMatchPart(EventPattern pattern, Variable varRef, JvmExecutable method, ITreeAppendable it) {
		val eventVar = it.declareSyntheticVariable(pattern, "event")
		it << '''Object[] «eventVar» = getEvent(«varRef.name», "«pattern.name»", «if (pattern.qualifier != null) '''"«pattern.qualifier»"''' else "null"»);'''
		it << '''if («eventVar» == null) return false;'''
		var num = 0;
		for (variable : pattern.variables) {
			it -> pattern << '''if («eventVar».length > «num») «variable» = (''' << pattern.type(null) << ''') «eventVar»[«num»];'''
		}
		if (pattern.guardExpression != null) {
			it << "if (! " methodCall(pattern.guardExpression, it) it << ") return false;"
		}
	}

	def inputPatternVariable(String variable, String varVar, String arrayVar, String channelExpr, String repeatVar, InputPattern pattern, Port port, ITreeAppendable it) {
		val portType = type(port as Typeable)
		val patternType = pattern.type(false, null)
		val variables = pattern.variables
		val groupSize = pattern.size
		val offset = variables.indexOf(variable)
		if (pattern.isRepeat()) {
			val tokensType = portType.jvm2pTokensType(port)
			if (pattern.isMultiport(port)) {
				it -> pattern << patternType << " "
			}
			it << '''«varVar» = '''
			// Tokens subclass constructor or copyInto array call?
			if (portType.isPrimitive) {
				it -> pattern << tokensType << ".copyInto"
			} else {
				it -> pattern << "new " << tokensType
			}
			// common part of argument list
			it << '''(«arrayVar», «groupSize», «offset»'''
			// array argument in copyInto case
			if (portType.isPrimitive) {
				it -> pattern << ", new " << portType << '''[«repeatVar»]'''
			}
			// in the generic case, the class is the last argument of the call, whether copyInto or constructor
			if (portType.is2ObjectTokenType) {
			 	it << ", " << portType.type << ".class"
			} 
			it << ");"
		} else if (variables.size() > 1) {
			if (pattern.isMultiport(port)) {
				it -> pattern << patternType << " "
			}
			it << '''«varVar» = «pattern.tokenValueAccess»(«arrayVar»[«offset»]);'''
		} else {
			it << '''if (! hasToken(«pattern.portAccess», «channelExpr», 1)) return false;'''
			if (pattern.isMultiport(port)) {
				it -> pattern << patternType << " "
			}
			it << '''«varVar» = «pattern.tokenValueAccess»(«pattern.portAccess».get(«channelExpr»));'''
		}
	}

	def tokenValueExpression(String tokenExpression, JvmTypeReference type, EObject context, ITreeAppendable it) {
		val tokenType = type.jvm2pTokenType(context);
		var methodName = tokenType.getSimpleName();
		if (methodName.endsWith(TypeUtil::TOKEN_CLASS_SUFFIX)) {
			methodName = methodName.substring(0, methodName.length() - TypeUtil::TOKEN_CLASS_SUFFIX.length());
		}
		methodName = (if ("Object".equals(methodName)) "get" else methodName.toLowerCase) + "Value"
		// must add cast, of the token type is not specialized to the desired type
		val mustCast = ! type.hasTokenType
		if (mustCast) {
			it -> context << "((" << type << ") "
		}
		it -> context << tokenType << '''.convert(«tokenExpression»).«methodName»()'''
		if (mustCast) {
			it << ")"
		}
	}

	def attributeValueExpression(String valueExpression, JvmTypeReference type, EObject context, ITreeAppendable it) {
		//
	}

	def void generatePatternOutputPart(OutputPattern pattern, String delayVar, ITreeAppendable it) {
		val repeatVar = if (pattern.isRepeat()) it.declareSyntheticVariable(pattern, "_repeat") else null
		if (repeatVar != null) {
			it << '''int «repeatVar»''' << " = " methodCall(pattern.repeatExpression, it) it << ";"
		}
		val port = pattern.portRef
		val widthVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Width")
		val channelsVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Channels")
		val isMultiport = pattern.isMultiport(port)
		if (isMultiport) {
			it << '''int «widthVar» = «pattern.portAccess».getWidth();'''
			generateChannelsList(pattern, channelsVar, repeatVar, widthVar, it)
		}
		val channelVar = if (isMultiport) it.declareSyntheticVariable(pattern, "_" + port.name + "Channel") else "0"
		if (isMultiport) {
			it << '''for (int «channelVar» : «channelsVar») {'''
			it << '''if («channelVar» < 0 || «channelVar» >= «widthVar») continue;'''
		}
		if (pattern.guardExpression != null) {
			it << "if (" methodCall(pattern.guardExpression, it) it << ") {"
		}
		outputPatternValue(delayVar, channelVar, repeatVar, pattern, it);
		if (pattern.guardExpression != null) {
			it << "}";
		}
		if (isMultiport) {
			it << "}"
		}
	}
	
	def methodCall(String methodName, JvmExecutable method, ITreeAppendable it) {
		it << methodName << "(" << method.parameters.map[simpleName].join(", ") << ")"
	}

	@Inject extension JvmModelAssociator

	def methodCall(XExpression expression, ITreeAppendable it) {
		val container = expression.logicalContainer
		if (container instanceof JvmOperation) {
			val method = (container as JvmOperation)
			methodCall(method.simpleName, method, it)
		}
	}

	def indexedName(String name, EObject child) {
		if (child.eContainingFeature.many) name + (child.eContainer().eGet(child.eContainingFeature) as List<?>).indexOf(child) else name
	}

	def patternMethodName(PortPattern pattern, JvmExecutable actionMethod, String suffix, EObject child) {
		indexedName(indexedName(actionMethod.simpleName + "Pattern", pattern) + suffix, child)
	}
	
	def outputPatternValue(String delayVar, String channelExpr, String repeatVar, OutputPattern pattern, ITreeAppendable it) {
		val port = pattern.portRef
		val portType = type(port as Typeable)
		val tokenType = portType.jvm2pTokenType(port);
		val multiport = pattern.isMultiport(port)
		var valVars = new ArrayList<String>()
		val valueExpressions = pattern.valueExpressions
		for (valueExpression : valueExpressions) {
			val valVar = it.declareSyntheticVariable(pattern, "_" + "value")
//			valueExpression.toJavaStatement(it, true) newLine
			val varType = if (pattern.isRepeat && (! portType.isPrimitive)) pattern.newTypeRef(Iterator, portType) else pattern.type(false, null)
			it -> pattern << varType << ''' «valVar»''' << " = "; // << valueExpression
//			methodCall(patternMethodName(pattern, actionMethod, "Output", valueExpression), actionMethod, it)
			methodCall(valueExpression, it)
			if (multiport) {
				it << '''.get(«channelExpr»)'''
			}
			if (pattern.isRepeat() && (! portType.isPrimitive)) {
				it << ".iterator()"
			}
			it << ";"
			valVars += valVar
		}
		if (pattern.isRepeat()) {
			val arrayVar = it.declareSyntheticVariable(pattern, "_" + "tokenArray")
			it -> pattern << tokenType << '''[] «arrayVar» = new ''' << tokenType << '''[«valueExpressions.size()» * «repeatVar»];'''
			val forVar = it.declareSyntheticVariable(pattern, "_" + "token")
			it << '''for (int «forVar» = 0; «forVar» < «repeatVar»; «forVar»++) {'''
			for (valueExpression : valueExpressions) {
				val pos = valueExpressions.indexOf(valueExpression)
				it << '''«arrayVar»[«forVar» * «pattern.size()» + «pos»] = «pattern.createTokenAccess»('''
				if (portType.isPrimitive) {
					it << '''«valVars.get(pos)»[«forVar»]'''
				} else {
					it << '''«valVars.get(pos)».next()'''
				}
				it << ");"
			}
			it << "}"
			it << '''send(«pattern.portAccess», «channelExpr», «arrayVar», «delayVar ?: "-1"»);'''
		} else if (valueExpressions.size() > 0) {
			val needsArray = valueExpressions.size() > 1
			var needsSeparator = false
			it << '''send(«pattern.portAccess», «channelExpr», '''
			if (needsArray) {
				it -> pattern << "new " << tokenType << "[]{"
			}
			for (valVar : valVars) {
				it << (if (needsSeparator) ", ") << '''«pattern.createTokenAccess»(''' << valVar << ")"
				needsSeparator = true
			}
			it << (if (needsArray) "}") << ", " << (delayVar ?: "-1") << ");"
		}
	}
	
	//

	def Iterable<Pair<String, JvmTypeReference>> getProperties(JvmDeclaredType type, String name) {
		val setters = new ArrayList<JvmOperation>
		val getters = new ArrayList<JvmOperation>
		val properties = new ArrayList<Pair<String, JvmTypeReference>>
		for (JvmOperation op : type.allFeatures.filter(JvmOperation)) {
			if (if (name == null) op.setterPropertyName != null else name.equals(op.setterPropertyName)) {
				setters += op
			} else if (if (name == null) op.getterPropertyName != null else name.equals(op.getterPropertyName)) {
				getters += op
			}
		}
		for (JvmOperation setter : setters) {
			val getter = getters.findFirst[ isGetterFor(setter) ]
			if (getter != null) {
				properties += getter.getterPropertyName -> getter.returnType
			}
		}
		properties
	}
	
	def Pair<String, JvmTypeReference> getProperty(JvmDeclaredType type, String propertyName) {
		getProperties(type, propertyName).head
	}
	def Pair<String, JvmTypeReference> getProperty(JvmTypeReference typeRef, String eventName) {
		if (typeRef.type instanceof JvmDeclaredType)
			getProperty(typeRef.type as JvmDeclaredType, eventName)
		else null
	}

	def accessorName(String name, String prefix, String suffix) {
		if (name.startsWith(prefix) && name.length > prefix.length && Character::isUpperCase(name.charAt(prefix.length)) && (suffix == null || name.endsWith(suffix))) {
			return name.substring(prefix.length, name.length - if (suffix != null) suffix.length else 0).toFirstLower
		}
		return null
	}

	def isAccessorName(String name, String prefix, String suffix) {
		accessorName(name, prefix, suffix) != null
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

	def listenerAdderName(String eventName) { "add" + eventName.toFirstUpper + "Listener" }
	def listenerAdderName(JvmOperation op) {
		if (op.parameters.size == 1) accessorName(op.simpleName, "add", "Listener") else null  
	}

	def listenerRemoverName(String eventName) 	{ "remove" + eventName.toFirstUpper + "Listener" }
	def listenerRemoverName(JvmOperation op) {
		if (op.parameters.size == 1) accessorName(op.simpleName, "remove", "Listener") else null 
	}
	
	def isListenerRemoverFor(JvmOperation op, JvmOperation adder) {
		op.listenerRemoverName.equals(adder.listenerAdderName) && op.parameters.head.parameterType.qualifiedName.equals(adder.parameters.head.parameterType.qualifiedName)
	}
}
