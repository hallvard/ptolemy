package org.ptolemy.xtext.lib.caltrop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import ptolemy.actor.IOPort;
import ptolemy.kernel.util.IllegalActionException;

public class ChannelMap<T> implements Iterable<Integer> {
	
	private int[] channels;
	private List<T> values;

	private ChannelMap(int size) {
		values = new ArrayList<T>(size);
		while (size-- > 0) {
			values.add(null);
		}
	}
	private ChannelMap(int[] channels) {
		this(channels.length);
		this.channels = channels;
	}
	private ChannelMap(Iterable<Integer> channels, int size) {
		this(size);
		this.channels = new int[size];
		int pos = 0;
		for (int channel : channels) {
			this.channels[pos++] = channel;
		}
	}
	private ChannelMap(Integer[] channels) {
		this(Arrays.asList(channels), channels[channels.length - 1] + 1);
	}

	public ChannelMap<T> copy() {
		return new ChannelMap<T>(channels);
	}

	public <T2> ChannelMap<T2> copy(Class<T2> c) {
		return new ChannelMap<T2>(channels);
	}

	public <T2> ChannelMap<T2> transform(Class<T2> c, Function1<T, T2> transform) {
		ChannelMap<T2> copy = copy(c);
		for (int channel : this) {
			copy.put(channel, transform.apply(this.get(channel)));
		}
		return copy;
	}
	
	static <T> ChannelMap<T> create(Integer[] channels) {
		return new ChannelMap<T>(channels);
	}
	
	public boolean isEmpty() {
		return channels.length == 0;
	}
	
	protected int pos(int channel) {
		if (channels.length > channel && channels[channel] == channel) {
			return channel;
		}
		for (int i = 0; i < channels.length; i++) {
			if (channels[i] == channel) {
				return i;
			}
		}
		return -1;
	}

	public void put(int channel, T value) {
		values.set(pos(channel), value);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int pos = 0;
			@Override
			public boolean hasNext() {
				return pos < channels.length;
			}
			@Override
			public Integer next() {
				return channels[pos++];
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException("ChannelMap's iterator does not support remove()");
			}
		};
	}

	public T get(int channel) {
		return values.get(pos(channel));
	}

	public Iterator<T> values() {
		return values.iterator();
	}

	//
	
	static Integer[] channels(IOPort ioPort, int tokenCount, boolean any, int width) throws IllegalActionException {
		Integer[] channels = new Integer[width];
		for (int channel = 0; channel < width; channel++) {
			if (ioPort.hasToken(channel, tokenCount)) {
				channels[channel] = channel;
			} else if (! any) {
				return null;
			} else {
				channels[channel] = -1;
			}
		}
		return channels;
	}
	static <T> ChannelMap<T> create(IOPort ioPort, int tokenCount, boolean any, int width) throws IllegalActionException {
		return new ChannelMap<T>(channels(ioPort, tokenCount, any, width));
	}

	static Integer[] channels(IOPort ioPort, int tokenCount, boolean any, int[] channelIds) throws IllegalActionException {
		List<Integer> channels = new ArrayList<Integer>(channelIds.length);
		for (int i = 0; i < channelIds.length; i++) {
			int channel = channelIds[i];
			if (ioPort.hasToken(channel, tokenCount)) {
				channels.add(channel);
			} else if (! any){
				return null;
			}
		}
		Collections.sort(channels);
		return channels.toArray(new Integer[channels.size()]);
	}	
	static <T> ChannelMap<T> create(IOPort ioPort, int tokenCount, boolean any, int[] channels) throws IllegalActionException {
		return new ChannelMap<T>(channels(ioPort, tokenCount, any, channels));
	}
	
	static Integer[] channels(IOPort ioPort, int tokenCount, boolean any, Iterable<Integer>... channelIds) throws IllegalActionException {
		List<Integer> channels = new ArrayList<Integer>(channelIds.length);
		for (int i = 0; i < channelIds.length; i++) {
			for (int channel : channelIds[i]) {
				if (ioPort.hasToken(channel, tokenCount)) {
					channels.add(channel);
				} else if (! any){
					return null;
				}
			}
		}
		Collections.sort(channels);
		return channels.toArray(new Integer[channels.size()]);
	}
	static <T> ChannelMap<T> create(IOPort ioPort, int tokenCount, boolean any, Iterable<Integer>... channels) throws IllegalActionException {
		return new ChannelMap<T>(channels(ioPort, tokenCount, any, channels));
	}
}
