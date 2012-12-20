
package org.ptolemy.ecore.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.ptolemy.ecore.actor.util.ActorResourceFactoryImpl;
import org.ptolemy.ecore.xtext.EActorRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EActorStandaloneSetup implements ISetup {

	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new EActorRuntimeModule());
	}
	
	public void register(Injector injector) {
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("eactor", new ActorResourceFactoryImpl());
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("eactor", serviceProvider);
	}

	public static void doSetup() {
		new EActorStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
