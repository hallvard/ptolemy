package org.ptolemy.graphiti;

import org.ptolemy.graphiti.generic.editor.ActorDiagramEditorModule;

import com.google.inject.name.Names;

public class PtolemyActorDiagramEditorModule extends ActorDiagramEditorModule {

	@Override
	protected void configure() {
		super.configure();

		// domain
		bind(org.ptolemy.ecore.kernel.KernelFactory.class).toInstance(org.ptolemy.ecore.kernel.KernelFactory.eINSTANCE);
		bind(org.ptolemy.ecore.actor.ActorFactory.class).toInstance(org.ptolemy.ecore.actor.ActorFactory.eINSTANCE);
		bind(org.ptolemy.ecore.caltrop.CaltropFactory.class).toInstance(org.ptolemy.ecore.caltrop.CaltropFactory.eINSTANCE);
		bind(org.ptolemy.ecore.xactor.XactorFactory.class).toInstance(org.ptolemy.ecore.xactor.XactorFactory.eINSTANCE);
		
		// the diagram editor ++
//		bind(org.eclipse.graphiti.ui.editor.DiagramEditor.class).to(org.ptolemy.graphiti.editor.ActorDiagramEditor.class);
//		bind(org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor.class).to(org.ptolemy.graphiti.editor.ActorDiagramEditorActionBarContributor.class);
//		bind(org.eclipse.ui.IEditorPart.class).to(org.ptolemy.graphiti.editor.MultiPageActorDiagramEditor.class);
//
//		bind(org.eclipse.graphiti.dt.IDiagramTypeProvider.class).to(org.ptolemy.graphiti.diagram.ActorDiagramTypeProvider.class);
//		bind(org.eclipse.graphiti.ui.platform.IImageProvider.class).to(org.ptolemy.graphiti.editor.ActorDiagramImageProvider.class);
////		bind(org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior.class).to(org.ptolemy.graphiti.editor.ActorDiagramPersistencyBehavior.class);
//		bind(org.eclipse.graphiti.features.IFeatureProvider.class).to(org.ptolemy.graphiti.diagram.ActorDiagramFeatureProvider.class);
//		bind(org.ptolemy.graphiti.actordiagram.ActordiagramFactory.class).toInstance(org.ptolemy.graphiti.actordiagram.ActordiagramFactory.eINSTANCE);
//
//		bind(org.eclipse.ui.INewWizard.class).to(org.ptolemy.graphiti.editor.CreateActorDiagramWizard.class);
////		bind(org.ptolemy.graphiti.kieler.GraphitiDiagramLayoutManager.class).to(org.ptolemy.graphiti.kieler.ActorDiagramLayoutManager.class);
//		bind(org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRendererFactory.class).to(org.ptolemy.graphiti.diagram.features.util.ActorDiagramShapeRendererFactory.class);

		bind(org.ptolemy.graphiti.generic.NameViewModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);
		bind(org.ptolemy.graphiti.generic.NameEditModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);

		bind(org.ptolemy.graphiti.generic.EntityViewModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);

		bind(org.ptolemy.graphiti.generic.ActorViewModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);
		bind(org.ptolemy.graphiti.generic.ActorEditModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);

		bind(org.ptolemy.graphiti.generic.ActorContainerViewModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);
		bind(org.ptolemy.graphiti.generic.ActorContainerEditModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);

		bind(org.ptolemy.graphiti.generic.ConnectionContainerViewModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);
		bind(org.ptolemy.graphiti.generic.ConnectionContainerEditModel.class).to(org.ptolemy.graphiti.PtolemyModelFacade.class);

		// dsl
		bind(org.ptolemy.graphiti.generic.editor.DslInjectorProvider.class).to(org.ptolemy.graphiti.PtolemyDslInjectorProvider.class);
		
		// various constants, must match plugin.xml
		bind(String.class).annotatedWith(Names.named("diagramType")).toInstance("xactor");
		bind(String.class).annotatedWith(Names.named("diagramEditor")).toInstance("org.ptolemy.graphiti.xactor");
	}
}
