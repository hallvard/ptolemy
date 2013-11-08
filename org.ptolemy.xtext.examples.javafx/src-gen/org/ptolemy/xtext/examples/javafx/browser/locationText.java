package org.ptolemy.xtext.examples.javafx.browser;

import org.ptolemy.xtext.examples.javafx.scene.control.PTextField;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class locationText extends PTextField {
  protected TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "systemOutput", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "userInput", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    
    
    return "browser_location_text"; 
  }
  
  public locationText(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public locationText(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "locationText");
    
  }
}
