package hal.caltrop.actors.library.sources.sequence;

import hal.caltrop.actors.library.sources.sequence.Ramp;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public class RampImpl extends AbstractActorImpl {
  protected final Parameter init;
  
  protected final Parameter step;
  
  protected final Parameter end;
  
  protected TypedIOPort output;
  
  public RampImpl(final Ramp _actor, final Parameter init, final Parameter step, final Parameter end, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.init = init;
    this.step = step;
    this.end = end;
    this.output = output;
    
  }
  
  private final Ramp _actor;
  
  public Ramp getActor() {
    return _actor;
    
  }
  
  private int state;
  
  private int old_state;
  
  public void initialize() throws IllegalActionException {
    super.initialize(); 
    this.old_state = getActor().getInitValue();
    
  }
  
  public boolean prefire() throws IllegalActionException {
    this.state = old_state;
    if (super.prefire()) return true;
    if (action1Match()) return true;
    
    return false; 
  }
  
  public boolean fire() throws IllegalActionException {
    super.fire();
    return _callDoMethod() && _callOutputMethod(); 
  }
  
  public boolean postfire() throws IllegalActionException {
    if (! super.postfire()) return false;
    this.old_state = state;
    return true; 
  }
  
  public boolean action1Match() throws IllegalActionException {
    
    boolean _lessThan = (this.state < getActor().getEndValue());
    if (! _lessThan) return false;
    _setDoMethod("action1Do");
    return true; 
  }
  
  public void action1Do() throws IllegalActionException {
    
    int _plus = (this.state + getActor().getStepValue());
    this.state = _plus;
    _setOutputMethod("action1Output");
    
  }
  
  public void action1Output() throws IllegalActionException {
    
    int _value = this.old_state;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
