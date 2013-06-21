package org.ptolemy.xtext.browser.browser;

import java.net.URL;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.ptolemy.xtext.util.Variable;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class location extends Variable<URL> {
  protected Parameter _createInitialValueAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "initialValue");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return attribute;
    
  }
  
  protected ObjectToken _createInitialValueToken(final URL initialValue) throws IllegalActionException {
    return new ObjectToken(initialValue, URL.class);
    
  }
  
  protected URL _getInitialValueValue() throws IllegalActionException {
    return ((URL) ObjectToken.convert(this.initialValue.getToken()).getValue()); 
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
  
  protected TypedIOPort _createSetValuePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "setValue", true, false);
    port.setMultiport(true);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getSetValueTokenValue(final Token setValue) throws IllegalActionException {
    return ((URL) ObjectToken.convert(setValue).getValue()); 
  }
  
  protected TypedIOPort _createValuePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "value", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected ObjectToken _createValueToken(final URL value) throws IllegalActionException {
    return new ObjectToken(value, URL.class);
    
  }
  
  protected boolean _initialAllowNullAttributeValue() throws IllegalActionException {
    
    
    return false; 
  }
  
  public location(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    
  }
}
