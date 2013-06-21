package org.ptolemy.graphiti.diagram.features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.graphiti.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.editor.ActorDiagramEditor;
import org.ptolemy.graphiti.editor.CreateActorDiagramWizard;

import com.google.inject.Inject;

public class EntityContainerDrillDownFeature extends AbstractDrillDownFeature {

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
			if (bo instanceof EntityContainer<?>) {
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
	
	@Override
	protected Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {
		Collection<Diagram> diagrams = super.getLinkedDiagrams(pe);
		if (diagrams.isEmpty() && autoCreateDiagram) {
			Nameable named = (Nameable) getBusinessObjectForPictogramElement(pe);
			Diagram autoDiagram = CreateActorDiagramWizard.createDiagram(getAutoDiagramName(named));
			link(autoDiagram, named);
			return Collections.singletonList(autoDiagram);
		}
		return diagrams;
	}

	private String getAutoDiagramName(Nameable named) {
		ActorDiagramEditor mainDiagramEditor = ((ActorDiagramEditor) getDiagramEditor()).getMainEditor();
		NamedObj rootNamed = (NamedObj) getBusinessObjectForPictogramElement(mainDiagramEditor.getDiagramTypeProvider().getDiagram());
		return named.getName(rootNamed);
	}
	
	protected void openDiagramEditor(Diagram diagram) {
		ActorDiagramEditor diagramEditor = (ActorDiagramEditor) getDiagramEditor();
		diagramEditor.openEditor(diagram);
	}
}
