package org.ptolemy.graphiti.generic.diagram.features.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

public class SimpleIconImageProvider implements IconImageProvider {
	
	public String getIconImageURL(EObject model) {
		String url = getIconImageURLForEObject(model);
		if (url == null) {
			EStructuralFeature nameFeature = model.eClass().getEStructuralFeature("name");
			if (nameFeature != null && nameFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
				url = getIconImageURLForName(model, (String) model.eGet(nameFeature));
			}
		}
		return url;
	}

	public String getIconImageURLForEObject(EObject model) {
		return getIconImageURLForEClass(model.eClass());
	}

	public String getIconImageURLForEClass(EClass eClass) {
		return null;
	}
	
	private String[] iconFileExtensions = {"png", "gif", "jpeg", "jpg"};
	
	public String getIconImageURLForName(EObject model, String name) {
		Resource resource = model.eResource();
		if (resource == null) {
			return null;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		URIConverter uriConverter = resourceSet.getURIConverter();
		URI uri = resource.getURI().trimSegments(1).appendSegment(name);
		for (int i = 0; i < iconFileExtensions.length; i++) {
			URI iconUri = uri.appendFileExtension(iconFileExtensions[i]);
			if (uriConverter.exists(iconUri, null)) {
				return iconUri.toString();
			}
		}
		return null;
	}
}
