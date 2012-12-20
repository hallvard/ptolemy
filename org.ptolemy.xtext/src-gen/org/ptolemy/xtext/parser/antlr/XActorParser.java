/*
* generated by Xtext
*/
package org.ptolemy.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.ptolemy.xtext.services.XActorGrammarAccess;

public class XActorParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private XActorGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.ptolemy.xtext.parser.antlr.internal.InternalXActorParser createParser(XtextTokenStream stream) {
		return new org.ptolemy.xtext.parser.antlr.internal.InternalXActorParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "ActorModel";
	}
	
	public XActorGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(XActorGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
