
package org.ptolemy.xtext;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XActorStandaloneSetup extends XActorStandaloneSetupGenerated{

	public static void doSetup() {
		new XActorStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
