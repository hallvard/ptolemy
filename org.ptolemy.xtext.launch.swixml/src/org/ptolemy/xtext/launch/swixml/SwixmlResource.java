package org.ptolemy.xtext.launch.swixml;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import org.ptolemy.xtext.launch.BeanResource;
import org.swixml.SwingEngine;

import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

public class SwixmlResource extends BeanResource {

    public SwixmlResource(NamedObj container, String name) throws IllegalActionException, NameDuplicationException {
        super(container, name);
    }

    private SwingEngine swingEngine = null;

    @Override
    public void initialize() throws IllegalActionException {
        super.initialize();
        if (swingEngine == null) {
        	org.swixml.SwingTagLibrary.getInstance().registerTag( "xtextField", XTextField.class);
        	swingEngine = new SwingEngine(this);
        }
        try {
            Container container = swingEngine.render(getResourceParameterURL());
            if (! (container instanceof Window)) {
                JFrame frame = new JFrame(getResourceParameterString());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(container);
                frame.pack();
                container = frame;
            }
            container.setVisible(true);
        } catch (Exception e) {
            throw new IllegalActionException(this, e, "Couldn't render " + getResourceParameterString());
        }
    }

    @Override
    public void wrapup() throws IllegalActionException {
        if (swingEngine != null) {
            swingEngine.cleanup();
            swingEngine = null;
        }
        super.wrapup();
    }

    @Override
    public Object getBean(String idOrPath, Class<?> c) {
        Object bean = getBeanForId(idOrPath);
        if (bean == null) {
            bean = getBeanForPath(idOrPath);
        }
        return bean;
    }
    
    protected Object getBeanForId(String id) {
        return swingEngine.getIdMap().get(id);
    }

    protected Object getBeanForPath(String path) {
        return getBeanForPath(path.split(Pattern.quote(PATH_SEPARATOR)));
    }
    
    protected Object getBeanForPath(String[] path) {
        return getBeanForPath(path, 0, swingEngine.getRootComponent());
    }
    
    protected Object getBeanForPath(String[] path, int pos, Component context) {
        String name = context.getName();
        if (name == null || name.startsWith("null"));
        else if (path[pos].equals(name) || path[pos].equals(tagName(context))) {
            pos++;
        } else {
            return null;
        }
        if (pos == path.length) {
            return context;
        }
        if (context instanceof Container) {
            Container container = (Container) context;
            Component[] children = container.getComponents();
            for (int i = 0; i < children.length; i++) {
                Object bean = getBeanForPath(path, pos, children[i]);
                if (bean != null) {
                    return bean;
                }
            }
        }
        return null;
    }

    protected Object tagName(Component context) {
        String tagName = context.getClass().getSimpleName();
        if (tagName.startsWith("J")) {
            tagName = tagName.substring(1);
        }
        return tagName.toLowerCase();
    }
}
