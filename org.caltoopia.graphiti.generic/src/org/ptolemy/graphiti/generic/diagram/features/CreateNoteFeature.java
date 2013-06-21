package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import com.google.inject.Inject;

public class CreateNoteFeature extends AbstractCreateFeature {
 
	private String noteString = null;
	
    public CreateNoteFeature(IFeatureProvider fp, String noteString) {
    	super(fp, "Note", "Create note");
    	this.noteString = noteString;
    }

    @Inject
    public CreateNoteFeature(IFeatureProvider fp) {
    	this(fp, null);
    }
    
	@Override
	public boolean canCreate(ICreateContext context) {
		return true;
	}

    public Object[] create(ICreateContext context) {
        addGraphicalRepresentation(context, noteString != null ? noteString : "A note");
		return new Object[]{noteString};
    }
}
