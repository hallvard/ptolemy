package org.ptolemy.graphiti.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.diagram.features.CreateNoteFeature;
import org.ptolemy.graphiti.diagram.features.CreatePortFeature;
import org.ptolemy.graphiti.diagram.features.CreateRelationFeature;
import org.ptolemy.graphiti.diagram.features.EntityFolderDrillDownFeature;
import org.ptolemy.graphiti.diagram.features.LinkReconnectionFeature;
import org.ptolemy.graphiti.diagram.features.MovePortFeature;
import org.ptolemy.graphiti.diagram.features.editastext.AbstractEditAsTextFeature;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ActorDiagramFeatureProvider extends DefaultFeatureProvider {

	@Inject
	public ActorDiagramFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Inject @Named("Entity")			private ICreateFeature createActorFeature;
	@Inject @Named("EntityContainer")	private ICreateFeature createEntityFolderFeature;

	@Inject @Named("single-input") 	private CreatePortFeature createSingleInputPortFeature;
	@Inject @Named("multi-input")	private CreatePortFeature createMultiInputPortFeature;
	@Inject @Named("single-output")	private CreatePortFeature createSingleOutputPortFeature;
	@Inject @Named("multi-output")	private CreatePortFeature createMultiOutputPortFeature;

	@Inject
	private CreateNoteFeature createNoteFeature;

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] {
				createEntityFolderFeature,
				createActorFeature,
				createSingleInputPortFeature, createMultiInputPortFeature,
				createSingleOutputPortFeature, createMultiOutputPortFeature,
				createNoteFeature,
		};
	}

	@Inject
	private CreateRelationFeature createRelationFeature;

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {
				createRelationFeature,
		};
	}

	@Override
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		return getCreateConnectionFeatures();
	}

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new LinkReconnectionFeature(this);
	}

	@Inject @Named("EntityContainer")	private IAddFeature addEntityContainerFeature;
	@Inject @Named("Entity")			private IAddFeature addEntityFeature;
	@Inject @Named("Port")				private IAddFeature addPortFeature;
	@Inject @Named("Relation")			private IAddFeature addRelationFeature;
	@Inject @Named("Note")				private IAddFeature addNoteFeature;
	@Inject @Named("Image")				private IAddFeature addImageFeature;

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (addNoteFeature.canAdd(context)) {
			return addNoteFeature;
		} else if (addImageFeature.canAdd(context)) {
			return addImageFeature;
		} else if (addEntityContainerFeature.canAdd(context)) {
			return addEntityContainerFeature;
		} else if (addEntityFeature.canAdd(context)) {
			return addEntityFeature;
		} else if (addPortFeature.canAdd(context)) {
			return addPortFeature;
		} else if (addRelationFeature.canAdd(context)) {
			return addRelationFeature;
		}
		return super.getAddFeature(context);
	}

	@Inject @Named("EntityFolder")		private IUpdateFeature updateEntityFolderFeature;
	@Inject @Named("EntityContainer")	private IUpdateFeature updateEntityContainerFeature;
	@Inject @Named("Entity")			private IUpdateFeature updateEntityFeature;
	@Inject @Named("Port")				private IUpdateFeature updatePortFeature;

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		if (updateEntityFolderFeature.canUpdate(context)) {
			return updateEntityFolderFeature;
		} else if (updateEntityContainerFeature.canUpdate(context)) {
			return updateEntityContainerFeature;
		} else if (updateEntityFeature.canUpdate(context)) {
			return updateEntityFeature;
		} else if (updatePortFeature.canUpdate(context)) {
			return updatePortFeature;
		}
		return super.getUpdateFeature(context);
	}

	@Inject @Named("EntityContainer")	private ILayoutFeature layoutEntityContainerFeature;
	@Inject @Named("Entity")			private ILayoutFeature layoutEntityFeature;
	@Inject @Named("Port")				private ILayoutFeature layoutPortFeature;

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		if (layoutEntityContainerFeature.canLayout(context)) {
			return layoutEntityContainerFeature;
		} else if (layoutEntityFeature.canLayout(context)) {
			return layoutEntityFeature;
		} else if (layoutPortFeature.canLayout(context)) {
			return layoutPortFeature;
		}
		return super.getLayoutFeature(context);
	}

	@Inject @Named("IEntity")	private IDirectEditingFeature directEditIEntityFeature;
	@Inject @Named("Note")		private IDirectEditingFeature directEditNoteFeature;

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (bo instanceof IEntity<?>) {
			return directEditIEntityFeature;
		} else if (bo instanceof AbstractText) {
			return directEditNoteFeature;
		}
		return super.getDirectEditingFeature(context);
	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (bo instanceof Port) {
			return new MovePortFeature(this);
		}
		return super.getMoveShapeFeature(context);
	}

	@Inject @Named("Entity")	private ICopyFeature copyEntityFeature;

	@Override
	public ICopyFeature getCopyFeature(ICopyContext context) {
		if (copyEntityFeature.canCopy(context)) {
			return copyEntityFeature;
		}
		return super.getCopyFeature(context);
	}

	@Inject @Named("IEntity")	private IPasteFeature pasteEntityFeature;

	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		if (pasteEntityFeature.canPaste(context)) {
			return pasteEntityFeature;
		}
		return super.getPasteFeature(context);
	}

	@Inject @Named("IEntity")	private IRemoveFeature removeIEntityFeature;
	@Inject @Named("Port")		private IRemoveFeature removePortFeature;
	@Inject @Named("Relation")	private IRemoveFeature removeRelationFeature;

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		if (removePortFeature.canRemove(context)) {
			return removePortFeature;
		} else if (removeRelationFeature.canRemove(context)) {
			return removeRelationFeature;
		} else if (removeIEntityFeature.canRemove(context)) {
			return removeIEntityFeature;
		}
		return super.getRemoveFeature(context);
	}

	@Inject @Named("IEntity")	private IDeleteFeature deleteIEntityFeature;
	@Inject @Named("Port")		private IDeleteFeature deletePortFeature;
	@Inject @Named("Relation")	private IDeleteFeature deleteRelationFeature;

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		if (deletePortFeature.canDelete(context)) {
			return deletePortFeature;
		} else if (deleteRelationFeature.canDelete(context)) {
			return deleteRelationFeature;
		} else if (deleteIEntityFeature.canDelete(context)) {
			return deleteIEntityFeature;
		}
		return super.getDeleteFeature(context);
	}

	@Inject
	private EntityFolderDrillDownFeature entityFolderDrillDownFeature;

	@Inject @Named("Port")
	private AbstractEditAsTextFeature editPortAsTextFeature;

	@Inject @Named("AtomicActor")
	private AbstractEditAsTextFeature editAtomicActorAsTextFeature;

//	@Inject
//	private DoubleClickCreateFeature doubleClickCreateFeature;

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		// the first executable one will also be used as double-click feature
		return new ICustomFeature[]{
			entityFolderDrillDownFeature,
//			doubleClickCreateFeature
			editPortAsTextFeature,
			editAtomicActorAsTextFeature,
		};
	}
}
