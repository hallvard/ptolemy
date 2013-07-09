package org.ptolemy.xtext.ui.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.util.StringInputStream;

/**
 * Wizard with no page that creates the untitled text file
 * and opens the text editor.
 *
 * @since 3.1
 */
public class NewXActorFileWizard extends Wizard implements INewWizard {

	private IWorkbenchWindow workbenchWindow;

	public NewXActorFileWizard() {
	}

	/*
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	public void dispose() {
		workbenchWindow = null;
	}

	private IStructuredSelection selection;
	private NewXActorFileWizardPage newFilePage;
	
    public void addPages() {
    	newFilePage = new NewXActorFileWizardPage(selection);
		addPage(newFilePage);
    }

	/*
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		String containerName = newFilePage.getContainerName();
		String fileName = newFilePage.getFileName();
		Path path = new Path(containerName + File.separator + fileName);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		try {
			if (! file.exists()) {
				String actorName = fileName;
				int pos = actorName.indexOf(".");
				if (pos > 0) {
					actorName = actorName.substring(0, pos);
				}
				if (Character.isLowerCase(actorName.charAt(0))) {
					actorName = Character.toUpperCase(actorName.charAt(0)) + actorName.substring(1);
				}
				IPath containerPath = path.removeLastSegments(1);
				Map<String, String> variables = createVariables(
						"namespaceName", containerPath.removeFirstSegments(2).toString().replace('/', '.'),
						"actorName", actorName
				);
				file.create(getInitialContents(newFilePage.getTemplateName(), variables), false, new NullProgressMonitor());
			}
			FileEditorInput editorInput = new FileEditorInput(file);
			IWorkbenchPage page = workbenchWindow.getActivePage();
			page.openEditor(editorInput, "org.ptolemy.xtext.XActor");
		} catch (PartInitException e) {
			return false;
		} catch (CoreException e) {
			return false;
		}
		return true;
	}

	protected Map<String, String> createVariables(String...variableValues) {
		Map<String, String> variables = new HashMap<String, String>();
		for (int i = 0; i < variableValues.length; i += 2) {
			String variable = variableValues[i];
			variables.put("$" + variable, variableValues[i + 1]);
		}
		return variables;
	}
	
	protected InputStream getInitialContents(String templateName, Map<String, String> variables) {
		InputStream templateStream = getClass().getResourceAsStream(templateName + ".xactor");

		StringBuilder contents = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(templateStream));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				contents.append(line);
				contents.append("\n");
			}
		} catch (IOException e) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		return new StringInputStream(replaceVariables(contents.toString(), variables));
	}

	protected String replaceVariables(String s, Map<String, String> variables) {
		for (String variable : variables.keySet()) {
			s = s.replace(variable, variables.get(variable));
		}
		return s;
	}
	
	/*
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		workbenchWindow = workbench.getActiveWorkbenchWindow();
		this.selection = selection;  
	}
}
