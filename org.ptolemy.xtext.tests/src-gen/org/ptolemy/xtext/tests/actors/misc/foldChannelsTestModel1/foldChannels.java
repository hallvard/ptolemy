package org.ptolemy.xtext.tests.actors.misc.foldChannelsTestModel1;

import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.ptolemy.xtext.tests.actors.misc.FoldChannels;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.IntToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class foldChannels extends FoldChannels<String,Integer> {
  protected Parameter _createFunAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "fun");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Function2.class));
    return attribute;
    
  }
  
  protected ObjectToken _createFunToken(final Function2<? super String,? super Integer,? extends String> fun) throws IllegalActionException {
    return new ObjectToken(fun, Function2.class);
    
  }
  
  protected Function2<? super String,? super Integer,? extends String> _getFunValue() throws IllegalActionException {
    return ((Function2<? super String,? super Integer,? extends String>) ObjectToken.convert(this.fun.getToken()).getValue()); 
  }
  
  protected Parameter _createInitAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "init");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return attribute;
    
  }
  
  protected StringToken _createInitToken(final String init) throws IllegalActionException {
    return new StringToken(init);
    
  }
  
  protected String _getInitValue() throws IllegalActionException {
    return StringToken.convert(this.init.getToken()).stringValue(); 
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
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected StringToken _createOutputToken(final String output) throws IllegalActionException {
    return new StringToken(output);
    
  }
  
  protected Function2<? super String,? super Integer,? extends String> _initialFunAttributeValue() throws IllegalActionException {
    
    final Function2<String,Integer,String> _function = new Function2<String,Integer,String>() {
        public String apply(final String s, final Integer n2) {
          String _plus = (s + Integer.valueOf(n2));
          return _plus;
        }
      };
    
    return _function; 
  }
  
  protected String _initialInitAttributeValue() throws IllegalActionException {
    
    
    return "0"; 
  }
  
  public foldChannels(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
