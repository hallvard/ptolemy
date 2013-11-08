package org.ptolemy.xtext.tests.actors.logic;

import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel2.logicFunction;
import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel2.logicFunctionTest;
import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel2.values1;
import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel2.values2;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class LogicFunctionAndTestModel2 extends TypedCompositeActor {
  private values1 values1;
  
  protected values1 _createValues1Entity() throws NameDuplicationException, IllegalActionException {
    values1 values1 = new values1(this, "values1");
    return values1;
    
  }
  
  private values2 values2;
  
  protected values2 _createValues2Entity() throws NameDuplicationException, IllegalActionException {
    values2 values2 = new values2(this, "values2");
    return values2;
    
  }
  
  private logicFunction logicFunction;
  
  protected logicFunction _createLogicFunctionEntity() throws NameDuplicationException, IllegalActionException {
    logicFunction logicFunction = new logicFunction(this, "logicFunction");
    return logicFunction;
    
  }
  
  private logicFunctionTest logicFunctionTest;
  
  protected logicFunctionTest _createLogicFunctionTestEntity() throws NameDuplicationException, IllegalActionException {
    logicFunctionTest logicFunctionTest = new logicFunctionTest(this, "logicFunctionTest");
    return logicFunctionTest;
    
  }
  
  public LogicFunctionAndTestModel2(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values1 = _createValues1Entity();
    this.values2 = _createValues2Entity();
    this.logicFunction = _createLogicFunctionEntity();
    this.logicFunctionTest = _createLogicFunctionTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values1.getPort("output").link(r1);
    this.logicFunction.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.values2.getPort("output").link(r2);
    this.logicFunction.getPort("input").link(r2);
    TypedIORelation r3 = new TypedIORelation(this, "r3");
    this.logicFunction.getPort("output").link(r3);
    this.logicFunctionTest.getPort("input").link(r3);
    
  }
  
  public LogicFunctionAndTestModel2(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "LogicFunctionAndTestModel2");
    
  }
}
