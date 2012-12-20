package hal.caltrop.actors.library.sources.generic;

import hal.caltrop.actors.library.sources.generic.StringConst;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public class StringConstImpl extends AbstractActorImpl {
  protected final Parameter value;
  
  protected final Parameter fireLimit;
  
  protected TypedIOPort output;
  
  public StringConstImpl(final StringConst _actor, final Parameter value, final Parameter fireLimit, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.value = value;
    this.fireLimit = fireLimit;
    this.output = output;
    
  }
  
  private final StringConst _actor;
  
  public StringConst getActor() {
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
    
    boolean _lessThan = (this.step < getActor().getFireLimitValue());
    if (! _lessThan) return false;
    _setDoMethod("action1Do");
    return true; 
  }
  
  public void action1Do() throws IllegalActionException {
    _setOutputMethod("action1Output");
    
  }
  
  public void action1Output() throws IllegalActionException {
    
    String _value = getActor().getValueValue();
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
