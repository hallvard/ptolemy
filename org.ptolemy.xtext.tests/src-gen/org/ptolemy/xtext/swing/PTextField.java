package org.ptolemy.xtext.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;
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
  
  protected JTextField textField;
  
  private JTextField _initialTextFieldStateVariableValue() throws IllegalActionException {
    
    JTextField _get = this.<JTextField>get(_getIdValue(), JTextField.class);return _get; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.textField = _initialTextFieldStateVariableValue();
    _postChangeTextFieldState(this.textField);
    if (_actionImpls[0].match()) {
    	_actionImpls[0].body();
    	_actionImpls[0].output();
    }
    
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    if (_actionImpls[2].match()) return new Pair.Impl(-1, _actionImpls[2]);
    if (_actionImpls[3].match()) return new Pair.Impl(-1, _actionImpls[3]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class textField1TextListener implements PropertyChangeListener {
    public void propertyChange(final PropertyChangeEvent arg0) {
      postEvent(0, textField, "text", "propertyChange", arg0);
      
    }
  }
  
  
  private PropertyChangeListener textField1TextListener = new textField1TextListener();
    ;
  
  @SuppressWarnings("all")
  public class textField2ActionListener implements ActionListener {
    public void actionPerformed(final ActionEvent arg0) {
      postEvent(0, textField, "action", "actionPerformed", arg0);
      
    }
  }
  
  
  private ActionListener textField2ActionListener = new textField2ActionListener();
    ;
  
  public void _preChangeTextFieldState(final JTextField textField) {
    if (textField != null) {
      textField.removePropertyChangeListener("text", textField1TextListener);
      textField.removeActionListener(textField2ActionListener);
      
    }
    
  }
  
  public void _postChangeTextFieldState(final JTextField textField) {
    if (textField != null) {
      textField.addPropertyChangeListener("text", textField1TextListener);
      textField.addActionListener(textField2ActionListener);
      
    }
    
  }
  
  protected boolean _postfireImpl() {
    if (! super._postfireImpl()) return false;
    return true; 
  }
  
  protected void _wrapupImpl() {
    super._wrapupImpl();
    _preChangeTextFieldState(this.textField);
    this.textField = null;
    
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
      
      String _text = PTextField.this.textField.getText();return _text; 
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
    
    public void output() throws IllegalActionException {
      
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
        PTextField.this.textField.setText(this.string);
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
    private PropertyChangeEvent propertyEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(textField, "text", null);
      if (event == null) return false;
      if (event.length > 0) propertyEvent = (PropertyChangeEvent) event[0];
      return true; 
    }
    
    public void output() throws IllegalActionException {
      String _value = _outputPattern0Output0();
      send(PTextField.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private String _outputPattern0Output0() throws IllegalActionException {
      
      String _text = PTextField.this.textField.getText();return _text; 
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
      
      String _text = PTextField.this.textField.getText();return _text; 
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
