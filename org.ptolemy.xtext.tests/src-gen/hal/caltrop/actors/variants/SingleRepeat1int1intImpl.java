package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.SingleRepeat1int1int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.tokens.IntTokens;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class SingleRepeat1int1intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public SingleRepeat1int1intImpl(final SingleRepeat1int1int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final SingleRepeat1int1int _actor;
  
  public SingleRepeat1int1int getActor() {
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
    
    int _inputRepeat = 3;
    if (! this.input.hasToken(0, _inputRepeat * 1)) return false;
    Token[] _inputArray = this.input.get(0, _inputRepeat * 1);
    int[] i = IntTokens.copyInto(_inputArray, 1, 0, new int[_inputRepeat]);
    _setDoMethod("action1Do", i);
    return true; 
  }
  
  public void action1Do(final int[] i) throws IllegalActionException {
    _setOutputMethod("action1Output", i);
    
  }
  
  public void action1Output(final int[] i) throws IllegalActionException {
    
    int _repeat = 3;
    
    int[] _value = i;
    IntToken[] _tokenArray = new IntToken[1 * _repeat];
    for (int _token = 0; _token < _repeat; _token++) {
      _tokenArray[_token * 1 + 0] = getActor().createOutputToken(_value[_token]);
      
    }
    this.output.send(0, _tokenArray, _tokenArray.length);
    
  }
}
