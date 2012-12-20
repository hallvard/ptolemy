package hal.caltrop.actors.library.sources.timed;

import hal.caltrop.actors.library.sources.timed.CurrentTimeImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.BooleanToken;
import ptolemy.data.DoubleToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class CurrentTime extends AbstractCaltropActor {
  protected final Parameter useLocalTime;
  
  protected TypedIOPort output;
  
  protected Parameter createUseLocalTimeAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "useLocalTime");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return attribute;
    
  }
  
  protected BooleanToken createUseLocalTimeToken(final boolean useLocalTime) throws IllegalActionException {
    return new BooleanToken(useLocalTime);
    
  }
  
  protected boolean initialUseLocalTimeAttributeValue() throws IllegalActionException {
    
    
    return false; 
  }
  
  public boolean getUseLocalTimeValue() throws IllegalActionException {
    return BooleanToken.convert(this.useLocalTime.getToken()).booleanValue(); 
  }
  
  public void setUseLocalTimeValue(final boolean useLocalTime) throws IllegalActionException {
    this.useLocalTime.setToken(createUseLocalTimeToken(useLocalTime));
    
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.DOUBLE);
    return port;
    
  }
  
  public DoubleToken createOutputToken(final double output) throws IllegalActionException {
    return new DoubleToken(output);
    
  }
  
  public CurrentTime(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.useLocalTime = createUseLocalTimeAttribute();
    this.output = createOutputPort();
    setUseLocalTimeValue(initialUseLocalTimeAttributeValue());
    this._impl = new CurrentTimeImpl(this, useLocalTime, output); 
  }
  
  private final CurrentTimeImpl _impl;
  
  protected CurrentTimeImpl _getImpl() {
    return _impl;
    
  }
}
