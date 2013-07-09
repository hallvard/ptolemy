package org.ptolemy.xtext.launch;

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

	protected Class<?> resourceClass;
	protected String resourceFile;

    protected TypedCompositeActor setUpModel(Class<?> actorClass, Class<?> directorClass) throws Exception {
    	TypedCompositeActor model = new TypedCompositeActor();
    	Entity<?> actor = (Entity<?>) actorClass.getConstructor(CompositeEntity.class, String.class).newInstance(model, "actor");
    	Director director = (Director) directorClass.getConstructor(CompositeEntity.class, String.class).newInstance(model, "director");
    	((Parameter) director.getAttribute("stopWhenQueueIsEmpty")).setToken(new BooleanToken(stopWhenQueueIsEmpty));
    	((Parameter) director.getAttribute("synchronizeToRealTime")).setToken(new BooleanToken(synchronizeToRealTime));
		if (resourceClass != null && resourceFile != null) {
	    	BeanResource beanResource = (BeanResource) resourceClass.getConstructor(NamedObj.class, String.class).newInstance(model, "beanResource");
			((Parameter) beanResource.getAttribute("resource")).setToken(new StringToken(resourceFile));
		}
    	return model;
    }
    
    protected void execute(TypedCompositeActor model) throws KernelException {
    	model.setModelErrorHandler(new BasicModelErrorHandler());
    	Manager manager = new Manager(model.workspace(), "ActorManager");
    	model.setManager(manager);
    	manager.execute();
    }

	public static void main(String[] args) {
		try {
			Class<?> actorClass = Class.forName(args[0]);
			Class<?> directorClass = Class.forName(args[1]);
			PtolemyMain main = new PtolemyMain();
			if (args.length >= 4) {
				main.resourceClass = Class.forName(args[2]);
				main.resourceFile = args[3];
			}
			TypedCompositeActor model = main.setUpModel(actorClass, directorClass);
			main.execute(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
