package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.tests.actors.misc.applyInput2TestModel.applyInput;
import org.ptolemy.xtext.tests.actors.misc.applyInput2TestModel.applyInputTest;
import org.ptolemy.xtext.tests.actors.misc.applyInput2TestModel.values;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class ApplyInput2TestModel extends TypedCompositeActor {
  private values values;
  
  protected values _createValuesEntity() throws NameDuplicationException, IllegalActionException {
    values values = new values(this, "values");
    return values;
    
  }
  
  private applyInput applyInput;
  
  protected applyInput _createApplyInputEntity() throws NameDuplicationException, IllegalActionException {
    applyInput applyInput = new applyInput(this, "applyInput");
    return applyInput;
    
  }
  
  private applyInputTest applyInputTest;
  
  protected applyInputTest _createApplyInputTestEntity() throws NameDuplicationException, IllegalActionException {
    applyInputTest applyInputTest = new applyInputTest(this, "applyInputTest");
    return applyInputTest;
    
  }
  
  public ApplyInput2TestModel(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values = _createValuesEntity();
    this.applyInput = _createApplyInputEntity();
    this.applyInputTest = _createApplyInputTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values.getPort("output").link(r1);
    this.applyInput.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.applyInput.getPort("output").link(r2);
    this.applyInputTest.getPort("input").link(r2);
    
  }
}
