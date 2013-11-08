package org.ptolemy.xtext.tests.actors.sources.rampTestModel1;

import org.ptolemy.xtext.tests.actors.sources.sequence.Ramp;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class ramp extends Ramp {
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  public ramp(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public ramp(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "ramp");
    
  }
}
