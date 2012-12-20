package test1;

import hal.caltrop.actors.library.sources.sequence.RampImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import test1.Ramp1;

public class Ramp1Impl extends RampImpl {
  public Ramp1Impl(final Ramp1 _actor, final Parameter init, final Parameter step, final Parameter end, final TypedIOPort output) {
    super(_actor, init, step, end, output);
    this._actor = _actor;
    
  }
  
  private final Ramp1 _actor;
  
  public Ramp1 getActor() {
    return _actor;
    
  }
}
