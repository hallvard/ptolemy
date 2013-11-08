package org.ptolemy.xtext.examples.javafx.scene.chart;

import com.google.common.base.Objects;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.Pair;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.IntToken;
import ptolemy.data.ObjectToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.Variable;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public abstract class PXYChartXsYs<X, Y> extends AbstractCaltropActor {
  protected final Variable id;
  
  protected TypedIOPort xs;
  
  protected TypedIOPort ys;
  
  protected TypedIOPort seriesNum;
  
  protected TypedIOPort clear;
  
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
  
  protected abstract TypedIOPort _createXsPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract X _getXsTokenValue(final Token xs) throws IllegalActionException;
  
  protected abstract TypedIOPort _createYsPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Y _getYsTokenValue(final Token ys) throws IllegalActionException;
  
  protected TypedIOPort _createSeriesNumPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "seriesNum", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.INT);
    return port;
    
  }
  
  protected int _getSeriesNumTokenValue(final Token seriesNum) throws IllegalActionException {
    return IntToken.convert(seriesNum).intValue(); 
  }
  
  protected TypedIOPort _createClearPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "clear", true, false);
    port.setMultiport(false);
    port.setTypeEquals(ptolemy.data.type.BaseType.OBJECT);
    return port;
    
  }
  
  protected Object _getClearTokenValue(final Token clear) throws IllegalActionException {
    return ObjectToken.convert(clear).getValue(); 
  }
  
  public PXYChartXsYs(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.xs = _createXsPort();
    this.ys = _createYsPort();
    this.seriesNum = _createSeriesNumPort();
    this.clear = _createClearPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  public PXYChartXsYs(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PXYChartXsYs");
    
  }
  
  protected XYChart<X,Y> xyChart;
  
  private XYChart<X,Y> _initialXyChartStateVariableValue() throws IllegalActionException {
    
    XYChart _get = this.<XYChart>get(_getIdValue(), XYChart.class);return _get; 
  }
  
  protected int currentSeriesNum;
  
  private int old_currentSeriesNum;
  
  private int _initialCurrentSeriesNumStateVariableValue() throws IllegalActionException {
    return 0; 
  }
  
  protected boolean clearSeries;
  
  private boolean old_clearSeries;
  
  protected Data<X,Y> newData;
  
  private Data<X,Y> old_newData;
  
  public Series<X,Y> series(final int seriesNum) throws IllegalActionException {
    Series<X,Y> _xblockexpression = null;
    {
      ObservableList<Series<X,Y>> _data = this.xyChart.getData();
      int _size = _data.size();
      boolean _lessEqualsThan = (_size <= seriesNum);
      boolean _while = _lessEqualsThan;
      while (_while) {
        ObservableList<Series<X,Y>> _data_1 = this.xyChart.getData();
        Series<X,Y> _series = new Series<X, Y>();
        _data_1.add(_series);
        ObservableList<Series<X,Y>> _data_2 = this.xyChart.getData();
        int _size_1 = _data_2.size();
        boolean _lessEqualsThan_1 = (_size_1 <= seriesNum);
        _while = _lessEqualsThan_1;
      }
      ObservableList<Series<X,Y>> _data_1 = this.xyChart.getData();
      Series<X,Y> _get = _data_1.get(seriesNum);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.xyChart = this.xyChart = _initialXyChartStateVariableValue();
    _postChangeXyChartState(this.xyChart);
    this.currentSeriesNum = this.old_currentSeriesNum = _initialCurrentSeriesNumStateVariableValue();
    _postChangeCurrentSeriesNumState(this.currentSeriesNum);
    this.clearSeries = this.old_clearSeries = false;
    _postChangeClearSeriesState(this.clearSeries);
    this.newData = this.old_newData = null;
    _postChangeNewDataState(this.newData);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    this.currentSeriesNum = this.old_currentSeriesNum;
    this.clearSeries = this.old_clearSeries;
    this.newData = this.old_newData;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    if (_actionImpls[2].match()) return new Pair.Impl(-1, _actionImpls[2]);
    return null;
    
  }
  
  public void _preChangeXyChartState_javafx(final XYChart<X,Y> xyChart) throws IllegalActionException {
    
  }
  
  public void _preChangeXyChartState(final XYChart<X,Y> xyChart) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeXyChartState_javafx(xyChart);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeCurrentSeriesNumState(final int currentSeriesNum) throws IllegalActionException {
    
  }
  
  public void _preChangeClearSeriesState_javafx(final boolean clearSeries) throws IllegalActionException {
    
  }
  
  public void _preChangeClearSeriesState(final boolean clearSeries) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeClearSeriesState_javafx(clearSeries);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeNewDataState_javafx(final Data<X,Y> newData) throws IllegalActionException {
    
  }
  
  public void _preChangeNewDataState(final Data<X,Y> newData) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeNewDataState_javafx(newData);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeXyChartState_javafx(final XYChart<X,Y> xyChart) throws IllegalActionException {
    
  }
  
  public void _postChangeXyChartState(final XYChart<X,Y> xyChart) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeXyChartState_javafx(xyChart);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeCurrentSeriesNumState(final int currentSeriesNum) throws IllegalActionException {
    
  }
  
  public void _postChangeClearSeriesState_javafx(final boolean clearSeries) throws IllegalActionException {
    
  }
  
  public void _postChangeClearSeriesState(final boolean clearSeries) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeClearSeriesState_javafx(clearSeries);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeNewDataState_javafx(final Data<X,Y> newData) throws IllegalActionException {
    
  }
  
  public void _postChangeNewDataState(final Data<X,Y> newData) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeNewDataState_javafx(newData);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateClearSeriesState_javafx() throws IllegalActionException {
    
    Series<X,Y> _series = this.series(this.currentSeriesNum);
    ObservableList<Data<X,Y>> _data = _series.getData();
    _data.clear();
    
  }
  
  public void _updateClearSeriesState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updateClearSeriesState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateNewDataState_javafx() throws IllegalActionException {
    
    Series<X,Y> _series = this.series(this.currentSeriesNum);
    ObservableList<Data<X,Y>> _data = _series.getData();
    _data.add(this.newData);
    
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
    if (this.old_currentSeriesNum != this.currentSeriesNum) {
      _preChangeCurrentSeriesNumState(this.old_currentSeriesNum);
      this.old_currentSeriesNum = this.currentSeriesNum;
      _postChangeCurrentSeriesNumState(this.old_currentSeriesNum);
      
    }
    if (this.old_clearSeries != this.clearSeries) {
      _updateClearSeriesState();
      _preChangeClearSeriesState(this.old_clearSeries);
      this.old_clearSeries = this.clearSeries;
      _postChangeClearSeriesState(this.old_clearSeries);
      
    }
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
    _preChangeXyChartState(this.xyChart);
    this.xyChart = null;
    _preChangeCurrentSeriesNumState(this.currentSeriesNum);
    this.currentSeriesNum = 0;
    _preChangeClearSeriesState(this.clearSeries);
    this.clearSeries = false;
    _preChangeNewDataState(this.newData);
    this.newData = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private int i;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PXYChartXsYs.this.seriesNum, 0, 1)) return false;
      i = _getSeriesNumTokenValue(PXYChartXsYs.this.seriesNum.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      PXYChartXsYs.this.currentSeriesNum = this.i;
      
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
    private Object b;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PXYChartXsYs.this.clear, 0, 1)) return false;
      b = _getClearTokenValue(PXYChartXsYs.this.clear.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(this.b, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _equals = Boolean.FALSE.equals(this.b);
        boolean _not = (!_equals);
        _and = (_notEquals && _not);
      }
      PXYChartXsYs.this.clearSeries = _and;
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions2 extends AbstractActionImpl {
    private X x;
    
    private Y y;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PXYChartXsYs.this.xs, 0, 1)) return false;
      x = _getXsTokenValue(PXYChartXsYs.this.xs.get(0));
      if (! hasToken(PXYChartXsYs.this.ys, 0, 1)) return false;
      y = _getYsTokenValue(PXYChartXsYs.this.ys.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      Data<X,Y> _data = new Data<X, Y>(this.x, this.y);
      PXYChartXsYs.this.newData = _data;
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
      new Actions0(), new Actions1(), new Actions2(), 
    }
    ;
  
  public CausalityInterface getCausalityInterface() throws IllegalActionException {
    return _getCausalityInterface(_actionImpls);
    
  }
}
