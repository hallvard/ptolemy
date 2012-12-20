package org.ptolemy.ecore.xtext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.resource.generic.EmfUiModule;

import com.google.inject.Binder;

public class EActorUiModule extends EmfUiModule {

	public EActorUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

//	@Override
//	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
//		binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(EActorEditorOpener.class);
//	}
}
