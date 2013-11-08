package org.ptolemy.xtext.tests.junit;

import junit.framework.TestCase;
import ptolemy.actor.Director;
import ptolemy.actor.Manager;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.data.IntToken;
import ptolemy.data.expr.Parameter;
import ptolemy.data.type.BaseType;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.Entity;
import ptolemy.kernel.util.BasicModelErrorHandler;

public abstract class AbstractActorsTestCase extends TestCase // implements ExecutionListener
{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	protected TypedCompositeActor setUpTestModel(Class<?> actorClass, Class<? extends Director> directorClass, int iterations) throws Exception {
		TypedCompositeActor parent = new TypedCompositeActor();
		Entity<?> actor = (Entity<?>) actorClass.getConstructor(CompositeEntity.class, String.class).newInstance(parent, "actor");
		Director director = directorClass.getConstructor(CompositeEntity.class, String.class).newInstance(parent, "director");
		((Parameter) director.getAttribute("iterations")).setToken(new IntToken(iterations));
//		Parameter constrainBufferSizes = (Parameter) director.getAttribute("constrainBufferSizes");
//		if (constrainBufferSizes != null) {
//			constrainBufferSizes.setExpression("false");
//		}			
		return parent;
	}

	protected Manager setUpTestModel(TypedCompositeActor parent) throws Exception {
		parent.setModelErrorHandler(new BasicModelErrorHandler());
		Manager manager = new Manager(parent.workspace(), "ActorTestManager");
		parent.setManager(manager);
		return manager;
	}

	protected void testActor(Class<?> actorClass, Class<? extends Director> directorClass, int iterations) throws Exception {
		TypedCompositeActor parent = setUpTestModel(actorClass, directorClass, iterations);
		setUpTestModel(parent).execute();
	}
}
