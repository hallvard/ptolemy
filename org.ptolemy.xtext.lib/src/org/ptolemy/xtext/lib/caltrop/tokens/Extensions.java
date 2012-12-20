package org.ptolemy.xtext.lib.caltrop.tokens;

import ptolemy.kernel.util.IllegalActionException;

public class Extensions {

	public static ptolemy.data.Token operator_plus(ptolemy.data.ScalarToken n1, ptolemy.data.Token n2) throws IllegalActionException {
		return n1.add(n2);
	}
	
	public static ptolemy.data.Token operator_minus(ptolemy.data.ScalarToken n1, ptolemy.data.Token n2) throws IllegalActionException {
		return n1.subtract(n2);
	}
	
	public static ptolemy.data.Token operator_multiply(ptolemy.data.ScalarToken n1, ptolemy.data.Token n2) throws IllegalActionException {
		return n1.multiply(n2);
	}
	
	public static ptolemy.data.Token operator_divide(ptolemy.data.ScalarToken n1, ptolemy.data.Token n2) throws IllegalActionException {
		return n1.divide(n2);
	}
}
