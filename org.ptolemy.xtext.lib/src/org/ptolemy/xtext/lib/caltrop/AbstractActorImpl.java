package org.ptolemy.xtext.lib.caltrop;

import java.lang.reflect.Method;

import ptolemy.actor.AtomicActor;
import ptolemy.actor.Director;
import ptolemy.actor.IOPort;
import ptolemy.kernel.util.IllegalActionException;

public abstract class AbstractActorImpl implements CaltropActorImpl {

	protected AbstractActorImpl(AbstractCaltropActor actor) {
		// ignore
	}
	
	@Override
	public Director getDirector() {
		return getActor().getDirector();
	}

	private String _doMethodName = null;
	private Object[] _doMethodArgs = null;
	
	private String _outputMethodName = null;
	private Object[] _outputMethodArgs = null;

	protected void _setDoMethod(String methodName, Object... methodArgs) {
		this._doMethodName = methodName;
		this._doMethodArgs = methodArgs;
	}
	protected boolean _callMethod(String methodName, Object[] methodArgs, Object[] extraArgs) {
		if (methodName == null || methodArgs == null) {
			return false;
		}
		Object[] args = methodArgs;
		if (extraArgs != null && extraArgs.length > 0) {
			args = new Object[methodArgs.length + extraArgs.length];
			System.arraycopy(methodArgs, 0, args, 0, methodArgs.length);
			System.arraycopy(extraArgs, 0, args, methodArgs.length, extraArgs.length);
		}
		Method[] methods = getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().equals(methodName)) {
				try {
					method.invoke(this, methodArgs);
				} catch (Exception e) {
				}
				return true;
			}
		}
		return false;
	}
	protected boolean _callDoMethod(Object... extraArgs) {
		return _callMethod(_doMethodName, _doMethodArgs, extraArgs);
	}
	protected void _clearDoMethod() {
		this._doMethodName = null;
		this._doMethodArgs = null;
	}
	
	protected void _setOutputMethod(String method, Object... methodArgs) {
		this._outputMethodName = method;
		this._outputMethodArgs = methodArgs;
	}
	protected boolean _callOutputMethod(Object... extraArgs) {
		return _callMethod(_outputMethodName, _outputMethodArgs, extraArgs);
	}
	protected void _clearOutputMethod() {
		this._outputMethodName = null;
		this._outputMethodArgs = null;
	}

	protected int step;
	
	@Override
	public void preinitialize() throws IllegalActionException {
	}

	@Override
	public void initialize() throws IllegalActionException {
		step = 0;
	}

	@Override
	public boolean prefire() throws IllegalActionException {
		_clearDoMethod();
		_clearOutputMethod();
		return false;
	}

	@Override
	public boolean fire() throws IllegalActionException {
		return true;
	}

	@Override
	public boolean postfire() throws IllegalActionException {
		step++;
		return true;
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
