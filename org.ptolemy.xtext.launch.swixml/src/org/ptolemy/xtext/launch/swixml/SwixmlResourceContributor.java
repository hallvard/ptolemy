package org.ptolemy.xtext.launch.swixml;

import org.ptolemy.xtext.launch.BeanResource;
import org.ptolemy.xtext.launch.ResourceContributor;

public class SwixmlResourceContributor implements ResourceContributor {
	
	@Override
	public Class<? extends BeanResource> getResourceClass() {
		return SwixmlResource.class;
	}

	@Override
	public String getAdditionalVMArguments() {
		return "-Dcom.apple.awt.CocoaComponent.CompatibilityMode=false";
	}
}
