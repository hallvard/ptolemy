# The ptolemy repository

This repository contains plugin projects that together implement models, editors and code generators for the Cal language and ptolemy framework:
* org.ptolemy.ecore - the ptolemy ecore model project used by editors and code generator
* org.ptolemy.xtext and org.ptolemy.xtext.ui - the Cal language implementation based on Xtext, with a code generator for the ptolemy framework

* org.ptolemy.jars - a plugin wrapper for the ptolemy jars (core and several domains), i.e. the ptolemy runtime platform
* org.ptolemy.xtext.lib - an extension of the ptolemy runtime platform, to support the Cal language implementation

* org.ptolemy.xtext.launch - launcher support, configuration, tab/tab group and delegate

* org.ptolemy.graphiti.generic - a generic graphical editor for actor networks
* org.ptolemy.graphiti.generic.kieler - support for Kieler-based layout in the generic editor

* org.ptolemy.graphiti - the generic editor adapted to the ptolemy ecore model
* org.caltoopia.graphiti - the generic editor adapted to the caltoopia ecore model

* org.ptolemy.xtext.tests - tests and examples

The plugins are detailed below, after instructions on how to install and try it out.

# Installation

The ecore model depends on the EMF framework, the textual Cal implementation depends on Xtext (2.4, including Xbase and Xtend) and MWE2 (2.4, language and runtime), and the graphical editor depends on Graphiti (0.10), with an optional dependency on the KIELER layout engine (0.8). The versions for EMF, Xtext and MWE2 correspond to the Kepler release, so it's easiest to install the modeling edition of Kepler and use its update site for installing Xtext, MWE2 and Graphiti. To use the KIELER layout engine, install KIELER Layout for Graphiti from http://rtsys.informatik.uni-kiel.de/~kieler/updatesite/.

Since there isn't (yet) an update site for our editors and code generator, you have to
1. clone this repository,
2. import the source of all the plugin projects into your Eclipse workspace and
3. launch a second Eclipse, to try them out.
If you only want to try the graphical editor with Caltoopia, you should clone the caltoopia repository from https://github.com/Caltoopia/caltoopia and (at least) import the org.ptolemy.graphiti.generic and org.caltoopia.graphiti plugin projects.

# Trying the editors and code generator

To try the editors and code generator you must build and launch a second Eclipse using Run as->Eclipse Application. If this option is not available, you must create the run configuration manually by using Run configurations... To improve performance, you may have to add some VM arguments, I use `-XX:MaxPermSize=256m`, `-Xms1024m` and `-Xmx2048m`. You can either create a Java project and an xactor file using the New wizard or import the org.ptolemy.xtext.tests project from the development workspace into the runtime workspace, and play with the examples in the tests source folder.

There is support for launching the ptolemy runtime with specific actor and director classes. The actor class will typically be generated from a network in an xactor file. The launcher will wrap an instance of the actor class in a root composite actor with the specified director, and execute this model.

To support opening a user interface from a resource file, you can also specify the name of (subclass of) a `BeanResource` class and a resource path. A `BeanResource` is a ptolemy attribute that initializes by loading java objects from a resource file. Actors in the model may lookup these java objects by their ids or some naming scheme. A special `BeanResource` for loading Swixml resources (http://www.swixml.org/) is provided, so your actor model can interact with a Swing interface.

## Examples ##

### Browser in org.ptolemy.xtext.tests/tests/org.ptolemy.xtext.browser ###

In this example, an actor network implements the behavior of a Swing interface, containing a location text field, browser panel and bookmarks list. If you type a valid URL in the location text field and press the Go button, the browser panel will load the URL. If you navigate in the browser panel, the location text is update appropriately. The current URL may be added to the bookmarks list. Clicking a bookmark opens it.

* `browser.xactor` - the main actor network
* `swing.xactor` - actor wrappers for Swing components
* `util.xactor` - utility actors that are generally useful for user interface behavior
* `browser.xml` - the Swixml file describing the composition of Swing components, their properties and layout

To launch this example, create a launch configuration with `org.ptolemy.xtext.tests` as the project name, `org.ptolemy.xtext.browser.Browser` as the actor class, `ptolemy.domains.de.kernel.DEDirector` as director class, `org.ptolemy.xtext.launch.swixml.SwixmlResource` as the resource class and the full path of `browser.xml` as the resource path. 

# org.ptolemy.ecore - the ptolemy ecore model project used by editors and code generator

# org.ptolemy.xtext and org.ptolemy.xtext.ui - the Cal language implementation based on Xtext, with a code generator for the ptolemy framework
# org.ptolemy.jars - a plugin wrapper for the ptolemy jars (core and several domains), i.e. the ptolemy runtime platform
# org.ptolemy.xtext.lib - an extension of the ptolemy runtime platform, to support the Cal language implementation

# org.ptolemy.xtext.launch - launcher support, configuration, tab/tab group and delegate

# org.ptolemy.graphiti.generic - a generic graphical editor for actor networks
# org.ptolemy.graphiti.generic.kieler - support for Kieler-based layout in the generic editor
# org.ptolemy.graphiti - the generic editor adapted to the ptolemy ecore model
# org.caltoopia.graphiti - the generic editor adapted to the caltoopia ecore model

# org.ptolemy.xtext.tests - tests and examples
