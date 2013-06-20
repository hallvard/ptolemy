package org.ptolemy.xtext.lib.caltrop;

public interface ObjectProvider {
	public <T> T get(String id, Class<T> c);
}
