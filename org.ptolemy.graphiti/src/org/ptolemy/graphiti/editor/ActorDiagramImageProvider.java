package org.ptolemy.graphiti.editor;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.ptolemy.ecore.actor.IOPortKind;

public class ActorDiagramImageProvider extends AbstractImageProvider {

	protected static final String IMG_ID_PREFIX = "org.ptolemy.graphiti.";

	// The image identifiers
	public static final String IMG_PORT = 				IMG_ID_PREFIX + "port";
	public static final String IMG_INPUT_PORT = 		IMG_ID_PREFIX + "input-port";
	public static final String IMG_MULTI_INPUT_PORT = 	IMG_ID_PREFIX + "multi-input-port";
	public static final String IMG_OUTPUT_PORT = 		IMG_ID_PREFIX + "output-port";
	public static final String IMG_MULTI_OUTPUT_PORT = 	IMG_ID_PREFIX + "multi-output-port";

	public static final String IMG_RELATION = 	IMG_ID_PREFIX + "relation";

	public static String getPortImageId(IOPortKind ioKind, Boolean multi) {
		return IMG_ID_PREFIX +
				(Boolean.TRUE.equals(multi) ? "multi-" : "") +
				(ioKind != null ? ioKind.getName().toLowerCase() + "-" : "") +
				"port";
	}
	
	private static String IMG_PATH_PREFIX = "resources/icons/";
	
	@Override
	protected void addAvailableImages() {
		addImageFilePath(IMG_PORT, 				IMG_PATH_PREFIX + "single_inout.gif");
		addImageFilePath(IMG_INPUT_PORT, 		IMG_PATH_PREFIX + "single_in.gif");
		addImageFilePath(IMG_OUTPUT_PORT, 		IMG_PATH_PREFIX + "single_out.gif");
		addImageFilePath(IMG_MULTI_INPUT_PORT, 	IMG_PATH_PREFIX + "multi_in.gif");
		addImageFilePath(IMG_MULTI_OUTPUT_PORT, IMG_PATH_PREFIX + "multi_out.gif");

		addImageFilePath(IMG_RELATION, IMG_PATH_PREFIX + "relation.gif");
	}
}
