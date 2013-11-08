package org.ptolemy.xtext.launch;

import java.util.ArrayList;
import java.util.List;

import ptolemy.actor.Director;
import ptolemy.actor.Manager;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.data.BooleanToken;
import ptolemy.data.StringToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.Entity;
import ptolemy.kernel.util.BasicModelErrorHandler;
import ptolemy.kernel.util.KernelException;
import ptolemy.kernel.util.NamedObj;

public class PtolemyMain {

    protected boolean stopWhenQueueIsEmpty = false;
    protected boolean synchronizeToRealTime = true;

	protected List<Class<? extends BeanResource>> resourceClasses = new ArrayList<Class<? extends BeanResource>>();
	protected List<String> resourceFiles = new ArrayList<String>();

    protected TypedCompositeActor setUpModel(Class<?> actorClass, Class<?> directorClass) throws Exception {
    	TypedCompositeActor model = new TypedCompositeActor();
    	Entity<?> actor = null;
    	if (actor == null) {
	    	try {
				actor = (Entity<?>) actorClass.getConstructor(CompositeEntity.class).newInstance(model);
			} catch (Exception e) {
			}
    	}
    	if (actor == null) {
    		try {
    		} catch (Exception e) {
    			actor = (Entity<?>) actorClass.getConstructor(CompositeEntity.class, String.class).newInstance(model, "actor");
    		}
    	}
    	Director director = (Director) directorClass.getConstructor(CompositeEntity.class, String.class).newInstance(model, "director");
    	((Parameter) director.getAttribute("stopWhenQueueIsEmpty")).setToken(new BooleanToken(stopWhenQueueIsEmpty));
    	((Parameter) director.getAttribute("synchronizeToRealTime")).setToken(new BooleanToken(synchronizeToRealTime));
    	for (int i = 0; i < resourceClasses.size(); i++) {
    		Class<? extends BeanResource> resourceClass = resourceClasses.get(i);
    		String resourceFile = resourceFiles.get(i);
    		BeanResource beanResource = (BeanResource) resourceClass.getConstructor(NamedObj.class, String.class).newInstance(model, "beanResource");
    		((Parameter) beanResource.getAttribute("resource")).setToken(new StringToken(resourceFile));
    	}
    	return model;
    }
    
    protected void execute(TypedCompositeActor model) throws KernelException {
    	model.setModelErrorHandler(new BasicModelErrorHandler());
    	Manager manager = new Manager(model.workspace(), "ActorManager");
    	model.setManager(manager);
    	execute(manager);
    }

    protected void execute(Manager manager) throws KernelException {
    	manager.execute();
    }
    
    public static void main(PtolemyMain main, String[] args) {
    	try {
    		Class<?> actorClass = Class.forName(args[0]);
    		Class<?> directorClass = Class.forName(args[1]);
    		for (int i = 2; i < args.length; i += 2) {
    			main.resourceClasses.add((Class<? extends BeanResource>) Class.forName(args[i]));
    			main.resourceFiles.add(args[i + 1]);
    		}
    		TypedCompositeActor model = main.setUpModel(actorClass, directorClass);
    		main.execute(model);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    }

	public static void main(String[] args) {
		main(new PtolemyMain(), args);
	}
}
