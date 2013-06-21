package org.caltoopia.graphiti;

import java.util.ArrayList;
import java.util.Collection;

import org.caltoopia.frontend.cal.AstAbstractActor;
import org.caltoopia.frontend.cal.AstActor;
import org.caltoopia.frontend.cal.AstActorVariable;
import org.caltoopia.frontend.cal.AstActorVariableReference;
import org.caltoopia.frontend.cal.AstConnection;
import org.caltoopia.frontend.cal.AstEntity;
import org.caltoopia.frontend.cal.AstExternalActor;
import org.caltoopia.frontend.cal.AstNamespace;
import org.caltoopia.frontend.cal.AstNetwork;
import org.caltoopia.frontend.cal.AstPort;
import org.caltoopia.frontend.cal.AstStructure;
import org.caltoopia.frontend.cal.CalFactory;
import org.caltoopia.frontend.cal.CalPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.ptolemy.graphiti.generic.AbstractViewModel;
import org.ptolemy.graphiti.generic.ActorContainerEditModel;
import org.ptolemy.graphiti.generic.ActorEditModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.ConnectionContainerEditModel;
import org.ptolemy.graphiti.generic.EntityViewModel;

import com.google.inject.Inject;

public class CalModelFacade extends AbstractViewModel implements ActorEditModel, ActorContainerEditModel, ConnectionContainerEditModel {

	/**
	 * Returns the (simple) name of the eObject
	 * @param eObject
	 * @return
	 */
	@Override
	public String getName(EObject eObject) {
		if (eObject instanceof AstEntity) {
			return getName(((AstEntity) eObject).getActor());
		}
		return super.getName(eObject);
	}

	/**
	 * Determines if the eObject is an entity of the specified kind.
	 * If entityKind is null, just determines if eObject is an entity at all.
	 * @param eObject
	 * @param entityKind
	 * @return
	 */
	public boolean isEntity(EObject eObject, EntityViewModel.EntityKind entityKind) {
		if (eObject instanceof AstActorVariable) {
			eObject = ((AstActorVariable) eObject).getType();
		}
		if (entityKind == null) {
			return eObject instanceof AstEntity || eObject instanceof AstNetwork || eObject instanceof AstNamespace;
		}
		switch (entityKind) {
		case ATOMIC_ACTOR:
			return isAtomicActor(eObject);
		case COMPOSITE_ACTOR:
			return isNetwork(eObject);
		case ENTITY_NAMESPACE:
			return eObject instanceof AstNamespace;
		case ACTOR_CONTAINER:
			return isNetwork(eObject) || eObject instanceof AstNamespace;
		case ACTOR:
			return eObject instanceof AstEntity;
		}
		return false;
	}

	private boolean isAtomicActor(EObject eObject) {
		return eObject instanceof AstActor || eObject instanceof AstExternalActor || eObject instanceof AstEntity && isAtomicActor(((AstEntity) eObject).getActor());
	}

