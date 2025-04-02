public class MetricDistanceCalculator {

    private static final double mmToMm = 1.0;
    private static final double cmToMm = 10.0;
    private static final double dmToMm = 100.0;
    private static final double mToMm = 1000;
    private static final double kmTomm = 1000000;

    public static double convertToMillimeters(String valueWithUnit) {

        String value = "";
        String unit = "";

        for (int i = 0; i < valueWithUnit.length(); i++) {
            char c = valueWithUnit.charAt(i);

            if (Character.isDigit(c) || c == '.' || c == '-') {
                value += c;
            } else {
                unit = valueWithUnit.substring(i);
                break;
            }
        }

        double numericValue = Double.parseDouble(value);

        switch (unit) {
            case "mm" :
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
                System.out.println("Unsupported unit, try again");
                break;
        }

return -1;
    }



    }


