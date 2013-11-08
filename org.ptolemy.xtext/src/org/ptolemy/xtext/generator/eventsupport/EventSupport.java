package org.ptolemy.xtext.generator.eventsupport;

import java.util.Collection;

import org.eclipse.xtext.common.types.JvmTypeReference;

public interface EventSupport {
	public boolean isProperty();
	public void addEvents(JvmTypeReference typeRef, String name, Collection<EventData> events);
}
