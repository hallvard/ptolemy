package org.ptolemy.xtext.launch;

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
		String resourceClassName = PtolemyMainTab.getResourceClassName(configuration);
		String resourcePath = PtolemyMainTab.getResourcePath(configuration);
		return 	actorClassName + " " +
				directorClassName + " " +
				(resourceClassName != null && resourcePath != null ? resourceClassName + " " + resourcePath + " " : "") +
				super.getProgramArguments(configuration);
	}
}
