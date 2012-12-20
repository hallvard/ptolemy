package org.ptolemy.xtext.jvmmodel

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.ptolemy.ecore.actor.JvmTypedObj
import org.ptolemy.ecore.actor.TypedAtomicActor
import org.ptolemy.ecore.kernel.ComponentEntity
import org.ptolemy.ecore.kernel.Entity
import org.ptolemy.ecore.kernel.Port
import org.ptolemy.ecore.caltrop.CaltropActorImpl
import org.eclipse.xtext.common.types.JvmGenericType
import java.util.ArrayList
import org.ptolemy.ecore.actor.Variable
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.ptolemy.ecore.caltrop.FireAction
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.ptolemy.xtext.generator.XActorGenerator
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.ptolemy.ecore.actor.AbstractIOPort
import org.ptolemy.ecore.actor.AbstractEntityActorImpl
import org.ptolemy.xtext.generator.ActionPatternHelper
import org.ptolemy.xtext.generator.TypeUtil
import org.ptolemy.ecore.caltrop.PortPattern
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.ptolemy.ecore.caltrop.OutputPattern
import org.ptolemy.ecore.caltrop.TypedInputPort
import org.ptolemy.ecore.caltrop.TypedOutputPort
import org.ptolemy.xtext.generator.TreeAppendableUtil
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.ptolemy.ecore.caltrop.ActorParameter
import org.ptolemy.ecore.caltrop.ExpressionChannelSelector
import org.eclipse.emf.ecore.util.EcoreUtil
import org.ptolemy.ecore.actor.Typeable
import org.ptolemy.ecore.actor.AbstractTypedIOPort
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XBlockExpression
import org.ptolemy.ecore.kernel.EntityContainer
import org.ptolemy.ecore.kernel.IEntity
import org.ptolemy.ecore.kernel.Nameable
import org.ptolemy.ecore.xactor.EntityFolder
import org.ptolemy.ecore.caltrop.OutputAction
import org.eclipse.emf.common.util.EList
import org.ptolemy.ecore.actor.ActorRef
import org.ptolemy.ecore.kernel.Attribute
import org.ptolemy.ecore.actor.AtomicActor
import org.ptolemy.ecore.actor.TypeParameterized
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.ptolemy.xtext.generator.WrappingAdapter
import org.eclipse.xtext.common.types.util.TypeReferences
import org.ptolemy.ecore.actor.TypeParameterized
import org.ptolemy.xtext.validation.XActorJavaValidator

class XActorJvmModelInferrer extends AbstractModelInferrer {
	
    @Inject extension TypeReferences
    @Inject extension TypesFactory
    @Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider
	@Inject extension IJvmModelAssociator
	@Inject extension TypeUtil

//	def Iterable<Entity> topologicalSortEntities(Iterable<Entity<? extends Port>> entities) {
//		val sourceEntities = entities.filter[! allPorts.exists[! sourcePorts.empty]]
//		val result = new ArrayList<Entity>()
//		if (! sourceEntities.empty) {
//			for (sourceEntity : sourceEntities) {
//				topologicalSortEntities(sourceEntity, result)
//			}
//		} else if (! entities.empty) {
//			topologicalSortEntities(entities.head, result)
//		}
//		return result
//	}
//
//	def private topologicalSortEntities(Entity entity, Collection<Entity> result) {
//		if (! result.contains(entity)) {
//			result += entity
//			for (targetEntity : entity.targetEntities) {
//				topologicalSortEntities(targetEntity, result)
//			}
//		}
//	}

    def dispatch void infer(EntityFolder entityFolder, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	_infer(entityFolder as EntityContainer, acceptor, isPrelinkingPhase)
		entityFolder.entityContainers.forEach[infer(it, acceptor, isPrelinkingPhase)]
    }

    def dispatch void infer(EntityContainer entityContainer, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	val entities = entityContainer.entities
    	if (! entities.empty) {
//    		val sortedEntities = entities.topologicalSortEntities
	    	entities.forEach[infer(it, acceptor, isPrelinkingPhase)]
	    	val actorClass = entityContainer.toActorClass(isPrelinkingPhase)
	    	if (actorClass == null) {
	    		return
	    	}
	    	if (! isPrelinkingPhase) {
	    		entityContainer.addEntityContainerMembers(actorClass)
	    	}
	    	acceptor.accept(actorClass)
    	}
    }
    
