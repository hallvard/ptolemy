/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.actor.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>actor</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActorTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ActorTests("actor Tests");
		suite.addTestSuite(JvmTypedObjTest.class);
		suite.addTestSuite(VariableTest.class);
		suite.addTestSuite(ParameterTest.class);
		suite.addTestSuite(IOPortTest.class);
		suite.addTestSuite(TypedIOPortTest.class);
		suite.addTestSuite(AtomicActorTest.class);
		suite.addTestSuite(TypedAtomicActorTest.class);
		suite.addTestSuite(CompositeActorTest.class);
		suite.addTestSuite(TypedCompositeActorTest.class);
		suite.addTestSuite(EntityActorImplTest.class);
		suite.addTestSuite(EntityRefActorImplTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorTests(String name) {
		super(name);
	}

} //ActorTests
