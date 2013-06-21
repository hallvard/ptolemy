package org.ptolemy.xtext.tests.actors.logic.logicFunctionAndTestModel1;

import com.google.common.collect.Lists;
import java.util.Collections;
import org.ptolemy.xtext.tests.actors.sources.sequence.Values;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.BooleanToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class values extends Values<Boolean> {
  protected Parameter _createValuesAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "values");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Iterable.class));
    return attribute;
    
  }
  
  protected ObjectToken _createValuesToken(final Iterable<Boolean> values) throws IllegalActionException {
    return new ObjectToken(values, Iterable.class);
    
  }
  
  protected Iterable<Boolean> _getValuesValue() throws IllegalActionException {
    return ((Iterable<Boolean>) ObjectToken.convert(this.values.getToken()).getValue()); 
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return port;
    
  }
  
  protected BooleanToken _createOutputToken(final Boolean output) throws IllegalActionException {
    return new BooleanToken(output);
    
  }
  
  protected Iterable<Boolean> _initialValuesAttributeValue() throws IllegalActionException {
    
    
    return Collections.<Boolean>unmodifiableList(Lists.<Boolean>newArrayList(Boolean.valueOf(false), Boolean.valueOf(true))); 
  }
  
  public values(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
