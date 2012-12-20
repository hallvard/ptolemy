package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.Single1T1String;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.util.IllegalActionException;

public abstract class Single1T1StringImpl<T> extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public Single1T1StringImpl(final Single1T1String<T> _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this.input = input;
    this.output = output;
    
  }
  
  public abstract Single1T1String<T> getActor();
  
  private int step;
  
  private int old_step;
  
  public void initialize() throws IllegalActionException {
    super.initialize(); 
    this.old_step = 0;
    
  }
  
  public boolean prefire() throws IllegalActionException {
    this.step = old_step;
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
    this.old_step = step;
    return true; 
  }
  
  public boolean action1Match() throws IllegalActionException {
    if (! this.input.hasToken(0)) return false;
    T t = getActor().getInputTokenValue(this.input.get(0));
    _setDoMethod("action1Do", t);
    return true; 
  }
  
  public void action1Do(final T t) throws IllegalActionException {
    
    int _plus = (this.step + 1);
    this.step = _plus;
    _setOutputMethod("action1Output", t);
    
  }
  
  public void action1Output(final T t) throws IllegalActionException {
    
    String _plus = (Integer.valueOf(this.step) + ": t=");
    String _plus_1 = (_plus + t);
    String _value = _plus_1;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
