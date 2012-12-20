package org.ptolemy.graphiti.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IObjectCreationToolEntry;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.IOPortKind;
import org.ptolemy.ecore.actor.TypedAtomicActor;
import org.ptolemy.ecore.caltrop.CaltropFactory;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.graphiti.diagram.features.CreateEntityFeature;
import org.ptolemy.graphiti.diagram.features.CreatePortFeature;
import org.ptolemy.graphiti.editor.ActorDiagramImageProvider;
import org.ptolemy.graphiti.editor.ActorDiagramLibraryProvider;
import org.ptolemy.xtext.ui.internal.XActorActivator;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ActorDiagramToolBehaviorProvider extends DefaultToolBehaviorProvider {

	@Inject
    public ActorDiagramToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
	
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		ICustomFeature[] customFeatures = getDiagramTypeProvider().getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			if (customFeatures[i].canExecute(context)) {
				return customFeatures[i];
			}
		}
		return null;
	}

    @Override
	public IPaletteCompartmentEntry[] getPalette() {
	    IPaletteCompartmentEntry[] superCompartments = super.getPalette();
	    List<IPaletteCompartmentEntry> libraryCompartments = getLibraryCompartments();
	    List<IPaletteCompartmentEntry> allCompartments = new ArrayList<IPaletteCompartmentEntry>(Arrays.asList(superCompartments));
	    allCompartments.addAll(libraryCompartments);
	    return allCompartments.toArray(new IPaletteCompartmentEntry[allCompartments.size()]);
	}

    private EntityContainer<?> defaultLibraryContainer = null;
    
    private EntityContainer<?> getDefaultLibraryContainer() {
    	if (defaultLibraryContainer == null) {
    		defaultLibraryContainer = KernelFactory.eINSTANCE.createEntityContainer();
    		TypedAtomicActor actor1 = ActorFactory.eINSTANCE.createTypedAtomicActor();
    		actor1.getPorts().add(CaltropFactory.eINSTANCE.createTypedInputPort());
    		actor1.getPorts().add(CaltropFactory.eINSTANCE.createTypedOutputPort());
    		actor1.setName("Input1Output1Actor");

    		TypedAtomicActor actor2 = ActorFactory.eINSTANCE.createTypedAtomicActor();
    		actor2.getPorts().add(CaltropFactory.eINSTANCE.createTypedInputPort());
    		actor2.getPorts().add(CaltropFactory.eINSTANCE.createTypedInputPort());
    		actor2.getPorts().add(CaltropFactory.eINSTANCE.createTypedOutputPort());
    		actor1.setName("Input2Output1Actor");

    		defaultLibraryContainer.getEntities().add(actor1);
    		defaultLibraryContainer.getEntities().add(actor2);
    	}
    	return defaultLibraryContainer;
	}

	private List<IPaletteCompartmentEntry> getLibraryCompartments() {
		List<IPaletteCompartmentEntry> compartments = new ArrayList<IPaletteCompartmentEntry>();
		ResourceSet resourceSet = getDiagramTypeProvider().getDiagramEditor().getResourceSet();
		for (Resource resource : resourceSet.getResources()) {
			for (Adapter adapter : resource.eAdapters()) {
				if (adapter instanceof ActorDiagramLibraryProvider) {
					EntityContainer<?> libraryContainer = ((ActorDiagramLibraryProvider) adapter).getLibraryContainer();
					if (libraryContainer != null) {
						addCompartmentEntries(libraryContainer, compartments);
					}
				}
			}
		}
		if (compartments.isEmpty()) {
			addCompartmentEntries(getDefaultLibraryContainer(), compartments);
		}
		return compartments;
	}

	protected void addCompartmentEntries(EntityContainer<?> container, List<IPaletteCompartmentEntry> compartments) {
		PaletteCompartmentEntry compartmentEntry = null;
		if (container instanceof CompositeEntity<?>) {
			compartmentEntry = addEntityCreationToolEntry((CompositeEntity<?>) container, compartmentEntry);
		} else {
			for (Entity<?> entity : container.getEntities()) {
				compartmentEntry = addEntityCreationToolEntry(entity, compartmentEntry);
			}
		}
		if (compartmentEntry != null) {
			compartments.add(compartmentEntry);
		}
		if (container instanceof EntityFolder) {
			compartmentEntry = new PaletteCompartmentEntry(container.getName(), null);
			for (EntityContainer<?> childContainer : ((EntityFolder) container).getEntityContainers()) {
				addCompartmentEntries(childContainer, compartments); // compartmentEntry.addToolEntry(createCompartmentEntry(container));
			}
			compartments.add(compartmentEntry);
		}
	}

	private PaletteCompartmentEntry addEntityCreationToolEntry(Entity<?> entity, PaletteCompartmentEntry compartmentEntry) {
		if (compartmentEntry == null) {
			compartmentEntry = new PaletteCompartmentEntry(entity.getName(), null);
		}
		compartmentEntry.addToolEntry(createEntityCreationToolEntry(entity));
		return compartmentEntry;
	}

	private IObjectCreationToolEntry createEntityCreationToolEntry(Entity<?> entity) {
		String label = entity.getName();
		if (label == null) {
			label = entity.toString();
		}
		CreateEntityFeature createEntityFeature = new CreateEntityFeature(getFeatureProvider(), entity);
		ObjectCreationToolEntry toolEntry = new ObjectCreationToolEntry(label, "Create a " + label, null, null, createEntityFeature);
		return toolEntry;
	}

	@Override
    public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
        IContextButtonPadData padData = super.getContextButtonPad(context);
        ILinkService linkService = Graphiti.getLinkService();
        PictogramElement pe = context.getPictogramElement();
        setGenericContextButtons(padData, pe, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_UPDATE);

        CreateConnectionContext createConnectionContext = null;
        Anchor anchor = null;
        if (pe instanceof Anchor) {
            anchor = (Anchor) pe;
        } else if (pe instanceof AnchorContainer) {
            anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
        }
        if (anchor != null) {
        	createConnectionContext = new CreateConnectionContext();
        	createConnectionContext.setSourcePictogramElement(pe);
        	createConnectionContext.setSourceAnchor(anchor);
        }
        ContextButtonEntry button = new ContextButtonEntry(null, context);
        button.setText("Create connection");
        ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
        for (ICreateConnectionFeature feature : features) {
            if (createConnectionContext != null && feature.isAvailable(createConnectionContext) && feature.canStartConnection(createConnectionContext)) {
            	button.setIconId(ActorDiagramImageProvider.IMG_RELATION);
                button.addDragAndDropFeature(feature);
            }
        }
        if (button.getDragAndDropFeatures().size() > 0) {
           padData.getDomainSpecificContextButtons().add(button);
        }
        if (pe instanceof ContainerShape && linkService.getBusinessObjectForLinkedPictogramElement(pe) instanceof Entity<?>) {
            padData.getDomainSpecificContextButtons().addAll(Arrays.asList(
            		createPortButton((ContainerShape) pe, IOPortKind.INPUT, Boolean.TRUE),
            		createPortButton((ContainerShape) pe, IOPortKind.INPUT, Boolean.FALSE),
            		createPortButton((ContainerShape) pe, IOPortKind.OUTPUT, Boolean.FALSE),
            		createPortButton((ContainerShape) pe, IOPortKind.OUTPUT, Boolean.TRUE)
            ));
        }
        return padData;
