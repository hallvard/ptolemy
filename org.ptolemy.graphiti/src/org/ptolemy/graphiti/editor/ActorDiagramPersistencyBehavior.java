package org.ptolemy.graphiti.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.xtext.resource.XtextResource;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.xactor.ActorModel;
import org.ptolemy.ecore.xactor.XactorFactory;

import com.google.inject.Inject;

public class ActorDiagramPersistencyBehavior extends DefaultPersistencyBehavior {

	@Inject
	public ActorDiagramPersistencyBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);
	}

	public Diagram loadDiagram(URI uri) {
		String fileExtension = uri.fileExtension();
		Diagram diagram = null;
		if (fileExtension.endsWith("xactor")) {
			uri = uri.trimFileExtension().appendFileExtension("xactor_diagram");
			final TransactionalEditingDomain editingDomain = getEditingDomain();
			if (editingDomain != null && (! editingDomain.getResourceSet().getURIConverter().exists(uri, null))) {
				CreateActorDiagramWizard.createDiagramFile(uri);
			}
		}
		diagram = super.loadDiagram(uri);
		Command createModelRootCommand = createModelRootCommand(diagram);
		CommandStack commandStack = getEditingDomain().getCommandStack();
		if (createModelRootCommand.canExecute()) {
			commandStack.execute(createModelRootCommand);
		}
//		URI projectUri = CommonPlugin.resolve(uri.trimFragment().trimSegments(uri.segmentCount() - 2));
//		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(projectUri.toPlatformString(true)));
//		if (file instanceof IProject) {
//			xtextResourceSet = (XtextResourceSet) xtextResourceSetProvider.get((IProject) file);
//			URI xactorUri = uri.trimFileExtension().appendFileExtension("xactor");
//			xtextResourceSet.getResource(xactorUri, true);
//		}
		return diagram;
	}

	private TransactionalEditingDomain getEditingDomain() {
		return diagramBehavior.getEditingDomain();
	}

	@Inject
	private PictogramsFactory pictogramsFactory;
	
	private Command createModelRootCommand(final Diagram diagram) {
		return new AbstractCommand() {
			@Override
			public boolean canExecute() {
				if (diagram != null) {
					PictogramLink link = diagram.getLink();
					return (link == null || link.getBusinessObjects().isEmpty());
				}
				return false;
			}
			@Override
			public void execute() {
				ensureModelResource(diagram);
			}
			@Override
			public void redo() {
			}
			@Override
			public boolean canUndo() {
				return false;
			}
		};
	}

	@Inject
	private XactorFactory actorFactory;

	protected Resource ensureModelResource(Diagram diagram) {
		Resource diagramResource = diagram.eResource();
		URI modelUri = diagramResource.getURI().trimFileExtension().appendFileExtension("xactor");
		ResourceSet resourceSet = getEditingDomain().getResourceSet();
		Resource modelResource = ensureModelResource(modelUri, resourceSet);
		Nameable modelRoot = ensureModelRoot(modelResource);
//		try {
//			modelResource.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		PictogramLink link = diagram.getLink();
		if (link == null) {
			diagram.setLink(link = pictogramsFactory.createPictogramLink());
		}
		link.getBusinessObjects().add(modelRoot);
		return modelResource;
	}
	
	private Nameable ensureModelRoot(Resource modelResource) {
		String name = getModelRootName(modelResource.getURI());
		Nameable modelRoot = null;
		if (modelResource.getContents().isEmpty()) {
			modelRoot  = createModelRoot();
			modelRoot.setName(name);
			modelResource.getContents().add(modelRoot);
		} else {
			modelRoot = (Nameable) modelResource.getContents().get(0);
		}
		return modelRoot;
	}

	protected String getModelRootName(URI modelUri) {
		return modelUri.trimFileExtension().lastSegment();
	}

	private Resource ensureModelResource(URI modelUri, ResourceSet resourceSet) {
		Resource resource = null;
		try {
			// first try to get and load
			resource = resourceSet.getResource(modelUri, true);
		} catch (Exception e) {
		}
		if (resource == null) {
			// if failed, get and if necessary create
			resource = resourceSet.getResource(modelUri, false);
		}
		return resource;
	}

	protected Nameable createModelRoot() {
		ActorModel modelRoot = actorFactory.createActorModel();
		return modelRoot;
	}
	
	//

//	@Override
//	protected Map<Resource, Map<?, ?>> createSaveOptions() {
//		// Save only resources that have actually changed.
//		final Map<Object, Object> saveOption = new HashMap<Object, Object>();
//		saveOption.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
//		EList<Resource> resources = diagramEditor.getEditingDomain().getResourceSet().getResources();
//		final Map<Resource, Map<?, ?>> saveOptions = new HashMap<Resource, Map<?, ?>>();
//		for (Resource resource : resources) {
//			saveOptions.put(resource, saveOption);
//		}
//		return saveOptions;
//	}

	@Override
	protected Set<Resource> save(TransactionalEditingDomain editingDomain, Map<Resource, Map<?, ?>> saveOptions, IProgressMonitor monitor) {
		List<Resource> trackingResources = null;
		try {
			// we only want to do this for linked resources, i.e. not the model directly linked to the diagram
			trackingResources = setTrackingModification(editingDomain.getResourceSet().getResources(), 2, true);
			return super.save(editingDomain, saveOptions, monitor);
		} finally {
			if (trackingResources != null) {
				trackingResources = setTrackingModification(trackingResources, 0, false);
			}
		}
	}

	protected List<Resource> setTrackingModification(List<Resource> resources, int start, boolean newValue) {
		List<Resource> changedResources = new ArrayList<Resource>();
		for (int i = start; i < resources.size(); i++) {
			Resource resource = resources.get(i);
			if (resource instanceof XtextResource) {
				if (resource.isTrackingModification() != newValue) {
					changedResources.add(resource);
					resource.setTrackingModification(newValue);
				}
			}
		}
		return changedResources;
	}
}
