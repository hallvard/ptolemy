package org.ptolemy.xtext.launch;

public class ResourceContribution {

	private String name;
	private ResourceContributor contributor;
	
	public ResourceContribution(String name, ResourceContributor contributor) {
		this.name = name;
		this.contributor = contributor;
	}
	
	public String getName() {
		return name;
	}

	public ResourceContributor getResourceContributor() {
		return contributor;
	}
}
