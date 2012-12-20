package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.DoubleRepeatMulti1Date1DateImpl;
import java.util.Date;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class DoubleRepeatMulti1Date1Date extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  public Date getInputTokenValue(final Token input) throws IllegalActionException {
    return ((Date) ObjectToken.convert(input).getValue()); 
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  public ObjectToken createOutputToken(final Date output) throws IllegalActionException {
    return new ObjectToken(output);
    
  }
  
  public DoubleRepeatMulti1Date1Date(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = createInputPort();
    this.output = createOutputPort();
    this._impl = new DoubleRepeatMulti1Date1DateImpl(this, input, output); 
  }
  
  private final DoubleRepeatMulti1Date1DateImpl _impl;
  
  protected DoubleRepeatMulti1Date1DateImpl _getImpl() {
    return _impl;
    
  }
}
