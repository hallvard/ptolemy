package org.ptolemy.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.ptolemy.xtext.services.XActorGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractXActorSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XActorGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AbstractEntityActorImpl___LessThanSignKeyword_1_1_2_0_GreaterThanSignKeyword_1_1_2_1__q;
	protected AbstractElementAlias match_CompositeEntity_MAPS_TOParserRuleCall_0_1_0_6_1_q;
	protected AbstractElementAlias match_KeywordChannelSelector_AtKeyword_0_q;
	protected AbstractElementAlias match_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XActorGrammarAccess) access;
		match_AbstractEntityActorImpl___LessThanSignKeyword_1_1_2_0_GreaterThanSignKeyword_1_1_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAbstractEntityActorImplAccess().getLessThanSignKeyword_1_1_2_0()), new TokenAlias(false, false, grammarAccess.getAbstractEntityActorImplAccess().getGreaterThanSignKeyword_1_1_2_1()));
		match_CompositeEntity_MAPS_TOParserRuleCall_0_1_0_6_1_q = new TokenAlias(false, true, grammarAccess.getCompositeEntityAccess().getMAPS_TOParserRuleCall_0_1_0_6_1());
		match_KeywordChannelSelector_AtKeyword_0_q = new TokenAlias(false, true, grammarAccess.getKeywordChannelSelectorAccess().getAtKeyword_0());
		match_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q = new TokenAlias(false, true, grammarAccess.getTypedAtomicActorAccess().getMAPS_TOParserRuleCall_6_1());
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2()));
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getIS_ARule())
			return getIS_AToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMAPS_TORule())
			return getMAPS_TOToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * IS_A:
	 * 	'is';
	 */
	protected String getIS_AToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "is";
	}
	
	/**
	 * MAPS_TO:
	 * 	'==>';
	 */
	protected String getMAPS_TOToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "==>";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AbstractEntityActorImpl___LessThanSignKeyword_1_1_2_0_GreaterThanSignKeyword_1_1_2_1__q.equals(syntax))
				emit_AbstractEntityActorImpl___LessThanSignKeyword_1_1_2_0_GreaterThanSignKeyword_1_1_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeEntity_MAPS_TOParserRuleCall_0_1_0_6_1_q.equals(syntax))
				emit_CompositeEntity_MAPS_TOParserRuleCall_0_1_0_6_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_KeywordChannelSelector_AtKeyword_0_q.equals(syntax))
				emit_KeywordChannelSelector_AtKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q.equals(syntax))
				emit_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q.equals(syntax))
				emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('<' '>')?
	 */
	protected void emit_AbstractEntityActorImpl___LessThanSignKeyword_1_1_2_0_GreaterThanSignKeyword_1_1_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     MAPS_TO?
	 */
	protected void emit_CompositeEntity_MAPS_TOParserRuleCall_0_1_0_6_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'at'?
	 */
	protected void emit_KeywordChannelSelector_AtKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     MAPS_TO?
	 */
	protected void emit_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
