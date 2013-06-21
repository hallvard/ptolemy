package org.ptolemy.graphiti.diagram.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.actor.AbstractTypedIOPort;
import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.IOPort;
import org.ptolemy.ecore.actor.IOPortKind;
import org.ptolemy.ecore.actor.JvmTypedObj;
import org.ptolemy.ecore.actor.TypedAtomicActor;
import org.ptolemy.ecore.actor.TypedCompositeActor;
import org.ptolemy.ecore.caltrop.CaltropFactory;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.graphiti.actordiagram.util.UniqueNameProvider;
import org.ptolemy.graphiti.editor.ActorDiagramImageProvider;

import com.google.inject.Inject;

public class CreatePortFeature extends AbstractCreateFeature {

	private IOPortKind ioKind = null;
	private Boolean multi;

	@Inject
	public CreatePortFeature(IFeatureProvider fp) {
		super(fp, "Port", "Create Port");
	}

	public CreatePortFeature(IFeatureProvider fp, IOPortKind ioKind, Boolean multi) {
		super(fp, getPortText(ioKind, multi), "Create " + getPortText(ioKind, multi));
		this.ioKind = ioKind;
		this.multi = multi;
	}

	public IOPortKind getIoKind() {
		return ioKind;
	}

	public Boolean getMulti() {
		return multi;
	}

	public static String getPortText(IOPortKind ioKind, Boolean multi) {
		return (Boolean.TRUE.equals(multi) ? "multi " : "") + (ioKind != null ? ioKind.getName().toLowerCase() + " " : "") + "port";
	}

	@Override
	public String getCreateImageId() {
		return ActorDiagramImageProvider.getPortImageId(getIoKind(), getMulti());
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		EObject modelObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());
		//		System.out.println("CreatePortFeature.canCreate: modelObject=" + modelObject);
		return modelObject instanceof TypedAtomicActor || modelObject instanceof TypedCompositeActor;
	}

	protected AbstractTypedIOPort createPort() {
		if (ioKind == IOPortKind.INPUT) {
			return CaltropFactory.eINSTANCE.createTypedInputPort();
		} else if (ioKind == IOPortKind.OUTPUT) {
			return CaltropFactory.eINSTANCE.createTypedOutputPort();
		} else {
			return ActorFactory.eINSTANCE.createTypedIOPort();
		}
	}

	protected void configurePort(AbstractTypedIOPort port, ICreateContext context) {
		IOPortKind ioKind = this.ioKind;
		if (port instanceof IOPort) {
			IOPort ioPort = (IOPort) port;
			if (ioPort.getIoKind() == IOPortKind.UNSPECIFIED) {
				if (ioKind == null) {
					int x = context.getX(); // , y = context.getY();
					GraphicsAlgorithm parentGa = context.getTargetContainer().getGraphicsAlgorithm();
					int width = parentGa.getWidth(); // , height = parentShape.getHeight();
					if (x < width / 3) {
						ioKind = IOPortKind.INPUT;
					} else if (x > width * 2 / 3) {
						ioKind = IOPortKind.OUTPUT;
					}
				}
				ioPort.setIoKind(ioKind);
			}
		}
		if (multi != null) {
			port.setMultiport(multi);
		}
	}

	@Inject
	private JvmTypesBuilder typesBuilder;

	protected void configurePortType(JvmTypedObj typed, EObject context) {
		if (typed.getType() == null) {
			JvmTypeReference typeRef = typesBuilder.newTypeRef(context, Object.class);
			typed.setType(typeRef);
		}
	}
	
	@Inject
	private UniqueNameProvider uniqueNameProvider;
	
	protected void configurePortName(Port port, EObject context) {
		String name = port.getName();
		String prefix = null;
		if (name == null) {
			if (port instanceof AbstractIOPort) {
				AbstractIOPort ioPort = (AbstractIOPort) port;
				prefix = (ioPort.isInput() && ioPort.isOutput() ? "io" : (ioPort.isInput() ? "input" : (ioPort.isOutput() ? "output" : "port")));
			}
		} else if (! uniqueNameProvider.isUsed(context, name)) {
			prefix = name;
		}
		port.setName(uniqueNameProvider.getUniqueName(context, prefix));
	}
	
	public Object[] create(ICreateContext context) {
		Entity<AbstractTypedIOPort> parent = (Entity<AbstractTypedIOPort>) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());

		AbstractTypedIOPort newPort = createPort();
		configurePort(newPort, context);
		configurePortName(newPort, parent);
		configurePortType(newPort, parent);
		parent.getPorts().add(newPort);

		addGraphicalRepresentation(context, newPort);

		return new Object[]{newPort};
	}
	
	public static class SingleInput extends CreatePortFeature {
		@Inject
		public SingleInput(IFeatureProvider fp) {
			super(fp, IOPortKind.INPUT, Boolean.FALSE);
		}
	}
	public static class MultiInput extends CreatePortFeature {
		@Inject
		public MultiInput(IFeatureProvider fp) {
			super(fp, IOPortKind.INPUT, Boolean.TRUE);
		}
	}
	public static class SingleOutput extends CreatePortFeature {
		@Inject
		public SingleOutput(IFeatureProvider fp) {
			super(fp, IOPortKind.OUTPUT, Boolean.FALSE);
		}
	}
	public static class MultiOutput extends CreatePortFeature {
		@Inject
		public MultiOutput(IFeatureProvider fp) {
			super(fp, IOPortKind.OUTPUT, Boolean.TRUE);
		}
	}
}
