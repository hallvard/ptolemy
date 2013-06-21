package org.ptolemy.graphiti.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.graphiti.platform.IDiagramEditor;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.IOPortKind;
import org.ptolemy.ecore.actor.TypedAtomicActor;
import org.ptolemy.ecore.caltrop.CaltropFactory;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.xactor.ActorModel;
import org.ptolemy.ecore.xactor.EntityFolder;
import org.ptolemy.ecore.xactor.ImportDirective;
import org.ptolemy.ecore.xactor.XactorPackage;
import org.ptolemy.graphiti.diagram.features.CreateEntityFeature;
import org.ptolemy.graphiti.diagram.features.CreatePortFeature;
import org.ptolemy.graphiti.diagram.features.editastext.AbstractEditAsTextFeature;
import org.ptolemy.graphiti.diagram.features.editastext.EditAsTextHelper;
import org.ptolemy.graphiti.editor.ActorDiagramImageProvider;
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

    private Collection<EntityContainer<?>> defaultLibraryContainers = null;
    
    private Collection<EntityContainer<?>> getDefaultLibraryContainers() {
		if (defaultLibraryContainers == null) {

    		TypedAtomicActor actor1 = ActorFactory.eINSTANCE.createTypedAtomicActor();
    		actor1.getPorts().add(CaltropFactory.eINSTANCE.createTypedInputPort());
    		actor1.getPorts().add(CaltropFactory.eINSTANCE.createTypedOutputPort());
    		actor1.setName("Input1Output1Actor");

    		TypedAtomicActor actor2 = ActorFactory.eINSTANCE.createTypedAtomicActor();
    		actor2.getPorts().add(CaltropFactory.eINSTANCE.createTypedInputPort());
    		actor2.getPorts().add(CaltropFactory.eINSTANCE.createTypedInputPort());
    		actor2.getPorts().add(CaltropFactory.eINSTANCE.createTypedOutputPort());
    		actor1.setName("Input2Output1Actor");

    		EntityContainer<Port> libraryContainer;
    		libraryContainer = KernelFactory.eINSTANCE.createEntityContainer();
    		libraryContainer.setName("Default library");
    		libraryContainer.getEntities().add(actor1);
    		libraryContainer.getEntities().add(actor2);
    		
    		defaultLibraryContainers = new ArrayList<EntityContainer<?>>();
    		defaultLibraryContainers.add(libraryContainer);
    		actor1.setName("Actors");
    	}
    	return defaultLibraryContainers;
	}
	    
	private List<IPaletteCompartmentEntry> getLibraryCompartments() {
		List<IPaletteCompartmentEntry> compartments = new ArrayList<IPaletteCompartmentEntry>();
		IDiagramEditor diagramEditor = getDiagramTypeProvider().getDiagramEditor();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagramEditor.getDiagramTypeProvider().getDiagram());
		EObject model = EcoreUtil.getRootContainer(bo);
		if (model instanceof ActorModel) {
			IScopeProvider scopeProvider = getDslInjector().getInstance(IScopeProvider.class);
			IQualifiedNameConverter qualifiedNameConverter = getDslInjector().getInstance(IQualifiedNameConverter.class);
			for (ImportDirective importDirective : ((ActorModel) model).getImports()) {
				String qName = importDirective.getImportedNamespace();
				if (qName.endsWith(".*")) {
					qName = qName.substring(0, qName.length() - 2);
				}
				IScope scope = scopeProvider.getScope(model, XactorPackage.eINSTANCE.getEntityFolder_EntityContainers());
				for (IEObjectDescription element : scope.getElements(qualifiedNameConverter.toQualifiedName(qName))) {
					EObject eObject = EcoreUtil.resolve(element.getEObjectOrProxy(), model);
					if (eObject instanceof EntityContainer<?>) {
						addCompartmentEntries((EntityContainer<?>) eObject, compartments);
					}
				}
			}
		}
		if (compartments.isEmpty()) {
			for (EntityContainer<?> entityContainer : getDefaultLibraryContainers()) {
				addCompartmentEntries(entityContainer, compartments);
			}
		}
		return compartments;
	}

	protected void addCompartmentEntries(EntityContainer<?> container, List<IPaletteCompartmentEntry> compartments) {
		if (! (container instanceof CompositeEntity<?>)) {
			IQualifiedNameConverter qualifiedNameConverter = getDslInjector().getInstance(IQualifiedNameConverter.class);
			QualifiedName qName = qualifiedNameConverter.toQualifiedName(container.getFullName());
			if (qName.getSegmentCount() > 2) {
				qName = qName.skipFirst(qName.getSegmentCount() - 2);
			}
			PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry(qualifiedNameConverter.toString(qName), null);
			for (Entity<?> entity : container.getEntities()) {
				compartmentEntry.addToolEntry(createEntityCreationToolEntry(entity));
			}
			compartments.add(compartmentEntry);
		}
	}

	@Inject 
	private Injector editorInjector; 
	
	private IObjectCreationToolEntry createEntityCreationToolEntry(Entity<?> entity) {
		String label = entity.getName();
		if (label == null) {
			label = entity.getDisplayName();
		}
		CreateEntityFeature createEntityFeature = new CreateEntityFeature(getFeatureProvider(), entity, true);
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
        if (pe instanceof ContainerShape && linkService.getBusinessObjectForLinkedPictogramElement(pe) instanceof Entity<?>) {
    		addPortButton((ContainerShape) pe, IOPortKind.INPUT, Boolean.TRUE, domainSpecificContextButtons);
    		addPortButton((ContainerShape) pe, IOPortKind.INPUT, Boolean.FALSE, domainSpecificContextButtons);
    		addPortButton((ContainerShape) pe, IOPortKind.OUTPUT, Boolean.FALSE, domainSpecificContextButtons);
    		addPortButton((ContainerShape) pe, IOPortKind.OUTPUT, Boolean.TRUE, domainSpecificContextButtons);
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

	private void addPortButton(ContainerShape targetContainer, IOPortKind ioKind, Boolean multi, List<IContextButtonEntry> buttonEntries) {
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

	private Injector dslInjector;
	
	protected Injector getDslInjector() {
		if (dslInjector == null) {
			dslInjector = XActorActivator.getInstance().getInjector(XActorActivator.ORG_PTOLEMY_XTEXT_XACTOR);
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
