package org.ptolemy.xtext.lib.caltrop;

public interface Actor {

	void initialize();
	void wrapup();
	
	public class Impl implements Actor {
		public void initialize() {}
		public void wrapup() {}
	}
}
