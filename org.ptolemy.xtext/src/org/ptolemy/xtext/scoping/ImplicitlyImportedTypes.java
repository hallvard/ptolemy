package org.ptolemy.xtext.scoping;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

@Singleton
public class ImplicitlyImportedTypes extends org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes {

	@Override
	protected List<Class<?>> getExtensionClasses() {
		List<Class<?>> classes = new ArrayList<Class<?>>(super.getExtensionClasses());
		classes.add(org.ptolemy.xtext.lib.Extensions.class);
		classes.add(org.ptolemy.xtext.lib.caltrop.tokens.Extensions.class);
		return classes;
	}
}
