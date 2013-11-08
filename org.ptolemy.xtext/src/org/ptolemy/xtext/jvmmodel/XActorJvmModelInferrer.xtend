package org.ptolemy.xtext.jvmmodel

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.ptolemy.ecore.actor.AbstractIOPort
import org.ptolemy.ecore.actor.AbstractTypedIOPort
import org.ptolemy.ecore.actor.ActorRef
import org.ptolemy.ecore.actor.AtomicActor
import org.ptolemy.ecore.actor.AtomicActorImpl
import org.ptolemy.ecore.actor.InjectableAttribute
import org.ptolemy.ecore.actor.JvmTypedAttribute
import org.ptolemy.ecore.actor.JvmTypedObj
import org.ptolemy.ecore.actor.TypeParameterized
import org.ptolemy.ecore.actor.Typeable
import org.ptolemy.ecore.actor.TypedAtomicActor
import org.ptolemy.ecore.actor.Variable
import org.ptolemy.ecore.caltrop.ActionPattern
import org.ptolemy.ecore.caltrop.CaltropActorImpl
import org.ptolemy.ecore.caltrop.EventAction
import org.ptolemy.ecore.caltrop.EventPattern
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector
import org.ptolemy.ecore.caltrop.FireAction
import org.ptolemy.ecore.caltrop.InputPattern
import org.ptolemy.ecore.caltrop.OutputAction
import org.ptolemy.ecore.caltrop.OutputPattern
import org.ptolemy.ecore.caltrop.PortPattern
import org.ptolemy.ecore.caltrop.ReAction
import org.ptolemy.ecore.kernel.Attribute
import org.ptolemy.ecore.kernel.ComponentEntity
import org.ptolemy.ecore.kernel.Entity
import org.ptolemy.ecore.kernel.EntityContainer
import org.ptolemy.ecore.kernel.IEntity
import org.ptolemy.ecore.kernel.Nameable
import org.ptolemy.ecore.kernel.Port
import org.ptolemy.xtext.generator.ActionPatternHelper
import org.ptolemy.xtext.generator.TreeAppendableUtil
import org.ptolemy.xtext.generator.TypeUtil
import org.ptolemy.xtext.generator.WrappingAdapter
import org.ptolemy.xtext.generator.XActorGenerator
import org.ptolemy.xtext.validation.XActorJavaValidator
import org.ptolemy.ecore.caltrop.ConversionRelation
import org.ptolemy.ecore.kernel.Relation
import org.ptolemy.ecore.kernel.Named
import org.ptolemy.ecore.kernel.CompositeEntity
import org.ptolemy.ecore.kernel.EntityRef
import org.ptolemy.xtext.generator.MappingCopier
import org.ptolemy.ecore.caltrop.RealmKind
import org.ptolemy.ecore.caltrop.StateVariable

class XActorJvmModelInferrer extends AbstractModelInferrer {
	
    @Inject extension TypesFactory
    @Inject extension TypeReferences
    @Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider
	@Inject extension IJvmModelAssociator
	@Inject extension TypeUtil

    def dispatch void infer(IEntity<?> entity, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	val Collection<IEntity<?>> entities = new EntitySorter(entity, true).sort();
    	for (IEntity<?> entity2 : entities) {
    		inferActorClass(entity2, acceptor, isPrelinkingPhase)
    	}
    }

    def dispatch void inferActorClass(IEntity<?> entity, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    }

    def dispatch void inferActorClass(EntityRef<?> entityRef, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	val entity = entityRef.getRef()
    	if (entity.eResource() == entityRef.eResource()) {
	    	inferActorClass(entity, acceptor, isPrelinkingPhase)
    	}
    }

	def boolean isConversionRelation(Relation relation) {
		relation instanceof ConversionRelation && (relation as ConversionRelation).conversionExpression != null
	}

    def dispatch void inferActorClass(CompositeEntity<? extends Port> entityContainer, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		for (relation : entityContainer.relations) {
			if (relation.isConversionRelation) {
				val relationClass = inferSyntheticConversionRelationActor(relation as ConversionRelation, acceptor, isPrelinkingPhase)
				if (relationClass != null) {
					acceptor.accept(relationClass)
				}
			}
		}
    	val actorClass = entityContainer.toActorClass(isPrelinkingPhase)
    	if (actorClass == null) {
    		return
    	}
    	acceptor.accept(actorClass)
    }

	def entityTypeRef(String qName, EObject context, JvmTypeReference... typeArguments) {
		var entityTypeRef = context.newTypeRef(qName, typeArguments)
		if (entityTypeRef != null && entityTypeRef.type != null) {
			return entityTypeRef
		}
		if (context.eResource != null) {
			for (type : context.eResource.contents.filter(JvmDeclaredType)) {
				if (qName.equals(type.qualifiedName)) {
					return newTypeRef(type)
				}							
			}
		}
		null
	}
    
	def addEntityContainerMembers(EntityContainer<?> container, JvmGenericType actorClass) {
		for (entity : container.entities) {
			val qName = entity.toQualifiedClassName
			if (qName != null) {
				val entityTypeRef = entityTypeRef(qName, container)
				actorClass.members += entity.toField(entity.name, entityTypeRef)			
			   	actorClass.members += entity.toMethod(entity.methodName("_create%sEntity"), entityTypeRef) [
			   		visibility = JvmVisibility::PROTECTED
					addPtExceptions(entity, true)
			   		body = [
			   			generateCreateEntityMethodBody(entity, null, null, entityTypeRef, it)
			   		]
			   	]
			}
		}
		for (relation : container.relations) {
			if (relation.isConversionRelation) {
				val conversionRelationTypeRef = entityTypeRef(relation.toQualifiedClassName, container)
				val name = relation.indexedFeatureName
				actorClass.members += relation.toField(name, conversionRelationTypeRef)
			   	actorClass.members += relation.toMethod('''_create«name.toFirstUpper»Entity''', conversionRelationTypeRef) [
			   		visibility = JvmVisibility::PROTECTED
					addPtExceptions(relation, true)
			   		body = [
			   			generateCreateEntityMethodBody(relation, name, null, conversionRelationTypeRef, it)
			   		]
			   	]
			}
		}
	}

