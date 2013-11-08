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
	protected AbstractElementAlias match_CompositeEntity_MAPS_TOParserRuleCall_6_1_q;
	protected AbstractElementAlias match_CompositeEntity_StructureKeyword_11_0_q;
	protected AbstractElementAlias match_CompositeEntity_VarKeyword_9_0_q;
	protected AbstractElementAlias match_ConversionRelation_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_KeywordChannelSelector_AtKeyword_0_q;
	protected AbstractElementAlias match_Schedule_FsmKeyword_1_q;
	protected AbstractElementAlias match_StateVariable_SemicolonKeyword_5_2_q;
	protected AbstractElementAlias match_TypedAtomicActorInstance_MAPS_TOParserRuleCall_3_1_1_1_q;
	protected AbstractElementAlias match_TypedAtomicActorInstance_SemicolonKeyword_3_0_2_q;
	protected AbstractElementAlias match_TypedAtomicActorInstance___EqualsSignKeyword_3_1_0_0_ActorKeyword_3_1_0_1__q;
	protected AbstractElementAlias match_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XBodyExpression_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XActorGrammarAccess) access;
		match_CompositeEntity_MAPS_TOParserRuleCall_6_1_q = new TokenAlias(false, true, grammarAccess.getCompositeEntityAccess().getMAPS_TOParserRuleCall_6_1());
		match_CompositeEntity_StructureKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getCompositeEntityAccess().getStructureKeyword_11_0());
		match_CompositeEntity_VarKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getCompositeEntityAccess().getVarKeyword_9_0());
		match_ConversionRelation_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getConversionRelationAccess().getSemicolonKeyword_3());
		match_KeywordChannelSelector_AtKeyword_0_q = new TokenAlias(false, true, grammarAccess.getKeywordChannelSelectorAccess().getAtKeyword_0());
		match_Schedule_FsmKeyword_1_q = new TokenAlias(false, true, grammarAccess.getScheduleAccess().getFsmKeyword_1());
		match_StateVariable_SemicolonKeyword_5_2_q = new TokenAlias(false, true, grammarAccess.getStateVariableAccess().getSemicolonKeyword_5_2());
		match_TypedAtomicActorInstance_MAPS_TOParserRuleCall_3_1_1_1_q = new TokenAlias(false, true, grammarAccess.getTypedAtomicActorInstanceAccess().getMAPS_TOParserRuleCall_3_1_1_1());
		match_TypedAtomicActorInstance_SemicolonKeyword_3_0_2_q = new TokenAlias(false, true, grammarAccess.getTypedAtomicActorInstanceAccess().getSemicolonKeyword_3_0_2());
		match_TypedAtomicActorInstance___EqualsSignKeyword_3_1_0_0_ActorKeyword_3_1_0_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTypedAtomicActorInstanceAccess().getEqualsSignKeyword_3_1_0_0()), new TokenAlias(false, false, grammarAccess.getTypedAtomicActorInstanceAccess().getActorKeyword_3_1_0_1()));
		match_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q = new TokenAlias(false, true, grammarAccess.getTypedAtomicActorAccess().getMAPS_TOParserRuleCall_6_1());
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XBodyExpression_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXBodyExpressionAccess().getSemicolonKeyword_1_1());
		match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2()));
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMAPS_TORule())
			return getMAPS_TOToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
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
			if(match_CompositeEntity_MAPS_TOParserRuleCall_6_1_q.equals(syntax))
				emit_CompositeEntity_MAPS_TOParserRuleCall_6_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeEntity_StructureKeyword_11_0_q.equals(syntax))
				emit_CompositeEntity_StructureKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeEntity_VarKeyword_9_0_q.equals(syntax))
				emit_CompositeEntity_VarKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConversionRelation_SemicolonKeyword_3_q.equals(syntax))
				emit_ConversionRelation_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_KeywordChannelSelector_AtKeyword_0_q.equals(syntax))
				emit_KeywordChannelSelector_AtKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Schedule_FsmKeyword_1_q.equals(syntax))
				emit_Schedule_FsmKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StateVariable_SemicolonKeyword_5_2_q.equals(syntax))
				emit_StateVariable_SemicolonKeyword_5_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedAtomicActorInstance_MAPS_TOParserRuleCall_3_1_1_1_q.equals(syntax))
				emit_TypedAtomicActorInstance_MAPS_TOParserRuleCall_3_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedAtomicActorInstance_SemicolonKeyword_3_0_2_q.equals(syntax))
				emit_TypedAtomicActorInstance_SemicolonKeyword_3_0_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedAtomicActorInstance___EqualsSignKeyword_3_1_0_0_ActorKeyword_3_1_0_1__q.equals(syntax))
				emit_TypedAtomicActorInstance___EqualsSignKeyword_3_1_0_0_ActorKeyword_3_1_0_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q.equals(syntax))
				emit_TypedAtomicActor_MAPS_TOParserRuleCall_6_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBodyExpression_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XBodyExpression_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q.equals(syntax))
				emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     MAPS_TO?
	 */
	protected void emit_CompositeEntity_MAPS_TOParserRuleCall_6_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'structure'?
	 */
	protected void emit_CompositeEntity_StructureKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'var'?
	 */
	protected void emit_CompositeEntity_VarKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_ConversionRelation_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'fsm'?
	 */
	protected void emit_Schedule_FsmKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_StateVariable_SemicolonKeyword_5_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     MAPS_TO?
	 */
	protected void emit_TypedAtomicActorInstance_MAPS_TOParserRuleCall_3_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_TypedAtomicActorInstance_SemicolonKeyword_3_0_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('=' 'actor')?
	 */
	protected void emit_TypedAtomicActorInstance___EqualsSignKeyword_3_1_0_0_ActorKeyword_3_1_0_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     ';'?
	 */
	protected void emit_XBodyExpression_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     ';'?
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
