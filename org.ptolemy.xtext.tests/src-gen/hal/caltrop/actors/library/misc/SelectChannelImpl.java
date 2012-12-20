package hal.caltrop.actors.library.misc;

import hal.caltrop.actors.library.misc.SelectChannel;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.util.IllegalActionException;

public abstract class SelectChannelImpl<T> extends AbstractActorImpl {
  protected TypedIOPort channel;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public SelectChannelImpl(final SelectChannel<T> _actor, final TypedIOPort channel, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this.channel = channel;
    this.input = input;
    this.output = output;
    
  }
  
  public abstract SelectChannel<T> getActor();
  
  private int currentChannel;
  
  private int old_currentChannel;
  
  public void initialize() throws IllegalActionException {
    super.initialize(); 
    this.old_currentChannel = 0;
    
  }
  
  public boolean prefire() throws IllegalActionException {
    this.currentChannel = old_currentChannel;
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
    this.old_currentChannel = currentChannel;
    return true; 
  }
  
  public boolean action1Match() throws IllegalActionException {
    if (! this.channel.hasToken(0)) return false;
    int channel = getActor().getChannelTokenValue(this.channel.get(0));
    int _inputWidth = this.input.getWidth();
    
    int _inputChannel = channel;
    Integer[] _inputChannels = channels(this.input, 1 * 1, false, new int[]{
      _inputChannel
    });
    if (_inputChannels == null || _inputChannels.length == 0) return false;
    ChannelMap<T> input = channelMap(_inputChannels);
    for (int _inputChannel_1 : _inputChannels) {
      if (! this.input.hasToken(_inputChannel_1)) return false;
      T _input = getActor().getInputTokenValue(this.input.get(_inputChannel_1));
      input.put(_inputChannel_1, _input);
      
    }
    _setDoMethod("action1Do", channel, input);
    return true; 
  }
  
  public void action1Do(final int channel, final ChannelMap<T> input) throws IllegalActionException {
    
    this.currentChannel = channel;
    final T value = input.get(this.currentChannel);
    _setOutputMethod("action1Output", channel, input, value);
    
  }
  
  public void action1Output(final int channel, final ChannelMap<T> input, final T value) throws IllegalActionException {
    
    T _value = value;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