	def inferSyntheticConversionRelationActor(ConversionRelation relation, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
	   	if (! (relation.sourcePort instanceof AbstractTypedIOPort && relation.targetPorts.head instanceof AbstractTypedIOPort)) {
	   		return null;
	   	}
	   	val inputPort = (relation.sourcePort as AbstractTypedIOPort)
	   	val outputPort = (relation.targetPorts.head as AbstractTypedIOPort)
    	val actorSuperType = relation.newTypeRef("org.ptolemy.xtext.lib.caltrop.AbstractConversionRelationActor",
			inputPort.type.cloneWithProxies.objectType(relation), outputPort.type.cloneWithProxies.objectType(relation)
    	)
    	val actorClass = relation.toClass(relation.toQualifiedClassName) [
			superTypes += actorSuperType
    	]
    	if (isPrelinkingPhase) {
    		return actorClass
    	}
		actorClass.members += relation.toConstructor [
			simpleName = actorClass.simpleName
			parameters += relation.toParameter("parent", relation.newTypeRef("ptolemy.kernel.CompositeEntity"))
			parameters += relation.toParameter("name", relation.newTypeRef(String))
			addPtExceptions(relation, true)
			body = [
				it << "super(parent, name);";
			]
		]
	   	actorClass.members += inputPort.toSyntheticCreatePortMethod("input", "_createInputPort", relation)
	   	actorClass.members += outputPort.toSyntheticCreatePortMethod("output", "_createOutputPort", relation)
	   	actorClass.members += inputPort.toGetTokenValueMethod("_getInputTokenValue", true, relation)
   		actorClass.members += outputPort.toCreateTokenMethod("_createOutputToken", true, relation)

		val actionClassName = relation.container.toQualifiedClassName + indexedFeatureName(relation) + "Action"
		val actionSuperType = (actorSuperType.type as JvmGenericType).members.filter(JvmGenericType).head
		val actionClass = relation.toClass(actionClassName) [
			superTypes += newTypeRef(actionSuperType)
		]
		val valueVar = relation.valueVar ?: "it"
		if (relation.guardExpression != null) {
			actionClass.members += relation.guardExpression.toMethod("_guard", relation.newTypeRef(boolean)) [
				parameters += relation.toParameter(valueVar,  inputPort.type.cloneWithProxies.objectType(relation))
				body = relation.guardExpression
			]
		}
		val relationMethodContext = relation.conversionExpression ?: relation
		actionClass.members += relationMethodContext.toMethod("_convert", outputPort.type.cloneWithProxies.objectType(relation)) [
			parameters += relationMethodContext.toParameter(valueVar,  inputPort.type.cloneWithProxies.objectType(relation))
			if (relation.conversionExpression != null) {
				body = relation.conversionExpression
			} else {
				body = [ it << '''return «valueVar»;''']
			}
		]
		actorClass.members += actionClass
		actorClass.members += relationMethodContext.toMethod("_createConversionAction", newTypeRef(actionSuperType)) [
			body = [
				it << '''return new «actionClass.simpleName»();'''
			]
		]
		actorClass 
	}

    def dispatch void inferActorClass(TypedAtomicActor actor, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	var JvmGenericType actorClass = null
    	if (actor.name != null) {
    		if (actor.superEntity != null) {
    			if (isPrelinkingPhase) {
	    			actor.superEntity.getRef(); // only resolve proxy
    			} else {
	    			actor.superEntity.resolve(false)
	    		}
    		}
    		actorClass = actor.toActorClass(isPrelinkingPhase)
	    	acceptor.accept(actorClass)
    	}
    	if (! isPrelinkingPhase) {
	    	var isAbstract = isAbstract(actor)
			actorClass.setAbstract(isAbstract)
			if (actor.impl != null) {
	    		inferImpl(actor.impl, actor, actorClass, acceptor, isPrelinkingPhase)
	    	} else if (actor.inheritedImpl != null) {
	    		inferImpl(actor.inheritedImpl, actor, actorClass, acceptor, isPrelinkingPhase)
			}
    	}
    }

	@Inject extension TreeAppendableUtil

	def addTypeParameters(TypeParameterized typeParameterized, JvmGenericType jvmType, JvmGenericType actorClass) {
		for (typeParameter : typeParameterized.typeParameters) {
			if (! checkName(typeParameter.name, false)) {
				return
			}
		}
		var pos = 0
		for (typeParameter : typeParameterized.typeParameters) {
			val jvmTypeParameter = createJvmTypeParameter
			jvmTypeParameter.name = typeParameter.name
			if (actorClass != null) {
				val actorClassTypeParameter = actorClass.typeParameters.get(pos)
				if (jvmTypeParameter != null) {
					new WrappingAdapter(jvmTypeParameter).attach(actorClassTypeParameter)
				}
			}
	    	typeParameter.associate(jvmTypeParameter)
	    	jvmType.typeParameters += jvmTypeParameter
	    	pos = pos + 1
		}
	}

