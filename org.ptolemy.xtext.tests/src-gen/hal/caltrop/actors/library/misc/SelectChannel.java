package hal.caltrop.actors.library.misc;

import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public abstract class SelectChannel<T> extends AbstractCaltropActor {
  protected TypedIOPort channel;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public TypedIOPort createChannelPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "channel", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  public int getChannelTokenValue(final Token channel) throws IllegalActionException {
    return IntToken.convert(channel).intValue(); 
  }
  
  public abstract TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract T getInputTokenValue(final Token input) throws IllegalActionException;
  
  public abstract TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract Token createOutputToken(final T output) throws IllegalActionException;
  
  public SelectChannel(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.channel = createChannelPort();
    this.input = createInputPort();
    this.output = createOutputPort();
    
  }
}
