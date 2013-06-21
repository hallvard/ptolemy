package org.ptolemy.xtext.browser.browser;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.ptolemy.xtext.lib.caltrop.AbstractActionImpl;
import org.ptolemy.xtext.lib.caltrop.Pair;
import org.ptolemy.xtext.util.Variable;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.ObjectToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class bookmarks extends Variable<List<URL>> {
  protected TypedIOPort addBookmark;
  
  protected TypedIOPort removeBookmark;
  
  protected Parameter _createInitialValueAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "initialValue");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(List.class));
    return attribute;
    
  }
  
  protected ObjectToken _createInitialValueToken(final List<URL> initialValue) throws IllegalActionException {
    return new ObjectToken(initialValue, List.class);
    
  }
  
  protected List<URL> _getInitialValueValue() throws IllegalActionException {
    return ((List<URL>) ObjectToken.convert(this.initialValue.getToken()).getValue()); 
  }
  
  protected Parameter _createValidatorAttribute() throws NameDuplicationException, IllegalActionException {
    Parameter attribute = new Parameter(this, "validator");
    attribute.setTypeEquals(new ptolemy.data.type.ObjectType(Function1.class));
    return attribute;
    
  }
  
  protected ObjectToken _createValidatorToken(final Function1<? super List<URL>,? extends Boolean> validator) throws IllegalActionException {
    return new ObjectToken(validator, Function1.class);
    
  }
  
  protected Function1<? super List<URL>,? extends Boolean> _getValidatorValue() throws IllegalActionException {
    return ((Function1<? super List<URL>,? extends Boolean>) ObjectToken.convert(this.validator.getToken()).getValue()); 
  }
  
  protected TypedIOPort _createAddBookmarkPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "addBookmark", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getAddBookmarkTokenValue(final Token addBookmark) throws IllegalActionException {
    return ((URL) ObjectToken.convert(addBookmark).getValue()); 
  }
  
  protected TypedIOPort _createRemoveBookmarkPort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "removeBookmark", true, false);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(URL.class));
    return port;
    
  }
  
  protected URL _getRemoveBookmarkTokenValue(final Token removeBookmark) throws IllegalActionException {
    return ((URL) ObjectToken.convert(removeBookmark).getValue()); 
  }
  
  protected TypedIOPort _createSetValuePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "setValue", true, false);
    port.setMultiport(true);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(List.class));
    return port;
    
  }
  
  protected List<URL> _getSetValueTokenValue(final Token setValue) throws IllegalActionException {
    return ((List<URL>) ObjectToken.convert(setValue).getValue()); 
  }
  
  protected TypedIOPort _createValuePort() throws NameDuplicationException, IllegalActionException {
    TypedIOPort port = new TypedIOPort(this, "value", false, true);
    port.setMultiport(false);
    port.setTypeEquals(new ptolemy.data.type.ObjectType(List.class));
    return port;
    
  }
  
  protected ObjectToken _createValueToken(final List<URL> value) throws IllegalActionException {
    return new ObjectToken(value, List.class);
    
  }
  
  protected List<URL> _initialInitialValueAttributeValue() throws IllegalActionException {
    
    ArrayList<URL> _arrayList = new ArrayList<URL>();
    
    return _arrayList; 
  }
  
  public bookmarks(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.addBookmark = _createAddBookmarkPort();
    this.removeBookmark = _createRemoveBookmarkPort();
    
  }
  
  public List<URL> addBookmark(final List<URL> bookmarks, final URL bookmark, final boolean copy) throws IllegalActionException {
    List<URL> _xblockexpression = null;
    {
      List<URL> _xifexpression = null;
      if (copy) {
        ArrayList<URL> _arrayList = new ArrayList<URL>(bookmarks);
        _xifexpression = _arrayList;
      } else {
        _xifexpression = bookmarks;
      }
      final List<URL> newBookmarks = _xifexpression;
      boolean _contains = newBookmarks.contains(bookmark);
      boolean _not = (!_contains);
      if (_not) {
        newBookmarks.add(bookmark);
      }
      _xblockexpression = (newBookmarks);
    }
    return _xblockexpression;
  }
  
  public List<URL> removeBookmark(final List<URL> bookmarks, final URL bookmark, final boolean copy) throws IllegalActionException {
    List<URL> _xblockexpression = null;
    {
      List<URL> _xifexpression = null;
      if (copy) {
        ArrayList<URL> _arrayList = new ArrayList<URL>(bookmarks);
        _xifexpression = _arrayList;
      } else {
        _xifexpression = bookmarks;
      }
      final List<URL> newBookmarks = _xifexpression;
      boolean _contains = newBookmarks.contains(bookmark);
      if (_contains) {
        newBookmarks.remove(bookmark);
      }
      _xblockexpression = (newBookmarks);
    }
    return _xblockexpression;
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
    private URL bookmark;
    
    private List<URL> oldBookmarks;
    
    private List<URL> newBookmarks;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(bookmarks.this.addBookmark, 0, 1)) return false;
      bookmark = _getAddBookmarkTokenValue(bookmarks.this.addBookmark.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      final List<URL> oldBookmarks = bookmarks.this.current;
      final List<URL> newBookmarks = bookmarks.this.addBookmark(bookmarks.this.current, this.bookmark, true);
      this.oldBookmarks = oldBookmarks;
      this.newBookmarks = newBookmarks;
      
    }
    
    public void output() throws IllegalActionException {
      if (_outputPattern0Guard()) {
        List<URL> _value = _outputPattern0Output0();
        send(bookmarks.this.value, 0, _createValueToken(_value), -1);
        
      }
      
    }
    
    private List<URL> _outputPattern0Output0() throws IllegalActionException {
      return this.newBookmarks; 
    }
    
    private boolean _outputPattern0Guard() throws IllegalActionException {
      
      boolean _contains = this.oldBookmarks.contains(this.bookmark);
      boolean _not = (!_contains);return _not; 
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
        bookmarks.this.addBookmark(bookmarks.this.current, this.bookmark, false);
        _xblockexpression = (true);
      }
      return _xblockexpression;
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(bookmarks.this.addBookmark, bookmarks.this.value), BooleanDependency.valueOf(true)), 
      };
      
    }
  }
  
  
  @SuppressWarnings("all")
  public class Actions1 extends AbstractActionImpl {
    private URL bookmark;
    
    private List<URL> oldBookmarks;
    
    private List<URL> newBookmarks;
    
    public boolean match() throws IllegalActionException {
      if (! hasToken(bookmarks.this.removeBookmark, 0, 1)) return false;
      bookmark = _getRemoveBookmarkTokenValue(bookmarks.this.removeBookmark.get(0));
      return true; 
    }
    
    public void body() throws IllegalActionException {
      
      final List<URL> oldBookmarks = bookmarks.this.current;
      final List<URL> newBookmarks = bookmarks.this.removeBookmark(bookmarks.this.current, this.bookmark, true);
      this.oldBookmarks = oldBookmarks;
      this.newBookmarks = newBookmarks;
      
    }
    
    public void output() throws IllegalActionException {
      if (_outputPattern0Guard()) {
        List<URL> _value = _outputPattern0Output0();
        send(bookmarks.this.value, 0, _createValueToken(_value), -1);
        
      }
      
    }
    
    private List<URL> _outputPattern0Output0() throws IllegalActionException {
      return this.newBookmarks; 
    }
    
    private boolean _outputPattern0Guard() throws IllegalActionException {
      
      boolean _contains = this.oldBookmarks.contains(this.bookmark);return _contains; 
    }
    
    public boolean update() throws IllegalActionException {
      
      boolean _xblockexpression = false;
      {
        bookmarks.this.removeBookmark(bookmarks.this.current, this.bookmark, false);
        _xblockexpression = (true);
      }
      return _xblockexpression;
      
    }
    
    public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
      return new Pair[]{
        new Pair.Impl(new Pair.Impl(bookmarks.this.removeBookmark, bookmarks.this.value), BooleanDependency.valueOf(true)), 
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
