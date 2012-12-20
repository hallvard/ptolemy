package org.ptolemy.graphiti.diagram.features;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

public class AbstractDeleteLinkFeature extends DefaultDeleteFeature {

	public AbstractDeleteLinkFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	protected void deleteRelation(Relation relation) {
		relation.setSourcePort(null);
		relation.getTargetPorts().clear();
		deleteFromContainer(relation);
	}

	protected void deleteLinks(Relation relation, Port port) {
		if (relation.getSourcePort() == port) {
			relation.setSourcePort(null);
		}
		relation.getTargetPorts().remove(port);
	}
	
	protected void deleteLinks(Iterable<Relation> relations, Port port) {
		Collection<Relation> unlinkedRelations = new ArrayList<Relation>();
		for (Relation relation : relations) {
			deleteLinks(relation, port);
			if (relation.getSourcePort() == null || relation.getTargetPorts().isEmpty()) {
				unlinkedRelations.add(relation);
			}
		}
		for (Relation relation : unlinkedRelations) {
			deleteRelation(relation);
		}
	}

	protected void deleteLinks(Port port, boolean outer, boolean inner) {
		if (outer && port.getContainer() != null && port.getContainer().getContainer() != null) {
			deleteLinks(port.getContainer().getContainer().getRelations(), port);
		}
		if (inner && port instanceof ComponentPort && port.getContainer() instanceof CompositeEntity<?>) {
			deleteLinks(((CompositeEntity<?>) port.getContainer()).getAllRelations(), port);
		}
	}

	//

	protected void deleteFromContainer(EObject eObject) {
		EStructuralFeature containingFeature = eObject.eContainingFeature();
		if (containingFeature.isMany()) {
			((EList<?>) eObject.eContainer().eGet(containingFeature)).remove(eObject);
		} else {
			eObject.eContainer().eSet(containingFeature, null);
		}
	}
}
