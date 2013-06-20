package org.ptolemy.xtext.lib.caltrop;

import java.util.Iterator;

import org.ptolemy.xtext.lib.caltrop.EventQueue.Entry;

import ptolemy.actor.AtomicActor;
import ptolemy.actor.Director;
import ptolemy.actor.IOPort;
import ptolemy.actor.NoRoomException;
import ptolemy.actor.util.Time;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NamedObj;

public abstract class AbstractActorImpl implements CaltropActorImpl {

	public abstract AtomicActor getActor();

	protected Director getDirector() {
		return getActor().getDirector();
	}
	
	protected <T> T get(String id, Class<T> c) {
		AtomicActor actor = getActor();
		NamedObj container = actor.getContainer();
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
		if (_eventQueue == null) {
			_eventQueue = new EventQueue();
		}
		_eventQueue.addUnsorted(time, source, name, qualifier, arguments);
	}
	
	protected Object[] getEvent(Object source, String name, String qualifier) throws IllegalActionException {
		Iterator<Entry> entries = _eventQueue.entriesBefore(getDirector().getModelTime().getLongValue());
		while (entries.hasNext()) {
			EventQueue.Entry entry = entries.next();
			Object[] match = entry.match(source, name, qualifier);
			if (match != null) {
				return match;
			}
		}
		return null;
	}

	protected boolean hasEvent(Object source, String name, String qualifier) throws IllegalActionException {
		return getEvent(source, name, qualifier) != null;
	}
	
	@Override
	public void initialize() throws IllegalActionException {
		step = 0;
	}

	public abstract AbstractActionImpl fireImpl() throws IllegalActionException;

	private AbstractActionImpl actionImpl = null;

	@Override
	public boolean fire() throws IllegalActionException {
		if (_sendQueue != null) {
			_sendQueue.clearUnsorted();
			_sendQueue.sendCurrent(getDirector().getModelTime().getLongValue());
		}
		actionImpl = fireImpl();
		if (actionImpl != null) {
			actionImpl.body();
			actionImpl.output();
			return true;
		}
		return false;
	}

	public boolean postfireImpl() throws IllegalActionException {
		return true;
	}

	@Override
	public boolean postfire() throws IllegalActionException {
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
		if (actionImpl != null) {
			actionImpl.update();
		}
		postfireImpl();
		long nextSendTime = (_sendQueue != null ?_sendQueue.getNextTime() : -1);
		long nextEventTime = (_eventQueue != null ?_eventQueue.getNextTime() : -1);
		long nextTime = (nextSendTime < 0 ? nextEventTime : (nextEventTime < 0 ? nextSendTime : Math.min(nextSendTime,  nextEventTime)));
		if (nextTime >= currentTime) {
			getDirector().fireAt(getActor(), new Time(getDirector(), nextTime));
		}
		return postfireImpl();
	}

	@Override
	public void wrapup() throws IllegalActionException {
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
