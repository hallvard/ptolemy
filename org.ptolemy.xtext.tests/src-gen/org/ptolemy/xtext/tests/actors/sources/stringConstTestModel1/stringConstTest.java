package org.ptolemy.xtext.tests.actors.sources.stringConstTestModel1;

import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.Pair;
import org.ptolemy.xtext.tests.junit.AbstractTest;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class stringConstTest extends AbstractTest {
  protected TypedIOPort input;
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return port;
    
  }
  
  protected String _getInputTokenValue(final Token input) throws IllegalActionException {
    return StringToken.convert(input).stringValue(); 
  }
  
  public stringConstTest(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = _createInputPort();
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private String s;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(stringConstTest.this.input, 0, 1)) return false;
      s = _getInputTokenValue(stringConstTest.this.input.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      boolean _lessThan = (stringConstTest.this.step < 1);
      stringConstTest.this.assertTrue("Step should be < 1", _lessThan);
      stringConstTest.this.assertEquals("fireLimit=1", "fireLimit=1", this.s);
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    public boolean match() throws IllegalActionException {
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      stringConstTest.this.fail("Stop when step >= 1");
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), new Actions1(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
