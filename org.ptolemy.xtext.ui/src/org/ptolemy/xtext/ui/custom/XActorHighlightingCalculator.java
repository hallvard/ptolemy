package org.ptolemy.xtext.ui.custom;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingCalculator;

public class XActorHighlightingCalculator extends XbaseHighlightingCalculator {
	
	@Override
	protected void searchAndHighlightElements(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject object = iterator.next();
			EStructuralFeature containingFeature = object.eContainingFeature();
			if (containingFeature != null && containingFeature.isTransient()) {
				iterator.prune();
				continue;
			}
			if (object instanceof XAbstractFeatureCall) {
				computeFeatureCallHighlighting((XAbstractFeatureCall) object, acceptor);
			}
			// Handle XAnnotation in a special way because we want the @ highlighted too
			if (object instanceof XNumberLiteral) {
				highlightNumberLiterals((XNumberLiteral) object, acceptor);
			} if (object instanceof XAnnotation) {
				highlightAnnotation((XAnnotation) object, acceptor);
			} else {
				computeReferencedJvmTypeHighlighting(acceptor, object);
			}
		}
	}
}
