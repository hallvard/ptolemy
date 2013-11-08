package org.ptolemy.xtext.launch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

public class BeanContainerAttributeImpl extends BeanContainerAttribute {

	public BeanContainerAttributeImpl(NamedObj container, String name) throws IllegalActionException, NameDuplicationException {
		super(container, name);
	}

	private Map<String, Object> beans = new HashMap<String, Object>();
	
	public void registerBean(String idOrPath, Object bean) {
		Object registeredBean = beans.get(idOrPath);
		if (registeredBean instanceof Collection<?>) {
			((Collection<Object>) registeredBean).add(bean);
		} else if (registeredBean != null) {
			beans.put(idOrPath, new ArrayList<Object>(Arrays.asList(registeredBean, bean)));
		} else {
			beans.put(idOrPath, bean);
		}
	}
	
	@Override
	public Object getBean(String idOrPath, Class<?> c) {
		Object bean = beans.get(idOrPath);
		if (bean instanceof Collection<?>) {
			for (Object item : (Collection<?>) bean) {
				if (c.isInstance(item)) {
					return item;
				}
			}
		} else if (c.isInstance(bean)) {
			return bean;
		}
		return null;
	}
}
