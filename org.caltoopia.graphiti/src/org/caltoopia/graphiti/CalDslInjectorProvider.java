package org.caltoopia.graphiti;

import org.caltoopia.frontend.ui.internal.CalActivator;
import org.ptolemy.graphiti.generic.editor.DslInjectorProvider;

import com.google.inject.Injector;
import com.google.inject.Provides;

public class CalDslInjectorProvider implements DslInjectorProvider {

	@Override
	public Injector getDslInjector() {
		return CalActivator.getInstance().getInjector("org.caltoopia.frontend.Cal");
	}
}
