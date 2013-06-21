package org.ptolemy.xtext.browser.browser;

import java.net.URL;
import java.util.List;
import org.ptolemy.xtext.swing.PList;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class bookmarksList extends PList<URL> {
  protected TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "systemOutput", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(List.class));
    return port;
    
  }
  
  protected List<URL> _getSystemOutputTokenValue(final Token systemOutput) throws IllegalActionException {
    return ((List<URL>) ObjectToken.convert(systemOutput).getValue()); 
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
    
    
    return "browser.bookmarks.list"; 
  }
  
  public bookmarksList(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
