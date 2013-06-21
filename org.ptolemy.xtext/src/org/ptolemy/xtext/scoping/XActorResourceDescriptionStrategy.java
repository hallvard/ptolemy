package org.ptolemy.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.Named;

public class XActorResourceDescriptionStrategy extends XbaseResourceDescriptionStrategy {

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof Named) {
			if (eObject instanceof IEntity<?>) {
				super.createEObjectDescriptions(eObject, acceptor);
				if (eObject instanceof EntityContainer<?> && (! (eObject instanceof CompositeEntity<?>))) {
					return true;
				}
			}
			return false;
		}
		return super.createEObjectDescriptions(eObject, acceptor);
	}
}
