package org.ptolemy.xtext.launch;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

public class PtolemyLaunchConfigurationDelegate extends JavaLaunchDelegate {
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		super.launch(configuration, mode, launch, monitor);
	}
	
	String getStringAttributeValue(ILaunchConfiguration configuration, String attribute, String def) {
		try {
			return configuration.getAttribute(attribute, (String) def);
		} catch (CoreException e) {
			return null;
		}
	}
	
	@Override
	public String getProgramArguments(ILaunchConfiguration configuration) throws CoreException {
		String actorClassName = PtolemyMainTab.getActorClassName(configuration);
		String directorClassName = PtolemyMainTab.getDirectorClassName(configuration);
		String additionalArgs = actorClassName + " " + directorClassName + " ";
		for (ResourceContribution resourceContribution : Activator.getDefault().getResourceContributions()) {
			String resourceClassName = resourceContribution.getResourceContributor().getResourceClass().getName();
			String resourcePath = PtolemyMainTab.getResourcePath(resourceContribution, configuration);
			if (resourceClassName != null && resourcePath != null && resourcePath.trim().length() > 0) {
				additionalArgs += resourceClassName + " " + resourcePath + " ";
			}
		}
		return 	additionalArgs + super.getProgramArguments(configuration);
	}

	@Override
	public String getVMArguments(ILaunchConfiguration configuration) throws CoreException {
		String additionalArgs = "";
		for (ResourceContribution resourceContribution : Activator.getDefault().getResourceContributions()) {
			String additionalVMArgs = resourceContribution.getResourceContributor().getAdditionalVMArguments();
			if (additionalVMArgs != null) {
				additionalArgs += additionalVMArgs + " ";
			}
		}
		String loggingArg = null;
		for (ResourceContribution resourceContribution : Activator.getDefault().getResourceContributions()) {
			String resourceClassName = resourceContribution.getResourceContributor().getResourceClass().getName();
			String resourcePath = PtolemyMainTab.getResourcePath(resourceContribution, configuration);
			if (resourceClassName != null && resourcePath != null && resourcePath.trim().length() > 0 && loggingArg == null) {
				File propertiesFile = new File(resourcePath + ".logging.properties");
				if (propertiesFile.exists()) {
					loggingArg = "-Djava.util.logging.config.file=" + propertiesFile.getAbsolutePath() + " ";
				}
			}
		}
		return 	additionalArgs + (loggingArg != null ? loggingArg : "") + super.getVMArguments(configuration);
	}
}
