package org.ptolemy.xtext.generator

import com.google.common.collect.Iterables
import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.ptolemy.ecore.actor.AbstractIOPort
import org.ptolemy.ecore.actor.AtomicActorImpl
import org.ptolemy.ecore.actor.InjectableAttribute
import org.ptolemy.ecore.actor.JvmTypedObj
import org.ptolemy.ecore.actor.Parameter
import org.ptolemy.ecore.actor.Typeable
import org.ptolemy.ecore.actor.Variable
import org.ptolemy.ecore.caltrop.CaltropActorImpl
import org.ptolemy.ecore.caltrop.EventAction
import org.ptolemy.ecore.caltrop.EventPattern
import org.ptolemy.ecore.caltrop.OutputAction
import org.ptolemy.ecore.caltrop.PortPattern
import org.ptolemy.ecore.caltrop.ReAction
import org.ptolemy.ecore.caltrop.State
import org.ptolemy.ecore.caltrop.StateVariable
import org.ptolemy.ecore.kernel.Attribute
import org.ptolemy.ecore.kernel.EntityContainer
import org.ptolemy.ecore.kernel.IEntity
import org.ptolemy.ecore.kernel.Named
import org.ptolemy.ecore.kernel.Port
import org.ptolemy.xtext.jvmmodel.XActorJvmModelInferrer

class XActorGenerator extends JvmModelGenerator {

	@Inject extension IJvmModelAssociations
	@Inject extension ILogicalContainerProvider
    @Inject extension TypeReferences
    @Inject extension JvmTypesBuilder
	@Inject extension XActorJvmModelInferrer
	@Inject extension XbaseCompiler
	@Inject extension TypeUtil
	@Inject IGeneratorConfigProvider generatorConfigProvider;

