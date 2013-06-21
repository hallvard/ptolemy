package org.ptolemy.xtext.swing;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;
import org.ptolemy.xtext.lib.caltrop.Pair;
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
public class PBrowser extends AbstractCaltropActor {
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
  
  protected TypedIOPort _createSystemOutputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "systemOutput", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getSystemOutputTokenValue(final Token systemOutput) throws IllegalActionException {
    return ((URL) ObjectToken.convert(systemOutput).getValue()); 
  }
  
  protected TypedIOPort _createUserInputPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "userInput", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected ObjectToken _createUserInputToken(final URL userInput) throws IllegalActionException {
    return new ObjectToken(userInput, URL.class);
    
  }
  
  public PBrowser(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.id = _createIdAttribute();
    this.systemOutput = _createSystemOutputPort();
    this.userInput = _createUserInputPort();
    _setIdValue(_initialIdAttributeValue());
    
  }
  
  protected JEditorPane editorPane;
  
  private JEditorPane _initialEditorPaneStateVariableValue() throws IllegalActionException {
    
    JEditorPane _get = this.<JEditorPane>get(_getIdValue(), JEditorPane.class);return _get; 
  }
  
  public void setPage(final URL url) throws IllegalActionException {
    try {
      this.editorPane.setPage(url);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ioe = (IOException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void _initializeImpl() throws IllegalActionException {
    super._initializeImpl();
    this.editorPane = _initialEditorPaneStateVariableValue();
    _postChangeEditorPaneState(this.editorPane);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    if (_actionImpls[2].match()) return new Pair.Impl(-1, _actionImpls[2]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class editorPane1PageListener implements PropertyChangeListener {
    public void propertyChange(final PropertyChangeEvent arg0) {
      postEvent(0, editorPane, "page", "propertyChange", arg0);
      
    }
  }
  
  
  private PropertyChangeListener editorPane1PageListener = new editorPane1PageListener();
    ;
  
  @SuppressWarnings("all")
  public class editorPane2HyperlinkListener implements HyperlinkListener {
    public void hyperlinkUpdate(final HyperlinkEvent arg0) {
      postEvent(0, editorPane, "hyperlink", "hyperlinkUpdate", arg0);
      
    }
  }
  
  
  private HyperlinkListener editorPane2HyperlinkListener = new editorPane2HyperlinkListener();
    ;
  
  public void _preChangeEditorPaneState(final JEditorPane editorPane) {
    if (editorPane != null) {
      editorPane.removePropertyChangeListener("page", editorPane1PageListener);
      editorPane.removeHyperlinkListener(editorPane2HyperlinkListener);
      
    }
    
  }
  
  public void _postChangeEditorPaneState(final JEditorPane editorPane) {
    if (editorPane != null) {
      editorPane.addPropertyChangeListener("page", editorPane1PageListener);
      editorPane.addHyperlinkListener(editorPane2HyperlinkListener);
      
    }
    
  }
  
  protected boolean _postfireImpl() {
    if (! super._postfireImpl()) return false;
    return true; 
  }
  
  protected void _wrapupImpl() {
    super._wrapupImpl();
    _preChangeEditorPaneState(this.editorPane);
    this.editorPane = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private URL url;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PBrowser.this.systemOutput, 0, 1)) return false;
      url = _getSystemOutputTokenValue(PBrowser.this.systemOutput.get(0));
      return true; 
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
        PBrowser.this.setPage(this.url);
        _xblockexpression = (true);
      }
      return _xblockexpression;
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    private PropertyChangeEvent propertyEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(editorPane, "page", null);
      if (event == null) return false;
      if (event.length > 0) propertyEvent = (PropertyChangeEvent) event[0];
      return true; 
    }
    
    public void output() throws IllegalActionException {
      URL _value = _outputPattern0Output0();
      send(PBrowser.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private URL _outputPattern0Output0() throws IllegalActionException {
      
      URL _page = PBrowser.this.editorPane.getPage();return _page; 
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions2 extends AbstractActionImpl {
    private HyperlinkEvent hyperlinkEvent;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(editorPane, "hyperlink", null);
      if (event == null) return false;
      if (event.length > 0) hyperlinkEvent = (HyperlinkEvent) event[0];
      if (! _matchPattern0Guard()) return false;
      return true; 
    }
    
    private boolean _matchPattern0Guard() throws IllegalActionException {
      
      EventType _eventType = this.hyperlinkEvent.getEventType();
      String _string = _eventType.toString();
      boolean _equals = "ACTIVATED".equals(_string);return _equals; 
    }
    
    public void output() throws IllegalActionException {
      
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
        URL _uRL = this.hyperlinkEvent.getURL();
        PBrowser.this.setPage(_uRL);
        _xblockexpression = (true);
      }
      return _xblockexpression;
      
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
