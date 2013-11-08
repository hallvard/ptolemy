package org.ptolemy.xtext.tests.actors.logic.logicFunctionOrTestModel2;

import com.google.common.collect.Lists;
import java.util.Collections;
import org.ptolemy.xtext.tests.junit.TestValues;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.BooleanToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class logicFunctionTest extends TestValues<Boolean> {
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
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.BOOLEAN);
    return port;
    
  }
  
  protected Boolean _getInputTokenValue(final Token input) throws IllegalActionException {
    return BooleanToken.convert(input).booleanValue(); 
  }
  
  protected Iterable<Boolean> _initialValuesAttributeValue() throws IllegalActionException {
    
    
    return Collections.<Boolean>unmodifiableList(Lists.<Boolean>newArrayList(Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true))); 
  }
  
  public logicFunctionTest(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public logicFunctionTest(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "logicFunctionTest");
    
  }
}
