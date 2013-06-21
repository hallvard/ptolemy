package org.ptolemy.graphiti.generic.diagram.features.editastext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

 public class EditedResourceProvider implements IEditedResourceProvider {

	private Resource originalResource;
	private IResourceFactory resourceFactory;
	private ResourceSet resourceSet;
	
	public EditedResourceProvider(Resource originalResource, IResourceFactory resourceFactory, ResourceSet resourceSet) {
		this.originalResource = originalResource;
		this.resourceFactory = resourceFactory;
	}

	public XtextResource createResource() {
		URI uri = getXtextResourceUri();
		XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
		resourceSet.getResources().add(resource);
		return resource;
	}
	
	public URI getXtextResourceUri() {
		URI originalUri = originalResource.getURI();
		URI tempUri =  originalUri.trimFileExtension().appendFileExtension("temp." + originalUri.fileExtension());
		return tempUri;
	}
}
