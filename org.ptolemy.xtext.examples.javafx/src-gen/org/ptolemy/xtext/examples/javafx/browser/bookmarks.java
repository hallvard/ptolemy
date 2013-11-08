package org.ptolemy.xtext.examples.javafx.browser;

import java.net.URL;
import java.util.Collection;
import org.ptolemy.xtext.examples.ui.CollectionVariable;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class bookmarks extends CollectionVariable<URL> {
  protected TypedIOPort _createAddPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "add", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getAddTokenValue(final Token add) throws IllegalActionException {
    return ((URL) ObjectToken.convert(add).getValue()); 
  }
  
  protected TypedIOPort _createRemovePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "remove", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getRemoveTokenValue(final Token remove) throws IllegalActionException {
    return ((URL) ObjectToken.convert(remove).getValue()); 
  }
  
  protected TypedIOPort _createValuePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "value", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(Collection.class));
    return port;
    
  }
  
  protected ObjectToken _createValueToken(final Collection<URL> value) throws IllegalActionException {
    return new ObjectToken(value, Collection.class);
    
  }
  
  public bookmarks(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public bookmarks(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "bookmarks");
    
  }
}
