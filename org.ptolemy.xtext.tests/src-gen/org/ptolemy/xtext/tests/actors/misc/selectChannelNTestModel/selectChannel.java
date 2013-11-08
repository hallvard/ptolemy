package org.ptolemy.xtext.tests.actors.misc.selectChannelNTestModel;

import org.ptolemy.xtext.tests.actors.misc.SelectChannelN;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class selectChannel extends SelectChannelN<Integer> {
  protected TypedIOPort _createChannelPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "channel", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected Integer _getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected IntToken _createOutputToken(final Integer output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  public selectChannel(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public selectChannel(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "selectChannel");
    
  }
}
