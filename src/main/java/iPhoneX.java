import org.Tema4.Apple;

public class iPhoneX extends Apple {
    public iPhoneX() {
       super("iPhoneX", 9, "Silver", "Glass", generateIMEI());
    }

    private static String generateIMEI() {
        return "iPHXIMEI12232";
    }
}
