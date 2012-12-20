package org.ptolemy.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.ptolemy.ecore.actor.AtomicActorImpl
import org.ptolemy.ecore.actor.Typeable
import org.ptolemy.ecore.actor.Variable
import org.ptolemy.ecore.caltrop.CaltropActorImpl
import org.ptolemy.ecore.kernel.Entity
import org.ptolemy.ecore.kernel.Port
import org.ptolemy.xtext.jvmmodel.XActorJvmModelInferrer
import org.ptolemy.ecore.actor.Parameter
import org.ptolemy.ecore.actor.AbstractIOPort
import org.ptolemy.ecore.kernel.Attribute
import org.ptolemy.ecore.actor.JvmTypedObj
import org.eclipse.xtext.common.types.JvmFormalParameter
import java.util.ArrayList
import org.ptolemy.ecore.kernel.IEntity
import org.eclipse.xtext.common.types.JvmTypeReference
import org.ptolemy.ecore.kernel.EntityContainer
import org.eclipse.emf.ecore.EObject
import org.ptolemy.ecore.caltrop.OutputAction
import org.eclipse.xtext.xbase.XExpression
import org.apache.log4j.Logger
import org.apache.log4j.Level
import com.google.common.collect.Iterables

class XActorGenerator extends JvmModelGenerator {

	@Inject extension IJvmModelAssociations
    @Inject extension JvmTypesBuilder
	@Inject extension XActorJvmModelInferrer
	@Inject extension XbaseCompiler
	@Inject extension TypeUtil

	override dispatch void internalDoGenerate(JvmGenericType type, IFileSystemAccess fsa) {
		val content = type.generateType
		if (content != null) {
			fsa.generateFile(type.qualifiedName.replace('.','/') + ".java", content)
		}
	}
	
	override CharSequence generateType(JvmDeclaredType type) {
		val sourceElement = type.primarySourceElement
		if (sourceElement instanceof Entity) { // && (! (sourceElement as Entity).isAbstract())) {
			return super.generateType(type)
		}
		return null;
	}

	override boolean _generateMember(JvmField it, ITreeAppendable appendable, boolean first) {
		var field = it
		val sourceElement = primarySourceElement
		// change the types of token variables to Parameter
		if (sourceElement.isTokenVariable) {
			field = EcoreUtil::copy(it)
			field.type = sourceElement.newTypeRef("ptolemy.data.expr.Parameter")
			field.final = true
		}
		return super._generateMember(field, appendable, first)
	}

	@Inject extension TreeAppendableUtil
	@Inject extension ActionPatternHelper

	def pAttributeType(Attribute attribute) {
		attribute.newTypeRef("ptolemy.data.expr." + if (attribute instanceof Parameter) "Parameter" else "Variable")
	}

	def void generateCreateAttributeMethodBody(Attribute attribute, String varName, boolean inline, ITreeAppendable it) {
		val typeRef = attribute.pAttributeType
		if (! inline) {
			it -> attribute << typeRef << " ";
		}
		if (attribute instanceof Parameter) {
			it -> attribute << '''�varName� = new ''' << typeRef << '''(this, "�attribute.name�");'''
		}
		if (attribute instanceof Typeable) {
			it << '''�varName�.setTypeEquals(�(attribute as Typeable).jvm2pType�);'''
		}
		if (! inline) {
			it << '''return �varName�;'''
		}
	}
	def void generateInitAttributeMethodBody(Attribute attribute, String varName, boolean inline, ITreeAppendable it) {
		if (attribute instanceof Variable) {
			val variable = (attribute as Variable)
			generateInitAttributeMethodBody(variable, variable.valueExpression, varName, inline, it)
		}
	}
	def void generateInitAttributeMethodBody(Variable variable, XExpression expression, String varName, boolean inline, ITreeAppendable it) {
		if (expression != null) {
			expression.toJavaStatement(it, true); it << '\n'
		}
		it << if (inline) '''�varName�.setToken(�variable.methodName("create%sToken")�(''' else "return "
//			it << '''�attribute.methodName("create%sToken")�('''
		outputVariableInitExpression(expression, variable.type, it)
//			it << ")"
		it << (if (inline) "))") << "; "
	}
	def void generateSetVariableValueMethodBody(Variable variable, ITreeAppendable it) {
		it << '''this.�variable.name�.setToken(�variable.methodName("create%sToken")�(�variable.name�));'''
	}

