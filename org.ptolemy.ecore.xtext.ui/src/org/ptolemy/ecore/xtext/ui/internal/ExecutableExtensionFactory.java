package org.ptolemy.ecore.xtext.ui.internal;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.ptolemy.ecore.xtext.ui.Activator;

import com.google.inject.Injector;

public class ExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return Activator.getDefault().getInjector();
	}

}

