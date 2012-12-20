package org.ptolemy.graphiti.diagram.features;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.ptolemy.graphiti.actordiagram.ModelShape;

public class AbstractRemoveLinkFeature extends DefaultRemoveFeature {

	public AbstractRemoveLinkFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	public static boolean isUnlinked(IPictogramElementContext context) {
		return isUnlinked(context.getPictogramElement());
	}

	public static boolean isUnlinked(PictogramElement pe) {
		return (pe instanceof ModelShape<?> && isUnlinked((ModelShape<? extends EObject>) pe));
	}

	public static boolean isUnlinked(ModelShape<? extends EObject> modelShape) {
		return isUnlinked(modelShape.getModel());
	}

	public static boolean isUnlinked(EObject model) {
		return (model == null || model.eIsProxy());
	}

	protected void removeConnection(Connection connection) {
		for (Anchor anchor : connection.getAnchors()) {
			for (Connection incomingConnection : anchor.getIncomingConnections()) {
				removeConnection(incomingConnection, incomingConnection.getStart());
			}
			removeConnections(anchor.getIncomingConnections(), anchor);
			for (Connection outgoingConnection : anchor.getOutgoingConnections()) {
				removeConnection(outgoingConnection, outgoingConnection.getEnd());
			}
			removeConnections(anchor.getOutgoingConnections(), anchor);
		}
		connection.getAnchors().clear();
		connection.setStart(null);
		connection.setEnd(null);
		removeFromContainer(connection);
	}

	protected void removeConnection(Connection connection, Anchor anchor) {
		if (connection.getStart() == anchor) {
			connection.setStart(null);
		}
		if (connection.getEnd() == anchor) {
			connection.setEnd(null);
		}
	}
	
	protected void removeConnections(Collection<Connection> connections, Anchor anchor) {
		Connection[] connectionsArray = connections.toArray(new Connection[connections.size()]);
		for (int i = 0; i < connectionsArray.length; i++) {
			Connection connection = connectionsArray[i];
			removeConnection(connection, anchor);
		}
		for (int i = 0; i < connectionsArray.length; i++) {
			Connection connection = connectionsArray[i];
			if (connection.getStart() == null || connection.getEnd() == null) {
				removeConnection(connection);
			}
		}
	}

	protected void removeConnections(Anchor anchor) {
		removeConnections(anchor.getIncomingConnections(), anchor);
		removeConnections(anchor.getOutgoingConnections(), anchor);
	}

	
	protected void removeConnections(AnchorContainer anchorContainer) {
		for (Anchor anchor : anchorContainer.getAnchors()) {
			removeConnections(anchor);
		}
	}

	//
	
	protected void removeFromContainer(EObject eObject) {
		EStructuralFeature containingFeature = eObject.eContainingFeature();
		if (containingFeature.isMany()) {
			((EList<?>) eObject.eContainer().eGet(containingFeature)).remove(eObject);
		} else {
			eObject.eContainer().eSet(containingFeature, null);
		}
	}
}
