package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel1.reduceChannels;
import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel1.reduceChannelsTest;
import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel1.values;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class ReduceChannelsTestModel1 extends TypedCompositeActor {
  private values values;
  
  protected values _createValuesEntity() throws NameDuplicationException, IllegalActionException {
    values values = new values(this, "values");
    return values;
    
  }
  
  private reduceChannels reduceChannels;
  
  protected reduceChannels _createReduceChannelsEntity() throws NameDuplicationException, IllegalActionException {
    reduceChannels reduceChannels = new reduceChannels(this, "reduceChannels");
    return reduceChannels;
    
  }
  
  private reduceChannelsTest reduceChannelsTest;
  
  protected reduceChannelsTest _createReduceChannelsTestEntity() throws NameDuplicationException, IllegalActionException {
    reduceChannelsTest reduceChannelsTest = new reduceChannelsTest(this, "reduceChannelsTest");
    return reduceChannelsTest;
    
  }
  
  public ReduceChannelsTestModel1(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values = _createValuesEntity();
    this.reduceChannels = _createReduceChannelsEntity();
    this.reduceChannelsTest = _createReduceChannelsTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values.getPort("output").link(r1);
    this.reduceChannels.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.reduceChannels.getPort("output").link(r2);
    this.reduceChannelsTest.getPort("input").link(r2);
    
  }
  
  public ReduceChannelsTestModel1(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "ReduceChannelsTestModel1");
    
  }
}