	override dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		val content = type.generateType(generatorConfigProvider.get(type))
		if (content != null) {
			fsa.generateFile(type.qualifiedName.replace('.','/') + ".java", content)
		}
	}
	
	override CharSequence generateType(JvmDeclaredType type, GeneratorConfig genConfig) {
		val sourceElement = type.primarySourceElement
		if (sourceElement instanceof Named) { // && (! (sourceElement as Entity).isAbstract())) {
			return super.generateType(type, genConfig)
		}
		return null;
	}

	override ITreeAppendable _generateMember(JvmField it, ITreeAppendable appendable, GeneratorConfig genConfig) {
		var field = it
		val sourceElement = primarySourceElement
		// change the types of token variables to Parameter
		if (sourceElement.isTokenVariable) {
			field = EcoreUtil::copy(it)
			field.type = sourceElement.newTypeRef("ptolemy.data.expr.Variable")
			field.final = true
		} else if (sourceElement.isInjectedValue) {
			field = EcoreUtil::copy(it)
			field.final = false
		}
		return super._generateMember(field, appendable, genConfig)
	}

	@Inject extension TreeAppendableUtil
	@Inject extension ActionPatternHelper

	def pAttributeType(Attribute attribute) {
		attribute.newTypeRef("ptolemy.data.expr." + if (attribute instanceof Parameter) "Parameter" else "Variable")
	}

	def void generateCreateAttributeMethodBody(Attribute attribute, String varName, ITreeAppendable it) {
		val typeRef = attribute.pAttributeType
		it -> attribute << typeRef << " ";
		if (attribute instanceof Variable) {
			it -> attribute << '''«varName» = new ''' << typeRef << '''(this, "«attribute.name»");'''
		}
		if (attribute instanceof Typeable) {
			it << '''«varName».setTypeEquals('''
			appendPTypeExpression(attribute as Typeable, it)
			it << ");"
		}
		it << '''return «varName»;'''
	}

	def appendPTypeExpression(Typeable typed, ITreeAppendable it) {
		val type = type(typed)
		val simpleName = type.jvm2pTypeSimpleName
		if (simpleName != null) {
			it << TypeUtil::TOKEN_CONST_PREFIX << simpleName.toUpperCase
		}
		else {
			it -> typed << '''new «TypeUtil::TYPE_PACKAGE_PREFIX»ObjectType(''' << type.type << ".class)"
//			val qName = type.qualifiedName
//			val pos = qName.indexOf("<")
//			(if (pos < 0) qName else qName.substring(0, pos)) + ".class"
		}
	}

	def void generateInitAttributeMethodBody(InjectableAttribute injectable, String varName, ITreeAppendable it) {
		//
	}

	def void generateInitAttributeMethodBody(Variable variable, XExpression expression, String varName, ITreeAppendable it) {
		if (expression != null) {
			expression.toJavaStatement(it, true); it << '\n'
		}
		it << if (varName != null) '''«varName».setToken(«variable.methodName("_create%sToken")»(''' else "return "
		generateVariableInitExpression(expression, variable.type, it)
		it << (if (varName != null) "))") << "; "
	}
	def void generateSetVariableValueMethodBody(Variable variable, ITreeAppendable it) {
		it << '''this.«variable.name».setToken(«variable.methodName("_create%sToken")»(«variable.name»));'''
	}

	def void generateCreatePortMethodBody(Port port, String name, String varName, ITreeAppendable it) {
		it -> port << "ptolemy.actor.TypedIOPort" << ''' «varName» = new ''' << "ptolemy.actor.TypedIOPort" << '''(this, "«if (name != null) name else port.name»"'''
		if (port instanceof AbstractIOPort) {
			val ioPort = port as AbstractIOPort
			it << ''', «ioPort.input», «ioPort.output»'''
		}
    	it << ");"
    	if (port instanceof AbstractIOPort) {
			it << '''«varName».setMultiport(«(port as AbstractIOPort).multiport»);'''
		}
		it << '''«varName».setTypeEquals('''
		appendPTypeExpression(port as Typeable, it)
		it << ");"
    	if (port instanceof AbstractIOPort && (port as AbstractIOPort).rate >= 0) {
    		val ioPort = (port as AbstractIOPort)
			if (ioPort.input) {
				addRateParameter(port, varName, "consumption", ioPort.rate, it)
			}
			if (ioPort.output) {
				addRateParameter(port, varName, "production", ioPort.rate, it)
			}
		}
		it << '''return «varName»;'''
	}

	def void generateSyntheticCreatePortMethodBody(Typeable typed, String name, String methodName, String varName, ITreeAppendable it) {
		it -> typed << "ptolemy.actor.TypedIOPort" << ''' «varName» = super.«methodName»();''';
		it << '''«varName».setTypeEquals('''
		appendPTypeExpression(typed, it)
		it << ");"
		it << '''return «varName»;'''
	}

	def void generateCreateEntityMethodBody(Named named, String name, String varName, JvmTypeReference typeRef, ITreeAppendable it) {
		it -> named << typeRef << " ";
		val altName = if (name != null) name else named.name
		val altVarName = (if (varName != null) varName else altName)
		it -> named << altVarName << " = new " << typeRef << '''(this, "«altName»");'''
		it << '''return «altVarName»;'''
	}

	def void generateCreateTokenMethodBody(String valueExpr, JvmTypedObj jvmTyped, ITreeAppendable it) {
		val portType = type(jvmTyped)
		val tokenType = portType.jvm2pTokenType(jvmTyped)
		it -> jvmTyped << "return new " << tokenType << '''(«valueExpr»'''
		if (portType.is2ObjectTokenType) {
		 	it << ", " << portType.type << ".class"
		}
		it << ");"
	}

	def void generateGetTokenValueMethodBody(String valueExpr, JvmTypedObj jvmTyped, ITreeAppendable it) {
		it << "return "
		tokenValueExpression(valueExpr, type(jvmTyped), jvmTyped, it)		
		it << "; "
	}

	def void generateGetAttributeValueMethodBody(String valueExpr, JvmTypedObj jvmTyped, ITreeAppendable it) {
		it << "return "
		attributeValueExpression(valueExpr, type(jvmTyped), jvmTyped, it)		
		it << "; "
	}
	
