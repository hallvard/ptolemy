package org.ptolemy.xtext.generator

import org.ptolemy.ecore.kernel.Port
import org.ptolemy.ecore.actor.AbstractIOPort
import org.ptolemy.ecore.actor.Typeable
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.common.types.util.TypeReferences
import org.ptolemy.ecore.caltrop.PortPattern
import org.ptolemy.ecore.caltrop.InputPattern
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import java.util.ArrayList
import org.ptolemy.ecore.caltrop.ChannelSelector
import org.ptolemy.ecore.caltrop.KeywordChannelSelector
import org.ptolemy.ecore.caltrop.ChannelSelectorKeyword
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector
import org.ptolemy.ecore.caltrop.OutputPattern
import java.util.Iterator
import org.ptolemy.ecore.kernel.Nameable
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.ptolemy.ecore.actor.Variable
import org.ptolemy.ecore.kernel.Entity

class ActionPatternHelper {
	
    @Inject extension JvmTypesBuilder
	@Inject extension TypeReferences
	@Inject extension TypeUtil

	def isTokenVariable(EObject eObject) {
		eObject instanceof Variable && eObject.eContainer() instanceof Entity<?>
	}

    def isMultiport(PortPattern pattern, Port port) {
    	port instanceof AbstractIOPort && (port as AbstractIOPort).multiport && pattern.channels != null
    }

    def isRepeat(PortPattern pattern) {
		pattern.repeatExpression != null
    }

	def toImplType(JvmTypeReference typeRef) {
		val typeParameterMapper = new ReferenceMapper(typeof(JvmTypeParameter))
		val copy = typeParameterMapper.copy(typeRef) as JvmTypeReference
		typeParameterMapper.copyReferences
		copy
	}
	
	def methodName(Nameable named, String format) {
		String::format(format, named.name.toFirstUpper)
	}
	
