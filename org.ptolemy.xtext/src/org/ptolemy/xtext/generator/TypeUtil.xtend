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
import java.util.Map
import org.eclipse.xtext.common.types.JvmTypeParameter
import java.util.Queue
import java.util.LinkedList
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmDeclaredType

class TypeUtil {
	
    @Inject extension JvmTypesBuilder
	@Inject extension TypeReferences
	@Inject extension Primitives primitives
	@Inject Provider<TypeParameterResolvingCopier> typeParameterResolvingCopierProvider

    def type(Typeable type) {
    	if (type != null && type.inferredType != null) {
    		val typeRef = (TypeParameterResolvingCopier.getCachedResult(type.inferredType) ?: typeParameterResolvingCopierProvider.get().copyTypeReference(type.inferredType)).typeRef;
    		if (typeRef instanceof XFunctionTypeRef && typeRef.getType().eIsProxy) {
    		}
    		return typeRef
    	}
    	createAnyTypeReference(type)
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
}
