package org.ptolemy.xtext.examples.javafx.scene.control;

import com.google.common.base.Objects;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
  
  public PBrowser(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "PBrowser");
    
  }
  
  protected WebView webView;
  
  private WebView _initialWebViewStateVariableValue() throws IllegalActionException {
    
    WebView _get = this.<WebView>get(_getIdValue(), WebView.class);return _get; 
  }
  
  protected Worker<Void> pageLoader;
  
  private Worker<Void> _initialPageLoaderStateVariableValue() throws IllegalActionException {
    
    WebEngine _engine = this.webView.getEngine();
    Worker<Void> _loadWorker = _engine.getLoadWorker();return _loadWorker; 
  }
  
  protected URL page;
  
  private URL old_page;
  
  private URL _initialPageStateVariableValue() throws IllegalActionException {
    return null; 
  }
  
  public URL createURL(final String location) throws IllegalActionException {
    URL _xtrycatchfinallyexpression = null;
    try {
      URL _uRL = new URL(location);
      _xtrycatchfinallyexpression = _uRL;
    } catch (final Throwable _t) {
      if (_t instanceof MalformedURLException) {
        final MalformedURLException mue = (MalformedURLException)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public void setPage(final URL url) throws IllegalActionException {
    try {
      WebEngine _engine = this.webView.getEngine();
      String _string = url.toString();
      _engine.load(_string);
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
    this.webView = this.webView = _initialWebViewStateVariableValue();
    _postChangeWebViewState(this.webView);
    this.pageLoader = this.pageLoader = _initialPageLoaderStateVariableValue();
    _postChangePageLoaderState(this.pageLoader);
    this.page = this.old_page = _initialPageStateVariableValue();
    _postChangePageState(this.page);
    
  }
  
  protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
    Pair<Integer,AbstractActionImpl> result = super._fireImpl();
    if (result != null) return result;
    _preChangePageState(this.page);
    this.page = this.old_page = _initialPageStateVariableValue();
    _postChangePageState(this.page);
    if (_actionImpls[0].match()) return new Pair.Impl(-1, _actionImpls[0]);
    if (_actionImpls[1].match()) return new Pair.Impl(-1, _actionImpls[1]);
    return null;
    
  }
  
  @SuppressWarnings("all")
  public class pageLoader1StateListener implements ChangeListener<State> {
    public void changed(final ObservableValue<? extends State> arg0, final State arg1, final State arg2) {
      postEvent(0, pageLoader, "state", "changed", arg0,arg1,arg2);
      
    }
  }
  
  
  private ChangeListener<State> pageLoader1StateListener = new pageLoader1StateListener();
    ;
  
  public void _preChangeWebViewState_javafx(final WebView webView) throws IllegalActionException {
    
  }
  
  public void _preChangeWebViewState(final WebView webView) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangeWebViewState_javafx(webView);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangePageLoaderState_javafx(final Worker<Void> pageLoader) throws IllegalActionException {
    if (pageLoader != null) {
      pageLoader.stateProperty().removeListener(pageLoader1StateListener);
      
    }
    
  }
  
  public void _preChangePageLoaderState(final Worker<Void> pageLoader) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangePageLoaderState_javafx(pageLoader);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _preChangePageState_javafx(final URL page) throws IllegalActionException {
    
  }
  
  public void _preChangePageState(final URL page) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _preChangePageState_javafx(page);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangeWebViewState_javafx(final WebView webView) throws IllegalActionException {
    
  }
  
  public void _postChangeWebViewState(final WebView webView) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangeWebViewState_javafx(webView);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangePageLoaderState_javafx(final Worker<Void> pageLoader) throws IllegalActionException {
    if (pageLoader != null) {
      pageLoader.stateProperty().addListener(pageLoader1StateListener);
      
    }
    
  }
  
  public void _postChangePageLoaderState(final Worker<Void> pageLoader) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangePageLoaderState_javafx(pageLoader);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _postChangePageState_javafx(final URL page) throws IllegalActionException {
    
  }
  
  public void _postChangePageState(final URL page) throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _postChangePageState_javafx(page);
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  public void _updatePageState_javafx() throws IllegalActionException {
    
    this.setPage(this.page);
    
  }
  
  public void _updatePageState() throws IllegalActionException {
    realmAsyncExec("javafx", new Runnable() {
      public void run() {
        try {
          _updatePageState_javafx();
          
        } catch (Exception e) {}
        
      }
      
    });
    
  }
  
  protected boolean _postfireImpl() throws IllegalActionException {
    if (! super._postfireImpl()) return false;
    if (this.old_page != this.page) {
      _updatePageState();
      _preChangePageState(this.old_page);
      this.old_page = this.page;
      _postChangePageState(this.old_page);
      
    }
    return true; 
  }
  
  protected void _wrapupImpl() throws IllegalActionException {
    super._wrapupImpl();
    _preChangeWebViewState(this.webView);
    this.webView = null;
    _preChangePageLoaderState(this.pageLoader);
    this.pageLoader = null;
    _preChangePageState(this.page);
    this.page = null;
    
  }
  
  @SuppressWarnings("all")
  public class Actions0 extends AbstractActionImpl {
    private URL url;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(PBrowser.this.systemOutput, 0, 1)) return false;
      url = _getSystemOutputTokenValue(PBrowser.this.systemOutput.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      PBrowser.this.page = this.url;
      
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
    private ObservableValue<? extends State> property;
    
    public boolean match() throws IllegalActionException {
      Object[] event = getEvent(pageLoader, "state", null);
      if (event == null) return false;
      if (event.length > 0) property = (ObservableValue<? extends State>) event[0];
      if (! _matchPattern0Guard()) return false;
      return true; 
    }
    
    private boolean _matchPattern0Guard() throws IllegalActionException {
      
      State _value = this.property.getValue();
      boolean _equals = Objects.equal(_value, State.SUCCEEDED);return _equals; 
    }
    
    public void output() throws IllegalActionException {
      URL _value = _outputPattern0Output0();
      send(PBrowser.this.userInput, 0, _createUserInputToken(_value), -1);
      
    }
    
    private URL _outputPattern0Output0() throws IllegalActionException {
      
      WebEngine _engine = PBrowser.this.webView.getEngine();
      String _location = _engine.getLocation();
      URL _createURL = PBrowser.this.createURL(_location);return _createURL; 
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