	private boolean isNetwork(EObject eObject) {
		return eObject instanceof AstNetwork || eObject instanceof AstEntity && isNetwork(((AstEntity) eObject).getActor());
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
			return eObject instanceof AstPort;
		}
		EStructuralFeature feature = eObject.eContainingFeature();
		switch (portKind) {
		case INPUT: return feature == CalPackage.eINSTANCE.getAstAbstractActor_Inputs();
		case OUTPUT: return feature == CalPackage.eINSTANCE.getAstAbstractActor_Outputs();
		}
		return false;
	}
	
	@Inject
	private CalFactory calFactory;
	
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
			AstEntity entity = calFactory.createAstEntity();
			AstActor actor = calFactory.createAstActor();
			actor.setName(name);
			entity.setActor(actor);
			newEntity = entity;
		}
		case COMPOSITE_ACTOR: {
			AstEntity entity = calFactory.createAstEntity();
			AstNetwork actor = calFactory.createAstNetwork();
			AstStructure connections = calFactory.createAstStructure();
			actor.setStructure(connections);
			actor.setName(name);
			entity.setActor(actor);
			newEntity = entity;
		}
		case ACTOR_CONTAINER:
		case ENTITY_NAMESPACE: {
			AstNamespace entity = calFactory.createAstNamespace();
			entity.setName(name);
			newEntity = entity;
		}
		}
		if (newEntity != null) {
			addEntity(newEntity, actorContainer);
		}
		return newEntity;
	}

	protected EObject addEntity(EObject entity, EObject entityContainer) {
		if (entity instanceof AstActorVariable && entityContainer instanceof AstNetwork) {
			((AstNetwork) entityContainer).getInstances().add((AstActorVariable) entity);
		} else if (entity instanceof AstEntity && entityContainer instanceof AstNamespace) {
			((AstNamespace) entityContainer).getEntities().add((AstEntity) entity);
		} else if (entity instanceof AstNamespace && entityContainer instanceof AstNamespace) {
			((AstNamespace) entityContainer).getNamespaces().add((AstNamespace) entity);
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
		AstActorVariable entity = calFactory.createAstActorVariable();
		entity.setName(name);
		return entity;
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
		if (actorContainer instanceof AstActorVariable) {
			actorContainer = ((AstActorVariable) actorContainer).getType();
		}
		if (actorContainer instanceof AstEntity) {
			actorContainer = ((AstEntity) actorContainer).getActor();
		}
		if (actorContainer instanceof AstNetwork) {
			addEntities(((AstNetwork) actorContainer).getInstances(), EntityKind.ACTOR, entityKinds, entities);
		} else if (actorContainer instanceof AstNamespace) {
			addEntities(((AstNamespace) actorContainer).getEntities(), EntityKind.ACTOR, entityKinds, entities);
			addEntities(((AstNamespace) actorContainer).getNamespaces(), EntityKind.ENTITY_NAMESPACE, entityKinds, entities);
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
		if (compositeActor instanceof AstEntity) {
			compositeActor = ((AstEntity) compositeActor).getActor();
		}
		if (compositeActor instanceof AstNetwork) {
			compositeActor = ((AstNetwork) compositeActor).getStructure();
		}
		if (compositeActor instanceof AstStructure) {
			connections.addAll(((AstStructure) compositeActor).getConnections());
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
		if (actor instanceof AstActorVariable) {
			actor = ((AstActorVariable) actor).getType();
		}
		if (actor instanceof AstEntity) {
			actor = ((AstEntity) actor).getActor();
		}
		if (actor instanceof AstAbstractActor) {
			AstAbstractActor abstractActor = (AstAbstractActor) actor;
			addPorts(abstractActor.getInputs(), PortKind.INPUT, portKinds, ports);
			addPorts(abstractActor.getOutputs(), PortKind.OUTPUT, portKinds, ports);
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
		AstPort port = calFactory.createAstPort();
		port.setName(name);
		if (actor instanceof AstEntity) {
			AstEntity entity = (AstEntity) actor;
			if (portKind == PortKind.INPUT) {
				entity.getActor().getInputs().add(port);
			} else if (portKind == PortKind.OUTPUT) {
				entity.getActor().getOutputs().add(port);
			}
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
		return false;
	}

	/**
	 * Sets the multi port flag of the port 
	 * @param port
	 * @param multi
	 */
	@Override
	public void setMultiPort(EObject port, boolean multi) {
	}

	/**
	 * Returns the actor container that will be the parent of a connection between the provided ports, or
	 * null if they cannot be connected
	 * @param sourcePort
	 * @param targetPort
	 * @return
	 */
	public EObject getConnectionContainer(EObject sourcePort, EObject targetPort) {
		return null;
	}
	
	/**
	 * Creates (and adds) the a connection between the provided ports
	 * @param sourcePort
	 * @param targetPort
	 * @return
	 */
	public EObject createConnection(EObject sourcePort, EObject targetPort) {
		EObject connectionContainer = getConnectionContainer(sourcePort, targetPort);
		if (connectionContainer instanceof AstEntity && ((AstEntity) connectionContainer).getActor() instanceof AstNetwork) {
			AstNetwork network = (AstNetwork) ((AstEntity) connectionContainer).getActor();
			AstConnection connection = calFactory.createAstConnection();
			AstActorVariableReference fromInstanceRef = calFactory.createAstActorVariableReference();
			AstActorVariableReference toInstanceRef = calFactory.createAstActorVariableReference();
			connection.setFrom(fromInstanceRef);
			connection.setOutPort(getName(sourcePort));
			connection.setTo(toInstanceRef);
			connection.setInPort(getName(sourcePort));
			if (network.getStructure() == null) {
				network.setStructure(calFactory.createAstStructure());
			}
			network.getStructure().getConnections().add(connection);
			return connection;
		}
		return null;
	}

	private EObject getConnectionActor(AstConnection connection, AstActorVariableReference varRef) {
		if (varRef != null) {
			return varRef.getVariable();
		} else {
			return (AstEntity) (((AstNetwork) ((AstStructure) connection.eContainer()).eContainer()).eContainer());
		}
	}

	/**
	 * Returns the source actor of the connection
	 * @param connection
	 * @return
	 */
	public EObject getSourceActor(EObject connection) {
		if (connection instanceof AstConnection) {
			return getConnectionActor((AstConnection) connection, ((AstConnection) connection).getFrom());
		}
		return null;
	}

	/**
	 * Returns the target actor of the connection
	 * @param connection
	 * @return
	 */
	public EObject getTargetActor(EObject connection) {
		if (connection instanceof AstConnection) {
			return getConnectionActor((AstConnection) connection, ((AstConnection) connection).getTo());
		}
		return null;
	}

	/**
	 * Returns the source port of the connection
	 * @param connection
	 * @return
	 */
	@Override
	public EObject getSourcePort(EObject connection) {
		if (connection instanceof AstConnection) {
			Iterable<AstPort> ports = null;
			AstActorVariableReference varRef = ((AstConnection) connection).getFrom();
			if (varRef != null) {
				AstAbstractActor actor = varRef.getVariable().getType().getActor();
				if (actor == null) {
					return null;
				}
				ports = actor.getOutputs();
			} else {
				ports = ((AstNetwork) ((AstStructure) connection.eContainer()).eContainer()).getInputs();
			}
			String portName = ((AstConnection) connection).getOutPort();
			return getPort(ports, portName);
		}
		return null;
	}

	protected EObject getPort(Iterable<AstPort> ports, String name) {
		for (AstPort port : ports) {
			if (name.equals(port.getName())) {
				return port;
			}
		}
		return null;
	}
	
	/**
	 * Returns the target port of the connection
	 * @param connection
	 * @return
	 */
	@Override
	public EObject getTargetPort(EObject connection) {
		if (connection instanceof AstConnection) {
			Iterable<AstPort> ports = null;
			AstActorVariableReference varRef = ((AstConnection) connection).getTo();
			if (varRef != null) {
				AstAbstractActor actor = varRef.getVariable().getType().getActor();
				if (actor == null) {
					return null;
				}
				ports = actor.getInputs();
			} else {
				ports = ((AstNetwork) ((AstStructure) connection.eContainer()).eContainer()).getOutputs();
			}
			String portName = ((AstConnection) connection).getInPort();
			return getPort(ports, portName);
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
		AstNamespace astNamespace = calFactory.createAstNamespace();
		astNamespace.setName(name);
		return astNamespace;
	}
}
