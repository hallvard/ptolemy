package org.ptolemy.graphiti.generic.editor.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.ptolemy.graphiti.generic.diagram.features.ImportActorsFeature;
import org.ptolemy.graphiti.generic.diagram.features.ImportActorsFeatureContext;

import com.google.inject.Inject;

public class DragImportActorsSupport implements TransferDropTargetListener {

	private final IFeatureProvider featureProvider;
	
	@Inject
	protected ImportActorsFeature importActorsFeature;

	@Inject
	public DragImportActorsSupport(IFeatureProvider featureProvider) {
		this.featureProvider = featureProvider;
		importActorsFeature = new ImportActorsFeature(featureProvider);
	}

	protected IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}

	protected ImportActorsFeature getImportActorsFeature() {
		return importActorsFeature;
	}
	
	@Override
	public Transfer getTransfer() {
		return FileTransfer.getInstance();
	}

	//

	protected URI[] getFileURIs(Object eventObject) {
		List<URI> uris = new ArrayList<URI>();
		if (eventObject instanceof String) {
			URI uri = URI.createFileURI((String) eventObject);
			if (isSupported(uri)) {
				uris.add(uri);
			}
		} else if (eventObject instanceof String[]) {
			for (int i = 0; i < ((String[]) eventObject).length; i++) {
				URI uri = URI.createFileURI(((String[]) eventObject)[i]);
				if (isSupported(uri)) {
					uris.add(uri);
				}
			}
		}
		return uris.toArray(new URI[uris.size()]);
	}

	protected boolean isSupported(URI uri) {
		return "xactor".equals(uri.fileExtension());
	}

	@Override
	public boolean isEnabled(DropTargetEvent event) {
		return true;
//		return getImportActorsFeature().canExecute(createFeatureContext(event));
	}

	public void dragEnter(DropTargetEvent event) 			{ event.detail = DND.DROP_COPY;}
	public void dragOperationChanged(DropTargetEvent event) { event.detail = DND.DROP_COPY;}

	public void dragOver(DropTargetEvent event) {}
	public void dragLeave(DropTargetEvent event) {}
	public void dropAccept(DropTargetEvent event) {}

	public void drop(DropTargetEvent event) {
		CustomContext context = createFeatureContext(event);
		if (getImportActorsFeature().canExecute(context)) {
			IDiagramTypeProvider diagramTypeProvider = getFeatureProvider().getDiagramTypeProvider();
			diagramTypeProvider.getDiagramBehavior().executeFeature(getImportActorsFeature(), context);
		}
	}

	protected CustomContext createFeatureContext(DropTargetEvent event) {
		URI[] uris = getFileURIs(event.data);
		IDiagramTypeProvider diagramTypeProvider = getFeatureProvider().getDiagramTypeProvider();
		Resource diagramResource = diagramTypeProvider.getDiagram().eResource();
		URI diagramUri = diagramResource.getURI();
		URI resolvedProjectUri = CommonPlugin.resolve(diagramUri.trimSegments(diagramUri.segmentCount() - 2));
		String resolvedProjectPath = resolvedProjectUri.toFileString();
		for (int i = 0; i < uris.length; i++) {
			URI fileUri = uris[i];
			String filePath = fileUri.path();
			URI platformUri = null;
			if (filePath.startsWith(resolvedProjectUri.toFileString())) {
				platformUri = URI.createPlatformResourceURI("/" + diagramUri.segment(1) + filePath.substring(resolvedProjectPath.length()), true);
			}
			if (platformUri != null) {
				uris[i] = platformUri;
			}
		}
		return new ImportActorsFeatureContext(diagramTypeProvider.getDiagram(), uris);
	}
}
