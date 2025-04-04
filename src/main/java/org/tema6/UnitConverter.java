package org.tema6;

public class UnitConverter {

    public static double convertToMillimeters(String valueWithUnit) {

        String value = "";
        String unit = "";

        for (int i = 0; i < valueWithUnit.length(); i++) {
            char c = valueWithUnit.charAt(i);
            if (Character.isDigit(c) || c == '.' || c == '-') {
                value += c;
            } else {
                unit = valueWithUnit.substring(i).trim();
                break;
            }
        }


        if (value.isEmpty()) {
            return 0;
        }

        double numericValue = Double.parseDouble(value.trim());

        switch (unit) {
            case "mm":
                return numericValue;
            case "cm":
                return numericValue * 10;
            case "dm":
                return numericValue * 100;
            case "m":
                return numericValue * 1000;
            case "km":
                return numericValue * 1000000;
            default:

                return 0;
        }


    }
}
