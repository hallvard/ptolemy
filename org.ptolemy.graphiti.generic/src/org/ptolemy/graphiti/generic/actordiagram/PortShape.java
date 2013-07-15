/**
 */
package org.ptolemy.graphiti.generic.actordiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;

import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getOutsideAnchor <em>Outside Anchor</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getInsideAnchor <em>Inside Anchor</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getSize <em>Size</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#isFilled <em>Filled</em>}</li>
 *   <li>{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#isLocked <em>Locked</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape()
 * @model
 * @generated
 */
public interface PortShape extends Shape {
	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.graphiti.mm.algorithms.styles.Orientation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.graphiti.mm.algorithms.styles.Orientation
	 * @see #setAlignment(Orientation)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_Alignment()
	 * @model
	 * @generated
	 */
	Orientation getAlignment();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.graphiti.mm.algorithms.styles.Orientation
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(Orientation value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.graphiti.mm.algorithms.styles.Orientation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' attribute.
	 * @see org.eclipse.graphiti.mm.algorithms.styles.Orientation
	 * @see #setOrientation(Orientation)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_Orientation()
	 * @model
	 * @generated
	 */
	Orientation getOrientation();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getOrientation <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' attribute.
	 * @see org.eclipse.graphiti.mm.algorithms.styles.Orientation
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(Orientation value);

	/**
	 * Returns the value of the '<em><b>Outside Anchor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside Anchor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outside Anchor</em>' reference.
	 * @see #setOutsideAnchor(PortAnchor)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_OutsideAnchor()
	 * @model
	 * @generated
	 */
	PortAnchor getOutsideAnchor();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getOutsideAnchor <em>Outside Anchor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outside Anchor</em>' reference.
	 * @see #getOutsideAnchor()
	 * @generated
	 */
	void setOutsideAnchor(PortAnchor value);

	/**
	 * Returns the value of the '<em><b>Inside Anchor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Anchor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Anchor</em>' reference.
	 * @see #setInsideAnchor(PortAnchor)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_InsideAnchor()
	 * @model
	 * @generated
	 */
	PortAnchor getInsideAnchor();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getInsideAnchor <em>Inside Anchor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Anchor</em>' reference.
	 * @see #getInsideAnchor()
	 * @generated
	 */
	void setInsideAnchor(PortAnchor value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Filled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filled</em>' attribute.
	 * @see #setFilled(boolean)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_Filled()
	 * @model
	 * @generated
	 */
	boolean isFilled();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#isFilled <em>Filled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filled</em>' attribute.
	 * @see #isFilled()
	 * @generated
	 */
	void setFilled(boolean value);

	/**
	 * Returns the value of the '<em><b>Locked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locked</em>' attribute.
	 * @see #setLocked(boolean)
	 * @see org.ptolemy.graphiti.generic.actordiagram.ActordiagramPackage#getPortShape_Locked()
	 * @model
	 * @generated
	 */
	boolean isLocked();

	/**
	 * Sets the value of the '{@link org.ptolemy.graphiti.generic.actordiagram.PortShape#isLocked <em>Locked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locked</em>' attribute.
	 * @see #isLocked()
	 * @generated
	 */
	void setLocked(boolean value);

} // PortShape
