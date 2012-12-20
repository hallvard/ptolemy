package org.ptolemy.xtext.scoping;

import java.util.Map;

import org.ptolemy.xtext.lib.Extensions;
import org.ptolemy.xtext.lib.caltrop.ChannelMap;

import com.google.common.collect.Multimap;
import com.google.inject.Singleton;

@Singleton
public class ExtensionClassNameProvider extends org.eclipse.xtext.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider.ExtensionClassNameProvider {

	protected Multimap<Class<?>, Class<?>> simpleComputeExtensionClasses() {
		Multimap<Class<?>, Class<?>> result = super.simpleComputeExtensionClasses();
		
		Class<Extensions> extensionClass = org.ptolemy.xtext.lib.Extensions.class;
		result.put(Iterable.class, extensionClass);
		result.put(String.class, extensionClass);
		result.put(Integer.TYPE, extensionClass);
		result.put(Map.class, extensionClass);
		
		result.put(ChannelMap.class, extensionClass);
		result.put(ptolemy.data.ScalarToken.class, org.ptolemy.xtext.lib.caltrop.tokens.Extensions.class);
		return result;
	}
}
