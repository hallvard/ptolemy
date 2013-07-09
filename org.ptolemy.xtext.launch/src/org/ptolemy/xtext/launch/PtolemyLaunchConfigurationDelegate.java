package org.ptolemy.xtext.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

public class PtolemyLaunchConfigurationDelegate extends JavaLaunchDelegate {
	
	public static String ACTOR_TYPE_KEY = "ACTOR_TYPE_KEY";

	public static String DIRECTOR_TYPE_KEY = "DIRECTOR_TYPE_KEY";

	public static String RESOURCE_TYPE_KEY = "RESOURCE_TYPE_KEY";
	
	public static String RESOURCE_PATH_KEY = "RESOURCE_PATH_KEY";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		super.launch(configuration, mode, launch, monitor);
	}
	
	@Override
	public String getProgramArguments(ILaunchConfiguration configuration) throws CoreException {
		return
			configuration.getAttribute(ACTOR_TYPE_KEY, "?") + " " +
			configuration.getAttribute(DIRECTOR_TYPE_KEY, "?") + " " +
			configuration.getAttribute(RESOURCE_TYPE_KEY, "?") + " " +
			configuration.getAttribute(RESOURCE_PATH_KEY, "?") + " " +
			super.getProgramArguments(configuration);
	}
}
