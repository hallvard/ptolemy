package org.ptolemy.ecore.xtext;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

public class EActorRuntimeModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "org.ptolemy.ecore.EActor";
	}

	@Override
	protected String getFileExtensions() {
		return "eactor";
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
}
