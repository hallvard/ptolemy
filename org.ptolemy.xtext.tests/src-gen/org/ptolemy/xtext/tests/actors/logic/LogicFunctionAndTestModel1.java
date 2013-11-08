package org.ptolemy.xtext.tests.actors.logic;

import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel1.logicFunction;
import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel1.logicFunctionTest;
import org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel1.values;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class LogicFunctionAndTestModel1 extends TypedCompositeActor {
  private values values;
  
  protected values _createValuesEntity() throws NameDuplicationException, IllegalActionException {
    values values = new values(this, "values");
    return values;
    
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
  
  public LogicFunctionAndTestModel1(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values = _createValuesEntity();
    this.logicFunction = _createLogicFunctionEntity();
    this.logicFunctionTest = _createLogicFunctionTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values.getPort("output").link(r1);
    this.logicFunction.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.logicFunction.getPort("output").link(r2);
    this.logicFunctionTest.getPort("input").link(r2);
    
  }
  
  public LogicFunctionAndTestModel1(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "LogicFunctionAndTestModel1");
    
  }
}
