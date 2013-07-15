/*
 * generated by Xtext
 */
package org.ptolemy.graphiti.generic.editor;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.ptolemy.graphiti.generic.Activator;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public abstract class ActorDiagramEditorExecutableExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension {

	protected String className;
	protected String named;
	protected String propertyName;
	protected IConfigurationElement config;

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		this.config = config;
		this.propertyName = propertyName;
		if (data instanceof String) {
			className = (String) data;
		} else if (data instanceof Map<?, ?>) {
			Map<String, String> map = (Map<String, String>) data;
			className = map.get("class");
			named = map.get("named");
		}
	}
	
	public Object create() throws CoreException {
		try {
			final Injector injector = getInjector();
			int pos = className.indexOf('#');
			if (pos > 0) {
				named = className.substring(pos + 1);
				className = className.substring(0, pos);
			}
			Class<?> c = getBundle().loadClass(className);
			Key<? extends Object> key = (named != null ? Key.get((Class<? extends Object>) c, Names.named(named)) : Key.get((Class<? extends Object>) c));
			final Object result = injector.getInstance(key);
			if (result instanceof IExecutableExtension) {
				((IExecutableExtension) result).setInitializationData(config, propertyName, null);
			}
			return result;
		}
		catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, getBundle().getSymbolicName(), e.getMessage() + " ExtensionFactory: "+ getClass().getName(), e));
		}
	}

	protected abstract Bundle getBundle();

	protected abstract Injector getInjector();
}
