package org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel1;

import com.google.common.collect.Lists;
import java.util.Collections;
import org.ptolemy.xtext.tests.junit.TestValues;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class foldChannelsTest extends TestValues<String> {
  protected Parameter _createValuesAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "values");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Iterable.class));
    return attribute;
    
  }
  
  protected ObjectToken _createValuesToken(final Iterable<String> values) throws IllegalActionException {
    return new ObjectToken(values, Iterable.class);
    
  }
  
  protected Iterable<String> _getValuesValue() throws IllegalActionException {
    return ((Iterable<String>) ObjectToken.convert(this.values.getToken()).getValue()); 
  }
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected String _getInputTokenValue(final Token input) throws IllegalActionException {
    return StringToken.convert(input).stringValue(); 
  }
  
  protected Iterable<String> _initialValuesAttributeValue() throws IllegalActionException {
    
    
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("01", "02")); 
  }
  
  public foldChannelsTest(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public foldChannelsTest(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "foldChannelsTest");
    
  }
}
