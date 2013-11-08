package org.ptolemy.xtext.launch;

public interface ResourceContributor {
	public Class<? extends BeanResource> getResourceClass();
	public String getAdditionalVMArguments();
}