	def type(PortPattern pattern, JvmTypeReference elementType, boolean multi, Boolean impl) {
		val type = if (elementType != null) elementType else typeof(Object).getTypeForName(pattern)
    	var implType = toImplType(type)
    	if (pattern.isRepeat()) {
    		if (implType.isPrimitive) {
	    		implType = createArrayType(type)
    		} else {
    			implType = pattern.newTypeRef(typeof(Iterable), type)
    		}
    	}
    	if (multi) {
//    		var innerType = typeof(Iterable) as Class<? extends Iterable>
//    		if (impl != null) {
//	    		innerType = if (impl) typeof(ArrayList) else typeof(List)
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
			context.newTypeRef(typeof(Iterable), context.newTypeRef(typeof(Integer)))
		else
			context.newTypeRef(typeof(int))
	}

	def type(PortPattern pattern, Port port, Boolean impl) {
		pattern.type(type(port as Typeable), pattern.isMultiport(port), impl)
	}

	@Inject extension TreeAppendableUtil
	@Inject extension XbaseCompiler
	
	def boolean isChannelSelectorKeyword(ChannelSelector channelSelector, ChannelSelectorKeyword keyword) {
		channelSelector instanceof KeywordChannelSelector && (channelSelector as KeywordChannelSelector).keyword == keyword
	}

	def requiredChannelCount(ChannelSelector channelSelector) {
		if (channelSelector instanceof ExpressionChannelSelector)
			(channelSelector as ExpressionChannelSelector).keyExpressions.size()
		else
			1
	}

	def generateChannelsList(PortPattern pattern, Port port, String channelsVar, String repeatVar, String widthVar, ITreeAppendable it) {
		val countArg = pattern.size() + " * " + (if (repeatVar != null) repeatVar else "1")
		val channels = pattern.channels
		val anyArg = channels.isChannelSelectorKeyword(ChannelSelectorKeyword::ANY)
		switch (channels) {
			KeywordChannelSelector: {
				it -> port << port.channelsInternalType << ''' «channelsVar» = channels(this.«port.name», «countArg», «anyArg», «widthVar»);'''
			}
			ExpressionChannelSelector: {
				val channelVars = new ArrayList<String>()
				for (expression : channels.keyExpressions) {
					expression.toJavaStatement(it, true) newLine
					val channelVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Channel")
					it -> port << port.channelsType(channels.many) << ''' «channelVar» = ''' << expression << ";"
					channelVars += channelVar
				}
				it -> port << port.channelsInternalType << ''' «channelsVar» = channels(this.«port.name», «countArg», «anyArg», '''
				if (channels.many) {
					// needed because the channels type is parameterized and we cannot create an array of such a type 
					it << channelVars.join(", ") << ");"
				} else {
					it -> port << "new " << port.channelsType(false) << "[]{" << channelVars.join(", ") << "});"
				}
			}
		}
	}

	def void generatePatternMatchPart(InputPattern pattern, Port port, ITreeAppendable it) {
		val repeatVar = (if (pattern.isRepeat()) it.declareSyntheticVariable(pattern, "_" + port.name + "Repeat") else "1")
		if (pattern.isRepeat()) {
			pattern.repeatExpression.toJavaStatement(it, true) newLine
			it << '''int «repeatVar»''' << " = " << pattern.repeatExpression << ";"
		}
		val isMultiport = pattern.isMultiport(port)
		val widthVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Width")
		val channelsVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Channels")
		if (isMultiport) {
			it << '''int «widthVar» = this.«port.name».getWidth();'''
			generateChannelsList(pattern, port, channelsVar, repeatVar, widthVar, it)
			it << '''if («channelsVar» == null || «channelsVar».length == 0) return false;'''
			for (variable : pattern.variables) {
				it -> pattern << pattern.type(port, null) << ''' «variable» = channelMap(«channelsVar»);'''
			}
		}
		val channelVar = if (isMultiport) it.declareSyntheticVariable(pattern, "_" + port.name + "Channel") else "0"
		if (isMultiport) {
			it << '''for (int «channelVar» : «channelsVar») {'''
		}
		val arrayVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Array")
		if (pattern.isRepeat() || pattern.size() > 1) {
			it << '''if (! this.«port.name».hasToken(«channelVar», «repeatVar» * «pattern.size()»)) return false;'''
			it -> pattern << "ptolemy.data.Token" << '''[] «arrayVar» = this.«port.name».get(«channelVar», «repeatVar» * «pattern.size()»);'''
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
	}

	def inputPatternVariable(String variable, String varVar, String arrayVar, String channelExpr, String repeatVar, InputPattern pattern, Port port, ITreeAppendable it) {
		val portType = type(port as Typeable)
		val patternType = pattern.type(type(port as Typeable), false, null)
		val variables = pattern.variables
		val groupSize = pattern.size
		val offset = variables.indexOf(variable)
		if (pattern.isRepeat()) {
			val tokensType = portType.jvm2pTokensType(port)
			it -> pattern << patternType << ''' «varVar» = '''
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
			 	it -> pattern << ", " << portType << ".class"
			} 
			it << ");"
		} else if (variables.size() > 1) {
			it -> pattern << patternType << ''' «varVar» = '''
			it << '''getActor().«port.methodName("get%sTokenValue")»(«arrayVar»[«offset»])'''
			it << ";"
		} else {
			it << '''if (! this.«port.name».hasToken(«channelExpr»)) return false;'''
			it -> pattern << patternType << ''' «varVar» = '''
			it << '''getActor().«port.methodName("get%sTokenValue")»(this.«port.name».get(«channelExpr»))'''
			it << ";"
		}
	}

	def tokenValueExpression(String tokenExpression, JvmTypeReference type, EObject context, ITreeAppendable it) {
		val tokenType = type.jvm2pTokenType(context);
		var methodName = tokenType.getSimpleName();
		if (methodName.endsWith(TypeUtil::TOKEN_CLASS_SUFFIX)) {
			methodName = methodName.substring(0, methodName.length() - TypeUtil::TOKEN_CLASS_SUFFIX.length());
		}
		methodName = (if ("Object".equals(methodName)) "get" else methodName.toLowerCase) + "Value"
		// must add case, of the token type is not specialized to the desired type
		val mustCast = ! type.hasTokenType
		if (mustCast) {
			it -> context << "((" << type << ") "
		}
		it -> context << tokenType << '''.convert(«tokenExpression»).«methodName»()'''
		if (mustCast) {
			it << ")"
		}
	}
	
	def void generatePatternOutputPart(OutputPattern pattern, Port port, ITreeAppendable it) {
		val repeatVar = if (pattern.isRepeat()) it.declareSyntheticVariable(pattern, "_repeat") else null
		if (repeatVar != null) {
			pattern.repeatExpression.toJavaStatement(it, true) newLine
			it << '''int «repeatVar»''' << " = " << pattern.repeatExpression << ";"
		}
		val widthVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Width")
		val channelsVar = it.declareSyntheticVariable(pattern, "_" + port.name + "Channels")
		val isMultiport = pattern.isMultiport(port)
		if (isMultiport) {
			it << '''int «widthVar» = this.«port.name».getWidth();'''
			generateChannelsList(pattern, port, channelsVar, repeatVar, widthVar, it)
		}
		val channelVar = if (isMultiport) it.declareSyntheticVariable(pattern, "_" + port.name + "Channel") else "0"
		if (isMultiport) {
			it << '''for (int «channelVar» : «channelsVar») {'''
			it << '''if («channelVar» < 0 || «channelVar» >= «widthVar») continue;'''
		}
		outputPatternValue(channelVar, repeatVar, pattern, port, it);
		if (isMultiport) {
			it << "}"
		}
	}
	
	def outputPatternValue(String channelExpr, String repeatVar, OutputPattern pattern, Port port, ITreeAppendable it) {
		val portType = type(port as Typeable)
		val tokenType = portType.jvm2pTokenType(port);
		val multiport = pattern.isMultiport(port)
		val patternType = pattern.type(portType, false, null)
		var valVars = new ArrayList<String>()
		val valueExpressions = pattern.valueExpressions
		for (valueExpression : valueExpressions) {
			val valVar = it.declareSyntheticVariable(pattern, "_" + "value")
			valueExpression.toJavaStatement(it, true) newLine
			val varType = if (pattern.isRepeat && (! portType.isPrimitive)) port.newTypeRef(typeof(Iterator), portType) else patternType
			it -> pattern << varType << ''' «valVar»''' << " = " << valueExpression
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
				it << '''«arrayVar»[«forVar» * «pattern.size()» + «pos»] = getActor().«port.methodName("create%sToken")»('''
				if (portType.isPrimitive) {
					it << '''«valVars.get(pos)»[«forVar»]'''
				} else {
					it << '''«valVars.get(pos)».next()'''
				}
				it << ");"
			}
			it << "}"
			it << '''this.«port.name».send(«channelExpr», «arrayVar», «arrayVar».length);'''
//			it << '''getActor().«port.methodName("send%sTokens")»(«channelExpr», «arrayVar»);'''
		} else if (valueExpressions.size() > 0) {
			val needsArray = valueExpressions.size() > 1
			var needsSeparator = false
			it << '''this.«port.name».send(«channelExpr», '''
//			it << '''getActor().«port.methodName("send%sToken" + if (needsArray) "s" else "")»(«channelExpr», '''
			if (needsArray) {
				it -> pattern << "new " << tokenType << "[]{"
			}
			for (valVar : valVars) {
				it << (if (needsSeparator) ", ") << '''getActor().«port.methodName("create%sToken")»(''' << valVar << ")"
				needsSeparator = true
			}
			it << (if (needsArray) '''}, «valVars.size()»''') << ");"
//			it << (if (needsArray) "}") << ");"
		}
	}
}
