package org.ptolemy.xtext.lib.caltrop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.ptolemy.xtext.lib.caltrop.EventQueue.Entry;

import ptolemy.actor.Actor;
import ptolemy.actor.IOPort;
import ptolemy.actor.NoRoomException;
import ptolemy.actor.TypedAtomicActor;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.DefaultCausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.actor.util.Time;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

@SuppressWarnings("serial")
public abstract class AbstractCaltropActor extends TypedAtomicActor {

	public AbstractCaltropActor(CompositeEntity container, String name) throws IllegalActionException, NameDuplicationException {
		super(container, name);
	}
	
	protected <T> T get(String id, Class<T> c) {
		NamedObj container = this;
		while (container != null) {
			for (ObjectProvider objectProvider : container.attributeList(ObjectProvider.class)) {
				T object = objectProvider.get(id, c);
				if (object != null) {
					return object;
				}
			}
			container = container.getContainer();
		}
		return (T) null;
	}
	
	protected boolean hasToken(IOPort port, int channel, int count) throws IllegalActionException {
		return (count == 1 ? port.hasToken(channel) : port.hasToken(channel, count));
	}
	
	protected int step;

	private SendQueue _sendQueue = null;
	
	protected void send(IOPort port, int channel, Token token, int delay) throws NoRoomException, IllegalActionException {
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
		System.out.println("Posting " + name + "." + qualifier + " event @ " + time);
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
		Iterator<Entry> entries = _eventQueue.entriesBefore(getDirector().getModelTime().getLongValue());
		while (entries.hasNext()) {
			EventQueue.Entry entry = entries.next();
			Object[] match = entry.match(source, name, qualifier);
			if (match != null) {
				System.out.println("Matched " + name + "." + qualifier + " event @ " + entry.time);
				return match;
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

	protected int currentState = -1;

	protected Pair<Integer, AbstractActionImpl> _fireImpl() throws IllegalActionException {
		return null;
	}

	private Pair<Integer, AbstractActionImpl> stateAction = null;

	@Override
	public void fire() throws IllegalActionException {
		super.fire();
		if (_sendQueue != null) {
			_sendQueue.clearUnsorted();
			_sendQueue.sendCurrent(getDirector().getModelTime().getLongValue());
		}
		stateAction = _fireImpl();
		if (stateAction != null) {
			AbstractActionImpl actionImpl = stateAction.getValue();
			actionImpl.body();
			actionImpl.output();
		}
	}

	protected boolean _postfireImpl() {
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
		if (stateAction != null) {
			result = stateAction.getValue().update();
			currentState = stateAction.getKey();
		}
		long nextSendTime = (_sendQueue != null ?_sendQueue.getNextTime() : -1);
		long nextEventTime = (_eventQueue != null ?_eventQueue.getNextTime() : -1);
		long nextTime = (nextSendTime < 0 ? nextEventTime : (nextEventTime < 0 ? nextSendTime : Math.min(nextSendTime,  nextEventTime)));
		if (nextTime >= currentTime) {
			getDirector().fireAt(this, new Time(getDirector(), nextTime));
		}
		return _postfireImpl() && result;
	}

	protected void _wrapupImpl() {
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
		
		private Collection<Pair<Pair<IOPort, IOPort>, Dependency>> dependencies = new ArrayList<Pair<Pair<IOPort,IOPort>,Dependency>>();
		
		public void addDependency(Pair<Pair<IOPort, IOPort>, Dependency> dependency) {
			dependencies.add(dependency);
		}

		public void addDependencies(Pair<Pair<IOPort, IOPort>, Dependency>... dependencies) {
			this.dependencies.addAll(Arrays.asList(dependencies));
		}

		public void addDependency(IOPort inputPort, IOPort outputPort, Dependency dependency) {
			dependencies.add(new Pair.Impl<Pair<IOPort,IOPort>, Dependency>(new Pair.Impl<IOPort, IOPort>(inputPort, outputPort), dependency));
		}
		
		@Override
		public Collection<IOPort> dependentPorts(IOPort port) throws IllegalActionException {
			Collection<IOPort> result = new ArrayList<IOPort>(); 
			if (port instanceof IOPort) {
				IOPort ioPort = (IOPort) port;
				for (Pair<Pair<IOPort, IOPort>, Dependency> dependency : dependencies) {
					Pair<IOPort, IOPort> key = dependency.getKey();
					if (ioPort.isInput() && key.getKey() == ioPort) {
						result.add(key.getValue());
					}
					if (ioPort.isOutput() && key.getValue() == ioPort) {
						result.add(key.getKey());
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
			for (Pair<Pair<IOPort, IOPort>, Dependency> dependency : dependencies) {
				Pair<IOPort, IOPort> key = dependency.getKey();
				if (key.getKey() == inputPort && key.getValue() == outputPort) {
					return dependency.getValue();
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
