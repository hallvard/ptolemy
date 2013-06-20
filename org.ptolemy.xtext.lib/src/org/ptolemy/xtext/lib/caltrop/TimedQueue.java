package org.ptolemy.xtext.lib.caltrop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ptolemy.actor.NoRoomException;
import ptolemy.kernel.util.IllegalActionException;

public class TimedQueue<T extends TimedQueue.Entry> {
	
	protected static class Entry {
		protected final long time;
		protected Entry(long time) {
			super();
			this.time = time;
		}
	}

	private List<T> queue = null;
	private int sortPos = 0;

	public void clearUnsorted() {
		if (queue == null) {
			return;
		}
		while (queue.size() > sortPos) {
			queue.remove(queue.size());
		}
	}
	public void addUnsorted(T entry) {
		if (queue == null) {
			queue = new ArrayList<T>();
		}
		queue.add(entry);
	}
	
	public void sortUnsortet() {
		if (queue == null) {
			return;
		}
		while (sortPos < queue.size()) {
			T sortEntry = queue.get(sortPos);
			for (int pos = sortPos - 1; pos >= 0; pos--) {
				T entry = queue.get(pos);
				if (entry.time < sortEntry.time) {
					queue.set(pos + 1, sortEntry);
					break;
				}
				queue.set(pos + 1, entry);
			}
			sortPos++;
		}
	}
	
	public Iterator<T> entriesBefore(long currentTime) {
		Collection<T> entries = new ArrayList<T>();
		if (queue != null) {
			for (int i = 0; i < sortPos; i++) {
				T entry = queue.get(i);
				if (entry.time <= currentTime) {
					entries.add(entry);
				}
			}
		}
		return entries.iterator();
	}

	public void removeCurrent(long currentTime) throws NoRoomException, IllegalActionException {
		if (queue == null) {
			return;
		}
		int count = 0;
		for (int i = 0; i < queue.size(); i++) {
			T entry = queue.get(i);
			if (i < sortPos && entry.time <= currentTime) {
				count++;
			} else {
				queue.set(i - count, entry);
			}
		}
		sortPos -= count;
		while (count-- > 0) {
			queue.remove(queue.size() - 1);
		}
	}
	
	public long getNextTime() {
		return (sortPos > 0 ? queue.get(0).time : -1);
	}
}
