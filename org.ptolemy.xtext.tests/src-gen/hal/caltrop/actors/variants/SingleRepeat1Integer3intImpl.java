package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.SingleRepeat1Integer3int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.tokens.IntTokens;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class SingleRepeat1Integer3intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public SingleRepeat1Integer3intImpl(final SingleRepeat1Integer3int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final SingleRepeat1Integer3int _actor;
  
  public SingleRepeat1Integer3int getActor() {
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
    
    Integer _index = com.google.common.collect.Iterables.get(i, 0);
    int _value = _index;
    
    Integer _index_1 = com.google.common.collect.Iterables.get(i, 1);
    int _value_1 = _index_1;
    
    Integer _index_2 = com.google.common.collect.Iterables.get(i, 2);
    int _value_2 = _index_2;
    this.output.send(0, new IntToken[]{
      getActor().createOutputToken(_value), getActor().createOutputToken(_value_1), getActor().createOutputToken(_value_2)
    }, 3);
    
  }
}
