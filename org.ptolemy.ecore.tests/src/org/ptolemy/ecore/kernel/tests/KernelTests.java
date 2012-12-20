/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>kernel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class KernelTests extends TestSuite {

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
		TestSuite suite = new KernelTests("kernel Tests");
		suite.addTestSuite(EntityTest.class);
		suite.addTestSuite(PortTest.class);
		suite.addTestSuite(RelationTest.class);
		suite.addTestSuite(ComponentEntityTest.class);
		suite.addTestSuite(ComponentPortTest.class);
		suite.addTestSuite(CompositeEntityTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelTests(String name) {
		super(name);
	}

} //KernelTests
