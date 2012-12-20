package org.ptolemy.xtext.lib.caltrop;

import ptolemy.actor.TypedAtomicActor;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("serial")
public abstract class AbstractCaltropActor extends TypedAtomicActor {

	public AbstractCaltropActor(CompositeEntity container, String name) throws IllegalActionException, NameDuplicationException {
		super(container, name);
	}

	protected abstract AbstractActorImpl _getImpl();
	
	@Override
	public void preinitialize() throws IllegalActionException {
		super.preinitialize();
		_getImpl().preinitialize();
	}

	@Override
	public void initialize() throws IllegalActionException {
		super.initialize();
		_getImpl().initialize();
	}

	@Override
	public boolean prefire() throws IllegalActionException {
		return super.prefire() && _getImpl().prefire();
	}

	@Override
	public void fire() throws IllegalActionException {
		super.fire();
		_getImpl().fire();
	}

	@Override
	public boolean postfire() throws IllegalActionException {
		return _getImpl().postfire() && super.postfire();
	}

	@Override
	public void wrapup() throws IllegalActionException {
		_getImpl().wrapup();
		super.wrapup();
	}
}
