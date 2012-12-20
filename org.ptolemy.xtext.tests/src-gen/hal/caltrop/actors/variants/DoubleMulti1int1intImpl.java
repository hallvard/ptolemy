package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.DoubleMulti1int1int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class DoubleMulti1int1intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public DoubleMulti1int1intImpl(final DoubleMulti1int1int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final DoubleMulti1int1int _actor;
  
  public DoubleMulti1int1int getActor() {
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
    int _inputWidth = this.input.getWidth();
    Integer[] _inputChannels = channels(this.input, 2 * 1, false, _inputWidth);
    if (_inputChannels == null || _inputChannels.length == 0) return false;
    ChannelMap<Integer> i1 = channelMap(_inputChannels);
    ChannelMap<Integer> i2 = channelMap(_inputChannels);
    for (int _inputChannel : _inputChannels) {
      if (! this.input.hasToken(_inputChannel, 1 * 2)) return false;
      Token[] _inputArray = this.input.get(_inputChannel, 1 * 2);
      int _i1 = getActor().getInputTokenValue(_inputArray[0]);
      i1.put(_inputChannel, _i1);
      int _i2 = getActor().getInputTokenValue(_inputArray[1]);
      i2.put(_inputChannel, _i2);
      
    }
    _setDoMethod("action1Do", i1, i2);
    return true; 
  }
  
  public void action1Do(final ChannelMap<Integer> i1, final ChannelMap<Integer> i2) throws IllegalActionException {
    _setOutputMethod("action1Output", i1, i2);
    
  }
  
  public void action1Output(final ChannelMap<Integer> i1, final ChannelMap<Integer> i2) throws IllegalActionException {
    int _outputWidth = this.output.getWidth();
    Integer[] _outputChannels = channels(this.output, 2 * 1, false, _outputWidth);
    for (int _outputChannel : _outputChannels) {
      if (_outputChannel < 0 || _outputChannel >= _outputWidth) continue;
      
      int _value = i1.get(_outputChannel);
      
      int _value_1 = i2.get(_outputChannel);
      this.output.send(_outputChannel, new IntToken[]{
        getActor().createOutputToken(_value), getActor().createOutputToken(_value_1)
      }, 2);
      
    }
    
  }
}
