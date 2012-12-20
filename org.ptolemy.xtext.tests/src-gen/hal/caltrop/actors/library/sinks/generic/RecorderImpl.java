package hal.caltrop.actors.library.sinks.generic;

import com.google.common.collect.Iterables;
import hal.caltrop.actors.library.sinks.generic.Recorder;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import ptolemy.actor.Director;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.Time;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public class RecorderImpl extends AbstractActorImpl {
  protected final Parameter capacity;
  
  protected TypedIOPort input;
  
  public RecorderImpl(final Recorder _actor, final Parameter capacity, final TypedIOPort input) {
    super(_actor);
    this._actor = _actor;
    this.capacity = capacity;
    this.input = input;
    
  }
  
  private final Recorder _actor;
  
  public Recorder getActor() {
    return _actor;
    
  }
  
  private Collection<Object> values;
  
  private Collection<Double> times;
  
  public void initialize() throws IllegalActionException {
    super.initialize(); 
    LinkedList<Object> _linkedList = new LinkedList<Object>();
    this.values = _linkedList;
    
    LinkedList<Double> _linkedList_1 = new LinkedList<Double>();
    this.times = _linkedList_1;
    
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
  
  public boolean postfire() throws IllegalActionException {
    if (! super.postfire()) return false;
    return true; 
  }
  
  public boolean action1Match() throws IllegalActionException {
    int _inputWidth = this.input.getWidth();
    Integer[] _inputChannels = channels(this.input, 1 * 1, true, _inputWidth);
    if (_inputChannels == null || _inputChannels.length == 0) return false;
    ChannelMap<Object> input = channelMap(_inputChannels);
    for (int _inputChannel : _inputChannels) {
      if (! this.input.hasToken(_inputChannel)) return false;
      Object _input = getActor().getInputTokenValue(this.input.get(_inputChannel));
      input.put(_inputChannel, _input);
      
    }
    _setDoMethod("action1Do", input);
    return true; 
  }
  
  public void action1Do(final ChannelMap<Object> input) throws IllegalActionException {
    
    boolean _and = false;
    boolean _greaterEqualsThan = (getActor().getCapacityValue() >= 0);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      int _size = this.values.size();
      boolean _greaterEqualsThan_1 = (_size >= getActor().getCapacityValue());
      _and = (_greaterEqualsThan && _greaterEqualsThan_1);
    }
    boolean _while = _and;
    while (_while) {
      {
        this.values.remove(Integer.valueOf(0));
        this.times.remove(Integer.valueOf(0));
      }
      boolean _and_1 = false;
      boolean _greaterEqualsThan_2 = (getActor().getCapacityValue() >= 0);
      if (!_greaterEqualsThan_2) {
        _and_1 = false;
      } else {
        int _size_1 = this.values.size();
        boolean _greaterEqualsThan_3 = (_size_1 >= getActor().getCapacityValue());
        _and_1 = (_greaterEqualsThan_2 && _greaterEqualsThan_3);
      }
      _while = _and_1;
    }
    Iterator<Object> _values = input.values();
    Iterable<Object> _iterable = IteratorExtensions.<Object>toIterable(_values);
    Iterables.<Object>addAll(this.values, _iterable);
    Director _director = this.getDirector();
    Time _modelTime = _director.getModelTime();
    double _doubleValue = _modelTime.getDoubleValue();
    this.times.add(Double.valueOf(_doubleValue));
    _setOutputMethod("action1Output", input);
    
  }
  
  public void action1Output(final ChannelMap<Object> input) throws IllegalActionException {
    
  }
}
