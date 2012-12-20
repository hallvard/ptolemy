package hal.caltrop.actors.library.logic;

import hal.caltrop.actors.library.logic.LogicFunctionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.BooleanToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class LogicFunction extends AbstractCaltropActor {
  protected final Parameter function;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  protected Parameter createFunctionAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "function");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return attribute;
    
  }
  
  protected StringToken createFunctionToken(final String function) throws IllegalActionException {
    return new StringToken(function);
    
  }
  
  protected String initialFunctionAttributeValue() throws IllegalActionException {
    
    
    return "and"; 
  }
  
  public String getFunctionValue() throws IllegalActionException {
    return StringToken.convert(this.function.getToken()).stringValue(); 
  }
  
  public void setFunctionValue(final String function) throws IllegalActionException {
    this.function.setToken(createFunctionToken(function));
    
  }
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return port;
    
  }
  
  public boolean getInputTokenValue(final Token input) throws IllegalActionException {
    return BooleanToken.convert(input).booleanValue(); 
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return port;
    
  }
  
  public BooleanToken createOutputToken(final boolean output) throws IllegalActionException {
    return new BooleanToken(output);
    
  }
  
  public LogicFunction(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.function = createFunctionAttribute();
    this.input = createInputPort();
    this.output = createOutputPort();
    setFunctionValue(initialFunctionAttributeValue());
    this._impl = new LogicFunctionImpl(this, function, input, output); 
  }
  
  private final LogicFunctionImpl _impl;
  
  protected LogicFunctionImpl _getImpl() {
    return _impl;
    
  }
}
