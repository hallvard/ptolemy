package hal.caltrop.actors.library.sources.generic;

import hal.caltrop.actors.library.sources.generic.StringConstImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.StringToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class StringConst extends AbstractCaltropActor {
  protected final Parameter value;
  
  protected final Parameter fireLimit;
  
  protected TypedIOPort output;
  
  protected Parameter createValueAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "value");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return attribute;
    
  }
  
  protected StringToken createValueToken(final String value) throws IllegalActionException {
    return new StringToken(value);
    
  }
  
  protected String initialValueAttributeValue() throws IllegalActionException {
    
    
    return "value"; 
  }
  
  public String getValueValue() throws IllegalActionException {
    return StringToken.convert(this.value.getToken()).stringValue(); 
  }
  
  public void setValueValue(final String value) throws IllegalActionException {
    this.value.setToken(createValueToken(value));
    
  }
  
  protected Parameter createFireLimitAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "fireLimit");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return attribute;
    
  }
  
  protected IntToken createFireLimitToken(final int fireLimit) throws IllegalActionException {
    return new IntToken(fireLimit);
    
  }
  
  protected int initialFireLimitAttributeValue() throws IllegalActionException {
    
    int _minus = (-1);
    
    return _minus; 
  }
  
  public int getFireLimitValue() throws IllegalActionException {
    return IntToken.convert(this.fireLimit.getToken()).intValue(); 
  }
  
  public void setFireLimitValue(final int fireLimit) throws IllegalActionException {
    this.fireLimit.setToken(createFireLimitToken(fireLimit));
    
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  public StringToken createOutputToken(final String output) throws IllegalActionException {
    return new StringToken(output);
    
  }
  
  public StringConst(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.value = createValueAttribute();
    this.fireLimit = createFireLimitAttribute();
    this.output = createOutputPort();
    setValueValue(initialValueAttributeValue());
    setFireLimitValue(initialFireLimitAttributeValue());
    this._impl = new StringConstImpl(this, value, fireLimit, output); 
  }
  
  private final StringConstImpl _impl;
  
  protected StringConstImpl _getImpl() {
    return _impl;
    
  }
}
