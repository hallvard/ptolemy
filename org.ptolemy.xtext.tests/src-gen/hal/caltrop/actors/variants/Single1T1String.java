package hal.caltrop.actors.variants;

import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public abstract class Single1T1String<T> extends AbstractCaltropActor {
  protected TypedIOPort input;
  
  protected TypedIOPort output;
  
  public abstract TypedIOPort createInputPort() throws NameDuplicationException, IllegalActionException;
  
  public abstract T getInputTokenValue(final Token input) throws IllegalActionException;
  
  public TypedIOPort createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  public StringToken createOutputToken(final String output) throws IllegalActionException {
    return new StringToken(output);
    
  }
  
  public Single1T1String(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = createInputPort();
    this.output = createOutputPort();
    
  }
}
