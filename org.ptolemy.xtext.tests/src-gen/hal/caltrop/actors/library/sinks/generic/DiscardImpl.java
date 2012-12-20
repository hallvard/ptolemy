package hal.caltrop.actors.library.sinks.generic;

import hal.caltrop.actors.library.sinks.generic.Discard;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.util.IllegalActionException;

public class DiscardImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  public DiscardImpl(final Discard _actor, final TypedIOPort input) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    
  }
  
  private final Discard _actor;
  
  public Discard getActor() {
    return _actor;
    
  }
  
  public boolean prefire() throws IllegalActionException {
    if (super.prefire()) return true;
    if (action1Match()) return true;
    
    return false; 
  }
  
  public boolean fire() throws IllegalActionException {
    super.fire();
    return _callDoMethod() && _callOutputMethod(); 
  }
  
  public boolean action1Match() throws IllegalActionException {
    if (! this.input.hasToken(0)) return false;
    Object ignore = getActor().getInputTokenValue(this.input.get(0));
    _setDoMethod("action1Do", ignore);
    return true; 
  }
  
  public void action1Do(final Object ignore) throws IllegalActionException {
    _setOutputMethod("action1Output", ignore);
    
  }
  
  public void action1Output(final Object ignore) throws IllegalActionException {
    
  }
}
