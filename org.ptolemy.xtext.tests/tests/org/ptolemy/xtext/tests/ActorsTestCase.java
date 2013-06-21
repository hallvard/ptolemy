package org.ptolemy.xtext.tests;

import org.ptolemy.xtext.tests.actors.logic.LogicFunctionAndTestModel1;
import org.ptolemy.xtext.tests.actors.logic.LogicFunctionAndTestModel2;
import org.ptolemy.xtext.tests.actors.logic.LogicFunctionOrTestModel1;
import org.ptolemy.xtext.tests.actors.logic.LogicFunctionOrTestModel2;
import org.ptolemy.xtext.tests.actors.misc.ApplyInput1TestModel;
import org.ptolemy.xtext.tests.actors.misc.ApplyInput2TestModel;
import org.ptolemy.xtext.tests.actors.misc.FoldChannelsTestModel1;
import org.ptolemy.xtext.tests.actors.misc.FoldChannelsTestModel2;
import org.ptolemy.xtext.tests.actors.misc.ReduceChannelsTestModel1;
import org.ptolemy.xtext.tests.actors.misc.ReduceChannelsTestModel2;
import org.ptolemy.xtext.tests.actors.misc.SelectChannelNTestModel;
import org.ptolemy.xtext.tests.actors.sources.RampTestModel1;
import org.ptolemy.xtext.tests.actors.sources.RampTestModel2;
import org.ptolemy.xtext.tests.actors.sources.RampTestModel3;
import org.ptolemy.xtext.tests.actors.sources.StringConstTestModel1;
import org.ptolemy.xtext.tests.actors.sources.StringConstTestModelN;
import org.ptolemy.xtext.tests.actors.sources.ValuesTestModel1;
import org.ptolemy.xtext.tests.actors.sources.ValuesTestModel2;
import org.ptolemy.xtext.tests.junit.AbstractActorsTestCase;

import ptolemy.domains.sdf.kernel.SDFDirector;

public class ActorsTestCase extends AbstractActorsTestCase {

	public void testStringConstTestModel1() throws Exception {
		testActor(StringConstTestModel1.class, SDFDirector.class, 5);
	}
	public void testStringConstTestModelN() throws Exception {
		testActor(StringConstTestModelN.class, SDFDirector.class, 5);
	}
	
	public void testRampTestModel1() throws Exception {
		testActor(RampTestModel1.class, SDFDirector.class, 10);
	}
	public void testRampTestModel2() throws Exception {
		testActor(RampTestModel2.class, SDFDirector.class, 10);
	}
	public void testRampTestModel3() throws Exception {
		testActor(RampTestModel3.class, SDFDirector.class, 10);
	}
	
	public void testValuesTestModel1() throws Exception {
		testActor(ValuesTestModel1.class, SDFDirector.class, 10);
	}
	public void testValuesTestModel2() throws Exception {
		testActor(ValuesTestModel2.class, SDFDirector.class, 10);
	}
	
	public void testLogicFunctionAndTestModel1() throws Exception {
		testActor(LogicFunctionAndTestModel1.class, SDFDirector.class, 10);
	}
	public void testLogicFunctionAndTestModel2() throws Exception {
		testActor(LogicFunctionAndTestModel2.class, SDFDirector.class, 10);
	}
	
	public void testLogicFunctionOrTestModel1() throws Exception {
		testActor(LogicFunctionOrTestModel1.class, SDFDirector.class, 10);
	}
	public void testLogicFunctionOrTestModel2() throws Exception {
		testActor(LogicFunctionOrTestModel2.class, SDFDirector.class, 10);
	}

	public void testReduceChannelsTestModel1() throws Exception {
		testActor(ReduceChannelsTestModel1.class, SDFDirector.class, 10);
	}
	public void testReduceChannelsTestModel2() throws Exception {
		testActor(ReduceChannelsTestModel2.class, SDFDirector.class, 10);
	}
	
	public void testFoldChannelsTestModel1() throws Exception {
		testActor(FoldChannelsTestModel1.class, SDFDirector.class, 10);
	}
	public void testFoldChannelsTestModel2() throws Exception {
		testActor(FoldChannelsTestModel2.class, SDFDirector.class, 10);
	}
	
	public void testApplyInput1TestModel() throws Exception {
		testActor(ApplyInput1TestModel.class, SDFDirector.class, 10);
	}
	public void testApplyInput2TestModel() throws Exception {
		testActor(ApplyInput2TestModel.class, SDFDirector.class, 10);
	}

	public void testSelectChannelNTestModel() throws Exception {
		testActor(SelectChannelNTestModel.class, SDFDirector.class, 10);
	}
	
}
