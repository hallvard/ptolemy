package org.ptolemy.xtext.examples.javafx.scene.control;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionModel;
import org.eclipse.xtext.xbase.lib.Pair;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.Variable;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public abstract class PCollection<T> extends AbstractCaltropActor {
  protected final Variable id;
  
  protected TypedIOPort systemOutput;
  
  protected TypedIOPort userInput;
  
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
  
  protected abstract TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Collection<T> _getSystemOutputTokenValue(final Token systemOutput) throws IllegalActionException;
  
  protected abstract TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token _createUserInputToken(final T userInput) throws IllegalActionException;
  
  public PCollection(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.systemOutput = _createSystemOutputPort();
    this.userInput = _createUserInputPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  public PCollection(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PCollection");
    
  }
  
  protected ListView<T> list;
  
  private ListView<T> _initialListStateVariableValue() throws IllegalActionException {
    
    ListView _get = this.<ListView>get(_getIdValue(), ListView.class);return _get; 
  }
  
  protected SelectionModel<T> selectionModel;
  
  private SelectionModel<T> _initialSelectionModelStateVariableValue() throws IllegalActionException {
    
    MultipleSelectionModel<T> _selectionModel = this.list.getSelectionModel();return _selectionModel; 
  }
  
  protected List<T> items;
  
  private List<T> old_items;
  
  private List<T> _initialItemsStateVariableValue() throws IllegalActionException {
    
    ObservableList<T> _items = this.list.getItems();return _items; 
  }
  
  protected Pair<T,Integer> selection;
  
  private Pair<T,Integer> old_selection;
  
  private Pair<T,Integer> _initialSelectionStateVariableValue() throws IllegalActionException {
    
    T _selectedItem = this.selectionModel.getSelectedItem();
    int _selectedIndex = this.selectionModel.getSelectedIndex();
    Pair<T,Integer> _pair = new Pair<T, Integer>(_selectedItem, Integer.valueOf(_selectedIndex));return _pair; 
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.list = this.list = _initialListStateVariableValue();
    _postChangeListState(this.list);
    this.selectionModel = this.selectionModel = _initialSelectionModelStateVariableValue();
    _postChangeSelectionModelState(this.selectionModel);
    this.items = this.old_items = _initialItemsStateVariableValue();
    _postChangeItemsState(this.items);
    this.selection = this.old_selection = _initialSelectionStateVariableValue();
    _postChangeSelectionState(this.selection);
    
  }
  
  protected org.ptolemy.xtext.lib.caltrop.Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    org.ptolemy.xtext.lib.caltrop.Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    _preChangeItemsState(this.items);
    this.items = this.old_items = _initialItemsStateVariableValue();
    _postChangeItemsState(this.items);
    _preChangeSelectionState(this.selection);
    this.selection = this.old_selection = _initialSelectionStateVariableValue();
    _postChangeSelectionState(this.selection);
    if (_actionImpls[0].match()) return new org.ptolemy.xtext.lib.caltrop.Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new org.ptolemy.xtext.lib.caltrop.Pair.Impl(-1, _actionImpls[1]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class selectionModel1SelectedItemListener implements ChangeListener<T> {
    public void changed(final ObservableValue<? extends T> arg0, final T arg1, final T arg2) {
      postEvent(0, selectionModel, "selectedItem", "changed", arg0,arg1,arg2);
      
    }
  }
  
  
  private ChangeListener<T> selectionModel1SelectedItemListener = new selectionModel1SelectedItemListener();
    ;
  
  public void _preChangeListState_javafx(final ListView<T> list) throws IllegalActionException {
    
  }
  
  public void _preChangeListState(final ListView<T> list) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeListState_javafx(list);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeSelectionModelState_javafx(final SelectionModel<T> selectionModel) throws IllegalActionException {
    if (selectionModel != null) {
      selectionModel.selectedItemProperty().removeListener(selectionModel1SelectedItemListener);
      
    }
    
  }
  
  public void _preChangeSelectionModelState(final SelectionModel<T> selectionModel) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeSelectionModelState_javafx(selectionModel);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeItemsState_javafx(final List<T> items) throws IllegalActionException {
    
  }
  
  public void _preChangeItemsState(final List<T> items) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeItemsState_javafx(items);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangeSelectionState_javafx(final Pair<T,Integer> selection) throws IllegalActionException {
    
  }
  
  public void _preChangeSelectionState(final Pair<T,Integer> selection) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeSelectionState_javafx(selection);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeListState_javafx(final ListView<T> list) throws IllegalActionException {
    
  }
  
  public void _postChangeListState(final ListView<T> list) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeListState_javafx(list);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeSelectionModelState_javafx(final SelectionModel<T> selectionModel) throws IllegalActionException {
    if (selectionModel != null) {
      selectionModel.selectedItemProperty().addListener(selectionModel1SelectedItemListener);
      
    }
    
  }
  
  public void _postChangeSelectionModelState(final SelectionModel<T> selectionModel) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeSelectionModelState_javafx(selectionModel);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeItemsState_javafx(final List<T> items) throws IllegalActionException {
    
  }
  
  public void _postChangeItemsState(final List<T> items) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeItemsState_javafx(items);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeSelectionState_javafx(final Pair<T,Integer> selection) throws IllegalActionException {
    
  }
  
  public void _postChangeSelectionState(final Pair<T,Integer> selection) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeSelectionState_javafx(selection);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateItemsState_javafx() throws IllegalActionException {
    
    ObservableList<T> _items = this.list.getItems();
    _items.setAll(this.items);
    
  }
  
  public void _updateItemsState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updateItemsState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updateSelectionState_javafx() throws IllegalActionException {
    
    int _xifexpression = (int) 0;
    boolean _and = false;
    T _key = this.selection.getKey();
    boolean _notEquals = (!Objects.equal(_key, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Integer _value = this.selection.getValue();
      boolean _lessThan = ((_value).intValue() < 0);
      _and = (_notEquals && _lessThan);
    }
    if (_and) {
      T _key_1 = this.selection.getKey();
      int _indexOf = this.items.indexOf(_key_1);
      _xifexpression = _indexOf;
    } else {
      Integer _value_1 = this.selection.getValue();
      _xifexpression = (_value_1).intValue();
    }
    final int index = _xifexpression;
    this.selectionModel.select(index);
    
  }
  
  public void _updateSelectionState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updateSelectionState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  protected boolean _postfireImpl() throws IllegalActionException {
    if (! super._postfireImpl()) return false;
    if (this.old_items != this.items) {
      _updateItemsState();
      _preChangeItemsState(this.old_items);
      this.old_items = this.items;
      _postChangeItemsState(this.old_items);
      
    }
    if (this.old_selection != this.selection) {
      _updateSelectionState();
      _preChangeSelectionState(this.old_selection);
      this.old_selection = this.selection;
      _postChangeSelectionState(this.old_selection);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() throws IllegalActionException {
    super._wrapupImpl();
    _preChangeListState(this.list);
    this.list = null;
    _preChangeSelectionModelState(this.selectionModel);
    this.selectionModel = null;
    _preChangeItemsState(this.items);
    this.items = null;
    _preChangeSelectionState(this.selection);
    this.selection = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private Collection<T> values;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PCollection.this.systemOutput, 0, 1)) return false;
      values = _getSystemOutputTokenValue(PCollection.this.systemOutput.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      ArrayList<T> _arrayList = new ArrayList<T>(this.values);
      PCollection.this.items = _arrayList;
      T _key = PCollection.this.selection.getKey();
      int _minus = (-1);
      Pair<T,Integer> _mappedTo = Pair.<T, Integer>of(_key, Integer.valueOf(_minus));
      PCollection.this.selection = _mappedTo;
      
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public org.ptolemy.xtext.lib.caltrop.Pair<org.ptolemy.xtext.lib.caltrop.Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new org.ptolemy.xtext.lib.caltrop.Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    private ObservableValue<? extends T> listSelectionEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(selectionModel, "selectedItem", null);
      if (event == null) return false;
      if (event.length > 0) listSelectionEvent = (ObservableValue<? extends T>) event[0];
      return true; 
    }
    
    public void output() throws IllegalActionException {
      T _value = _outputPattern0Output0();
      send(PCollection.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private T _outputPattern0Output0() throws IllegalActionException {
      
      T _selectedItem = PCollection.this.selectionModel.getSelectedItem();return _selectedItem; 
    }
    
    public org.ptolemy.xtext.lib.caltrop.Pair<org.ptolemy.xtext.lib.caltrop.Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new org.ptolemy.xtext.lib.caltrop.Pair[]{
        
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
