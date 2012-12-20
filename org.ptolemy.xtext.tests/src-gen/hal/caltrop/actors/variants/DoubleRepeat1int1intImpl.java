package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.DoubleRepeat1int1int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.tokens.IntTokens;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class DoubleRepeat1int1intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public DoubleRepeat1int1intImpl(final DoubleRepeat1int1int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final DoubleRepeat1int1int _actor;
  
  public DoubleRepeat1int1int getActor() {
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
    if (! this.input.hasToken(0, _inputRepeat * 2)) return false;
    Token[] _inputArray = this.input.get(0, _inputRepeat * 2);
    int[] i1 = IntTokens.copyInto(_inputArray, 2, 0, new int[_inputRepeat]);
    int[] i2 = IntTokens.copyInto(_inputArray, 2, 1, new int[_inputRepeat]);
    _setDoMethod("action1Do", i1, i2);
    return true; 
  }
  
  public void action1Do(final int[] i1, final int[] i2) throws IllegalActionException {
    _setOutputMethod("action1Output", i1, i2);
    
  }
  
  public void action1Output(final int[] i1, final int[] i2) throws IllegalActionException {
    
    int _repeat = 3;
    
    int[] _value = i1;
    
    int[] _value_1 = i2;
    IntToken[] _tokenArray = new IntToken[2 * _repeat];
    for (int _token = 0; _token < _repeat; _token++) {
      _tokenArray[_token * 2 + 0] = getActor().createOutputToken(_value[_token]);
      _tokenArray[_token * 2 + 1] = getActor().createOutputToken(_value_1[_token]);
      
    }
    this.output.send(0, _tokenArray, _tokenArray.length);
    
  }
}
