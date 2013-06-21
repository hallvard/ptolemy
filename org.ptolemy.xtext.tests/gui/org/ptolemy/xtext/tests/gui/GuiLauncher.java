package org.ptolemy.xtext.tests.gui;

import ptolemy.actor.Manager;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.data.BooleanToken;
import ptolemy.data.expr.Parameter;
import ptolemy.domains.de.kernel.DEDirector;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.Entity;
import ptolemy.kernel.util.BasicModelErrorHandler;
import ptolemy.kernel.util.KernelException;

public abstract class GuiLauncher {

    protected boolean stopWhenQueueIsEmpty = false;

    protected boolean synchronizeToRealTime = true;

    protected TypedCompositeActor setUpModel(Class<?> actorClass) throws Exception {
    	TypedCompositeActor model = new TypedCompositeActor();
    	Entity<?> actor = (Entity<?>) actorClass.getConstructor(CompositeEntity.class, String.class).newInstance(model, "actor");
    	DEDirector director = new DEDirector(model, "director");
    	((Parameter) director.getAttribute("stopWhenQueueIsEmpty")).setToken(new BooleanToken(stopWhenQueueIsEmpty));
    	((Parameter) director.getAttribute("synchronizeToRealTime")).setToken(new BooleanToken(synchronizeToRealTime));
    	return model;
    }
    
    protected void execute(TypedCompositeActor model) throws KernelException {
    	model.setModelErrorHandler(new BasicModelErrorHandler());
    	Manager manager = new Manager(model.workspace(), "ActorManager");
    	model.setManager(manager);
    	manager.execute();
    }
}
