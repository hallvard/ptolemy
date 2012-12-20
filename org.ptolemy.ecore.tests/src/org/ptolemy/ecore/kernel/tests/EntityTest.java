/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.KernelFactory;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getSourceEntities() <em>Source Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getTargetEntities() <em>Target Entities</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getAllAttributes() <em>All Attributes</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getAllPorts() <em>All Ports</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.ptolemy.ecore.kernel.Entity#getPort(java.lang.String) <em>Get Port</em>}</li>
 *   <li>{@link org.ptolemy.ecore.kernel.EntityRefOwner#entityResolved(org.eclipse.emf.ecore.EStructuralFeature) <em>Entity Resolved</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EntityTest extends NamedObjTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntityTest.class);
	}

	/**
	 * Constructs a new Entity test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Entity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Entity<?> getFixture() {
		return (Entity<?>)fixture;
	}

	protected CompositeEntity<ComponentPort> model;
	protected Entity<Port> e1, e2, e3, e4;
	protected Relation r1;
	
	protected Entity<Port> sup1, sup2, sub1, sub2;

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
		
		e1 = createEntity("e1", "p1");
		e2 = createEntity("e2", "p1");
		e3 = createEntity("e3", "p1");
		e4 = createEntity("e4", "p1");

		r1 = KernelFactory.eINSTANCE.createRelation();
		r1.setSourcePort(e1.getPorts().get(0));
		r1.getTargetPorts().addAll(Arrays.asList(
				e2.getPorts().get(0),
				e3.getPorts().get(0),
				e4.getPorts().get(0)
		));

		model.getEntities().addAll(Arrays.asList(e1, e2, e3, e4));
		model.getRelations().add(r1);

		sup1 = createEntity("sup1", "p1", "p2");
		sup2 = createEntity("sup2", "p1");

		sub1 = createEntity("sub1", "sub1p1", "sub1p2");
		sub2 = createEntity("sub2", "sub2p1", "p2");
	}

	protected Entity<Port> createEntity(String name, String... portNames) {
		Entity<Port> entity = KernelFactory.eINSTANCE.createEntity();
		entity.setSuperEntity(KernelFactory.eINSTANCE.createEntityRef());
		entity.setName(name);
		for (int i = 0; i < portNames.length; i++) {
			Port port = KernelFactory.eINSTANCE.createPort();
			port.setName(portNames[i]);
			entity.getPorts().add(port);
		}
		entity.resolveSuperEntity(true);
		return entity;
	}
	
	@Override
	public void testGetAttribute__String() {
	}

	@Override
	public void testGetContainer() {
		assertEquals(model, e1.getContainer());
		assertEquals(model, e2.getContainer());
		assertEquals(model, e3.getContainer());
		assertEquals(model, e4.getContainer());
	}

	@Override
	public void testGetFullName() {
		assertEquals("model.e1", e1.getFullName());
		assertEquals("model.e2", e2.getFullName());
		assertEquals("model.e3", e3.getFullName());
		assertEquals("model.e4", e4.getFullName());
	}

	@Override
	public void testGetName__NamedObj() {
		assertEquals("e1", e1.getName(model));
		assertEquals("e2", e2.getName(model));
		assertEquals("e3", e3.getName(model));
		assertEquals("e4", e4.getName(model));
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
	 * Tests the '{@link org.ptolemy.ecore.kernel.Entity#getSourceEntities() <em>Source Entities</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Entity#getSourceEntities()
	 * @generated NOT
	 */
	public void testGetSourceEntities() {
		assertEquals(Arrays.asList(e1), e2.getSourceEntities());
		assertEquals(Arrays.asList(e1), e3.getSourceEntities());
		assertEquals(Arrays.asList(e1), e4.getSourceEntities());
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Entity#getTargetEntities() <em>Target Entities</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Entity#getTargetEntities()
	 * @generated NOT
	 */
	public void testGetTargetEntities() {
		EList<Entity<?>> e1TargetEntities = e1.getTargetEntities();
		assertTrue(e1TargetEntities.containsAll(Arrays.asList(e2, e3, e4)));
		assertTrue(Arrays.asList(e2, e3, e4).containsAll(e1TargetEntities));

		assertEquals(0, e2.getTargetEntities().size());
		assertEquals(0, e3.getTargetEntities().size());
		assertEquals(0, e4.getTargetEntities().size());
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Entity#getAllAttributes() <em>All Attributes</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Entity#getAllAttributes()
	 * @generated NOT
	 */
	public void testGetAllAttributes() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Entity#getAllPorts() <em>All Ports</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Entity#getAllPorts()
	 * @generated NOT
	 */
	public void testGetAllPorts() {
		assertEquals(2, sup1.getPorts().size());
		assertEquals(1, sup2.getPorts().size());

		EList<Port> allPorts = sub1.getAllPorts();
		assertEquals(2, allPorts.size());
		
		// entity sup1 ->p1 ->p2 + entity sub1 ->sub1p1 ->sub1p2
		sub1.getSuperEntity().setRef(sup1);
		assertEquals(sup1.getPorts().size() + sub1.getPorts().size(), sub1.getAllPorts().size());
		assertNamesEquals(Iterables.concat(sup1.getPorts(), sub1.getPorts()), sub1.getAllPorts());

		// entity sup2 ->p1 + entity sub1 ->sub1p1 ->sub1p2
		sub1.getSuperEntity().setRef(sup2);
		assertEquals(sup2.getPorts().size() + sub1.getPorts().size(), sub1.getAllPorts().size());
		assertNamesEquals(Iterables.concat(sup2.getPorts(), sub1.getPorts()), sub1.getAllPorts());

		// entity sup1 ->p1 ->p2 + entity sub2 ->sub2p1 ->p2
		sub2.getSuperEntity().setRef(sup1);
		assertEquals(sup1.getPorts().size() + sub2.getPorts().size() - 1, sub2.getAllPorts().size());
		assertNamesEquals("p1 p2 sub2p1", sub2.getAllPorts());

		// entity sup2 ->p1 + entity sub2 ->sub2p1 ->p2
		sub2.getSuperEntity().setRef(sup2);
		assertEquals(sup2.getPorts().size() + sub2.getPorts().size(), sub2.getAllPorts().size());
		assertNamesEquals("p1 sub2p1 p2", sub2.getAllPorts());
	}

	private void assertNamesEquals(Iterable<? extends EObject> expectedNamed, Iterable<? extends EObject> actualNamed) {
		Iterator<? extends EObject> it1 = expectedNamed.iterator();
		Iterator<? extends EObject> it2 = actualNamed.iterator();
		while (it1.hasNext() && it2.hasNext()) {
			EObject next1 = it1.next();
			EObject next2 = it2.next();
			assertNamesEqual(next1, next2);
		}
		assertEquals(it1.hasNext(), it2.hasNext());
	}

	private void assertNamesEquals(String expectedNamed, Iterable<? extends EObject> actualNamed) {
		assertNamesEquals(expectedNamed.split(" "), actualNamed);
	}
	private void assertNamesEquals(String[] expectedNamed, Iterable<? extends EObject> actualNamed) {
		Iterator<String> it1 = Arrays.asList(expectedNamed).iterator();
		Iterator<? extends EObject> it2 = actualNamed.iterator();
		while (it1.hasNext() && it2.hasNext()) {
			String next1 = it1.next();
			EObject next2 = it2.next();
			assertNamesEqual(next1, next2);
		}
		assertEquals(it1.hasNext(), it2.hasNext());
	}

	private void assertNamesEqual(EObject next1, EObject next2) {
		assertEquals(next1 instanceof Nameable, next2 instanceof Nameable);
		assertEquals(((Nameable) next1).getName(), ((Nameable) next2).getName());
	}

	private void assertNamesEqual(String expected, EObject named) {
		assertTrue(named instanceof Nameable);
		assertEquals(expected, ((Nameable) named).getName());
	}
	
	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.Entity#getPort(java.lang.String) <em>Get Port</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.Entity#getPort(java.lang.String)
	 * @generated NOT
	 */
	public void testGetPort__String() {
		assertNamesEqual("p1", e1.getPort("p1")); assertNull(e1.getPort("p"));
		assertNamesEqual("p1", e2.getPort("p1")); assertNull(e2.getPort("p"));
		assertNamesEqual("p1", e3.getPort("p1")); assertNull(e3.getPort("p"));
		assertNamesEqual("p1", e4.getPort("p1")); assertNull(e4.getPort("p"));
	}

	/**
	 * Tests the '{@link org.ptolemy.ecore.kernel.EntityRefOwner#entityResolved(org.eclipse.emf.ecore.EStructuralFeature) <em>Entity Resolved</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ptolemy.ecore.kernel.EntityRefOwner#entityResolved(org.eclipse.emf.ecore.EStructuralFeature)
	 * @generated NOT
	 */
	public void testEntityResolved__EStructuralFeature() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

} //EntityTest
