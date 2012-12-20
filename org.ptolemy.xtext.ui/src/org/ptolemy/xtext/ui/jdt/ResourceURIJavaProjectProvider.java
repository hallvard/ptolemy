package org.ptolemy.xtext.ui.jdt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider;

public class ResourceURIJavaProjectProvider extends XtextResourceSetBasedProjectProvider {

	private EObject projectContext;
	
	public EObject getProjectContext() {
		return projectContext;
	}

	public void setProjectContext(EObject eObject) {
		this.projectContext = eObject;
	}
	
	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		IJavaProject javaProject = super.getJavaProject(resourceSet);
		if (javaProject == null && projectContext != null) {
			javaProject = getJavaProject(projectContext.eResource());
		}
		if (javaProject == null) {
			for (Resource resource : resourceSet.getResources()) {
				javaProject = getJavaProject(resource);
				if (javaProject != null) {
					break;
				}
			}
		}
		return javaProject;
	}

	protected IJavaProject getJavaProject(Resource resource) {
		URI uri = resource.getURI();
		URI projectUri = uri.trimSegments(uri.segmentCount() - 2);
		String pathString = null;
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (projectUri.isPlatformResource()) {
			pathString = projectUri.segment(1);
		} else {
			URI resolvedUri = CommonPlugin.resolve(projectUri);
			URI rootUri = URI.createFileURI(root.getLocation().toPortableString());
			String fileString = resolvedUri.toFileString();
			if (fileString != null && fileString.startsWith(rootUri.toFileString())) {
				pathString = resolvedUri.segment(rootUri.segmentCount());
			}
		}
		if (pathString != null) {
			IProject project = root.getProject(pathString);
			if (project != null) {
				return JavaCore.create(project);
			}
		}
		return null;
	}
}
