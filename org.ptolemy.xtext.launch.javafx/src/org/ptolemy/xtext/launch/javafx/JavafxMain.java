package org.ptolemy.xtext.launch.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import org.ptolemy.xtext.launch.BeanContainerAttributeImpl;
import org.ptolemy.xtext.launch.PtolemyMain;
import org.ptolemy.xtext.lib.caltrop.RealmHandler;

import ptolemy.actor.CompositeActor;
import ptolemy.actor.Manager;
import ptolemy.kernel.util.KernelException;

import com.sun.javafx.application.PlatformImpl;

public class JavafxMain extends Application {

	static final String JAVAFX_STAGE_KEY = Stage.class.getName().replace('.', '_');
	static final String JAVAFX_KEY = "javafx";

	private RealmHandler realmHandler = new RealmHandler() {
		@Override
		public void realmAsyncExec(Runnable runnable) {
			Platform.runLater(runnable);
		}
		@Override
		public void realmSyncExec(Runnable runnable) {
			PlatformImpl.runAndWait(runnable);
		}
	};

	private Manager manager;
	private CompositeActor model;

	@Override
	public void init() {
		String[] args = getParameters().getRaw().toArray(new String[0]);

		PtolemyMain.main(new PtolemyMain() {
			
			protected CompositeActor setUpModel(Class<?> actorClass) throws Exception {
				JavafxMain.this.model = super.setUpModel(actorClass);
				return model;
			}
			
			protected void execute(final Manager manager) throws KernelException {
				// delay execution until start(Stage) is called
				JavafxMain.this.manager = manager;
			}
		}, args);
	}

	@Override
	public void start(final Stage stage) {
		try {
			BeanContainerAttributeImpl beanContainer = new BeanContainerAttributeImpl(model, "javafxBeanContainer");
			beanContainer.registerBean(JAVAFX_STAGE_KEY, stage);
			beanContainer.registerBean(JAVAFX_KEY, realmHandler);
			manager.startRun();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		if (manager != null) {
			try {
				manager.stop();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				manager = null;
			}
		}
	}

	public static void main(String[] args) {
		Application.launch(JavafxMain.class, args);
	}
}
