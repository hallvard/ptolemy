package org.ptolemy.xtext.launch;

import java.net.MalformedURLException;
import java.net.URL;

import ptolemy.data.expr.StringParameter;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;

public abstract class BeanResource extends BeanContainerAttribute {

    private StringParameter resourceParameter;
    
    public BeanResource(NamedObj container, String name) throws IllegalActionException, NameDuplicationException {
        super(container, name);
        resourceParameter = new StringParameter(this, "resource");
    }

	protected String getResourceParameterString() {
		return Util.getStringParameterValue(resourceParameter);
	}

	protected URL getResourceParameterURL() throws MalformedURLException {
		String resource = Util.getStringParameterValue(resourceParameter);
		return new URL(resource.indexOf(':') > 2 ? resource : "file:" + resource);
	}
}
