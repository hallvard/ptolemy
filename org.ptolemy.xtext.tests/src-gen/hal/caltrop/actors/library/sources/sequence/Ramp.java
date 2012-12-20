package hal.caltrop.actors.library.sources.sequence;

import hal.caltrop.actors.library.sources.sequence.RampImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public class Ramp extends AbstractCaltropActor {
  protected final Parameter init;
  
  protected final Parameter step;
  
  protected final Parameter end;
  
  protected TypedIOPort output;
  
  protected Parameter createInitAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "init");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return attribute;
    
  }
  
  protected IntToken createInitToken(final int init) throws IllegalActionException {
    return new IntToken(init);
    
  }
  
  protected int initialInitAttributeValue() throws IllegalActionException {
    
    
    return 0; 
  }
  
  public int getInitValue() throws IllegalActionException {
    return IntToken.convert(this.init.getToken()).intValue(); 
  }
  
  public void setInitValue(final int init) throws IllegalActionException {
    this.init.setToken(createInitToken(init));
    
  }
  
  protected Parameter createStepAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "step");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return attribute;
    
  }
  
  protected IntToken createStepToken(final int step) throws IllegalActionException {
    return new IntToken(step);
    
  }
  
  protected int initialStepAttributeValue() throws IllegalActionException {
    
    
    return 1; 
  }
  
  public int getStepValue() throws IllegalActionException {
    return IntToken.convert(this.step.getToken()).intValue(); 
  }
  
  public void setStepValue(final int step) throws IllegalActionException {
    this.step.setToken(createStepToken(step));
    
  }
  
  protected Parameter createEndAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "end");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return attribute;
    
  }
  
  protected IntToken createEndToken(final int end) throws IllegalActionException {
    return new IntToken(end);
    
  }
  
  protected int initialEndAttributeValue() throws IllegalActionException {
    
    
    return 10; 
  }
  
  public int getEndValue() throws IllegalActionException {
    return IntToken.convert(this.end.getToken()).intValue(); 
  }
  
  public void setEndValue(final int end) throws IllegalActionException {
    this.end.setToken(createEndToken(end));
    
  }
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  public IntToken createOutputToken(final int output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  public Ramp(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.init = createInitAttribute();
    this.step = createStepAttribute();
    this.end = createEndAttribute();
    this.output = createOutputPort();
    setInitValue(initialInitAttributeValue());
    setStepValue(initialStepAttributeValue());
    setEndValue(initialEndAttributeValue());
    this._impl = new RampImpl(this, init, step, end, output); 
  }
  
  private final RampImpl _impl;
  
  protected RampImpl _getImpl() {
    return _impl;
    
  }
}
