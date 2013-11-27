package org.ptolemy.xtext.launch;

import ptolemy.actor.CompositeActor;
import ptolemy.actor.Manager;
import ptolemy.kernel.util.BasicModelErrorHandler;
import ptolemy.kernel.util.KernelException;
import ptolemy.kernel.util.Workspace;

public class PtolemyMain {

    protected CompositeActor setUpModel(Class<?> actorClass) throws Exception {
    	return (CompositeActor) actorClass.getConstructor(Workspace.class).newInstance((Object) null);
    }
    
    protected void execute(CompositeActor model) throws KernelException {
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
    		Class<?> actorClass = (Class<?>) Class.forName(args[0]);
    		CompositeActor model = main.setUpModel(actorClass);
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