	def void generateCreatePortMethodBody(Port port, String varName, boolean inline, ITreeAppendable it) {
		if (! inline) {
			it -> port << "ptolemy.actor.TypedIOPort" << " ";
		}
		it -> port << '''�varName� = new ''' << "ptolemy.actor.TypedIOPort" << '''(this, "�port.name�"'''
		if (port instanceof AbstractIOPort) {
			val ioPort = port as AbstractIOPort
			it << ''', �ioPort.input�, �ioPort.output�'''
		}
    	it << ");"
    	if (port instanceof AbstractIOPort) {
			it << '''�varName�.setMultiport(�(port as AbstractIOPort).multiport�);'''
		}
		it << '''�varName�.setTypeEquals(�(port as Typeable).jvm2pType�);'''
    	if (port instanceof AbstractIOPort && (port as AbstractIOPort).rate >= 0) {
    		val ioPort = (port as AbstractIOPort)
			if (ioPort.input) {
				addRateParameter(port, "consumption", ioPort.rate, it)
			}
			if (ioPort.output) {
				addRateParameter(port, "production", ioPort.rate, it)
			}
		}
		if (! inline) {
			it << '''return �varName�;'''
		}
	}

	def void generateCreateEntityMethodBody(IEntity entity, String varName, JvmTypeReference typeRef, boolean inline, ITreeAppendable it) {
		if (! inline) {
			it -> (entity as EObject) << typeRef << " ";
		}
		it -> (entity as EObject) << varName << " = new " << typeRef << '''(this, "�entity.name�");'''
		if (! inline) {
			it << '''return �varName�;'''
		}
	}

	def void generateCreateTokenMethodBody(String valueExpr, JvmTypedObj jvmTyped, ITreeAppendable it) {
		val portType = type(jvmTyped)
		val tokenType = portType.jvm2pTokenType(jvmTyped)
		it -> jvmTyped << "return new " << tokenType << '''(�valueExpr�);'''
	}

	def void generateGetTokenValueMethodBody(String valueExpr, JvmTypedObj jvmTyped, ITreeAppendable it) {
		it << "return "
		tokenValueExpression(valueExpr, type(jvmTyped), jvmTyped, it)		
		it << "; "
	}
	
	def void generateSendTokenMethodBody(JvmTypedObj jvmTyped, String channelExpr, boolean array, ITreeAppendable it) {
		it << '''this.�jvmTyped.name�.send(�channelExpr�, �jvmTyped.name�'''
		if (array) {
			it << ''', �jvmTyped.name�.length'''
		}
		it << ");"
	}

	def void generateActorConstructorBody(IEntity<? extends Port> entity, JvmExecutable op, ITreeAppendable it) {
		it << "super(parent, name);"
		for (attribute : entity.attributes) {
			it << '''this.�attribute.name� = �attribute.methodName("create%sAttribute")�();'''
		}
		for (port: entity.ports) {
			it << '''this.�port.name� = �port.methodName("create%sPort")�();'''
		}

		if (entity instanceof EntityContainer<?>) {
			val composite = (entity as EntityContainer<?>)
			for (child : composite.entities) {
				it -> entity << '''�child.name� = �entity.methodName("create%sEntity")�();'''
			}
			val relationTypeRef = entity.newTypeRef("ptolemy.kernel.Relation")
			for (relation : composite.relations) {
				it -> relation << '''�relation.name� = new ''' << relationTypeRef << '''("�relation.name�");'''
				it << relation.sourcePort.name << '''.link(�relation.name�);'''
				for (targetPort : relation.targetPorts) {
					it << targetPort.name << '''.link(�relation.name�);'''
				}
			}
		}
		for (attribute : entity.attributes) {
			it << '''�attribute.methodName("set%sValue")�(�attribute.methodName("initial%sAttributeValue")�());'''
		}
		if (! op.containerType.isAbstract) {
			it << '''this._impl = new �op.containerType.simpleName�Impl(this'''
			it << entity.actorImplConstructorParameters.join(", ", ", ", "") [simpleName]
			it << "); "
		}
	}

	def void addRateParameter(Port port, String rateKind, int rate, ITreeAppendable it) {
		var paramName = "token" + rateKind.toFirstUpper + "Rate"
		it -> port << '''new ''' << "ptolemy.data.expr.Parameter" << '''(�port.name�, "�paramName.toFirstLower�", new ''' << "ptolemy.data.IntToken" << '''(�rate�));'''
	}
  
	def void generateActorImplConstructorBody(IEntity<? extends Port> entity, JvmExecutable op, ITreeAppendable it) {
		val implClass = op.containerType as JvmDeclaredType
		val actorParameter = op.parameters.head
		var fieldParameters = (op.parameters as Iterable<JvmFormalParameter>).tail
		val fields = implClass.members.filter(typeof(JvmField))
		val inheritedParameters = fieldParameters.filter[parameter | ! fields.exists[simpleName.equals(parameter.simpleName)]]
		val superArguments = new ArrayList<JvmFormalParameter>()
		superArguments += actorParameter
		superArguments += inheritedParameters
		it << '''super(�superArguments.join(", ")[simpleName]�);'''
		if (fields.exists[simpleName.equals(actorParameter.simpleName)]) {
			it << '''this.�actorParameter.simpleName� = �actorParameter.simpleName�;'''
		}
		for (parameter : fieldParameters) {
			if (! superArguments.contains(parameter)) {
				it << '''this.�parameter.simpleName� = �parameter.simpleName�;'''
			}
		}
	}

