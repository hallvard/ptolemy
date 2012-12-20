/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.tests;

import java.util.Arrays;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Relation#getSourcePort() <em>Source Port</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Relation#getTargetPorts() <em>Target Ports</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RelationTest extends NamedObjTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RelationTest.class);
	}

	/**
	 * Constructs a new Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Relation getFixture() {
		return (Relation)fixture;
	}

	protected CompositeEntity<ComponentPort> model;
	protected Entity<Port> e1, e2, e3, e4;
	protected Port e1p1, e2p1, e3p1, e4p1;
	protected Relation r1;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		model = KernelFactory.eINSTANCE.createCompositeEntity();
		model.setName("model");
		
		e1 = KernelFactory.eINSTANCE.createEntity(); e1.setName("e1");
		e1p1 = KernelFactory.eINSTANCE.createPort(); e1p1.setName("p1");
		e1.getPorts().add(e1p1);
		
		e2 = KernelFactory.eINSTANCE.createEntity(); e2.setName("e2");
		e2p1 = KernelFactory.eINSTANCE.createPort(); e2p1.setName("p1");
		e2.getPorts().add(e2p1);
		
		e3 = KernelFactory.eINSTANCE.createEntity(); e3.setName("e3");
		e3p1 = KernelFactory.eINSTANCE.createPort(); e3p1.setName("p1");
		e3.getPorts().add(e3p1);

		e4 = KernelFactory.eINSTANCE.createEntity(); e4.setName("e4");
		e4p1 = KernelFactory.eINSTANCE.createPort(); e4p1.setName("p1");
		e4.getPorts().add(e4p1);

		r1 = KernelFactory.eINSTANCE.createRelation(); r1.setName("r1");
		r1.setSourcePort(e1p1);
		r1.getTargetPorts().addAll(Arrays.asList(e2p1, e3p1, e4p1));

		model.getEntities().add(e1);
		model.getEntities().add(e2);
		model.getEntities().add(e3);
		model.getEntities().add(e4);
		model.getRelations().add(r1);
	}

	@Override
	public void testGetAttribute__String() {
	}

	@Override
	public void testGetContainer() {
		assertEquals(model, r1.getContainer());
	}

	@Override
	public void testGetFullName() {
		assertEquals("model.r1", r1.getFullName());
	}

	@Override
	public void testGetName__NamedObj() {
		assertEquals("r1", r1.getName(model));
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

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Relation#getSourcePort() <em>Source Port</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Relation#getSourcePort()
	 * @generated NOT
	 */
	public void testGetSourcePort() {
		assertEquals(e1p1, r1.getSourcePort());
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Relation#getTargetPorts() <em>Target Ports</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Relation#getTargetPorts()
	 * @generated NOT
	 */
	public void testGetTargetPorts() {
		EList<Port> r1TargetPorts = r1.getTargetPorts();
		assertTrue(r1TargetPorts.containsAll(Arrays.asList(e2p1, e3p1, e4p1)));
		assertTrue(Arrays.asList(e2p1, e3p1, e4p1).containsAll(r1TargetPorts));
	}

} //RelationTest
