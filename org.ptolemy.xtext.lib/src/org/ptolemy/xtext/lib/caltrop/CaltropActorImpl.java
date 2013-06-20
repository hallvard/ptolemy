package org.ptolemy.xtext.lib.caltrop;

import ptolemy.actor.AtomicActor;
import ptolemy.actor.Director;
import ptolemy.kernel.util.IllegalActionException;

public interface CaltropActorImpl {

	public void initialize() throws IllegalActionException;
	public boolean fire() throws IllegalActionException;
	public boolean postfire() throws IllegalActionException;
	
	public void wrapup() throws IllegalActionException;
	
	public AtomicActor getActor();
}
