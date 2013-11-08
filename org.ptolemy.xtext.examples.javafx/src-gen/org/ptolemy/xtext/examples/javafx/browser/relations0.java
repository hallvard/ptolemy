package org.ptolemy.xtext.examples.javafx.browser;

import com.google.common.base.Objects;
import java.net.URL;
import org.ptolemy.xtext.lib.caltrop.AbstractConversionRelationActor;
import org.ptolemy.xtext.lib.caltrop.AbstractConversionRelationActor.ConversionAction;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class relations0 extends AbstractConversionRelationActor<URL,String> {
  public relations0(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = super._createInputPort();
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = super._createOutputPort();
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected URL _getInputTokenValue(final Token value) throws IllegalActionException {
    return ((URL) ObjectToken.convert(value).getValue()); 
  }
  
  protected StringToken _createOutputToken(final String systemOutput) throws IllegalActionException {
    return new StringToken(systemOutput);
    
  }
  
  @SuppressWarnings("all")
  public class Browserrelations0Action extends ConversionAction {
    public boolean _guard(final URL it) {
      boolean _notEquals = (!Objects.equal(it, null));
      return _notEquals;
    }
    
    public String _convert(final URL it) {
      String _string = it.toString();
      return _string;
    }
  }
  
  
  public ConversionAction _createConversionAction() {
    return new Browserrelations0Action();
    
  }
}