//	def void generateSendTokenMethodBody(JvmTypedObj jvmTyped, String channelExpr, boolean array, ITreeAppendable it) {
//		it << '''send(this.«jvmTyped.name», «channelExpr», «jvmTyped.name»'''
//		if (array) {
//			it << ''', «jvmTyped.name».length'''
//		}
//		it << ");"
//	}

	def void generateActorConstructorBody(IEntity<? extends Port> entity, JvmExecutable op, ITreeAppendable it) {
		it << "super(parent, name);"
		for (attribute : entity.attributes) {
			it << '''this.«attribute.name» = «attribute.methodName("_create%sAttribute")»();'''
		}
		for (port: entity.ports) {
			it << '''this.«port.name» = «port.methodName("_create%sPort")»();'''
		}

		if (entity instanceof EntityContainer<?>) {
			val composite = (entity as EntityContainer<?>)
			for (child : composite.entities) {
				it << '''this.«child.name» = «child.methodName("_create%sEntity")»();'''
			}
			for (relation : composite.relations) {
				if (relation.isConversionRelation) {
					val name = relation.indexedFeatureName
					it << '''this.«name» = _create«name.toFirstUpper»Entity();'''
				}
			}
			val Map<Port, String> portRelations = new HashMap<Port, String>()
			for (relation : composite.relations) {
				val port = relation.sourcePort
				var relationName = portRelations.get(port)
				if (relationName == null) {
					it -> relation << "ptolemy.actor.TypedIORelation" << ''' «relation.name» = new ''' << "ptolemy.actor.TypedIORelation" << '''(this, "«relation.name»");'''
					relationName = relation.name
					portRelations.put(port, relationName)
					it << '''this.«port.container.name».getPort("«port.name»").link(«relationName»);'''
				}
				if (relation.isConversionRelation) {
					it << '''this.«relation.indexedFeatureName».getPort("input").link(«relationName»);'''
					relationName = relation.indexedFeatureName
					it -> relation << "ptolemy.actor.TypedIORelation" << ''' «relationName» = new ''' << "ptolemy.actor.TypedIORelation" << '''(this, "«relationName»");'''
					it << '''this.«relationName».getPort("output").link(«relationName»);'''
				}
				for (targetPort : relation.targetPorts) {
					it << '''this.«targetPort.container.name».getPort("«targetPort.name»").link(«relationName»);'''
				}
			}
		}
//		else if (! op.containerType.isAbstract) {
//			it << '''this._impl = new «op.containerType.simpleName»Impl(this'''
//			it << entity.actorImplConstructorParameters.join(", ", ", ", "") [simpleName]
//			it << "); "
//		}
		for (attribute : entity.attributes) {
			it << '''«attribute.methodName("_set%sValue")»(«attribute.methodName("_initial%sAttributeValue")»());'''
		}
	}
	
	def void addRateParameter(Port port, String varName, String rateKind, int rate, ITreeAppendable it) {
		var paramName = "token" + rateKind.toFirstUpper + "Rate"
		it -> port << '''new ''' << "ptolemy.data.expr.Parameter" << '''(«if (varName != null) varName else port.name», "«paramName.toFirstLower»", new ''' << "ptolemy.data.IntToken" << '''(«rate»));'''
	}
  
	def void generateActorImplConstructorBody(IEntity<? extends Port> entity, JvmExecutable op, ITreeAppendable it) {
		val implClass = op.containerType as JvmDeclaredType
		val actorParameter = op.parameters.head
		var fieldParameters = (op.parameters as Iterable<JvmFormalParameter>).tail
		val fields = implClass.members.filter(JvmField)
		val inheritedParameters = fieldParameters.filter[parameter | ! fields.exists[simpleName.equals(parameter.simpleName)]]
		val superArguments = new ArrayList<JvmFormalParameter>()
		superArguments += actorParameter
		superArguments += inheritedParameters
		it << '''super(«superArguments.join(", ")[simpleName]»);'''
		if (fields.exists[simpleName.equals(actorParameter.simpleName)]) {
			it << '''this.«actorParameter.simpleName» = «actorParameter.simpleName»;'''
		}
		for (parameter : fieldParameters) {
			if (! superArguments.contains(parameter)) {
				it << '''this.«parameter.simpleName» = «parameter.simpleName»;'''
			}
		}
	}

	def void generateInitializeBody(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super.initialize(); "
	}
	def void generatePrefireBody	(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "return super.prefire(); "
	}
	def void generateFireBody		(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super.fire(); "
	}
	def void generatePostfireBody	(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "return super.postfire(); "
	}

	def previousValueName(StateVariable variable) {
		val name = variable.name
		return if (variable.constant) name else "old_" + name
	}

	def indexedFeatureName(EObject named) {
		indexedName(named.eContainingFeature.name, named)
	}

	def String actionRef(OutputAction action) {
		val actorImpl = action.eContainer as CaltropActorImpl<?>
		var actionNum = actorImpl.initActions.indexOf(action)
		if (actionNum < 0) {
			actionNum = actorImpl.initActions.size() + actorImpl.actions.indexOf(action)
		}
		'''_actionImpls[«actionNum»]'''
	}

	def void generateInitializeImplBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmGenericType implClass, ITreeAppendable it) {
		it << "super._initializeImpl();"
		for (declaration : impl.declarations) {
			val name = declaration.previousValueName
			it <<'''this.«name» = «if (declaration.valueExpression != null) '''«declaration.methodName("_initial%sStateVariableValue")»()''' else defaultValue(declaration.type)»;'''
			it << '''«declaration.methodName("_postChange%sState")»(this.«name»);'''
 		}
		it << '''«FOR action : impl.initActions SEPARATOR("else ")»
		if («actionRef(action)».match()) {
			«actionRef(action)».body();
			«actionRef(action)».output();
		}
		«ENDFOR»'''
		
		if (impl.schedule != null) {
			it << '''currentState = «impl.schedule.states.indexOf(impl.schedule.initial)»;'''
		}
	}

	def generateActionImplsInitializer(EObject context, JvmGenericType implClass, JvmTypeReference superType, ITreeAppendable it) {
		it -> context << '''new ''' << superType << "[]{"
		for (classMember : implClass.members.filter(JvmDeclaredType)) {
			if (superType.qualifiedName.equals(classMember.superTypes.head.qualifiedName)) {
				it << '''new «classMember.simpleName»(), '''
			}
		}
		it << "}"
	}
	
	def generateInitStateVariableMethodBody(StateVariable variable, String varName, ITreeAppendable it) {
		generateExpressionMethodBody(variable.valueExpression, varName, variable.type, it)
	}

	def declareThisVariables(JvmMember actionClass, ITreeAppendable it) {
		it.declareVariable(actionClass, "this")
		val outerClass = actionClass.declaringType
		if (outerClass != null) {
			it.declareVariable(outerClass, outerClass.simpleName + ".this")
		}
	}

	def generateExpressionMethodBody(XExpression expression, String varName, JvmTypeReference type, ITreeAppendable it) {
		if (expression != null) {
			val container = expression.logicalContainer
			declareThisVariables(container.eContainer() as JvmGenericType, it)
			expression.toJavaStatement(it, true);
		}
		it << if (varName != null) '''«varName» = ''' else "return "
		generateVariableInitExpression(expression, type, it)
		it << "; "
	}

	def generateVariableInitExpression(XExpression expr, JvmTypeReference type, ITreeAppendable it) {
		if (expr != null) {
			it << expr
		} else {
			it << defaultValue(type)
		}
	}

	def void generateFireImplBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmOperation op, ITreeAppendable it) {
		val returnVar = declareSyntheticVariable(impl, "result")
		it -> impl << op.returnType << ''' «returnVar» = super.«op.simpleName»();'''
		it << '''if («returnVar» != null) return «returnVar»;'''
		for (declaration : impl.declarations) {
			if (! declaration.constant) {
				it << '''this.«declaration.name» = this.«declaration.previousValueName»;'''
			}
		}
		if (impl.schedule != null) {
			val states = impl.schedule.states
			it << "switch (currentState) {"
			for (state : states) {
				it << '''case «states.indexOf(state)»:''' newLine
				generateStateMatchBody(state, impl.actions, op, it)
				it << "break;"
			}
			it << "}"
		} else {
			generateStateMatchBody(impl, impl.actions, -1, it)
		}
		it << "return null;"
	}
	
	def generateStateMatchBody(State state, Iterable<? extends OutputAction> actions, JvmExecutable operation, ITreeAppendable it) {
		for (transition : state.transitions) {
			generateStateMatchBody(state, actions.filter[name == null || transition.tags.accepts(name)], state.schedule.states.indexOf(transition.target), it)
		}
	}

	def boolean accepts(Iterable<String> tags, String actionName) {
		for (tag : tags) {
			if (actionName.startsWith(tag) && (actionName.length() == tag.length() || actionName.charAt(tag.length()) == '.')) {
				return true;
			}
		}
		return false;
	}

	def generateStateMatchBody(EObject context, Iterable<? extends OutputAction> actions, int targetStateNum, ITreeAppendable it) {
		val pairType = findDeclaredType("org.ptolemy.xtext.lib.caltrop.Pair", context)
		for (action : actions) {
			it << '''if («actionRef(action)».match()) return new ''' << pairType << '''.Impl(«targetStateNum», «actionRef(action)»);'''
		}
	}
	
	def <T> int indexOf(Iterable<? extends T> col, T element) {
		return Iterables::indexOf(col)[it == element]
	}

	def Iterable<EventPattern> eventPatternsForVariable(Iterable<ReAction> actions, StateVariable declaration) {
		actions.filter(EventAction).map[eventPatterns.filter[varRef == declaration]].flatten
	}

	def eventPatternListenerName(EventPattern eventPattern) {
		indexedName(eventPattern.varRef.name, eventPattern.eContainer()) + eventPattern.name.toFirstUpper + "Listener"
	}

	def void generateEventListenerMethodBody(EventPattern eventPattern, JvmOperation op, ITreeAppendable it) {
		val timestampExpression = if (eventPattern.timeExpression != null) '''_timestamp(«op.parameters.head.simpleName»)''' else "0"
		it << '''postEvent(«timestampExpression», «eventPattern.varRef.previousValueName», "«eventPattern.name»", "«op.simpleName»", «op.parameters.join(",") [simpleName]»);'''
	}

	def void generatePreStateVariableChangeBody(StateVariable declaration, CaltropActorImpl<? extends AbstractIOPort> impl, ITreeAppendable it) {
		val variablePatterns = impl.actions.eventPatternsForVariable(declaration)
		if (! variablePatterns.empty) {
			it << '''if («declaration.name» != null) {'''
			for (EventPattern eventPattern : variablePatterns) {
				it << declaration.name << "."
				it << 	if (eventPattern.property) 	'''«listenerRemoverName("propertyChange")»("«eventPattern.name»", «eventPattern.eventPatternListenerName»)'''
						else						'''«listenerRemoverName(eventPattern.name)»(«eventPattern.eventPatternListenerName»)'''
				it << ";"
			}
			it << "}"
		}
	}

	def void generatePostStateVariableChangeBody(StateVariable declaration, CaltropActorImpl<? extends AbstractIOPort> impl, ITreeAppendable it) {
		val variablePatterns = impl.actions.eventPatternsForVariable(declaration)
		if (! variablePatterns.empty) {
			it << '''if («declaration.name» != null) {'''
			for (EventPattern eventPattern : variablePatterns) {
				it << declaration.name << "."
				it << 	if (eventPattern.property) 	'''«listenerAdderName("propertyChange")»("«eventPattern.name»", «eventPattern.eventPatternListenerName»)'''
						else						'''«listenerAdderName(eventPattern.name)»(«eventPattern.eventPatternListenerName»)'''
				it << ";"
			}
			it << "}"
		}
	}

	def void generatePostfireImplBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "if (! super._postfireImpl()) return false;"
		for (declaration : impl.declarations) {
			if (! declaration.constant) {
				it << '''if (this.«declaration.previousValueName» != this.«declaration.name») {'''
					it << '''«declaration.methodName("_preChange%sState")»(this.«declaration.previousValueName»);'''
					it << '''this.«declaration.previousValueName» = this.«declaration.name»;'''
					it << '''«declaration.methodName("_postChange%sState")»(this.«declaration.previousValueName»);'''
				it << "}"
			}
		}
		it << "return true; "
	}

	def void generateWrapupImplBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super._wrapupImpl();"
		for (declaration : impl.declarations) {
			it << '''«declaration.methodName("_preChange%sState")»(this.«declaration.name»);'''
			it <<'''this.«declaration.name» = «defaultValue(declaration.type)»;'''
 		}
	}

	def void generateGetCausalityInterfaceBody(CaltropActorImpl<? extends AbstractIOPort> impl, ITreeAppendable it) {
		it << "return _getCausalityInterface(_actionImpls);"
	}

	def boolean appendInputPatternVariables(OutputAction action, PortPattern upto, ITreeAppendable it, boolean withType, boolean needsSeparatorParam) {
		var needsSeparator = needsSeparatorParam
		for (pattern : action.inputPatterns) {
			if (pattern == upto) {
				return needsSeparator
			}
			val port = pattern.portRef
			for (variable : pattern.variables) {
				if (needsSeparator) {
					it << ", "
				}
				if (withType) {
					it -> port << pattern.type(true) << " "
				}
				it << variable
				needsSeparator = true
			}
		}
		needsSeparator
	}

	def void generateActionMatchBody(OutputAction action, JvmExecutable op, ITreeAppendable it) {
		for (pattern : action.inputPatterns) {
			val port = pattern.portRef
			generatePatternMatchPart(pattern, port, op, it)
		}
		if (action instanceof EventAction) {
			for (pattern : (action as EventAction).eventPatterns) {
				generatePatternMatchPart(pattern, pattern.varRef, op, it)
			}
		}
		declareThisVariables(op.declaringType, it)
		if (action.guardExpression != null) {
			it << "if (! " methodCall(action.guardExpression, it) it << ") return false;"
		}
		it << '''return true; '''
	}

	def void generateActionDoBody(OutputAction action, JvmExecutable op, ITreeAppendable it) {
		declareThisVariables(op.declaringType, it)
		for (declaration : action.attributes.filter(Variable)) {
			if (declaration.valueExpression != null) {
				declaration.valueExpression.toJavaStatement(it, true) newLine
			}
			it -> action << declaration.type << ''' «declaration.name»'''
			if (declaration.valueExpression != null) {
				it << " = " << declaration.valueExpression
			}
			it << ";"
		}
		if (action.bodyExpression != null) {
			action.bodyExpression.toJavaStatement(it, false) newLine
			for (declaration : expressionDeclarations(action.bodyExpression)) {
				it << '''this.«declaration.simpleName» = «declaration.simpleName»;'''
			}
		}
	}

	def void generateActionOutputBody(OutputAction action, ITreeAppendable it) {
		var delayExpr = "-1"
		if (action.delayExpression != null) {
			delayExpr = it.declareSyntheticVariable(action, "_delay")
			it << '''int «delayExpr»''' << " = "
			methodCall(action.delayExpression, it)
			it << ";"
		}
		for (pattern : action.outputPatterns) {
			generatePatternOutputPart(pattern, delayExpr, it)
		}
	}

	def void generateActionUpdateBody(OutputAction action, JvmGenericType implClass, ITreeAppendable it) {
		if (action.updateExpression != null) {
			declareThisVariables(implClass, it)
			action.updateExpression.toJavaStatement(it, true) newLine
			it << "return " << action.updateExpression << ";"
		} else {
			it << "return true;" 
		}
	}
}
