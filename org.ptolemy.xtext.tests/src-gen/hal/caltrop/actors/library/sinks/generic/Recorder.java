package hal.caltrop.actors.library.sinks.generic;

import hal.caltrop.actors.library.sinks.generic.RecorderImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class Recorder extends AbstractCaltropActor {
  protected final Parameter capacity;
  
  protected TypedIOPort input;
  
  protected Parameter createCapacityAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "capacity");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return attribute;
    
  }
  
  protected IntToken createCapacityToken(final int capacity) throws IllegalActionException {
    return new IntToken(capacity);
    
  }
  
  protected int initialCapacityAttributeValue() throws IllegalActionException {
    
    int _minus = (-1);
    
    return _minus; 
  }
  
  public int getCapacityValue() throws IllegalActionException {
    return IntToken.convert(this.capacity.getToken()).intValue(); 
  }
  
  public void setCapacityValue(final int capacity) throws IllegalActionException {
    this.capacity.setToken(createCapacityToken(capacity));
    
  }
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  public Object getInputTokenValue(final Token input) throws IllegalActionException {
    return ObjectToken.convert(input).getValue(); 
  }
  
  public Recorder(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.capacity = createCapacityAttribute();
    this.input = createInputPort();
    setCapacityValue(initialCapacityAttributeValue());
    this._impl = new RecorderImpl(this, capacity, input); 
  }
  
  private final RecorderImpl _impl;
  
  protected RecorderImpl _getImpl() {
    return _impl;
    
  }
}
