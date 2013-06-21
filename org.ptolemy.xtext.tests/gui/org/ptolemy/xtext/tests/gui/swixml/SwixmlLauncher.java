package org.ptolemy.xtext.tests.gui.swixml;

import org.ptolemy.xtext.tests.gui.GuiLauncher;

import ptolemy.actor.TypedCompositeActor;
import ptolemy.data.StringToken;
import ptolemy.data.expr.Parameter;

public class SwixmlLauncher extends GuiLauncher {

	protected String resourceFile;
	
	@Override
	protected TypedCompositeActor setUpModel(Class<?> actorClass) throws Exception {
		TypedCompositeActor model = super.setUpModel(actorClass);
		SwixmlResource swixmlResource = new SwixmlResource(model, "swixmlResource");
		((Parameter) swixmlResource.getAttribute("swixmlResource")).setToken(new StringToken(resourceFile));
		return model;
	}
	
	public static void main(String[] args) {
		try {
			SwixmlLauncher swixmlLauncher = new SwixmlLauncher();
			swixmlLauncher.resourceFile = args[1];
			TypedCompositeActor model = swixmlLauncher.setUpModel(Class.forName(args[0]));
			swixmlLauncher.execute(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
