package org.ptolemy.graphiti.generic.diagram.features.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class DiagramFeatureMapping<DCC, MCC, DEC, MEC> {

	private final Class<DCC> diagramContainerClass;
	private final Class<MCC> modelContainerClass;

	private final Class<DEC> diagramElementClass;
	private final Class<MEC> modelElementClass;
	
	public DiagramFeatureMapping(Class<DCC> dcc, Class<MCC> mcc, Class<DEC> dec, Class<MEC> mec) {
		super();
		this.diagramContainerClass = dcc;
		this.modelContainerClass = mcc;
		this.diagramElementClass = dec;
		this.modelElementClass = mec;
	}

	public boolean canHandle(PictogramElement de, EObject me) {
		return diagramContainerClass.isInstance(de) && modelContainerClass.isInstance(me);
	}
}
