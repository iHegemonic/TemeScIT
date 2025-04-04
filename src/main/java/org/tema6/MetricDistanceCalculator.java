package org.tema6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetricDistanceCalculator {

    public static String computeExpression(String expression, String outputUnit) {
        List<String> tokens = new ArrayList<>(Arrays.asList(expression.split(" ")));

        if (tokens.size() < 2) {
            return "Invalid expression format.";
        }

        double total = UnitConverter.convertToMillimeters(tokens.get(0) + " " + tokens.get(1));

        for (int i = 2; i < tokens.size(); i += 3) {
            if (i + 2 >= tokens.size()) {
                return "Invalid expression format.";
            }
            String operator = tokens.get(i);
            double nextValue = UnitConverter.convertToMillimeters(tokens.get(i + 1) + " " + tokens.get(i + 2));

            if (operator.equals("+")) {
                total += nextValue;
            } else if (operator.equals("-")) {
                total -= nextValue;
            } else {
                return "Invalid operator: " + operator;
            }
        }

        return convertToDesiredUnit(total, outputUnit);
    }

    private static String convertToDesiredUnit(double total, String outputUnit) {
        switch (outputUnit) {
            case "mm":
                return total + " mm";
            case "cm":
                return (total / 10) + " cm";
            case "dm":
                return (total / 100) + " m";
            case "m":
                return (total / 1000) + " m";
            case "km":
                return (total / 1000000) + " km";
            default:
               return "Unsupported output: " + outputUnit;
        }

    }

}


