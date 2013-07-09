package org.ptolemy.xtext.launch;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.debug.ui.launcher.AbstractJavaMainTab;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;

import ptolemy.actor.Director;
import ptolemy.actor.TypedCompositeActor;

public class PtolemyMainTab extends AbstractJavaMainTab implements ILaunchConfigurationTab {

	@Override
	public String getName() {
		return "Ptolemy";
	}

	private Text actorClassNameText;

	private Combo directorClassNameText;

	private Combo resourceClassNameText;

	private Text resourcePathText;

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		comp.setLayoutData(gd);

		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		comp.setLayout(layout);

		createProjectEditor(comp);
		Control projectEditorControl = comp.getChildren()[0];
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = layout.numColumns;
		projectEditorControl.setLayoutData(gd);

		Label label = new Label(comp, SWT.NULL);
		label.setText("Actor class:");

		actorClassNameText = new Text(comp, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		actorClassNameText.setLayoutData(gd);
		actorClassNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		Button button = new Button(comp, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectType("Actor class", TypedCompositeActor.class, PtolemyLaunchConfigurationDelegate.ACTOR_TYPE_KEY, actorClassNameText);
			}
		});

		label = new Label(comp, SWT.NULL);
		label.setText("Director class:");

		directorClassNameText = new Combo(comp, SWT.BORDER | SWT.DROP_DOWN);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		directorClassNameText.setLayoutData(gd);
		directorClassNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		directorClassNameText.add("ptolemy.domains.de.kernel.DEDirector");
		directorClassNameText.add("ptolemy.domains.sdf.kernel.SDFDirector");
		directorClassNameText.select(0);
		directorClassNameText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		button = new Button(comp, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectType("Director class", Director.class, PtolemyLaunchConfigurationDelegate.DIRECTOR_TYPE_KEY, directorClassNameText);
			}
		});

		label = new Label(comp, SWT.NULL);
		label.setText("Resource class:");

		resourceClassNameText = new Combo(comp, SWT.BORDER | SWT.DROP_DOWN);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		resourceClassNameText.setLayoutData(gd);
		resourceClassNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		resourceClassNameText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		button = new Button(comp, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectType("Resource class", BeanResource.class, PtolemyLaunchConfigurationDelegate.RESOURCE_TYPE_KEY, resourceClassNameText);
			}
		});

		label = new Label(comp, SWT.NULL);
		label.setText("Resoure file name:");

		resourcePathText = new Text(comp, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		resourcePathText.setLayoutData(gd);
		resourcePathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		button = new Button(comp, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectResource("Resource path", PtolemyLaunchConfigurationDelegate.RESOURCE_PATH_KEY, resourcePathText);
			}
		});

		setControl(comp);
	}

	protected void selectType(String title, Class<?> superClass, String attribute, Control textControl) {
		IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IProject project = ((IFileEditorInput) editorInput).getFile().getProject();
			IJavaProject javaProject = JavaCore.create(project);
			try {
				IType superType = javaProject.findType(superClass.getName());
				//				ITypeHierarchy hierarchy = superType.newTypeHierarchy(new NullProgressMonitor());
				//				IType[] subTypes = hierarchy.getAllSubtypes(superType);
				IJavaSearchScope superTypeScope = SearchEngine.createHierarchyScope(superType);
				SelectionDialog typeDialog = JavaUI.createTypeDialog(textControl.getShell(), new ProgressMonitorDialog(textControl.getShell()), superTypeScope, IJavaElementSearchConstants.CONSIDER_CLASSES, false);
				typeDialog.setTitle(title);
				if (typeDialog.open() == Window.OK) {
					Object[] result = typeDialog.getResult();
					if (result != null && result.length > 0 && result[0] instanceof IType) {
						String typeName = ((IType) result[0]).getFullyQualifiedName();
						setStringAttribute((ILaunchConfigurationWorkingCopy) getCurrentLaunchConfiguration(), attribute, typeName);
						updateStringWidget(textControl, typeName);
						updateLaunchConfigurationDialog();
					}
				}

			} catch (JavaModelException e) {
			}
		}
	}

	protected void selectResource(String title, String attribute, Control textControl) {
		final IContainer input = ResourcesPlugin.getWorkspace().getRoot();
		final SelectionDialog dialog = new FilteredResourcesSelectionDialog(resourcePathText.getShell(), false, input, IResource.FILE);
		dialog.setTitle(title);
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if (result != null && result.length > 0 && result[0] instanceof IResource) {
				IPath path = ((IResource) result[0]).getFullPath();
				updateStringWidget(textControl, path.toString());
				updateLaunchConfigurationDialog();
			}
		}
	}

	protected boolean setStringAttribute(ILaunchConfigurationWorkingCopy configuration, String attribute, String value) {
		try {
			configuration.setAttribute(attribute, value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, "org.ptolemy.xtext.launch.PtolemyMain");
	}

	public boolean isValid(ILaunchConfiguration configuration) {
		setErrorMessage(null);
		if (! super.isValid(configuration)) {
			return false;
		}
		try {
			if (configuration.getAttribute(PtolemyLaunchConfigurationDelegate.ACTOR_TYPE_KEY, (String) null) == null) {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			setErrorMessage("No actor class");
			return false;
		}
		try {
			if (configuration.getAttribute(PtolemyLaunchConfigurationDelegate.DIRECTOR_TYPE_KEY, (String) null) == null) {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			setErrorMessage("No director class");
			return false;
		}
		return true;
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, fProjText.getText().trim());

		setStringAttribute(configuration, PtolemyLaunchConfigurationDelegate.ACTOR_TYPE_KEY, actorClassNameText.getText());
		setStringAttribute(configuration, PtolemyLaunchConfigurationDelegate.DIRECTOR_TYPE_KEY, directorClassNameText.getText());
		setStringAttribute(configuration, PtolemyLaunchConfigurationDelegate.RESOURCE_TYPE_KEY, resourceClassNameText.getText());
		setStringAttribute(configuration, PtolemyLaunchConfigurationDelegate.RESOURCE_PATH_KEY, resourcePathText.getText());
	}

	protected void updateStringWidget(Widget textWidget, String value) {
		if (value == null) {
			value = "";
		}
		if (textWidget instanceof Text) {
			((Text) textWidget).setText(value);
		} else if (textWidget instanceof Combo) {
			((Combo) textWidget).setText(value);
		}
	}

	protected void updateStringWidget(ILaunchConfiguration configuration, String attribute, Widget textWidget) {
		try {
			updateStringWidget(textWidget, configuration.getAttribute(attribute, (String) null));
		} catch (CoreException e) {
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		updateStringWidget(configuration, PtolemyLaunchConfigurationDelegate.ACTOR_TYPE_KEY, actorClassNameText);
		updateStringWidget(configuration, PtolemyLaunchConfigurationDelegate.DIRECTOR_TYPE_KEY, directorClassNameText);
		updateStringWidget(configuration, PtolemyLaunchConfigurationDelegate.RESOURCE_TYPE_KEY, resourceClassNameText);
		updateStringWidget(configuration, PtolemyLaunchConfigurationDelegate.RESOURCE_PATH_KEY, resourcePathText);
	}
}
