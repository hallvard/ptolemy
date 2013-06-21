package hal.caltrop.actors.variants;

import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.Pair;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class double2int1int extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(port, "tokenConsumptionRate", new IntToken(2));
    return port;
    
  }
  
  protected int _getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    new Parameter(port, "tokenProductionRate", new IntToken(2));
    return port;
    
  }
  
  protected IntToken _createOutputToken(final int output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  public double2int1int(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = _createInputPort();
    this.output = _createOutputPort();
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private int i1;
    
    private int i2;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(double2int1int.this.input, 0, 1 * 2)) return false;
      Token[] _inputArray = double2int1int.this.input.get(0, 1 * 2);
      i1 = _getInputTokenValue(_inputArray[0]);
      i2 = _getInputTokenValue(_inputArray[1]);
      return true; 
    }
    
    public void output() throws IllegalActionException {
      int _value = _outputPattern0Output0();
      int _value_1 = _outputPattern0Output1();
      send(double2int1int.this.output, 0, new IntToken[]{
        _createOutputToken(_value), _createOutputToken(_value_1)
      }
      , -1);
      
    }
    
    private int _outputPattern0Output0() throws IllegalActionException {
      return this.i1; 
    }
    
    private int _outputPattern0Output1() throws IllegalActionException {
      return this.i2; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(double2int1int.this.input, double2int1int.this.output), BooleanDependency.valueOf(true)), 
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
