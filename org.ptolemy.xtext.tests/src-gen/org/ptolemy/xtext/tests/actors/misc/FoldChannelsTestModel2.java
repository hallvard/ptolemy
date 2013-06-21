package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel2.foldChannels;
import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel2.foldChannelsTest;
import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel2.values1;
import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel2.values2;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class FoldChannelsTestModel2 extends TypedCompositeActor {
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
  
  private foldChannels foldChannels;
  
  protected foldChannels _createFoldChannelsEntity() throws NameDuplicationException, IllegalActionException {
    foldChannels foldChannels = new foldChannels(this, "foldChannels");
    return foldChannels;
    
  }
  
  private foldChannelsTest foldChannelsTest;
  
  protected foldChannelsTest _createFoldChannelsTestEntity() throws NameDuplicationException, IllegalActionException {
    foldChannelsTest foldChannelsTest = new foldChannelsTest(this, "foldChannelsTest");
    return foldChannelsTest;
    
  }
  
  public FoldChannelsTestModel2(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values1 = _createValues1Entity();
    this.values2 = _createValues2Entity();
    this.foldChannels = _createFoldChannelsEntity();
    this.foldChannelsTest = _createFoldChannelsTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values1.getPort("output").link(r1);
    this.foldChannels.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.values2.getPort("output").link(r2);
    this.foldChannels.getPort("input").link(r2);
    TypedIORelation r3 = new TypedIORelation(this, "r3");
    this.foldChannels.getPort("output").link(r3);
    this.foldChannelsTest.getPort("input").link(r3);
    
  }
}
