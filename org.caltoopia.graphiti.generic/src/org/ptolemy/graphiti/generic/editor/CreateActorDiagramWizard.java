package org.ptolemy.graphiti.generic.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.examples.common.ExamplesCommonPlugin;
import org.eclipse.graphiti.examples.common.FileService;
import org.eclipse.graphiti.examples.common.navigator.nodes.base.AbstractInstancesOfTypeContainerNode;
import org.eclipse.graphiti.examples.common.ui.DiagramNameWizardPage;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.ptolemy.graphiti.generic.actordiagram.ActordiagramFactory;
import org.ptolemy.graphiti.generic.actordiagram.EntityContainerDiagram;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * The Class CreateDiagramWizard.
 */
public class CreateActorDiagramWizard extends BasicNewResourceWizard {

	private static String PAGE_NAME_DIAGRAM_NAME = "Actor Diagram name page";
	
	@Override
	public void addPages() {
		super.addPages();
		addPage(new DiagramNameWizardPage(PAGE_NAME_DIAGRAM_NAME, "Actor Diagram name", null)
//		{
//			@Override
//			protected void createWizardContents(Composite parent) {
//				super.createWizardContents(parent);
//			}
//		}
		);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle("New Actor Diagram");
	}
	
	@Inject @Named("diagramType") private String DIAGRAM_TYPE_ID;
	@Inject @Named("diagramEditor") private String DIAGRAM_EDITOR_ID;

	@Override
	public boolean performFinish() {

		IProject project = null;
		IFolder diagramFolder = null;

		Object element = getSelection().getFirstElement();
		if (element instanceof IFile) {
			element = ((IFile) element).getParent();
		}
		if (element instanceof IProject) {
			project = (IProject) element;
		} else if (element instanceof AbstractInstancesOfTypeContainerNode) {
			AbstractInstancesOfTypeContainerNode aiocn = (AbstractInstancesOfTypeContainerNode) element;
			project = aiocn.getProject();
		} else if (element instanceof IFolder) {
			diagramFolder = (IFolder) element;
			project = diagramFolder.getProject();
		}

		if (project == null || !project.isAccessible()) {
			IStatus status = new Status(IStatus.ERROR, ExamplesCommonPlugin.getID(), "No project found");
			ErrorDialog.openError(getShell(), "No project found", null, status);
			return false;
		}


		if (diagramFolder == null) {
			diagramFolder = project.getFolder("src/diagrams/"); //$NON-NLS-1$
		}

		final String diagramName = ((DiagramNameWizardPage) getPage(PAGE_NAME_DIAGRAM_NAME)).getText();
		IFile diagramFile = diagramFolder.getFile(diagramName + "." + DIAGRAM_TYPE_ID + "_diagram"); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		Diagram diagram = createDiagramFile(uri, DIAGRAM_TYPE_ID);
		
		String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		DiagramEditorInput editorInput = new DiagramEditorInput(EcoreUtil.getURI(diagram), providerId);
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, DIAGRAM_EDITOR_ID);
		} catch (PartInitException e) {
			IStatus status = new Status(IStatus.ERROR, ExamplesCommonPlugin.getID(), "Error opening diagram", e);
			ErrorDialog.openError(getShell(), "Error opening diagram", null, status);
			return false;
		}

		return true;
	}

	public final static String FILE_EXTENSION_SUFFIX = "_diagram";

	public static Diagram createDiagramFile(URI uri, String diagramType) {
		Diagram diagram = createDiagram(uri.lastSegment(), diagramType);
		FileService.createEmfFileForDiagram(uri, diagram);
		return diagram;
	}

	public static Diagram createDiagram(String diagramName, String diagramType) {
		final Diagram defaultDiagram = Graphiti.getPeCreateService().createDiagram(diagramType, diagramName, true);
		final EntityContainerDiagram entityDiagram = ActordiagramFactory.eINSTANCE.createEntityContainerDiagram();
		@SuppressWarnings("serial")
		EcoreUtil.Copier copier = new EcoreUtil.Copier() {
			@Override
			protected EObject createCopy(EObject eObject) {
				return (eObject == defaultDiagram ? entityDiagram : super.createCopy(eObject));
			}
		};
		copier.copy(defaultDiagram);
		copier.copyReferences();
		return entityDiagram;
	}
}
