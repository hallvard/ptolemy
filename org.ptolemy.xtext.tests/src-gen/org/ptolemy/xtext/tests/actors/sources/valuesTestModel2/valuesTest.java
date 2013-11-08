package org.ptolemy.xtext.tests.actors.sources.valuesTestModel2;

import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.Pair;
import org.ptolemy.xtext.tests.junit.AbstractTest;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class valuesTest extends AbstractTest {
  protected TypedIOPort input;
  
  protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "input", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected int _getInputTokenValue(final Token input) throws IllegalActionException {
    return IntToken.convert(input).intValue(); 
  }
  
  public valuesTest(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.input = _createInputPort();
    
  }
  
  public valuesTest(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "valuesTest");
    
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
    private int i;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(valuesTest.this.input, 0, 1)) return false;
      i = _getInputTokenValue(valuesTest.this.input.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      String _plus = ("input should be " + Integer.valueOf(valuesTest.this.step));
      int _modulo = (valuesTest.this.step % 3);
      valuesTest.this.assertEquals(_plus, _modulo, this.i);
      
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
      
      String _plus = ("Step " + Integer.valueOf(valuesTest.this.step));
      String _plus_1 = (_plus + ": default action");
      valuesTest.this.fail(_plus_1);
      
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
