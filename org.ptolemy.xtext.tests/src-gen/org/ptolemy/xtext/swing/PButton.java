package org.ptolemy.xtext.swing;

import com.google.common.base.Objects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
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
  
  protected JButton button;
  
  private JButton _initialButtonStateVariableValue() throws IllegalActionException {
    
    JButton _get = this.<JButton>get(_getIdValue(), JButton.class);return _get; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.button = _initialButtonStateVariableValue();
    _postChangeButtonState(this.button);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class button1ActionListener implements ActionListener {
    public void actionPerformed(final ActionEvent arg0) {
      postEvent(0, button, "action", "actionPerformed", arg0);
      
    }
  }
  
  
  private ActionListener button1ActionListener = new button1ActionListener();
    ;
  
  public void _preChangeButtonState(final JButton button) {
    if (button != null) {
      button.removeActionListener(button1ActionListener);
      
    }
    
  }
  
  public void _postChangeButtonState(final JButton button) {
    if (button != null) {
      button.addActionListener(button1ActionListener);
      
    }
    
  }
  
  protected boolean _postfireImpl() {
    if (! super._postfireImpl()) return false;
    return true; 
  }
  
  protected void _wrapupImpl() {
    super._wrapupImpl();
    _preChangeButtonState(this.button);
    this.button = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private ChannelMap<Object> enable;
    
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
    
    public void output() throws IllegalActionException {
      
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
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
        PButton.this.button.setEnabled(_and);
        _xblockexpression = (true);
      }
      return _xblockexpression;
      
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
