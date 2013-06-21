package org.ptolemy.graphiti.diagram.features.util;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;

public class OrientationSupport {

	private static Orientation[] orientations = {
		Orientation.ALIGNMENT_RIGHT,
		Orientation.ALIGNMENT_BOTTOM,
		Orientation.ALIGNMENT_LEFT,
		Orientation.ALIGNMENT_TOP
	};

	private static Orientation orientation(int pos) {
		return orientations[pos % orientations.length];
	}
	
	private static int pos(Orientation orientation) {
		for (int i = 0; i < orientations.length; i++) {
			if (orientation == orientations[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int distance(Orientation orientation1, Orientation orientation2) {
		int d = pos(orientation2) - pos(orientation1);
		return d < 0 ? d + orientations.length : d;
	}
	
	public static Orientation rotate(Orientation orientation, int n) {
		return orientation(pos(orientation) + n);
	}

	public static int direction(Orientation orientation) {
		switch (orientation) {
		case ALIGNMENT_RIGHT: 	return PositionConstants.EAST;
		case ALIGNMENT_BOTTOM: 	return PositionConstants.SOUTH;
		case ALIGNMENT_LEFT: 	return PositionConstants.WEST;
		case ALIGNMENT_TOP: 	return PositionConstants.NORTH;
		}
		return -1;
	}
}