	def superEntityTypeRef(IEntity<? extends Port> entity) {
		val superEntity = (entity as Entity<?>).superEntity
		if (superEntity.ref != null) {
			val superTypeName = superEntity.ref.toQualifiedClassName
			if (superTypeName == null) {
			} else if (superEntity instanceof ActorRef<?>) {
				val superActor = (superEntity as ActorRef<?>)
				entityTypeRef(superTypeName, superEntity, superActor.typeArguments.toArray(newArrayList))
			} else {
				entityTypeRef(superTypeName, superEntity)
			}
		}
	}

    def toActorClass(IEntity<? extends Port> entity, boolean isPrelinkingPhase) {
		if (! checkName(entity, false)) {
			return null
		}
    	val className = entity.toQualifiedClassName
    	if (className == null) {
    		return null
    	}
    	val actorClass = entity.toClass(className)
    	if (isPrelinkingPhase) {
    		return actorClass
    	}
    	if (entity instanceof TypeParameterized) {
    		(entity as TypeParameterized).addTypeParameters(actorClass, null)
    	}

		actorClass => [
//			annotations += entity.toAnnotation(SuppressWarnings, "serial")
			var superTypeRef = entity.newTypeRef("ptolemy.actor.TypedCompositeActor")
			if (entity instanceof Entity<?> && (entity as Entity<?>).superEntity != null) {
				superTypeRef = superEntityTypeRef(entity)
			} else if (entity instanceof EntityContainer<?>) {
			} else if ((! (entity instanceof ComponentEntity<?>)) || (entity as ComponentEntity<?>).atomic) {
				superTypeRef = entity.newTypeRef("org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor")
			}
			if (superTypeRef != null) {
				superTypes += superTypeRef
			}
		]
		entity.addMembers(actorClass)
		actorClass.members += entity.toConstructor [
			simpleName = actorClass.simpleName
			parameters += entity.toParameter("parent", entity.newTypeRef("ptolemy.kernel.CompositeEntity"))
			parameters += entity.toParameter("name", entity.newTypeRef(String))
			addPtExceptions(entity, true)
			val cons = it
			body = [
				generateActorConstructorBody(entity, cons, it)
			]
		]
		actorClass.members += entity.toConstructor [
			simpleName = actorClass.simpleName
			parameters += entity.toParameter("parent", entity.newTypeRef("ptolemy.kernel.CompositeEntity"))
			addPtExceptions(entity, true)
			body = [
				it << '''this(parent, "«entity.name»");'''
			]
		]
		actorClass
	}

	//
	
	def isAbstract(Nameable named) {
		if (named instanceof JvmTypedObj) 
			(named as Typeable).isGeneric 
		else
			false
	}

	def isAbstract(IEntity<? extends Port> entity) {
		var abs = (entity instanceof TypeParameterized && (! (entity as TypeParameterized).typeParameters.empty))
    	for (port : entity.allPorts) {
			abs = isAbstract(port) || abs
    	}
    	for (attribute : entity.allAttributes) {
			abs = isAbstract(attribute) || abs
    	}
    	if (entity instanceof AtomicActor<?>) {
    		val actor = entity as AtomicActor<?>
			if (actor.impl == null && actor.inheritedImpl == null) {
				abs = true
			}
    	}
    	return abs
	}
	
	//

	def addPtExceptions(JvmExecutable method, EObject context, boolean creation) {
		if (creation) {
			method.exceptions += context.newTypeRef("ptolemy.kernel.util.NameDuplicationException")
		}
		method.exceptions += context.newTypeRef("ptolemy.kernel.util.IllegalActionException")
	}

	def createActorClassRef(JvmGenericType actorClass, Iterable<JvmTypeParameter> typeParameters) {
		val typeArguments = new ArrayList<JvmParameterizedTypeReference>()
		for (typeParameter : typeParameters) {
			val typeParameterRef = createJvmParameterizedTypeReference
			typeParameterRef.type = typeParameter
			typeArguments += typeParameterRef
		}
		val actorClassRef = createJvmParameterizedTypeReference
		actorClassRef.type = actorClass
		actorClassRef.arguments += typeArguments
		actorClassRef
	}

	private val overrideAnnotatons = false

	def sameExpressionContext(EObject model, JvmOperation method, String name, JvmTypeReference returnType, JvmTypeReference typeRef, (JvmOperation) => void init) {
		model.toMethod(name, returnType) [
			for (exception : method.exceptions) {
				exceptions += EcoreUtil.copy(exception)
			}
			for (parameter : method.parameters) {
				val parameterCopy = MappingCopier.map(parameter, typeRef)
				if (parameterCopy.name == null) {
					parameterCopy.name = "arg" + parameters.size 
				}
				parameters += parameterCopy
			}
			init.apply(it)
		]
	}

	def overrideMethod(EObject model, JvmOperation method, JvmTypeReference typeRef, (JvmOperation) => void init) {
		model.sameExpressionContext(method, method.simpleName, method.returnType, typeRef, init)
	}

	def JvmOperation overrideMethod(EObject model, String name, JvmTypeReference typeRef) {
		if (typeRef != null && typeRef.type != null) {
			val type = typeRef.type as JvmDeclaredType
			val method = type.allFeatures.filter(JvmOperation).findFirst[simpleName.equals(name)]
			if (method != null) {
				return model.overrideMethod(method, typeRef) [
					if (overrideAnnotatons) {
						annotations += method.toAnnotation(Override)
					}
					visibility = method.visibility
				]
			}
		}
		throw new NoSuchMethodException(typeRef + " does not have the " + name + " method ")
	}

	def JvmOperation overrideMethod(EObject model, String name, JvmTypeReference typeRef, (ITreeAppendable) => void init) {
		val method = overrideMethod(model, name, typeRef)
		method.setBody(init)
		method
	}

