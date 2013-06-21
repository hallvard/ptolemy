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
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class double2int1String extends AbstractCaltropActor {
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
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    new Parameter(port, "tokenProductionRate", new IntToken(2));
    return port;
    
  }
  
  protected StringToken _createOutputToken(final String output) throws IllegalActionException {
    return new StringToken(output);
    
  }
  
  public double2int1String(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = _createInputPort();
    this.output = _createOutputPort();
    
  }
  
  protected int step;
  
  private int old_step;
  
  private int _initialStepStateVariableValue() throws IllegalActionException {
    return 0; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.old_step = _initialStepStateVariableValue();
    _postChangeStepState(this.old_step);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    this.step = this.old_step;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    return null;
    
  }
  
  public void _preChangeStepState(final int step) {
    
  }
  
  public void _postChangeStepState(final int step) {
    
  }
  
  protected boolean _postfireImpl() {
    if (! super._postfireImpl()) return false;
    if (this.old_step != this.step) {
      _preChangeStepState(this.old_step);
      this.old_step = this.step;
      _postChangeStepState(this.old_step);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() {
    super._wrapupImpl();
    _preChangeStepState(this.step);
    this.step = 0;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private int i1;
    
    private int i2;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(double2int1String.this.input, 0, 1 * 2)) return false;
      Token[] _inputArray = double2int1String.this.input.get(0, 1 * 2);
      i1 = _getInputTokenValue(_inputArray[0]);
      i2 = _getInputTokenValue(_inputArray[1]);
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      int _plus = (double2int1String.this.step + 1);
      double2int1String.this.step = _plus;
      
    }
    
    public void output() throws IllegalActionException {
      String _value = _outputPattern0Output0();
      String _value_1 = _outputPattern0Output1();
      send(double2int1String.this.output, 0, new StringToken[]{
        _createOutputToken(_value), _createOutputToken(_value_1)
      }
      , -1);
      
    }
    
    private String _outputPattern0Output0() throws IllegalActionException {
      
      String _plus = (Integer.valueOf(double2int1String.this.step) + ": i1=");
      String _plus_1 = (_plus + Integer.valueOf(this.i1));return _plus_1; 
    }
    
    private String _outputPattern0Output1() throws IllegalActionException {
      
      String _plus = (Integer.valueOf(double2int1String.this.step) + ": i2=");
      String _plus_1 = (_plus + Integer.valueOf(this.i2));return _plus_1; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(double2int1String.this.input, double2int1String.this.output), BooleanDependency.valueOf(true)), 
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