	def addEntityContainerMembers(EntityContainer container, JvmGenericType actorClass) {
		for (entity : container.entities) {
			val entityTypeRef = container.newTypeRef(entity.toQualifiedClassName)
			entity.toField(entity.name, entityTypeRef)			
		   	actorClass.members += entity.toMethod(entity.methodName("create%sEntity"), entityTypeRef) [
				addPtExceptions(entity, true)
		   		body = [
		   			generateCreateEntityMethodBody(entity, "port", entityTypeRef, false, it)
		   		]
		   	]
		}
		val relationTypeRef = container.newTypeRef("ptolemy.kernel.Relation")
		for (relation : container.relations) {
			relation.toField(relation.name, relationTypeRef)
		}
	}

    def dispatch void infer(TypedAtomicActor actor, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	var JvmGenericType actorClass = null
    	if (actor.name != null) {
    		if (actor.superEntity != null) { // && (! isPrelinkingPhase)) {
    			actor.superEntity.resolve(false)
    		}
    		actorClass = actor.toActorClass(isPrelinkingPhase)
	    	acceptor.accept(actorClass)
    	}
		if (actor.impl != null) {
    		inferImpl(actor.impl, actor, actorClass, acceptor, isPrelinkingPhase)
    	} else if (actor.inheritedImpl != null) {
    		inferImpl(actor.inheritedImpl, actor, actorClass, acceptor, isPrelinkingPhase)
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

	def superEntityTypeRef(IEntity<? extends Port> entity, String suffix) {
		val superEntity = (entity as Entity).superEntity
		if (superEntity.ref != null) {
			val superTypeName = superEntity.ref.toQualifiedClassName + suffix
			if (superEntity instanceof ActorRef) {
				val superActor = (superEntity as ActorRef)
				entity.newTypeRef(superTypeName, superActor.typeArguments.toArray(newArrayList))
			} else {
				entity.newTypeRef(superTypeName)
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
    	var isAbstract = isAbstract(entity)
		actorClass.setAbstract(isAbstract)

		actorClass => [
//			annotations += entity.toAnnotation(typeof(SuppressWarnings), "serial")
			var superTypeRef = entity.newTypeRef("ptolemy.actor.TypedCompositeActor")
			if (entity instanceof Entity && (entity as Entity).superEntity != null) {
				superTypeRef = superEntityTypeRef(entity, "")
			} else if (entity instanceof EntityContainer) {
			} else if ((! (entity instanceof ComponentEntity)) || (entity as ComponentEntity).atomic) {
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
			parameters += entity.toParameter("name", entity.newTypeRef(typeof(String)))
			addPtExceptions(entity, true)
			val cons = it
			body = [
				generateActorConstructorBody(entity, cons, it)
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
    	if (entity instanceof AtomicActor) {
    		val actor = entity as AtomicActor
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

	def getActorImplConstructorParameters(IEntity<? extends Port> entity) {
		val parameters = new ArrayList<JvmFormalParameter>();
		for (parameter : entity.allAttributes.filter(typeof(ActorParameter))) {
			parameters += parameter.toParameter(parameter.name, entity.newTypeRef("ptolemy.data.expr.Parameter"))
		}
		for (port : entity.allPorts.filter(typeof(TypedInputPort))) {
			parameters += port.toParameter(port.name, entity.newTypeRef("ptolemy.actor.TypedIOPort"))
		}
		for (port : entity.allPorts.filter(typeof(TypedOutputPort))) {
			parameters += port.toParameter(port.name, entity.newTypeRef("ptolemy.actor.TypedIOPort"))
		}
		parameters
	}

	public val ACTOR_VAR_NAME = "_actor"

    def toActorImplClass(AtomicActor actor, JvmGenericType actorClass, boolean isPrelinkingPhase) {
    	val implClass = actor.toClass(actor.toQualifiedClassName + "Impl")
    	if (isPrelinkingPhase) {
    		return implClass;
    	}
		implClass.setAbstract(actorClass.isAbstract)
		(actor as TypeParameterized).addTypeParameters(implClass, actorClass)
		var superTypeRef = actor.newTypeRef("org.ptolemy.xtext.lib.caltrop.AbstractActorImpl")
		if (actor.superEntity != null) {
			superTypeRef = superEntityTypeRef(actor, "Impl")
		}
		implClass.superTypes += superTypeRef
		addAttributeFields(actor, implClass)
		addPortFields(actor, implClass)
		implClass.members += actor.toConstructor [
			val cons = it
			simpleName = implClass.simpleName
			parameters += actor.toParameter(ACTOR_VAR_NAME, actorClass.createActorClassRef(implClass.typeParameters))
			// should add parameters of superclass first
			parameters.addAll(actor.actorImplConstructorParameters)
			body = [
				generateActorImplConstructorBody(actor, cons, it)
			]
		]
		implClass
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

	def overrideMethod(EObject model, String name, JvmTypeReference typeRef, (ITreeAppendable) => void init) {
		if (typeRef != null && typeRef.type != null) {
			val type = typeRef.type as JvmDeclaredType
			val method = type.allFeatures.filter(typeof(JvmOperation)).findFirst[simpleName.equals(name)]
			if (method != null) {
				model.toMethod(name, EcoreUtil2::copy(method.returnType)) [
					if (overrideAnnotatons) {
						annotations+=method.toAnnotation(typeof(Override))
					}
					for (exception : method.exceptions) {
						exceptions += EcoreUtil::copy(exception)
					}
					for (parameter : method.parameters) {
						parameters += EcoreUtil::copy(parameter)
					}
					visibility = method.visibility
					body = init
				]
			}
		}
	}

	def addAttributeFields(IEntity<? extends Port> entity, JvmGenericType actorClass) {
		for (attribute : entity.attributes) {
			if (attribute instanceof Variable && checkName(attribute, false)) {
				val varType = type(attribute as Variable)
				// the actual type may later be changed to Parameter by the code generator
				val field = attribute.toField(varType)
				field.visibility = JvmVisibility::PROTECTED
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
		if (entity instanceof EntityContainer) {
			addEntityContainerMembers(entity as EntityContainer, actorClass)
		}
		addAttributeAccessMethods(entity, actorClass)
		addPortAccessMethods(entity, actorClass)
		if (entity instanceof Entity){
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
	   	actorClass.members += entity.toCreateOutputPortMethod(port)
	   	if (port instanceof AbstractTypedIOPort) {
	   		val ioPort = (port as AbstractTypedIOPort)
	   		if (ioPort.input && needsMethod(ioPort, true)) {
			   	actorClass.members += entity.toGetTokenValueMethod(ioPort)
	   		}
	   		if (ioPort.output) {
	   			if (needsMethod(ioPort, true)) {
			   		actorClass.members += entity.toCreateTokenMethod(ioPort)
		   		}
//	   			if (needsMethod(ioPort, false)) {
//				   	actorClass.members += entity.toSendTokenMethod(ioPort, false)
//				   	actorClass.members += entity.toSendTokenMethod(ioPort, true)
//			   	}
	   		}
		}
	}

	def toCreateOutputPortMethod(IEntity<? extends Port> entity, Port port) {
	   	port.toMethod(port.methodName("create%sPort"), entity.newTypeRef("ptolemy.actor.TypedIOPort")) [
			addPtExceptions(entity, true)
	   		if (port instanceof Typeable && type(port as Typeable).isGeneric) {
	   			setAbstract(true)
	   		} else {
		   		body = [
		   			generateCreatePortMethodBody(port, "port", false, it)
		   		]
	   		}
	   	]
	}

	def toGetTokenValueMethod(IEntity<? extends Port> entity, JvmTypedObj typed) {
		val type = type(typed)
	   	typed.toMethod(typed.methodName("get%sTokenValue"), type) [
   			parameters += typed.toParameter(typed.name, jvm2pTokenType("", typed))
			addPtExceptions(entity, false)
	   		if (isAbstract(typed)) {
	   			setAbstract(true)
	   		} else {
		   		body = [
		   			generateGetTokenValueMethodBody(typed.name, typed, it)
		   		]
	   		}
	   	]
	}

	def toSendTokenMethod(IEntity<? extends Port> entity, JvmTypedObj typed, boolean array) {
	   	typed.toMethod(typed.methodName("send%sToken" + if (array) "s" else ""), null) [
	   		visibility = JvmVisibility::PROTECTED
	   		var paramType = jvm2pTokenType("", typed)
	   		if (array) {
	   			paramType = createArrayType(paramType)
	   		}
   			parameters += typed.toParameter("channel", entity.newTypeRef(Integer::TYPE))
   			parameters += typed.toParameter(typed.name, paramType)
			addPtExceptions(entity, false)
	   		body = [
	   			generateSendTokenMethodBody(typed, "channel", array, it)
	   		]
	   	]
	}

	def toCreateTokenMethod(IEntity<? extends Port> entity, JvmTypedObj typed) {
		val type = type(typed)
		val tokenType = if (typed.isAbstract()) jvm2pTokenType("", typed) else type.jvm2pTokenType(typed)
	   	typed.toMethod(typed.methodName("create%sToken"), tokenType) [
   			parameters += typed.toParameter(typed.name, type)
			addPtExceptions(entity, false)
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
		if (attribute instanceof Variable) {
			val typeRef = attribute.pAttributeType
			val variable = (attribute as Variable)
			val varType = type(variable)

			if (variable.needsMethod(true)) {
			   	actorClass.members += attribute.toMethod(attribute.methodName("create%sAttribute"), typeRef) [
			   		visibility = JvmVisibility::PROTECTED
					addPtExceptions(entity, true)
					if (isAbstract(variable)) {
						setAbstract(true)
					} else {
				   		body = [
				   			generateCreateAttributeMethodBody(attribute, "attribute", false, it)
				   		]
			   		}
			   	]
			}
			if (variable.needsMethod(true)) {
		   		val createTokenMethod = entity.toCreateTokenMethod(variable)
		   		createTokenMethod.visibility = JvmVisibility::PROTECTED
		   		actorClass.members += createTokenMethod
	   		}
			if (variable.needsMethod(false)) {
				addInitialAttributeValueMethod(entity, variable, variable, variable.valueExpression, actorClass)
			}
			if (variable.needsMethod(true)) {
			   	actorClass.members += attribute.toMethod(attribute.methodName("get%sValue"), varType) [
					addPtExceptions(entity, false)
					if (isAbstract(variable)) {
						setAbstract(true)
					} else {
				   		body = [
				   			generateGetTokenValueMethodBody('''this.«variable.name».getToken()''', variable, it)
				   		]
					}
			   	]
		   	}
			if (variable.needsMethod(false)) {
			   	actorClass.members += attribute.toMethod(attribute.methodName("set%sValue"), null) [
		   			parameters += attribute.toParameter(attribute.name, type(attribute as Typeable))
					addPtExceptions(entity, false)
			   		body = [
			   			generateSetVariableValueMethodBody(variable, it)
			   		]
			   	]
		   	}
		}
	}

	def addParameterBindingMethods(Entity<? extends Port> entity, JvmGenericType actorClass) {
		val superEntity = entity.superEntity
		if (superEntity instanceof ActorRef) {
			for (parameterBinding : (superEntity as ActorRef).parameterBindings) {
				val variable = parameterBinding.parameterRef
				if (variable != null) {
					addInitialAttributeValueMethod(entity, parameterBinding, variable, parameterBinding.valueExpression, actorClass)
				}
			}
		}
	}

	def addInitialAttributeValueMethod(IEntity<? extends Port> entity, EObject owner, Variable variable, XExpression expression, JvmGenericType actorClass) {
		val type = type(variable)
	   	actorClass.members += owner.toMethod(variable.methodName("initial%sAttributeValue"), type) [
	   		visibility = JvmVisibility::PROTECTED
			addPtExceptions(entity, false)
	   		body = [
	   			generateInitAttributeMethodBody(variable, expression, "parameter", false, it)
	   		]
	   		expression.associateLogicalContainer(it)
	   	]
	}

    def dispatch void inferImpl(AbstractEntityActorImpl impl, AtomicActor actor, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	if (impl.entity != null && impl.container == actor) {
	    	infer(impl.entity, acceptor, isPrelinkingPhase)
    	}
	}

	@Inject extension XActorGenerator

    def dispatch void inferImpl(CaltropActorImpl<? extends AbstractIOPort> impl, AtomicActor actor, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    	val implClass = toActorImplClass(actor, actorClass, isPrelinkingPhase)
    	acceptor.accept(implClass)
    	if (isPrelinkingPhase) {
    		return;
    	}
    	if (! actorClass.isAbstract) {
			actorClass.members += impl.toField("_impl", implClass.newTypeRef) [
				setFinal(true)
				visibility = JvmVisibility::PRIVATE			
			]
			actorClass.members += impl.toMethod("_getImpl", implClass.newTypeRef) [
				if (overrideAnnotatons) {
					annotations+=impl.toAnnotation(typeof(Override))
				}
				visibility = JvmVisibility::PROTECTED
				body = [
					it << "return _impl;"
				]
			]
    	}
		implClass.members += impl.toMethod("getActor", actorClass.createActorClassRef(implClass.typeParameters)) [
			if (overrideAnnotatons) {
				annotations+=impl.toAnnotation(typeof(Override))
			}
			if (actorClass.isAbstract) {
				setAbstract(true)
			} else {
				implClass.members += impl.toField(ACTOR_VAR_NAME, actorClass.createActorClassRef(implClass.typeParameters)) [
					visibility = JvmVisibility::PRIVATE
					final = true
				]
				body = [
					it << '''return «ACTOR_VAR_NAME»;'''; 
				]
	    	}
		]
    	if (impl.container == actor) {
			for (declaration : impl.declarations) {
				implClass.members += declaration.toField(declaration.name, declaration.inferredType)
				if (! declaration.constant) {
					implClass.members += declaration.toField(previousValueName(declaration.name), declaration.inferredType)
				}
			}
			val implSupertype = implClass.superTypes.head
			if (! (impl.declarations.empty && impl.initActions.empty)) {
				implClass.members += impl.overrideMethod("initialize", implSupertype) [
					generateInitializeBody(impl, null, it)
				]
			}
			implClass.members += impl.overrideMethod("prefire", implSupertype) [
				generatePrefireBody(impl, null, it)
			]
			implClass.members += impl.overrideMethod("fire", implSupertype) [
				generateFireBody(impl, null, it)
			]
			if (! impl.declarations.empty) {
				implClass.members += impl.overrideMethod("postfire", implSupertype) [
					generatePostfireBody(impl, null, it)
				]
			}
			for (action : impl.initActions) {
				inferActionMethods(action, implClass)
			}
			for (action : impl.actions) {
				inferActionMethods(action, implClass)
			}
    	}
    }

    def dispatch void inferInheritedImpl(AbstractEntityActorImpl impl, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    }

    def dispatch void inferInheritedImpl(CaltropActorImpl<? extends AbstractIOPort> impl, JvmGenericType actorClass, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
    }

	def inferActionMethods(OutputAction action, JvmGenericType implClass) {
			val matchMethod = action.toMethod(action.actionMethodName("match"), action.newTypeRef(typeof(boolean))) [
				addPtExceptions(action, false)
				val method = it
				body = [
					generateActionMatchBody(action, method, it)
				]
			]
			action.inputPatterns.associateLogicalContainer(matchMethod)
			if (action.guardExpression != null) {
				action.guardExpression.associateLogicalContainer(matchMethod)
			}
			implClass.members += matchMethod

			val doMethod = action.toMethod(action.actionMethodName("do"), null) [
				addPtExceptions(action, false)
				action.addInputPatternParameters(it)
				val method = it
				body = [
					generateActionDoBody(action, method, it)
				]
			]
			for (declaration : action.attributes.filter(typeof(Variable))) {
				if (declaration.valueExpression != null) {
					declaration.valueExpression.associateLogicalContainer(doMethod)
				}
			}
			if (action.bodyExpression != null) {
				action.bodyExpression.associateLogicalContainer(doMethod)
			}
			implClass.members += doMethod

			val outputMethod = action.toMethod(action.actionMethodName("output"), null) [
				addPtExceptions(action, false)
				action.addInputPatternParameters(it)
				action.addDeclarationParameters(it)
				val method = it
				body = [
					generateActionOutputBody(action, method, it)
				]
			]
			action.outputPatterns.associateLogicalContainer(outputMethod)
			implClass.members += outputMethod
	}

	@Inject
	extension ActionPatternHelper

	def addInputPatternParameters(OutputAction action, JvmExecutable method) {
		for (pattern : action.inputPatterns) {
			val port = pattern.portRef
			for (variable : pattern.variables) {
				val type = pattern.type(port, null)
				method.parameters += pattern.toParameter(variable, type)
			}
		}
	}

	def void associateLogicalContainer(Iterable<? extends PortPattern> patterns, JvmIdentifiableElement container) {
		for (pattern : patterns) {
			if (pattern instanceof OutputPattern) {
				for (valueExpression : (pattern as OutputPattern).valueExpressions) {
					valueExpression.associateLogicalContainer(container)
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

	def actionNum(FireAction action) {
		(action.eContainer as CaltropActorImpl).actions.indexOf(action)		
	}

	def methodName(String prefix, EObject child, String name) {
		val container = child.eContainer
		val content = container.eGet(child.eContainingFeature) as EList<? extends EObject>
		prefix + (content.indexOf(child) + 1) + name.toFirstUpper		
	}

	def actionMethodName(OutputAction action, String name) {
		methodName(if (action instanceof FireAction) "action" else "init", action, name)
	}

//    def packagePrefix(EObject eObject) {
//    	val uri = eObject.eResource.URI.trimFileExtension
//    	val segments = uri.segmentsList
//    	val projectSegment = segments.findLast[contains(".")]
//    	val packageSegments = if (projectSegment != null) segments.drop(segments.indexOf(projectSegment) + 2) else segments
//    	packageSegments.join('.')
//    }

    def toQualifiedClassName(Nameable named) {
    	val qName = named.fullyQualifiedName
    	if (qName == null) {
    		return null
    	}
    	qName.skipLast(1).append(qName.lastSegment.toFirstUpper).toString()
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
}
