package hal.caltrop.actors.variants;

import java.util.Date;
import java.util.Iterator;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import org.ptolemy.xtext.lib.caltrop.Pair;
import org.ptolemy.xtext.lib.caltrop.tokens.ObjectTokens;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class doubleRepeatMulti1Date1Date extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(Date.class));
    return port;
    
  }
  
  protected Date _getInputTokenValue(final Token input) throws IllegalActionException {
    return ((Date) ObjectToken.convert(input).getValue()); 
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(true);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(Date.class));
    return port;
    
  }
  
  protected ObjectToken _createOutputToken(final Date output) throws IllegalActionException {
    return new ObjectToken(output, Date.class);
    
  }
  
  public doubleRepeatMulti1Date1Date(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = _createInputPort();
    this.output = _createOutputPort();
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private ChannelMap<Iterable<Date>> i1;
    
    private ChannelMap<Iterable<Date>> i2;
    
    public boolean match() throws IllegalActionException {
      int _inputRepeat = _matchPattern0Repeat();
      int _inputWidth = doubleRepeatMulti1Date1Date.this.input.getWidth();
      Integer[] _inputChannels = channels(doubleRepeatMulti1Date1Date.this.input, 2 * _inputRepeat, true, _inputWidth);
      if (_inputChannels == null || _inputChannels.length == 0) return false;
       i1 = channelMap(_inputChannels);
       i2 = channelMap(_inputChannels);
      for (int _inputChannel : _inputChannels) {
        if (! hasToken(doubleRepeatMulti1Date1Date.this.input, _inputChannel, _inputRepeat * 2)) return false;
        Token[] _inputArray = doubleRepeatMulti1Date1Date.this.input.get(_inputChannel, _inputRepeat * 2);
        Iterable<Date> _i1 = new ObjectTokens<Date>(_inputArray, 2, 0, Date.class);
        i1.put(_inputChannel, _i1);
        Iterable<Date> _i2 = new ObjectTokens<Date>(_inputArray, 2, 1, Date.class);
        i2.put(_inputChannel, _i2);
        
      }
      return true; 
    }
    
    private int _matchPattern0Repeat() throws IllegalActionException {
      return 3; 
    }
    
    public void output() throws IllegalActionException {
      int _repeat = _outputPattern0Repeat();
      int _outputWidth = doubleRepeatMulti1Date1Date.this.output.getWidth();
      Integer[] _outputChannels = channels(doubleRepeatMulti1Date1Date.this.output, 2 * _repeat, false, _outputWidth);
      for (int _outputChannel : _outputChannels) {
        if (_outputChannel < 0 || _outputChannel >= _outputWidth) continue;
        Iterator<Date> _value = _outputPattern0Output0().get(_outputChannel).iterator();
        Iterator<Date> _value_1 = _outputPattern0Output1().get(_outputChannel).iterator();
        ObjectToken[] _tokenArray = new ObjectToken[2 * _repeat];
        for (int _token = 0; _token < _repeat; _token++) {
          _tokenArray[_token * 2 + 0] = _createOutputToken(_value.next());
          _tokenArray[_token * 2 + 1] = _createOutputToken(_value_1.next());
          
        }
        send(doubleRepeatMulti1Date1Date.this.output, _outputChannel, _tokenArray, -1);
        
      }
      
    }
    
    private ChannelMap<Iterable<Date>> _outputPattern0Output0() throws IllegalActionException {
      return this.i1; 
    }
    
    private ChannelMap<Iterable<Date>> _outputPattern0Output1() throws IllegalActionException {
      return this.i2; 
    }
    
    private int _outputPattern0Repeat() throws IllegalActionException {
      return 3; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(doubleRepeatMulti1Date1Date.this.input, doubleRepeatMulti1Date1Date.this.output), BooleanDependency.valueOf(true)), 
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
