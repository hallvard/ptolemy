package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.Double2int1String;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class Double2int1StringImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public Double2int1StringImpl(final Double2int1String _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final Double2int1String _actor;
  
  public Double2int1String getActor() {
    return _actor;
    
  }
  
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
    if (! this.input.hasToken(0, 1 * 2)) return false;
    Token[] _inputArray = this.input.get(0, 1 * 2);
    int i1 = getActor().getInputTokenValue(_inputArray[0]);
    int i2 = getActor().getInputTokenValue(_inputArray[1]);
    _setDoMethod("action1Do", i1, i2);
    return true; 
  }
  
  public void action1Do(final int i1, final int i2) throws IllegalActionException {
    
    int _plus = (this.step + 1);
    this.step = _plus;
    _setOutputMethod("action1Output", i1, i2);
    
  }
  
  public void action1Output(final int i1, final int i2) throws IllegalActionException {
    
    String _plus = (Integer.valueOf(this.step) + ": i1=");
    String _plus_1 = (_plus + Integer.valueOf(i1));
    String _value = _plus_1;
    
    String _plus_2 = (Integer.valueOf(this.step) + ": i2=");
    String _plus_3 = (_plus_2 + Integer.valueOf(i2));
    String _value_1 = _plus_3;
    this.output.send(0, new StringToken[]{
      getActor().createOutputToken(_value), getActor().createOutputToken(_value_1)
    }, 2);
    
  }
}
