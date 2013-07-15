# Browser example #

In this example, an actor network implements the behavior of a Swing interface, containing a location text field, browser panel and bookmarks list. If you type a valid URL in the location text field and press the Go button, the browser panel will load the URL. If you navigate in the browser panel, the location text is update appropriately. The current URL may be added to the bookmarks list. Clicking a bookmark opens it.

* `browser.xactor` - the main actor network
* `swing.xactor` - actor wrappers for Swing components
* `util.xactor` - utility actors that are generally useful for user interface behavior
* `browser.xml` - the Swixml file describing the composition of Swing components, their properties and layout

To launch this example, create a launch configuration with `org.ptolemy.xtext.tests` as the project name, `org.ptolemy.xtext.browser.Browser` as the actor class, `ptolemy.domains.de.kernel.DEDirector` as director class, `org.ptolemy.xtext.launch.swixml.SwixmlResource` as the resource class and the full path of `browser.xml` as the resource path. 
