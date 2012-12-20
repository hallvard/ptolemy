package hal.caltrop.actors.library.sources.sequence;

import hal.caltrop.actors.library.sources.sequence.ValuesImpl;
import java.util.Arrays;
import java.util.List;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.BooleanToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class Values extends AbstractCaltropActor {
  protected final Parameter values;
  
  protected final Parameter rep;
  
  protected TypedIOPort output;
  
  protected Parameter createValuesAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "values");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return attribute;
    
  }
  
  protected ObjectToken createValuesToken(final Iterable<? extends Object> values) throws IllegalActionException {
    return new ObjectToken(values);
    
  }
  
  protected Iterable<? extends Object> initialValuesAttributeValue() throws IllegalActionException {
    
    List<Integer> _asList = Arrays.<Integer>asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    
    return _asList; 
  }
  
  public Iterable<? extends Object> getValuesValue() throws IllegalActionException {
    return ((Iterable<?>) ObjectToken.convert(this.values.getToken()).getValue()); 
  }
  
  public void setValuesValue(final Iterable<? extends Object> values) throws IllegalActionException {
    this.values.setToken(createValuesToken(values));
    
  }
  
  protected Parameter createRepAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "rep");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return attribute;
    
  }
  
  protected BooleanToken createRepToken(final boolean rep) throws IllegalActionException {
    return new BooleanToken(rep);
    
  }
  
  protected boolean initialRepAttributeValue() throws IllegalActionException {
    
    
    return false; 
  }
  
  public boolean getRepValue() throws IllegalActionException {
    return BooleanToken.convert(this.rep.getToken()).booleanValue(); 
  }
  
  public void setRepValue(final boolean rep) throws IllegalActionException {
    this.rep.setToken(createRepToken(rep));
    
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  public ObjectToken createOutputToken(final Object output) throws IllegalActionException {
    return new ObjectToken(output);
    
  }
  
  public Values(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.values = createValuesAttribute();
    this.rep = createRepAttribute();
    this.output = createOutputPort();
    setValuesValue(initialValuesAttributeValue());
    setRepValue(initialRepAttributeValue());
    this._impl = new ValuesImpl(this, values, rep, output); 
  }
  
  private final ValuesImpl _impl;
  
  protected ValuesImpl _getImpl() {
    return _impl;
    
  }
}