	def addAttributeFields(IEntity<? extends Port> entity, JvmGenericType actorClass) {
		for (attribute : entity.attributes) {
			if (attribute instanceof JvmTypedAttribute && checkName(attribute, false)) {
				val varType = type(attribute as JvmTypedAttribute)
				// the actual type may later be changed to Parameter by the code generator
				val field = attribute.toField(varType)
				field.visibility = JvmVisibility::PROTECTED
				field.final = (! (attribute instanceof Variable))
			   	actorClass.members += field
			}
		}
	}

	@Inject extension XActorJavaValidator

	def addPortFields(IEntity<? extends Port> entity, JvmGenericType actorClass) {
		val portTypeRef = entity.newTypeRef("ptolemy.actor.TypedIOPort")
		for (port : entity.ports) {
			if (checkName(port, false)) {
				val field = port.toField(portTypeRef)
				field.visibility = JvmVisibility::PROTECTED
			   	actorClass.members += field
			}
		}
	}

	def addMembers(IEntity<? extends Port> entity, JvmGenericType actorClass) {
		resolveTypeParameters(entity);
		addAttributeFields(entity, actorClass)
		addPortFields(entity, actorClass)
		if (entity instanceof EntityContainer<?>) {
			addEntityContainerMembers(entity as EntityContainer<?>, actorClass)
		}
		addAttributeAccessMethods(entity, actorClass)
		addPortAccessMethods(entity, actorClass)
		if (entity instanceof Entity<?>){
			addParameterBindingMethods(entity as Entity, actorClass)
		}
	}

	def resolveTypeParameters(IEntity<? extends Port> entity) {
		val contents = entity.eAllContents
		while (contents.hasNext) {
			val eObject = contents.next
			if (eObject instanceof JvmTypedObj) {
				val typed = (eObject as JvmTypedObj)
				if (typed.inheritsFrom != null) {
					typed.type = type(typed)
				}
			}
		}
	}
	
	def addPortAccessMethods(IEntity<? extends Port> entity, JvmGenericType actorClass) {
		for (Port port : entity.allPorts) {
			if (checkName(port, false)) {
				addPortAccessMethods(entity, port, actorClass)
			}
		}
	}

	def addPortAccessMethods(IEntity<? extends Port> entity, Port port, JvmGenericType actorClass) {
	   	actorClass.members += port.toCreatePortMethod(null, null, entity)
	   	if (port instanceof AbstractTypedIOPort) {
	   		val ioPort = (port as AbstractTypedIOPort)
	   		if (ioPort.input && needsMethod(ioPort, true)) {
			   	actorClass.members += ioPort.toGetTokenValueMethod(null, false, entity)
	   		}
	   		if (ioPort.output) {
	   			if (needsMethod(ioPort, true)) {
			   		actorClass.members += ioPort.toCreateTokenMethod(null, false, entity)
		   		}
//	   			if (needsMethod(ioPort, false)) {
//				   	actorClass.members += entity.toSendTokenMethod(ioPort, false)
//				   	actorClass.members += entity.toSendTokenMethod(ioPort, true)
//			   	}
	   		}
		}
	}

	def toCreatePortMethod(Port port, String altName, String methodName, EObject context) {
	   	port.toMethod(methodName ?: port.methodName("_create%sPort"), context.newTypeRef("ptolemy.actor.TypedIOPort")) [
	   		visibility = JvmVisibility::PROTECTED
			addPtExceptions(context, true)
	   		if (port instanceof Typeable && type(port as Typeable).isGeneric) {
	   			setAbstract(true)
	   		} else {
		   		body = [
		   			generateCreatePortMethodBody(port, altName, "port", it)
		   		]
	   		}
	   	]
	}

	def toSyntheticCreatePortMethod(JvmTypedObj typed, String altName, String methodName, EObject context) {
	   	typed.toMethod(methodName ?: typed.methodName("_create%sPort"), context.newTypeRef("ptolemy.actor.TypedIOPort")) [
	   		visibility = JvmVisibility::PROTECTED
			addPtExceptions(context, true)
	   		body = [
	   			generateSyntheticCreatePortMethodBody(typed, altName, methodName, "port", it)
	   		]
	   	]
	}

	def toGetTokenValueMethod(JvmTypedObj typed, String methodName, boolean objectType, EObject context) {
		val type = type(typed)
	   	typed.toMethod(methodName ?: typed.methodName("_get%sTokenValue"), if (objectType) type.objectType(context) else type) [
	   		visibility = JvmVisibility::PROTECTED
   			parameters += typed.toParameter(typed.name, jvm2pTokenType("", typed))
			addPtExceptions(context, false)
	   		if (isAbstract(typed)) {
	   			setAbstract(true)
	   		} else {
		   		body = [
		   			generateGetTokenValueMethodBody(typed.name, typed, it)
		   		]
	   		}
	   	]
	}

	def toCreateTokenMethod(JvmTypedObj typed, String methodName, boolean objectType, EObject context) {
		val type = type(typed)
		val tokenType = if (typed.isAbstract()) jvm2pTokenType("", typed) else type.jvm2pTokenType(typed)
	   	typed.toMethod(methodName ?: typed.methodName("_create%sToken"), tokenType) [
	   		visibility = JvmVisibility::PROTECTED
   			parameters += typed.toParameter(typed.name, if (objectType) type.objectType(context) else type)
			addPtExceptions(context, false)
	   		if (typed.isAbstract()) {
	   			setAbstract(true)
	   		} else {
		   		body = [
		   			generateCreateTokenMethodBody(typed.name, typed, it)
		   		]
	   		}
	   	]
	}

	def addAttributeAccessMethods(IEntity<? extends Port> entity, JvmGenericType actorClass) {
		for (attribute : entity.allAttributes) {
			if (checkName(attribute, false)) {
				addAttributeAccessMethods(entity, attribute, actorClass)
			}
		}
	}

