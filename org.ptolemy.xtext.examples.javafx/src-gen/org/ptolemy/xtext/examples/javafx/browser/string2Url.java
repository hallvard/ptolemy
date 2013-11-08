package org.ptolemy.xtext.examples.javafx.browser;

import java.net.URL;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.ptolemy.xtext.examples.javafx.scene.control.PButtonEagerConverter;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class string2Url extends PButtonEagerConverter<String,URL> {
  protected Parameter _createFunAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "fun");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Function1.class));
    return attribute;
    
  }
  
  protected ObjectToken _createFunToken(final Function1<? super String,? extends URL> fun) throws IllegalActionException {
    return new ObjectToken(fun, Function1.class);
    
  }
  
  protected Function1<? super String,? extends URL> _getFunValue() throws IllegalActionException {
    return ((Function1<? super String,? extends URL>) ObjectToken.convert(this.fun.getToken()).getValue()); 
  }
  
  protected Parameter _createValidatorAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "validator");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Function1.class));
    return attribute;
    
  }
  
  protected ObjectToken _createValidatorToken(final Function1<? super URL,? extends Boolean> validator) throws IllegalActionException {
    return new ObjectToken(validator, Function1.class);
    
  }
  
  protected Function1<? super URL,? extends Boolean> _getValidatorValue() throws IllegalActionException {
    return ((Function1<? super URL,? extends Boolean>) ObjectToken.convert(this.validator.getToken()).getValue()); 
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
  
  protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "output", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected ObjectToken _createOutputToken(final URL output) throws IllegalActionException {
    return new ObjectToken(output, URL.class);
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    
    
    return "browser_location_goButton"; 
  }
  
  protected Function1<? super String,? extends URL> _initialFunAttributeValue() throws IllegalActionException {
    
    final Function1<String,URL> _function = new Function1<String,URL>() {
      public URL apply(final String s) {
        URL _xtrycatchfinallyexpression = null;
        try {
          URL _uRL = new URL(s);
          _xtrycatchfinallyexpression = _uRL;
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            RuntimeException _runtimeException = new RuntimeException(e);
            throw _runtimeException;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        return _xtrycatchfinallyexpression;
      }
    };
    
    return _function; 
  }
  
  public string2Url(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
  
  public string2Url(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "string2Url");
    
  }
}
