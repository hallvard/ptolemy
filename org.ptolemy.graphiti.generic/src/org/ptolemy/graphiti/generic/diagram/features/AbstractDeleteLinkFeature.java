package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.ptolemy.graphiti.generic.ConnectionContainerEditModel;

import com.google.inject.Inject;

public class AbstractDeleteLinkFeature extends DefaultDeleteFeature {

	@Inject(optional=true)
	protected ConnectionContainerEditModel connectionContainerEditModel;

	public AbstractDeleteLinkFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canDelete(IDeleteContext context) {
		if (! (super.canDelete(context) && connectionContainerEditModel != null)) {
			return false;
		}
		return true;
	}

//	protected void deleteRelation(Relation relation) {
//		relation.setSourcePort(null);
//		relation.getTargetPorts().clear();
//		deleteFromContainer(relation);
//	}
//
//	protected void deleteLinks(Relation relation, Port port) {
//		if (relation.getSourcePort() == port) {
//			relation.setSourcePort(null);
//		}
//		relation.getTargetPorts().remove(port);
//	}
//	
//	protected void deleteLinks(Iterable<Relation> relations, Port port) {
//		Collection<Relation> unlinkedRelations = new ArrayList<Relation>();
//		for (Relation relation : relations) {
//			deleteLinks(relation, port);
//			if (relation.getSourcePort() == null || relation.getTargetPorts().isEmpty()) {
//				unlinkedRelations.add(relation);
//			}
//		}
//		for (Relation relation : unlinkedRelations) {
//			deleteRelation(relation);
//		}
//	}
//
//	protected void deleteLinks(Port port, boolean outer, boolean inner) {
//		if (outer && port.getContainer() != null && port.getContainer().getContainer() != null) {
//			deleteLinks(port.getContainer().getContainer().getRelations(), port);
//		}
//		if (inner && port instanceof ComponentPort && port.getContainer() instanceof CompositeEntity<?>) {
//			deleteLinks(((CompositeEntity<?>) port.getContainer()).getAllRelations(), port);
//		}
//	}

	//

	protected void deleteFromContainer(EObject eObject) {
		EStructuralFeature containingFeature = eObject.eContainingFeature();
		EObject container = eObject.eContainer();
		if (containingFeature.isMany()) {
			((EList<?>) container.eGet(containingFeature)).remove(eObject);
		} else {
			container.eSet(containingFeature, null);
		}
	}
}
