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
 * A test case for the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Port#getTargetPorts() <em>Target Ports</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Port#getSourcePorts() <em>Source Ports</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PortTest extends NamedObjTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PortTest.class);
	}

	/**
	 * Constructs a new Port test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Port getFixture() {
		return (Port)fixture;
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

		r1 = KernelFactory.eINSTANCE.createRelation();
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
		assertEquals(e1, e1p1.getContainer());
		assertEquals(e2, e2p1.getContainer());
		assertEquals(e3, e3p1.getContainer());
		assertEquals(e4, e4p1.getContainer());
	}

	@Override
	public void testGetFullName() {
		assertEquals("model.e1.p1", e1p1.getFullName());
		assertEquals("model.e2.p1", e2p1.getFullName());
		assertEquals("model.e3.p1", e3p1.getFullName());
		assertEquals("model.e4.p1", e4p1.getFullName());
	}

	@Override
	public void testGetName__NamedObj() {
		assertEquals("e1.p1", e1p1.getName(model));
		assertEquals("e2.p1", e2p1.getName(model));
		assertEquals("e3.p1", e3p1.getName(model));
		assertEquals("e4.p1", e4p1.getName(model));

		assertEquals("p1", e1p1.getName(e1));
		assertEquals("p1", e2p1.getName(e2));
		assertEquals("p1", e3p1.getName(e3));
		assertEquals("p1", e4p1.getName(e4));
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
	 * Tests the '{@link org.ptolemy.ecore.kernel.Port#getTargetPorts() <em>Target Ports</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Port#getTargetPorts()
	 * @generated NOT
	 */
	public void testGetTargetPorts() {
		EList<Port> p1TargetPorts = e1p1.getTargetPorts();
		assertTrue(p1TargetPorts.containsAll(Arrays.asList(e2p1, e3p1, e4p1)));
		assertTrue(Arrays.asList(e2p1, e3p1, e4p1).containsAll(p1TargetPorts));

		assertEquals(0, e2p1.getTargetPorts().size());
		assertEquals(0, e3p1.getTargetPorts().size());
		assertEquals(0, e4p1.getTargetPorts().size());
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Port#getSourcePorts() <em>Source Ports</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Port#getSourcePorts()
	 * @generated NOT
	 */
	public void testGetSourcePorts() {
		assertEquals(Arrays.asList(e1p1), e2p1.getSourcePorts());
		assertEquals(Arrays.asList(e1p1), e3p1.getSourcePorts());
		assertEquals(Arrays.asList(e1p1), e4p1.getSourcePorts());
	}

} //PortTest
