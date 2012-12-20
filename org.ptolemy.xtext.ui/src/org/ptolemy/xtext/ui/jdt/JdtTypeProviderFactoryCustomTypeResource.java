package org.ptolemy.xtext.ui.jdt;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;

import com.google.inject.Inject;

public class JdtTypeProviderFactoryCustomTypeResource extends JdtTypeProviderFactory {

	@Inject
	public JdtTypeProviderFactoryCustomTypeResource(IJavaProjectProvider javaProjectProvider) {
		super(javaProjectProvider);
	}

	protected IJdtTypeProvider createJdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		if (javaProject == null)
			return super.createJdtTypeProvider(javaProject, resourceSet);
		return new JdtTypeProvider(javaProject, resourceSet, getIndexedJvmTypeAccess()) {
			@Override
			protected TypeResource doCreateResource(URI uri) {
				TypeResource result = new TypeResource(uri) {
					@Override
					public void save(Map<?, ?> options) throws IOException {
						// avoid unsupported operation
						setModified(false);
					}
				};
				result.setIndexedJvmTypeAccess(getIndexedJvmTypeAccess());
				return result;
			}
		};
	}
}
