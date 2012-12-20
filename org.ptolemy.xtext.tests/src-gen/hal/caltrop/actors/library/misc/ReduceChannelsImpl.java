package hal.caltrop.actors.library.misc;

import hal.caltrop.actors.library.misc.ReduceChannels;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public abstract class ReduceChannelsImpl<T> extends AbstractActorImpl {
  protected final Parameter function;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public ReduceChannelsImpl(final ReduceChannels<T> _actor, final Parameter function, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this.function = function;
    this.input = input;
    this.output = output;
    
  }
  
  public abstract ReduceChannels<T> getActor();
  
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
    Integer[] _inputChannels = channels(this.input, 1 * 1, true, _inputWidth);
    if (_inputChannels == null || _inputChannels.length == 0) return false;
    ChannelMap<T> input = channelMap(_inputChannels);
    for (int _inputChannel : _inputChannels) {
      if (! this.input.hasToken(_inputChannel)) return false;
      T _input = getActor().getInputTokenValue(this.input.get(_inputChannel));
      input.put(_inputChannel, _input);
      
    }
    _setDoMethod("action1Do", input);
    return true; 
  }
  
  public void action1Do(final ChannelMap<T> input) throws IllegalActionException {
    
    Integer _head = IterableExtensions.<Integer>head(input);
    T output = input.get((_head).intValue());
    Iterable<Integer> _tail = IterableExtensions.<Integer>tail(input);
    for (final Integer channel : _tail) {
      T _index = input.get((channel).intValue());
      T _apply = getActor().getFunctionValue().apply(output, _index);
      output = _apply;
    }
    _setOutputMethod("action1Output", input, output);
    
  }
  
  public void action1Output(final ChannelMap<T> input, final T output) throws IllegalActionException {
    
    T _value = output;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
