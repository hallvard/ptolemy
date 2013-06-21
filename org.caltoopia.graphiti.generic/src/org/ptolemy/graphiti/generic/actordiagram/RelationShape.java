/**
 */
package org.ptolemy.graphiti.generic.actordiagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.RelationShape#getSourcePortShape <em>Source Port Shape</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.RelationShape#getTargetPortShapes <em>Target Port Shapes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getRelationShape()
 * @model
 * @generated
 */
public interface RelationShape extends Shape {

	/**
	 * Returns the value of the '<em><b>Source Port Shape</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Port Shape</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port Shape</em>' reference.
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getRelationShape_SourcePortShape()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	PortShape getSourcePortShape();

	/**
	 * Returns the value of the '<em><b>Target Port Shapes</b></em>' reference list.
	 * The list contents are of type {@link org.ptolemy.graphiti.generic.actordiagram.PortShape}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Port Shapes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port Shapes</em>' reference list.
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getRelationShape_TargetPortShapes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<PortShape> getTargetPortShapes();
} // RelationShape
