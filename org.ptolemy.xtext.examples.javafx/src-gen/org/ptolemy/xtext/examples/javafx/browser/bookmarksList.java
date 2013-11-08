package org.ptolemy.xtext.examples.javafx.browser;

import java.net.URL;
import java.util.Collection;
import org.ptolemy.xtext.examples.javafx.scene.control.PCollection;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class bookmarksList extends PCollection<URL> {
  protected TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "systemOutput", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(Collection.class));
    return port;
    
  }
  
  protected Collection<URL> _getSystemOutputTokenValue(final Token systemOutput) throws IllegalActionException {
    return ((Collection<URL>) ObjectToken.convert(systemOutput).getValue()); 
  }
  
  protected TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "userInput", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected ObjectToken _createUserInputToken(final URL userInput) throws IllegalActionException {
    return new ObjectToken(userInput, URL.class);
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    
    
    return "browser_bookmarks_list"; 
  }
  
  public bookmarksList(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public bookmarksList(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "bookmarksList");
    
  }
}
