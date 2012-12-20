package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.SingleRepeat1Integer1IntegerImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class SingleRepeat1Integer1Integer extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(input, "tokenConsumptionRate", new IntToken(3));
    return port;
    
  }
  
  public Integer getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(output, "tokenProductionRate", new IntToken(3));
    return port;
    
  }
  
  public IntToken createOutputToken(final Integer output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  public SingleRepeat1Integer1Integer(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = createInputPort();
    this.output = createOutputPort();
    this._impl = new SingleRepeat1Integer1IntegerImpl(this, input, output); 
  }
  
  private final SingleRepeat1Integer1IntegerImpl _impl;
  
  protected SingleRepeat1Integer1IntegerImpl _getImpl() {
    return _impl;
    
  }
}
