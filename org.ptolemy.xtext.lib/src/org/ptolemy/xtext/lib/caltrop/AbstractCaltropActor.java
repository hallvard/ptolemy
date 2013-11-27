package org.ptolemy.xtext.lib.caltrop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ptolemy.xtext.lib.caltrop.tuple.Tuple2;
import org.ptolemy.xtext.lib.caltrop.tuple.Tuple3;

import ptolemy.actor.Actor;
import ptolemy.actor.IOPort;
import ptolemy.actor.NoRoomException;
import ptolemy.actor.TypedAtomicActor;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.actor.util.Time;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.Port;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

@SuppressWarnings("serial")
public abstract class AbstractCaltropActor extends TypedAtomicActor {

	public AbstractCaltropActor(CompositeEntity container, String name) throws IllegalActionException, NameDuplicationException {
		super(container, name);
	}

	protected <T> T get(Class<T> c) {
		return get(null, c);
	}

	protected void realmAsyncExec(String realmKey, Runnable runnable) throws IllegalActionException {
		RealmHandler realmHandler = get(realmKey, RealmHandler.class);
		if (realmHandler != null) {
			realmHandler.realmAsyncExec(runnable);
		} else {
			warn("No RealmHandler for " + realmKey, null);
			runnable.run();
		}
	}
	protected void realmSyncExec(String realmKey, Runnable runnable) throws IllegalActionException {
		RealmHandler realmHandler = get(realmKey, RealmHandler.class);
		if (realmHandler != null) {
			realmHandler.realmSyncExec(runnable);
		} else {
			warn("No RealmHandler for " + realmKey, null);
			runnable.run();
		}
	}
	
	protected <T> T get(String id, Class<T> c) {
		return get(id, c, this);
	}

	public static <T> T get(String id, Class<T> c, NamedObj origin) {
		NamedObj container = origin;
		while (container != null) {
			String objectId = (id != null ? id : origin.getName(container));
			T result = get1(objectId, c, container);
			if (result != null) {
				return result;
			}
			container = container.getContainer();
		}
		return (T) null;
	}
	
	public static <T> T get1(String objectId, Class<T> c, NamedObj container) {
		for (ObjectProvider objectProvider : container.attributeList(ObjectProvider.class)) {
			T object = objectProvider.get(objectId, c);
			if (object != null) {
				return object;
			}
		}
		return null;
	}
	
	protected int step;

	private SendQueue _sendQueue = null;
	
	private Logger logger = null;
	
	protected String getLoggerName(Actor actor) {
//		return actor.getClass().getName();
		return actor.getFullName();
	}
	
	protected Logger getLogger() {
		if (logger == null) {
			String loggerName = getLoggerName(this);
			while (loggerName.startsWith(".")) {
				loggerName = loggerName.substring(1);
			}
			logger = Logger.getLogger(loggerName);
		}
		return logger;
	}

	protected String logPort(Port port) {
		return port.getName();
	}

	protected String logActor(Actor actor) {
		return getLoggerName(actor);
	}
	
	protected String logThis() {
		return logActor(this);
	}

	protected void trace(String message, Throwable e) {
		getLogger().log(Level.FINE, logThis() + " - " + message, e);
	}
	protected void debug(String message, Throwable e) {
		getLogger().log(Level.INFO, logThis() + " - " + message, e);
	}
	protected void warn(String message, Throwable e) {
		getLogger().log(Level.WARNING, logThis() + " - " + message, e);
	}
	protected void error(String message, Throwable e) {
		getLogger().log(Level.SEVERE, logThis() + " - " + message, e);
	}
	
	protected boolean hasToken(IOPort port, int channel, int count) throws IllegalActionException {
		boolean hasToken = channel < port.getWidth() && (count == 1 ? port.hasToken(channel) : port.hasToken(channel, count));
		if (hasToken) {
			debug("Found " + count + " tokens on " + logPort(port), null);
		} else {
			trace("Didn't find " + count + " tokens on " + logPort(port), null);
		}
		return hasToken;
	}
	
	protected void send(IOPort port, int channel, Token token, int delay) throws NoRoomException, IllegalActionException {
		debug("Sending " + token + " on " + logPort(port), null);
		if (delay < 0) {
			port.send(channel, token);
		} else {
			if (_sendQueue == null) {
				_sendQueue = new SendQueue();
			}
			_sendQueue.addUnsorted(getDirector().getModelTime().getLongValue() + delay, port, channel, token);
		}
	}
	
	protected void send(IOPort port, int channel, Token[] tokens, int delay) throws NoRoomException, IllegalActionException {
		debug("Sending " + tokens.length + " tokens on " + logPort(port), null);
		if (delay < 0) {
			port.send(channel, tokens, tokens.length);
		} else {
			if (_sendQueue == null) {
				_sendQueue = new SendQueue();
			}
			_sendQueue.addUnsorted(getDirector().getModelTime().getLongValue() + delay, port, channel, tokens);
		}
	}

