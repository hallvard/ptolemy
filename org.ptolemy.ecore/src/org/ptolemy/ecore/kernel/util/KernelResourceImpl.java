/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.ecore.kernel.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.ptolemy.ecore.kernel.EntityContainer;
import org.ptolemy.ecore.kernel.Nameable;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.ptolemy.ecore.kernel.util.KernelResourceFactoryImpl
 * @generated
 */
public class KernelResourceImpl extends XMIResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public KernelResourceImpl(URI uri) {
		super(uri);
	}

	public static String getFullName(Nameable named, boolean containerPrefixed, boolean indexSuffixed) {
		String fullName = named.getFullName();
		if (fullName != null && containerPrefixed && (! (named instanceof EntityContainer))) {
			while (named.getContainer() != null) {
				named = named.getContainer();
			}
			if (named.eContainer() instanceof EntityContainer) {
				String containerFullName = ((EntityContainer) named.eContainer()).getFullName();
				if (containerFullName != null) {
					fullName = containerFullName + "." + fullName;
				}
			}
		}
		return fullName;
	}

	private static String NAME_URL_FRAGMENT_PREFIX = "#";

	@Override
	public String getURIFragment(EObject eObject) {
		if (eObject instanceof Nameable) {
			String fragment = getFullName((Nameable) eObject, true, true);
			EStructuralFeature containingFeature = eObject.eContainingFeature();
			if (containingFeature != null) {
				fragment = fragment + ":" + containingFeature.getName();
			}
			return NAME_URL_FRAGMENT_PREFIX + fragment;
		}
		return super.getURIFragment(eObject);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		if (uriFragment.startsWith(NAME_URL_FRAGMENT_PREFIX)) {
			Object eObject = getNamedEObject(uriFragment.substring(NAME_URL_FRAGMENT_PREFIX.length()));
			if (eObject instanceof EObject) {
				return (EObject) eObject;
			}
		}
		return super.getEObject(uriFragment);
	}

	protected Object getNamedEObject(String uriFragment) {
		String[] names = uriFragment.split("\\.");
		Object container = this;
		for (int i = 0; i < names.length && container != null; i++) {
			String name = names[i];
			int index = -1, pos = name.indexOf('@');
			if (pos >= 0) {
				index = Integer.valueOf(name.substring(pos + 1));
				name = name.substring(0, pos);
			}
			Iterable<?> contentList = getContentList(container, name);
			if (contentList != null) {
				container = getNamed(contentList, name, index);
			}
		}
		return container;
	}
	
	protected Iterable<?> getContentList(Object container, String name) {
		if (container instanceof Resource) {
			return ((Resource) container).getContents();
		} else if (container instanceof EObject) {
			EObject eObject = (EObject) container;
			int pos = name.indexOf(':');
			if (pos < 0) {
				return eObject.eContents();
			} else {
				EStructuralFeature feature = eObject.eClass().getEStructuralFeature(name.substring(pos + 1));
				name = name.substring(0, pos);
				if (feature != null) {
					Object featureValue = eObject.eGet(feature);
					if (featureValue instanceof Iterable) {
						return (Iterable<?>) featureValue;
					}
				}
			}
		}
		return null;
	}

	protected Nameable getNamed(Iterable<?> contentList, String name, int index) {
		Nameable namedAt = null;
		for (Object child : contentList) {
			if (child instanceof Nameable) {
				Nameable named = (Nameable) child;
				if (index-- == 0) {
					namedAt = named;
				}
				if (name.equals(named.getName())) {
					return named;
				}
			}
		}
		return namedAt;
	}
	
} //KernelResourceImpl
