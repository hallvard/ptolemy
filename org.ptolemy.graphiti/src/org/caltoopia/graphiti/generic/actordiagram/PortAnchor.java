/**
 */
package org.caltoopia.graphiti.generic.actordiagram;

import org.eclipse.graphiti.mm.algorithms.styles.Orientation;

import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Anchor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.caltoopia.graphiti.generic.actordiagram.PortAnchor#getAlignment <em>Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.caltoopia.graphiti.generic.actordiagram.ActordiagramPackage#getPortAnchor()
 * @model
 * @generated
 */
public interface PortAnchor extends BoxRelativeAnchor {
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
	 * @see org.caltoopia.graphiti.generic.actordiagram.ActordiagramPackage#getPortAnchor_Alignment()
	 * @model
	 * @generated
	 */
	Orientation getAlignment();

	/**
	 * Sets the value of the '{@link org.caltoopia.graphiti.generic.actordiagram.PortAnchor#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.graphiti.mm.algorithms.styles.Orientation
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(Orientation value);

} // PortAnchor