	private EventQueue _eventQueue = null;
	
	protected void postEvent(long time, Object source, String name, String qualifier, Object... arguments) {
		debug("Posting " + name + "." + qualifier + " event @ " + time, null);
		if (_eventQueue == null) {
			_eventQueue = new EventQueue();
		}
		_eventQueue.addUnsorted(time, source, name, qualifier, arguments);
		try {
			getDirector().fireAtCurrentTime(this); // (this, new Time(getDirector(), time));
		} catch (IllegalActionException e) {
		}
	}
	
	protected Object[] getEvent(Object source, String name, String qualifier) throws IllegalActionException {
		if (_eventQueue != null) {
			Iterator<EventQueue.Entry> entries = _eventQueue.entriesBefore(getDirector().getModelTime().getLongValue());
			while (entries.hasNext()) {
				EventQueue.Entry entry = entries.next();
				Object[] match = entry.match(source, name, qualifier);
				if (match != null) {
					debug("Matched " + name + "." + qualifier + " event @ " + entry.time, null);
					return match;
				}
			}
		}
		return null;
	}

	protected boolean hasEvent(Object source, String name, String qualifier) throws IllegalActionException {
		return getEvent(source, name, qualifier) != null;
	}
	
	protected void _initializeImpl() throws IllegalActionException {
	}

	@Override
	public void initialize() throws IllegalActionException {
		super.initialize();
		step = 0;
		_initializeImpl();
	}

	protected int _currentState = -1;

	protected Tuple2<Integer, AbstractActionImpl> _fireImpl() throws IllegalActionException {
		return null;
	}

	private Tuple2<Integer, AbstractActionImpl> _stateAction = null;

	@Override
	public void fire() throws IllegalActionException {
		super.fire();
		if (_sendQueue != null) {
			_sendQueue.clearUnsorted();
			_sendQueue.sendCurrent(getDirector().getModelTime().getLongValue());
		}
		trace("Firing @ " + getDirector().getModelTime().getLongValue(), null);
		_stateAction = _fireImpl();
		if (_stateAction != null) {
			debug("Triggering " + (_stateAction.getValue1() < 0 ? _stateAction.getValue2() : _stateAction), null);
			AbstractActionImpl actionImpl = _stateAction.getValue2();
			actionImpl.body();
			actionImpl.output();
		}
	}

	protected boolean _postfireImpl() throws IllegalActionException {
		return true;
	}

	@Override
	public boolean postfire() throws IllegalActionException {
		if (! super.postfire()) return false;
		long currentTime = getDirector().getModelTime().getLongValue();
		if (_sendQueue != null) {
			_sendQueue.removeCurrent(currentTime);
			_sendQueue.sortUnsortet();
		}
		if (_eventQueue != null) {
			_eventQueue.removeCurrent(currentTime);
			_eventQueue.sortUnsortet();
		}
		step++;
		boolean result = true;
		if (_stateAction != null) {
			result = _stateAction.getValue2().update();
			_currentState = _stateAction.getValue1();
			if (_currentState >= 0) {
				debug("Changed to state #" + _currentState, null);
			}
		}
		long nextSendTime = (_sendQueue != null ?_sendQueue.getNextTime() : -1);
		long nextEventTime = (_eventQueue != null ?_eventQueue.getNextTime() : -1);
		long nextTime = (nextSendTime < 0 ? nextEventTime : (nextEventTime < 0 ? nextSendTime : Math.min(nextSendTime,  nextEventTime)));
		if (nextTime >= currentTime) {
			getDirector().fireAt(this, new Time(getDirector(), nextTime));
		}
		return _postfireImpl() && result;
	}

	protected void _wrapupImpl() throws IllegalActionException {
	}

	@Override
	public void wrapup() throws IllegalActionException {
		_wrapupImpl();
	}
	
	//

	private class CausalityInterfaceImpl implements CausalityInterface {

		@Override
		public Actor getActor() {
			return AbstractCaltropActor.this;
		}
		
		@Override
		public Dependency getDefaultDependency() {
			return BooleanDependency.valueOf(false);
		}
		
		private Collection<Tuple3<IOPort, IOPort, Dependency>> dependencies = new ArrayList<Tuple3<IOPort,IOPort,Dependency>>();
		
		public void addDependency(Tuple3<IOPort, IOPort, Dependency> dependency) {
			dependencies.add(dependency);
		}

		public void addDependencies(Tuple3<IOPort, IOPort, Dependency>... dependencies) {
			this.dependencies.addAll(Arrays.asList(dependencies));
		}

