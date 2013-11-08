package org.ptolemy.xtext.examples.javafx.browser;

import java.net.URL;
import org.ptolemy.xtext.examples.javafx.scene.control.PBrowser;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class browserPane extends PBrowser {
  protected TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "systemOutput", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "userInput", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    
    
    return "browser_viewer"; 
  }
  
  public browserPane(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public browserPane(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "browserPane");
    
  }
}
