package org.ptolemy.xtext.examples.javafx.scene.chart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import org.eclipse.xtext.xbase.lib.Pair;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.Variable;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class PPieChartPairs extends AbstractCaltropActor {
  protected final Variable id;
  
  protected TypedIOPort data;
  
  protected Parameter _createIdAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "id");
    attribute.setTypeEquals(ptolemy.data.type.BaseType.STRING);
    return attribute;
    
  }
  
  protected StringToken _createIdToken(final String id) throws IllegalActionException {
    return new StringToken(id);
    
  }
  
  protected String _initialIdAttributeValue() throws IllegalActionException {
    return null; 
  }
  
  protected String _getIdValue() throws IllegalActionException {
    return StringToken.convert(this.id.getToken()).stringValue(); 
  }
  
  protected void _setIdValue(final String id) throws IllegalActionException {
    this.id.setToken(_createIdToken(id));
    
  }
  
  protected TypedIOPort _createDataPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "data", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(Pair.class));
    return port;
    
  }
  
  protected Pair<String,Double> _getDataTokenValue(final Token data) throws IllegalActionException {
    return ((Pair<String,Double>) ObjectToken.convert(data).getValue()); 
  }
  
  public PPieChartPairs(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.data = _createDataPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  public PPieChartPairs(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PPieChartPairs");
    
  }
  
  protected PieChart pieChart;
  
  private PieChart _initialPieChartStateVariableValue() throws IllegalActionException {
    
    PieChart _get = this.<PieChart>get(_getIdValue(), PieChart.class);return _get; 
  }
  
  protected Map<String,Data> pieData;
  
  private Map<String,Data> _initialPieDataStateVariableValue() throws IllegalActionException {
    
    HashMap<String,Data> _hashMap = new HashMap<String, Data>();return _hashMap; 
  }
  
  protected Data newData;
  
  private Data old_newData;
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.pieChart = this.pieChart = _initialPieChartStateVariableValue();
    _postChangePieChartState(this.pieChart);
    this.pieData = this.pieData = _initialPieDataStateVariableValue();
    _postChangePieDataState(this.pieData);
    this.newData = this.old_newData = null;
    _postChangeNewDataState(this.newData);
    
  }
  
  protected org.ptolemy.xtext.lib.caltrop.Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    org.ptolemy.xtext.lib.caltrop.Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    this.newData = this.old_newData;
    if (_actionImpls[0].match()) return new org.ptolemy.xtext.lib.caltrop.Pair.Impl(-1, _actionImpls[0]);
    return null;
    
  }
  
  public void _preChangePieChartState_javafx(final PieChart pieChart) throws IllegalActionException {
    
  }
  
  public void _preChangePieChartState(final PieChart pieChart) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangePieChartState_javafx(pieChart);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangePieDataState(final Map<String,Data> pieData) throws IllegalActionException {
    
  }
  
  public void _preChangeNewDataState_javafx(final Data newData) throws IllegalActionException {
    
  }
  
  public void _preChangeNewDataState(final Data newData) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeNewDataState_javafx(newData);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangePieChartState_javafx(final PieChart pieChart) throws IllegalActionException {
    
  }
  
  public void _postChangePieChartState(final PieChart pieChart) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangePieChartState_javafx(pieChart);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangePieDataState(final Map<String,Data> pieData) throws IllegalActionException {
    
  }
  
  public void _postChangeNewDataState_javafx(final Data newData) throws IllegalActionException {
    
  }
  
  public void _postChangeNewDataState(final Data newData) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeNewDataState_javafx(newData);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateNewDataState_javafx() throws IllegalActionException {
    
    String _name = this.newData.getName();
    this.pieData.put(_name, this.newData);
    ObservableList<Data> _data = this.pieChart.getData();
    Collection<Data> _values = this.pieData.values();
    _data.setAll(_values);
    
  }
  
  public void _updateNewDataState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updateNewDataState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  protected boolean _postfireImpl() throws IllegalActionException {
    if (! super._postfireImpl()) return false;
    if (this.old_newData != this.newData) {
      _updateNewDataState();
      _preChangeNewDataState(this.old_newData);
      this.old_newData = this.newData;
      _postChangeNewDataState(this.old_newData);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() throws IllegalActionException {
    super._wrapupImpl();
    _preChangePieChartState(this.pieChart);
    this.pieChart = null;
    _preChangePieDataState(this.pieData);
    this.pieData = null;
    _preChangeNewDataState(this.newData);
    this.newData = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private Pair<String,Double> data;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PPieChartPairs.this.data, 0, 1)) return false;
      data = _getDataTokenValue(PPieChartPairs.this.data.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      String _key = this.data.getKey();
      Double _value = this.data.getValue();
      Data _data = new Data(_key, (_value).doubleValue());
      PPieChartPairs.this.newData = _data;
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public org.ptolemy.xtext.lib.caltrop.Pair<org.ptolemy.xtext.lib.caltrop.Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new org.ptolemy.xtext.lib.caltrop.Pair[]{
        
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
