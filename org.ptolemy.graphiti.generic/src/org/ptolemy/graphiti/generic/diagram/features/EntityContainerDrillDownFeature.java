package org.ptolemy.graphiti.generic.diagram.features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.generic.editor.ActorDiagramEditor;
import org.ptolemy.graphiti.generic.editor.CreateActorDiagramWizard;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class EntityContainerDrillDownFeature extends AbstractDrillDownFeature {

	@Inject
	private EntityViewModel entityViewModel;
	
	@Inject
	public EntityContainerDrillDownFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Open as diagram";
	}

	@Override
	public String getDescription() {
		return "Open as diagram";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		// first check, if one EClass is selected
		if (pes != null && pes.length == 1) {
			PictogramElement pe = pes[0];
			if (pe instanceof Diagram) {
				return false;
			}
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof EObject && entityViewModel.isEntity((EObject) bo, EntityViewModel.EntityKind.ACTOR_CONTAINER)) {
				return autoCreateDiagram || super.canExecute(context);
			}
		}
		return false;
	}
	
	@Override
	protected Collection<Diagram> getDiagrams() {
		Collection<Diagram> diagrams = new ArrayList<Diagram>();
		for (EObject eObject : getDiagram().eResource().getContents()) {
			if (eObject instanceof EntityContainerDiagram) {
				diagrams.add((Diagram) eObject);
			}
		}
		return diagrams;
	}

	private boolean autoCreateDiagram = true;
	
	@Inject @Named("diagramType") private String DIAGRAM_TYPE;
	
	@Override
	protected Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {
		Collection<Diagram> diagrams = super.getLinkedDiagrams(pe);
		if (diagrams.isEmpty() && autoCreateDiagram) {
			EObject named = (EObject) getBusinessObjectForPictogramElement(pe);
			Diagram autoDiagram = CreateActorDiagramWizard.createDiagram(getAutoDiagramName(named), DIAGRAM_TYPE);
			link(autoDiagram, named);
			return Collections.singletonList(autoDiagram);
		}
		return diagrams;
	}

	private String getAutoDiagramName(EObject named) {
		ActorDiagramEditor mainDiagramEditor = getActorDiagramEditor().getMainEditor();
//		EObject rootNamed = (EObject) getBusinessObjectForPictogramElement(mainDiagramEditor.getDiagramTypeProvider().getDiagram());
		return entityViewModel.getQualifiedEntityName(named);
	}

	private ActorDiagramEditor getActorDiagramEditor() {
		return (ActorDiagramEditor) getDiagramBehavior().getDiagramContainer();
	}
	
	protected void openDiagramEditor(Diagram diagram) {
		getActorDiagramEditor().openEditor(diagram);
	}
}
