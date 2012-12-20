package org.ptolemy.ecore.xtext;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class EActorSupport extends AbstractGenericResourceSupport {

	@Override
	protected Module createGuiceModule() {
		return new EActorRuntimeModule();
	}
}
