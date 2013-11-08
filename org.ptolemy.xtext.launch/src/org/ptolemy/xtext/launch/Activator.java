package org.ptolemy.xtext.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.ptolemy.xtext.launch"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	// extension point
	
	private List<ResourceContribution> resourceContributions;
	
	private void processResourceContributorExtensions() {
		resourceContributions = new ArrayList<ResourceContribution>();
		for (IConfigurationElement extension : Platform.getExtensionRegistry().getConfigurationElementsFor("org.ptolemy.xtext.launch.resourceContribution")) {
			try {
				ResourceContributor contributor = (ResourceContributor) extension.createExecutableExtension("contributorClass");
				ResourceContribution contribution = new ResourceContribution(extension.getAttribute("name"), contributor);
				resourceContributions.add(contribution);
			} catch (CoreException e) {
			}
		}
	}

	public ResourceContribution[] getResourceContributions() {
		if (resourceContributions == null) {
			processResourceContributorExtensions();
		}
		return resourceContributions.toArray(new ResourceContribution[resourceContributions != null ? resourceContributions.size() : 0]);
	}
}
