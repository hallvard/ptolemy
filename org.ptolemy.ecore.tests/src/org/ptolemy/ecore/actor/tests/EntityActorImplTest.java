/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.tests;

import junit.textui.TestRunner;

import org.ptolemy.ecore.actor.ActorFactory;
import org.ptolemy.ecore.actor.EntityActorImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entity Actor Impl</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntityActorImplTest extends AtomicActorImplTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntityActorImplTest.class);
	}

	/**
	 * Constructs a new Entity Actor Impl test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityActorImplTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Entity Actor Impl test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EntityActorImpl<?> getFixture() {
		return (EntityActorImpl<?>)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ActorFactory.eINSTANCE.createEntityActorImpl());
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

} //EntityActorImplTest
