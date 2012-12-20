package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.SingleRepeat1Integer1Integer;
import java.util.Iterator;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.tokens.IntTokens;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class SingleRepeat1Integer1IntegerImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public SingleRepeat1Integer1IntegerImpl(final SingleRepeat1Integer1Integer _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final SingleRepeat1Integer1Integer _actor;
  
  public SingleRepeat1Integer1Integer getActor() {
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
    Iterable<Integer> i = new IntTokens(_inputArray, 1, 0);
    _setDoMethod("action1Do", i);
    return true; 
  }
  
  public void action1Do(final Iterable<Integer> i) throws IllegalActionException {
    _setOutputMethod("action1Output", i);
    
  }
  
  public void action1Output(final Iterable<Integer> i) throws IllegalActionException {
    
    int _repeat = 3;
    
    Iterator<Integer> _value = i.iterator();
    IntToken[] _tokenArray = new IntToken[1 * _repeat];
    for (int _token = 0; _token < _repeat; _token++) {
      _tokenArray[_token * 1 + 0] = getActor().createOutputToken(_value.next());
      
    }
    this.output.send(0, _tokenArray, _tokenArray.length);
    
  }
}
