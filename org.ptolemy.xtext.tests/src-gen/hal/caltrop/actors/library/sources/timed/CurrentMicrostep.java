package hal.caltrop.actors.library.sources.timed;

import hal.caltrop.actors.library.sources.timed.CurrentMicrostepImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class CurrentMicrostep extends AbstractCaltropActor {
  protected TypedIOPort output;
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  public IntToken createOutputToken(final int output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  public CurrentMicrostep(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.output = createOutputPort();
    this._impl = new CurrentMicrostepImpl(this, output); 
  }
  
  private final CurrentMicrostepImpl _impl;
  
  protected CurrentMicrostepImpl _getImpl() {
    return _impl;
    
  }
}