		public void addDependency(IOPort inputPort, IOPort outputPort, Dependency dependency) {
			dependencies.add(new Tuple3<IOPort,IOPort, Dependency>(inputPort, outputPort, dependency));
		}
		
		@Override
		public Collection<IOPort> dependentPorts(IOPort port) throws IllegalActionException {
			Collection<IOPort> result = new ArrayList<IOPort>(); 
			if (port instanceof IOPort) {
				IOPort ioPort = (IOPort) port;
				for (Tuple3<IOPort, IOPort, Dependency> dependency : dependencies) {
					if (ioPort.isInput() && dependency.getValue1() == ioPort) {
						result.add(dependency.getValue2());
					}
					if (ioPort.isOutput() && dependency.getValue2() == ioPort) {
						result.add(dependency.getValue1());
					}
				}
			}
			return result;
		}

		@Override
		public Collection<IOPort> equivalentPorts(IOPort inputPort) throws IllegalActionException {
	        if (inputPort.getContainer() != getActor() || (! inputPort.isInput())) {
	            throw new IllegalArgumentException(inputPort.getFullName() + " is not an input port of " + getActor().getFullName());
	        }
	        HashSet<IOPort> result = new HashSet<IOPort>();
	        growDependencies(inputPort, result, new HashSet<IOPort>());
			return result;
		}

		// shamelessly ripped from DefaultCausalityInterface
	    private void growDependencies(IOPort input, Set<IOPort> inputs, Set<IOPort> outputs) throws IllegalActionException {
	        if (! inputs.contains(input)) {
	            inputs.add(input);
	            for (IOPort output : dependentPorts(input)) {
	                // If the output has already been handled, skip it.
	                if (! outputs.contains(output)) {
	                    outputs.add(output);
	                    for (IOPort anotherInput : dependentPorts(output)) {
	                        growDependencies(anotherInput, inputs, outputs);
	                    }
	                }
	            }
	        }
	    }

		@Override
		public Dependency getDependency(IOPort inputPort, IOPort outputPort) throws IllegalActionException {
			for (Tuple3<IOPort, IOPort, Dependency> dependency : dependencies) {
				if (dependency.getValue1() == inputPort && dependency.getValue2() == outputPort) {
					return dependency.getValue3();
				}
			}
			return getDefaultDependency();
		}

		// mutation methods are not supported and will/should not be called by subclasses

		@Override
		public void declareDelayDependency(IOPort inputPort, IOPort outputPort, double timeDelay, int index) {
			throw new UnsupportedOperationException("CausalityInterfaceImpl.declareDelayDependency not supported");
		}

		@Override
		public void removeDependency(IOPort inputPort, IOPort outputPort) {
			throw new UnsupportedOperationException("CausalityInterfaceImpl.removeDependency not supported");
		}
	}

	protected CausalityInterface _getCausalityInterface(AbstractActionImpl... actions) throws IllegalActionException {
		CausalityInterfaceImpl causalityInterface = new CausalityInterfaceImpl();
		for (int i = 0; i < actions.length; i++) {
			AbstractActionImpl actionImpl = actions[i];
			causalityInterface.addDependencies(actionImpl.getDependencies());
		}
		return causalityInterface;
	}
	
	//
	
	protected Integer[] channels(IOPort ioPort, int tokenCount, boolean any, int width) throws IllegalActionException {
		return ChannelMap.channels(ioPort, tokenCount, any, width);
	}
	
	protected Integer[] channels(IOPort ioPort, int tokenCount, boolean any, int[] channels) throws IllegalActionException {
		return ChannelMap.channels(ioPort, tokenCount, any, channels);
	}

	protected Integer[] channels(IOPort ioPort, int tokenCount, boolean any, Iterable<Integer>... channels) throws IllegalActionException {
		return ChannelMap.channels(ioPort, tokenCount, any, channels);
	}

	//

	protected <T> ChannelMap<T> channelMap(Integer[] channels) {
		return ChannelMap.<T>create(channels);
	}

	protected <T> ChannelMap<T> channelMap(IOPort ioPort, int tokenCount, boolean any, int width) throws IllegalActionException {
		return ChannelMap.<T>create(ioPort, tokenCount, any, width);
	}
	
	protected <T> ChannelMap<T> channelMap(IOPort ioPort, int tokenCount, boolean any, int[] channels) throws IllegalActionException {
		return ChannelMap.<T>create(ioPort, tokenCount, any, channels);
	}
	
	protected <T> ChannelMap<T> channelMap(IOPort ioPort, int tokenCount, boolean any, Iterable<Integer>... channels) throws IllegalActionException {
		return ChannelMap.<T>create(ioPort, tokenCount, any, channels);
	}

}
