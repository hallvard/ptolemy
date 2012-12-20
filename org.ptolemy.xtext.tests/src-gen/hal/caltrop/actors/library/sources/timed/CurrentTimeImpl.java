package hal.caltrop.actors.library.sources.timed;

import hal.caltrop.actors.library.sources.timed.CurrentTime;
import org.ptolemy.xtext.lib.caltrop.AbstractActorImpl;
import ptolemy.actor.Director;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.Time;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;

public class CurrentTimeImpl extends AbstractActorImpl {
  protected final Parameter useLocalTime;
  
  protected TypedIOPort output;
  
  public CurrentTimeImpl(final CurrentTime _actor, final Parameter useLocalTime, final TypedIOPort output) {
    super(_actor);
    this._actor = _actor;
    this.useLocalTime = useLocalTime;
    this.output = output;
    
  }
  
  private final CurrentTime _actor;
  
  public CurrentTime getActor() {
    return _actor;
    
  }
  
  public boolean prefire() throws IllegalActionException {
    if (super.prefire()) return true;
    if (action1Match()) return true;
    
    return false; 
  }
  
  public boolean fire() throws IllegalActionException {
    super.fire();
    return _callDoMethod() && _callOutputMethod(); 
  }
  
  public boolean action1Match() throws IllegalActionException {
    _setDoMethod("action1Do");
    return true; 
  }
  
  public void action1Do() throws IllegalActionException {
    
    double _xifexpression = (double) 0;
    if (getActor().getUseLocalTimeValue()) {
      Director _director = this.getDirector();
      Time _modelTime = _director.getModelTime();
      double _doubleValue = _modelTime.getDoubleValue();
      _xifexpression = _doubleValue;
    } else {
      Director _director_1 = this.getDirector();
      Time _globalTime = _director_1.getGlobalTime();
      double _doubleValue_1 = _globalTime.getDoubleValue();
      _xifexpression = _doubleValue_1;
    }
    final double time = _xifexpression;
    _setOutputMethod("action1Output", time);
    
  }
  
  public void action1Output(final double time) throws IllegalActionException {
    
    double _value = time;
    this.output.send(0, getActor().createOutputToken(_value));
    
  }
}
