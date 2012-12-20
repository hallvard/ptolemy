/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.tests;

import junit.textui.TestRunner;

import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.TypedAtomicActor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Typed Atomic Actor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypedAtomicActorTest extends AtomicActorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TypedAtomicActorTest.class);
	}

	/**
	 * Constructs a new Typed Atomic Actor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedAtomicActorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Typed Atomic Actor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TypedAtomicActor getFixture() {
		return (TypedAtomicActor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ActorFactory.eINSTANCE.createTypedAtomicActor());
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

} //TypedAtomicActorTest
