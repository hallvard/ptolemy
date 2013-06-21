package org.ptolemy.xtext.swing;

import java.util.List;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.Pair;
import org.ptolemy.xtext.tests.gui.swing.DelegatingListModel;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.BooleanDependency;
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
public abstract class PList<T> extends AbstractCaltropActor {
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
  
  protected abstract List<T> _getSystemOutputTokenValue(final Token systemOutput) throws IllegalActionException;
  
  protected abstract TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException;
  
  protected abstract Token _createUserInputToken(final T userInput) throws IllegalActionException;
  
  public PList(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.systemOutput = _createSystemOutputPort();
    this.userInput = _createUserInputPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  protected JList list;
  
  private JList _initialListStateVariableValue() throws IllegalActionException {
    
    JList _get = this.<JList>get(_getIdValue(), JList.class);return _get; 
  }
  
  public int newSelectionIndex(final List<T> values, final T oldSelection, final int oldIndex) throws IllegalActionException {
    int _indexOf = values.indexOf(oldSelection);
    return _indexOf;
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.list = _initialListStateVariableValue();
    _postChangeListState(this.list);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class list1ListSelectionListener implements ListSelectionListener {
    public void valueChanged(final ListSelectionEvent arg0) {
      postEvent(0, list, "listSelection", "valueChanged", arg0);
      
    }
  }
  
  
  private ListSelectionListener list1ListSelectionListener = new list1ListSelectionListener();
    ;
  
  public void _preChangeListState(final JList list) {
    if (list != null) {
      list.removeListSelectionListener(list1ListSelectionListener);
      
    }
    
  }
  
  public void _postChangeListState(final JList list) {
    if (list != null) {
      list.addListSelectionListener(list1ListSelectionListener);
      
    }
    
  }
  
  protected boolean _postfireImpl() {
    if (! super._postfireImpl()) return false;
    return true; 
  }
  
  protected void _wrapupImpl() {
    super._wrapupImpl();
    _preChangeListState(this.list);
    this.list = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private List<T> values;
    
    private int index;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PList.this.systemOutput, 0, 1)) return false;
      values = _getSystemOutputTokenValue(PList.this.systemOutput.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      Object _selectedValue = PList.this.list.getSelectedValue();
      int _selectedIndex = PList.this.list.getSelectedIndex();
      final int index = PList.this.newSelectionIndex(this.values, ((T) _selectedValue), _selectedIndex);
      this.index = index;
      
    }
    
    public void output() throws IllegalActionException {
      T _value = _outputPattern0Output0();
      send(PList.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private T _outputPattern0Output0() throws IllegalActionException {
      
      T _xifexpression = null;
      boolean _lessThan = (this.index < 0);
      if (_lessThan) {
        _xifexpression = null;
      } else {
        ListModel _model = PList.this.list.getModel();
        Object _elementAt = _model.getElementAt(this.index);
        _xifexpression = ((T) _elementAt);
      }return _xifexpression; 
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
        DelegatingListModel<T> _delegatingListModel = new DelegatingListModel<T>(this.values);
        PList.this.list.setModel(_delegatingListModel);
        PList.this.list.setSelectedIndex(this.index);
        _xblockexpression = (true);
      }
      return _xblockexpression;
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(PList.this.systemOutput, PList.this.userInput), BooleanDependency.valueOf(true)), 
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    private ListSelectionEvent listSelectionEvent;
    
    private T selection;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(list, "listSelection", null);
      if (event == null) return false;
      if (event.length > 0) listSelectionEvent = (ListSelectionEvent) event[0];
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      Object _selectedValue = PList.this.list.getSelectedValue();
      final T selection = ((T) _selectedValue);
      this.selection = selection;
      
    }
    
    public void output() throws IllegalActionException {
      T _value = _outputPattern0Output0();
      send(PList.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private T _outputPattern0Output0() throws IllegalActionException {
      return this.selection; 
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
