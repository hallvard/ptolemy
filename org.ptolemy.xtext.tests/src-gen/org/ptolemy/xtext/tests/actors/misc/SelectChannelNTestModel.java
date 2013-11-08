package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel.channels;
import org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel.selectChannel;
import org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel.selectChannelTest;
import org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel.values1;
import org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel.values2;
import org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel.values3;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class SelectChannelNTestModel extends TypedCompositeActor {
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
  
  private values3 values3;
  
  protected values3 _createValues3Entity() throws NameDuplicationException, IllegalActionException {
    values3 values3 = new values3(this, "values3");
    return values3;
    
  }
  
  private channels channels;
  
  protected channels _createChannelsEntity() throws NameDuplicationException, IllegalActionException {
    channels channels = new channels(this, "channels");
    return channels;
    
  }
  
  private selectChannel selectChannel;
  
  protected selectChannel _createSelectChannelEntity() throws NameDuplicationException, IllegalActionException {
    selectChannel selectChannel = new selectChannel(this, "selectChannel");
    return selectChannel;
    
  }
  
  private selectChannelTest selectChannelTest;
  
  protected selectChannelTest _createSelectChannelTestEntity() throws NameDuplicationException, IllegalActionException {
    selectChannelTest selectChannelTest = new selectChannelTest(this, "selectChannelTest");
    return selectChannelTest;
    
  }
  
  public SelectChannelNTestModel(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values1 = _createValues1Entity();
    this.values2 = _createValues2Entity();
    this.values3 = _createValues3Entity();
    this.channels = _createChannelsEntity();
    this.selectChannel = _createSelectChannelEntity();
    this.selectChannelTest = _createSelectChannelTestEntity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.values1.getPort("output").link(r1);
    this.selectChannel.getPort("input").link(r1);
    TypedIORelation r2 = new TypedIORelation(this, "r2");
    this.values2.getPort("output").link(r2);
    this.selectChannel.getPort("input").link(r2);
    TypedIORelation r3 = new TypedIORelation(this, "r3");
    this.values3.getPort("output").link(r3);
    this.selectChannel.getPort("input").link(r3);
    TypedIORelation r4 = new TypedIORelation(this, "r4");
    this.channels.getPort("output").link(r4);
    this.selectChannel.getPort("channel").link(r4);
    TypedIORelation r5 = new TypedIORelation(this, "r5");
    this.selectChannel.getPort("output").link(r5);
    this.selectChannelTest.getPort("input").link(r5);
    
  }
  
  public SelectChannelNTestModel(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "SelectChannelNTestModel");
    
  }
}
