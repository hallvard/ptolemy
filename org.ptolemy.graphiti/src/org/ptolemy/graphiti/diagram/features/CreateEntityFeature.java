package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

import com.google.inject.Inject;

public class CreateEntityFeature extends CreateNameableFeature {
 
    protected CreateEntityFeature(IFeatureProvider fp, String name, String description) {
        super(fp, name, description);
    }

    private Entity<?> prototype;
    
    public CreateEntityFeature(IFeatureProvider fp, Entity<?> prototype) {
    	this(fp, (prototype != null ? prototype.getName() : "Actor"), "Create " + (prototype != null ? prototype.getName() : "Actor"));
    	this.prototype = prototype;
    }

    @Inject
    public CreateEntityFeature(IFeatureProvider fp) {
    	this(fp, null);
    }

	@Override
	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return bo instanceof EntityContainer<?> && (prototype == null || canCreate(prototype));
	}

	boolean canCreate(EObject bo) {
		return bo instanceof Entity<?>;
	}
	
	protected Entity<?> createActor() {
		if (prototype != null) {
			return EcoreUtil.copy(prototype);
		}
		return ActorFactory.eINSTANCE.createTypedAtomicActor();
	}

	private <T> T getCreateFeature(Class<T> c) {
		ICreateFeature[] createFeatures = getFeatureProvider().getCreateFeatures();
		for (int i = 0; i < createFeatures.length; i++) {
			if (c.isInstance(createFeatures[i])) {
				return (T) createFeatures[i];
			}
		}
		return null;
	}
	
	protected void configureActor(Entity<?> entity, EObject context) {
		CreatePortFeature createPortFeature = getCreateFeature(CreatePortFeature.class);
		for (Port port : entity.getPorts()) {
			if (port instanceof JvmTypedObj) {
				createPortFeature.configurePortType((JvmTypedObj) port, context);
			}
		}
		if (entity instanceof EntityContainer<?>) {
			EntityContainer<?> entityContainer = (EntityContainer<?>) entity;
			for (Entity<?> childEntity : entityContainer.getEntities()) {
				configureActor(childEntity, context);
			}
			CreateRelationFeature createRelationFeature = getCreateFeature(CreateRelationFeature.class);
			for (Relation relation : entityContainer.getRelations()) {
				createRelationFeature.configureRelation(relation, context);
			}
		}
	}
	
	@Override
	protected Nameable create(ContainerShape targetContainer, EObject bo) {
		Entity<?> newActor = createActor();
		return create(newActor, targetContainer, bo);
	}
	
	protected Nameable create(Entity<?> newActor, ContainerShape targetContainer, EObject bo) {
		EntityContainer<?> parent = (EntityContainer<?>) bo;
		configureActor(newActor, parent);

        parent.getEntities().add(newActor);
        if (newActor.getName() == null) {
        	newActor.setName("actor");
        }
        return newActor;
	}
}
