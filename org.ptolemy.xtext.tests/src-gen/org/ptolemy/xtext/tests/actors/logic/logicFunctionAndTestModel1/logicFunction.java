package org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel1;

import org.ptolemy.xtext.tests.actors.logic.LogicFunction;
import ptolemy.actor.TypedIOPort;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class logicFunction extends LogicFunction {
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return port;
    
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return port;
    
  }
  
  public logicFunction(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public logicFunction(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "logicFunction");
    
  }
}
