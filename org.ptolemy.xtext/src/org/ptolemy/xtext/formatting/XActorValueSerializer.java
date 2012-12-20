package org.ptolemy.xtext.formatting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;
import org.ptolemy.xtext.services.XActorGrammarAccess;

import com.google.inject.Inject;

public class XActorValueSerializer extends ValueSerializer {

	@Inject
	private XActorGrammarAccess grammarAccess;

	@Override
	protected String serializeUnassignedValueByRule(AbstractRule rule, EObject current, INode node) {
		String s = super.serializeUnassignedValueByRule(rule, current, node);
		if (s != null) {
			return s;
		}
		if (rule == grammarAccess.getMAPS_TORule()) {
			AbstractElement alternatives = rule.getAlternatives();
			if (alternatives instanceof Keyword) {
				return ((Keyword) alternatives).getValue();
			}
		}
		return null;
	}
}
