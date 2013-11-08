package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel1.foldChannels;
import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel1.foldChannelsTest;
import org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel1.values;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class FoldChannelsTestModel1 extends TypedCompositeActor {
  private values values;
  
  protected values _createValuesEntity() throws NameDuplicationException, IllegalActionException {
    values values = new values(this, "values");
    return values;
    
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
  
  public FoldChannelsTestModel1(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values = _createValuesEntity();
    this.foldChannels = _createFoldChannelsEntity();
    this.foldChannelsTest = _createFoldChannelsTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values.getPort("output").link(r1);
    this.foldChannels.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.foldChannels.getPort("output").link(r2);
    this.foldChannelsTest.getPort("input").link(r2);
    
  }
  
  public FoldChannelsTestModel1(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "FoldChannelsTestModel1");
    
  }
}
