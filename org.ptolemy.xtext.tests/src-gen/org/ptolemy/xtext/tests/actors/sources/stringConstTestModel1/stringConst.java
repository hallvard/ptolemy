package org.ptolemy.xtext.tests.actors.sources.stringConstTestModel1;

import org.ptolemy.xtext.tests.actors.sources.generic.StringConst;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class stringConst extends StringConst {
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected String _initialValueAttributeValue() throws IllegalActionException {
    
    
    return "fireLimit=1"; 
  }
  
  protected int _initialFireLimitAttributeValue() throws IllegalActionException {
    
    
    return 1; 
  }
  
  public stringConst(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public stringConst(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "stringConst");
    
  }
}
