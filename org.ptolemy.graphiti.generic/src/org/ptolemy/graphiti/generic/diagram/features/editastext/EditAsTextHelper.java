package org.ptolemy.graphiti.generic.diagram.features.editastext;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;

public class EditAsTextHelper extends AbstractEditAsTextHelper {

	public EditAsTextHelper(Context context) {
		super(context);
	}

	@Override
	protected ResourceSet getXtextResourceSet(Resource originalResource) {
		return context.getDslInjector().getInstance(XtextResourceSet.class);
	}
	
	@Override
	protected String[] getInitialText(EObject editableObject, EStructuralFeature[] editableFeatures) {
		ISerializer serializer = context.getDslInjector().getInstance(ISerializer.class);
		String fragment = editableObject.eResource().getURIFragment(editableObject);
		String resourceContent = serializer.serialize(EcoreUtil.getRootContainer(editableObject));
		try {
			xtextResource.reparse(resourceContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject copy = xtextResource.getEObject(fragment);
		ICompositeNode node = NodeModelUtils.getNode(copy);
		int start = node.getTotalOffset(), end = start + node.getTotalLength();
		String invisiblePrefix = resourceContent.substring(0, start), invisibleSuffix = resourceContent.substring(end);
		String readonlyPrefix = "", readonlySuffix = "";
		String editableContent = resourceContent.substring(start, end);
		if (editableFeatures != null) {
			int childrenStart = -1, childrenEnd = -1;
			for (INode child : node.getChildren()) {
				if (child.getSemanticElement() == copy && isEditableNode(child, editableObject, editableFeatures)) {
					int offset = child.getTotalOffset(), length = child.getTotalLength();
					if (childrenStart < 0 || childrenStart > offset) {
						childrenStart = offset;
					}
					if (childrenEnd < 0 || childrenEnd < offset + length) {
						childrenEnd = offset + length;
					}
				}
			}
			readonlyPrefix = resourceContent.substring(start, childrenStart).trim();
			readonlySuffix = resourceContent.substring(childrenEnd, end);
			editableContent = resourceContent.substring(childrenStart, childrenEnd);
		}
		editableContent = withoutNewlines(editableContent, true, true);
		System.out.println(invisiblePrefix + "<<" + readonlyPrefix + "<<" + editableContent + ">>" + readonlySuffix + ">>" + invisibleSuffix);
		return new String[]{invisiblePrefix, readonlyPrefix, editableContent, readonlySuffix, invisibleSuffix};
	}

	protected boolean isEditableNode(INode node, EObject editableObject, EStructuralFeature[] editableFeatures) {
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement.eContainer() instanceof Assignment) {
			Assignment assignment = (Assignment) grammarElement.eContainer();
			String featureName = assignment.getFeature();
			for (int i = 0; i < editableFeatures.length; i++) {
				if (featureName.equals(editableFeatures[i].getName())) {
					return true;
				}
			}
		}
		return false;
	}
}
