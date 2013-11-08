package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel2.reduceChannels;
import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel2.reduceChannelsTest;
import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel2.values1;
import org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel2.values2;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class ReduceChannelsTestModel2 extends TypedCompositeActor {
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
  
  public ReduceChannelsTestModel2(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values1 = _createValues1Entity();
    this.values2 = _createValues2Entity();
    this.reduceChannels = _createReduceChannelsEntity();
    this.reduceChannelsTest = _createReduceChannelsTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values1.getPort("output").link(r1);
    this.reduceChannels.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.values2.getPort("output").link(r2);
    this.reduceChannels.getPort("input").link(r2);
    TypedIORelation r3 = new TypedIORelation(this, "r3");
    this.reduceChannels.getPort("output").link(r3);
    this.reduceChannelsTest.getPort("input").link(r3);
    
  }
  
  public ReduceChannelsTestModel2(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "ReduceChannelsTestModel2");
    
  }
}
