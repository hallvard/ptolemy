package hal.caltrop.actors.variants;

import hal.caltrop.actors.variants.Double2int1StringImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class Double2int1String extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(input, "tokenConsumptionRate", new IntToken(2));
    return port;
    
  }
  
  public int getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    new Parameter(output, "tokenProductionRate", new IntToken(2));
    return port;
    
  }
  
  public StringToken createOutputToken(final String output) throws IllegalActionException {
    return new StringToken(output);
    
  }
  
  public Double2int1String(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = createInputPort();
    this.output = createOutputPort();
    this._impl = new Double2int1StringImpl(this, input, output); 
  }
  
  private final Double2int1StringImpl _impl;
  
  protected Double2int1StringImpl _getImpl() {
    return _impl;
    
  }
}
