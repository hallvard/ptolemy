package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.Double2int1int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class Double2int1intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public Double2int1intImpl(final Double2int1int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final Double2int1int _actor;
  
  public Double2int1int getActor() {
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
    if (! this.input.hasToken(0, 1 * 2)) return false;
    Token[] _inputArray = this.input.get(0, 1 * 2);
    int i1 = getActor().getInputTokenValue(_inputArray[0]);
    int i2 = getActor().getInputTokenValue(_inputArray[1]);
    _setDoMethod("action1Do", i1, i2);
    return true; 
  }
  
  public void action1Do(final int i1, final int i2) throws IllegalActionException {
    _setOutputMethod("action1Output", i1, i2);
    
  }
  
  public void action1Output(final int i1, final int i2) throws IllegalActionException {
    
    int _value = i1;
    
    int _value_1 = i2;
    this.output.send(0, new IntToken[]{
      getActor().createOutputToken(_value), getActor().createOutputToken(_value_1)
    }, 2);
    
  }
}
