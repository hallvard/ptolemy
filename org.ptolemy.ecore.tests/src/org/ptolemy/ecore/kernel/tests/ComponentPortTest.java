/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.tests;

import junit.textui.TestRunner;

import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.KernelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Component Port</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentPortTest extends PortTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ComponentPortTest.class);
	}

	/**
	 * Constructs a new Component Port test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPortTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Component Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ComponentPort getFixture() {
		return (ComponentPort)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KernelFactory.eINSTANCE.createComponentPort());
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

} //ComponentPortTest
