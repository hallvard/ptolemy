package org.ptolemy.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.common.types.util.TypeConformanceComputer
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import java.util.Collection
import org.eclipse.xtext.common.types.JvmIdentifiableElement

class XExpressionBuilder {
		
	@Inject extension XbaseFactory
	@Inject extension TypeConformanceComputer
	@Inject extension ITypeProvider

	def JvmField findField(JvmDeclaredType type, String name) {
		type.members.filter(typeof(JvmField)).findFirst[field |
			field.simpleName.equals(name)
		]
	}
		
	def JvmExecutable findExecutable(JvmDeclaredType type, String name, XExpression... arguments) {
		type.members.filter(typeof(JvmExecutable)).findFirst[exec |
			if (! exec.simpleName.equals(name)) {
				return false
			}
			var i = 0
			for (parameter : exec.parameters) {
				if (! arguments.get(i).type.isConformant(parameter.parameterType)) {
					return false
				}
				i = i + 1
			}
			return true
		]
	}

	def XExpression toFieldRef(JvmDeclaredType type, String name) {
		val field = findField(type, type.simpleName)
		if (field == null) {
			return null
		}
		val fieldRef = createXFeatureCall
		fieldRef.feature = field
		fieldRef
	}

	def XExpression toFieldAssignment(JvmDeclaredType type, String name, XExpression value) {
		toAssignment(findField(type, type.simpleName), value)
	}
	
	def XExpression toAssignment(JvmIdentifiableElement feature, XExpression value) {
		val ass = createXAssignment
		ass.feature = feature
		ass.explicitArguments += value
		ass
	}

	def XExpression toMethodCall(JvmDeclaredType type, String name, XExpression... arguments) {
		val cons = findExecutable(type, type.simpleName, arguments) as JvmConstructor
		if (cons == null) {
			return null
		}
		val consCall = createXConstructorCall
		consCall.constructor = cons
		consCall.arguments.addAll(EcoreUtil::copyAll(arguments))
		consCall
	}
	
	def XExpression toConstructorCall(JvmDeclaredType type, XExpression... arguments) {
		val cons = findExecutable(type, type.simpleName, arguments) as JvmConstructor
		if (cons == null) {
			return null
		}
		val consCall = createXConstructorCall
		consCall.constructor = cons
		consCall.arguments.addAll(copyIfNeeded(arguments))
		consCall
	}

	def Collection<? extends XExpression> copyIfNeeded(XExpression... expressions) {
		val copies = <XExpression>newArrayList()
		for (expression : expressions) {
			copies.add(copyIfNeeded(expression))
		}
		copies
	}

	def XExpression copyIfNeeded(XExpression expression) {
		if (expression.eContainer != null) EcoreUtil::copy(expression) else expression
	}
}
