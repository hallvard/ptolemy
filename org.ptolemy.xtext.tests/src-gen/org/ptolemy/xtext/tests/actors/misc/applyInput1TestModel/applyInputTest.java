package org.ptolemy.xtext.tests.actors.misc.applyInput1TestModel;

import com.google.common.collect.Lists;
import java.util.Collections;
import org.ptolemy.xtext.tests.junit.TestValues;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class applyInputTest extends TestValues<Integer> {
  protected Parameter _createValuesAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "values");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Iterable.class));
    return attribute;
    
  }
  
  protected ObjectToken _createValuesToken(final Iterable<Integer> values) throws IllegalActionException {
    return new ObjectToken(values, Iterable.class);
    
  }
  
  protected Iterable<Integer> _getValuesValue() throws IllegalActionException {
    return ((Iterable<Integer>) ObjectToken.convert(this.values.getToken()).getValue()); 
  }
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected Integer _getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  protected Iterable<Integer> _initialValuesAttributeValue() throws IllegalActionException {
    
    
    return Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(Integer.valueOf(2), Integer.valueOf(3))); 
  }
  
  public applyInputTest(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
