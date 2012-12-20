/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.KernelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entity Ref</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntityRefTest extends TestCase {

	/**
	 * The fixture for this Entity Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityRef<?> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntityRefTest.class);
	}

	/**
	 * Constructs a new Entity Ref test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRefTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Entity Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EntityRef<?> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Entity Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityRef<?> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KernelFactory.eINSTANCE.createEntityRef());
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

} //EntityRefTest
