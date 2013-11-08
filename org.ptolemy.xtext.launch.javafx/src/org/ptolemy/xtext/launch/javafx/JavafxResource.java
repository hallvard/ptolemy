package org.ptolemy.xtext.launch.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.ptolemy.xtext.launch.BeanResource;
import org.ptolemy.xtext.lib.caltrop.AbstractCaltropActor;

import ptolemy.data.ObjectToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

import com.sun.javafx.application.PlatformImpl;

public class JavafxResource extends BeanResource {

    public JavafxResource(NamedObj container, String name) throws IllegalActionException, NameDuplicationException {
        super(container, name);
    }

    private FXMLLoader fxmlLoader = null;

    @Override
    public void initialize() throws IllegalActionException {
    	super.initialize();
		if (Platform.isFxApplicationThread()) {
			loadResourceRunnable.run();
			showContainerRunnable.run();
		} else {
			PlatformImpl.runAndWait(loadResourceRunnable);
			PlatformImpl.runAndWait(showContainerRunnable);
		}
    }

    private Runnable loadResourceRunnable = new Runnable() {
		@Override
		public void run() {
			try {
				URL resourceUrl = getResourceParameterURL();
				loadResource(resourceUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
    
	private Runnable showContainerRunnable = new Runnable() {
		@Override
		public void run() {
			try {
				showContainer(fxmlLoader.<Parent>getRoot());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
    protected Parent loadResource(URL resourceUrl) throws IOException {
    	if (fxmlLoader == null) {
			fxmlLoader = new FXMLLoader(resourceUrl);
    	}
    	System.out.print("Loading " + resourceUrl + "... ");
    	fxmlLoader.load();
        Parent container = fxmlLoader.<Parent>getRoot();
        System.out.println(container);
		return container;
    }

    protected void showContainer(Parent container) throws IllegalActionException {
		Scene scene = new Scene(container);
		Stage stage = AbstractCaltropActor.get(JavafxMain.JAVAFX_STAGE_KEY, Stage.class, getContainer());
		stage.setScene(scene);
		stage.show();
    }
    
    @Override
    public void wrapup() throws IllegalActionException {
        if (fxmlLoader != null) {
        	fxmlLoader = null;
        }
        super.wrapup();
    }

    @Override
    public Object getBean(String idOrPath, Class<?> c) {
    	if (! c.getName().startsWith("javafx.")) {
    		return null;
    	}
        Object bean = getBeanForId(idOrPath);
        if (bean == null) {
            bean = getBeanForPath(idOrPath);
        }
        if ((! c.isInstance(bean)) && bean instanceof Parent) {
        	bean = getChild((Parent) bean, idOrPath, c);
        }
        return bean;
    }
    
	protected Object getBeanForId(String id) {
        Node root = (fxmlLoader != null ? fxmlLoader.<Node>getRoot() : null);
        return (root != null ? root.lookup("#" + id.replace('.', '_')) : null);
    }

    protected Object getBeanForPath(String path) {
        return getBeanForPath(path.split(Pattern.quote(PATH_SEPARATOR)));
    }
    
    protected Object getBeanForPath(String[] path) {
    	Node root = (fxmlLoader != null ? fxmlLoader.<Node>getRoot() : null);
        return (root != null ? getBeanForPath(path, 0, root) : null);
    }
    
    protected Object getBeanForPath(String[] path, int pos, Node context) {
        String name = (String) context.getProperties().get("name");
        if (name == null || name.startsWith("null"));
        else if (path[pos].equals(name) || path[pos].equals(tagName(context))) {
            pos++;
        } else {
            return null;
        }
        if (pos == path.length) {
            return context;
        }
        if (context instanceof Parent) {
        	Parent container = (Parent) context;
            for (Node child : container.getChildrenUnmodifiable()) {
                Object bean = getBeanForPath(path, pos, child);
                if (bean != null) {
                    return bean;
                }
            }
        }
        return null;
    }

    private Object getChild(Parent container, String id, Class<?> c) {
    	for (Node child : container.getChildrenUnmodifiable()) {
    		if ((id == null || id.equals(child.getId())) && ((c == null) || c.isInstance(child))) {
    			return child;
    		} else if (child instanceof Parent) {
    			Object foundChild = getChild((Parent) child, id, c);
    			if (foundChild != null) {
    				return foundChild;
    			}
    		}
    	}
    	return null;
	}

    protected Object tagName(Node context) {
        String tagName = context.getClass().getSimpleName();
        if (tagName.startsWith("J")) {
            tagName = tagName.substring(1);
        }
        return tagName.toLowerCase();
    }
}
