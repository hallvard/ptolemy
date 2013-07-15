package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class ImportActorsFeatureContext extends CustomContext {

	private URI[] uris = new URI[0];

	public ImportActorsFeatureContext(Diagram diagram, URI[] uris) {
		super(new PictogramElement[]{diagram});
		this.uris = uris;
	}

	public URI[] getUris() {
		return uris;
	}
	
	public Diagram getDiagram() {
		return (Diagram) getPictogramElements()[0];
	}
}
