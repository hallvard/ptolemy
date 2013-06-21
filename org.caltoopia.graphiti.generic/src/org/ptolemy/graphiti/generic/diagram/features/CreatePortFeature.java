package org.ptolemy.graphiti.generic.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.services.Graphiti;
import org.ptolemy.graphiti.generic.ActorEditModel;
import org.ptolemy.graphiti.generic.ActorViewModel;
import org.ptolemy.graphiti.generic.EntityViewModel;
import org.ptolemy.graphiti.generic.editor.ActorDiagramImageProvider;

import com.google.inject.Inject;

public class CreatePortFeature extends AbstractCreateFeature {

	private ActorViewModel.PortKind ioKind = null;
	private Boolean multi;

	@Inject(optional=true)
	private ActorEditModel actorEditModel;
	
	@Inject
	public CreatePortFeature(IFeatureProvider fp) {
		super(fp, "Port", "Create Port");
	}

	public CreatePortFeature(IFeatureProvider fp, ActorViewModel.PortKind ioKind, Boolean multi) {
		super(fp, getPortText(ioKind, multi), "Create " + getPortText(ioKind, multi));
		this.ioKind = ioKind;
		this.multi = multi;
	}

	public ActorViewModel.PortKind getIoKind() {
		return ioKind;
	}

	public Boolean getMulti() {
		return multi;
	}

	public static String getPortText(ActorViewModel.PortKind ioKind, Boolean multi) {
		return (Boolean.TRUE.equals(multi) ? "multi " : "") + (ioKind != null ? ioKind.name().toLowerCase() + " " : "") + "port";
	}

	@Override
	public String getCreateImageId() {
		return ActorDiagramImageProvider.getPortImageId(getIoKind(), getMulti());
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());
		//		System.out.println("CreatePortFeature.canCreate: modelObject=" + modelObject);
		return (actorEditModel != null) && actorEditModel.isEntity(bo, EntityViewModel.EntityKind.ACTOR);
	}

	protected ActorViewModel.PortKind getIOPortKind(ICreateContext context) {
		int x = context.getX(); // , y = context.getY();
		GraphicsAlgorithm parentGa = context.getTargetContainer().getGraphicsAlgorithm();
		int width = parentGa.getWidth(); // , height = parentShape.getHeight();
		if (x < width / 3) {
			return ActorViewModel.PortKind.INPUT;
		} else if (x > width * 2 / 3) {
			return ActorViewModel.PortKind.OUTPUT;
		}
		return ioKind;
	}

	public EObject[] create(ICreateContext context) {
		EObject parent = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());
		ActorViewModel.PortKind ioKind = getIOPortKind(context);
		String name = actorEditModel.getUniqueName(parent, ioKind.name().toLowerCase());
		EObject newPort = actorEditModel.createPort(ioKind, name, parent);
		if (multi != null) {
			actorEditModel.setMultiPort(newPort, multi.booleanValue());
		}
		addGraphicalRepresentation(context, newPort);

		return new EObject[]{newPort};
	}
	
	public static class SingleInput extends CreatePortFeature {
		@Inject
		public SingleInput(IFeatureProvider fp) {
			super(fp, ActorEditModel.PortKind.INPUT, Boolean.FALSE);
		}
	}
	public static class MultiInput extends CreatePortFeature {
		@Inject
		public MultiInput(IFeatureProvider fp) {
			super(fp, ActorEditModel.PortKind.INPUT, Boolean.TRUE);
		}
	}
	public static class SingleOutput extends CreatePortFeature {
		@Inject
		public SingleOutput(IFeatureProvider fp) {
			super(fp, ActorEditModel.PortKind.OUTPUT, Boolean.FALSE);
		}
	}
	public static class MultiOutput extends CreatePortFeature {
		@Inject
		public MultiOutput(IFeatureProvider fp) {
			super(fp, ActorEditModel.PortKind.OUTPUT, Boolean.TRUE);
		}
	}
}
