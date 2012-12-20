package org.ptolemy.graphiti.editor;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.diagram.features.CreateEntityContainerFeature;
import org.ptolemy.graphiti.diagram.features.CreateEntityFeature;
import org.ptolemy.graphiti.diagram.features.CreatePortFeature;
import org.ptolemy.graphiti.diagram.features.IEntityLayout;
import org.ptolemy.graphiti.diagram.features.editastext.AbstractEditAsTextFeature;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ActorDiagramEditorModule extends AbstractModule {

	@Override
	protected void configure() {

		// domain
		bind(org.ptolemy.ecore.kernel.KernelFactory.class).toInstance(org.ptolemy.ecore.kernel.KernelFactory.eINSTANCE);
		bind(org.ptolemy.ecore.actor.ActorFactory.class).toInstance(org.ptolemy.ecore.actor.ActorFactory.eINSTANCE);
		bind(org.ptolemy.ecore.xactor.XactorFactory.class).toInstance(org.ptolemy.ecore.xactor.XactorFactory.eINSTANCE);
		
		// the diagram editor ++
		bind(org.eclipse.graphiti.ui.editor.DiagramEditor.class).to(org.ptolemy.graphiti.editor.ActorDiagramEditor.class);
		bind(org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor.class).to(org.ptolemy.graphiti.editor.ActorDiagramEditorActionBarContributor.class);
		bind(org.eclipse.ui.IEditorPart.class).to(org.ptolemy.graphiti.editor.MultiPageActorDiagramEditor.class);

		bind(org.eclipse.graphiti.dt.IDiagramTypeProvider.class).to(org.ptolemy.graphiti.diagram.ActorDiagramTypeProvider.class);
		bind(org.eclipse.graphiti.ui.platform.IImageProvider.class).to(org.ptolemy.graphiti.editor.ActorDiagramImageProvider.class);
//		bind(org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior.class).to(org.ptolemy.graphiti.editor.ActorDiagramPersistencyBehavior.class);
		bind(org.eclipse.graphiti.features.IFeatureProvider.class).to(org.ptolemy.graphiti.diagram.ActorDiagramFeatureProvider.class);
		bind(org.ptolemy.graphiti.actordiagram.ActordiagramFactory.class).toInstance(org.ptolemy.graphiti.actordiagram.ActordiagramFactory.eINSTANCE);

		bind(org.eclipse.ui.INewWizard.class).to(org.ptolemy.graphiti.editor.CreateActorDiagramWizard.class);
//		bind(org.ptolemy.graphiti.kieler.GraphitiDiagramLayoutManager.class).to(org.ptolemy.graphiti.kieler.ActorDiagramLayoutManager.class);
		bind(org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRendererFactory.class).to(org.ptolemy.graphiti.diagram.features.util.GenericShapeRendererFactory.class);

		// features
		
		bind(ICreateFeature.class).annotatedWith(Names.named("EntityContainer")).to(CreateEntityContainerFeature.class);
		bind(ICreateFeature.class).annotatedWith(Names.named("Entity")).to(CreateEntityFeature.class);
		
		bind(CreatePortFeature.class).annotatedWith(Names.named("single-input")).to(CreatePortFeature.SingleInput.class);
		bind(CreatePortFeature.class).annotatedWith(Names.named("multi-input")).to(CreatePortFeature.MultiInput.class);
		bind(CreatePortFeature.class).annotatedWith(Names.named("single-output")).to(CreatePortFeature.SingleOutput.class);
		bind(CreatePortFeature.class).annotatedWith(Names.named("multi-output")).to(CreatePortFeature.MultiOutput.class);

		bind(IAddFeature.class).annotatedWith(Names.named("EntityContainer")).to(org.ptolemy.graphiti.diagram.features.AddEntityContainerFeature.class);
		bind(IAddFeature.class).annotatedWith(Names.named("Entity")).to(org.ptolemy.graphiti.diagram.features.AddEntityFeature.class);
		bind(IAddFeature.class).annotatedWith(Names.named("Port")).to(org.ptolemy.graphiti.diagram.features.AddPortFeature.class);
		bind(IAddFeature.class).annotatedWith(Names.named("Relation")).to(org.ptolemy.graphiti.diagram.features.AddRelationFeature.class);
		bind(IAddFeature.class).annotatedWith(Names.named("Note")).to(org.ptolemy.graphiti.diagram.features.AddNoteFeature.class);
		bind(IAddFeature.class).annotatedWith(Names.named("Image")).to(org.ptolemy.graphiti.diagram.features.AddImageFeature.class);
		
		bind(IUpdateFeature.class).annotatedWith(Names.named("EntityFolder")).to(org.ptolemy.graphiti.diagram.features.UpdateEntityFolderDiagramFeature.class);
		bind(IUpdateFeature.class).annotatedWith(Names.named("EntityContainer")).to(org.ptolemy.graphiti.diagram.features.UpdateEntityContainerDiagramFeature.class);
		bind(IUpdateFeature.class).annotatedWith(Names.named("Entity")).to(org.ptolemy.graphiti.diagram.features.UpdateEntityFeature.class);
		bind(IUpdateFeature.class).annotatedWith(Names.named("Port")).to(org.ptolemy.graphiti.diagram.features.UpdatePortFeature.class);

		bind(ILayoutFeature.class).annotatedWith(Names.named("EntityContainer")).to(org.ptolemy.graphiti.diagram.features.LayoutEntityContainerFeature.class);
		bind(ILayoutFeature.class).annotatedWith(Names.named("Entity")).to(org.ptolemy.graphiti.diagram.features.LayoutEntityFeature.class);
		bind(ILayoutFeature.class).annotatedWith(Names.named("Port")).to(org.ptolemy.graphiti.diagram.features.LayoutPortFeature.class);
		
		bind(IEntityLayout.class).annotatedWith(Names.named("EntityContainer")).to(org.ptolemy.graphiti.diagram.features.EntityContainerLayout.class);
		bind(IEntityLayout.class).annotatedWith(Names.named("Entity")).to(org.ptolemy.graphiti.diagram.features.EntityLayout.class);
		
		bind(IDirectEditingFeature.class).annotatedWith(Names.named("IEntity")).to(org.ptolemy.graphiti.diagram.features.DirectEditNameableNameFeature.class);
		bind(IDirectEditingFeature.class).annotatedWith(Names.named("Note")).to(org.ptolemy.graphiti.diagram.features.DirectEditNoteFeature.class);
		
		bind(ICopyFeature.class).annotatedWith(Names.named("Entity")).to(org.ptolemy.graphiti.diagram.features.CopyEntityFeature.class);
		bind(IPasteFeature.class).annotatedWith(Names.named("IEntity")).to(org.ptolemy.graphiti.diagram.features.PasteFeature.class);

		bind(IRemoveFeature.class).annotatedWith(Names.named("IEntity")).to(org.ptolemy.graphiti.diagram.features.RemoveEntityShapeFeature.class);
		bind(IRemoveFeature.class).annotatedWith(Names.named("Port")).to(org.ptolemy.graphiti.diagram.features.RemovePortShapeFeature.class);
		bind(IRemoveFeature.class).annotatedWith(Names.named("Relation")).to(org.ptolemy.graphiti.diagram.features.RemoveRelationConnectionFeature.class);
		
		bind(IDeleteFeature.class).annotatedWith(Names.named("IEntity")).to(org.ptolemy.graphiti.diagram.features.DeleteIEntityFeature.class);
		bind(IDeleteFeature.class).annotatedWith(Names.named("Port")).to(org.ptolemy.graphiti.diagram.features.DeletePortFeature.class);
		bind(IDeleteFeature.class).annotatedWith(Names.named("Relation")).to(org.ptolemy.graphiti.diagram.features.DeleteRelationFeature.class);

		bind(AbstractEditAsTextFeature.class).annotatedWith(Names.named("Port")).to(org.ptolemy.graphiti.diagram.features.editastext.EditPortAsTextFeature.class);
		bind(AbstractEditAsTextFeature.class).annotatedWith(Names.named("AtomicActor")).to(org.ptolemy.graphiti.diagram.features.editastext.EditAtomicActorAsTextFeature.class);
		
		// Graphiti services
		
		bind(org.eclipse.graphiti.mm.pictograms.PictogramsFactory.class).toInstance(org.eclipse.graphiti.mm.pictograms.PictogramsFactory.eINSTANCE);
		
		bind(org.eclipse.graphiti.services.ILinkService.class)		.toInstance(Graphiti.getLinkService());
		bind(org.eclipse.graphiti.services.IPeService.class)		.toInstance(Graphiti.getPeService());
		bind(org.eclipse.graphiti.services.IPeCreateService.class)	.toInstance(Graphiti.getPeCreateService());
		bind(org.eclipse.graphiti.services.IPeLayoutService.class)	.toInstance(Graphiti.getPeLayoutService());
		bind(org.eclipse.graphiti.services.IGaService.class)		.toInstance(Graphiti.getGaService());
		bind(org.eclipse.graphiti.services.IGaCreateService.class)	.toInstance(Graphiti.getGaCreateService());
		bind(org.eclipse.graphiti.services.IGaLayoutService.class)	.toInstance(Graphiti.getGaLayoutService());
		
		// misc
		
		bind(org.ptolemy.graphiti.diagram.features.IEntityLayout.class).to(org.ptolemy.graphiti.diagram.features.EntityLayout.class);
	}
}
