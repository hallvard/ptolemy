package org.ptolemy.xtext.tests.actors.misc;

import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import org.ptolemy.xtext.lib.caltrop.Pair;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public abstract class SelectChannelN<T> extends AbstractCaltropActor {
  protected TypedIOPort channel;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  protected TypedIOPort _createChannelPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "channel", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected int _getChannelTokenValue(final Token channel) throws IllegalActionException {
    return IntToken.convert(channel).intValue(); 
  }
  
  protected abstract TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract T _getInputTokenValue(final Token input) throws IllegalActionException;
  
  protected abstract TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token _createOutputToken(final T output) throws IllegalActionException;
  
  public SelectChannelN(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.channel = _createChannelPort();
    this.input = _createInputPort();
    this.output = _createOutputPort();
    
  }
  
  protected int currentChannel;
  
  private int old_currentChannel;
  
  private int _initialCurrentChannelStateVariableValue() throws IllegalActionException {
    return 0; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.old_currentChannel = _initialCurrentChannelStateVariableValue();
    _postChangeCurrentChannelState(this.old_currentChannel);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    this.currentChannel = this.old_currentChannel;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    if (_actionImpls[2].match()) return new Pair.Impl(-1, _actionImpls[2]);
    return null;
    
  }
  
  public void _preChangeCurrentChannelState(final int currentChannel) {
    
  }
  
  public void _postChangeCurrentChannelState(final int currentChannel) {
    
  }
  
  protected boolean _postfireImpl() {
    if (! super._postfireImpl()) return false;
    if (this.old_currentChannel != this.currentChannel) {
      _preChangeCurrentChannelState(this.old_currentChannel);
      this.old_currentChannel = this.currentChannel;
      _postChangeCurrentChannelState(this.old_currentChannel);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() {
    super._wrapupImpl();
    _preChangeCurrentChannelState(this.currentChannel);
    this.currentChannel = 0;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private int channel;
    
    private ChannelMap<T> input;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(SelectChannelN.this.channel, 0, 1)) return false;
      channel = _getChannelTokenValue(SelectChannelN.this.channel.get(0));
      int _inputWidth = SelectChannelN.this.input.getWidth();
      Integer[] _inputChannels = channels(SelectChannelN.this.input, 1 * 1, false, _inputWidth);
      if (_inputChannels == null || _inputChannels.length == 0) return false;
       input = channelMap(_inputChannels);
      for (int _inputChannel : _inputChannels) {
        if (! hasToken(SelectChannelN.this.input, _inputChannel, 1)) return false;
        T _input = _getInputTokenValue(SelectChannelN.this.input.get(_inputChannel));
        input.put(_inputChannel, _input);
        
      }
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      SelectChannelN.this.currentChannel = this.channel;
      
    }
    
    public void output() throws IllegalActionException {
      T _value = _outputPattern0Output0();
      send(SelectChannelN.this.output, 0, _createOutputToken(_value), -1);
      
    }
    
    private T _outputPattern0Output0() throws IllegalActionException {
      
      T _index = this.input.get(SelectChannelN.this.currentChannel);return _index; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(SelectChannelN.this.channel, SelectChannelN.this.output), BooleanDependency.valueOf(true)), new Pair.Impl(new Pair.Impl(SelectChannelN.this.input, SelectChannelN.this.output), BooleanDependency.valueOf(true)), 
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    private int channel;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(SelectChannelN.this.channel, 0, 1)) return false;
      channel = _getChannelTokenValue(SelectChannelN.this.channel.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      SelectChannelN.this.currentChannel = this.channel;
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions2 extends AbstractActionImpl {
    private ChannelMap<T> input;
    
    public boolean match() throws IllegalActionException {
      int _inputWidth = SelectChannelN.this.input.getWidth();
      Integer[] _inputChannels = channels(SelectChannelN.this.input, 1 * 1, false, _inputWidth);
      if (_inputChannels == null || _inputChannels.length == 0) return false;
       input = channelMap(_inputChannels);
      for (int _inputChannel : _inputChannels) {
        if (! hasToken(SelectChannelN.this.input, _inputChannel, 1)) return false;
        T _input = _getInputTokenValue(SelectChannelN.this.input.get(_inputChannel));
        input.put(_inputChannel, _input);
        
      }
      return true; 
    }
    
    public void output() throws IllegalActionException {
      T _value = _outputPattern0Output0();
      send(SelectChannelN.this.output, 0, _createOutputToken(_value), -1);
      
    }
    
    private T _outputPattern0Output0() throws IllegalActionException {
      
      T _index = this.input.get(SelectChannelN.this.currentChannel);return _index; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(SelectChannelN.this.input, SelectChannelN.this.output), BooleanDependency.valueOf(true)), 
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), new Actions1(), new Actions2(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
