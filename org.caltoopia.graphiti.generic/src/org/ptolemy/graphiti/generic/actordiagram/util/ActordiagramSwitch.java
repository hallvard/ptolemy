/**
 */
package org.ptolemy.graphiti.generic.actordiagram.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.StyleContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.PlatformGraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.AbstractStyle;
import org.eclipse.graphiti.mm.pictograms.AdvancedAnchor;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.ptolemy.graphiti.generic.actordiagram.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage
 * @generated
 */
public class ActordiagramSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActordiagramPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActordiagramSwitch() {
		if (modelPackage == null) {
			modelPackage = ActordiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ActordiagramPackage.LABEL_SHAPE: {
				LabelShape labelShape = (LabelShape)theEObject;
				T result = caseLabelShape(labelShape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.ENTITY_SHAPE: {
				EntityShape entityShape = (EntityShape)theEObject;
				T result = caseEntityShape(entityShape);
				if (result == null) result = caseContainerShape(entityShape);
				if (result == null) result = caseLabelShape(entityShape);
				if (result == null) result = caseShape(entityShape);
				if (result == null) result = caseAnchorContainer(entityShape);
				if (result == null) result = casePictogramElement(entityShape);
				if (result == null) result = caseGraphicsAlgorithmContainer(entityShape);
				if (result == null) result = casePropertyContainer(entityShape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.ENTITY_CONTAINER_SHAPE: {
				EntityContainerShape entityContainerShape = (EntityContainerShape)theEObject;
				T result = caseEntityContainerShape(entityContainerShape);
				if (result == null) result = caseContainerShape(entityContainerShape);
				if (result == null) result = caseLabelShape(entityContainerShape);
				if (result == null) result = caseShape(entityContainerShape);
				if (result == null) result = caseAnchorContainer(entityContainerShape);
				if (result == null) result = casePictogramElement(entityContainerShape);
				if (result == null) result = caseGraphicsAlgorithmContainer(entityContainerShape);
				if (result == null) result = casePropertyContainer(entityContainerShape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.ENTITY_CONTAINER_DIAGRAM: {
				EntityContainerDiagram entityContainerDiagram = (EntityContainerDiagram)theEObject;
				T result = caseEntityContainerDiagram(entityContainerDiagram);
				if (result == null) result = caseDiagram(entityContainerDiagram);
				if (result == null) result = caseContainerShape(entityContainerDiagram);
				if (result == null) result = caseStyleContainer(entityContainerDiagram);
				if (result == null) result = caseShape(entityContainerDiagram);
				if (result == null) result = caseAnchorContainer(entityContainerDiagram);
				if (result == null) result = casePictogramElement(entityContainerDiagram);
				if (result == null) result = caseGraphicsAlgorithmContainer(entityContainerDiagram);
				if (result == null) result = casePropertyContainer(entityContainerDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.PORT_SHAPE: {
				PortShape portShape = (PortShape)theEObject;
				T result = casePortShape(portShape);
				if (result == null) result = caseShape(portShape);
				if (result == null) result = caseAnchorContainer(portShape);
				if (result == null) result = casePictogramElement(portShape);
				if (result == null) result = caseGraphicsAlgorithmContainer(portShape);
				if (result == null) result = casePropertyContainer(portShape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.PORT_ANCHOR: {
				PortAnchor portAnchor = (PortAnchor)theEObject;
				T result = casePortAnchor(portAnchor);
				if (result == null) result = caseBoxRelativeAnchor(portAnchor);
				if (result == null) result = caseAdvancedAnchor(portAnchor);
				if (result == null) result = caseAnchor(portAnchor);
				if (result == null) result = casePictogramElement(portAnchor);
				if (result == null) result = caseGraphicsAlgorithmContainer(portAnchor);
				if (result == null) result = casePropertyContainer(portAnchor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.PORT_GA: {
				PortGA portGA = (PortGA)theEObject;
				T result = casePortGA(portGA);
				if (result == null) result = casePlatformGraphicsAlgorithm(portGA);
				if (result == null) result = caseGraphicsAlgorithm(portGA);
				if (result == null) result = caseGraphicsAlgorithmContainer(portGA);
				if (result == null) result = caseAbstractStyle(portGA);
				if (result == null) result = casePropertyContainer(portGA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.RELATION_CONNECTION: {
				RelationConnection relationConnection = (RelationConnection)theEObject;
				T result = caseRelationConnection(relationConnection);
				if (result == null) result = caseFreeFormConnection(relationConnection);
				if (result == null) result = caseConnection(relationConnection);
				if (result == null) result = caseAnchorContainer(relationConnection);
				if (result == null) result = casePictogramElement(relationConnection);
				if (result == null) result = caseGraphicsAlgorithmContainer(relationConnection);
				if (result == null) result = casePropertyContainer(relationConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActordiagramPackage.RELATION_SHAPE: {
				RelationShape relationShape = (RelationShape)theEObject;
				T result = caseRelationShape(relationShape);
				if (result == null) result = caseShape(relationShape);
				if (result == null) result = caseAnchorContainer(relationShape);
				if (result == null) result = casePictogramElement(relationShape);
				if (result == null) result = caseGraphicsAlgorithmContainer(relationShape);
				if (result == null) result = casePropertyContainer(relationShape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabelShape(LabelShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityShape(EntityShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Container Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Container Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityContainerShape(EntityContainerShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortShape(PortShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortAnchor(PortAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port GA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port GA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortGA(PortGA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationConnection(RelationConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationShape(RelationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Container Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Container Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityContainerDiagram(EntityContainerDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyContainer(PropertyContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Algorithm Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Algorithm Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphicsAlgorithmContainer(GraphicsAlgorithmContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pictogram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pictogram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePictogramElement(PictogramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anchor Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anchor Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnchorContainer(AnchorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShape(Shape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerShape(ContainerShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnchor(Anchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advanced Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advanced Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdvancedAnchor(AdvancedAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Box Relative Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Box Relative Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoxRelativeAnchor(BoxRelativeAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractStyle(AbstractStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphicsAlgorithm(GraphicsAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform Graphics Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform Graphics Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatformGraphicsAlgorithm(PlatformGraphicsAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Free Form Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Free Form Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFreeFormConnection(FreeFormConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Style Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Style Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyleContainer(StyleContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ActordiagramSwitch
