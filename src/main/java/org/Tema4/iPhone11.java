package org.Tema4;

public class iPhone11 extends Apple{
    public iPhone11() {
        super("iPhone11", 11, "Green", "Aluminum", generateIMEI());
    }

    private static String generateIMEI() {
        return "iPH11IMEI12536";
    }
}
