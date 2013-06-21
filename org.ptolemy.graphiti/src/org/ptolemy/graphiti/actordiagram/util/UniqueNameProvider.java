package org.ptolemy.graphiti.actordiagram.util;

import org.eclipse.emf.ecore.EObject;
import org.ptolemy.ecore.kernel.Nameable;

public class UniqueNameProvider {
	
	public String getUniqueName(EObject container, String prefix) {
//		if (! isUsed(container, prefix)) {
//			return prefix;
//		}
		int count = 1;
		while (isUsed(container, prefix + count)) {
			count++;
		}
		return prefix + count;
	}

	public boolean isUsed(EObject container, String name) {
		for (EObject child : container.eContents()) {
			if (child instanceof Nameable) {
				String childName = ((Nameable) child).getName();
				if (name.equals(childName)) {
					return true;
				}
			}
		}
		return false;
	}
}
