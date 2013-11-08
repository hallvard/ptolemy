package org.ptolemy.xtext.examples.javafx.browser;

import java.net.URL;
import org.ptolemy.xtext.examples.javafx.scene.control.PButtonValve;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class removeBookmarksButtonValve extends PButtonValve<URL> {
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getInputTokenValue(final Token input) throws IllegalActionException {
    return ((URL) ObjectToken.convert(input).getValue()); 
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected ObjectToken _createOutputToken(final URL output) throws IllegalActionException {
    return new ObjectToken(output, URL.class);
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    
    
    return "browser_bookmarks_removeButton"; 
  }
  
  public removeBookmarksButtonValve(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public removeBookmarksButtonValve(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "removeBookmarksButtonValve");
    
  }
}
