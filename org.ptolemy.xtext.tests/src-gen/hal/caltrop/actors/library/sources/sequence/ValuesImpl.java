package hal.caltrop.actors.library.sources.sequence;

import hal.caltrop.actors.library.sources.sequence.Values;
import java.util.Iterator;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.TypedIOPort;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public class ValuesImpl extends AbstractActorImpl {
  protected final Parameter values;
  
  protected final Parameter rep;
  
  protected TypedIOPort output;
  
  public ValuesImpl(final Values _actor, final Parameter values, final Parameter rep, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.values = values;
    this.rep = rep;
    this.output = output;
    
  }
  
  private final Values _actor;
  
  public Values getActor() {
    return _actor;
    
  }
  
  private Iterator<? extends Object> iter;
  
  private Iterator<? extends Object> old_iter;
  
  public void initialize() throws IllegalActionException {
    super.initialize(); 
    Iterator<? extends Object> _iterator = getActor().getValuesValue().iterator();
    this.old_iter = _iterator;
    
  }
  
  public boolean prefire() throws IllegalActionException {
    this.iter = old_iter;
    if (super.prefire()) return true;
    if (action1Match()) return true;
    
    return false; 
  }
  
  public boolean fire() throws IllegalActionException {
    super.fire();
    return _callDoMethod() && _callOutputMethod(); 
  }
  
  public boolean postfire() throws IllegalActionException {
    if (! super.postfire()) return false;
    this.old_iter = iter;
    return true; 
  }
  
  public boolean action1Match() throws IllegalActionException {
    
    boolean _or = false;
    boolean _hasNext = this.iter.hasNext();
    if (_hasNext) {
      _or = true;
    } else {
      _or = (_hasNext || getActor().getRepValue());
    }
    if (! _or) return false;
    _setDoMethod("action1Do");
    return true; 
  }
  
  public void action1Do() throws IllegalActionException {
    
    final Object value = this.iter.next();
    boolean _and = false;
    if (!getActor().getRepValue()) {
      _and = false;
    } else {
      boolean _hasNext = this.iter.hasNext();
      boolean _not = (!_hasNext);
      _and = (getActor().getRepValue() && _not);
    }
    if (_and) {
      Iterator<? extends Object> _iterator = getActor().getValuesValue().iterator();
      this.iter = _iterator;
    }
    _setOutputMethod("action1Output", value);
    
  }
  
  public void action1Output(final Object value) throws IllegalActionException {
    
    Object _value = value;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
