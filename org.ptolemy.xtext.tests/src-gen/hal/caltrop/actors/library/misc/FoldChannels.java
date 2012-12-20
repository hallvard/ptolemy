package hal.caltrop.actors.library.misc;

import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public abstract class FoldChannels<S, T> extends AbstractCaltropActor {
  protected final Parameter function;
  
  protected final Parameter init;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  protected abstract Parameter createFunctionAttribute() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token createFunctionToken(final Function2<? super S,? super T,? extends S> function) throws IllegalActionException;
  
  protected Function2<? super S,? super T,? extends S> initialFunctionAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  public abstract Function2<? super S,? super T,? extends S> getFunctionValue() throws IllegalActionException;
  
  public void setFunctionValue(final Function2<? super S,? super T,? extends S> function) throws IllegalActionException {
    this.function.setToken(createFunctionToken(function));
    
  }
  
  protected abstract Parameter createInitAttribute() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token createInitToken(final S init) throws IllegalActionException;
  
  protected S initialInitAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  public abstract S getInitValue() throws IllegalActionException;
  
  public void setInitValue(final S init) throws IllegalActionException {
    this.init.setToken(createInitToken(init));
    
  }
  
  public abstract TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract T getInputTokenValue(final Token input) throws IllegalActionException;
  
  public abstract TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract Token createOutputToken(final S output) throws IllegalActionException;
  
  public FoldChannels(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.function = createFunctionAttribute();
    this.init = createInitAttribute();
    this.input = createInputPort();
    this.output = createOutputPort();
    setFunctionValue(initialFunctionAttributeValue());
    setInitValue(initialInitAttributeValue());
    
  }
}
