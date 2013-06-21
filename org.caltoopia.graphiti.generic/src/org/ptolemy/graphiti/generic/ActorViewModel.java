package org.ptolemy.graphiti.generic;

import org.eclipse.emf.ecore.EObject;

public interface ActorViewModel extends EntityViewModel {

	public enum PortKind {
		INPUT, // can be the source of a connection
		OUTPUT, // can be the target of a connection,
		IO // can be both a target and a source of a connection;
	}

	/**
	 * Determines if the eObject is a port of the specified portKind.
	 * If portKind is null, just determines if eObject is a port at all.
	 * @param eObject
	 * @param portKind
	 * @return
	 */
	public boolean isPort(EObject eObject, PortKind portKind);

	/**
	 * Returns the ports contained by the actor. The portKinds arguments control which ports to include,
	 * no arguments means return all.
	 * @param actor
	 * @param portKinds the kinds of ports to include, no kinds means all kinds
	 * @return
	 */
	public Iterable<? extends EObject> getPorts(EObject actor, PortKind... portKinds);

	/**
	 * Determines if the port is a multi port
	 * @param port
	 * @return
	 */
	public boolean isMulti(EObject port);
}