	def needsMethod(JvmTypedObj typed, boolean tokenMethod) {
		val declaring = typed.inheritsFrom == null
		val implementing = (! typed.isAbstract) && typed.inheritsFrom != null && isAbstract(typed.inheritsFrom as JvmTypedObj)
		declaring || (tokenMethod && implementing)
	}

	def addAttributeAccessMethods(IEntity<? extends Port> entity, Attribute attribute, JvmGenericType actorClass) {
		if (attribute instanceof Variable || attribute instanceof InjectableAttribute) {
			val typeRef = attribute.pAttributeType
			val typed = (attribute as JvmTypedAttribute)
			val varType = type(typed)

			if (typed.needsMethod(true)) {
			   	actorClass.members += attribute.toMethod(attribute.methodName("_create%sAttribute"), typeRef) [
			   		visibility = JvmVisibility::PROTECTED
					addPtExceptions(entity, true)
					if (isAbstract(typed)) {
						setAbstract(true)
					} else {
				   		body = [
				   			generateCreateAttributeMethodBody(attribute, "attribute", it)
				   		]
			   		}
			   	]
			}
			if (typed instanceof Variable) {
				val variable = typed as Variable
				if (typed.needsMethod(true)) {
			   		val createTokenMethod = typed.toCreateTokenMethod(null, false, entity)
			   		createTokenMethod.visibility = JvmVisibility::PROTECTED
			   		actorClass.members += createTokenMethod
		   		}
				if (typed.needsMethod(false)) {
					addInitialAttributeValueMethod(entity, typed, variable, variable.valueExpression, actorClass)
				}
				if (typed.needsMethod(true)) {
				   	actorClass.members += attribute.toMethod(attribute.methodName("_get%sValue"), varType) [
				   		visibility = JvmVisibility::PROTECTED
						addPtExceptions(entity, false)
						if (isAbstract(typed)) {
							setAbstract(true)
						} else {
					   		body = [
					   			generateGetTokenValueMethodBody('''this.«typed.name».getToken()''', typed, it)
					   		]
						}
				   	]
			   	}
				if (typed.needsMethod(false)) {
				   	actorClass.members += attribute.toMethod(attribute.methodName("_set%sValue"), getTypeForName(void, entity)) [
				   		visibility = JvmVisibility::PROTECTED
			   			parameters += attribute.toParameter(attribute.name, type(attribute as Typeable))
						addPtExceptions(entity, false)
				   		body = [
				   			generateSetVariableValueMethodBody(variable, it)
				   		]
				   	]
			   	}
			} else if (typed instanceof InjectableAttribute) {
				if (typed.needsMethod(false)) {
					addInitialAttributeValueMethod(entity, typed, typed as InjectableAttribute, actorClass)
				} 
				if (typed.needsMethod(true)) {
				   	actorClass.members += attribute.toMethod(attribute.methodName("_get%sValue"), varType) [
				   		visibility = JvmVisibility::PROTECTED
						addPtExceptions(entity, false)
						if (isAbstract(typed)) {
							setAbstract(true)
						} else {
					   		body = [
					   			generateGetAttributeValueMethodBody('''this.«typed.name»''', typed, it)
					   		]
						}
				   	]
			   	}
			}
		}
	}

	def addParameterBindingMethods(Entity<? extends Port> entity, JvmGenericType actorClass) {
		val superEntity = entity.superEntity
		if (superEntity instanceof ActorRef<?>) {
			for (parameterBinding : (superEntity as ActorRef<?>).parameterBindings) {
				val parameter = parameterBinding.parameterRef
				if (parameter != null) {
					val inheritedParameter = entity.inheritedAttributes.filter(Variable).findFirst[name.equals(parameter.name)]
					addInitialAttributeValueMethod(entity, parameterBinding, inheritedParameter ?: parameter, parameterBinding.valueExpression, actorClass)
				}
			}
		}
	}

	def addInitialAttributeValueMethod(IEntity<? extends Port> entity, EObject owner, Variable variable, XExpression expression, JvmGenericType actorClass) {
		val type = type(variable)
	   	actorClass.members += owner.toMethod(variable.methodName("_initial%sAttributeValue"), type) [
	   		visibility = JvmVisibility::PROTECTED
			addPtExceptions(entity, false)
	   		body = [
	   			generateInitAttributeMethodBody(variable, expression, null, it)
	   		]
	   		expression.associateLogicalContainer(it)
	   	]
	}
	def addInitialAttributeValueMethod(IEntity<? extends Port> entity, EObject owner, InjectableAttribute injectable, JvmGenericType actorClass) {
		val type = type(injectable)
	   	actorClass.members += owner.toMethod(injectable.methodName("_initial%sAttributeValue"), type) [
	   		visibility = JvmVisibility::PROTECTED
			addPtExceptions(entity, false)
	   		body = [
	   			generateInitAttributeMethodBody(injectable, "injectable", it)
	   		]
	   	]
	}

	@Inject extension XActorGenerator

    def dispatch void inferImpl(AtomicActorImpl<? extends AbstractIOPort> impl, AtomicActor<?> actor, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    }

