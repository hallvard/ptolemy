package org.caltoopia.graphiti;

import org.ptolemy.graphiti.generic.editor.ActorDiagramEditorModule;

import com.google.inject.name.Names;

public class CalActorDiagramEditorModule extends ActorDiagramEditorModule {

	@Override
	protected void configure() {
		super.configure();

		// domain
		bind(org.ptolemy.graphiti.generic.NameViewModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);
		bind(org.ptolemy.graphiti.generic.NameEditModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);

		bind(org.ptolemy.graphiti.generic.EntityViewModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);

		bind(org.ptolemy.graphiti.generic.ActorViewModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);
		bind(org.ptolemy.graphiti.generic.ActorEditModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);

		bind(org.ptolemy.graphiti.generic.ActorContainerViewModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);
		bind(org.ptolemy.graphiti.generic.ActorContainerEditModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);

		bind(org.ptolemy.graphiti.generic.ConnectionContainerViewModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);
		bind(org.ptolemy.graphiti.generic.ConnectionContainerEditModel.class).to(org.caltoopia.graphiti.CalModelFacade.class);

		bind(org.caltoopia.frontend.cal.CalFactory.class).toInstance(org.caltoopia.frontend.cal.CalFactory.eINSTANCE);

		// dsl
		bind(org.ptolemy.graphiti.generic.editor.DslInjectorProvider.class).to(org.caltoopia.graphiti.CalDslInjectorProvider.class);

		// various constants, must match plugin.xml
		bind(String.class).annotatedWith(Names.named("diagramType")).toInstance("cal");
		bind(String.class).annotatedWith(Names.named("diagramEditor")).toInstance("org.caltoopia.graphiti.cal");
	}
}
