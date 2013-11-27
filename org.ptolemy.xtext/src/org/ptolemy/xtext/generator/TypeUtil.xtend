package org.ptolemy.xtext.generator

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.ptolemy.ecore.actor.Typeable
import org.ptolemy.ecore.actor.Variable
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XInstanceOfExpression
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XConstructorCall
import org.ptolemy.ecore.kernel.Port
import org.ptolemy.ecore.actor.AbstractIOPort

class TypeUtil {
	
    @Inject extension JvmTypesBuilder
	@Inject extension TypeReferences
	@Inject extension Primitives primitives
	@Inject Provider<TypeParameterResolvingCopier> typeParameterResolvingCopierProvider

    def type(Typeable type, boolean anyAsDef) {
    	if (type != null && type.inferredType != null) {
    		val typeRef = (TypeParameterResolvingCopier.getCachedResult(type.inferredType) ?: typeParameterResolvingCopierProvider.get().copyTypeReference(type.inferredType)).typeRef;
    		if (typeRef instanceof XFunctionTypeRef && typeRef.getType().eIsProxy) {
    		}
    		return typeRef
    	}
    	if (anyAsDef) createAnyTypeReference(type) else null
    }

	def type(Typeable typed) {
		type(typed, false) ?: if (typed instanceof Variable) (typed as Variable).valueExpression.type else typed.createAnyTypeReference
	}

	def type(XExpression expression) {
		switch (expression) {
			XBooleanLiteral : expression.newTypeRef(boolean)
			XInstanceOfExpression : expression.newTypeRef(boolean)
			XNumberLiteral : expression.newTypeRef(if (expression.value.contains(".")) (if (expression.value.endsWith("f")) float else double) else (if (expression.value.endsWith("l")) long else int))
			XStringLiteral : expression.newTypeRef(String)
			XTypeLiteral : expression.newTypeRef(Class)
			XCastedExpression : expression.type
			XConstructorCall: expression.newTypeRef(expression.constructor.declaringType.qualifiedName)
			default: expression.inferredType
		}
	}

	//

	def private withoutJavaLang(String s) {
		if (s.startsWith("java.lang.")) s.substring(10) else s
	}

	def jvm2pTypeSimpleName(JvmTypeReference type) {
		if (type == null || type.type == null) "" else
	    	switch (type.qualifiedName.withoutJavaLang.toFirstLower) {
	    		case "boolean": 	"Boolean"
	    		case "short": 		"Short"
	    		case "int": 		"Int"
	    		case "integer": 	"Int"
	    		case "long": 		"Long"
	    		case "float": 		"Float"
	    		case "double": 		"Double"
	    		case "string": 		"String"
	    		case "object": 		"Object"
	    		default: null
	    	}
	}
    
	public static val TOKEN_CLASS_PACKAGE_PREFIX = "ptolemy.data.";
	public static val TOKEN_CLASS_SUFFIX = "Token";

	def jvm2pTokenType(String simpleName, EObject context) {
		context.newTypeRef(TOKEN_CLASS_PACKAGE_PREFIX + (if (simpleName != null) simpleName else "") + TOKEN_CLASS_SUFFIX)
	}

	def jvm2pTokenType(JvmTypeReference type, EObject context) {
		val simpleName = type.jvm2pTypeSimpleName
		context.newTypeRef(TOKEN_CLASS_PACKAGE_PREFIX + (if (simpleName != null) simpleName else "Object") + TOKEN_CLASS_SUFFIX)
	}

	public static val TOKENS_CLASS_PACKAGE_PREFIX = "org.ptolemy.xtext.lib.caltrop.tokens.";

	def hasTokenType(JvmTypeReference type) {
		type.jvm2pTypeSimpleName != null
	}

	def is2ObjectTokenType(JvmTypeReference type) {
		val simpleName = type.jvm2pTypeSimpleName
		simpleName == null || "Object".equals(simpleName)
	}

	def jvm2pTokensType(JvmTypeReference typeRef, EObject context) {
		val tokensTypeName = TOKENS_CLASS_PACKAGE_PREFIX + typeRef.jvm2pTokenType(context).simpleName + "s"
		if (typeRef.is2ObjectTokenType)
			context.newTypeRef(tokensTypeName, typeRef)
		else
			context.newTypeRef(tokensTypeName)
	}

	public static val TYPE_PACKAGE_PREFIX = "ptolemy.data.type."
	public static val TOKEN_CONST_PREFIX = TYPE_PACKAGE_PREFIX + "BaseType."
    
	//
	
	def isPrimitive(JvmTypeReference type) {
		primitives.isPrimitive(type)
	}

    def objectType(JvmTypeReference type, EObject context) {
    	primitives.asWrapperTypeIfPrimitive(type)
    }
    
    //
    
    def defaultValue(JvmTypeReference type) {
    	switch (type.qualifiedName.withoutJavaLang.toFirstUpper) {
    		case "Boolean":		"false"
    		case "Character": 	"'\\0'"
    		case "char": 		"'\\0'"
    		case "Byte": 		"0"
    		case "Short": 		"0"
    		case "Integer":		"0"
    		case "Int": 		"0"
    		case "Long": 		"0L"
    		case "Float": 		"0.0f"
    		case "Double": 		"0.0"
    		default: "null"
    	}
    }
    
    //
    
	def isGeneric(Typeable typed) {
		isGeneric(typed.inferredType)
	}

	def isGeneric(JvmTypeReference typeRef) {
		typeRef != null &&  (TypeParameterResolvingCopier.getCachedResult(typeRef) ?: typeParameterResolvingCopierProvider.get().copyTypeReference(typeRef)).generic;
	}
	
	def portImplType(EObject context, boolean input) {
//		if (input)
			context.newTypeRef("org.ptolemy.xtext.lib.caltrop.CaltropIOPort")
//		else
//			context.newTypeRef("ptolemy.actor.TypedIOPort")
	}

	def portImplType(Port port) {
		portImplType(port, port instanceof AbstractIOPort && (port as AbstractIOPort).input)
	}
}
