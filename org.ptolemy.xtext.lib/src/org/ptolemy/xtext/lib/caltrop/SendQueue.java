package org.ptolemy.xtext.lib.caltrop;

import java.util.Iterator;

import ptolemy.actor.IOPort;
import ptolemy.actor.NoRoomException;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class SendQueue extends TimedQueue<SendQueue.Entry> {
	
	protected static class Entry extends TimedQueue.Entry {
		
		private IOPort port;
		private int channel;
		private Token token;
		private Token[] tokens;

		private Entry(long time, IOPort port, int channel, Token token, Token[] tokens) {
			super(time);
			this.port = port;
			this.channel = channel;
			this.tokens = tokens;
		}
		
		void send() throws NoRoomException, IllegalActionException {
			if (token != null) {
				port.send(channel, token);
			}
			if (tokens != null && tokens.length > 0) {
				port.send(channel, tokens, tokens.length);
			}
		}
	}

	public void addUnsorted(long time, IOPort port, int channel, Token token) {
		addUnsorted(new Entry(time, port, channel, token, null));
	}

	public void addUnsorted(long time, IOPort port, int channel, Token[] tokens) {
		addUnsorted(new Entry(time, port, channel, null, tokens));
	}
	
	public void sendCurrent(long currentTime) throws NoRoomException, IllegalActionException {
		Iterator<Entry> entries = entriesBefore(currentTime);
		while (entries.hasNext()) {
			Entry entry = entries.next();
			entry.send();
		}
	}
}
