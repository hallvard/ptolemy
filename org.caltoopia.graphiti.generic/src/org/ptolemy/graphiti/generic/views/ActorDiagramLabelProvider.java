package org.ptolemy.graphiti.generic.views;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.ptolemy.graphiti.generic.Activator;
import org.ptolemy.graphiti.generic.ActorContainerViewModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.NameViewModel;
import org.ptolemy.graphiti.generic.editor.ActorDiagramImageProvider;

import com.google.inject.Inject;

public class ActorDiagramLabelProvider extends LabelProvider {

	@Inject
	private NameViewModel nameViewModel;
	
	@Inject
	private ActorViewModel actorViewModel;
	
	@Inject
	private ActorContainerViewModel actorContainerViewModel;
	
	@Inject
	private ILinkService linkService;
	
	@Override
	public String getText(Object element) {
		if (element instanceof PictogramElement) {
			element = linkService.getBusinessObjectForLinkedPictogramElement((PictogramElement) element);
		}
		String name = (element instanceof EObject ? nameViewModel.getName((EObject) element) : null);
		return (name != null ? name : super.getText(element));
	}
	
	@Inject
	private ActorDiagramImageProvider imageProvider;
	
	@Override
	public Image getImage(Object element) {
		String imageId = null;
		if (element instanceof PictogramElement) {
			element = linkService.getBusinessObjectForLinkedPictogramElement((PictogramElement) element);
		}
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			if (actorContainerViewModel.isEntity(eObject, EntityViewModel.EntityKind.ACTOR)) {
				imageId = ISharedImages.IMG_OBJ_ELEMENT;
			} else if (actorContainerViewModel.isEntity(eObject, EntityViewModel.EntityKind.ENTITY_NAMESPACE)) {
				imageId = ISharedImages.IMG_OBJ_FOLDER;
			} else if (actorViewModel.isPort(eObject, ActorViewModel.PortKind.INPUT)) {
				imageId = (actorViewModel.isMulti(eObject) ? ActorDiagramImageProvider.IMG_MULTI_INPUT_PORT : ActorDiagramImageProvider.IMG_INPUT_PORT);
			} else if (actorViewModel.isPort(eObject, ActorViewModel.PortKind.OUTPUT)) {
				imageId = (actorViewModel.isMulti(eObject) ? ActorDiagramImageProvider.IMG_MULTI_OUTPUT_PORT : ActorDiagramImageProvider.IMG_OUTPUT_PORT);
			}
		}
		Image image = null;
		if (imageId != null) {
			image = Activator.getDefault().getImageRegistry().get(imageId);
			if (image == null) {
				image = PlatformUI.getWorkbench().getSharedImages().getImage(imageId);
			}
			if (image == null) {
				URI uri = URI.createPlatformPluginURI("/" + Activator.getDefault().getBundle().getSymbolicName() + "/" + imageProvider.getImageFilePath(imageId), true);
				try {
					Activator.getDefault().getImageRegistry().put(imageId, ImageDescriptor.createFromURL(new URL(uri.toString())));
					image = Activator.getDefault().getImageRegistry().get(imageId);
				} catch (MalformedURLException e) {
				}
			}
		}
		return (image != null ? image : super.getImage(element));
	}
}
