package org.ptolemy.xtext.examples.javafx;

import org.ptolemy.xtext.examples.javafx.browser.addBookmarksButtonValve;
import org.ptolemy.xtext.examples.javafx.browser.bookmarks;
import org.ptolemy.xtext.examples.javafx.browser.bookmarksList;
import org.ptolemy.xtext.examples.javafx.browser.browserPane;
import org.ptolemy.xtext.examples.javafx.browser.location;
import org.ptolemy.xtext.examples.javafx.browser.locationText;
import org.ptolemy.xtext.examples.javafx.browser.relations0;
import org.ptolemy.xtext.examples.javafx.browser.removeBookmarksButtonValve;
import org.ptolemy.xtext.examples.javafx.browser.string2Url;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

@SuppressWarnings("all")
public class Browser extends TypedCompositeActor {
  private location location;
  
  protected location _createLocationEntity() throws NameDuplicationException, IllegalActionException {
    location location = new location(this, "location");
    return location;
    
  }
  
  private locationText locationText;
  
  protected locationText _createLocationTextEntity() throws NameDuplicationException, IllegalActionException {
    locationText locationText = new locationText(this, "locationText");
    return locationText;
    
  }
  
  private string2Url string2Url;
  
  protected string2Url _createString2UrlEntity() throws NameDuplicationException, IllegalActionException {
    string2Url string2Url = new string2Url(this, "string2Url");
    return string2Url;
    
  }
  
  private browserPane browserPane;
  
  protected browserPane _createBrowserPaneEntity() throws NameDuplicationException, IllegalActionException {
    browserPane browserPane = new browserPane(this, "browserPane");
    return browserPane;
    
  }
  
  private bookmarks bookmarks;
  
  protected bookmarks _createBookmarksEntity() throws NameDuplicationException, IllegalActionException {
    bookmarks bookmarks = new bookmarks(this, "bookmarks");
    return bookmarks;
    
  }
  
  private bookmarksList bookmarksList;
  
  protected bookmarksList _createBookmarksListEntity() throws NameDuplicationException, IllegalActionException {
    bookmarksList bookmarksList = new bookmarksList(this, "bookmarksList");
    return bookmarksList;
    
  }
  
  private addBookmarksButtonValve addBookmarksButtonValve;
  
  protected addBookmarksButtonValve _createAddBookmarksButtonValveEntity() throws NameDuplicationException, IllegalActionException {
    addBookmarksButtonValve addBookmarksButtonValve = new addBookmarksButtonValve(this, "addBookmarksButtonValve");
    return addBookmarksButtonValve;
    
  }
  
  private removeBookmarksButtonValve removeBookmarksButtonValve;
  
  protected removeBookmarksButtonValve _createRemoveBookmarksButtonValveEntity() throws NameDuplicationException, IllegalActionException {
    removeBookmarksButtonValve removeBookmarksButtonValve = new removeBookmarksButtonValve(this, "removeBookmarksButtonValve");
    return removeBookmarksButtonValve;
    
  }
  
  private relations0 relations0;
  
  protected relations0 _createRelations0Entity() throws NameDuplicationException, IllegalActionException {
    relations0 relations0 = new relations0(this, "relations0");
    return relations0;
    
  }
  
  public Browser(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
    super(parent, name);
    this.location = _createLocationEntity();
    this.locationText = _createLocationTextEntity();
    this.string2Url = _createString2UrlEntity();
    this.browserPane = _createBrowserPaneEntity();
    this.bookmarks = _createBookmarksEntity();
    this.bookmarksList = _createBookmarksListEntity();
    this.addBookmarksButtonValve = _createAddBookmarksButtonValveEntity();
    this.removeBookmarksButtonValve = _createRemoveBookmarksButtonValveEntity();
    this.relations0 = _createRelations0Entity();
    TypedIORelation r1 = new TypedIORelation(this, "r1");
    this.location.getPort("value").link(r1);
    this.relations0.getPort("input").link(r1);
    TypedIORelation relations0 = new TypedIORelation(this, "relations0");
    this.relations0.getPort("output").link(relations0);
    this.locationText.getPort("systemOutput").link(relations0);
    this.browserPane.getPort("systemOutput").link(r1);
    TypedIORelation r3 = new TypedIORelation(this, "r3");
    this.string2Url.getPort("output").link(r3);
    this.location.getPort("setValue").link(r3);
    TypedIORelation r4 = new TypedIORelation(this, "r4");
    this.locationText.getPort("userInput").link(r4);
    this.string2Url.getPort("input").link(r4);
    TypedIORelation r5 = new TypedIORelation(this, "r5");
    this.browserPane.getPort("userInput").link(r5);
    this.location.getPort("setValue").link(r5);
    TypedIORelation r6 = new TypedIORelation(this, "r6");
    this.bookmarks.getPort("value").link(r6);
    this.bookmarksList.getPort("systemOutput").link(r6);
    TypedIORelation r7 = new TypedIORelation(this, "r7");
    this.bookmarksList.getPort("userInput").link(r7);
    this.location.getPort("setValue").link(r7);
    this.addBookmarksButtonValve.getPort("input").link(r1);
    TypedIORelation r9 = new TypedIORelation(this, "r9");
    this.addBookmarksButtonValve.getPort("output").link(r9);
    this.bookmarks.getPort("add").link(r9);
    this.removeBookmarksButtonValve.getPort("input").link(r7);
    TypedIORelation r11 = new TypedIORelation(this, "r11");
    this.removeBookmarksButtonValve.getPort("output").link(r11);
    this.bookmarks.getPort("remove").link(r11);
    
  }
  
  public Browser(final CompositeEntity parent) throws NameDuplicationException, IllegalActionException {
    this(parent, "browser");
    
  }
}
