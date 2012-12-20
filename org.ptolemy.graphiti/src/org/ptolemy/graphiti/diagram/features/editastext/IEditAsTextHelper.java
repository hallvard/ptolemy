package org.ptolemy.graphiti.diagram.features.editastext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

public interface IEditAsTextHelper {

	public void editAsText(EObject editableObject, EStructuralFeature[] structuralFeatures, Composite comp, int x, int y);
	public void stopEditing(boolean applyResult);
	
	public interface Context {
		public Injector getInjector();
		public TransactionalEditingDomain getEditingDomain();
		public Boolean applyResult(EObject model);
	}
}
