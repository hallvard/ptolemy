/*
 * generated by Xtext
 */
package org.ptolemy.xtext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.ptolemy.xtext.ui.custom.XActorHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XActorUiModule extends org.ptolemy.xtext.ui.AbstractXActorUiModule {
	public XActorUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public org.eclipse.core.resources.IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
	}

	public Class<? extends org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider> bindIJavaProjectProvider() {
		return org.ptolemy.xtext.ui.jdt.ResourceURIJavaProjectProvider.class;
	}
	
	public Class<? extends org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return org.ptolemy.xtext.ui.jdt.JdtTypeProviderFactoryCustomTypeResource.class;
	}

	public Class<? extends org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory> bindJdtTypeProviderFactory() {
		return org.ptolemy.xtext.ui.jdt.JdtTypeProviderFactoryCustomTypeResource.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.XtextSourceViewer.Factory> bindFactory() {
		return org.ptolemy.xtext.ui.custom.SelectionLimitingXtextSourceViewer.Factory.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return XActorHighlightingCalculator.class;
	}
}