    def dispatch void inferImpl(CaltropActorImpl<? extends AbstractIOPort> impl, AtomicActor<?> actor, JvmGenericType implClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	if (impl.container != actor || implClass.superTypes.head == null) {
    		return
		}
		val implSupertype = implClass.superTypes.head
		val initializeMethod = impl.overrideMethod("_initializeImpl", implSupertype) [
			generateInitializeImplBody(impl, implClass, it)
		]
		for (declaration : impl.declarations) {
			val field = declaration.toField(declaration.name, declaration.inferredType)
			if (field != null) {
				field.visibility = JvmVisibility::PROTECTED
				implClass.members += field
				if (! declaration.constant) {
					implClass.members += declaration.toField(declaration.previousValueName, declaration.inferredType)
				}
				inferExpressionMethod(implClass, declaration.methodName("initial%sStateVariableValue"), declaration.valueExpression, declaration.type, initializeMethod)
			}
		}
		for (function : impl.functions) {
			val method = function.toMethod(function.name, if (function.type != null) type(function) else impl.newTypeRef(void)) [
				addPtExceptions(impl, false)
				for (parameter : function.parameters) {
					parameters += toParameter(parameter.name, type(parameter))
				}
				body = function.bodyExpression
			]
			implClass.members += method
		}
		if (! (impl.declarations.empty && impl.initActions.empty && impl.schedule == null)) {
			implClass.members += initializeMethod
		}
		val fireImplMethod = impl.overrideMethod("_fireImpl", implSupertype) []
		fireImplMethod.body = [
			generateFireImplBody(impl, fireImplMethod, it)
		]
		implClass.members += fireImplMethod
		for (EventPattern eventPattern : impl.actions.filter(EventAction).map[eventPatterns].flatten) {
			val listenerInterface = eventPattern.type(true)
			if (listenerInterface?.type instanceof JvmDeclaredType) {
				val listenerClass = eventPattern.toClass(eventPattern.eventPatternListenerName) [
					superTypes += listenerInterface
				]
				implClass.members += listenerClass
				for (JvmOperation op : (listenerInterface.type as JvmDeclaredType).members.filter(JvmOperation)) {
					if (eventPattern.timeExpression != null) {
						listenerClass.members += eventPattern.toMethod("_timestamp", eventPattern.newTypeRef(long)) [
							for (String param : eventPattern.variables) {
								parameters += eventPattern.toParameter(param, eventPattern.type(null))
							}
							body = eventPattern.timeExpression
						]
					}
					val eventMethod = eventPattern.overrideMethod(op, listenerInterface) []
					eventMethod.body = [
						generateEventListenerMethodBody(eventPattern, eventMethod, it)
					]
					listenerClass.members += eventMethod
				}
				implClass.members += eventPattern.toField(listenerClass.simpleName, listenerInterface) [
					initializer = [
						it -> eventPattern << "new " << newTypeRef(listenerClass) << "();"
					]
				]
			}
		}
		if (! impl.declarations.empty) {
			for (declaration : impl.declarations) {
				declaration.toDeclarationMethod("_preChange%sState", declaration.newTypeRef(void), false, implClass) [
					parameters += toParameter(declaration.name, declaration.inferredType)
					addPtExceptions(declaration, false)
					body = [
						generatePreStateVariableChangeBody(declaration, impl, it)
					]
				]
			}
			for (declaration : impl.declarations) {
				declaration.toDeclarationMethod("_postChange%sState", declaration.newTypeRef(void), false, implClass) [
					parameters += toParameter(declaration.name, declaration.inferredType)
					addPtExceptions(declaration, false)
					body = [
						generatePostStateVariableChangeBody(declaration, impl, it)
					]
				]
			}
			for (declaration : impl.declarations.filter[it.updateExpression != null]) {
				declaration.toDeclarationMethod("_update%sState", declaration.newTypeRef(void), false, implClass) [
					addPtExceptions(declaration, false)
					val method = it
					body = [
						generateUpdateStateVariableBody(declaration, method, it)
					]
					declaration.updateExpression.associateLogicalContainer(method)
				]
			}
		}
		if (! impl.declarations.empty) {
			val postFireImplMethod = impl.overrideMethod("_postfireImpl", implSupertype)
			postFireImplMethod.body = [
				generatePostfireImplBody(impl, postFireImplMethod, it)
			]
			implClass.members += postFireImplMethod
		}
		if (! impl.declarations.empty) {
			implClass.members += impl.overrideMethod("_wrapupImpl", implSupertype) [
				generateWrapupImplBody(impl, null, it)
			]
		}
		val actionSuperType = impl.newTypeRef("org.ptolemy.xtext.lib.caltrop.AbstractActionImpl")
		val actions = impl.initActions + impl.actions
		for (action : actions) {
			val actionClass = action.toActionClass(actionSuperType)
			implClass.members += actionClass
		}
		implClass.members += impl.toField("_actionImpls", addArrayTypeDimension(actionSuperType)) [
			visibility = JvmVisibility::PRIVATE
			final = true
			initializer = [
				generateActionImplsInitializer(impl, implClass, actionSuperType, it)
			]
		]
		implClass.members += impl.overrideMethod("getCausalityInterface", implSupertype) [
			generateGetCausalityInterfaceBody(impl, it)
		]
    }
	
	def toDeclarationMethod(StateVariable declaration, String methodName, JvmTypeReference returnType, boolean sync, JvmGenericType implClass, (JvmOperation) => void init) {
		val realmName = if (declaration.realm != null) declaration.realm.key else null
		val method = declaration.toMethod(declaration.methodName(methodName) + if (realmName != null) "_" + realmName else "", returnType, init)
		implClass.members += method
		if (realmName != null) {
			implClass.members += declaration.toMethod(declaration.methodName(methodName), returnType) [
				for (parameter : method.parameters) {
					parameters += toParameter(parameter.name, parameter.parameterType)
				}
				for (exception : method.exceptions) {
					exceptions += declaration.newTypeRef(exception.qualifiedName)
				}
				body = [
					it << '''realm«if (sync) "S" else "As"»yncExec("«realmName»", new Runnable() {''' << "public void run() {"
					if (! method.exceptions.empty) {
						it << '''try {'''
					}
					it << '''«declaration.methodName(methodName) + "_" + realmName»('''
					it << method.parameters.join(",") [name]
					it << ");"
					if (! method.exceptions.empty) {
						it << '''} catch (Exception e) {}'''
					}
					it << "}" << "});"
				]
			]
		}
	}
	
