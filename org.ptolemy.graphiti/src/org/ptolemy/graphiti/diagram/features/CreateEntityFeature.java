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
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;
import org.ptolemy.graphiti.actordiagram.util.UniqueNameProvider;

import com.google.inject.Inject;

public class CreateEntityFeature extends CreateNameableFeature {
 
    protected CreateEntityFeature(IFeatureProvider fp, String name, String description) {
        super(fp, name, description);
    }

    private Entity<?> prototype;
    private boolean inheritFrom = false;
    
    public CreateEntityFeature(IFeatureProvider fp, Entity<?> prototype, boolean inheritFrom) {
    	this(fp, (prototype != null ? prototype.getName() : "Actor"), "Create " + (prototype != null ? prototype.getName() : "Actor"));
    	this.prototype = prototype;
    	this.inheritFrom = inheritFrom;
    }

    @Inject
    public CreateEntityFeature(IFeatureProvider fp) {
    	this(fp, null, false);
    }

	@Override
	protected boolean canCreate(ContainerShape targetContainer, EObject bo) {
		return bo instanceof EntityContainer<?> && (prototype == null || canCreate(prototype));
	}

	boolean canCreate(EObject bo) {
		return bo instanceof Entity<?>;
	}
	
	@Inject
	private UniqueNameProvider uniqueNameProvider; // = new UniqueNameProvider();
	
	protected Entity<?> createActor() {
		Entity<?> entity = null;
		if (prototype != null) {
			if (inheritFrom) {
				entity = (Entity<?>) ActorFactory.eINSTANCE.create(prototype.eClass());
				EntityRef superEntity = ActorFactory.eINSTANCE.createActorRef();
				superEntity.setRef(prototype);
				String prototypeName = prototype.getName();
				entity.setName(Character.toLowerCase(prototypeName.charAt(0)) + prototypeName.substring(1));
				entity.setDisplayName(prototype.getDisplayName());
				entity.setSuperEntity(superEntity);
			} else {
				entity = EcoreUtil.copy(prototype);
			}
		}
		if (entity == null) {
			entity = ActorFactory.eINSTANCE.createTypedAtomicActor();
		}
		return entity;
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
			CreateRelationLinkFeature createRelationFeature = getCreateFeature(CreateRelationLinkFeature.class);
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
        String name = newActor.getName();
		if (name == null) {
        	newActor.setName(name = "actor");
        }
        if (uniqueNameProvider.isUsed(parent, name)) {
			newActor.setName(uniqueNameProvider.getUniqueName(parent, name));
        }
        return newActor;
	}
}
