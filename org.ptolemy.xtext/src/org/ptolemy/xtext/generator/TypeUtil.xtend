package org.ptolemy.xtext.generator

import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.ptolemy.ecore.actor.Typeable
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.common.types.JvmType
import org.ptolemy.ecore.actor.TypeParameterized
import org.ptolemy.ecore.kernel.Entity
import org.ptolemy.ecore.actor.ActorRef
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.eclipse.emf.ecore.InternalEObject

class TypeUtil {
	
    @Inject extension JvmTypesBuilder
	@Inject extension TypeReferences
	@Inject extension IJvmModelAssociations
	@Inject extension Primitives primitives
	
	def resolveTypeParameter1(JvmTypeReference typeRef) {
		var container = typeRef.eContainer()
		while (container != null) {
			if (container instanceof Entity) {
				val entityRef = (container as Entity).superEntity
				if (entityRef != null && entityRef.ref != null) {
					val superEntity = entityRef.ref
					if (entityRef instanceof ActorRef && superEntity instanceof TypeParameterized) {
						val typeArguments = (entityRef as ActorRef).typeArguments
						var pos = 0
						for (typeParameter : (superEntity as TypeParameterized).typeParameters) {
			    			val jvmType = typeParameter.jvmElements.head as JvmType
							if (typeRef.type == jvmType) {
								return typeArguments.get(pos)
							}
							pos = pos + 1
						}
					}
				}
			}
			container = container.eContainer()
		}
		return null
	}

	def resolveTypeParameter(JvmTypeReference typeRefParam) {
		var typeRef = typeRefParam
		while (typeRef?.type instanceof JvmTypeParameter) {
			val resolvedTypeRef = resolveTypeParameter1(typeRef)
			if (resolvedTypeRef == null) {
				return typeRef
			}
			typeRef = resolvedTypeRef
		}
		return typeRef
	}

    def type(Typeable type) {
    	if (type != null && type.inferredType != null) {
    		val typeRef = TypeParameterResolvingCopier::getResult(type.inferredType, this).typeRef;
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

	public static val TOKEN_CONST_PREFIX = "ptolemy.data.type.BaseType."

	def jvm2pType(JvmTypeReference type, EObject context) {
		val simpleName = type.jvm2pTypeSimpleName
		return TOKEN_CONST_PREFIX + (if (simpleName != null) simpleName else "Object").toUpperCase
	}
    
	def jvm2pType(Typeable typed) {
		return type(typed).jvm2pType(typed)
	}
	
	//
	
	def isPrimitive(JvmTypeReference type) {
		primitives.isPrimitive(type)
	}

    def objectType(JvmTypeReference type, EObject context) {
    	primitives.asWrapperTypeIfPrimitive(type)
//    	if (isPrimitive(type)) createTypeRef(primitives.getWrapperType(type.type as JvmPrimitiveType)) else type
//    	switch (type.qualifiedName) {
//    		case "boolean": context.newTypeRef(typeof(Boolean))
//    		case "char": 	context.newTypeRef(typeof(Character))
//    		case "byte": 	context.newTypeRef(typeof(Byte))
//    		case "short": 	context.newTypeRef(typeof(Short))
//    		case "int": 	context.newTypeRef(typeof(Integer))
//    		case "long": 	context.newTypeRef(typeof(Long))
//    		case "float": 	context.newTypeRef(typeof(Float))
//    		case "double": 	context.newTypeRef(typeof(Double))
//    		default: type
//    	}
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
		typeRef != null && TypeParameterResolvingCopier::getResult(typeRef, this).generic;
	}
}