    def dispatch void inferInheritedImpl(AtomicActorImpl<?> impl, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    }

    def dispatch void inferInheritedImpl(CaltropActorImpl<? extends AbstractIOPort> impl, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    }

	@Inject
	extension ActionPatternHelper

	def addActionPatternParameters(JvmExecutable method, Iterable<? extends ActionPattern> patterns) {
		for (pattern : patterns) {
			for (variable : pattern.patternVariables) {
				val type = pattern.type(null)
				method.parameters += pattern.toParameter(variable, type)
			}
		}
	}

	def void inferExpressionMethod(JvmGenericType implClass, String name, XExpression expression, JvmTypeReference returnType, JvmOperation actionMethod) {
		if (expression != null) {
			val method = expression.sameExpressionContext(actionMethod, "_" + indexedName(name, expression), returnType, null) [
				visibility = JvmVisibility::PRIVATE
				body = [
					generateExpressionMethodBody(expression, null, returnType, it)
				]
			]
			expression.associateLogicalContainer(method)
			implClass.members += method
		}
	}

	def void inferExpressionMethod(JvmGenericType implClass, String name, XExpression expression, Class<?> clazz, JvmOperation actionMethod) {
		inferExpressionMethod(implClass, name, expression, getTypeForName(clazz, expression), actionMethod)
	}

	def void inferInputPatternExpressionMethods(JvmGenericType implClass, Iterable<? extends InputPattern> patterns, JvmOperation actionMethod) {
		for (pattern : patterns) {
			val methodPrefix = indexedName(actionMethod.simpleName + "Pattern", pattern)
			if (pattern.repeatExpression != null) {
				inferExpressionMethod(implClass, methodPrefix + "Repeat", pattern.repeatExpression, typeof(int), actionMethod)
			}
			if (pattern.channels instanceof ExpressionChannelSelector) {
				for (expression : (pattern.channels as ExpressionChannelSelector).keyExpressions) {
					inferExpressionMethod(implClass, methodPrefix + "Channel", expression, int, actionMethod)
				}
			}
			if (pattern.guardExpression != null) {
				inferExpressionMethod(implClass, methodPrefix + "Guard", pattern.guardExpression, boolean, actionMethod)
			}
		}
	}

	def void inferOutputPatternExpressionMethods(JvmGenericType implClass, Iterable<? extends OutputPattern> patterns, JvmOperation actionMethod) {
		for (pattern : patterns) {
			val methodPrefix = indexedName(actionMethod.simpleName + "Pattern", pattern)
			if (pattern.portRef != null) {
				val patternType = pattern.type(pattern.isMultiport(pattern.portRef), null)
				for (valueExpression : pattern.valueExpressions) {
					inferExpressionMethod(implClass, methodPrefix + "Output", valueExpression, patternType, actionMethod)
				}
			}
			if (pattern.repeatExpression != null) {
				inferExpressionMethod(implClass, methodPrefix + "Repeat", pattern.repeatExpression, int, actionMethod)
			}
			if (pattern.channels instanceof ExpressionChannelSelector) {
				for (expression : (pattern.channels as ExpressionChannelSelector).keyExpressions) {
					inferExpressionMethod(implClass, methodPrefix + "Channel", expression, int, actionMethod)
				}
			}
			if (pattern.guardExpression != null) {
				inferExpressionMethod(implClass, methodPrefix + "Guard", pattern.guardExpression, boolean, actionMethod)
			}
		}
	}

	def void inferEventPatternExpressionMethods(JvmGenericType implClass, Iterable<? extends EventPattern> patterns, JvmOperation actionMethod) {
		for (pattern : patterns) {
			val methodPrefix = indexedName(actionMethod.simpleName + "Pattern", pattern)
			if (pattern.guardExpression != null) {
				inferExpressionMethod(implClass, methodPrefix + "Guard", pattern.guardExpression, boolean, actionMethod)
			}
		}
	}

	def void associateLogicalContainer(Iterable<? extends PortPattern> patterns, JvmIdentifiableElement container) {
		for (pattern : patterns) {
			if (pattern instanceof OutputPattern) {
				for (valueExpression : (pattern as OutputPattern).valueExpressions) {
					valueExpression.associateLogicalContainer(container)
				}
				if (pattern.guardExpression != null) {
					pattern.guardExpression.associateLogicalContainer(container)
				}
			}
//			if (pattern.repeatExpression != null) {
//				pattern.repeatExpression.associateLogicalContainer(container)
//			}
//			pattern.channels.associateLogicalContainer(container)
			if (pattern.channels instanceof ExpressionChannelSelector) {
				for (expression : (pattern.channels as ExpressionChannelSelector).keyExpressions) {
//					expression.associateLogicalContainer(container)
				}
			}
		}
	}

	def expressionDeclarations(XExpression xexpression) {
		val declarations = new ArrayList<XVariableDeclaration>()
		if (xexpression instanceof XVariableDeclaration) {
			declarations.add(xexpression as XVariableDeclaration)
		} else if (xexpression instanceof XBlockExpression) {
			for (expression : (xexpression as XBlockExpression).expressions) {
				if (expression instanceof XVariableDeclaration) {
					declarations.add(expression as XVariableDeclaration)
				}
			}
		}
		declarations
	}

