package hal.caltrop.actors.library.misc;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public abstract class ApplyInput1<T, R> extends AbstractCaltropActor {
  protected final Parameter function;
  
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  protected abstract Parameter createFunctionAttribute() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token createFunctionToken(final Function1<? super T,? extends R> function) throws IllegalActionException;
  
  protected Function1<? super T,? extends R> initialFunctionAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  public abstract Function1<? super T,? extends R> getFunctionValue() throws IllegalActionException;
  
  public void setFunctionValue(final Function1<? super T,? extends R> function) throws IllegalActionException {
    this.function.setToken(createFunctionToken(function));
    
  }
  
  public abstract TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract T getInputTokenValue(final Token input) throws IllegalActionException;
  
  public abstract TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract Token createOutputToken(final R output) throws IllegalActionException;
  
  public ApplyInput1(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.function = createFunctionAttribute();
    this.input = createInputPort();
    this.output = createOutputPort();
    setFunctionValue(initialFunctionAttributeValue());
    
  }
}
