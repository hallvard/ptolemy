package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.Single1int1int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.util.IllegalActionException;

public class Single1int1intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public Single1int1intImpl(final Single1int1int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final Single1int1int _actor;
  
  public Single1int1int getActor() {
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
    int i = getActor().getInputTokenValue(this.input.get(0));
    _setDoMethod("action1Do", i);
    return true; 
  }
  
  public void action1Do(final int i) throws IllegalActionException {
    _setOutputMethod("action1Output", i);
    
  }
  
  public void action1Output(final int i) throws IllegalActionException {
    
    int _value = i;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
