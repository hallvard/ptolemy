package org.ptolemy.xtext.launch;

import org.ptolemy.xtext.lib.caltrop.ObjectProvider;

import ptolemy.actor.AbstractInitializableAttribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

public abstract class BeanContainerAttribute extends AbstractInitializableAttribute implements ObjectProvider {

    public static final String PATH_SEPARATOR = ".";

    public BeanContainerAttribute(NamedObj container, String name) throws IllegalActionException, NameDuplicationException {
        super(container, name);
    }
    
    public abstract Object getBean(String idOrPath);
    
    public <T> T get(String id, Class<T> c) {
    	Object bean = getBean(id);
    	return (c.isInstance(bean) ? (T) bean : null);
    }
}
