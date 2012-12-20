package hal.caltrop.actors.library.sinks.generic;

import hal.caltrop.actors.library.sinks.generic.DiscardImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class Discard extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  public Object getInputTokenValue(final Token input) throws IllegalActionException {
    return ObjectToken.convert(input).getValue(); 
  }
  
  public Discard(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = createInputPort();
    this._impl = new DiscardImpl(this, input); 
  }
  
  private final DiscardImpl _impl;
  
  protected DiscardImpl _getImpl() {
    return _impl;
    
  }
}
