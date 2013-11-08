package org.ptolemy.xtext.examples.javafx.scene.control;

import com.google.common.base.Objects;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;
import org.ptolemy.xtext.lib.caltrop.Pair;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.Variable;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class PButton extends AbstractCaltropActor {
  protected final Variable id;
  
  protected TypedIOPort enable;
  
  protected TypedIOPort actionEvent;
  
  protected Parameter _createIdAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "id");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return attribute;
    
  }
  
  protected StringToken _createIdToken(final String id) throws IllegalActionException {
    return new StringToken(id);
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  protected String _getIdValue() throws IllegalActionException {
    return StringToken.convert(this.id.getToken()).stringValue(); 
  }
  
  protected void _setIdValue(final String id) throws IllegalActionException {
    this.id.setToken(_createIdToken(id));
    
  }
  
  protected TypedIOPort _createEnablePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "enable", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  protected Object _getEnableTokenValue(final Token enable) throws IllegalActionException {
    return ObjectToken.convert(enable).getValue(); 
  }
  
  protected TypedIOPort _createActionEventPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "actionEvent", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  protected ObjectToken _createActionEventToken(final Object actionEvent) throws IllegalActionException {
    return new ObjectToken(actionEvent, Object.class);
    
  }
  
  public PButton(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.enable = _createEnablePort();
    this.actionEvent = _createActionEventPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  public PButton(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PButton");
    
  }
  
  protected Button button;
  
  private Button _initialButtonStateVariableValue() throws IllegalActionException {
    
    Button _get = this.<Button>get(_getIdValue(), Button.class);return _get; 
  }
  
  protected boolean enabled;
  
  private boolean old_enabled;
  
  private boolean _initialEnabledStateVariableValue() throws IllegalActionException {
    
    boolean _isDisabled = this.button.isDisabled();
    boolean _not = (!_isDisabled);return _not; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.button = this.button = _initialButtonStateVariableValue();
    _postChangeButtonState(this.button);
    this.enabled = this.old_enabled = _initialEnabledStateVariableValue();
    _postChangeEnabledState(this.enabled);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    this.enabled = this.old_enabled;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class button1ActionListener implements EventHandler<ActionEvent> {
    public void handle(final ActionEvent arg0) {
      postEvent(0, button, "action", "handle", arg0);
      
    }
  }
  
  
  private EventHandler<ActionEvent> button1ActionListener = new button1ActionListener();
    ;
  
  public void _preChangeButtonState_javafx(final Button button) throws IllegalActionException {
    if (button != null) {
      button.setOnAction(null);
      
    }
    
  }
  
  public void _preChangeButtonState(final Button button) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeButtonState_javafx(button);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeEnabledState_javafx(final boolean enabled) throws IllegalActionException {
    
  }
  
  public void _preChangeEnabledState(final boolean enabled) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeEnabledState_javafx(enabled);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeButtonState_javafx(final Button button) throws IllegalActionException {
    if (button != null) {
      button.setOnAction(button1ActionListener);
      
    }
    
  }
  
  public void _postChangeButtonState(final Button button) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeButtonState_javafx(button);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeEnabledState_javafx(final boolean enabled) throws IllegalActionException {
    
  }
  
  public void _postChangeEnabledState(final boolean enabled) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeEnabledState_javafx(enabled);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateEnabledState_javafx() throws IllegalActionException {
    
    boolean _not = (!this.enabled);
    this.button.setDisable(_not);
    
  }
  
  public void _updateEnabledState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updateEnabledState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  protected boolean _postfireImpl() throws IllegalActionException {
    if (! super._postfireImpl()) return false;
    if (this.old_enabled != this.enabled) {
      _updateEnabledState();
      _preChangeEnabledState(this.old_enabled);
      this.old_enabled = this.enabled;
      _postChangeEnabledState(this.old_enabled);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() throws IllegalActionException {
    super._wrapupImpl();
    _preChangeButtonState(this.button);
    this.button = null;
    _preChangeEnabledState(this.enabled);
    this.enabled = false;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private ChannelMap<Object> enable;
    
    private Object value;
    
    public boolean match() throws IllegalActionException {
      int _enableWidth = PButton.this.enable.getWidth();
      Integer[] _enableChannels = channels(PButton.this.enable, 1 * 1, true, _enableWidth);
      if (_enableChannels == null || _enableChannels.length == 0) return false;
       enable = channelMap(_enableChannels);
      for (int _enableChannel : _enableChannels) {
        if (! hasToken(PButton.this.enable, _enableChannel, 1)) return false;
        Object _enable = _getEnableTokenValue(PButton.this.enable.get(_enableChannel));
        enable.put(_enableChannel, _enable);
        
      }
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      Iterator<Object> _values = this.enable.values();
      final Object value = IteratorExtensions.<Object>head(_values);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _notEquals = (!Objects.equal(value, null));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(value, Boolean.FALSE));
        _and_1 = (_notEquals && _notEquals_1);
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _not = (!(value instanceof Exception));
        _and = (_and_1 && _not);
      }
      PButton.this.enabled = _and;
      this.value = value;
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    private ActionEvent actionEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(button, "action", null);
      if (event == null) return false;
      if (event.length > 0) actionEvent = (ActionEvent) event[0];
      return true; 
    }
    
    public void output() throws IllegalActionException {
      Object _value = _outputPattern0Output0();
      send(PButton.this.actionEvent, 0, _createActionEventToken(_value), -1);
      
    }
    
    private Object _outputPattern0Output0() throws IllegalActionException {
      return this.actionEvent; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), new Actions1(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
