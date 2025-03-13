package org.Tema4;

public class SamsungGalaxyS6 extends Samsung {
    public SamsungGalaxyS6() {
        super("SamsungGalaxyS6", 90, "Black", "Plastic", generateIMEI());
    }

    private static String generateIMEI() {
        return "S6IMEI123456";
    }


}
