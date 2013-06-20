package org.ptolemy.xtext.lib.caltrop;

import ptolemy.actor.IOPort;
import ptolemy.actor.util.Dependency;
import ptolemy.kernel.util.IllegalActionException;

public abstract class AbstractActionImpl {
	
	public abstract boolean match() throws IllegalActionException;

	public void body() throws IllegalActionException {
	}
	
	public abstract void output() throws IllegalActionException;


	public boolean update() throws IllegalActionException {
		return true;
	}
	
	public abstract Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies();
}
