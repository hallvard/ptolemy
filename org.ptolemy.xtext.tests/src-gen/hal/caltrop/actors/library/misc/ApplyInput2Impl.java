package hal.caltrop.actors.library.misc;

import hal.caltrop.actors.library.misc.ApplyInput2;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public abstract class ApplyInput2Impl<T, R> extends AbstractActorImpl {
  protected final Parameter function;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public ApplyInput2Impl(final ApplyInput2<T,R> _actor, final Parameter function, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this.function = function;
    this.input = input;
    this.output = output;
    
  }
  
  public abstract ApplyInput2<T,R> getActor();
  
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
    if (! this.input.hasToken(0, 1 * 2)) return false;
    Token[] _inputArray = this.input.get(0, 1 * 2);
    T input1 = getActor().getInputTokenValue(_inputArray[0]);
    T input2 = getActor().getInputTokenValue(_inputArray[1]);
    _setDoMethod("action1Do", input1, input2);
    return true; 
  }
  
  public void action1Do(final T input1, final T input2) throws IllegalActionException {
    
    final R value = getActor().getFunctionValue().apply(input1, input2);
    _setOutputMethod("action1Output", input1, input2, value);
    
  }
  
  public void action1Output(final T input1, final T input2, final R value) throws IllegalActionException {
    
    R _value = value;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
