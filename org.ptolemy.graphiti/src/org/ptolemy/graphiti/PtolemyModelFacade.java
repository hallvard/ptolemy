package org.ptolemy.graphiti;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.Actor;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.AtomicActor;
import org.ptolemy.ecore.actor.CompositeActor;
import org.ptolemy.ecore.actor.TypedAtomicActor;
import org.ptolemy.ecore.actor.TypedCompositeActor;
import org.ptolemy.ecore.caltrop.CaltropFactory;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;
import org.ptolemy.ecore.kernel.util.KernelValidator;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.XactorFactory;
import org.ptolemy.graphiti.generic.AbstractViewModel;
import org.ptolemy.graphiti.generic.ActorContainerEditModel;
import org.ptolemy.graphiti.generic.ActorEditModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ConnectionContainerEditModel;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class PtolemyModelFacade extends AbstractViewModel implements ActorEditModel, ActorContainerEditModel, ConnectionContainerEditModel {

	/**
	 * Determines if the eObject is an entity of the specified kind.
	 * If entityKind is null, just determines if eObject is an entity at all.
	 * @param eObject
	 * @param entityKind
	 * @return
	 */
	public boolean isEntity(EObject eObject, EntityViewModel.EntityKind entityKind) {
		if (entityKind == null) {
			return eObject instanceof Entity<?>;
		}
		switch (entityKind) {
		case ATOMIC_ACTOR:
			return eObject instanceof AtomicActor;
		case COMPOSITE_ACTOR:
			return eObject instanceof CompositeActor;
		case ENTITY_NAMESPACE:
			return eObject instanceof EntityFolder;
		case ACTOR_CONTAINER:
			return eObject instanceof EntityContainer<?>;
		case ACTOR:
			return eObject instanceof Actor<?>;
		}
		return false;
	}

	/**
	 * Determines if the eObject is a port of the specified portKind.
	 * If portKind is null, just determines if eObject is a port at all.
	 * @param eObject
	 * @param portKind
	 * @return
	 */
	public boolean isPort(EObject eObject, ActorViewModel.PortKind portKind) {
		if (portKind == null) {
			return eObject instanceof Port;
		}
		if (eObject instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) eObject;
			switch (portKind) {
			case INPUT: return ioPort.isInput();
			case OUTPUT: return ioPort.isOutput();
			}
		}
		return false;
	}
	
	@Inject
	private KernelFactory kernelFactory;

	@Inject
	private ActorFactory actorFactory;
	
	@Inject
	private CaltropFactory calFactory;

	@Inject
	private XactorFactory xactorFactory;
	
	/**
	 * Creates a new entity (actor and/or container) of the specified kind, with the suggested name, and
	 * adds it to the provided container
	 * @param name
	 * @param
	 * @return the new actor
	 */
	public EObject createEntity(EntityViewModel.EntityKind entityKind, String name, EObject actorContainer) {
		EObject newEntity = null;
		switch (entityKind) {
		case ATOMIC_ACTOR: {
			TypedAtomicActor actor = actorFactory.createTypedAtomicActor();
			actor.setName(name);
			newEntity = actor;
		}
		case COMPOSITE_ACTOR: {
			TypedCompositeActor actor = actorFactory.createTypedCompositeActor();
			actor.setName(name);
			newEntity = actor;
		}
		case ACTOR_CONTAINER:
		case ENTITY_NAMESPACE: {
			EntityFolder namespace = xactorFactory.createEntityFolder();
			namespace.setName(name);
			newEntity = namespace;
		}
		}
		if (newEntity != null) {
			addEntity(newEntity, actorContainer);
		}
		return newEntity;
	}

	protected EObject addEntity(EObject entity, EObject entityContainer) {
		if (entity instanceof Entity<?> && entityContainer instanceof EntityContainer<?>) {
			((EntityContainer<?>) entityContainer).getEntities().add((Entity<?>) entity);
		} else if (entity instanceof EntityFolder && entityContainer instanceof EntityFolder) {
			((EntityFolder) entityContainer).getEntityContainers().add((EntityFolder) entity);
		}
		return entity;
	}
	
	/**
	 * Creates a new actor that is an instance of an existing actor with the suggested name, and
	 * adds it to the provided actor container
	 * @param name
	 * @param actor
	 * @return
	 */
	@Override
	public EObject createActorInstance(EObject actor, String name, EObject actorContainer) {
		if (actor instanceof Entity<?>) {
			Entity<?> prototype = (Entity<?>) actor;
			Entity<?> entity = (Entity<?>) ActorFactory.eINSTANCE.create(prototype.eClass());
			EntityRef superEntity = ActorFactory.eINSTANCE.createActorRef();
			superEntity.setRef((Entity<?>) prototype);
			entity.setName(name);
			entity.setDisplayName(prototype.getDisplayName());
			entity.setSuperEntity(superEntity);
			return entity;
		}
		return null;
	}

	/**
	 * Returns the actors contained by the actor container. The entityKinds arguments control which entities to include,
	 * no arguments means return all.
	 * @param actorContainer
	 * @return
	 */
	@Override
	public Iterable<? extends EObject> getEntities(EObject actorContainer, EntityKind... entityKinds) {
		Collection<EObject> entities = new ArrayList<EObject>();
		if (actorContainer instanceof EntityContainer<?>) {
			addEntities(((EntityContainer<?>) actorContainer).getEntities(), EntityKind.ACTOR, entityKinds, entities);
		}
		if (actorContainer instanceof EntityFolder) {
			addEntities(((EntityFolder) actorContainer).getEntityContainers(), EntityKind.ENTITY_NAMESPACE, entityKinds, entities);
		}
		return entities;
	}

	/**
	 * Returns the connections contained by the composite actor
	 * @param actorContainer
	 * @return
	 */
	@Override
	public Iterable<? extends EObject> getConnections(EObject compositeActor) {
		Collection<EObject> connections = new ArrayList<EObject>();
		if (compositeActor instanceof CompositeActor<?>) {
			connections.addAll(((CompositeActor<?>) compositeActor).getRelations());
		}
		return connections;
	}
	
	/**
	 * Returns the ports contained by the actor. The portKinds arguments control which ports to include,
	 * no arguments means return all.
	 * @param actor
	 * @param portKinds the kinds of ports to include
	 * @return
	 */
	@Override
	public Iterable<? extends EObject> getPorts(EObject actor, PortKind... portKinds) {
		Collection<EObject> ports = new ArrayList<EObject>();
		if (actor instanceof Entity<?>) {
			Entity<?> entity = (Entity<?>) actor;
			addPorts(entity.getAllPorts(), null, portKinds, ports);
		}
		return ports;
	}

	/**
	 * Creates (and adds) a new port with the provided name and of the provided kind (input, output, io), and
	 * adds it to the actor
	 * @param name
	 * @param portKind
	 * @return the newly created port
	 */
	@Override
	public EObject createPort(PortKind portKind, String name, EObject actor) {
		AbstractIOPort port = null;
		if (portKind == PortKind.INPUT) {
			port = calFactory.createTypedInputPort();
		} else if (portKind == PortKind.OUTPUT) {
			port = calFactory.createTypedOutputPort();
		}
		port.setName(name);
		if (actor instanceof Actor<?>) {
			((Actor<AbstractIOPort>) actor).getPorts().add(port);
		}
		return port;
	}
	
	/**
	 * Determines if the port is a multiport
	 * @param port
	 * @return
	 */
	@Override
	public boolean isMulti(EObject port) {
		return port instanceof AbstractIOPort && ((AbstractIOPort) port).isMultiport();
	}

	/**
	 * Sets the multi port flag of the port 
	 * @param port
	 * @param multi
	 */
	@Override
	public void setMultiPort(EObject port, boolean multi) {
		if (port instanceof AbstractIOPort) {
			((AbstractIOPort) port).setMultiport(multi);
		}
	}

	/**
	 * Returns the actor container that will be the parent of a connection between the provided ports, or
	 * null if they cannot be connected
	 * @param sourcePort
	 * @param targetPort
	 * @return
	 */
	public EntityContainer<?> getConnectionContainer(EObject sourcePort, EObject targetPort) {
		if (sourcePort instanceof Port && targetPort instanceof Port) {
			return KernelValidator.getRelationContainer((Port) sourcePort, (Port) targetPort);
		}
		return null;
	}
	
	/**
	 * Creates (and adds) the a connection between the provided ports
	 * @param sourcePort
	 * @param targetPort
	 * @return
	 */
	public EObject createConnection(EObject sourcePort, EObject targetPort) {
		if (sourcePort instanceof Port && targetPort instanceof Port) {
			EntityContainer<?> relationContainer = KernelValidator.getRelationContainer((Port) sourcePort, (Port) targetPort);
			if (relationContainer != null) {
				Relation relation = kernelFactory.createRelation();
				relation.setSourcePort((Port) sourcePort);
				relation.getTargetPorts().add((Port) targetPort);
				relationContainer.getRelations().add(relation);
				return relation;
			}
		}
		return null;
	}

	/**
	 * Returns the source actor of the connection
	 * @param connection
	 * @return
	 */
	public Entity<?> getSourceActor(EObject connection) {
		if (connection instanceof Relation) {
			return ((Relation) connection).getSourcePort().getContainer();
		}
		return null;
	}

	/**
	 * Returns the target actor of the connection
	 * @param connection
	 * @return
	 */
	public Entity<?> getTargetActor(EObject connection) {
		if (connection instanceof Relation) {
			EList<Port> targetPorts = ((Relation) connection).getTargetPorts();
			if (! targetPorts.isEmpty()) {
				return targetPorts.get(0).getContainer();
			}
		}
		return null;
	}

	/**
	 * Returns the source port of the connection
	 * @param connection
	 * @return
	 */
	@Override
	public Port getSourcePort(EObject connection) {
		if (connection instanceof Relation) {
			return ((Relation) connection).getSourcePort();
		}
		return null;
	}

	/**
	 * Returns the target port of the connection
	 * @param connection
	 * @return
	 */
	@Override
	public Port getTargetPort(EObject connection) {
		if (connection instanceof Relation) {
			EList<Port> targetPorts = ((Relation) connection).getTargetPorts();
			if (! targetPorts.isEmpty()) {
				return targetPorts.get(0);
			}
		}
		return null;
	}
	
	/**
	 * Deletes the entity
	 * @param entity
	 */
	public void deleteEntity(EObject entity) {
	}
	
	/**
	 * Deletes the port
	 * @param port
	 */
	public void deletePort(EObject port) {
	}
	
	/**
	 * Deletes the connection
	 * @param connection
	 */
	public void deleteConnection(EObject connection) {
	}
	
	/**
	 * Create the top-level root object
	 * @return
	 */
	public EObject createModelRoot(String name) {
		EntityFolder entityFolder = xactorFactory.createEntityFolder();
		entityFolder.setName(name);
		return entityFolder;
	}
}
