package hal.caltrop.actors.library.misc;

import hal.caltrop.actors.library.misc.Copier;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.util.IllegalActionException;

public abstract class CopierImpl<T> extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public CopierImpl(final Copier<T> _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this.input = input;
    this.output = output;
    
  }
  
  public abstract Copier<T> getActor();
  
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
    T input = getActor().getInputTokenValue(this.input.get(0));
    _setDoMethod("action1Do", input);
    return true; 
  }
  
  public void action1Do(final T input) throws IllegalActionException {
    _setOutputMethod("action1Output", input);
    
  }
  
  public void action1Output(final T input) throws IllegalActionException {
    
    T _value = input;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
