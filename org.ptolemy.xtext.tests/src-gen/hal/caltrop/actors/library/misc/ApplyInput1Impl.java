package hal.caltrop.actors.library.misc;

import hal.caltrop.actors.library.misc.ApplyInput1;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public abstract class ApplyInput1Impl<T, R> extends AbstractActorImpl {
  protected final Parameter function;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public ApplyInput1Impl(final ApplyInput1<T,R> _actor, final Parameter function, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this.function = function;
    this.input = input;
    this.output = output;
    
  }
  
  public abstract ApplyInput1<T,R> getActor();
  
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
    
    final R value = getActor().getFunctionValue().apply(input);
    _setOutputMethod("action1Output", input, value);
    
  }
  
  public void action1Output(final T input, final R value) throws IllegalActionException {
    
    R _value = value;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
