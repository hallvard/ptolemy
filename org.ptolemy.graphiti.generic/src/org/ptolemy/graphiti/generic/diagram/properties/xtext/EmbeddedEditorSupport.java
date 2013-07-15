package org.ptolemy.graphiti.generic.diagram.properties.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface EmbeddedEditorSupport {

	public Control createControl(Composite parent);
	public void refresh(EObject bo);
	public void applyChanges();
}
