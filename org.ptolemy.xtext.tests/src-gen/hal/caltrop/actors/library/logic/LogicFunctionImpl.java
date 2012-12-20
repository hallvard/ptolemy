package hal.caltrop.actors.library.logic;

import hal.caltrop.actors.library.logic.LogicFunction;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public class LogicFunctionImpl extends AbstractActorImpl {
  protected final Parameter function;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public LogicFunctionImpl(final LogicFunction _actor, final Parameter function, final TypedIOPort input, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.function = function;
    this.input = input;
    this.output = output;
    
  }
  
  private final LogicFunction _actor;
  
  public LogicFunction getActor() {
    return _actor;
    
  }
  
  private List<String> optable;
  
  public void initialize() throws IllegalActionException {
    super.initialize(); 
    List<String> _asList = Arrays.<String>asList(
      "clr", "nor", "andc2", "c2", "andc1", "c1", "xor", "nand", 
      "and", "eqv", "1", "orc2", "2", "orc1", "ior", "set");
    this.optable = _asList;
    
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
    ChannelMap<Boolean> input = channelMap(_inputChannels);
    for (int _inputChannel : _inputChannels) {
      if (! this.input.hasToken(_inputChannel)) return false;
      boolean _input = getActor().getInputTokenValue(this.input.get(_inputChannel));
      input.put(_inputChannel, _input);
      
    }
    
    int _indexOf = this.optable.indexOf(getActor().getFunctionValue());
    boolean _greaterEqualsThan = (_indexOf >= 0);
    if (! _greaterEqualsThan) return false;
    _setDoMethod("action1Do", input);
    return true; 
  }
  
  public void action1Do(final ChannelMap<Boolean> input) throws IllegalActionException {
    
    final int op = this.optable.indexOf(getActor().getFunctionValue());
    int _xifexpression = (int) 0;
    Integer _head = IterableExtensions.<Integer>head(input);
    Boolean _index = input.get((_head).intValue());
    if ((_index).booleanValue()) {
      _xifexpression = 1;
    } else {
      _xifexpression = 0;
    }
    int integer1 = _xifexpression;
    for (final Integer channel : input) {
      {
        int _xifexpression_1 = (int) 0;
        Boolean _index_1 = input.get((channel).intValue());
        if ((_index_1).booleanValue()) {
          _xifexpression_1 = 2;
        } else {
          _xifexpression_1 = 0;
        }
        final int integer2 = _xifexpression_1;
        int _plus = (integer1 + integer2);
        int _doubleGreaterThan = (op >> _plus);
        int _modulo = (_doubleGreaterThan % 1);
        integer1 = _modulo;
      }
    }
    _setOutputMethod("action1Output", input, op, integer1);
    
  }
  
  public void action1Output(final ChannelMap<Boolean> input, final int op, final int integer1) throws IllegalActionException {
    
    boolean _equals = (integer1 == 1);
    boolean _value = _equals;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
