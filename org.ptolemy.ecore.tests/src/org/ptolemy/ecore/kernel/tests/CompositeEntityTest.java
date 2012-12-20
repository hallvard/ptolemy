/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.tests;

import junit.textui.TestRunner;

import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.Port;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Composite Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllEntities() <em>All Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllRelations() <em>All Relations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.CompositeEntity#getEntity(java.lang.String) <em>Get Entity</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CompositeEntityTest extends ComponentEntityTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CompositeEntityTest.class);
	}

	/**
	 * Constructs a new Composite Entity test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeEntityTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Composite Entity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CompositeEntity<?> getFixture() {
		return (CompositeEntity<?>)fixture;
	}

	protected CompositeEntity<ComponentPort> c1, c2;
	protected Entity<Port> e11, e12, e21, e22;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		c1 = createCompositeEntity("c1");
		c2 = createCompositeEntity("c2");

		e11 = createEntity("e11");
		e12 = createEntity("e11");
		e21 = createEntity("e11");
		e22 = createEntity("e11");
	}

	protected CompositeEntity<ComponentPort> createCompositeEntity(String name, String... portNames) {
		CompositeEntity<ComponentPort> entity = KernelFactory.eINSTANCE.createCompositeEntity();
		entity.setSuperEntity(KernelFactory.eINSTANCE.<ComponentPort>createEntityRef());
		entity.setName(name);
		for (int i = 0; i < portNames.length; i++) {
			ComponentPort port = KernelFactory.eINSTANCE.createComponentPort();
			port.setName(portNames[i]);
			entity.getPorts().add(port);
		}
		entity.resolveSuperEntity(true);
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllEntities() <em>All Entities</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getAllEntities()
	 * @generated
	 */
	public void testGetAllEntities() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.CompositeEntity#getAllRelations() <em>All Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getAllRelations()
	 * @generated
	 */
	public void testGetAllRelations() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.CompositeEntity#getEntity(java.lang.String) <em>Get Entity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.CompositeEntity#getEntity(java.lang.String)
	 * @generated
	 */
	public void testGetEntity__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //CompositeEntityTest
