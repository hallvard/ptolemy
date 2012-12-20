package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.DoubleRepeatMulti1Date1Date;
import java.util.Date;
import java.util.Iterator;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import org.ptolemy.xtext.lib.caltrop.tokens.ObjectTokens;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.util.IllegalActionException;

public class DoubleRepeatMulti1Date1DateImpl extends AbstractActorImpl {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public DoubleRepeatMulti1Date1DateImpl(final DoubleRepeatMulti1Date1Date _actor, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.input = input;
    this.output = output;
    
  }
  
  private final DoubleRepeatMulti1Date1Date _actor;
  
  public DoubleRepeatMulti1Date1Date getActor() {
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
    ChannelMap<Iterable<Date>> i1 = channelMap(_inputChannels);
    ChannelMap<Iterable<Date>> i2 = channelMap(_inputChannels);
    for (int _inputChannel : _inputChannels) {
      if (! this.input.hasToken(_inputChannel, _inputRepeat * 2)) return false;
      Token[] _inputArray = this.input.get(_inputChannel, _inputRepeat * 2);
      Iterable<Date> _i1 = new ObjectTokens<Date>(_inputArray, 2, 0, Date.class);
      i1.put(_inputChannel, _i1);
      Iterable<Date> _i2 = new ObjectTokens<Date>(_inputArray, 2, 1, Date.class);
      i2.put(_inputChannel, _i2);
      
    }
    _setDoMethod("action1Do", i1, i2);
    return true; 
  }
  
  public void action1Do(final ChannelMap<Iterable<Date>> i1, final ChannelMap<Iterable<Date>> i2) throws IllegalActionException {
    _setOutputMethod("action1Output", i1, i2);
    
  }
  
  public void action1Output(final ChannelMap<Iterable<Date>> i1, final ChannelMap<Iterable<Date>> i2) throws IllegalActionException {
    
    int _repeat = 3;
    int _outputWidth = this.output.getWidth();
    Integer[] _outputChannels = channels(this.output, 2 * _repeat, false, _outputWidth);
    for (int _outputChannel : _outputChannels) {
      if (_outputChannel < 0 || _outputChannel >= _outputWidth) continue;
      
      Iterator<Date> _value = i1.get(_outputChannel).iterator();
      
      Iterator<Date> _value_1 = i2.get(_outputChannel).iterator();
      ObjectToken[] _tokenArray = new ObjectToken[2 * _repeat];
      for (int _token = 0; _token < _repeat; _token++) {
        _tokenArray[_token * 2 + 0] = getActor().createOutputToken(_value.next());
        _tokenArray[_token * 2 + 1] = getActor().createOutputToken(_value_1.next());
        
      }
      this.output.send(_outputChannel, _tokenArray, _tokenArray.length);
      
    }
    
  }
}
