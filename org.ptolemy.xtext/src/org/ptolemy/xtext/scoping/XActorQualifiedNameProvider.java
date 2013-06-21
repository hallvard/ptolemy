package org.ptolemy.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Named;
import org.ptolemy.ecore.kernel.util.KernelResourceImpl;

import com.google.inject.Inject;

public class XActorQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof Nameable) {
			String name = ((Named) obj).getName();
			if (name != null) {
				if (obj instanceof IEntity<?>) {
					String fullName = KernelResourceImpl.getFullName((Nameable) obj, true, false);
					return (fullName != null ? qualifiedNameConverter.toQualifiedName(fullName) : null);
				}
				return QualifiedName.create(name);
			}
		}
		return super.getFullyQualifiedName(obj);
	}
}
