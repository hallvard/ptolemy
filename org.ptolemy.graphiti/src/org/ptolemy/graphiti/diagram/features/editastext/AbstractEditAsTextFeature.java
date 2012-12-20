package org.ptolemy.graphiti.diagram.features.editastext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.widgets.Composite;
import org.ptolemy.graphiti.diagram.features.editastext.IEditAsTextHelper.Context;
import org.ptolemy.xtext.ui.internal.XActorActivator;

import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class AbstractEditAsTextFeature extends AbstractCustomFeature implements Context {

	@Inject
	public AbstractEditAsTextFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return getPictogramElement(context) != null;
	}

	protected PictogramElement getPictogramElement(ICustomContext context) {
		for (PictogramElement pe : context.getPictogramElements()) {
			if (canExecute(pe)) {
				return pe;
			}
		}
		return null;
	}

	public boolean canExecute(PictogramElement pe) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		return canExecute(bo);
	}
	
	public abstract boolean canExecute(EObject bo);

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pe = getPictogramElement(context);
		ILocation location = Graphiti.getPeLayoutService().getLocationRelativeToDiagram((Shape) pe);
		IDimension size = Graphiti.getGaService().calculateSize(pe.getGraphicsAlgorithm());
		int x = context.getX(), y = context.getY();
		if (x < 0) {
			x = location.getX() + size.getWidth();
		}
		if (y < 0) {
			y = location.getY() + size.getHeight();
		}
		execute(pe, x, y);
	}
	
	protected void execute(PictogramElement pe, int x, int y) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		execute(getEditableObject(bo), x, y);
	}

	protected EObject getEditableObject(EObject bo) {
		return bo;
	}
	
	private Injector injector;
	
	public Injector getInjector() {
		if (injector == null) {
			injector = XActorActivator.getInstance().getInjector(XActorActivator.ORG_PTOLEMY_XTEXT_XACTOR);
		}
		return injector;
	}
	
	public TransactionalEditingDomain getEditingDomain() {
		return getDiagramEditor().getEditingDomain();
	}

	private IEditAsTextHelper editAsTextHelper = new EditAsTextHelper(this);

	private EObject editableObject = null;
	
	public EStructuralFeature[] getStructuralFeatures() {
		return null;
	}
	
	protected void execute(EObject bo, int x, int y) {
		editableObject = bo;
		editAsTextHelper.editAsText(editableObject, getStructuralFeatures(), (Composite) ((DiagramEditor) getDiagramEditor()).getGraphicalViewer().getControl(), x, y);
	}

	public Boolean applyResult(final EObject editedObject) {
		Resource editableResource = editableObject.eResource();
		Resource editedResource = editedObject.eResource();
		URIConverter streamFactory = editableResource.getResourceSet().getURIConverter();
		try {
			editableResource.save(streamFactory.createOutputStream(editedResource.getURI()), null);
			editedResource.save(streamFactory.createOutputStream(editableResource.getURI()), null);
			editableResource.unload();
//			ResourceSet resourceSet = editableResource.getResourceSet();
//			EList<Resource> resources = resourceSet.getResources();
//			int pos = resources.indexOf(editableResource);
//			for (int i = resources.size() - 1; i > pos; i--) {
//				Resource resource = resources.get(i);
//				if (resource instanceof TypeResource) {
//					resources.remove(i);
//				}
//			}
			editableResource.load(streamFactory.createInputStream(editableResource.getURI()), null);
			for (EObject eObject : editableResource.getContents()) {
				// ignore
			}
		} catch (IOException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public Boolean applyResultOld(final EObject eObject) {
		final Resource editableResource = editableObject.eResource();
		final Copier copier = getReplacementCopier(editableObject, eObject);
		final EObject editedObject = copier.get(editableObject);
		final EObject replacement = copier.copy(copier.get(editableObject));
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		final EObject owner = editableObject.eContainer();
		final EStructuralFeature feature = editableObject.eContainingFeature();
		CompoundCommand compountCommand = new CompoundCommand();
		compountCommand.append(new ChangeCommand(owner) {
			@Override
			protected void doExecute() {
				if (feature.isMany()) {
					EList<EObject> list = (EList<EObject>) owner.eGet(feature);
					int pos = list.indexOf(editableObject);
					list.set(pos, replacement);
				} else {
					owner.eSet(feature, replacement);
				}
				copier.copyReferences();
			}
		});
		final ResourceSet resourceSet = editableResource.getResourceSet();
		if (editedObject.eResource().getResourceSet() == resourceSet) {
			compountCommand.append(new AbstractCommand() {
				@Override
				protected boolean prepare() {
					return true;
				}
				@Override
				public void execute() {
					resourceSet.getResources().remove(editedObject.eResource());
				}
				@Override
				public void redo() {
				}
			});
		}
		editingDomain.getCommandStack().execute(compountCommand);
		return true;
	}

	protected RelinkingCopier getReplacementCopier(EObject editableObject, EObject eObject) {
		final Resource editableResource = editableObject.eResource();
		String editableUriFragment = editableResource.getURIFragment(editableObject);
		Resource editedResource = eObject.eResource();
		EObject editedObject = editedResource.getEObject(editableUriFragment);
		final Map<EObject, EObject> edited2Editable = buildEdited2OriginalMap(editableObject, editedObject);
		// the original object is mapped the other way, too
		edited2Editable.put(editableObject, editedObject);
		RelinkingCopier copier = new RelinkingCopier(editableResource);
		copier.relink(edited2Editable);
		return copier;
	}
	
	static class RelinkingCopier extends EcoreUtil.Copier {
		
		private Resource originalResource;
		private Map<EObject, EObject> relinkMap = new HashMap<EObject, EObject>();
		
		public RelinkingCopier(Resource originalResource) {
			super(true, false);
			this.originalResource = originalResource;
		}
		
		public void relink(EObject key, EObject value) {
			relinkMap.put(key, value);
		}
		public void relink(Map<EObject, EObject> map) {
			relinkMap.putAll(map);
		}
		
		@Override
		protected EObject createCopy(EObject eObject) {
			return eObject;
		}
		public EObject get(Object key) {
			if (super.containsKey(key)) {
				return super.get(key);
			}
			if (relinkMap.containsKey(key)) {
				return relinkMap.get(key);
			}
			EObject eObject = (EObject) key;
			Resource eResource = eObject.eResource();
			if (eResource != originalResource) {
				URI eObjectUri = eResource.getURI().appendFragment(eResource.getURIFragment(eObject));
				EObject other = originalResource.getResourceSet().getEObject(eObjectUri, true);
				System.out.println(eObjectUri + ": " + other);
				return other;
			}
			return null;
		}
	}

	protected Map<EObject, EObject> buildEdited2OriginalMap(EObject editableObject, EObject editedObject) {
		final Map<EObject, EObject> edited2Editable = new HashMap<EObject, EObject>();
		TreeIterator<EObject> editableContent = EcoreUtil.getRootContainer(editableObject).eAllContents();
		TreeIterator<EObject> editedContent = EcoreUtil.getRootContainer(editedObject).eAllContents();
		// we assume the trees are isomorphic, except from the content of editableObject and editedObject
		while (editableContent.hasNext() && editedContent.hasNext()) {
			EObject editable = editableContent.next();
			EObject edited = editedContent.next();
			edited2Editable.put(edited, editable);
			if (editable == editableObject) {
				editableContent.prune();
			}
			if (edited == editedObject) {
				editedContent.prune();
			}
		}
		return edited2Editable;
	}
}
