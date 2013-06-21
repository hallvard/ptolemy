/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.ptolemy.ecore.actor.AbstractIOPort;
import org.ptolemy.ecore.kernel.*;
import org.ptolemy.ecore.kernel.Attribute;
import org.ptolemy.ecore.kernel.ComponentEntity;
import org.ptolemy.ecore.kernel.ComponentPort;
import org.ptolemy.ecore.kernel.CompositeEntity;
import org.ptolemy.ecore.kernel.Entity;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.EntityRef;
import org.ptolemy.ecore.kernel.EntityRefOwner;
import org.ptolemy.ecore.kernel.IEntity;
import org.ptolemy.ecore.kernel.KernelPackage;
import org.ptolemy.ecore.kernel.Nameable;
import org.ptolemy.ecore.kernel.Named;
import org.ptolemy.ecore.kernel.NamedObj;
import org.ptolemy.ecore.kernel.Port;
import org.ptolemy.ecore.kernel.Relation;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.kernel.KernelPackage
 * @generated
 */
public class KernelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final KernelValidator INSTANCE = new KernelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.ptolemy.ecore.kernel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return KernelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case KernelPackage.NAMED:
				return validateNamed((Named)value, diagnostics, context);
			case KernelPackage.NAMEABLE:
				return validateNameable((Nameable)value, diagnostics, context);
			case KernelPackage.NAMED_OBJ:
				return validateNamedObj((NamedObj)value, diagnostics, context);
			case KernelPackage.ATTRIBUTE:
				return validateAttribute((Attribute)value, diagnostics, context);
			case KernelPackage.IENTITY:
				return validateIEntity((IEntity<?>)value, diagnostics, context);
			case KernelPackage.ENTITY:
				return validateEntity((Entity<?>)value, diagnostics, context);
			case KernelPackage.ENTITY_REF_OWNER:
				return validateEntityRefOwner((EntityRefOwner)value, diagnostics, context);
			case KernelPackage.ENTITY_REF:
				return validateEntityRef((EntityRef<?>)value, diagnostics, context);
			case KernelPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case KernelPackage.RELATION:
				return validateRelation((Relation)value, diagnostics, context);
			case KernelPackage.COMPONENT_ENTITY:
				return validateComponentEntity((ComponentEntity<?>)value, diagnostics, context);
			case KernelPackage.COMPONENT_PORT:
				return validateComponentPort((ComponentPort)value, diagnostics, context);
			case KernelPackage.ENTITY_CONTAINER:
				return validateEntityContainer((EntityContainer<?>)value, diagnostics, context);
			case KernelPackage.COMPOSITE_ENTITY:
				return validateCompositeEntity((CompositeEntity<?>)value, diagnostics, context);
			case KernelPackage.JAVA_CLASS_REF:
				return validateJavaClassRef(value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamed(Named named, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(named, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIEntity(IEntity<?> iEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iEntity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameable(Nameable nameable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nameable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedObj(NamedObj namedObj, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedObj, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity<?> entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntityRefOwner(EntityRefOwner entityRefOwner, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entityRefOwner, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntityRef(EntityRef<?> entityRef, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entityRef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(port, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_sourceTargetContainer(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_inputOutputLogic(relation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceTargetContainer constraint of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRelation_sourceTargetContainer(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (Port targetPort : relation.getTargetPorts()) {
			if (getRelationContainer(relation.getSourcePort(), targetPort) == null) {
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_GenericConstraint_diagnostic",
							 new Object[] { "sourceTargetContainer", getObjectLabel(relation, context) },
							 new Object[] { relation },
							 context));
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * Validates the inputOutputLogic constraint of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRelation_inputOutputLogic(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (Port targetPort : relation.getTargetPorts()) {
			if (! isValidLink(relation.getSourcePort(), targetPort)) {
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_GenericConstraint_diagnostic",
							 new Object[] { "inputOutputLogic", getObjectLabel(relation, context) },
							 new Object[] { relation },
							 context));
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentEntity(ComponentEntity<?> componentEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentEntity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentPort(ComponentPort componentPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeEntity(CompositeEntity<?> compositeEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compositeEntity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntityContainer(EntityContainer<?> entityContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entityContainer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJavaClassRef(Object javaClassRef, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	//
	
	public static boolean isValidLink(Nameable source, Nameable target) {
		Entity<?> sourceContainer = null;
		if (source instanceof Port) {
			sourceContainer = ((Port) source).getContainer();
		} else if (source instanceof Entity<?>) {
			sourceContainer = (Entity<?>) source;
		}
		Entity<?> targetContainer = null;
		if (target instanceof Port) {
			targetContainer = ((Port) target).getContainer();
		} else if (target instanceof Entity<?>) {
			targetContainer = (Entity<?>) target;
		}
		if (sourceContainer == null || targetContainer == null) {
			return false;
		}
		EntityContainer<?> relationContainer = getRelationContainer(sourceContainer, targetContainer);
		if (relationContainer == null) {
			return false;
		}
		if (source instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) source;
			if (! (sourceContainer == relationContainer ? ioPort.isInput() : ioPort.isOutput())) {
				return false;
			}
		}
		if (target instanceof AbstractIOPort) {
			AbstractIOPort ioPort = (AbstractIOPort) target;
			if (! (targetContainer == relationContainer ? ioPort.isOutput() : ioPort.isInput())) {
				return false;
			}
		}
		return true;
	}
	
	public static EntityContainer<?> getRelationContainer(Port source, Port target) {
		return getRelationContainer(source.getContainer(), target.getContainer());
	}

	public static EntityContainer<?> getRelationContainer(Entity<?> sourceContainer, Entity<?> targetContainer) {
		if (sourceContainer == null || targetContainer == null) {
			return null;
		}
		EntityContainer<?> entityContainer = null;
		if (sourceContainer instanceof CompositeEntity<?> && sourceContainer == targetContainer) {
			entityContainer = (CompositeEntity<?>) sourceContainer;
		} else if (sourceContainer instanceof CompositeEntity<?> && sourceContainer == targetContainer.getContainer()) {
			entityContainer = (CompositeEntity<?>) sourceContainer;
		} else if (targetContainer instanceof CompositeEntity<?> && targetContainer == sourceContainer.getContainer()) {
			entityContainer = (CompositeEntity<?>) sourceContainer;
		} else if (sourceContainer.getContainer() == targetContainer.getContainer()) {
			entityContainer = sourceContainer.getContainer();
		}
		return entityContainer;
	}

} //KernelValidator
