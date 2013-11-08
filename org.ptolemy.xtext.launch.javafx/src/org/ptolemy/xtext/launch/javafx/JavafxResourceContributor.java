package org.ptolemy.xtext.launch.javafx;

import org.ptolemy.xtext.launch.BeanResource;
import org.ptolemy.xtext.launch.ResourceContributor;

public class JavafxResourceContributor implements ResourceContributor {
	
	@Override
	public Class<? extends BeanResource> getResourceClass() {
		return JavafxResource.class;
	}

	@Override
	public String getAdditionalVMArguments() {
		return ""; // "-Dcom.apple.awt.CocoaComponent.CompatibilityMode=false";
	}
}
