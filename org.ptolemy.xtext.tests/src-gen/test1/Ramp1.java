package test1;

import hal.caltrop.actors.library.sources.sequence.Ramp;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import test1.Ramp1Impl;

public class Ramp1 extends Ramp {
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected int initialInitAttributeValue() throws IllegalActionException {
    
    
    return 2; 
  }
  
  protected int initialEndAttributeValue() throws IllegalActionException {
    
    
    return 6; 
  }
  
  public Ramp1(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this._impl = new Ramp1Impl(this, init, step, end, output); 
  }
  
  private final Ramp1Impl _impl;
  
  protected Ramp1Impl _getImpl() {
    return _impl;
    
  }
}
