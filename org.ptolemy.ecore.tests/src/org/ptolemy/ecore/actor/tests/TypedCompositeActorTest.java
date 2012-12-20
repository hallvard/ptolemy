/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.tests;

import junit.textui.TestRunner;

import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.TypedCompositeActor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Typed Composite Actor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypedCompositeActorTest extends CompositeActorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TypedCompositeActorTest.class);
	}

	/**
	 * Constructs a new Typed Composite Actor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedCompositeActorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Typed Composite Actor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TypedCompositeActor getFixture() {
		return (TypedCompositeActor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ActorFactory.eINSTANCE.createTypedCompositeActor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //TypedCompositeActorTest
