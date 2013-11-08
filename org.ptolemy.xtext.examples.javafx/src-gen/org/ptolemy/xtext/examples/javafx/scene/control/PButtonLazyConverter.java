package org.ptolemy.xtext.examples.javafx.scene.control;

import com.google.common.base.Objects;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.Pair;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.Variable;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public abstract class PButtonLazyConverter<T, S> extends AbstractCaltropActor {
  protected final Variable id;
  
  protected final Variable fun;
  
  protected final Variable validator;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
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
  
  protected abstract Parameter _createFunAttribute() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token _createFunToken(final Function1<? super T,? extends S> fun) throws IllegalActionException;
  
  protected Function1<? super T,? extends S> _initialFunAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  protected abstract Function1<? super T,? extends S> _getFunValue() throws IllegalActionException;
  
  protected void _setFunValue(final Function1<? super T,? extends S> fun) throws IllegalActionException {
    this.fun.setToken(_createFunToken(fun));
    
  }
  
  protected abstract Parameter _createValidatorAttribute() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token _createValidatorToken(final Function1<? super T,? extends Boolean> validator) throws IllegalActionException;
  
  protected Function1<? super T,? extends Boolean> _initialValidatorAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  protected abstract Function1<? super T,? extends Boolean> _getValidatorValue() throws IllegalActionException;
  
  protected void _setValidatorValue(final Function1<? super T,? extends Boolean> validator) throws IllegalActionException {
    this.validator.setToken(_createValidatorToken(validator));
    
  }
  
  protected abstract TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract T _getInputTokenValue(final Token input) throws IllegalActionException;
  
  protected abstract TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token _createOutputToken(final S output) throws IllegalActionException;
  
  public PButtonLazyConverter(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.fun = _createFunAttribute();
    this.validator = _createValidatorAttribute();
    this.input = _createInputPort();
    this.output = _createOutputPort();
    _setIdValue(_initialIdAttributeValue());
    _setFunValue(_initialFunAttributeValue());
    _setValidatorValue(_initialValidatorAttributeValue());
    
  }
  
  public PButtonLazyConverter(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PButtonLazyConverter");
    
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
  
  protected T current;
  
  private T old_current;
  
  private T _initialCurrentStateVariableValue() throws IllegalActionException {
    return null; 
  }
  
  public boolean isValid() throws IllegalActionException {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.current, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _or = false;
      boolean _equals = Objects.equal(_getValidatorValue(), null);
      if (_equals) {
        _or = true;
      } else {
        Boolean _apply = _getValidatorValue().apply(this.current);
        _or = (_equals || (_apply).booleanValue());
      }
      _and = (_notEquals && _or);
    }
    return _and;
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.button = this.button = _initialButtonStateVariableValue();
    _postChangeButtonState(this.button);
    this.enabled = this.old_enabled = _initialEnabledStateVariableValue();
    _postChangeEnabledState(this.enabled);
    this.current = this.old_current = _initialCurrentStateVariableValue();
    _postChangeCurrentState(this.current);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    this.enabled = this.old_enabled;
    this.current = this.old_current;
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
  
  public void _preChangeCurrentState(final T current) throws IllegalActionException {
    
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
  
  public void _postChangeCurrentState(final T current) throws IllegalActionException {
    
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
    if (this.old_current != this.current) {
      _preChangeCurrentState(this.old_current);
      this.old_current = this.current;
      _postChangeCurrentState(this.old_current);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() throws IllegalActionException {
    super._wrapupImpl();
    _preChangeButtonState(this.button);
    this.button = null;
    _preChangeEnabledState(this.enabled);
    this.enabled = false;
    _preChangeCurrentState(this.current);
    this.current = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private T input;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PButtonLazyConverter.this.input, 0, 1)) return false;
      input = _getInputTokenValue(PButtonLazyConverter.this.input.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      PButtonLazyConverter.this.current = this.input;
      boolean _isValid = PButtonLazyConverter.this.isValid();
      PButtonLazyConverter.this.enabled = _isValid;
      
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
      if (_outputPattern0Guard()) {
        S _value = _outputPattern0Output0();
        send(PButtonLazyConverter.this.output, 0, _createOutputToken(_value), -1);
        
      }
      
    }
    
    private S _outputPattern0Output0() throws IllegalActionException {
      
      S _apply = _getFunValue().apply(PButtonLazyConverter.this.current);return _apply; 
    }
    
    private boolean _outputPattern0Guard() throws IllegalActionException {
      
      boolean _isValid = PButtonLazyConverter.this.isValid();return _isValid; 
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
