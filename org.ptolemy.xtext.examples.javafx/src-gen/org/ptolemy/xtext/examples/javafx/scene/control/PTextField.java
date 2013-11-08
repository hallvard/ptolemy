package org.ptolemy.xtext.examples.javafx.scene.control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
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
public class PTextField extends AbstractCaltropActor {
  protected final Variable id;
  
  protected TypedIOPort systemOutput;
  
  protected TypedIOPort userInput;
  
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
  
  protected TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "systemOutput", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected String _getSystemOutputTokenValue(final Token systemOutput) throws IllegalActionException {
    return StringToken.convert(systemOutput).stringValue(); 
  }
  
  protected TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "userInput", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected StringToken _createUserInputToken(final String userInput) throws IllegalActionException {
    return new StringToken(userInput);
    
  }
  
  public PTextField(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.systemOutput = _createSystemOutputPort();
    this.userInput = _createUserInputPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  public PTextField(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PTextField");
    
  }
  
  protected TextField textField;
  
  private TextField _initialTextFieldStateVariableValue() throws IllegalActionException {
    
    TextField _get = this.<TextField>get(_getIdValue(), TextField.class);return _get; 
  }
  
  protected String text;
  
  private String old_text;
  
  private String _initialTextStateVariableValue() throws IllegalActionException {
    
    String _text = this.textField.getText();return _text; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.textField = this.textField = _initialTextFieldStateVariableValue();
    _postChangeTextFieldState(this.textField);
    this.text = this.old_text = _initialTextStateVariableValue();
    _postChangeTextState(this.text);
    if (_actionImpls[0].match()) {
    	_actionImpls[0].body();
    	_actionImpls[0].output();
    }
    
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    _preChangeTextState(this.text);
    this.text = this.old_text = _initialTextStateVariableValue();
    _postChangeTextState(this.text);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    if (_actionImpls[2].match()) return new Pair.Impl(-1, _actionImpls[2]);
    if (_actionImpls[3].match()) return new Pair.Impl(-1, _actionImpls[3]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class textField1TextListener implements ChangeListener<String> {
    public void changed(final ObservableValue<? extends String> arg0, final String arg1, final String arg2) {
      postEvent(0, textField, "text", "changed", arg0,arg1,arg2);
      
    }
  }
  
  
  private ChangeListener<String> textField1TextListener = new textField1TextListener();
    ;
  
  @SuppressWarnings("all")
  public class textField2ActionListener implements EventHandler<ActionEvent> {
    public void handle(final ActionEvent arg0) {
      postEvent(0, textField, "action", "handle", arg0);
      
    }
  }
  
  
  private EventHandler<ActionEvent> textField2ActionListener = new textField2ActionListener();
    ;
  
  public void _preChangeTextFieldState_javafx(final TextField textField) throws IllegalActionException {
    if (textField != null) {
      textField.textProperty().removeListener(textField1TextListener);
      textField.setOnAction(null);
      
    }
    
  }
  
  public void _preChangeTextFieldState(final TextField textField) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeTextFieldState_javafx(textField);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeTextState_javafx(final String text) throws IllegalActionException {
    
  }
  
  public void _preChangeTextState(final String text) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeTextState_javafx(text);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeTextFieldState_javafx(final TextField textField) throws IllegalActionException {
    if (textField != null) {
      textField.textProperty().addListener(textField1TextListener);
      textField.setOnAction(textField2ActionListener);
      
    }
    
  }
  
  public void _postChangeTextFieldState(final TextField textField) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeTextFieldState_javafx(textField);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeTextState_javafx(final String text) throws IllegalActionException {
    
  }
  
  public void _postChangeTextState(final String text) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeTextState_javafx(text);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateTextState_javafx() throws IllegalActionException {
    
    this.textField.setText(this.text);
    
  }
  
  public void _updateTextState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updateTextState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  protected boolean _postfireImpl() throws IllegalActionException {
    if (! super._postfireImpl()) return false;
    if (this.old_text != this.text) {
      _updateTextState();
      _preChangeTextState(this.old_text);
      this.old_text = this.text;
      _postChangeTextState(this.old_text);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() throws IllegalActionException {
    super._wrapupImpl();
    _preChangeTextFieldState(this.textField);
    this.textField = null;
    _preChangeTextState(this.text);
    this.text = null;
    
  }
  
  @SuppressWarnings("all")
  public class InitActions0 extends AbstractActionImpl {
    public boolean match() throws IllegalActionException {
      return true; 
    }
    
    public void output() throws IllegalActionException {
      String _value = _outputPattern0Output0();
      send(PTextField.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private String _outputPattern0Output0() throws IllegalActionException {
      return PTextField.this.text; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private String string;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PTextField.this.systemOutput, 0, 1)) return false;
      string = _getSystemOutputTokenValue(PTextField.this.systemOutput.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      PTextField.this.text = this.string;
      
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
    private ObservableValue<? extends String> propertyEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(textField, "text", null);
      if (event == null) return false;
      if (event.length > 0) propertyEvent = (ObservableValue<? extends String>) event[0];
      return true; 
    }
    
    public void output() throws IllegalActionException {
      String _value = _outputPattern0Output0();
      send(PTextField.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private String _outputPattern0Output0() throws IllegalActionException {
      return PTextField.this.text; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions2 extends AbstractActionImpl {
    private ActionEvent actionEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(textField, "action", null);
      if (event == null) return false;
      if (event.length > 0) actionEvent = (ActionEvent) event[0];
      return true; 
    }
    
    public void output() throws IllegalActionException {
      String _value = _outputPattern0Output0();
      send(PTextField.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private String _outputPattern0Output0() throws IllegalActionException {
      return PTextField.this.text; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new InitActions0(), new Actions0(), new Actions1(), new Actions2(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
