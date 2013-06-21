package org.ptolemy.xtext.tests.actors.misc.reduceChannelsTestModel1;

import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.ptolemy.xtext.tests.actors.misc.ReduceChannels;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class reduceChannels extends ReduceChannels<Integer> {
  protected Parameter _createFunAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "fun");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Function2.class));
    return attribute;
    
  }
  
  protected ObjectToken _createFunToken(final Function2<? super Integer,? super Integer,? extends Integer> fun) throws IllegalActionException {
    return new ObjectToken(fun, Function2.class);
    
  }
  
  protected Function2<? super Integer,? super Integer,? extends Integer> _getFunValue() throws IllegalActionException {
    return ((Function2<? super Integer,? super Integer,? extends Integer>) ObjectToken.convert(this.fun.getToken()).getValue()); 
  }
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(true);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected Integer _getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected IntToken _createOutputToken(final Integer output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  protected Function2<? super Integer,? super Integer,? extends Integer> _initialFunAttributeValue() throws IllegalActionException {
    
    final Function2<Integer,Integer,Integer> _function = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer n1, final Integer n2) {
          int _plus = (n1 + n2);
          return Integer.valueOf(_plus);
        }
      };
    
    return _function; 
  }
  
  public reduceChannels(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
