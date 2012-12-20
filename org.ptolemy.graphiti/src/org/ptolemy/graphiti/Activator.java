package org.ptolemy.graphiti;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.ptolemy.graphiti.editor.ActorDiagramEditorModule;
import org.ptolemy.xtext.ui.internal.XActorActivator;

import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.ptolemy.graphiti"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	private Injector injector;
	
	public Injector getInjector() {
		if (injector == null) {
			Injector parentInjector = XActorActivator.getInstance().getInjector(XActorActivator.ORG_PTOLEMY_XTEXT_XACTOR);
			injector = parentInjector.createChildInjector(new ActorDiagramEditorModule());
		}
		return injector;
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
		injector = null;
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

}
