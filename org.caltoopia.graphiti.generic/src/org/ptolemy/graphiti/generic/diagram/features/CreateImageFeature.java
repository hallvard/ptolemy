package org.ptolemy.graphiti.generic.diagram.features;

import java.net.URL;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateImageFeature extends AbstractCreateFeature {
 
	private URL url = null;
	
    public CreateImageFeature(IFeatureProvider fp, URL url) {
    	super(fp, "Image", "Create image");
    	this.url = url;
    }
    
	@Override
	public boolean canCreate(ICreateContext context) {
		return url != null && AddImageFeature.isSupportedUrl(url);
	}

    public Object[] create(ICreateContext context) {
        addGraphicalRepresentation(context, url);
		return new Object[]{url};
    }
}
