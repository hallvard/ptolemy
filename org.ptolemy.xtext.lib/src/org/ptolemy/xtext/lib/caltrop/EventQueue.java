package org.ptolemy.xtext.lib.caltrop;

import ptolemy.kernel.util.IllegalActionException;

public class EventQueue extends TimedQueue<EventQueue.Entry> {
	
	protected static class Entry extends TimedQueue.Entry {

		private Object source;
		private String name, qualifier;
		private Object[] arguments;

		
		public Entry(long time, Object source, String name, String qualifier, Object[] arguments) {
			super(time);
			this.source = source;
			this.name = name;
			this.qualifier = qualifier;
			this.arguments = arguments;
		}

		public Object[] match(Object source, String name, String qualifier) throws IllegalActionException {
			if (! this.source.equals(source)) {
				return null;
			}
			if (! this.name.equals(name)) {
				return null;
			}
			if (qualifier != null && (! this.qualifier.equals(qualifier))) {
				return null;
			}
			return arguments;
		}
	}

	public void addUnsorted(long time, Object source, String name, String qualifier, Object[] arguments) {
		addUnsorted(new Entry(time, source, name, qualifier, arguments));
	}
}
