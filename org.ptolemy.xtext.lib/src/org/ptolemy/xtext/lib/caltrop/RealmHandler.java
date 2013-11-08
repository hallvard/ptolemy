package org.ptolemy.xtext.lib.caltrop;

public interface RealmHandler {

	public void realmAsyncExec(Runnable runnable);
	public void realmSyncExec(Runnable runnable);

}
