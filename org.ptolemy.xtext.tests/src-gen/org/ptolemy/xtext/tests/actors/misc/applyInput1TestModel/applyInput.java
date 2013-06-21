package org.ptolemy.xtext.tests.actors.misc.applyInput1TestModel;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.ptolemy.xtext.tests.actors.misc.ApplyInput1;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class applyInput extends ApplyInput1<Integer,Integer> {
  protected Parameter _createFunAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "fun");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Function1.class));
    return attribute;
    
  }
  
  protected ObjectToken _createFunToken(final Function1<? super Integer,? extends Integer> fun) throws IllegalActionException {
    return new ObjectToken(fun, Function1.class);
    
  }
  
  protected Function1<? super Integer,? extends Integer> _getFunValue() throws IllegalActionException {
    return ((Function1<? super Integer,? extends Integer>) ObjectToken.convert(this.fun.getToken()).getValue()); 
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
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected IntToken _createOutputToken(final Integer output) throws IllegalActionException {
    return new IntToken(output);
    
  }
  
  protected Function1<? super Integer,? extends Integer> _initialFunAttributeValue() throws IllegalActionException {
    
    final Function1<Integer,Integer> _function = new Function1<Integer,Integer>() {
        public Integer apply(final Integer n) {
          int _plus = (n + 1);
          return Integer.valueOf(_plus);
        }
      };
    
    return _function; 
  }
  
  public applyInput(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
