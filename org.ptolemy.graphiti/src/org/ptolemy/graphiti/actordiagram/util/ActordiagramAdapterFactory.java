/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.graphiti.actordiagram.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.StyleContainer;
import org.eclipse.graphiti.mm.pictograms.AdvancedAnchor;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.ptolemy.graphiti.actordiagram.ActordiagramPackage;
import org.ptolemy.graphiti.actordiagram.EntityContainerDiagram;
import org.ptolemy.graphiti.actordiagram.EntityContainerShape;
import org.ptolemy.graphiti.actordiagram.EntityShape;
import org.ptolemy.graphiti.actordiagram.LabelShape;
import org.ptolemy.graphiti.actordiagram.ModelShape;
import org.ptolemy.graphiti.actordiagram.PortAnchor;
import org.ptolemy.graphiti.actordiagram.PortShape;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.graphiti.actordiagram.ActordiagramPackage
 * @generated
 */
public class ActordiagramAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActordiagramPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActordiagramAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ActordiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActordiagramSwitch<Adapter> modelSwitch =
		new ActordiagramSwitch<Adapter>() {
			@Override
			public <M> Adapter caseModelShape(ModelShape<M> object) {
				return createModelShapeAdapter();
			}
			@Override
			public Adapter caseLabelShape(LabelShape object) {
				return createLabelShapeAdapter();
			}
			@Override
			public Adapter caseEntityShape(EntityShape object) {
				return createEntityShapeAdapter();
			}
			@Override
			public Adapter caseEntityContainerShape(EntityContainerShape object) {
				return createEntityContainerShapeAdapter();
			}
			@Override
			public Adapter casePortShape(PortShape object) {
				return createPortShapeAdapter();
			}
			@Override
			public Adapter casePortAnchor(PortAnchor object) {
				return createPortAnchorAdapter();
			}
			@Override
			public Adapter caseEntityContainerDiagram(EntityContainerDiagram object) {
				return createEntityContainerDiagramAdapter();
			}
			@Override
			public Adapter casePropertyContainer(PropertyContainer object) {
				return createPropertyContainerAdapter();
			}
			@Override
			public Adapter caseGraphicsAlgorithmContainer(GraphicsAlgorithmContainer object) {
				return createGraphicsAlgorithmContainerAdapter();
			}
			@Override
			public Adapter casePictogramElement(PictogramElement object) {
				return createPictogramElementAdapter();
			}
			@Override
			public Adapter caseAnchorContainer(AnchorContainer object) {
				return createAnchorContainerAdapter();
			}
			@Override
			public Adapter caseShape(Shape object) {
				return createShapeAdapter();
			}
			@Override
			public Adapter caseContainerShape(ContainerShape object) {
				return createContainerShapeAdapter();
			}
			@Override
			public Adapter caseAnchor(Anchor object) {
				return createAnchorAdapter();
			}
			@Override
			public Adapter caseAdvancedAnchor(AdvancedAnchor object) {
				return createAdvancedAnchorAdapter();
			}
			@Override
			public Adapter caseBoxRelativeAnchor(BoxRelativeAnchor object) {
				return createBoxRelativeAnchorAdapter();
			}
			@Override
			public Adapter caseStyleContainer(StyleContainer object) {
				return createStyleContainerAdapter();
			}
			@Override
			public Adapter caseDiagram(Diagram object) {
				return createDiagramAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.EntityShape <em>Entity Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.EntityShape
	 * @generated
	 */
	public Adapter createEntityShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.EntityContainerShape <em>Entity Container Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.EntityContainerShape
	 * @generated
	 */
	public Adapter createEntityContainerShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.PortShape <em>Port Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.PortShape
	 * @generated
	 */
	public Adapter createPortShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.PortAnchor <em>Port Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.PortAnchor
	 * @generated
	 */
	public Adapter createPortAnchorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.EntityContainerDiagram <em>Entity Container Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.EntityContainerDiagram
	 * @generated
	 */
	public Adapter createEntityContainerDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.ModelShape <em>Model Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.ModelShape
	 * @generated
	 */
	public Adapter createModelShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.ptolemy.graphiti.actordiagram.LabelShape <em>Label Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.ptolemy.graphiti.actordiagram.LabelShape
	 * @generated
	 */
	public Adapter createLabelShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.PropertyContainer <em>Property Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.PropertyContainer
	 * @generated
	 */
	public Adapter createPropertyContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.GraphicsAlgorithmContainer <em>Graphics Algorithm Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.GraphicsAlgorithmContainer
	 * @generated
	 */
	public Adapter createGraphicsAlgorithmContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.PictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.PictogramElement
	 * @generated
	 */
	public Adapter createPictogramElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.AnchorContainer <em>Anchor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.AnchorContainer
	 * @generated
	 */
	public Adapter createAnchorContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.Shape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.Shape
	 * @generated
	 */
	public Adapter createShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.ContainerShape <em>Container Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.ContainerShape
	 * @generated
	 */
	public Adapter createContainerShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.Anchor <em>Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.Anchor
	 * @generated
	 */
	public Adapter createAnchorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.AdvancedAnchor <em>Advanced Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.AdvancedAnchor
	 * @generated
	 */
	public Adapter createAdvancedAnchorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor <em>Box Relative Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor
	 * @generated
	 */
	public Adapter createBoxRelativeAnchorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.StyleContainer <em>Style Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.StyleContainer
	 * @generated
	 */
	public Adapter createStyleContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.graphiti.mm.pictograms.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.graphiti.mm.pictograms.Diagram
	 * @generated
	 */
	public Adapter createDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ActordiagramAdapterFactory
