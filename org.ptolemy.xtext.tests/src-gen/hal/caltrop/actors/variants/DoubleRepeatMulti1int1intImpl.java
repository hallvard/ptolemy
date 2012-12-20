package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.DoubleRepeatMulti1int1int;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import org.ptolemy.xtext.lib.caltrop.tokens.IntTokens;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class DoubleRepeatMulti1int1intImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public DoubleRepeatMulti1int1intImpl(final DoubleRepeatMulti1int1int _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final DoubleRepeatMulti1int1int _actor;
  
  public DoubleRepeatMulti1int1int getActor() {
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
    int _inputWidth = this.input.getWidth();
    Integer[] _inputChannels = channels(this.input, 2 * _inputRepeat, true, _inputWidth);
    if (_inputChannels == null || _inputChannels.length == 0) return false;
    ChannelMap<int[]> i1 = channelMap(_inputChannels);
    ChannelMap<int[]> i2 = channelMap(_inputChannels);
    for (int _inputChannel : _inputChannels) {
      if (! this.input.hasToken(_inputChannel, _inputRepeat * 2)) return false;
      Token[] _inputArray = this.input.get(_inputChannel, _inputRepeat * 2);
      int[] _i1 = IntTokens.copyInto(_inputArray, 2, 0, new int[_inputRepeat]);
      i1.put(_inputChannel, _i1);
      int[] _i2 = IntTokens.copyInto(_inputArray, 2, 1, new int[_inputRepeat]);
      i2.put(_inputChannel, _i2);
      
    }
    _setDoMethod("action1Do", i1, i2);
    return true; 
  }
  
  public void action1Do(final ChannelMap<int[]> i1, final ChannelMap<int[]> i2) throws IllegalActionException {
    _setOutputMethod("action1Output", i1, i2);
    
  }
  
  public void action1Output(final ChannelMap<int[]> i1, final ChannelMap<int[]> i2) throws IllegalActionException {
    
    int _repeat = 3;
    int _outputWidth = this.output.getWidth();
    Integer[] _outputChannels = channels(this.output, 2 * _repeat, false, _outputWidth);
    for (int _outputChannel : _outputChannels) {
      if (_outputChannel < 0 || _outputChannel >= _outputWidth) continue;
      
      int[] _value = i1.get(_outputChannel);
      
      int[] _value_1 = i2.get(_outputChannel);
      IntToken[] _tokenArray = new IntToken[2 * _repeat];
      for (int _token = 0; _token < _repeat; _token++) {
        _tokenArray[_token * 2 + 0] = getActor().createOutputToken(_value[_token]);
        _tokenArray[_token * 2 + 1] = getActor().createOutputToken(_value_1[_token]);
        
      }
      this.output.send(_outputChannel, _tokenArray, _tokenArray.length);
      
    }
    
  }
}
