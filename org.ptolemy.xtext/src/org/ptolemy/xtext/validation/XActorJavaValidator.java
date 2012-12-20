package org.ptolemy.xtext.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.validation.Check;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.ActorPackage;
import org.ptolemy.ecore.actor.Typeable;
import org.ptolemy.ecore.caltrop.CaltropPackage;
import org.ptolemy.ecore.caltrop.PortPattern;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.xactor.ActorModel;

public class XActorJavaValidator extends AbstractXActorJavaValidator {

	private void checkType(Typeable typed, String aTypePhrase) {
		if (typed.getInferredType() == null) {
			warning(aTypePhrase + " should have an explicit type or it should be possible to infer it.", ActorPackage.eINSTANCE.getJvmTypedObj_InferredType());
		}
	}
	
	@Check public void checkType(AbstractTypedIOPort port) { checkType(port, "A typed port ");}

	private Pattern nameRegex = Pattern.compile("\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart}*)");
	
	public boolean checkName(String name, boolean warn) {
		if (name == null) {
			if (warn) {
				warning("The name cannot be null", KernelPackage.eINSTANCE.getNamedObj_Name());
			}
			return false;
		} else if (! nameRegex.matcher(name).matches()) {
			if (warn) {
				warning("A name must be a proper Java identifier", KernelPackage.eINSTANCE.getNamedObj_Name());
			}
			return false;
		}
		return true;
	}

	public boolean checkName(Nameable named, boolean warn) {
		return checkName(named.getName(), warn);		
	}

	@Check	public void checkName(Port port) 			{ checkName(port, true);}
	@Check	public void checkName(Entity<?> entity) 	{ checkName(entity, true);}
	@Check	public void checkName(EntityContainer<?> entityContainer) {
		if (entityContainer instanceof ActorModel) {
			String nameParts[] = entityContainer.getName().split(".");
			for (int i = 0; i < nameParts.length; i++) {
				checkName(nameParts[i], true);
			}
		} else {
			checkName(entityContainer, true);
		}
	}

	@Check
	public boolean checkNames(IEntity<?> entity, boolean warn) {
		Collection<String> names = new HashSet<String>();
		Collection<String> duplicates = new ArrayList<String>();
		addNames(entity.getAllAttributes(), names, duplicates); 
		addNames(entity.getAllPorts(), names, duplicates);
		if (entity instanceof EntityContainer<?>) {
			EntityContainer<?> entityContainer = (EntityContainer<?>) entity;
			addNames(entityContainer.getEntities(), names, duplicates); 
			addNames(entityContainer.getRelations(), names, duplicates); 
		}
		if (duplicates.size() > 0) {
			error("Duplicate names: " + duplicates, KernelPackage.eINSTANCE.getNamedObj_Name());
			return false;
		}
		return true;
	}
	
	private void addNames(Iterable<? extends Nameable> nameds, Collection<String> names, Collection<String> duplicates) {
		for (Nameable named : nameds) {
			String name = named.getName();
			if (names.contains(name)) {
				duplicates.add(name);
			}
			names.add(name);
		}
	}

	@Check
	public void checkMultiportPattern(PortPattern portPattern) {
		Port port = portPattern.getPortRef();
		if (port instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) port;
			if (portPattern.getChannels() != null && (! ioPort.isMultiport())) {
				error("Cannot use multi pattern on single port.", CaltropPackage.eINSTANCE.getPortPattern_Channels());
			}
		}
	}
}
