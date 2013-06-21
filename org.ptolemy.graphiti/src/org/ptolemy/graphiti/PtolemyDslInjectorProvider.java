package org.ptolemy.graphiti;

import org.ptolemy.graphiti.generic.editor.DslInjectorProvider;

import com.google.inject.Injector;

public class PtolemyDslInjectorProvider implements DslInjectorProvider {

	@Override
	public Injector getDslInjector() {
		return Activator.getDefault().getInjector();
	}
}