//        return super.getContextButtonPad(context);
    }

	private ContextButtonEntry createPortButton(ContainerShape targetContainer, IOPortKind ioKind, Boolean multi) {
		CreateContext createContext = new CreateContext();
		createContext.setTargetContainer(targetContainer);
		CreatePortFeature createPortFeature = findCreatePortFeature(ioKind, multi, createContext);
		if (createPortFeature != null) {
			ContextButtonEntry createPortButton = new ContextButtonEntry(createPortFeature, createContext);
			createPortButton.setText(createPortFeature.getCreateName());
			createPortButton.setDescription(createPortFeature.getCreateDescription());
			createPortButton.setIconId(createPortFeature.getCreateImageId());
			return createPortButton;
		}
		return null;
	}

	private CreatePortFeature findCreatePortFeature(IOPortKind ioKind, Boolean multi, ICreateContext createContext) {
		for (IFeature feature : getFeatureProvider().getCreateFeatures()) {
			if (feature instanceof CreatePortFeature && (createContext == null || feature.canExecute(createContext))) {
				CreatePortFeature createPortFeature = (CreatePortFeature) feature;
				if (createPortFeature.getIoKind() == ioKind && createPortFeature.getMulti() == multi) {
					return createPortFeature;
				}
			}
		}
		return null;
	}
	
	//

	private Injector injector;
	
	protected Injector getInjector() {
		if (injector == null) {
			injector = XActorActivator.getInstance().getInjector(XActorActivator.ORG_PTOLEMY_XTEXT_XACTOR);
		}
		return injector;
	}

	@Override
	public String getToolTip(GraphicsAlgorithm ga) {
	    PictogramElement pe = ga.getPictogramElement();
	    Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
	    if (bo == null) {
	    	return null;
	    }
//	    if (bo instanceof Typeable) {
//			ISerializer serializer = getInjector().getInstance(ISerializer.class);
//			return serializer.serialize((EObject) bo);
//	    }
	    return bo.toString();
	}
}
