package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.SingleRepeat1int1intImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class SingleRepeat1int1int extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(input, "tokenConsumptionRate", new IntToken(3));
    return port;
    
  }
  
  public int getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(output, "tokenProductionRate", new IntToken(3));
    return port;
    
  }
  
  public IntToken createOutputToken(final int output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  public SingleRepeat1int1int(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = createInputPort();
    this.output = createOutputPort();
    this._impl = new SingleRepeat1int1intImpl(this, input, output); 
  }
  
  private final SingleRepeat1int1intImpl _impl;
  
  protected SingleRepeat1int1intImpl _getImpl() {
    return _impl;
    
  }
}
