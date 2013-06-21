package org.ptolemy.graphiti.generic.editor;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.ptolemy.graphiti.generic.ActorViewModel;

public class ActorDiagramImageProvider extends AbstractImageProvider {

	protected static final String IMG_ID_PREFIX = "org.ptolemy.graphiti.";

	// The image identifiers
	public static final String IMG_PORT = 				IMG_ID_PREFIX + "port";
	public static final String IMG_INPUT_PORT = 		IMG_ID_PREFIX + "input-port";
	public static final String IMG_MULTI_INPUT_PORT = 	IMG_ID_PREFIX + "multi-input-port";
	public static final String IMG_OUTPUT_PORT = 		IMG_ID_PREFIX + "output-port";
	public static final String IMG_MULTI_OUTPUT_PORT = 	IMG_ID_PREFIX + "multi-output-port";

	public static final String IMG_RELATION = 	IMG_ID_PREFIX + "relation";

	public static String getPortImageId(ActorViewModel.PortKind ioKind, Boolean multi) {
		return IMG_ID_PREFIX +
				(Boolean.TRUE.equals(multi) ? "multi-" : "") +
				(ioKind != null ? ioKind.name().toLowerCase() + "-" : "") +
				"port";
	}
	
	private static String IMG_PATH_PREFIX = "resources/icons/";
	
	@Override
	protected void addAvailableImages() {
		addImageFilePath(IMG_PORT, 				IMG_PATH_PREFIX + "single_inout.gif");
		addImageFilePath(IMG_INPUT_PORT, 		IMG_PATH_PREFIX + "port-input-single.png");
		addImageFilePath(IMG_MULTI_INPUT_PORT, 	IMG_PATH_PREFIX + "port-input-multi.png");
		addImageFilePath(IMG_OUTPUT_PORT, 		IMG_PATH_PREFIX + "port-output-single.png");
		addImageFilePath(IMG_MULTI_OUTPUT_PORT, IMG_PATH_PREFIX + "port-output-multi.png");

		addImageFilePath(IMG_RELATION, IMG_PATH_PREFIX + "relation.png");
	}
}
