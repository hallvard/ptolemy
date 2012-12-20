package hal.caltrop.actors.library.sources.timed;

import hal.caltrop.actors.library.sources.timed.CurrentMicrostep;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.Director;
import ptolemy.actor.SuperdenseTimeDirector;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.util.IllegalActionException;

public class CurrentMicrostepImpl extends AbstractActorImpl {
  protected TypedIOPort output;
  
  public CurrentMicrostepImpl(final CurrentMicrostep _actor, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.output = output;
    
  }
  
  private final CurrentMicrostep _actor;
  
  public CurrentMicrostep getActor() {
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
    _setDoMethod("action1Do");
    return true; 
  }
  
  public void action1Do() throws IllegalActionException {
    _setOutputMethod("action1Output");
    
  }
  
  public void action1Output() throws IllegalActionException {
    
    Director _director = this.getDirector();
    int _index = ((SuperdenseTimeDirector) _director).getIndex();
    int _value = _index;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