	def addDeclarationParameters(OutputAction action, JvmExecutable method) {
		for (declaration : expressionDeclarations(action.bodyExpression)) {
			val parameter = declaration.toParameter(declaration.simpleName, declaration.type)
			method.parameters += parameter
		}
	}

	def actionNum(ReAction action) {
		(action.eContainer as CaltropActorImpl<?>).actions.indexOf(action)		
	}

	def methodName(String prefix, EObject child, String name) {
		val container = child.eContainer
		val content = container.eGet(child.eContainingFeature) as EList<? extends EObject>
		prefix + (content.indexOf(child) + 1) + name.toFirstUpper		
	}

	def actionMethodName(OutputAction action, String name) {
		methodName(if (action instanceof FireAction) "action" else "init", action, name)
	}

	def toLowerPrefix(QualifiedName qName, boolean upperLast) {
    	val firstLowerSegments = new ArrayList<String>
    	for (segment : qName.skipLast(1).segments) {
    		firstLowerSegments += segment.toFirstLower
    	}
    	val simpleName = qName.lastSegment
    	QualifiedName::create(firstLowerSegments).append(if (upperLast) simpleName.toFirstUpper else simpleName)
	}

    def toQualifiedClassName(Named named, String name, boolean upperLast) {
    	val qName = named.fullyQualifiedName
    	if (qName == null) {
    		return null
    	}
    	(if (name != null) qName.append(name) else qName).toLowerPrefix(upperLast).toString
    }

    def toQualifiedClassName(Nameable named) {
    	named.toQualifiedClassName(null, named instanceof EntityContainer<?>)
    }

	def toQualifiedClassName(Relation relation) {
		relation.container.toQualifiedClassName(relation.indexedFeatureName, false)
	}

    def toField(Nameable named, JvmTypeReference type) {
    	named.toField(named.name, type) [
//    		final = true
    	]
    }

    def toField(JvmTypedObj typed) {
		val field = typed.toField(typed.name, type(typed))
		field
    }

    def toParameter(JvmTypedObj typed) {
		val parameter = typed.toParameter(typed.name, type(typed))
		parameter
    }
    
    //
    
	def JvmGenericType toActionClass(OutputAction action, JvmTypeReference superType) {
		val actionClass = action.toClass(action.indexedFeatureName.toFirstUpper) [
			superTypes += superType.cloneWithProxies
			val actionPatterns = new ArrayList<ActionPattern>(action.inputPatterns)
			if (action instanceof EventAction) {
				actionPatterns += ((action as EventAction).eventPatterns as Iterable<? extends ActionPattern>)
			}
			for (pattern : actionPatterns) {
				for (variable : pattern.patternVariables) {
					val type = pattern.type(null)
					members += pattern.toField(variable, type)
				}
			}
			for (declaration : expressionDeclarations(action.bodyExpression)) {
				members += declaration.toField(declaration.simpleName, declaration.type)
			}
		]
		try {
			inferActionClassMethods(action, actionClass)
		} catch (NoSuchMethodException e) {
		}
		actionClass
	}

	def inferActionClassMethods(OutputAction action, JvmGenericType implClass) {
		val matchMethod = action.overrideMethod("match", implClass.superTypes.head)
		matchMethod.body = [
			generateActionMatchBody(action, matchMethod, it)
		]
		implClass.members += matchMethod
		inferInputPatternExpressionMethods(implClass, action.inputPatterns, matchMethod)
		if (action instanceof EventAction) {
			inferEventPatternExpressionMethods(implClass, (action as EventAction).eventPatterns, matchMethod)
		}
		if (action.guardExpression != null) {
			inferExpressionMethod(implClass, matchMethod.simpleName + "Guard", action.guardExpression, getTypeForName(boolean, action), matchMethod)
		}
		if (action.bodyExpression != null) {
			val bodyMethod = action.overrideMethod("body", implClass.superTypes.head)
			bodyMethod.body = [
				generateActionDoBody(action, bodyMethod, it)
			]
			action.bodyExpression.associateLogicalContainer(bodyMethod)
			implClass.members += bodyMethod
		}
		val outputMethod = action.overrideMethod("output", implClass.superTypes.head) [
			generateActionOutputBody(action, it)
		]
		implClass.members += outputMethod
		inferOutputPatternExpressionMethods(implClass, action.outputPatterns, outputMethod)
		if (action.delayExpression != null) {
			inferExpressionMethod(implClass, matchMethod.simpleName + "Delay", action.delayExpression, getTypeForName(int, action), outputMethod)
		}
		if (action.updateExpression != null) {
			val updateMethod = action.overrideMethod("update", implClass.superTypes.head) [
				generateActionUpdateBody(action, implClass, it)
			]
			action.updateExpression.associateLogicalContainer(updateMethod)
			implClass.members += updateMethod
		}
		implClass.members += action.overrideMethod("getDependencies", implClass.superTypes.head) [
			val pairType = findDeclaredType("org.ptolemy.xtext.lib.caltrop.Pair", action)
			val portOwnerAccess = implClass.declaringType.simpleName + ".this"
			it -> action << "return new " << pairType << "[]{"
			if (action instanceof FireAction) {
				val booleanDependencyTypeRef = action.newTypeRef("ptolemy.actor.util.BooleanDependency")
				for (inputPattern : (action as FireAction).inputPatterns) {
					for (outputPattern : action.outputPatterns) {
						it -> action << "new " << pairType << ".Impl(new " << pairType << ".Impl"
						it -> action << '''(«portOwnerAccess».«inputPattern.portRef.name», «portOwnerAccess».«outputPattern.portRef.name»), ''' << booleanDependencyTypeRef << ".valueOf(true)), "
					}				
				}
			}
			it << "};"
		]
	}    
}