	def dispatch void generateInitializeBody(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super.initialize(); "
	}
	def dispatch void generatePrefireBody	(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "return super.prefire(); "
	}
	def dispatch void generateFireBody		(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super.fire(); "
	}
	def dispatch void generatePostfireBody	(AtomicActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "return super.postfire(); "
	}

	def previousValueName(String s) {
		return "old_" + s
	}

	def dispatch void generateInitializeBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super.initialize(); "
		for (declaration : impl.declarations) {
			if (declaration.valueExpression != null) {
				declaration.valueExpression.toJavaStatement(it, true) newLine
			}
			var name = declaration.name
			if (! declaration.constant) {
				name = name.previousValueName
			}
			it <<'''this.�name� = '''
			outputVariableInitExpression(declaration.valueExpression, declaration.type, it)
 			it << ';'
 		}
		it <<
		'''�FOR action : impl.initActions SEPARATOR "else "�
		if (�action.actionMethodName("match")�()) {
			if (_callDoMethod()) _callOutputMethod();
		}
		�ENDFOR�'''
	}

	def outputVariableInitExpression(XExpression expr, JvmTypeReference type, ITreeAppendable it) {
		if (expr != null) {
			it << expr
		} else {
			it << defaultValue(type)
		}
	}

	def dispatch void generatePrefireBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		for (declaration : impl.declarations) {
			if (! declaration.constant) {
				it << '''this.�declaration.name� = �previousValueName(declaration.name)�;'''
			}
		}
		it << "if (super.prefire()) return true;"
		it <<
		'''�FOR action : impl.actions SEPARATOR "else "�
		if (�action.actionMethodName("match")�()) return true;
		�ENDFOR�'''
		it << "return false; "
	}

	def dispatch void generateFireBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		it << "super.fire();"
		it << "return _callDoMethod() && _callOutputMethod(); "
	}

	def dispatch void generatePostfireBody(CaltropActorImpl<? extends AbstractIOPort> impl, JvmExecutable op, ITreeAppendable it) {
		if (impl.declarations.empty) {
			it << "return super.postfire();"
		} else {
			it << "if (! super.postfire()) return false;"
			for (declaration : impl.declarations) {
				if (! declaration.constant) {
					it << '''this.�previousValueName(declaration.name)� = �declaration.name�;'''
				}
			}
			it << "return true; "
		}
	}

	def boolean appendInputPatternVariables(OutputAction action, ITreeAppendable it, boolean withType, boolean needsSeparatorParam) {
		var needsSeparator = needsSeparatorParam
		for (pattern : action.inputPatterns) {
			val port = pattern.portRef
			for (variable : pattern.variables) {
				if (needsSeparator) {
					it << ", "
				}
				if (withType) {
					it -> port << pattern.type(port, true) << " "
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
			generatePatternMatchPart(pattern, port, it)
		}
		if (action.guardExpression != null) {
			action.guardExpression.toJavaStatement(it, true) newLine
			it << "if (! " << action.guardExpression << ") return false;"
		}
		it << '''_setDoMethod("�op.simpleName.replace("Match", "Do")�"'''
		appendInputPatternVariables(action, it, false, true)
		it << ");"
		it << '''return true; '''
	}

	def void generateActionDoBody(OutputAction action, JvmExecutable op, ITreeAppendable it) {
		for (declaration : action.attributes.filter(typeof(Variable))) {
			if (declaration.valueExpression != null) {
				declaration.valueExpression.toJavaStatement(it, true) newLine
			}
			it -> action << declaration.type << ''' �declaration.name�'''
			if (declaration.valueExpression != null) {
				it << " = " << declaration.valueExpression
			}
			it << ";"
		}
		if (action.bodyExpression != null) {
//			Logger::getLogger(typeof(org.eclipse.xtext.xbase.typing.AbstractTypeProvider)).setLevel(Level::DEBUG)
			action.bodyExpression.toJavaStatement(it, false) newLine
		}
		it << '''_setOutputMethod("�op.simpleName.replace("Do", "Output")�"'''
		var needSeparator = appendInputPatternVariables(action, it, false, true)
		for (declaration : expressionDeclarations(action.bodyExpression)) { // action.attributes.filter(typeof(Variable))
			it << (if (needSeparator) ", ") << declaration.name
			needSeparator = true
		}
		it << ");"
	}

	def void generateActionOutputBody(OutputAction action, JvmExecutable op, ITreeAppendable it) {
		for (pattern : action.outputPatterns) {
			val port = pattern.portRef
			generatePatternOutputPart(pattern, port, it)
		}
	}
}