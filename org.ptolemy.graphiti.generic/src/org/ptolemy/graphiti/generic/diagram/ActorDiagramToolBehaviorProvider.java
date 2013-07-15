package org.ptolemy.graphiti.generic.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.ptolemy.graphiti.generic.ActorContainerEditModel;
import org.ptolemy.graphiti.generic.ActorEditModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.diagram.features.AbstractCreateActorFeature;
import org.ptolemy.graphiti.generic.diagram.features.CreateActorInstanceFeature;
import org.ptolemy.graphiti.generic.diagram.features.CreatePortFeature;
import org.ptolemy.graphiti.generic.editor.ActorDiagramImageProvider;
import org.ptolemy.graphiti.generic.editor.DslInjectorProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ActorDiagramToolBehaviorProvider extends DefaultToolBehaviorProvider {

	@Inject
	private EntityViewModel entityViewModel;
	
	@Inject(optional=true)
	private ActorContainerEditModel actorContainerEditModel;

	@Inject(optional=true)
	private ActorEditModel actorEditModel;

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

    private Collection<EObject> defaultLibraryContainers = null;
    
    private Collection<EObject> getDefaultLibraryContainers() {
		if (defaultLibraryContainers == null && actorContainerEditModel != null && actorEditModel != null) {
			
			EObject libraryContainer = actorContainerEditModel.createEntity(EntityViewModel.EntityKind.ACTOR_CONTAINER, "Default library", null);
			
    		EObject actor1 = actorContainerEditModel.createEntity(EntityViewModel.EntityKind.ATOMIC_ACTOR, "Input1Output1Actor", libraryContainer);
    		actorEditModel.createPort(ActorViewModel.PortKind.INPUT, "input", actor1);
    		actorEditModel.createPort(ActorViewModel.PortKind.OUTPUT, "output", actor1);

    		EObject actor2 = actorContainerEditModel.createEntity(EntityViewModel.EntityKind.ATOMIC_ACTOR, "Input2Output1Actor", libraryContainer);
    		actorEditModel.createPort(ActorViewModel.PortKind.INPUT, "input1", actor2);
    		actorEditModel.createPort(ActorViewModel.PortKind.INPUT, "input2", actor2);
    		actorEditModel.createPort(ActorViewModel.PortKind.OUTPUT, "output", actor2);

    		defaultLibraryContainers = new ArrayList<EObject>();
    		defaultLibraryContainers.add(libraryContainer);
    	}
    	return defaultLibraryContainers;
	}
	    
	private List<IPaletteCompartmentEntry> getLibraryCompartments() {
		List<IPaletteCompartmentEntry> compartments = new ArrayList<IPaletteCompartmentEntry>();
		DiagramBehavior diagramBehavior = (DiagramBehavior) getDiagramTypeProvider().getDiagramBehavior();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagramBehavior.getDiagramTypeProvider().getDiagram());
		EObject model = EcoreUtil.getRootContainer(bo);
		// assume only the root can contain imports
		if (entityViewModel.isEntity(model, EntityViewModel.EntityKind.ACTOR_CONTAINER) && model.eContainer() == null) {
			IScopeProvider scopeProvider = getDslInjector().getInstance(IScopeProvider.class);
			IQualifiedNameConverter qualifiedNameConverter = getDslInjector().getInstance(IQualifiedNameConverter.class);
//			for (ImportDirective importDirective : ((ActorModel) model).getImports()) {
//				String qName = importDirective.getImportedNamespace();
//				if (qName.endsWith(".*")) {
//					qName = qName.substring(0, qName.length() - 2);
//				}
//				IScope scope = scopeProvider.getScope(model, XactorPackage.eINSTANCE.getEntityFolder_EntityContainers());
//				for (IEObjectDescription element : scope.getElements(qualifiedNameConverter.toQualifiedName(qName))) {
//					EObject eObject = EcoreUtil.resolve(element.getEObjectOrProxy(), model);
//					if (eObject instanceof EntityContainer<?>) {
//						addCompartmentEntries((EntityContainer<?>) eObject, compartments);
//					}
//				}
//			}
		}
		if (compartments.isEmpty()) {
			for (EObject entityContainer : getDefaultLibraryContainers()) {
				addCompartmentEntries(entityContainer, compartments);
			}
		}
		return compartments;
	}

	protected void addCompartmentEntries(EObject container, List<IPaletteCompartmentEntry> compartments) {
		if (! entityViewModel.isEntity(container, EntityViewModel.EntityKind.COMPOSITE_ACTOR)) {
			IQualifiedNameConverter qualifiedNameConverter = getDslInjector().getInstance(IQualifiedNameConverter.class);
			QualifiedName qName = qualifiedNameConverter.toQualifiedName(entityViewModel.getQualifiedEntityName(container));
			if (qName.getSegmentCount() > 2) {
				qName = qName.skipFirst(qName.getSegmentCount() - 2);
			}
			PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry(qualifiedNameConverter.toString(qName), null);
			for (EObject entity : actorContainerEditModel.getEntities(container)) {
				compartmentEntry.addToolEntry(createEntityCreationToolEntry(entity));
			}
			compartments.add(compartmentEntry);
		}
	}

	@Inject 
	private Injector editorInjector; 
	
	private IObjectCreationToolEntry createEntityCreationToolEntry(EObject actor) {
		String label = entityViewModel.getName(actor);
		AbstractCreateActorFeature createEntityFeature = new CreateActorInstanceFeature(getFeatureProvider(), entityViewModel.getName(actor), actor);
		editorInjector.injectMembers(createEntityFeature);
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
        List<IContextButtonEntry> domainSpecificContextButtons = padData.getDomainSpecificContextButtons();
        if (pe instanceof ContainerShape && entityViewModel.isEntity(linkService.getBusinessObjectForLinkedPictogramElement(pe), null)) {
    		addPortButton((ContainerShape) pe, ActorViewModel.PortKind.INPUT, Boolean.TRUE, domainSpecificContextButtons);
    		addPortButton((ContainerShape) pe, ActorViewModel.PortKind.INPUT, Boolean.FALSE, domainSpecificContextButtons);
    		addPortButton((ContainerShape) pe, ActorViewModel.PortKind.OUTPUT, Boolean.FALSE, domainSpecificContextButtons);
    		addPortButton((ContainerShape) pe, ActorViewModel.PortKind.OUTPUT, Boolean.TRUE, domainSpecificContextButtons);
        }
        ContextButtonEntry button = new ContextButtonEntry(null, context);
        button.setText("Create connection");
        for (ICreateConnectionFeature feature : getFeatureProvider().getCreateConnectionFeatures()) {
        	if (createConnectionContext != null && feature.isAvailable(createConnectionContext) && feature.canStartConnection(createConnectionContext)) {
        		button.setIconId(ActorDiagramImageProvider.IMG_RELATION);
        		button.addDragAndDropFeature(feature);
        	}
        }
        if (button.getDragAndDropFeatures().size() > 0) {
        	domainSpecificContextButtons.add(button);
        }
        return padData;
//        return super.getContextButtonPad(context);
    }

	private void addPortButton(ContainerShape targetContainer, ActorViewModel.PortKind ioKind, Boolean multi, List<IContextButtonEntry> buttonEntries) {
		CreateContext createContext = new CreateContext();
		createContext.setTargetContainer(targetContainer);
		CreatePortFeature createPortFeature = findCreatePortFeature(ioKind, multi, createContext);
		if (createPortFeature != null) {
			ContextButtonEntry createPortButton = new ContextButtonEntry(createPortFeature, createContext);
			createPortButton.setText(createPortFeature.getCreateName());
			createPortButton.setDescription(createPortFeature.getCreateDescription());
			createPortButton.setIconId(createPortFeature.getCreateImageId());
			buttonEntries.add(createPortButton);
		}
	}

	private CreatePortFeature findCreatePortFeature(ActorViewModel.PortKind ioKind, Boolean multi, ICreateContext createContext) {
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

	@Inject
	private DslInjectorProvider injectorProvider;

	private Injector dslInjector;
	
	protected Injector getDslInjector() {
		if (dslInjector == null) {
			dslInjector = injectorProvider.getDslInjector();
		}
		return dslInjector;
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
