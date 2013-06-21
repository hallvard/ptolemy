package org.ptolemy.xtext.tests.gui;

import ptolemy.data.expr.Parameter;

public class Util {

    public static String getStringParameterValue(Parameter parameter) {
        String s = parameter.getValueAsString();
        if (s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }

}
