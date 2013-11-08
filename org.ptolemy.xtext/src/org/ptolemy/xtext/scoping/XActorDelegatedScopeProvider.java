package org.ptolemy.xtext.scoping;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.caltrop.CaltropActorImpl;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.EventPattern;
import org.ptolemy.ecore.caltrop.PortPattern;
import org.ptolemy.ecore.caltrop.ReAction;
import org.ptolemy.ecore.caltrop.StateVariable;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

public class XActorDelegatedScopeProvider {
	
	public IScope getScope(EObject context, EReference reference, IScope superScope) {
		Collection<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();
		if (context instanceof Relation && context.eContainer() instanceof EntityContainer<?>) {
			EntityContainer<?> entity = (EntityContainer<?>) context.eContainer();
			for (Entity<?> childEntity : entity.getEntities()) {
				for (Port port : childEntity.getAllPorts()) {
					Port scopedPort = null;
					if (port instanceof AbstractIOPort) {
						AbstractIOPort ioPort = (AbstractIOPort) port;
						if ((reference == KernelPackage.eINSTANCE.getRelation_SourcePort() && ioPort.isOutput()) || (reference == KernelPackage.eINSTANCE.getRelation_TargetPorts() && ioPort.isInput())) {
							scopedPort = port;
						}
					} else {
						scopedPort = port;
					}
					if (scopedPort != null && scopedPort.getName() != null) {
						descriptions.add(EObjectDescription.create(QualifiedName.create(childEntity.getName(), scopedPort.getName()), scopedPort));
					}
				}
			}
		} else if (context instanceof PortPattern && reference == CaltropPackage.eINSTANCE.getPortPattern_PortRef()) {
			EObject container = context.eContainer();
			while (container != null && (! (container instanceof Entity))) {
				container = container.eContainer();
			}
			if (container instanceof Entity) {
				for (Port port : ((Entity<?>) container).getAllPorts()) {
					descriptions.add(EObjectDescription.create(QualifiedName.create(port.getName()), port));
				}
			}
		} else if (context instanceof EventPattern && reference == CaltropPackage.eINSTANCE.getEventPattern_VarRef()) {
			EObject container = context.eContainer();
			while (container != null && (! (container instanceof CaltropActorImpl<?>))) {
				container = container.eContainer();
			}
			if (container instanceof CaltropActorImpl) {
				for (StateVariable var : ((CaltropActorImpl<?>) container).getDeclarations()) {
					String name = var.getName();
					if (name != null) {
						descriptions.add(EObjectDescription.create(QualifiedName.create(name), var));
					}
				}
			}
		}
		return (descriptions.isEmpty() ? superScope : new SimpleScope(descriptions));
	}
}
