import org.Tema4.Samsung;

public class SamsungGalaxyS7 extends Samsung {
    public SamsungGalaxyS7() {
        super("SamsungGalaxyS7", 65, "White", "Metal", generateIMEI());
    }

    private static String generateIMEI() {
        return "S7IMEI654321";
    }
}
